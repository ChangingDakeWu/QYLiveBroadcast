package com.edu.gdqy.Controller.MainView.My;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.gdqy.Controller.LoginRegisterView.LoginRegisterActivity;
import com.edu.gdqy.Controller.R;
import com.edu.gdqy.Tool.CircularHeadportrait;
import com.edu.gdqy.Tool.ImageTextGroupView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HXY on 2016/10/7.
 * 我的界面
 */

public class MyFragment extends Fragment {
    @BindView(R.id.FM_My_Photo)
    ImageView mPhoto;
    @BindView(R.id.FM_My_LoginRegister)
    TextView mLoginRegister;
    @BindView(R.id.FM_My_ApplyForLive)
    Button mApplyForLive;
    @BindView(R.id.FM_My_History)
    ImageTextGroupView mHistory;
    @BindView(R.id.FM_My_Manager)
    ImageTextGroupView mManager;
    @BindView(R.id.FM_My_Release)
    ImageTextGroupView mRelease;
    @BindView(R.id.FM_My_Upload)
    ImageTextGroupView mUpload;
    @BindView(R.id.FM_My_MoreSet)
    Button mMoreSet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, null);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        mPhoto.setImageBitmap(CircularHeadportrait.toRoundBitmap(R.drawable.photo, getResources()));

        mHistory.setImageIcon(R.drawable.history);
        mHistory.setTextName("记录");
        mManager.setImageIcon(R.drawable.manage);
        mManager.setTextName("云管理");
        mRelease.setImageIcon(R.drawable.release_notice);
        mRelease.setTextName("直播预告");
        mUpload.setImageIcon(R.drawable.upload);
        mUpload.setTextName("上传");
    }

    @OnClick({R.id.FM_My_Photo, R.id.FM_My_LoginRegister, R.id.FM_My_ApplyForLive,
            R.id.FM_My_History, R.id.FM_My_Manager, R.id.FM_My_Release, R.id.FM_My_Upload,
            R.id.FM_My_MoreSet})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.FM_My_Photo:
                jumpActivity(MoreSetActivity.class);
                break;
            case R.id.FM_My_LoginRegister:
                jumpActivity(LoginRegisterActivity.class);
                break;
            case R.id.FM_My_ApplyForLive:
                break;
            case R.id.FM_My_History:
                break;
            case R.id.FM_My_Manager:
                break;
            case R.id.FM_My_Release:
                jumpActivity(ReleaseNoticeActivity.class);
                break;
            case R.id.FM_My_Upload:
                jumpActivity(UploadActivity.class);
                break;
            case R.id.FM_My_MoreSet:
                jumpActivity(MoreSetActivity.class);
                break;
        }
    }

    private void jumpActivity(Class<?> mclass) {
        Intent intent = new Intent(getActivity(), mclass);
        startActivity(intent);
    }
}
