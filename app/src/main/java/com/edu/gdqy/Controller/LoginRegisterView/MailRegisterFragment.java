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
import android.widget.TextView;

import com.edu.gdqy.Controller.R;
import com.edu.gdqy.Tool.Counter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HXY on 2016/10/25.
 * 注册页面的邮箱注册页面
 */

public class MailRegisterFragment extends Fragment {
    @BindView(R.id.FM_Mailregister_mailInput)
    EditText mMailInput;
    @BindView(R.id.FM_Mailregister_CodeInput)
    EditText mCodeInput;
    @BindView(R.id.FM_Mailregister_passwordInput)
    EditText mPasswordInput;
    @BindView(R.id.FM_Mailregister_Captcha)
    Button mCaptcha;
    @BindView(R.id.FM_Mailregister_Nickname)
    EditText mNickname;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mailregister, null);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        setEditTextDrawable(mMailInput, R.drawable.mail);
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

    @OnClick(R.id.FM_Mailregister_Captcha)
    public void onClick() {
        GradientDrawable drawable = (GradientDrawable) ContextCompat.getDrawable(getContext(), R.drawable.shape_button_unusable);
        mCaptcha.setBackground(drawable);
        mCaptcha.setEnabled(false);
        mMailInput.setEnabled(false);
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
                    mMailInput.setEnabled(true);
                }
            }
        };
        Counter counter = new Counter(handler);
        Thread thread = new Thread(counter);
        thread.start();
    }
}
