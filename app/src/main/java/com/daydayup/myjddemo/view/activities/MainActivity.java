package com.daydayup.myjddemo.view.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.daydayup.myjddemo.R;
import com.daydayup.myjddemo.view.fragments.BaseFragment;
import com.daydayup.myjddemo.view.fragments.FragmentFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment  容器  FrameLayout
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private final int SY = 0, FL = 1, FX = 2, GWC = 3, WD = 4;
    private View view;
    private TextView main_sy, main_fl, main_fx, main_gwc, main_wd;
    private List<TextView> nav_list = null;
    private List<BaseFragment> fg_list = null;
    private FragmentManager fm;

    @Override
    protected void initDatas() {

        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fg_list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            BaseFragment fragement = FragmentFactory.createFragement(i);

            fg_list.add(fragement);

            ft.add(R.id.main_content, fragement);

            if (i == 0) {
                ft.show(fragement);
            } else {
                ft.hide(fragement);
            }
        }
        ft.commit();
        //底部导航栏

    }

    @Override
    protected void initViews() {
        main_sy = findViewById(R.id.main_sy);
        main_fl = findViewById(R.id.main_fl);
        main_fx = findViewById(R.id.main_fx);
        main_gwc = findViewById(R.id.main_gwc);
        main_wd = findViewById(R.id.main_wd);

        nav_list = new ArrayList<>();

        nav_list.add(main_sy);
        nav_list.add(main_fl);
        nav_list.add(main_fx);
        nav_list.add(main_gwc);
        nav_list.add(main_wd);

        //默认第一个选中
        nav_list.get(0).setSelected(true);

        main_sy.setOnClickListener(this);
        main_fl.setOnClickListener(this);
        main_fx.setOnClickListener(this);
        main_gwc.setOnClickListener(this);
        main_wd.setOnClickListener(this);
    }

    @Override
    View createView() {
        view = View.inflate(this, R.layout.activity_main, null);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_sy:
                changeNav(nav_list, SY);
                changeFragment(fg_list, SY);
                break;
            case R.id.main_fl:
                changeNav(nav_list, FL);
                changeFragment(fg_list, FL);
                break;
            case R.id.main_fx:
                changeNav(nav_list, FX);
                changeFragment(fg_list, FX);
                break;
            case R.id.main_gwc:
                changeNav(nav_list, GWC);
                changeFragment(fg_list, GWC);
                break;
            case R.id.main_wd:
                changeNav(nav_list, WD);
                changeFragment(fg_list, WD);
                break;


        }
    }

    //切换状态
    public void changeNav(List<TextView> nav_list, int postion) {
        for (int i = 0; i < nav_list.size(); i++) {
            TextView textView = nav_list.get(i);
            if (postion == i) {
                textView.setSelected(true);
            } else {
                textView.setSelected(false);
            }
        }
    }

    //切换页面
    public void changeFragment(List<BaseFragment> fg_list, int postion) {

        FragmentTransaction ft = fm.beginTransaction();

        for (int i = 0; i < fg_list.size(); i++) {
            BaseFragment baseFragment = fg_list.get(i);
            if (postion == i) {
                ft.show(baseFragment);
            } else {
                ft.hide(baseFragment);
            }
        }

        ft.commit();
    }
}
