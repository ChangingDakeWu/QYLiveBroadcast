package com.edu.gdqy.Controller.LoginRegisterView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.edu.gdqy.Controller.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HXY on 2016/10/25.
 * 登录界面的Fragment
 */

public class LoginFragment extends Fragment {
    @BindView(R.id.FM_login_userInput)
    EditText mUserInput;
    @BindView(R.id.FM_login_passwordInput)
    EditText mPasswordInput;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, null);
        ButterKnife.bind(this, view);

        init();
        return view;
    }

    private void init() {
        Context context = getContext();
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.my);
        drawable.setBounds(10, 0, 55, 55);
        mUserInput.setCompoundDrawables(drawable, null, null, null);
        drawable = ContextCompat.getDrawable(context, R.drawable.password);
        drawable.setBounds(10, 0, 55, 55);
        mPasswordInput.setCompoundDrawables(drawable, null, null, null);
    }


    @OnClick({R.id.FM_login_back, R.id.login_forgetPassword, R.id.login_registerUser, R.id.login_ImmediatelyLogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.FM_login_back:
                LoginWayFragment wayFragment = new LoginWayFragment();
                replaceFragment(wayFragment);
                break;
            case R.id.login_forgetPassword:
                break;
            case R.id.login_registerUser:
                RegisterFragment registerFragment = new RegisterFragment();
                replaceFragment(registerFragment);
                break;
            case R.id.login_ImmediatelyLogin:
                break;
        }
    }

    private void replaceFragment(Fragment fragment){
        LoginWayFragment wayFragment = new LoginWayFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(
                R.id.AC_Loginregister_Framelayout,fragment).commit();
    }
}
