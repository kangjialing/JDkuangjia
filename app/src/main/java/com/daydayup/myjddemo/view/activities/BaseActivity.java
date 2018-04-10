package com.daydayup.myjddemo.view.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

/**
 * Created by gjl on 2018/4/10.
 *
 * 基类：
 *         继承：增加代码的复用性
 *         多态：同一事物在不同状态下的不同形态。可扩展性。
 *
 *
 *
 */

public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(createView());
        //初始化界面
        initViews();
        //初始化数据
        initDatas();
    }

    protected abstract void initDatas();

    protected abstract void initViews();

    abstract View createView();
}
