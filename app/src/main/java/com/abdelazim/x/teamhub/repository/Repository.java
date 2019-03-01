package com.abdelazim.x.teamhub.repository;

import com.abdelazim.x.teamhub.home.HomeContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private Retrofit retrofit;
    private GithubApi githubApi;
    HomeContract.HomePresenterCallbacks homePresenterCallbacks;

    public Repository(HomeContract.HomePresenterCallbacks homePresenterCallbacks) {

        this.homePresenterCallbacks = homePresenterCallbacks;

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/users/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        githubApi = retrofit.create(GithubApi.class);
    }

    public void getAccountsFromGitHub(List<String> namesList) {

        for (String name : namesList) {

            Call<Account> accountCall = githubApi.getAccount(name);

            accountCall.enqueue(new Callback<Account>() {
                @Override
                public void onResponse(Call<Account> call, Response<Account> response) {

                    Account account = response.body();
                    homePresenterCallbacks.accountFetched(account);
                }

                @Override
                public void onFailure(Call<Account> call, Throwable t) {

                }
            });
        }
    }
}
