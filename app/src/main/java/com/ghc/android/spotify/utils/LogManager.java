package com.ghc.android.spotify.utils;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by GHC_ on 7/18/2015.
 */
public class LogManager {
    private static final String TAG = LogManager.class.getSimpleName();

    private Application mApplication;

    public LogManager(Application application) {
        mApplication = application;
    }

    public void log(String message){
        Timber.tag(TAG);
        Timber.d(message);
    }
}
