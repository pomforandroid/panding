package com.panding.main.swzgps.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.panding.main.Base.BaseContentragment;
import com.panding.main.Base.BaseUtils;
import com.panding.main.R;
import com.panding.main.application.GetAppUtils;
import com.panding.main.application.MapKeyApplication;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PerfectHttp;
import com.panding.main.perfecthttp.request.Req_Login_log_post;
import com.panding.main.perfecthttp.request.Req_h_trial;
import com.panding.main.perfecthttp.request.Req_login;
import com.panding.main.perfecthttp.response.H_trial;
import com.panding.main.perfecthttp.response.Login_bd_group;
import com.panding.main.perfecthttp.response.Login_bd_single;
import com.panding.main.perfecthttp.response.Login_h_group;
import com.panding.main.perfecthttp.response.Login_h_single;
import com.panding.main.perfecthttp.response.Login_log_post;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.R.attr.fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SwzLoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SwzLoginFragment extends BaseContentragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.et_username)
    MaterialEditText etUsername;
    @BindView(R.id.et_password)
    MaterialEditText etPassword;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_register)
    Button btRegister;
    Unbinder unbinder;
    @BindView(R.id.cb_remember)
    CheckBox cbRemember;
    @BindView(R.id.cb_atuo)
    CheckBox cbAtuo;
    @BindView(R.id.tv_forgetpwd)
    TextView tvForgetpwd;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String password;
    private String username;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String AUTOLOGIN = "autologin";
    private static final String REMEMBERPASSWORD = "rememberpwd";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";


    public SwzLoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SwzLoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SwzLoginFragment newInstance(String param1, String param2) {
        SwzLoginFragment fragment = new SwzLoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_swz_login, container, false);
        unbinder = ButterKnife.bind(this, view);

        btLogin.setEnabled(false); //测试先屏蔽
        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etPassword.getText().toString())
                        && !TextUtils.isEmpty(etUsername.getText().toString())) {
                    btLogin.setEnabled(true);
                } else {
                    btLogin.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etPassword.getText().toString())
                        && !TextUtils.isEmpty(etUsername.getText().toString())) {
                    btLogin.setEnabled(true);
                } else {
                    btLogin.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = etPassword.getText().toString();
                username = etUsername.getText().toString();
                loginControl(username, password);
            }
        });

        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        cbAtuo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putBoolean(AUTOLOGIN, isChecked);
                    cbRemember.setChecked(isChecked);
                    editor.putBoolean(REMEMBERPASSWORD, isChecked);
                    editor.commit();
                } else {
                    editor.putBoolean(AUTOLOGIN, isChecked);
                    editor.commit();
                }
            }
        });
        cbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putBoolean(REMEMBERPASSWORD, isChecked);
                    editor.commit();
                } else {
                    editor.putBoolean(REMEMBERPASSWORD, isChecked);
                    editor.putBoolean(AUTOLOGIN, isChecked);
                    cbAtuo.setChecked(isChecked);
                    editor.commit();
                }

            }
        });
        boolean autoLogin = sharedPreferences.getBoolean(AUTOLOGIN, false);
        boolean remberpwd = sharedPreferences.getBoolean(REMEMBERPASSWORD, false);
        cbAtuo.setChecked(autoLogin);
        cbRemember.setChecked(remberpwd);

        String rem_username = sharedPreferences.getString(USERNAME, "");
        String rem_password = sharedPreferences.getString(PASSWORD, "");

        if (remberpwd) {
            etPassword.setText(rem_password);
            etUsername.setText(rem_username);
        }
        //自动登录
        if (autoLogin) {
            btLogin.callOnClick();
        }
        //忘记密码
        tvForgetpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    private void loginControl(String username, String password) {
        showDialog("登录中...");
        Req_login req_login = new Req_login();
        req_login.setPassword(password);
        req_login.setUsername(username);
        String param = new Gson().toJson(req_login);

        PerfectHttp.createService(PandingService.class).login(param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JsonObject>() {
                    @Override
                    public void onCompleted() {
                        dismissDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        dismissDialog();
                        Toast.makeText(mActivity, "登录失败,请检查网络状况", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(JsonObject jsonObject) {
                        int errcode = jsonObject.get("errcode").getAsInt();
                        String msg = jsonObject.get("msg").getAsString();
                        if (errcode == 0) {
                            int vehiclegroup = jsonObject.get("vehiclegroup").getAsInt();
                            switch (vehiclegroup) {

                                case 0:
                                    //H平台个人登录返回
                                    Login_h_single login_h_single =
                                            new Gson().fromJson(jsonObject, Login_h_single.class);
                                    deal_Login_h_single(login_h_single);
                                    break;

                                case 1:
                                    //H平台组用户返回
                                    Login_h_group login_h_group = new Gson().fromJson(jsonObject, Login_h_group.class);
                                    deal_Login_h_group(login_h_group);
                                    break;

                                case 2:
                                    //波导平台个人用户返回
                                    Login_bd_single login_bd_single = new Gson().fromJson(jsonObject, Login_bd_single.class);
                                    deal_login_bd_single(login_bd_single);
                                    break;

                                case 3:
                                    //波导平台组用户返回
                                    Login_bd_group login_bd_group = new Gson().fromJson(jsonObject, Login_bd_group.class);
                                    deal_Login_bd_group(login_bd_group);
                                    break;

                            }
                        }
                        //账号未激活，有激活和试用选项
                        else if (errcode == 102) {
                            String server = jsonObject.get("server").getAsString();
                            activateORtrial(true, server);
                        }
                        //账号试用期已到。 只有激活选项
                        else if (errcode == 103) {
                            String server = jsonObject.get("server").getAsString();
                            activateORtrial(false, server);
                        } else {
                            Toast.makeText(mActivity, msg, Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    /**
     * h平台个人登录的登录处理
     *
     * @param login_h_single
     */
    private void deal_Login_h_single(Login_h_single login_h_single) {
        MapKeyApplication application = (MapKeyApplication) getApplication();
        application.setLoginHSingle(login_h_single);

        application.setVehiclegroup(login_h_single.getVehiclegroup());
        application.setUsername(username);
        application.setPassword(password);
        if (cbRemember.isChecked()) {
            editor.putString(USERNAME, username);
            editor.putString(PASSWORD, password);
            editor.commit();
        }
        Req_Login_log_post req_login_logPost = new Req_Login_log_post();
        String ipAddress = BaseUtils.getIPAddress(mActivity);
        String termanalNum = GetAppUtils.getTermanalNum((MapKeyApplication) getApplication());

        req_login_logPost.setIp(ipAddress);
        req_login_logPost.setPhoneType("ANDROID");
        req_login_logPost.setTerminalNum(termanalNum);
        String param = new Gson().toJson(req_login_logPost);

        PerfectHttp.createService(PandingService.class).login_log_post(param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Login_log_post>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mActivity, "网络错误，录入登录日志失败", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(Login_log_post login_logPost) {
                        if (login_logPost.getErrcode() == 0) {
                            //切换到首页的Fragment
                            SwzFragment fragment = SwzFragment.newInstance("H");
                            pushStack(fragment);

                        } else {
                            Toast.makeText(mActivity, login_logPost.getMsg(), Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }

    /**
     * h平台组用户的登录处理
     *
     * @param login_h_group
     */
    private void deal_Login_h_group(Login_h_group login_h_group) {
        MapKeyApplication application = (MapKeyApplication) getApplication();
        application.setLoginhgroup(login_h_group);

        application.setVehiclegroup(login_h_group.getVehiclegroup());
        application.setUsername(username);
        application.setPassword(password);
        if (cbRemember.isChecked()) {
            editor.putString(USERNAME, username);
            editor.putString(PASSWORD, password);
            editor.commit();
        }
        //切换到h平台选择车辆的fragment
    }

    /**
     * 波导个人用户的登录处理
     *
     * @param login_bd_single
     */
    private void deal_login_bd_single(Login_bd_single login_bd_single) {
        MapKeyApplication application = (MapKeyApplication) getApplication();
        application.setLoginBdSingle(login_bd_single);

        application.setVehiclegroup(login_bd_single.getVehiclegroup());
        application.setUsername(username);
        application.setPassword(password);
        if (cbRemember.isChecked()) {
            editor.putString(USERNAME, username);
            editor.putString(PASSWORD, password);
            editor.commit();
        }

        Req_Login_log_post req_login_logPost = new Req_Login_log_post();
        String ipAddress = BaseUtils.getIPAddress(mActivity);
        String termanalNum = GetAppUtils.getTermanalNum((MapKeyApplication) getApplication());

        req_login_logPost.setIp(ipAddress);
        req_login_logPost.setPhoneType("ANDROID");
        req_login_logPost.setTerminalNum(termanalNum);
        String param = new Gson().toJson(req_login_logPost);

        PerfectHttp.createService(PandingService.class).login_log_post(param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Login_log_post>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mActivity, "网络错误，录入登录日志失败", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(Login_log_post login_logPost) {
                        if (login_logPost.getErrcode() == 0) {
                            //切换到波导的主页的fragment
                            SwzFragment fragment = SwzFragment.newInstance("BD");
                            pushStack(fragment);
                        } else {
                            Toast.makeText(mActivity, login_logPost.getMsg(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    /**
     * 波导组用户的登录处理
     *
     * @param login_bd_group
     */
    private void deal_Login_bd_group(Login_bd_group login_bd_group) {
        MapKeyApplication application = (MapKeyApplication) getApplication();
        application.setLoginBdGroup(login_bd_group);

        application.setVehiclegroup(login_bd_group.getVehiclegroup());
        application.setUsername(username);
        application.setPassword(password);
        //切换到波导的选择的fragment
    }

    /**
     * 激活和试用的dialog
     *
     * @param isTrial 是否有试用按钮
     * @param server
     */
    private void activateORtrial(boolean isTrial, final String server) {
        /*ViewHolder contentView = new ViewHolder(R.layout.dialog_activate_trial);
        final DialogPlus dialog = DialogPlus.newDialog(this)
                .setContentHolder(contentView)
                .setGravity(Gravity.CENTER)
                *//*.setContentWidth(ViewGroup.LayoutParams.WRAP_CONTENT)
                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)*//*
                .setCancelable(true)
                .setContentBackgroundResource(R.drawable.dialog_background)
                .create();

        View holderView = dialog.getHolderView();
        TextView tv_trial = (TextView) holderView.findViewById(R.id.tv_trial);
        TextView tv_activate = (TextView) holderView.findViewById(R.id.tv_activate);
        if (!isTrial) {
            tv_trial.setVisibility(View.INVISIBLE);
        }

        tv_trial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.equals(server, "H")) {
                    trial();
                } else if (TextUtils.equals(server, "BD")) {
                    bdTrial();
                }

                dialog.dismiss();
            }
        });
        tv_activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.equals(server, "H")) {
                    activate();
                } else if (TextUtils.equals(server, "BD")) {
                    bdActivate();
                }

                dialog.dismiss();
            }
        });

        dialog.show();*/
    }

    /**
     * 波导激活
     */
    private void bdActivate() {
        /*Intent intent = new Intent(this, BdActivateActivity.class);
        intent.putExtra("password", password);
        intent.putExtra("cid", username);
        startActivityForResult(intent, RequestCode);*/
    }

    /**
     * bd试用
     */
    private void bdTrial() {
    }

    /**
     * 试用
     */
    private void trial() {
        /*Req_h_trial req_h_trial = new Req_h_trial();
        req_h_trial.setPassword();
        req_h_trial.setUsername();*/
        Req_h_trial req_h_trial = new Req_h_trial();
        req_h_trial.setUsername(username);
        req_h_trial.setPassword(password);
        final String param = new Gson().toJson(req_h_trial);
        PerfectHttp.createService(PandingService.class).h_trial(param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<H_trial>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mActivity, "操作失败，请检测网络连接", Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onNext(H_trial h_trial) {
                        if (h_trial.getErrcode() == 0) {
                            Toast.makeText(mActivity, h_trial.getMsg(), Toast.LENGTH_SHORT);
                            loginControl(username, password);
                        } else {
                            Toast.makeText(mActivity, h_trial.getMsg(), Toast.LENGTH_SHORT);
                        }
                    }
                });
    }

    /**
     * 激活
     */
    private void activate() {
        /*Intent intent = new Intent(this, ActivateActivity.class);
        intent.putExtra("username", username);
        startActivityForResult(intent, RequestCode);*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
