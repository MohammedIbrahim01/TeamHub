package com.abdelazim.x.teamhub.home;

import com.abdelazim.x.teamhub.repository.Account;

import java.util.List;

public interface HomeContract {

    interface HomeView {

        void displayAccount(Account account);

        void gotoAccountDetailsFragment(String accountName);

        void displayProgressDialog();

        void hideProgressBar();

        void displayAccounts(List<Account> accountList);
    }

    interface HomePresenterCallbacks {

        void accountFetched(Account account);
    }
}
