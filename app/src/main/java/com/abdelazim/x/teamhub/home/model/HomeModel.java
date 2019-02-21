package com.abdelazim.x.teamhub.home.model;

import com.abdelazim.x.teamhub.home.HomeContract;
import com.abdelazim.x.teamhub.repository.Account;
import com.abdelazim.x.teamhub.repository.Repository;

public class HomeModel implements HomeContract.HomeModelCallbacks {

    private Repository repository;
    HomeContract.HomePresenterCallbacks presenterCallbacks;

    public HomeModel(HomeContract.HomePresenterCallbacks presenterCallbacks) {
        repository = new Repository(this);
        this.presenterCallbacks = presenterCallbacks;
    }

    public void getDataFromRepository() {

        repository.getDataFromGitHub();
    }

    @Override
    public void accountFetched(Account account) {
        presenterCallbacks.accountFetched(account);
    }
}
