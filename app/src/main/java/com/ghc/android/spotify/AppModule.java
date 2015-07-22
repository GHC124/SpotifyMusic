package com.ghc.android.spotify;

import android.app.Application;

import com.ghc.android.spotify.utils.LogManager;
import com.ghc.android.spotify.utils.Validator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides @Singleton
    public Application provideApplication(){
        return mApplication;
    }

    @Provides @Singleton
    public Validator provideValidator(){
        return new Validator();
    }

    @Provides @Singleton
    public LogManager provideLogManager(){
        return new LogManager(mApplication);
    }
}
