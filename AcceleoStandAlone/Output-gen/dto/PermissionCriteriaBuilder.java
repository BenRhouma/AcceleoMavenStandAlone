package dto;

public class PermissionCriteriaBuilder {

 

    public static PermissionExample buildCriteria(Permission permission){
     
        final PermissionExample permissionExample = new PermissionExample();
 		PermissionExample.Criteria criteria = permissionExample.createCriteria();
			if(permission.id != null && !permission.id.equals(""))
            	criteriaExample.andIdEqualTo(permission.id);
			
			if(permission.value != null && !permission.value.equals(""))
            	criteria.andValueLike(permission.value);
			
			if(permission.idUser != null && !permission.idUser.equals(""))
            	criteriaExample.andIdUserEqualTo(permission.idUser);
			
        
        return  permissionExample;
    }

}

