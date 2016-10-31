package com.edu.gdqy.Controller.LiveWatcherView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.edu.gdqy.Controller.R;

/**
 * Created by WDK on 2016/10/27.
 */

public class WatcherViewActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livewatcherviewmain);

        /*这里可以看到的就是我们将初始化直播的Fragment添加到了这个页面作为填充
        * 并且将MainDialogFragment显示在该页面的顶部已达到各种不同交互的需求*/

        //1->LiveViewFragment

        //2->MainDialogFragment()-2a->EmptyFragment
        //                        2b->LayerFragment
        LiveViewFragment liveViewFragment = new LiveViewFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.flmain, liveViewFragment).commit();
        new MainDialogFragment().show(getSupportFragmentManager(),"MainDialogFragment");

    }
}
