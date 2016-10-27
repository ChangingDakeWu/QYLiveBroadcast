package com.edu.gdqy.Controller.MainView.HomePage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.edu.gdqy.Controller.R;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

/**
 * Created by HXY on 2016/10/23.
 * 轮播组件的adapter
 */


//RollPagerView轮播adapter
public class CarouselAdapter extends StaticPagerAdapter {
    private int[] imgs = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
    };

    @Override
    public View getView(ViewGroup container, final int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgs[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里便是组件的点击事件监听
            }
        });
        return view;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }
}

