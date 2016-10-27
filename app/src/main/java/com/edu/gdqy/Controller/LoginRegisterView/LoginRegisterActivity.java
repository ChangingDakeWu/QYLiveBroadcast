package com.edu.gdqy.Controller.LoginRegisterView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.edu.gdqy.Controller.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HXY on 2016/10/25.
 * 登录和注册所需Activity
 */

public class LoginRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginregister);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        init();
    }

    private void init() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        LoginWayFragment wayFragment = new LoginWayFragment();
        fragmentTransaction.add(R.id.AC_Loginregister_Framelayout,wayFragment).commit();
    }
}
