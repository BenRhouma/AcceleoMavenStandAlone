 package service;

import dto.Permission;
import play.api.mybatis.guice.paginator.Page;
import play.libs.F;

public interface PermissionService {
    public Page getPage(int index );
    public Page getPage(int index , Page from );
    public void insertPermission(dto.Permission permission);
    public  dto.Permission selectPermission(Long permissionId);
    public  F.Tuple<Boolean, String> createPermissionFromRequest(dto.Permission permission);
    public F.Tuple<Boolean, String> updatePermission(Permission permissions);
    public F.Tuple<Boolean, String> deletePermissionById(Long id);
}

