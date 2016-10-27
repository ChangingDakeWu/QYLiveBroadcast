package com.edu.gdqy.Tool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.gdqy.Controller.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HXY on 2016/10/14.
 * 首页 热门和编程GridView的adapter
 */

public class VedioGridAdapter extends BaseAdapter {
    private List<String> titles;
    private List<String> urls;
    private LayoutInflater inflater;

    public VedioGridAdapter(Context context, List<String> titles, List<String> urls) {
        this.titles = titles;
        this.urls = urls;
        inflater = LayoutInflater.from(context);

        this.titles=new ArrayList<>();
        this.titles.add("我是帅B");
        this.titles.add("超级大帅逼");
        this.titles.add("我是老腊肉");
        this.titles.add("熏得乌漆麻黑的");
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_homepage_hot, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mHotTitle.setText(titles.get(position));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.item_hot_Thumbnail)
        ImageView mThumbnail;
        @BindView(R.id.item_hot_Title)
        TextView mHotTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
