package com.edu.gdqy.Controller.MainView.HomePage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by HXY on 2016/10/21.
 * mene预告ListView的Adapter
 */

public class HeraldListAdapter extends BaseAdapter {
    private List<String> introduction;
    private List<String> anchorName;
    private List<String> starTime;

    public HeraldListAdapter(Context context,List<String> introduction,
                             List<String> anchorName, List<String> starTime) {
        this.introduction = introduction;
        this.anchorName = anchorName;
        this.starTime = starTime;
    }

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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
