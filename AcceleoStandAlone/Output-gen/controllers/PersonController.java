package controllers;


import com.google.inject.Inject;
import config.Global;
import dto.Person;
import mappers.PersonMapper;
import play.api.mybatis.guice.paginator.Page;
import play.data.Form;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;
import service.PersonService;


/**
 * @author : Zied
 */
public class PersonController extends Controller {

    @Inject
    static PersonService personService = Global.InjectorFactory.getInjector().getInstance(PersonService.class);

    static Form<Person> personForm = Form.form(Person.class);

    public static Result submit() {

        final Form<Person> frm = play.data.Form.form(Person.class).bindFromRequest();
        if(frm.get().getId() == null){
            F.Tuple<Boolean, String> personFromRequest = personService.createPersonFromRequest(frm.get());
            if (personFromRequest._1 != null && !personFromRequest._1) {
                flash("error", personFromRequest._2);
                return rejectEditPage(frm.get().getId());
            }
        }else{

            F.Tuple<Boolean, String> insertoperation = personService.updatePerson(frm.get());
            if(insertoperation._1){
                flash("success" ,"person updated");
            }
            else{
                flash("error" , insertoperation._2);
                frm.reject("login");
                return rejectEditPage(frm.get().getId());
            }
        }
        return getListpage();
    }

    public static Result rejectEditPage(Long id) {
        Form<Person> frm;
        if (id == null) {
            frm = play.data.Form.form(Person.class).bindFromRequest();
            return badRequest(views.html.person.person_edit.render("", frm));
        } else {
            Person person = personService.selectPerson(id);
            return badRequest(views.html.person.person_edit.render("", personForm.fill(person)));
        }
    }

    public static Result editPage(Long id) {
        Form<Person> frm;
        if (id == null) {
            frm = play.data.Form.form(Person.class).bindFromRequest();
            return ok(views.html.person.person_edit.render("", frm));
        } else {
            Person person = personService.selectPerson(id);
            return ok(views.html.person.person_edit.render("", personForm.fill(person)));
        }
    }

    public static Result addPerson() {
        Form<Person> newForm = new Form<Person>(Person.class);
        return ok(views.html.person.person_edit.render("", newForm));
    }


    public static Result deletePerson(Long id) {
        personService = Global.InjectorFactory.getInjector().getInstance(PersonService.class);
        F.Tuple<Boolean, String> deleteResult = personService.deletePersonById(id);


        if(deleteResult ._1){
            flash("success" ,"person deleted");
            return getListpage();
        }
        else{
            flash("error" , deleteResult._2);
            return rejectEditPage(id);
        }

    }


    public static Result getListpage() {
        Page page = new Page<>(Person.class);
        return ok(views.html.person.person_list.render("blank page", page));
    }


    public static Result list(int page) {
        personService = Global.InjectorFactory.getInjector().getInstance(PersonService.class);
        return ok(views.html.person.person_list.render("blank page", personService.getPage(page)));
    }


}
