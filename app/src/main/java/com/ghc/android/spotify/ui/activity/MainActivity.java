package com.ghc.android.spotify.ui.activity;

import android.app.ActionBar;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.ghc.android.spotify.R;
import com.ghc.android.spotify.SpotifyApplication;
import com.ghc.android.spotify.ui.activity.adapter.DrawerAdapter;
import com.ghc.android.spotify.ui.model.DrawerItem;
import com.ghc.android.spotify.ui.model.DrawerType;
import com.ghc.android.spotify.ui.module.MainActivityModule;
import com.ghc.android.spotify.ui.presenter.MainActivityPresenter;
import com.ghc.android.spotify.utils.LogManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by ChungPV1 on 7/22/2015.
 */
public class MainActivity extends BaseActivity {
    @Inject
    MainActivityPresenter mPresenter;
    @Inject
    LogManager mLogManager;
    @Inject
    Picasso mPicasso;

    @Bind(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.pbLoading)
    ProgressBar mPbLoading;

    @Bind(R.id.sliderMenu)
    ListView mDrawerList;

    private List<DrawerItem> mDrawerItems;
    private DrawerAdapter mDrawerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            actionBar.show();
            actionBar.setLogo(R.drawable.ic_menu_white_36dp);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        mDrawerList.setDivider(null);
        mDrawerList.setSelector(new BitmapDrawable());
        //mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));

        mDrawerItems = new ArrayList<>();
        mDrawerAdapter = new DrawerAdapter(this, mDrawerItems, mPicasso);
        mDrawerList.setAdapter(mDrawerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
                mDrawerLayout.closeDrawer(GravityCompat.START);
            } else {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    void setupActivityComponent() {
        SpotifyApplication.get(this).getUserComponent().plus(new MainActivityModule(this)).inject(this);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        showLoading(true);
        createDrawerItems();
    }

    @OnItemClick(R.id.sliderMenu)
    public void onDrawerClick(final int position){
        mDrawerLayout.closeDrawer(GravityCompat.START);
        mDrawerAdapter.setSelectedPosition(position);
        mDrawerAdapter.notifyDataSetChanged();

        DrawerItem drawerItem = mDrawerAdapter.getItem(position);
        createContent(drawerItem.getType());
    }



    public void showLoading(boolean show) {
        mPbLoading.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    private void createDrawerItems(){
        mDrawerItems.clear();
        mDrawerItems.add(new DrawerItem(DrawerType.LOGIN, getString(R.string.login), "", R.drawable.ic_account_circle_white_48dp));
        mDrawerItems.add(new DrawerItem(DrawerType.LIBRARY, getString(R.string.library), "", R.drawable.ic_archive_white_48dp));
        mDrawerItems.add(new DrawerItem(DrawerType.STORE, getString(R.string.store), "", R.drawable.ic_storage_white_48dp));
        mDrawerItems.add(new DrawerItem(DrawerType.SEARCH, getString(R.string.search), "", R.drawable.ic_search_white_48dp));
        mDrawerItems.add(new DrawerItem(DrawerType.SETTING, getString(R.string.setting), "", R.drawable.ic_settings_applications_white_48dp));
        mDrawerAdapter.notifyDataSetChanged();
    }

    private void createContent(int type){
        switch (type){
            case DrawerType.LOGIN:
                break;
            case DrawerType.LIBRARY:
                break;
            case DrawerType.STORE:
                break;
            case DrawerType.SEARCH:
                break;
            case DrawerType.SETTING:
                break;

        }
    }

    @Override
    public void finish() {
        super.finish();

        // Release user
        SpotifyApplication.get(this).releaseUserComponent();
    }
}
