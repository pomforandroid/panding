package com.panding.main.pdservice.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.panding.main.Base.BaseContentragment;
import com.panding.main.R;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PdPerfectHttp;
import com.panding.main.perfecthttp.request.Req_pd_remind_get;
import com.panding.main.perfecthttp.request.Req_pd_vip_get;
import com.panding.main.perfecthttp.response.Pd_remind_get;
import com.panding.main.perfecthttp.response.Pd_vip_get;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CareCarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CareCarFragment extends BaseContentragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Unbinder unbinder;
    @BindView(R.id.goback)
    ImageView goback;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_vip_point)
    TextView tvVipPoint;
    @BindView(R.id.tv_baoyangtime)
    TextView tvBaoyangtime;
    @BindView(R.id.tv_nianshentime)
    TextView tvNianshentime;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Subscription subscribe;


    public CareCarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CareCarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CareCarFragment newInstance(String param1, String param2) {
        CareCarFragment fragment = new CareCarFragment();
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
        View view = inflater.inflate(R.layout.fragment_care_car, container, false);
        unbinder = ButterKnife.bind(this, view);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popStack();
            }
        });
        //初始化数据
        initData();
        return view;
    }

    private void initData() {
        String pdPassword = getPDPassword();
        String pdUsername = getPDUsername();
        tvUsername.setText(pdUsername);

        //会员信息参数
        Req_pd_vip_get req_pd_vip_get = new Req_pd_vip_get();
        req_pd_vip_get.setPassword(pdPassword);
        req_pd_vip_get.setUsername(pdUsername);
        String vipget_param = new Gson().toJson(req_pd_vip_get);
        //提醒信息参数
        final Req_pd_remind_get req_pd_remind_get = new Req_pd_remind_get();
        req_pd_remind_get.setUsername(pdUsername);
        req_pd_remind_get.setPassword(pdPassword);
        String remind_param = new Gson().toJson(req_pd_remind_get);

        Observable<Pd_remind_get> pd_remind_getObservable = PdPerfectHttp.createService(PandingService.class)
                .pd_remind_get(remind_param);

        Observable<Pd_vip_get> pd_vip_getObservable = PdPerfectHttp.createService(PandingService.class)
                .pd_vip_get(vipget_param);

        subscribe = Observable.merge(pd_remind_getObservable, pd_vip_getObservable)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Object o) {
                        if (o instanceof Pd_vip_get) {
                            Pd_vip_get pd_vip_get = (Pd_vip_get) o;
                            if (pd_vip_get.getErrcode() == 0) {
                                tvVipPoint.setText(pd_vip_get.getUsePoint());
                            }
                        }
                        if (o instanceof Pd_remind_get) {
                            Pd_remind_get pd_remind_get = (Pd_remind_get) o;
                            if (pd_remind_get.getErrcode() == 0) {
                                tvNianshentime.setText(pd_remind_get.getNextYear() + "年" + pd_remind_get.getNextMonth() + "月");
                                tvBaoyangtime.setText(pd_remind_get.getNextTime());
                            }
                        }
                    }
                });
    }

    private void stopInitData(){
        if (subscribe != null) {
            if (subscribe != null) {
                if (!subscribe.isUnsubscribed()) {
                    subscribe.unsubscribe();
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        stopInitData();
        unbinder.unbind();
    }
}
