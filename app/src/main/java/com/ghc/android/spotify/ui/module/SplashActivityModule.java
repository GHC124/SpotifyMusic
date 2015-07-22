package com.ghc.android.spotify.ui.module;

import com.ghc.android.spotify.ui.activity.SplashActivity;
import com.ghc.android.spotify.ui.presenter.SplashActivityPresenter;
import com.ghc.android.spotify.utils.Validator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
@Module
public class SplashActivityModule {
    private SplashActivity mSplashActivity;

    public SplashActivityModule(SplashActivity splashActivity) {
        mSplashActivity = splashActivity;
    }

    @Provides @Singleton
    public SplashActivity provideSplashActivity(){
        return mSplashActivity;
    }

    @Provides @Singleton
    public SplashActivityPresenter provideSplashActivityPresenter(Validator validator){
        return new SplashActivityPresenter(mSplashActivity);
    }
}
