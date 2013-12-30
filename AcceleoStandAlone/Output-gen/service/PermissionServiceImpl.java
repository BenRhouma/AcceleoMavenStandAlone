package service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import dto.Permission;
import mappers.PermissionMapper;
import play.api.mybatis.guice.paginator.Page;
import play.Logger;
import play.api.mybatis.AutoBind;
import play.libs.F;

import java.sql.SQLIntegrityConstraintViolationException;

@Singleton
@AutoBind(service = PermissionService.class)
public class PermissionServiceImpl implements PermissionService {

    @Inject
    private PermissionMapper permissionMapper;


    @Override
    public void insertPermission(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    public Permission selectPermission(Long permissionId) {
        return permissionMapper.selectByPrimaryKey(permissionId);
    }


    @Override
    public Page getPage(int index) {
        return new Page(Permission.class, index);
    }

    /**
     * this method is more optimized than the simple getPage, a less sql query is used here, because getPage, make a select count before returning result
     *
     * @param index : index of the page
     * @param from  : page used as start point of the seek operation
     * @return : permission mybatis result
     */
    @Override
    public Page getPage(int index, Page from) {
        return from.seekPage(index);
    }
    @Override
    public F.Tuple<Boolean, String> createPermissionFromRequest(Permission permission) {
        try {
            this.insertPermission(permission);
            return F.Tuple(true, "");
        } catch (Exception e) {
            Logger.error("Error during permission insertion", e);
            return F.Tuple(false, "could not save the permission please verify the use informations");
        }
    }

    @Override
    public F.Tuple<Boolean, String> updatePermission(Permission permission) {
        try {
            Logger.info("updating permission " + permission.getId());
            permissionMapper.updateByPrimaryKeySelective(permission);
            return F.Tuple(true, null);
        } catch (Exception e) {
            Logger.error("Error during person update", e);
            String message = e.getMessage();
            if (e instanceof SQLIntegrityConstraintViolationException) {
                SQLIntegrityConstraintViolationException d = (MySQLIntegrityConstraintViolationException) e.getCause();
                message = d.getMessage();
            }
            return F.Tuple(false, message);
        }
    }

    @Override
    public F.Tuple<Boolean, String> deletePermissionById(Long id) {
        try {
            Logger.info("updating permission " + id);
            permissionMapper.deleteByPrimaryKey(id);
            return F.Tuple(true, null);
        } catch (Exception e) {
            Logger.error("Error during person update", e);
            String message = e.getMessage();
            if (e instanceof SQLIntegrityConstraintViolationException) {
                SQLIntegrityConstraintViolationException d = (MySQLIntegrityConstraintViolationException) e.getCause();
                message = d.getMessage();
            }
            return F.Tuple(false, message);
        }
    }


}

