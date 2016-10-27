package com.edu.gdqy.Controller.MainView.Subscriber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.edu.gdqy.Controller.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HXY on 2016/10/17.
 * 订阅ListView的adapter
 */

public class SubscriberListAdapter extends BaseAdapter {
    private List<String> liveNames,anchorName,liveState, startTime;
    private LayoutInflater inflater;

    public SubscriberListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        liveNames =new ArrayList<>();
        anchorName =new ArrayList<>();
        liveState =new ArrayList<>();
        startTime =new ArrayList<>();

        liveNames.add("直播装逼，欢迎大家观看");
        anchorName.add("逼神");
        liveState.add("正在播放");
        startTime.add("12月31，9:30");
    }

    @Override
    public int getCount() {
        return liveNames.size();
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
            convertView = inflater.inflate(R.layout.item_subscriber_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.mLiveName.setText(liveNames.get(position));
        holder.mAnchorName.setText(anchorName.get(position));
        holder.mLiveState.setText(liveState.get(position));
        holder.mStartTime.setText(startTime.get(position));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.Item_subscriberlist_LiveName)
        TextView mLiveName;
        @BindView(R.id.Item_subscriberlist_AnchorName)
        TextView mAnchorName;
        @BindView(R.id.Item_subscriberlist_LiveState)
        TextView mLiveState;
        @BindView(R.id.Item_subscriberlist_StartTime)
        TextView mStartTime;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
