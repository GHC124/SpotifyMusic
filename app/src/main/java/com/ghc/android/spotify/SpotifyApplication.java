package com.ghc.android.spotify;

import android.app.Application;
import android.content.Context;

import com.ghc.android.spotify.data.model.User;
import com.ghc.android.spotify.user.UserComponent;
import com.ghc.android.spotify.user.UserModule;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
public class SpotifyApplication extends Application {
    private AppComponent mAppComponent;
    private UserComponent mUserComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static SpotifyApplication get(Context context){
        return (SpotifyApplication) context.getApplicationContext();
    }

    public void createUserComponent(User user){
        mUserComponent = mAppComponent.plus(new UserModule(user));
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public UserComponent getUserComponent() {
        return mUserComponent;
    }

    public void releaseUserComponent(){
        mUserComponent = null;
    }
}
