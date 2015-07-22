package com.ghc.android.spotify.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.ghc.android.spotify.R;
import com.ghc.android.spotify.SpotifyApplication;
import com.ghc.android.spotify.ui.module.SplashActivityModule;
import com.ghc.android.spotify.ui.presenter.SplashActivityPresenter;

import javax.inject.Inject;


public class SplashActivity extends BaseActivity {

    @Inject
    SplashActivityPresenter mSplashActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplashActivityPresenter.loadData();
    }

    @Override
    void setupActivityComponent() {
        SpotifyApplication.get(this).getAppComponent().plus(new SplashActivityModule(this)).inject(this);
    }

    public void showMainActivity(){
        startActivity(new Intent(this, MainActivity.class));
    }
}
