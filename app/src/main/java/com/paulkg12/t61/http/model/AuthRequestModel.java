package com.paulkg12.t61.http.model;

import com.google.gson.annotations.SerializedName;
import com.paulkg12.t61.BuildConfig;
import com.paulkg12.t61.AppConfig;

import java.util.Arrays;
import java.util.List;

public class AuthRequestModel {
    private List<String> scopes;
    private String note;
    private String noteUrl;
    @SerializedName("client_id")
    private String clientId;
    @SerializedName("client_secret")
    private String clientSecret;

    public static AuthRequestModel generate() {
        AuthRequestModel authRequestModel = new AuthRequestModel();
        authRequestModel.scopes = Arrays.asList("user", "repo", "gist", "notifications");
        authRequestModel.note = BuildConfig.APPLICATION_ID;
        authRequestModel.clientId = AppConfig.HUB_CLIENT_ID;
        authRequestModel.clientSecret = AppConfig.HUB_CLIENT_SECRET;
        authRequestModel.noteUrl = AppConfig.REDIRECT_URL;
        return authRequestModel;
    }
    public List<String> getScopes() {
        return scopes;
    }

    public String getNote() {
        return note;
    }

    public String getNoteUrl() {
        return noteUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
