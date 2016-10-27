package com.edu.gdqy.Controller.LoginRegisterView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.edu.gdqy.Controller.R;
import com.edu.gdqy.Tool.Counter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HXY on 2016/10/25.
 * 注册界面中手机注册的部分
 */

public class PhoneRegisterFragment extends Fragment {
    @BindView(R.id.FM_Phoneregister_PhoneInput)
    EditText mPhoneInput;
    @BindView(R.id.FM_honeregister_codeInput)
    EditText mCodeInput;
    @BindView(R.id.FM_honeregister_passwordInput)
    EditText mPasswordInput;
    @BindView(R.id.FM_Phoneregister_Captcha)
    Button mCaptcha;
    @BindView(R.id.FM_honeregister_Nickname)
    EditText mNickname;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phoneregister, null);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        setEditTextDrawable(mPhoneInput, R.drawable.phone);
        setEditTextDrawable(mCodeInput, R.drawable.captcha);
        setEditTextDrawable(mPasswordInput, R.drawable.password);
        setEditTextDrawable(mNickname,R.drawable.nickname);
    }

    private void setEditTextDrawable(EditText editText, int resource) {
        Context context = getContext();
        Drawable drawable = ContextCompat.getDrawable(context, resource);
        drawable.setBounds(10, 0, 55, 55);
        editText.setCompoundDrawables(drawable, null, null, null);
    }

    @OnClick(R.id.FM_Phoneregister_Captcha)
    public void onClick() {
        GradientDrawable drawable = (GradientDrawable) ContextCompat.getDrawable(getContext(), R.drawable.shape_button_unusable);
        mCaptcha.setBackground(drawable);
        mCaptcha.setEnabled(false);
        mPhoneInput.setEnabled(false);
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                int what = msg.what;
                if (what != 0) {
                    mCaptcha.setText(what + "");
                } else {
                    mPasswordInput.setEnabled(true);
                    mCaptcha.setText("验证码");
                    GradientDrawable drawable = (GradientDrawable) ContextCompat.getDrawable(getContext(), R.drawable.shape_button_usable);
                    mCaptcha.setBackground(drawable);
                    mCaptcha.setEnabled(true);
                    mPhoneInput.setEnabled(true);
                }
            }
        };
        Counter counter = new Counter(handler);
        Thread thread = new Thread(counter);
        thread.start();
    }
}
