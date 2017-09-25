package com.panding.main;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.panding.main.Base.BaseFragment;
import com.panding.main.pdinterface.OnStepListener;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PdPerfectHttp;
import com.panding.main.perfecthttp.PerfectHttp;
import com.panding.main.perfecthttp.request.Req_pd_login_check;
import com.panding.main.perfecthttp.request.Req_pd_login_post;
import com.panding.main.perfecthttp.response.Pd_login_check;
import com.panding.main.perfecthttp.response.Pd_login_post;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VerifyStepFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VerifyStepFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM = "layout";
    private static final String PDUSER = "pdusername";
    private static final String PDPWD = "pdpassward";
    private static final String PDPHONE ="pdphone";
    // TODO: Rename and change types of parameters
    private int mParam;
    private SharedPreferences sharedPreferences;
    private String username;
    private String password;

    public VerifyStepFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment VerifyStepFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VerifyStepFragment newInstance(int mParam) {
        VerifyStepFragment fragment = new VerifyStepFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM,mParam);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getInt(ARG_PARAM);
        }
        sharedPreferences = getSharedPreferences("pdlogin", Context.MODE_PRIVATE);

        username = sharedPreferences.getString(PDUSER, "");
        password = sharedPreferences.getString(PDPWD, "");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(mParam, container, false);
        // Inflate the layout for this fragment
        switch (mParam){
            case R.layout.fragment_verify_step1:
                dealStep1(view);
                break;
            case R.layout.fragment_verify_step2:
                dealStep2(view);
                break;
            case R.layout.fragment_verify_step3:
                dealStep3(view);
                break;
        }
        return view;
    }

    private void dealStep3(View view){
        Button button = (Button) view.findViewById(R.id.bt_step3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mlistener!=null){
                    mlistener.goStep(2,true);
                }
            }
        });
    }

    private void dealStep2(View view){
        Button bt_step2 = (Button) view.findViewById(R.id.bt_step2);
        EditText etCode = (EditText) view.findViewById(R.id.et_code);
        Button resendCode = (Button) view.findViewById(R.id.bt_resendcode);
        //验证验证码
        bt_step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = sharedPreferences.getString(PDPHONE, "");
                Req_pd_login_post req_pd_login_post = new Req_pd_login_post();
                req_pd_login_post.setMobile(phone);
                req_pd_login_post.setUsername(username);
                req_pd_login_post.setPassword(password);
                String param = new Gson().toJson(req_pd_login_post);
                if(checkSms()){
                    PdPerfectHttp.createService(PandingService.class).pd_login_post(param)
                            .subscribeOn(Schedulers.io())
                            .unsubscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<Pd_login_post>() {
                                @Override
                                public void onCompleted() {

                                }

                                @Override
                                public void onError(Throwable e) {

                                }

                                @Override
                                public void onNext(Pd_login_post pd_login_post) {
                                    if(pd_login_post.getErrcode()==0){
                                        if(mlistener!=null){
                                            mlistener.goStep(1,true);
                                        }
                                    }
                                }
                            });
                }

            }
        });

        resendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    /**
     * 检查code
     * @return
     */
    private boolean checkSms() {
        return true;
    }


    /**
     * 处理步骤1
     * @param view
     */
    private void dealStep1(final View view){
        Button bt_step1 = (Button) view.findViewById(R.id.bt_step1);
        final EditText etphonenum = (EditText) view.findViewById(R.id.et_phonenum);

        bt_step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog("请稍等...");
                final String phonenum = etphonenum.getText().toString();
                Req_pd_login_check req_pd_login_check = new Req_pd_login_check();
                req_pd_login_check.setUsername(username);
                req_pd_login_check.setPassword(password);
                req_pd_login_check.setMobile(phonenum);
                String param = new Gson().toJson(req_pd_login_check);

                PdPerfectHttp.createService(PandingService.class).pd_login_check(param)
                        .unsubscribeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Pd_login_check>() {
                            @Override
                            public void onCompleted() {
                                dismissDialog();
                            }

                            @Override
                            public void onError(Throwable e) {
                                dismissDialog();
                                mlistener.goStep(0,false);
                            }

                            @Override
                            public void onNext(Pd_login_check pd_login_check) {
                                if(pd_login_check.getErrcode()==0){
                                    sharedPreferences.edit().putString(PDPHONE,phonenum).commit();
                                    Toast.makeText(mActivity, pd_login_check.getMsg(), Toast.LENGTH_SHORT).show();
                                    mlistener.goStep(0,true);
                                }else{
                                    Toast.makeText(mActivity, pd_login_check.getMsg(), Toast.LENGTH_SHORT).show();
                                    mlistener.goStep(0,false);
                                }
                            }
                        });
            }
        });


    }


    private OnStepListener mlistener;

    public void setOnStepListener(OnStepListener mlistener) {
        this.mlistener = mlistener;
    }
}
