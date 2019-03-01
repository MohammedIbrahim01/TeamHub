package com.abdelazim.x.teamhub.home.presenter;

import com.abdelazim.x.teamhub.home.HomeContract;
import com.abdelazim.x.teamhub.home.model.HomeModel;
import com.abdelazim.x.teamhub.repository.Account;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter implements HomeContract.HomePresenterCallbacks {

    private HomeModel model;
    private HomeContract.HomeView view;

    public HomePresenter(HomeContract.HomeView view) {
        this.view = view;
        model = new HomeModel(this);
    }

    public void getData() {

        List<String> namesList = new ArrayList<>();
        namesList.add("mohammedibrahim01");
        namesList.add("ahmedkhairyitpro");
        model.getAccountsFromRepository(namesList);
    }

    public void accountListItemClicked(String accountName) {
        view.gotoAccountDetailsFragment(accountName);
    }


    @Override
    public void accountFetched(Account account) {
        view.displayAccount(account);
    }
}
