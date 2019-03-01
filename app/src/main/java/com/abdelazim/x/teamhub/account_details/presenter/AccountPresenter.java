package com.abdelazim.x.teamhub.account_details.presenter;

import com.abdelazim.x.teamhub.account_details.AccountContract;
import com.abdelazim.x.teamhub.account_details.model.AccountModel;
import com.abdelazim.x.teamhub.repository.Account;

public class AccountPresenter implements AccountContract.AccountPresenterCallBacks {

    private AccountModel model;

    public AccountPresenter (){

        model = new AccountModel(this);
    }



    public void dataReceived() {
        model.getAccountDetailsFromRepository();
    }

    @Override
    public void detailsFetched(Account account) {

    }
}
