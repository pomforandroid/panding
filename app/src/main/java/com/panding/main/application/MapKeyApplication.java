package com.panding.main.application;

import android.app.Application;
import android.app.Service;
import android.os.Vibrator;

import com.baidu.mapapi.SDKInitializer;
import com.panding.main.perfecthttp.response.Login_bd_group;
import com.panding.main.perfecthttp.response.Login_bd_single;
import com.panding.main.perfecthttp.response.Login_h_group;
import com.panding.main.perfecthttp.response.Login_h_single;

import net.danlew.android.joda.JodaTimeAndroid;

public class MapKeyApplication extends Application  {

	//百度定位服务
	public LocationService locationService;
	public Vibrator mVibrator;


	//账号和密码
	private String username;
	private String password;

	//登录标识
	private int vehiclegroup;

	//h平台的个人登录和组登录
	private Login_h_single loginHSingle;
	private Login_h_group loginhgroup;


	//波导的个人登录和组登录
	private Login_bd_group loginBdGroup;
	private Login_bd_single loginBdSingle;

	/*@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}*/
	@Override
	public void onCreate() {
		super.onCreate();
		// 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
		locationService = new LocationService(getApplicationContext());
		mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
		SDKInitializer.initialize(this);
		//joda 时间库的使用
		JodaTimeAndroid.init(this);
		/*//joda 时间库的使用
		JodaTimeAndroid.init(this);
		//图片库fresco初始化
		Fresco.initialize(this);
		//友盟初始化
		UMShareAPI.get(this);
		//JPUSH
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);
		//jpush的短信
		SMSSDK.getInstance().initSdk(this);*/

	}
	//友盟，qq微信的key
	/*{
		PlatformConfig.setWeixin("wxb7f9ab7fbba036e5","5e0f7a5d8a67d59552506f873047a5ab");
		PlatformConfig.setQQZone("1106022664","dX9yVoSmVjUvieVs");
		*//*PlatformConfig.setWeixin("wx9b269aac3acb0f02","b1b1ff775fd0eeac0edb8fba02584d9f");
		PlatformConfig.setQQZone("1106030697","CI2BKNhPt0AJplax");*//*
	}*/

	public int getVehiclegroup() {
		return vehiclegroup;
	}

	public void setVehiclegroup(int vehiclegroup) {
		this.vehiclegroup = vehiclegroup;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public Login_h_single getLoginHSingle() {
		return loginHSingle;
	}

	public void setLoginHSingle(Login_h_single loginHSingle) {
		this.loginHSingle = loginHSingle;
	}

	public Login_h_group getLoginhgroup() {
		return loginhgroup;
	}

	public void setLoginhgroup(Login_h_group loginhgroup) {
		this.loginhgroup = loginhgroup;
	}

	public Login_bd_group getLoginBdGroup() {
		return loginBdGroup;
	}

	public void setLoginBdGroup(Login_bd_group loginBdGroup) {
		this.loginBdGroup = loginBdGroup;
	}

	public Login_bd_single getLoginBdSingle() {
		return loginBdSingle;
	}

	public void setLoginBdSingle(Login_bd_single loginBdSingle) {
		this.loginBdSingle = loginBdSingle;
	}

}