package com.edu.gdqy.Controller.LiveWatcherView;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.gdqy.Controller.R;

/**
 * Created by WDK on 2016/10/27.
 */

public class LiveViewFragment extends Fragment {

    //这里得改成直播中的视频

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_liveview, container, false);
    }
}
