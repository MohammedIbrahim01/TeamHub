package com.abdelazim.x.teamhub.home.model;

import com.abdelazim.x.teamhub.home.HomeContract;
import com.abdelazim.x.teamhub.repository.Account;
import com.abdelazim.x.teamhub.repository.Repository;

import java.util.List;

public class HomeModel {

    private Repository repository;
    HomeContract.HomePresenterCallbacks presenterCallbacks;

    public HomeModel(HomeContract.HomePresenterCallbacks presenterCallbacks) {
        repository = new Repository(presenterCallbacks);
        this.presenterCallbacks = presenterCallbacks;
    }

    public void getAccountsFromRepository(List<String> namesList) {

        repository.getAccountsFromGitHub(namesList);
    }
}
