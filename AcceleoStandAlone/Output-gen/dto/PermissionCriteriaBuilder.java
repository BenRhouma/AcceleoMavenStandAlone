package dto;

public class PermissionCriteriaBuilder {

 

    public static PermissionExample buildCriteria(Permission permission){
     
        final PermissionExample permissionExample = new PermissionExample();
			if(permission.id != null && !permission.id.equals(""))
            	permissionExample.createCriteria().andIdEqualTo(permission.id);
			
			if(permission.value != null && !permission.value.equals(""))
            	permissionExample.createCriteria().andValueLike(permission.value);
			
			if(permission.idUser != null && !permission.idUser.equals(""))
            	permissionExample.createCriteria().andIdUserEqualTo(permission.idUser);
			
        
        return  permissionExample;
    }

}

