package com.abdelazim.x.teamhub.repository.remote;

import com.abdelazim.x.teamhub.repository.Account;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubApi {

    @GET("{account}")
    Call<Account> getAccount(@Path("account") String accountName);
}
