package com.abdelazim.x.teamhub.repository;

import com.abdelazim.x.teamhub.home.HomeContract;
import com.abdelazim.x.teamhub.home.model.HomeModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private Retrofit retrofit;
    private GithubApi githubApi;
    private HomeContract.HomeModelCallbacks homeModelCallbacks;

    public Repository(HomeContract.HomeModelCallbacks homeModelCallbacks) {

        this.homeModelCallbacks = homeModelCallbacks;

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        githubApi = retrofit.create(GithubApi.class);
    }

    public void getDataFromGitHub() {

        Call<Account> accountCall = githubApi.getAccount("mohammedibrahim01");

        accountCall.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {

                Account account = response.body();
                homeModelCallbacks.accountFetched(account);
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {

            }
        });
    }
}
