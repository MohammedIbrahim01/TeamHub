package com.abdelazim.x.teamhub.home.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.abdelazim.x.teamhub.home.HomeContract;
import com.abdelazim.x.teamhub.home.model.HomeModel;
import com.abdelazim.x.teamhub.repository.Account;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePresenter implements HomeContract.HomePresenterCallbacks {


    private static final String TAG = "GGG";
    private static final String DEFAULT_SHARED_PREFERENCES = "default-sharedPreferences";
    private static final String KEY_DATA_FETCHED = "data-fetched-key";
    private static final String KEY_ACCOUNT_NAMES = "key-account-names";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private HomeModel model;
    private HomeContract.HomeView view;
    private List<Account> accountList = new ArrayList<>();
    List<String> namesList = new ArrayList<>();

    public HomePresenter(HomeContract.HomeView view, Context context) {
        this.view = view;
        model = new HomeModel(this, context);
        sharedPreferences = context.getSharedPreferences(DEFAULT_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void getData() {

        boolean isDataFetched = sharedPreferences.getBoolean(KEY_DATA_FETCHED, false);

        Set<String> namesSet = sharedPreferences.getStringSet(KEY_ACCOUNT_NAMES, new HashSet<String>());
        namesList = new ArrayList<>(namesSet);

        if (namesList.size() == 0)
            return;

        if (!isDataFetched) {

            model.getAccountsFromRepository(namesList);
            view.displayProgressDialog();
            editor.putBoolean(KEY_DATA_FETCHED, true);
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
