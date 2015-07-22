package com.ghc.android.spotify.ui.component;

import com.ghc.android.spotify.ui.activity.SplashActivity;
import com.ghc.android.spotify.ui.module.SplashActivityModule;
import com.ghc.android.spotify.ui.presenter.SplashActivityPresenter;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
@Singleton
@Subcomponent(
        modules = {
                SplashActivityModule.class
        }
)
public interface SplashActivityComponent {
    SplashActivity inject(SplashActivity splashActivity);
    SplashActivityPresenter presenter();
}
