package com.abdelazim.x.teamhub.account_details.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abdelazim.x.teamhub.R;
import com.abdelazim.x.teamhub.account_details.AccountContract;
import com.abdelazim.x.teamhub.account_details.presenter.AccountPresenter;
import com.abdelazim.x.teamhub.home.view.HomeFragment;
import com.abdelazim.x.teamhub.repository.Account;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountDetailsFragment extends Fragment implements AccountContract.AccountView {

    private AccountPresenter presenter;
    private TextView account_data_textView;




    public AccountDetailsFragment() {
       presenter = new AccountPresenter(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View view) {
        account_data_textView =view.findViewById(R.id.account_data_textView);
        String name = getArguments().getString(HomeFragment.KEY_ACCOUNT_NAME);
        data_display(name);
    }

    private void data_display(String name) {
        presenter.getAccountDetailsFromModel(name);
    }



    @Override
    public void displayDetails(Account account) {
        account_data_textView.setText("Login Name : "+account.getLogin() + "\n"+"\n");
        account_data_textView.append("Member ID : "+account.getId().toString()+"\n"+"\n");
        account_data_textView.append("Type : "+account.getType()+"\n"+"\n");
        account_data_textView.append("Company : "+account.getCompany()+ "\n"+"\n");
        account_data_textView.append("Location : "+account.getLocation()+"\n"+"\n");
        account_data_textView.append("Email : "+account.getEmail()+"\n"+"\n");
        account_data_textView.append("Pubic Gists : "+account.getPublic_gists()+"\n"+"\n");
        account_data_textView.append("Followers Number : "+account.getFollowers().toString()+"\n"+"\n");
        account_data_textView.append("Following Number : "+account.getFollowing().toString()+"\n"+"\n");
        account_data_textView.append("User Created at : "+account.getCreated_at()+"\n"+"\n");
        account_data_textView.append("User Updated at : "+account.getUpdated_at()+"\n"+"\n");
        account_data_textView.append("URL : "+ "\n"+account.getUrl()+"\n"+"\n");
        account_data_textView.append("HTML URL : "+"\n"+account.getHtml_url());

    }
}
