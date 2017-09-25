package com.panding.main.swzgps.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import com.borax12.materialdaterangepicker.time.TimePickerDialog;
import com.google.gson.Gson;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.panding.main.Base.BaseContentragment;
import com.panding.main.Base.BaseUtils;
import com.panding.main.R;
import com.panding.main.application.GetAppUtils;
import com.panding.main.application.MapKeyApplication;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PerfectHttp;
import com.panding.main.perfecthttp.request.Req_hfence_postbind;
import com.panding.main.perfecthttp.response.Hfence_get;
import com.panding.main.perfecthttp.response.Hfence_postbind;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FenceBindFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FenceBindFragment extends BaseContentragment implements TimePickerDialog.OnTimeSetListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM = "areaBean";
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mapView)
    MapView mMapView;
    @BindView(R.id.bt_bind)
    Button btBind;
    Unbinder unbinder;

    private BaiduMap mBaiduMap;
    private String type;
    private String hourstart;
    private String minstart;
    private String hourend;
    private String minsend;
    private EditText et_time;

    // TODO: Rename and change types of parameters
    private Hfence_get.AreaBean areaBean;
    private Subscription subscribe;


    public FenceBindFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FenceBindFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FenceBindFragment newInstance(Hfence_get.AreaBean areaBean) {
        FenceBindFragment fragment = new FenceBindFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM, areaBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            areaBean = getArguments().getParcelable(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fence_bind, container, false);
        unbinder = ButterKnife.bind(this, view);
        toolbarTitle.setText("电子围栏" + areaBean.getAreaName());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            popStack();
            }
        });

        mBaiduMap = mMapView.getMap();
        //地图加载完成
        mBaiduMap.setOnMapLoadedCallback(new BaiduMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                List<Hfence_get.AreaBean.PosListBean> posList = areaBean.getPosList();
                List<LatLng> pts = new ArrayList<LatLng>();
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (Hfence_get.AreaBean.PosListBean pos: posList){
                    LatLng latLng = BaseUtils.MarsTransToBaidu(pos.getX(), pos.getY());
                    pts.add(latLng);
                    builder.include(latLng);
                }

                OverlayOptions polygonOption = new PolygonOptions()
                        .points(pts)
                        .stroke(new Stroke(5, 0xAA2e2efe))
                        .fillColor(0xAAa7dfff);
                //在地图上添加多边形Option，用于显示
                mBaiduMap.addOverlay(polygonOption);

                mBaiduMap.setMapStatus(MapStatusUpdateFactory
                        .newLatLngBounds(builder.build()));
            }
        });

        //绑定按钮
        btBind.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ViewHolder contentView = new ViewHolder(R.layout.dialog_bind_fence);
                final DialogPlus dialog = DialogPlus.newDialog(mActivity)
                        .setContentHolder(contentView)
                        .setGravity(Gravity.CENTER)
                        .setCancelable(true)
                        .setContentWidth(560)
                        .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                        .setContentBackgroundResource(R.drawable.dialog_background)
                        .create();

                View holderView = dialog.getHolderView();
                RadioGroup radioGroup = (RadioGroup) holderView.findViewById(R.id.radioGroup);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        //RadioButton radioButton = (RadioButton) findViewById(checkedId);
                        switch (checkedId){
                            case R.id.in:
                                type = "int";
                                break;
                            case R.id.out:
                                type = "out";
                                break;
                        }
                    }
                });
                et_time = (EditText) holderView.findViewById(R.id.et_time);
                et_time.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //选择时间
                        selectTime();
                    }
                });

                holderView.findViewById(R.id.ll_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                holderView.findViewById(R.id.ll_comfirm).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(TextUtils.isEmpty(hourstart)){
                            Toast.makeText(mActivity,"时间范围不能为空",Toast.LENGTH_SHORT)
                                    .show();
                            return;
                        }
                        if(TextUtils.isEmpty(type)){
                            Toast.makeText(mActivity,"绑定类型不能为空",Toast.LENGTH_SHORT)
                                    .show();
                            return;
                        }

                        String areaName = areaBean.getAreaName();
                        Req_hfence_postbind req_hfence_postbind = new Req_hfence_postbind();
                        req_hfence_postbind.setAreaName(areaName);
                        req_hfence_postbind.setBt(hourstart);
                        req_hfence_postbind.setBtMin(minstart);

                        req_hfence_postbind.setType(type);
                        req_hfence_postbind.setEt(hourend);
                        req_hfence_postbind.setEtMin(hourstart);

                        MapKeyApplication application = (MapKeyApplication) getApplication();
                        String carLicenseNum = application.getLoginHSingle().getCarLicenseNum();
                        String objectId = application.getLoginHSingle().getObjectId();
                        req_hfence_postbind.setSelCar("|"+objectId+","+carLicenseNum);
                        req_hfence_postbind.setSelTeam("");
                        String userID = GetAppUtils.getUserID(application);
                        req_hfence_postbind.setUserId(userID);

                        String param = new Gson().toJson(req_hfence_postbind);
                        subscribe = PerfectHttp.createService(PandingService.class).hfence_postbind(param)
                                .subscribeOn(Schedulers.io())
                                .unsubscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<Hfence_postbind>() {
                                    @Override
                                    public void onCompleted() {

                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        Toast.makeText(mActivity, "error", Toast.LENGTH_SHORT)
                                                .show();
                                    }

                                    @Override
                                    public void onNext(Hfence_postbind hfence_postbind) {
                                        if (hfence_postbind.getErrcode() == 0) {
                                            type = "";
                                            hourstart = "";
                                            Toast.makeText(mActivity, hfence_postbind.getMsg(), Toast.LENGTH_SHORT)
                                                    .show();
                                            dialog.dismiss();
                                            popStack();
                                        } else {
                                            Toast.makeText(mActivity, hfence_postbind.getMsg(), Toast.LENGTH_SHORT)
                                                    .show();
                                        }
                                    }
                                });
                    }
                });
                dialog.show();

            }
        });

        return view;
    }

    private void stopSub(){
        if (subscribe != null) {
            if (subscribe != null) {
                if (!subscribe.isUnsubscribed()) {
                    subscribe.unsubscribe();
                }
            }
        }
    }
    /**
     * 选择时间
     */
    private void selectTime(){
        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(
                FenceBindFragment.this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                false
        );
        tpd.setTabIndicators("开始时间","结束时间");
        tpd.show(mActivity.getFragmentManager(), "Timepickerdialog");

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        stopSub();
        mMapView.onDestroy();
        unbinder.unbind();
    }
    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int hourOfDayEnd, int minuteEnd) {
        if(hourOfDay>hourOfDayEnd){
            Toast.makeText(mActivity,"开始时间不能大于结束时间",Toast.LENGTH_SHORT).show();
        }
        hourstart = String.valueOf(hourOfDay);
        minstart = String.valueOf(minute);

        hourend = String.valueOf(hourOfDayEnd);
        minsend = String.valueOf(minuteEnd);

        et_time.setText(hourstart+":"+minstart+"至"+hourend+":"+minsend);

    }

}
