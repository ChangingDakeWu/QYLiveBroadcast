package com.edu.gdqy.Controller.AnchorAudienceView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HXY on 2016/10/31.
 */

public class A extends BaseAdapter{

    private List<String> mList;
    private Context mContext;

    public A(List<String> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder viewHolder = null;
        if(convertView == null){

        }
        return null;
    }

    class ViewHolder{
        private TextView mTextView;
        private ImageView mImageView;
    }
}
