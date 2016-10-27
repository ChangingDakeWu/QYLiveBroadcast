package com.edu.gdqy.Controller.MainView.Square;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.edu.gdqy.Controller.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HXY on 2016/10/9.
 * 课后辅导选项下的小选项Fragment
 */

public class ClassifyCoachFragment extends Fragment {
    @BindView(R.id.FM_ClassifyCoach_GridView)
    GridView mGridView;
    private List<String> teachList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classifycoach, null);
        ButterKnife.bind(this, view);
        init();
        return view;
    }


    private void init() {
        teachList = new ArrayList<>();
        teachList.add("练习");
        teachList.add("回顾");
        teachList.add("测试");
        teachList.add("巩固");
        teachList.add("问答");
        teachList.add("扩展");
        ClassifyGirdAdapter adapter = new ClassifyGirdAdapter(teachList, getContext());
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                    case 1:
                        break;
                    case 2:
                        Log.w("TAG", "2");
                        break;
                    case 3:
                        Log.w("TAG", "3");
                        break;
                    case 4:
                        Log.w("TAG", "4");
                        break;
                    case 5:
                        Log.w("TAG", "5");
                        break;
                    case 6:
                        Log.w("TAG", "6");
                        break;
                }
            }
        });
    }


}
