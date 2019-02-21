package com.abdelazim.x.teamhub.home;

import com.abdelazim.x.teamhub.repository.Account;

public interface HomeContract {

    interface HomeView {

        void displayAccountData(Account account);
    }

    interface HomeModelCallbacks {

        void accountFetched(Account account);
    }

    interface HomePresenterCallbacks {

        void accountFetched(Account account);
    }
}
