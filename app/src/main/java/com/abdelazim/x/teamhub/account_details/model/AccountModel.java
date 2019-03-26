package com.abdelazim.x.teamhub.account_details.model;

import com.abdelazim.x.teamhub.account_details.AccountContract;
import com.abdelazim.x.teamhub.repository.Account;
import com.abdelazim.x.teamhub.repository.Repository;

public class AccountModel  {

    private Repository repository;
    private AccountContract.AccountPresenterCallBacks presenterCallBacks;

    public AccountModel (AccountContract.AccountPresenterCallBacks accountpresenterCallBacks){

        repository = new Repository(accountpresenterCallBacks);
        this.presenterCallBacks=accountpresenterCallBacks;
    }

    public void getAccountDetailsFromRepository(String name){

        repository.getAccountDetailsFromGithub(name);
    }


}
