package service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import dto.LinkedAccount;
import mappers.LinkedAccountMapper;
import play.api.mybatis.guice.paginator.Page;
import org.mybatis.guice.transactional.Transactional;
import play.Logger;
import play.api.mybatis.guice.AutoBind;
import play.libs.F;

import java.sql.SQLIntegrityConstraintViolationException;

@Singleton
@AutoBind(service = LinkedAccountService.class)
public class LinkedAccountServiceImpl implements LinkedAccountService {

    @Inject
    private LinkedAccountMapper linkedaccountMapper;


    @Override
    public void insertLinkedAccount(LinkedAccount linkedaccount) {
        linkedaccountMapper.insert(linkedaccount);
    }

    @Override
    public LinkedAccount selectLinkedAccount(Long linkedaccountId) {
        return linkedaccountMapper.selectByPrimaryKey(linkedaccountId);
    }


    @Override
    public Page getPage(int index) {
        return new Page(LinkedAccountMapper.class, index);
    }

    /**
     * this method is more optimized than the simple getPage, a less sql query is used here, because getPage, make a select count before returning result
     *
     * @param index : index of the page
     * @param from  : page used as start point of the seek operation
     * @return : linkedaccount mybatis result
     */
    @Override
    public Page getPage(int index, Page from) {
        return from.seekPage(index);
    }
    @Override
    public F.Tuple<Boolean, String> createLinkedAccountFromRequest(LinkedAccount linkedaccount) {
        try {
            linkedaccount.setName(linkedaccount.getFirstName() + " " + linkedaccount.getLastName());
            this.insertLinkedAccount(linkedaccount);
            return F.Tuple(true, "");
        } catch (Exception e) {
            Logger.error("Error during linkedaccount insertion", e);
            return F.Tuple(false, "could not save the linkedaccount please verify the use informations");
        }
    }

    @Override
    public F.Tuple<Boolean, String> updateLinkedAccount(LinkedAccount linkedaccount) {
        try {
            Logger.info("updating linkedaccount " + linkedaccount.getId());
            linkedaccountMapper.updateByPrimaryKeySelective(linkedaccount);
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
    public F.Tuple<Boolean, String> deleteLinkedAccountById(Long id) {
        try {
            Logger.info("updating linkedaccount " + id);
            linkedaccountMapper.deleteByPrimaryKey(id);
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

