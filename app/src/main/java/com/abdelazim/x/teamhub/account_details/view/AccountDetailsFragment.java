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
import com.abdelazim.x.teamhub.account_details.presenter.AccountPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountDetailsFragment extends Fragment {

    private AccountPresenter presenter;
    private TextView account_data_textView;


    public AccountDetailsFragment() {
       presenter = new AccountPresenter();
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
        data_display();
    }

    private void data_display() {
        presenter.dataReceived();
    }
}
