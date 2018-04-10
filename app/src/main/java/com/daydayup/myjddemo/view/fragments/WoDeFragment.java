package com.daydayup.myjddemo.view.fragments;

import android.view.LayoutInflater;
import android.view.View;

import com.daydayup.myjddemo.R;

/**
 * Created by gjl on 2018/4/10.
 */

public class WoDeFragment extends BaseFragment {

    private View view;

    //页面
    @Override
    View createView(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.layout_wd,null);
        return view;
    }
}
