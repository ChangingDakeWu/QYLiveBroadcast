package com.edu.gdqy.Controller.MainView.HomePage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.edu.gdqy.Controller.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HXY on 2016/10/23.
 * 搜索界面
 */

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.AC_Search_Text)
    EditText mSearchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.AC_Search_Searchbtn)
    public void onClick() {
    }
}
