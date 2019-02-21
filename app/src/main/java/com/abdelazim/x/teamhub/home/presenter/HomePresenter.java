package com.abdelazim.x.teamhub.home.presenter;

import com.abdelazim.x.teamhub.home.HomeContract;
import com.abdelazim.x.teamhub.home.model.HomeModel;
import com.abdelazim.x.teamhub.repository.Account;

public class HomePresenter implements HomeContract.HomePresenterCallbacks {

    private HomeModel model;
    private HomeContract.HomeView view;

    public HomePresenter(HomeContract.HomeView view) {
        this.view = view;
        model = new HomeModel(this);
    }

    public void getDataButtonClicked() {

        model.getDataFromRepository();
    }

    @Override
    public void accountFetched(Account account) {
        view.displayAccountData(account);
    }
}
