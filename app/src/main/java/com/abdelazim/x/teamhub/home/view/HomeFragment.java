package com.abdelazim.x.teamhub.home.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.abdelazim.x.teamhub.R;
import com.abdelazim.x.teamhub.home.HomeContract;
import com.abdelazim.x.teamhub.home.presenter.HomePresenter;
import com.abdelazim.x.teamhub.repository.Account;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener , HomeContract.HomeView {


    private HomePresenter presenter;

    private TextView displayDataTextView;
    private Button getDataButton;


    public HomeFragment() {

        presenter = new HomePresenter(this);
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

        initView(view);
    }

    private void initView(View view) {

        displayDataTextView = view.findViewById(R.id.display_data_textView);
        getDataButton = view.findViewById(R.id.get_Data_button);

        getDataButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.get_Data_button:
                presenter.getDataButtonClicked();
        }
    }

    @Override
    public void displayAccountData(Account account) {

        displayDataTextView.setText("login: " + account.getLogin());
        displayDataTextView.append("avatar_url: " + account.getAvatar_url());
    }
}
