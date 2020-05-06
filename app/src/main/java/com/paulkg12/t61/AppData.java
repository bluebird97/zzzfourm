package com.paulkg12.t61;

import android.support.annotation.Nullable;

import com.paulkg12.t61.dao.AuthUser;
import com.paulkg12.t61.mvp.model.User;
import com.thirtydegreesray.dataautoaccess.annotation.AutoAccess;

import java.util.Locale;

public enum AppData {
    INSTANCE;
    @AutoAccess(dataName = "appData_loggedUser") User loggedUser;
    @AutoAccess(dataName = "appData_authUser")
    AuthUser authUser;
    @AutoAccess(dataName = "appData_systemDefaultLocal")
    Locale systemDefaultLocal;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public AuthUser getAuthUser() {
        return authUser;
    }

    public void setAuthUser(AuthUser authUser) {
        this.authUser = authUser;
    }

    @Nullable
    public String getAccessToken() {
        return authUser == null ? null : authUser.getAccessToken();
    }

    public Locale getSystemDefaultLocal() {
        if(systemDefaultLocal == null){
            systemDefaultLocal = Locale.getDefault();
        }
        return systemDefaultLocal;
    }

}
