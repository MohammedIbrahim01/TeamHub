package com.abdelazim.x.teamhub.home.view;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdelazim.x.teamhub.R;
import com.abdelazim.x.teamhub.home.HomeContract;
import com.abdelazim.x.teamhub.home.presenter.HomePresenter;
import com.abdelazim.x.teamhub.repository.Account;

import java.util.List;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeContract.HomeView, AccountListAdapter.OnListItemClickListener {

    public static final String KEY_ACCOUNT_NAME = "key-account-name";

    private HomePresenter presenter;
    private RecyclerView accountListRecyclerView;
    private AccountListAdapter accountListAdapter;
    private ProgressDialog progressDialog;


    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new HomePresenter(this, getContext());
        initView(view);
        presenter.getData();
    }

    private void initView(View view) {

        progressDialog = new ProgressDialog(getContext());
        accountListRecyclerView = view.findViewById(R.id.account_list_recyclerViews);
        accountListAdapter = new AccountListAdapter(this);

        accountListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        accountListRecyclerView.setHasFixedSize(true);
        accountListRecyclerView.setAdapter(accountListAdapter);
    }

    @Override
    public void displayAccount(Account account) {

        accountListAdapter.addAccount(account);
    }

    @Override
    public void gotoAccountDetailsFragment(String accountName) {

        NavController navController = Navigation.findNavController(accountListRecyclerView);

        Bundle args = new Bundle();
        args.putString(KEY_ACCOUNT_NAME, accountName);

        navController.navigate(R.id.toAccountDetailsFragment, args);
    }

    @Override
    public void displayProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void hideProgressBar() {
        progressDialog.cancel();
    }

    @Override
    public void displayAccounts(List<Account> accountList) {
        accountListAdapter.setAccountList(accountList);
    }

    @Override
    public void onListItemClick(String accountName) {

        presenter.accountListItemClicked(accountName);
    }
}
