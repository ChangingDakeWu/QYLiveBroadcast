package com.edu.gdqy.Tool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.edu.gdqy.Controller.R;

/**
 * Created by HXY on 2016/10/7.
 * Imag和Text的组合控件
 */

public class ImageTextGroupView extends LinearLayout{
    private ImageView icon;     //图标
    private TextView name;       //名字

    public ImageTextGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.groupview_imgetext,this,true);

        icon = (ImageView) findViewById(R.id.GV_Navigation_icon);
        name = (TextView) findViewById(R.id.GV_Navigation_name);
    }

    public void setImageIcon(int iconId){
        icon.setImageResource(iconId);
    }


    public void setTextName(String name){
        this.name.setText(name);
    }

}
