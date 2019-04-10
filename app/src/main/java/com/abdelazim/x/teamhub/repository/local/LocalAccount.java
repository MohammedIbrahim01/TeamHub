package com.abdelazim.x.teamhub.repository.local;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "local-accounts")
public class LocalAccount {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String login;
    private String avatar_url;
    private String repos;

    public LocalAccount(int id, String login, String avatar_url, String repos) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
        this.repos = repos;
    }

    @Ignore
    public LocalAccount(String login, String avatar_url, String repos) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.repos = repos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getRepos() {
        return repos;
    }

    public void setRepos(String repos) {
        this.repos = repos;
    }
}
