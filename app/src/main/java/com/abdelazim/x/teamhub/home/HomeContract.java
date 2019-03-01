package com.abdelazim.x.teamhub.home;

import com.abdelazim.x.teamhub.repository.Account;

public interface HomeContract {

    interface HomeView {

        void displayAccount(Account account);

        void gotoAccountDetailsFragment(String accountName);
    }

    interface HomePresenterCallbacks {

        void accountFetched(Account account);
    }
}
