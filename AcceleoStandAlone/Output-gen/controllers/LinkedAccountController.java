package controllers;


import com.google.inject.Inject;
import config.Global;
import dto.LinkedAccount;
import mappers.LinkedAccountMapper;
import play.api.mybatis.guice.paginator.Page;
import play.data.Form;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;
import service.LinkedAccountService;


/**
 * @author : Zied
 */
public class LinkedAccountController extends Controller {

    @Inject
    static LinkedAccountService linkedaccountService = Global.InjectorFactory.getInjector().getInstance(LinkedAccountService.class);

    static Form<LinkedAccount> linkedaccountForm = Form.form(LinkedAccount.class);

    public static Result submit() {

        final Form<LinkedAccount> frm = play.data.Form.form(LinkedAccount.class).bindFromRequest();
        if(frm.get().getId() == null){
            F.Tuple<Boolean, String> linkedaccountFromRequest = linkedaccountService.createLinkedAccountFromRequest(frm.get());
            if (linkedaccountFromRequest._1 != null && !linkedaccountFromRequest._1) {
                flash("error", linkedaccountFromRequest._2);
                return rejectEditPage(frm.get().getId());
            }
        }else{

            F.Tuple<Boolean, String> insertoperation = linkedaccountService.updateLinkedAccount(frm.get());
            if(insertoperation._1){
                flash("success" ,"linkedaccount updated");
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
        Form<LinkedAccount> frm;
        if (id == null) {
            frm = play.data.Form.form(LinkedAccount.class).bindFromRequest();
            return badRequest(views.html.linkedaccount.linkedaccount_edit.render("", frm));
        } else {
            LinkedAccount linkedaccount = linkedaccountService.selectLinkedAccount(id);
            return badRequest(views.html.linkedaccount.linkedaccount_edit.render("", linkedaccountForm.fill(linkedaccount)));
        }
    }

    public static Result editPage(Long id) {
        Form<LinkedAccount> frm;
        if (id == null) {
            frm = play.data.Form.form(LinkedAccount.class).bindFromRequest();
            return ok(views.html.linkedaccount.linkedaccount_edit.render("", frm));
        } else {
            LinkedAccount linkedaccount = linkedaccountService.selectLinkedAccount(id);
            return ok(views.html.linkedaccount.linkedaccount_edit.render("", linkedaccountForm.fill(linkedaccount)));
        }
    }

    public static Result addLinkedAccount() {
        Form<LinkedAccount> newForm = new Form<LinkedAccount>(LinkedAccount.class);
        return ok(views.html.linkedaccount.linkedaccount_edit.render("", newForm));
    }


    public static Result deleteLinkedAccount(Long id) {
        linkedaccountService = Global.InjectorFactory.getInjector().getInstance(LinkedAccountService.class);
        F.Tuple<Boolean, String> deleteResult = linkedaccountService.deleteLinkedAccountById(id);


        if(deleteResult ._1){
            flash("success" ,"linkedaccount deleted");
            return getListpage();
        }
        else{
            flash("error" , deleteResult._2);
            return rejectEditPage(id);
        }

    }


    public static Result getListpage() {
        Page page = new Page<>(LinkedAccount.class);
        return ok(views.html.linkedaccount.linkedaccount_list.render("blank page", page));
    }


    public static Result list(int page) {
        linkedaccountService = Global.InjectorFactory.getInjector().getInstance(LinkedAccountService.class);
        return ok(views.html.linkedaccount.linkedaccount_list.render("blank page", linkedaccountService.getPage(page)));
    }


}
