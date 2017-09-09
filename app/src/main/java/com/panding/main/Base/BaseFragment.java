package com.panding.main.Base;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.panding.main.pdinterface.OperateBackstackListener;


public class BaseFragment extends Fragment {

    protected Activity mActivity;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }


}
