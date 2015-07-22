package com.ghc.android.spotify.ui.module;

import com.ghc.android.spotify.api.ApiManager;
import com.ghc.android.spotify.ui.ActivityScope;
import com.ghc.android.spotify.ui.activity.MainActivity;
import com.ghc.android.spotify.ui.presenter.MainActivityPresenter;
import com.ghc.android.spotify.utils.Validator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
@Module
public class MainActivityModule {
    private MainActivity mMainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Provides @ActivityScope
    public MainActivity provideMainActivity(){
        return mMainActivity;
    }

    @Provides @ActivityScope
    public MainActivityPresenter provideMainActivityPresenter(Validator validator, ApiManager apiManager){
        return new MainActivityPresenter(mMainActivity, apiManager);
    }
}
