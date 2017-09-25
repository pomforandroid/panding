package com.panding.main.Base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.panding.main.application.MapKeyApplication;
import com.panding.main.perfecthttp.response.Login_bd_group;
import com.panding.main.perfecthttp.response.Login_bd_single;
import com.panding.main.perfecthttp.response.Login_h_group;
import com.panding.main.perfecthttp.response.Login_h_single;

public class BaseActivity extends AppCompatActivity {

    private static final String PDUSER = "pdusername";
    private static final String PDPWD = "pdpassward";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {

            //恢复application
            Login_bd_group loginBdGroup = savedInstanceState.getParcelable("loginBdGroup");
            Login_h_group loginhgroup = savedInstanceState.getParcelable("loginhgroup");
            Login_bd_single loginBdSingle = savedInstanceState.getParcelable("loginBdSingle");
            Login_h_single loginHSingle = savedInstanceState.getParcelable("loginHSingle");

            String username = savedInstanceState.getString("username");
            String password = savedInstanceState.getString("password");

            int vehiclegroup = savedInstanceState.getInt("vehiclegroup");

            MapKeyApplication swzApplication = (MapKeyApplication) getApplication();
            swzApplication.setLoginBdGroup(loginBdGroup);
            swzApplication.setLoginhgroup(loginhgroup);
            swzApplication.setLoginBdSingle(loginBdSingle);
            swzApplication.setLoginHSingle(loginHSingle);

            swzApplication.setUsername(username);
            swzApplication.setPassword(password);

            swzApplication.setVehiclegroup(vehiclegroup);
        }

        //设置输入框监听，内容都不为空才能点击按钮
    }

    /**
     * 获得磐鼎用户名
     * @return
     */
    protected String getPDUsername(){
        //从shareprefecne拿数据
        if(sharedPreferences==null){
            sharedPreferences = getSharedPreferences("pdlogin", Context.MODE_PRIVATE);
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
            sharedPreferences = getSharedPreferences("pdlogin", Context.MODE_PRIVATE);
        }
        return  sharedPreferences.getString(PDPWD, "");
    }

    /**
     * 因为内存不足而被系统杀死的非正常“死亡”方式， Activity会调用回调函数onSaveInstanceState
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MapKeyApplication swzApplication = (MapKeyApplication) getApplication();
        String username = swzApplication.getUsername();
        String password = swzApplication.getPassword();

        int vehiclegroup = swzApplication.getVehiclegroup();
        Login_bd_group loginBdGroup = swzApplication.getLoginBdGroup();
        Login_h_group loginhgroup = swzApplication.getLoginhgroup();
        Login_bd_single loginBdSingle = swzApplication.getLoginBdSingle();
        Login_h_single loginHSingle = swzApplication.getLoginHSingle();

        outState.putParcelable("loginBdGroup",loginBdGroup);
        outState.putParcelable("loginhgroup",loginhgroup);
        outState.putParcelable("loginBdSingle",loginBdSingle);
        outState.putParcelable("loginHSingle",loginHSingle);

        outState.putString("username",username);
        outState.putString("password",password);
        outState.putInt("vehiclegroup",vehiclegroup);

    }
}
