package com.edu.gdqy.Controller.MainView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.edu.gdqy.Controller.MainView.BottomNavigationBar.BottomNavigationFragment;
import com.edu.gdqy.Controller.MainView.HomePage.HomePageFragment;
import com.edu.gdqy.Controller.MainView.My.MyFragment;
import com.edu.gdqy.Controller.MainView.Square.SquareFragment;
import com.edu.gdqy.Controller.MainView.Subscriber.SubscriberFragment;
import com.edu.gdqy.Controller.R;
import com.edu.gdqy.Tool.PublicVariable;

public class MainActivity extends FragmentActivity implements
        BottomNavigationFragment.NavigationListener {
    private Fragment homeFragment, squareFragment, subscriberFragment, myFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        homeFragment = new HomePageFragment();
        squareFragment = new SquareFragment();
        subscriberFragment = new SubscriberFragment();
        myFragment = new MyFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.AC_Main_framentLayout, homeFragment);
        fragmentTransaction.add(R.id.AC_Main_framentLayout, squareFragment).hide(squareFragment);
        fragmentTransaction.add(R.id.AC_Main_framentLayout, subscriberFragment).hide(subscriberFragment);
        fragmentTransaction.add(R.id.AC_Main_framentLayout, myFragment).hide(myFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void changeMainView(String code, String position) {
        if (code.equals(PublicVariable.HOMEPAGE_FRAGMENT))
            doChangeView(homeFragment, position);
        else if (code.equals(PublicVariable.SQUARE_FRAGMENT))
            doChangeView(squareFragment, position);
        else if (code.equals(PublicVariable.SUBSCRIBER_FRAGMENT))
            doChangeView(subscriberFragment, position);
        else if (code.equals(PublicVariable.MY_FRAGMENT))
            doChangeView(myFragment, position);
    }

    //具体改变主界面的方法
    private void doChangeView(Fragment showFragment, String hideFragmentCode) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.show(showFragment);
        if (hideFragmentCode.equals(PublicVariable.HOMEPAGE_FRAGMENT))
            fragmentTransaction.hide(homeFragment);
        else if (hideFragmentCode.equals(PublicVariable.SQUARE_FRAGMENT))
            fragmentTransaction.hide(squareFragment);
        else if (hideFragmentCode.equals(PublicVariable.SUBSCRIBER_FRAGMENT))
            fragmentTransaction.hide(subscriberFragment);
        else if (hideFragmentCode.equals(PublicVariable.MY_FRAGMENT))
            fragmentTransaction.hide(myFragment);
        fragmentTransaction.commit();
    }

}
