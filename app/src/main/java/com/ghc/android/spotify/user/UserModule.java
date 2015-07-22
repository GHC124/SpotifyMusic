package com.ghc.android.spotify.user;

import com.ghc.android.spotify.api.ApiManager;
import com.ghc.android.spotify.api.ApiService;
import com.ghc.android.spotify.data.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
@Module
public class UserModule {
    private User mUser;

    public UserModule(User user) {
        mUser = user;
    }

    @Provides @UserScope
    public User provideUser(){
        return mUser;
    }

    @Provides @UserScope
    public ApiManager provideApiManager(ApiService apiService){
        return new ApiManager(mUser, apiService);
    }
}
