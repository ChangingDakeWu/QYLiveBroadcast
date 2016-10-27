package com.edu.gdqy.Controller.MainView.My;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.gdqy.Controller.R;
import com.edu.gdqy.Tool.ImageTextGroupView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HXY on 2016/10/14.
 * 上传界面的Activity
 */

public class UploadActivity extends AppCompatActivity {
    @BindView(R.id.AC_Upload_ShootUpload)
    ImageTextGroupView mShootUpload;
    @BindView(R.id.AC_Upload_LocalUpload)
    ImageTextGroupView mLocalUpload;
    @BindView(R.id.AC_Upload_Preview)
    ImageView mPreview;
    @BindView(R.id.AC_Upload_VedioName)
    TextView mVedioName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar!=null){
            supportActionBar.hide();
        }
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mShootUpload.setImageIcon(R.drawable.shoot);
        mShootUpload.setTextName("拍摄上传");
        mLocalUpload.setImageIcon(R.drawable.file);
        mLocalUpload.setTextName("本地上传");
    }

    @OnClick({R.id.AC_Upload_Back, R.id.AC_Upload_ShootUpload, R.id.AC_Upload_LocalUpload, R.id.AC_Upload_UploadBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.AC_Upload_Back:
                this.finish();
                break;
            case R.id.AC_Upload_ShootUpload:
                break;
            case R.id.AC_Upload_LocalUpload:
                break;
            case R.id.AC_Upload_UploadBtn:
                break;
        }
    }
}
