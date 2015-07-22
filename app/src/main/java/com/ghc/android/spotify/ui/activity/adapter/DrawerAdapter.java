package com.ghc.android.spotify.ui.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ghc.android.spotify.R;
import com.ghc.android.spotify.ui.model.DrawerItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by GHC_ on 7/18/2015.
 */
public class DrawerAdapter extends ArrayAdapter<DrawerItem> {
    private LayoutInflater mLayoutInflater;
    private Picasso mPicasso;
    private int mSelectedPosition = -1;

    public DrawerAdapter(Context context, List<DrawerItem> objects, Picasso picasso) {
        super(context, 0, objects);
        mLayoutInflater = LayoutInflater.from(context);
        mPicasso = picasso;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.drawer_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        DrawerItem drawerItem = getItem(position);

        viewHolder.tvTitle.setText(drawerItem.getTitle());
        if(drawerItem.getThumbnailId() > 0) {
            viewHolder.ivThumbnail.setImageResource(drawerItem.getThumbnailId());
        } else if(URLUtil.isNetworkUrl(drawerItem.getThumbnail())){
            mPicasso.load(drawerItem.getThumbnail())
                    .fit()
                    .into(viewHolder.ivThumbnail);
        }

        if(position == mSelectedPosition){
            viewHolder.llLayout.setBackgroundResource(R.drawable.background_oval_orange);
        } else {
            viewHolder.llLayout.setBackgroundResource(0);
        }

        return convertView;
    }

    public void resetSelectedPosition() {
        mSelectedPosition = -1;
    }

    public void setSelectedPosition(int selectedPosition) {
        mSelectedPosition = selectedPosition;
    }

    static class ViewHolder{

        @Bind(R.id.llLayout)
        View llLayout;

        @Bind(R.id.tvTitle)
        TextView tvTitle;

        @Bind(R.id.ivThumbnail)
        ImageView ivThumbnail;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
