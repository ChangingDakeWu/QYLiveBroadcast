package com.edu.gdqy.Tool;

import android.os.Handler;
import android.os.Message;

/**
 * Created by HXY on 2016/9/4.
 * 计时器
 */
public class Counter implements Runnable {

    private Handler mHandler;
    public Counter(Handler handler){
        this.mHandler=handler;
    }

    @Override
    public void run() {
        for (int i=0;i<60;i++){
            try {
                Thread.sleep(1000);
                Message message = new Message();
                message.what=59-i;
                mHandler.sendMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
