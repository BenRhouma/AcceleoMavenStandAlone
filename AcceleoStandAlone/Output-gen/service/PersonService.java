 package service;

import dto.Person;
import play.api.mybatis.guice.paginator.Page;
import play.libs.F;

public interface PersonService {
    public Page getPage(int index );
    public Page getPage(int index , Page from );
    public void insertPerson(dto.Person person);
    public  dto.Person selectPerson(Long personId);
    public  F.Tuple<Boolean, String> createPersonFromRequest(dto.Person person);
    public F.Tuple<Boolean, String> updatePerson(Person persons);
    public F.Tuple<Boolean, String> deletePersonById(Long id);
}

