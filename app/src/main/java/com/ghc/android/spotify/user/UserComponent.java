package com.ghc.android.spotify.user;

import com.ghc.android.spotify.ui.component.MainActivityComponent;
import com.ghc.android.spotify.ui.module.MainActivityModule;

import dagger.Subcomponent;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {
    MainActivityComponent plus(MainActivityModule mainActivityModule);
}
