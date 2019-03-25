package com.abdelazim.x.teamhub.home.presenter;

import android.content.Context;

import com.abdelazim.x.teamhub.home.HomeContract;
import com.abdelazim.x.teamhub.home.model.HomeModel;
import com.abdelazim.x.teamhub.repository.Account;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter implements HomeContract.HomePresenterCallbacks {

    private HomeModel model;
    private HomeContract.HomeView view;
    private List<Account> accountList = new ArrayList<>();

    public HomePresenter(HomeContract.HomeView view, Context context) {
        this.view = view;
        model = new HomeModel(this, context);
    }

    public void getData() {

        List<String> namesList = new ArrayList<>();
        namesList.add("mohammedibrahim01");
        namesList.add("ahmedkhairyitpro");
        model.getAccountsFromRepository(namesList);
        view.displayProgressDialog();
    }

    public void accountListItemClicked(String accountName) {
        view.gotoAccountDetailsFragment(accountName);
    }


    @Override
    public void accountFetched(Account account) {

        accountList.add(account);
        if (accountList.size() == 2) {

            view.displayAccounts(accountList);
            view.hideProgressBar();
        } else if (accountList.size() > 2)
            view.displayAccount(account);
    }
}
