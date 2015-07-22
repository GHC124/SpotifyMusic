package com.ghc.android.spotify.api;

import com.ghc.android.spotify.data.model.User;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
public class ApiManager {
    private User mUser;
    private ApiService mApiService;

    public ApiManager(User user, ApiService apiService) {
        mUser = user;
        mApiService = apiService;
    }
}
