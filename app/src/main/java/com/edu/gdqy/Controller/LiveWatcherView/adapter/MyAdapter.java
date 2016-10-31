package com.edu.gdqy.Controller.LiveWatcherView.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by WDK on 2016/10/31.
 */

public class MyAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        for(int i=0; i < 3; i++){
            Log.d("dake", String.valueOf(i));
        }
        return null;
    }
}
