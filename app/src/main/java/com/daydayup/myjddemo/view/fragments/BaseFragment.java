package com.daydayup.myjddemo.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gjl on 2018/4/10.
 * <p>
 * Fragment?
 * Activity
 * <p>
 * 生命周期
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return createView(inflater);
    }

    abstract View createView(LayoutInflater inflater);

}
