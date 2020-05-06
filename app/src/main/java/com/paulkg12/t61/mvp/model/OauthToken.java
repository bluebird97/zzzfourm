package com.paulkg12.t61.mvp.model;

import com.google.gson.annotations.SerializedName;

public class OauthToken {

    @SerializedName("access_token")
    private String accessToken;

    private String scope;

    public OauthToken() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
