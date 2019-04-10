package com.abdelazim.x.teamhub.home.model;

import android.content.Context;

import com.abdelazim.x.teamhub.home.HomeContract;
import com.abdelazim.x.teamhub.repository.Account;
import com.abdelazim.x.teamhub.repository.Repository;

import java.util.List;

public class HomeModel {

    private Repository repository;
    HomeContract.HomePresenterCallbacks presenterCallbacks;

    public HomeModel(HomeContract.HomePresenterCallbacks presenterCallbacks, Context context) {
        repository = new Repository(presenterCallbacks, context);
        this.presenterCallbacks = presenterCallbacks;
    }

    public void getAccountsFromRepository(List<String> namesList) {

        repository.getAccountsFromGitHub(namesList);
    }

    public void getAccountsFromLocalRepository() {

        repository.getAccountsFromRoomDatabase();
    }
}
