package com.edu.gdqy.Tool;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.TextView;

import com.edu.gdqy.Controller.R;

/**
 * Created by HXY on 2016/10/8.
 * 自定义组件  圆形的TextView，用于显示直播分类界面
 */

public class CircularTextView extends TextView {
    private int textColor, roundColor,roundRadius;
    private String textContent;
    private Paint paint;

    public CircularTextView(Context context) {
        super(context,null);
    }

    public CircularTextView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.CircularTextView);
        textColor = a.getColor(R.styleable.CircularTextView_textColor,0xff000000);
        roundColor = a.getColor(R.styleable.CircularTextView_roundColor,0xff123456);
        a.recycle();
        paint = new Paint();
        paint.setAntiAlias(true);
        WindowManager manager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        roundRadius = manager.getDefaultDisplay().getWidth()/4-50;
    }


    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(roundColor);
        canvas.drawCircle(roundRadius,roundRadius,roundRadius,paint);
        paint.setColor(textColor);
        paint.setTextSize(60);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(textContent,roundRadius,roundRadius,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width,height;
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        if (widthMode==MeasureSpec.EXACTLY){
            width=widthSize;
        }else {
            width=roundRadius*2;
        }
        if (heightMode==MeasureSpec.EXACTLY){
            height=heightSize;
        }else {
            height=roundRadius*2;
        }
        setMeasuredDimension(width,height);
    }
}
