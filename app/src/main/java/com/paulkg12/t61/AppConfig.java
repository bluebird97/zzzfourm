package com.paulkg12.t61;

import com.paulkg12.t61.BuildConfig;
import com.paulkg12.t61.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class AppConfig {
    public static final String HUB_CLIENT_ID = BuildConfig.HUB_CLIENT_ID;
    public static final String HUB_CLIENT_SECRET = BuildConfig.HUB_CLIENT_SECRET;
    public static final String USER_NAME = BuildConfig.USER_NAME;
    public static final String USER_PASS = BuildConfig.USER_PASS;
    public static final String REDIRECT_URL = "https://github.com/ThirtyDegreesRay/OpenHub/CallBack";
    public final static String GITHUB_BASE_URL = "https://github.com/";
    public final static String GITHUB_API_BASE_URL = "https://api.github.com/";
    public final static String GITHUB_CONTENT_BASE_URL = "https://raw.githubusercontent.com/";
    public final static String DB_NAME = "TTHub.db";
    public final static int IMAGE_MAX_CACHE_SIZE = 32 * 1024 * 1024;
    public final static int HTTP_TIME_OUT = 32 * 1000;
    public final static int HTTP_MAX_CACHE_SIZE = 32 * 1024 * 1024;
    public final static int CACHE_MAX_AGE = 4 * 7 * 24 * 60 * 60;
    public final static String OAUTH2_URL = GITHUB_BASE_URL + "login/oauth/authorize";
    public final static String OAUTH2_SCOPE = "user,repo,gist,notifications";


    public final static boolean isCommonPageUrl(String url){
        if(StringUtils.isBlank(url)){
            return false;
        }
        for(String commonUrl : COMMON_PAGE_URL_LIST){
            if(url.contains(commonUrl)){
                return true;
            }
        }
        return false;
    }
    public final static List<String> COMMON_PAGE_URL_LIST = Arrays.asList(
            "https://github.com/trending"
    );

}
