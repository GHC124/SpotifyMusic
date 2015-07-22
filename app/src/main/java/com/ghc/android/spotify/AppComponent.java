package com.ghc.android.spotify;

import com.ghc.android.spotify.api.ApiModule;
import com.ghc.android.spotify.ui.module.SplashActivityModule;
import com.ghc.android.spotify.ui.component.SplashActivityComponent;
import com.ghc.android.spotify.user.UserComponent;
import com.ghc.android.spotify.user.UserModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
@Singleton
@Component(
        modules = {
            AppModule.class,
            ApiModule.class
        }
)
public interface AppComponent {
    UserComponent plus(UserModule userModule);
    SplashActivityComponent plus(SplashActivityModule splashActivityModule);
}
