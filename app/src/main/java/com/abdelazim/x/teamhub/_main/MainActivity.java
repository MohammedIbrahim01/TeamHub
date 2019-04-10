package com.abdelazim.x.teamhub._main;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abdelazim.x.teamhub.R;
import com.abdelazim.x.teamhub.repository.local.LocalDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String DEFAULT_SHARED_PREFERENCES = "default-sharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences(DEFAULT_SHARED_PREFERENCES, MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
        LocalDatabase.getInstance(this).localAccountDao().deleteAll();
    }
}
