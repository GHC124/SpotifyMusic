package com.ghc.android.spotify.api;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;

import com.ghc.android.spotify.BuildConfig;
import com.ghc.android.spotify.R;
import com.ghc.android.spotify.user.UserManager;
import com.ghc.android.spotify.user.UserService;
import com.ghc.android.spotify.utils.LogManager;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
@Module
public class ApiModule {
    // 50 mb
    static final int DISK_CACHE_SIZE = 50 * 1024; // bytes

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Application application){
        OkHttpClient okHttpClient  = new OkHttpClient();
        okHttpClient.setConnectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(60 * 1000, TimeUnit.MILLISECONDS);

        // Install an HTTP cache in the application cache directory.
        File cacheDir = new File(application.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        okHttpClient.setCache(cache);

        return okHttpClient;
    }

    @Provides @Singleton
    RestAdapter provideRestAdapter(Application application, OkHttpClient okHttpClient){
        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setClient(new OkClient(okHttpClient))
                .setEndpoint(application.getString(R.string.app_end_point));

        String username = application.getString(R.string.app_auth_username);
        String password = application.getString(R.string.app_auth_password);

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            // concatenate username and password with colon for authentication
            final String credentials = username + ":" + password;

            builder.setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    // create Base64 encode string
                    String string = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", string);
                    request.addHeader("Accept", "application/json");
                }
            });
        }

        if (BuildConfig.DEBUG) {
            builder.setLogLevel(RestAdapter.LogLevel.FULL);
        }

        return builder.build();
    }

    @Provides @Singleton
    Picasso providePicasso(Application app, OkHttpClient client, final LogManager logManager) {
        return new Picasso.Builder(app)
                .downloader(new OkHttpDownloader(client))
                .listener(new Picasso.Listener() {
                    @Override public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
                        logManager.log("Failed to load image: " + uri);
                    }
                })
                .build();
    }

    @Provides @Singleton
    ApiService provideApiService(RestAdapter restAdapter){
        return restAdapter.create(ApiService.class);
    }

    @Provides @Singleton
    UserService provideUserService(RestAdapter restAdapter){
        return restAdapter.create(UserService.class);
    }

    @Provides @Singleton
    UserManager provideUserManager(UserService userService){
        return new UserManager(userService);
    }
}
