package com.ghc.android.spotify.ui.component;

import com.ghc.android.spotify.ui.ActivityScope;
import com.ghc.android.spotify.ui.activity.MainActivity;
import com.ghc.android.spotify.ui.module.MainActivityModule;
import com.ghc.android.spotify.ui.presenter.MainActivityPresenter;

import dagger.Subcomponent;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
@ActivityScope
@Subcomponent(
        modules = {
                MainActivityModule.class
        }
)
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);
    MainActivityPresenter presenter();
}
