package com.shindejayesharun.mvvmdiretroroomjavax.data.local.pref;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class AppPreference implements PrefHandler{
    @Inject
    SharedPreferences sharedPreferences;

    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";

    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";

    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";

    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";

    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";

    public AppPreference(SharedPreferences sharedPreferences) {
        this.sharedPreferences=sharedPreferences;
    }


    @Override
    public void setToken(String token) {
        sharedPreferences.edit().putString(PREF_KEY_ACCESS_TOKEN, token).apply();
    }

    @Override
    public String getToken() {
        return sharedPreferences.getString(PREF_KEY_ACCESS_TOKEN, null);
    }
}
