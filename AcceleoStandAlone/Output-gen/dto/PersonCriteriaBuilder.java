package dto;

public class PersonCriteriaBuilder {

 

    public static PersonExample buildCriteria(Person person){
     
        final PersonExample personExample = new PersonExample();
 		PersonExample.Criteria criteria = personExample.createCriteria();
			if(person.emailValidated != null && !person.emailValidated.equals(""))
            	criteriaExample.andEmailValidatedEqualTo(person.emailValidated);
			
			if(person.lastName != null && !person.lastName.equals(""))
            	criteria.andLastNameLike(person.lastName);
			
			if(person.lastLogin != null && !person.lastLogin.equals(""))
            	criteriaExample.andLastLoginEqualTo(person.lastLogin);
			
			if(person.persId != null && !person.persId.equals(""))
            	criteriaExample.andPersIdEqualTo(person.persId);
			
			if(person.email != null && !person.email.equals(""))
            	criteria.andEmailLike(person.email);
			
			if(person.name != null && !person.name.equals(""))
            	criteria.andNameLike(person.name);
			
			if(person.active != null && !person.active.equals(""))
            	criteriaExample.andActiveEqualTo(person.active);
			
			if(person.login != null && !person.login.equals(""))
            	criteria.andLoginLike(person.login);
			
			if(person.firstName != null && !person.firstName.equals(""))
            	criteria.andFirstNameLike(person.firstName);
			
        
        return  personExample;
    }

}

