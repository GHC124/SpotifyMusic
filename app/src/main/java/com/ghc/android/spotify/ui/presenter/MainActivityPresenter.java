package com.ghc.android.spotify.ui.presenter;

import com.ghc.android.spotify.api.ApiManager;
import com.ghc.android.spotify.ui.activity.MainActivity;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
public class MainActivityPresenter {
    private MainActivity mMainActivity;
    private ApiManager mApiManager;

    public MainActivityPresenter(MainActivity mainActivity, ApiManager apiManager) {
        mMainActivity = mainActivity;
        mApiManager = apiManager;
    }
}
