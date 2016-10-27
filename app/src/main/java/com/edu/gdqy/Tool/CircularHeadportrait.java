package com.edu.gdqy.Tool;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

import com.edu.gdqy.Controller.R;

/**
 * Created by HXY on 2016/9/11.
 * 将图片裁剪成圆形
 */
public class CircularHeadportrait {
    //将图片裁剪成圆形

    public static Bitmap toRoundBitmap(int drawable,Resources resources) {
        Bitmap bitmap= BitmapFactory.decodeResource(resources,drawable);
        int mImagewidth = bitmap.getWidth();
        int mImageheight = bitmap.getHeight();
        int r;
        if (mImagewidth > mImageheight)
            r = mImageheight;
        else
            r = mImagewidth;

        Bitmap mBackground = Bitmap.createBitmap(mImagewidth, mImageheight, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBackground);
        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        RectF rectF = new RectF(0,0,r,r);
        mCanvas.drawRoundRect(rectF,r/2,r/2,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        mCanvas.drawBitmap(bitmap,null,rectF,mPaint);
        return mBackground;
    }
}
