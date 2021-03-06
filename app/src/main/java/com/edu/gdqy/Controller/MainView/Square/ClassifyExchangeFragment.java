package com.edu.gdqy.Controller.MainView.Square;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;

import com.edu.gdqy.Controller.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HXY on 2016/10/9.
 * 学生交流选项下的小选项Fragment
 */

public class ClassifyExchangeFragment extends Fragment {
    @BindView(R.id.FM_ClassifyExchange_GridView)
    GridView mGridView;
    private List<String> teachList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exchange, null);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        teachList = new ArrayList<>();
        teachList.add("技能");
        teachList.add("才艺");
        teachList.add("休闲");
        teachList.add("运动");
        teachList.add("游戏");
        teachList.add("电子");
        teachList.add("梦想");
        teachList.add("潮流");
        ClassifyGirdAdapter adapter = new ClassifyGirdAdapter(teachList,getContext());
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                doAnimotion(view);
                switch (position){
                    case 0:
                        Log.w("TAG","0");
                        break;
                    case 1:
                        Log.w("TAG","1");
                        break;
                    case 2:
                        Log.w("TAG","2");
                        break;
                    case 3:
                        Log.w("TAG","3");
                        break;
                    case 4:
                        Log.w("TAG","4");
                        break;
                    case 5:
                        Log.w("TAG","5");
                        break;
                    case 6:
                        Log.w("TAG","6");
                        break;
                    case 7:
                        Log.w("TAG","6");
                        break;
                }
            }
        });
    }

    private void doAnimotion(View view){
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.myanimotion);
        View textView = view.findViewById(R.id.Item_Classify_CircularView);
        Log.w("TAG", textView.toString());
        textView.startAnimation(animation);
    }
}
