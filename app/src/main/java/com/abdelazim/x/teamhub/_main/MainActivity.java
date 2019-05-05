package com.abdelazim.x.teamhub._main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.navigation.Navigation;

import com.abdelazim.x.teamhub.R;
import com.abdelazim.x.teamhub.repository.local.LocalDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String DEFAULT_SHARED_PREFERENCES = "default-sharedPreferences";
    private static final String KEY_DATA_FETCHED = "data-fetched-key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences(DEFAULT_SHARED_PREFERENCES, MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(KEY_DATA_FETCHED, false).apply();
        sharedPreferences.edit().clear().commit();
        LocalDatabase.getInstance(this).localAccountDao().deleteAll();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Navigation.findNavController(this, R.id.fragment).navigate(R.id.toSettingsFragment);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
