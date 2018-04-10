package com.daydayup.myjddemo.view.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daydayup.myjddemo.R;

/**
 * Created by gjl on 2018/4/10.
 * <p>
 * Handler 的面试题
 */

public class SplashActivity extends BaseActivity {

    private View view;
    private ImageView splash_pic;
    private TextView spalsh_time;
    private MyHandler myHandler = new MyHandler();
    private int time = 3;

    @Override
    protected void initDatas() {
        //默认值
        spalsh_time.setText(time + "s");

        myHandler.sendEmptyMessageDelayed(0, 1000);

    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    time--;
                    spalsh_time.setText(time + "s");
                    if (time == 0) {
                        myHandler.removeCallbacksAndMessages(null);
                        //跳转
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    } else {
                        myHandler.sendEmptyMessageDelayed(0, 1000);
                    }
                    break;
            }
        }
    }

    //初始化控件
    @Override
    protected void initViews() {
        splash_pic = findViewById(R.id.splash_pic);
        spalsh_time = findViewById(R.id.spalsh_time);
    }

    //创建视图
    @Override
    View createView() {
        view = View.inflate(this, R.layout.layout_spalsh, null);
        return view;
    }
}
