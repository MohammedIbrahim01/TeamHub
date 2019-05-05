package com.abdelazim.x.teamhub.settings;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.abdelazim.x.teamhub.R;
import com.abdelazim.x.teamhub.utils.AppExecutors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private static final String DEFAULT_SHARED_PREFERENCES = "default-sharedPreferences";
    private static final String KEY_ACCOUNT_NAMES = "key-account-names";

    SharedPreferences sharedPreferences;
    private TextView accountsNamesTextView;
    private Button addAccountButton;
    private EditText accountNameEditText;

    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = getContext().getSharedPreferences(DEFAULT_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        initViews(view);
    }

    private void initViews(View view) {

        accountsNamesTextView = view.findViewById(R.id.account_names_textView);
        accountNameEditText = view.findViewById(R.id.account_name_editText);
        addAccountButton = view.findViewById(R.id.add_account_button);

        addAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String accountName = accountNameEditText.getText().toString();
                accountNameEditText.setText("");

                Set<String> stringSet = sharedPreferences.getStringSet(KEY_ACCOUNT_NAMES, new HashSet<String>());

                stringSet.add(accountName);

                sharedPreferences.edit().putStringSet(KEY_ACCOUNT_NAMES, stringSet).apply();

                updateAccountNames();
            }
        });

        updateAccountNames();
    }

    private void updateAccountNames() {

        Set<String> accountNames = sharedPreferences.getStringSet(KEY_ACCOUNT_NAMES, new HashSet<String>());

        for (String accountName :
                accountNames) {

            accountsNamesTextView.append("- " + accountName + "\n");
        }

    }
}
