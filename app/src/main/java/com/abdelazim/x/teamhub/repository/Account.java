package com.abdelazim.x.teamhub.repository;

import com.google.gson.annotations.SerializedName;

public class Account {

    private String login;
    private String avatar_url;
    @SerializedName("public_repos")
    private String repos;

    public String getRepos() {
        return repos;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }
}
