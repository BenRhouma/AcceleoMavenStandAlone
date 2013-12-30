package controllers;


import com.google.inject.Inject;
import config.Global;
import dto.Permission;
import play.api.mybatis.guice.paginator.Page;
import play.data.Form;
import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;
import service.PermissionService;
import dto.PermissionCriteriaBuilder;


/**
 * @author : Zied
 */
public class PermissionController extends Controller {

    @Inject
    static PermissionService permissionService = Global.InjectorFactory.getInjector().getInstance(PermissionService.class);

    static Form<Permission> permissionForm = Form.form(Permission.class);

	static Form<Permission> searchForm = Form.form(Permission.class);

    public static Result submit() {

        final Form<Permission> frm = play.data.Form.form(Permission.class).bindFromRequest();
        if(frm.get().getId() == null){
            F.Tuple<Boolean, String> permissionFromRequest = permissionService.createPermissionFromRequest(frm.get());
            if (permissionFromRequest._1 != null && !permissionFromRequest._1) {
                flash("error", permissionFromRequest._2);
                return rejectEditPage(frm.get().getId());
            }
        }else{

            F.Tuple<Boolean, String> insertoperation = permissionService.updatePermission(frm.get());
            if(insertoperation._1){
                flash("success" ,"permission updated");
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
        Form<Permission> frm;
        if (id == null) {
            frm = play.data.Form.form(Permission.class).bindFromRequest();
            return badRequest(views.html.permission.permission_edit.render("", frm));
        } else {
            Permission permission = permissionService.selectPermission(id);
            return badRequest(views.html.permission.permission_edit.render("", permissionForm.fill(permission)));
        }
    }

    public static Result editPage(Long id) {
        Form<Permission> frm;
        if (id == null) {
            frm = play.data.Form.form(Permission.class).bindFromRequest();
            return ok(views.html.permission.permission_edit.render("", frm));
        } else {
            Permission permission = permissionService.selectPermission(id);
            return ok(views.html.permission.permission_edit.render("", permissionForm.fill(permission)));
        }
    }

    public static Result addPermission() {
        Form<Permission> newForm = new Form<Permission>(Permission.class);
        return ok(views.html.permission.permission_edit.render("", newForm));
    }


    public static Result deletePermission(Long id) {
        permissionService = Global.InjectorFactory.getInjector().getInstance(PermissionService.class);
        F.Tuple<Boolean, String> deleteResult = permissionService.deletePermissionById(id);


        if(deleteResult ._1){
            flash("success" ,"permission deleted");
            return getListpage();
        }
        else{
            flash("error" , deleteResult._2);
            return rejectEditPage(id);
        }

    }


    public static Result getListpage() {
		searchForm = Form.form(Permission.class).bindFromRequest();
        final Permission permission = searchForm.get();
        final Page page = new Page<>(Permission.class, PermissionCriteriaBuilder.buildCriteria(permission));
        return ok(views.html.permission.permission_list.render("blank page", page, searchForm.fill(permission)));

    }


    public static Result list(int page) {
        permissionService = Global.InjectorFactory.getInjector().getInstance(PermissionService.class);
        return ok(views.html.permission.permission_list.render("blank page", permissionService.getPage(page), searchForm.fill(new Permission())));
     }

	public static Result filter() {

        searchForm = Form.form(Permission.class).bindFromRequest();
        final Permission permission = searchForm.get();
        final Page page = new Page<>(Permission.class, PermissionCriteriaBuilder.buildCriteria(permission));
        return ok(views.html.permission.permission_list.render("blank page", page, searchForm.fill(permission)));
    }


}
