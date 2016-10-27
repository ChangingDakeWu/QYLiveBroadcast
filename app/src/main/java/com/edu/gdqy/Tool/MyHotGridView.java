package com.edu.gdqy.Tool;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by HXY on 2016/10/20.
 * 解决ScrollView嵌套ListView GridView显示不全的问题
 */

public class MyHotGridView extends GridView{

    public MyHotGridView(Context context) {
        super(context);
    }

    public MyHotGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHotGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
