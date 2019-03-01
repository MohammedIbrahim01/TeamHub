package com.abdelazim.x.teamhub.account_details.model;

import com.abdelazim.x.teamhub.account_details.AccountContract;
import com.abdelazim.x.teamhub.repository.Account;
import com.abdelazim.x.teamhub.repository.Repository;

public class AccountModel implements AccountContract.AccountModelCallBacks {

    private Repository repository;
    private AccountContract.AccountPresenterCallBacks presenterCallBacks;

    public AccountModel (AccountContract.AccountPresenterCallBacks presenterCallBacks){

       // repository = new Repository();
        this.presenterCallBacks=presenterCallBacks;
    }

    public void getAccountDetailsFromRepository(){

        repository.getAccountDetailsFromGithub();
    }

    @Override
    public void detailsFetched(Account account) {
        presenterCallBacks.detailsFetched(account);
    }
}
