package com.edu.gdqy.Controller.MainView.HomePage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.edu.gdqy.Controller.R;
import com.edu.gdqy.Tool.VedioGridAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by HXY on 2016/10/7.
 * 主页界面
 */

public class HomePageFragment extends Fragment {
    @BindView(R.id.FM_Homepage_Carousel)
    RollPagerView mCarousel;
    @BindView(R.id.FM_Homepage_HotGrid)
    GridView mHotGrid;
    @BindView(R.id.FM_Homepage_Programming)
    GridView mProgrammingGrid;
    @BindView(R.id.FM_HomePage_Layout)
    LinearLayout mLayout;

    private int popupWidth, popupHeight;
    private int xOff;
    private PopupWindow popupWindow;
    private boolean isShowPopup = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, null);
        ButterKnife.bind(this, view);

        WindowManager manager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = manager.getDefaultDisplay();
        Point size = new Point();
        defaultDisplay.getSize(size);
        int screenWidth = size.x;
        int screenHeight = size.y;
        popupWidth = screenWidth * 3 / 4;
        popupHeight = screenHeight /2;
        xOff = screenWidth - popupWidth;

        init();
        return view;
    }

    private void init() {
        //设置播放时间间隔
        mCarousel.setPlayDelay(2000);
        //设置透明度
        mCarousel.setAnimationDurtion(500);
        //设置适配器
        mCarousel.setAdapter(new CarouselAdapter());

        initPopupWindow();

        VedioGridAdapter adapter1 = new VedioGridAdapter(getContext(), null, null);
        mHotGrid.setAdapter(adapter1);
        VedioGridAdapter adapter2 = new VedioGridAdapter(getContext(), null, null);
        mProgrammingGrid.setAdapter(adapter2);

    }

    @OnClick({R.id.FM_HomePage_Herald, R.id.FM_HomePage_TwoDimensionCode, R.id.FM_HomePage_Search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.FM_HomePage_Herald:
                if (!isShowPopup) {
                    popupWindow.showAsDropDown(mLayout, xOff, 0);
                    isShowPopup = true;
                } else {
                    popupWindow.dismiss();
                    isShowPopup = false;
                }
                break;
            case R.id.FM_HomePage_TwoDimensionCode:
                startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 0);
                break;
            case R.id.FM_HomePage_Search:
                Intent intent= new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void initPopupWindow(){
        View popupView = getActivity().getLayoutInflater().inflate(R.layout.layout_heraldlist, null);
        popupWindow = new PopupWindow(popupView, popupWidth, popupHeight);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), R.drawable.img1));
        popupWindow.setAnimationStyle(R.style.mune_herald);
        ListView heraldList= (ListView) popupView.findViewById(R.id.LY_herald_list);
        heraldList.setAdapter(new HeraldListAdapter(getContext(),null,null,null));
        heraldList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    //扫描二维码返回
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Toast.makeText(getContext(), "扫描结果:" + result, Toast.LENGTH_LONG).show();
        }
    }

}
