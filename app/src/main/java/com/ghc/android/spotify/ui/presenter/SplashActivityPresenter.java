package com.ghc.android.spotify.ui.presenter;

import android.os.Handler;

import com.ghc.android.spotify.SpotifyApplication;
import com.ghc.android.spotify.data.model.User;
import com.ghc.android.spotify.ui.activity.SplashActivity;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
public class SplashActivityPresenter {
    private SplashActivity mSplashActivity;

    public SplashActivityPresenter(SplashActivity splashActivity) {
        mSplashActivity = splashActivity;
    }

    public void loadData(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create user
                User user = new User();
                SpotifyApplication.get(mSplashActivity).createUserComponent(user);
                mSplashActivity.showMainActivity();
            }
        }, 1000);
    }
}
