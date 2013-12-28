 package service;

import dto.LinkedAccount;
import play.api.mybatis.guice.paginator.Page;
import play.libs.F;

public interface LinkedAccountService {
    public Page getPage(int index );
    public Page getPage(int index , Page from );
    public void insertLinkedAccount(dto.LinkedAccount linkedaccount);
    public  dto.LinkedAccount selectLinkedAccount(Long linkedaccountId);
    public  F.Tuple<Boolean, String> createLinkedAccountFromRequest(dto.LinkedAccount linkedaccount);
    public F.Tuple<Boolean, String> updateLinkedAccount(LinkedAccount linkedaccounts);
    public F.Tuple<Boolean, String> deleteLinkedAccountById(Long id);
}

