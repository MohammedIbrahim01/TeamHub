package com.abdelazim.x.teamhub.repository;

public class Account {

    private String login;
    private String avatar_url;

    private String type;
    private String company;
    private String followers;
    private String id;
    private String location;
    private String email;
    private String public_gists;
    private String following;
    private String created_at;
    private String updated_at;
    private String url;
    private String html_url;

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getPublic_gists() {
        return public_gists;
    }

    public String getFollowing() {
        return following;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getUrl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getType() {
        return type;
    }

    public String getCompany() {
        return company;
    }

    public String getFollowers() {
        return followers;
    }




    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }
}
