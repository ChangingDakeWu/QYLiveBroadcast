package com.edu.gdqy.Controller.LoginRegisterView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HXY on 2016/10/25.
 * 注册页面ViewPager组件所需Adapter
 */

public class RegisterViewpagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] mTitle = {"手机注册", "邮箱注册"};
    private MailRegisterFragment mailpagerFragment;
    private PhoneRegisterFragment phonepagerFragment;

    public RegisterViewpagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        mailpagerFragment = new MailRegisterFragment();
        phonepagerFragment = new PhoneRegisterFragment();
        fragments.add(phonepagerFragment);
        fragments.add(mailpagerFragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}


