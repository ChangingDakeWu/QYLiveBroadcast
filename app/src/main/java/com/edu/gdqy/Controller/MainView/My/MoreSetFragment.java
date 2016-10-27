package com.edu.gdqy.Controller.MainView.My;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.edu.gdqy.Controller.R;
import com.edu.gdqy.Tool.PublicVariable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by HXY on 2016/10/14.
 * 显示更多设置的Fragment
 */

public class MoreSetFragment extends Fragment {
    @BindView(R.id.FM_Moreset_SetList)
    ListView mSetList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_moreset, null);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        SetListAdapter adapter = new SetListAdapter(getContext());
        mSetList.setAdapter(adapter);
    }

    @OnClick(R.id.AC_moreset_Back)
    public void onClick() {
        getActivity().finish();
    }
    @OnItemClick(R.id.FM_Moreset_SetList)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                sendBroadcastToMoresetActivity(PublicVariable.SET_REVISEDATE);
                break;
            case 1:
                Log.w("TAG","0");
                break;
            case 2:
                Log.w("TAG","0");
                break;
            case 3:
                Log.w("TAG","0");
                break;
            case 4:
                Log.w("TAG","0");
                break;
            case 5:
                sendBroadcastToMoresetActivity(PublicVariable.SET_ABOUTUS);
                break;
        }
    }

    private void sendBroadcastToMoresetActivity(String FragmentCode){
        Intent intent =new Intent(PublicVariable.SET_ACTION);
        intent.putExtra("FragmentCode",FragmentCode);
        getActivity().sendBroadcast(intent);
    }
}
