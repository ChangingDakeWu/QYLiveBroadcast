package com.edu.gdqy.Controller.MainView.My;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.edu.gdqy.Controller.MainView.My.AboutUsFragment;
import com.edu.gdqy.Controller.MainView.My.MoreSetFragment;
import com.edu.gdqy.Controller.MainView.My.ReviseDateFragment;
import com.edu.gdqy.Controller.R;
import com.edu.gdqy.Tool.PublicVariable;

/**
 * Created by HXY on 2016/10/14.
 * 更多设置Fragment的Activity容器
 */

public class MoreSetActivity extends AppCompatActivity {

    private Fragment setFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moreset);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        //注册广播
        IntentFilter filter = new IntentFilter();
        filter.addAction(PublicVariable.SET_ACTION);
        registerReceiver(receiver, filter);

        init();
    }

    private void init() {
        setFragment = new MoreSetFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.AC_Moreset_FrameLayout, setFragment);
        fragmentTransaction.commit();
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String fragmentCode = intent.getStringExtra("FragmentCode");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            if (fragmentCode.equals(PublicVariable.SET_MORESET)) {
                fragmentTransaction.replace(R.id.AC_Moreset_FrameLayout, setFragment).commit();
            } else if (fragmentCode.equals(PublicVariable.SET_REVISEDATE)) {
                Fragment reviseDateFragment= new ReviseDateFragment();
                fragmentTransaction.replace(R.id.AC_Moreset_FrameLayout, reviseDateFragment).commit();
            } else if (fragmentCode.equals(PublicVariable.SET_ABOUTUS)) {
                Fragment usFragment = new AboutUsFragment();
                fragmentTransaction.replace(R.id.AC_Moreset_FrameLayout, usFragment).commit();
            }
        }
    };
}
