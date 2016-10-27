package com.edu.gdqy.Controller.MainView.My;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.gdqy.Controller.R;
import com.edu.gdqy.Tool.PublicVariable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HXY on 2016/10/19.
 */

public class ReviseDateFragment extends Fragment {

    @BindView(R.id.AC_Aboutus_Back)
    TextView mBack;
    @BindView(R.id.FM_Revisedate_Picture)
    ImageView mPicture;
    @BindView(R.id.FM_Revisedate_Username)
    TextView mUsername;
    @BindView(R.id.FM_Revisedate_UpdatePassword)
    TextView mUpdatePassword;
    @BindView(R.id.FM_Revisedate_Nickname)
    EditText mNickname;
    @BindView(R.id.FM_Revisedate_Submit)
    Button mSubmit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_revisedate, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.AC_Aboutus_Back, R.id.FM_Revisedate_Picture, R.id.FM_Revisedate_UpdatePassword, R.id.FM_Revisedate_Submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.AC_Aboutus_Back:
                Intent intent =new Intent(PublicVariable.SET_ACTION);
                intent.putExtra("FragmentCode",PublicVariable.SET_MORESET);
                getActivity().sendBroadcast(intent);
                break;
            case R.id.FM_Revisedate_Picture:
                break;
            case R.id.FM_Revisedate_UpdatePassword:
                break;
            case R.id.FM_Revisedate_Submit:
                break;
        }
    }
}
