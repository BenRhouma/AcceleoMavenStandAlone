package service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import dto.Person;
import mappers.PersonMapper;
import play.api.mybatis.guice.paginator.Page;
import play.Logger;
import play.api.mybatis.AutoBind;
import play.libs.F;

import java.sql.SQLIntegrityConstraintViolationException;

@Singleton
@AutoBind(service = PersonService.class)
public class PersonServiceImpl implements PersonService {

    @Inject
    private PersonMapper personMapper;


    @Override
    public void insertPerson(Person person) {
        personMapper.insert(person);
    }

    @Override
    public Person selectPerson(Long personId) {
        return personMapper.selectByPrimaryKey(personId);
    }


    @Override
    public Page getPage(int index) {
        return new Page(Person.class, index);
    }

    /**
     * this method is more optimized than the simple getPage, a less sql query is used here, because getPage, make a select count before returning result
     *
     * @param index : index of the page
     * @param from  : page used as start point of the seek operation
     * @return : person mybatis result
     */
    @Override
    public Page getPage(int index, Page from) {
        return from.seekPage(index);
    }
    @Override
    public F.Tuple<Boolean, String> createPersonFromRequest(Person person) {
        try {
            this.insertPerson(person);
            return F.Tuple(true, "");
        } catch (Exception e) {
            Logger.error("Error during person insertion", e);
            return F.Tuple(false, "could not save the person please verify the use informations");
        }
    }

    @Override
    public F.Tuple<Boolean, String> updatePerson(Person person) {
        try {
            Logger.info("updating person " + person.getId());
            personMapper.updateByPrimaryKeySelective(person);
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
    public F.Tuple<Boolean, String> deletePersonById(Long id) {
        try {
            Logger.info("updating person " + id);
            personMapper.deleteByPrimaryKey(id);
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

