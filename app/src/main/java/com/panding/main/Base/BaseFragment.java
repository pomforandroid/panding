package com.panding.main.Base;


import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.panding.main.R;
import com.panding.main.pdinterface.OperateBackstackListener;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class BaseFragment extends Fragment {
    private static final String PDUSER = "pdusername";
    private static final String PDPWD = "pdpassward";
    private SharedPreferences sharedPreferences;

    protected Activity mActivity;

    protected SweetAlertDialog pDialog;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    protected Application getApplication(){
        return mActivity.getApplication();
    }

    protected SharedPreferences getSharedPreferences(String name , int mode){
        return mActivity.getSharedPreferences(name,mode);
    }

    protected void showDialog(String title){
        pDialog = new SweetAlertDialog(mActivity, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
        pDialog.setTitleText(title);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    protected void dismissDialog(){
        pDialog.dismiss();
    }


    /**
     * 获得磐鼎用户名
     * @return
     */
    protected String getPDUsername(){
        //从shareprefecne拿数据
        if(sharedPreferences==null){
            sharedPreferences = getSharedPreferences("pdlogin", mActivity.MODE_PRIVATE);
        }
        return sharedPreferences.getString(PDUSER, "");
    }

    /**
     * 获得磐鼎密码
     * @return
     */
    protected String getPDPassword(){
        //从shareprefecne拿数据
        if(sharedPreferences==null){
            sharedPreferences = getSharedPreferences("pdlogin", mActivity.MODE_PRIVATE);
        }
        return  sharedPreferences.getString(PDPWD, "");
    }
}
