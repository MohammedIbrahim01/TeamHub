package com.abdelazim.x.teamhub.home.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.abdelazim.x.teamhub.home.HomeContract;
import com.abdelazim.x.teamhub.home.model.HomeModel;
import com.abdelazim.x.teamhub.repository.Account;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter implements HomeContract.HomePresenterCallbacks {

    private static final String TAG = "GGG";
    private static final String DEFAULT_SHARED_PREFERENCES = "default-sharedPreferences";
    private static final String DATA_FETCHED_KEY = "data-fetched-key";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private HomeModel model;
    private HomeContract.HomeView view;
    private List<Account> accountList = new ArrayList<>();

    public HomePresenter(HomeContract.HomeView view, Context context) {
        this.view = view;
        model = new HomeModel(this, context);
        sharedPreferences = context.getSharedPreferences(DEFAULT_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void getData() {

        boolean isDataFetched = sharedPreferences.getBoolean(DATA_FETCHED_KEY, false);

        if (!isDataFetched) {

            List<String> namesList = new ArrayList<>();
            namesList.add("mohammedibrahim01");
            namesList.add("ahmedkhairyitpro");
            model.getAccountsFromRepository(namesList);
            view.displayProgressDialog();
            editor.putBoolean(DATA_FETCHED_KEY, true);
            editor.apply();
            Log.i(TAG, "getData: from api");
        } else {

            model.getAccountsFromLocalRepository();
            Log.i(TAG, "getData: from room");
        }
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
