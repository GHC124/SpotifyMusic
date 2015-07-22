package com.ghc.android.spotify.ui.model;

/**
 * Created by GHC_ on 7/18/2015.
 */
public class DrawerItem {
    private int mType;
    private String mTitle;
    private String mThumbnail;
    private int mThumbnailId;

    public DrawerItem(int type, String title, String thumbnail, int thumbnailId) {
        mType = type;
        mTitle = title;
        mThumbnail = thumbnail;
        mThumbnailId = thumbnailId;
    }

    public int getType() {
        return mType;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public int getThumbnailId() {
        return mThumbnailId;
    }
}
