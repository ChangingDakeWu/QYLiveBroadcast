package com.edu.gdqy.Controller.MainView.Subscriber;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.edu.gdqy.Controller.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HXY on 2016/10/17.
 * 订阅的界面
 */

public class SubscriberFragment extends Fragment {
    @BindView(R.id.id_Subscriber_SubscriberList)
    ListView mSubscriberList;
    @BindView(android.R.id.empty)
    ImageView empty;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscriber, null);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        mSubscriberList.setEmptyView(empty);
        SubscriberListAdapter adapter = new SubscriberListAdapter(getContext());
        mSubscriberList.setAdapter(adapter);
    }
}
