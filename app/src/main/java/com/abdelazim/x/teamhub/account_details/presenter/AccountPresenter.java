package com.abdelazim.x.teamhub.account_details.presenter;

import com.abdelazim.x.teamhub.account_details.AccountContract;
import com.abdelazim.x.teamhub.account_details.model.AccountModel;
import com.abdelazim.x.teamhub.repository.Account;

public class AccountPresenter implements AccountContract.AccountPresenterCallBacks {

    private AccountModel model;
    AccountContract.AccountView accountView;

    public AccountPresenter (AccountContract.AccountView accountView){
        this.accountView=accountView;
        model = new AccountModel(this);
    }



    public void getAccountDetailsFromModel(String name) {
        model.getAccountDetailsFromRepository(name);
    }

    @Override
    public void detailsFetched(Account account) {
        accountView.displayDetails(account);
    }
}
