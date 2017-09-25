package com.panding.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PdPerfectHttp;
import com.panding.main.perfecthttp.request.Req_Pd_login;
import com.panding.main.perfecthttp.response.Pd_login;

import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.internal.operators.OnSubscribePublishMulticast;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity implements TextWatcher {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.et_username)
    MaterialEditText etUsername;
    @BindView(R.id.et_password)
    MaterialEditText etPassword;
    @BindView(R.id.login)
    Button login;
    private Subscription subscribe;
    private SweetAlertDialog pDialog;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private static final String PDUSER = "pdusername";
    private static final String PDPWD = "pdpassward";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //记录用户名，密码
        sharedPreferences = getSharedPreferences("pdlogin", Context.MODE_PRIVATE);
        //设置输入框监听，内容都不为空才能点击按钮
        login.setEnabled(false);
        etPassword.addTextChangedListener(this);
        etUsername.addTextChangedListener(this);

        String username = sharedPreferences.getString(PDUSER, "");
        String password = sharedPreferences.getString(PDPWD, "");
        if(!TextUtils.isEmpty(username)){
            etUsername.setText(username);
        }
        if(!TextUtils.isEmpty(password)){
            etPassword.setText(password);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginControl();
            }
        });

    }

    /**
     * 登录控制
     */
    private void loginControl(){
        //等待框
        pDialog = new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
        pDialog.setTitleText("登录中...");
        pDialog.setCancelable(false);
        pDialog.show();
        //请求登录参数
        final String password = etPassword.getText().toString();
        final String username = etUsername.getText().toString();
        Req_Pd_login req_pd_login = new Req_Pd_login();
        req_pd_login.setPassword(password);
        req_pd_login.setUsername(username);
        String param = new Gson().toJson(req_pd_login);

        //记住用户名

        editor = sharedPreferences.edit();
        editor.putString(PDUSER,username);
        editor.commit();
        //请求登录
        subscribe = PdPerfectHttp.createService(PandingService.class).pd_login(param)
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Pd_login>() {
                    @Override
                    public void onCompleted() {
                        pDialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        pDialog.dismiss();
                        Intent intent = new Intent(LoginActivity.this, VerifyActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onNext(Pd_login pd_login) {
                        if(pd_login.getErrcode()==0){
                            editor = sharedPreferences.edit();
                            editor.putString(PDUSER,username);
                            editor.putString(PDPWD,password);
                            editor.commit();

                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        else if(pd_login.getErrcode()==102){
                            editor = sharedPreferences.edit();
                            editor.putString(PDUSER,username);
                            editor.putString(PDPWD,password);
                            editor.commit();
                            //手机未验证
                            Intent intent = new Intent(LoginActivity.this, VerifyActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, pd_login.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!TextUtils.isEmpty(etPassword.getText().toString())
                && !TextUtils.isEmpty(etUsername.getText().toString())) {
            login.setEnabled(true);
        } else {
            login.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscribe != null) {
            if (subscribe != null) {
                if (!subscribe.isUnsubscribed()) {
                    subscribe.unsubscribe();
                }
            }
        }
    }
}
