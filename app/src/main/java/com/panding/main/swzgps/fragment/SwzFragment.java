package com.panding.main.swzgps.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Text;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.google.gson.Gson;
import com.panding.main.Base.BaseContentragment;
import com.panding.main.Base.BaseUtils;
import com.panding.main.R;
import com.panding.main.application.GetAppUtils;
import com.panding.main.application.MapKeyApplication;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PerfectHttp;
import com.panding.main.perfecthttp.request.Req_Bd_client_control;
import com.panding.main.perfecthttp.request.Req_Bd_info_get;
import com.panding.main.perfecthttp.request.Req_H_Location_last;
import com.panding.main.perfecthttp.request.Req_H_client_control;
import com.panding.main.perfecthttp.request.Req_bd_location_last;
import com.panding.main.perfecthttp.request.Req_control_func;
import com.panding.main.perfecthttp.request.Req_h_status;
import com.panding.main.perfecthttp.response.Bd_client_control;
import com.panding.main.perfecthttp.response.Bd_info_get;
import com.panding.main.perfecthttp.response.Bd_location_last;
import com.panding.main.perfecthttp.response.Control_func;
import com.panding.main.perfecthttp.response.H_Client_control;
import com.panding.main.perfecthttp.response.H_Location_last;
import com.panding.main.perfecthttp.response.H_status;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.pedant.SweetAlert.SweetAlertDialog;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SwzFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SwzFragment extends BaseContentragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_VEHICLE = "vehicletype";

    @BindView(R.id.tv_carnum)
    TextView tvCarnum;
    @BindView(R.id.tv_milleage)
    TextView tvMilleage;
    @BindView(R.id.tv_voltage)
    TextView tvVoltage;
    Unbinder unbinder;
    @BindView(R.id.bmapView)
    MapView mMapView;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_gpstime)
    TextView tvGpstime;
    @BindView(R.id.iv_carstate)
    ImageView ivCarstate;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.ll_unlock)
    LinearLayout llUnlock;
    @BindView(R.id.ll_lock)
    LinearLayout llLock;
    @BindView(R.id.ll_location)
    LinearLayout llLocation;
    @BindView(R.id.tv_history)
    TextView tvHistory;
    @BindView(R.id.tv_fence)
    TextView tvFence;

    // TODO: Rename and change types of parameters
    private String vehiclegroup;

    private Subscription subscribe;
    private BaiduMap mBaiduMap;
    private GeoCoder mSearch;
    private Marker mMarker;
    BitmapDescriptor refreshloacte = BitmapDescriptorFactory.fromResource(R.drawable.refreshlocate);
    private MarkerOptions option;

    private static final String SETALARMO = "SETALARMON";//  设防
    private static final String SETALARMOFF = "SETALARMOFF";//解防

    private static final String BDShefang = "S12";//  设防
    private static final String BDJieFang = "S13";//解防

    private int guard = -1; //初始化为1
    private int recordGuard;
    private int refreshCount;
    private String bdguardCode;
    private String bdrecordguradcode;


    /**
     * 在hide show这种模式下处理，数据刷新和停止，下面三个方法缺一不可
     *
     * @param hidden
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            stopUpdateData();
        } else {
            startUpdateData(0, 15, false);
        }
    }

    @Override
    public void onResume() {

        if (!getFragmentManager().findFragmentByTag(this.getClass().getName()).isHidden()) {
            //startUpdateData(startTime, refreshTime);
            startUpdateData(0, 15, false);
        } else {

        }
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
        stopUpdateData();
    }


    public SwzFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment SwzFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SwzFragment newInstance(String vehiclegroup) {
        SwzFragment fragment = new SwzFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_VEHICLE, vehiclegroup);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            vehiclegroup = getArguments().getString(ARG_PARAM_VEHICLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_swz, container, false);
        unbinder = ButterKnife.bind(this, view);

        mBaiduMap = mMapView.getMap();
        mMapView.showZoomControls(false);
        mMapView.showScaleControl(false);
        mSearch = GeoCoder.newInstance();

        option = new MarkerOptions()
                .position(BaseUtils.gpsTranstoBaidu(0, 0))
                .icon(refreshloacte)
                .anchor(0.5f, 0.5f
                ).rotate(0);
        mMarker = (Marker) (mBaiduMap.addOverlay(option));
        mMarker.setIcon(refreshloacte);
        mMarker.setRotate(0);


        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
//                mMarker.setVisible();
                //创建InfoWindow展示的view
                if (marker == mMarker) {
                    stopUpdateData();
                    startUpdateData(0, 15, false);
                }
                return true;
            }
        });

        llLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocationFragment locationFragment = LocationFragment.newInstance(vehiclegroup);
                pushStack(locationFragment);
            }
        });
        tvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HistoryFragment historyFragment = HistoryFragment.newInstance(vehiclegroup);
                pushStack(historyFragment);
            }
        });

        tvFence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.equals(vehiclegroup,"H")){
                    //h平台
                    HFenceFragment hFenceFragment = HFenceFragment.newInstance();
                    pushStack(hFenceFragment);
                }else if(TextUtils.equals(vehiclegroup,"BD")){
                    BdFenceFragment bdFenceFragment = BdFenceFragment.newInstance().newInstance();
                    pushStack(bdFenceFragment);
                }

            }
        });

        startUpdateData(0, 15, false);
        return view;
    }

    /**
     * 开始15秒更新一次
     * --> 先获得远程控制列表判断是否有设防解防和远程控制等
     * --> 再获得离线状态
     * --> 再开始轮询（间隔多少秒）
     * --> 开始获取数据
     *
     * @param start     隔多少秒开始
     * @param second    间隔秒数
     * @param isRefresh 是否刷新设防解防的状态
     */
    private void startUpdateData(final long start, final long second, final boolean isRefresh) {
        //h平台
        if(TextUtils.equals(vehiclegroup,"H")){
            h_updateData(start,second,isRefresh);
        }
        //bd平台
        else if(TextUtils.equals(vehiclegroup,"BD")){
            bd_updateData(start,second,isRefresh);
        }
    }

    /**
     * h平台的更新数据
     * @param start
     * @param second
     * @param isRefresh
     */
    private void h_updateData(final long start, final long second, final boolean isRefresh){
        //请求远程控制列表参数
        String termanalNum = GetAppUtils.getTermanalNum((MapKeyApplication) getApplication());
        Req_control_func req_control_func = new Req_control_func();
        req_control_func.setTerminalNum(termanalNum);
        String param = new Gson().toJson(req_control_func);

        //请求在线，离线状态参数
        Req_h_status req_h_status = new Req_h_status();
        String objectId = GetAppUtils.getObjectID((MapKeyApplication) getApplication());
        req_h_status.setObjectId(objectId);
        final String h_status_param = new Gson().toJson(req_h_status);

        //请求最后一条轨迹信息的参数
        String carLicenseNum = GetAppUtils.getCarnum((MapKeyApplication) getApplication());
        Req_H_Location_last req_H_location_last = new Req_H_Location_last();
        req_H_location_last.setVehicleNum(carLicenseNum);
        req_H_location_last.setObjectId(objectId);
        final String h_Location_last_param = new Gson().toJson(req_H_location_last);

        // -->先获得远程控制列表判断是否有设防解防和远程控制等
        //--> 再获得离线状态
        //--> 再开始轮询（间隔多少秒）
        //获得最后一条轨迹数据
        //指定下面的retrywhen 在主线程
        //出错后过5秒重新订阅
        subscribe = PerfectHttp.createService(PandingService.class).control_func(param) // -->先获得远程控制列表判断是否有设防解防和远程控制等
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .flatMap(new Func1<Control_func, Observable<H_status>>() {
                    @Override
                    public Observable<H_status> call(Control_func control_func) {
                        //检查h平台是否有远程控制
                        checkControlfunc(control_func);
                        Observable<H_status> h_statusObservable = PerfectHttp.createService(PandingService.class).h_status(h_status_param);//--> 再获得离线状态
                        return h_statusObservable;
                    }
                })
                .flatMap(new Func1<H_status, Observable<Long>>() {
                    @Override
                    public Observable<Long> call(H_status h_status) {
                        //检查车辆离线状态
                        checkCarIsOff(h_status);
                        Observable<Long> interval = Observable.interval(start, second, TimeUnit.SECONDS);//--> 再开始轮询（间隔多少秒）
                        return interval;
                    }
                })
                .flatMap(new Func1<Long, Observable<H_Location_last>>() {
                    @Override
                    public Observable<H_Location_last> call(Long aLong) {
                        Observable<H_Location_last> h_location_lastObservable =
                                PerfectHttp.createService(PandingService.class)
                                        .h_location_last(h_Location_last_param); //获得最后一条轨迹数据
                        return h_location_lastObservable;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()) //指定下面的retrywhen 在主线程
                //出错后过5秒重新订阅
                .retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
                    @Override
                    public Observable<?> call(Observable<? extends Throwable> observable) {
                        return observable.flatMap(new Func1<Throwable, Observable<?>>() {
                            @Override
                            public Observable<?> call(Throwable throwable) {
                                return Observable.timer(5, TimeUnit.SECONDS);
                            }
                        });
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<H_Location_last>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(H_Location_last h_location_last) {
                        if (h_location_last.getErrcode() == 0) {
                            //Toast.makeText(mActivity,"你成功在刷新了，加油",Toast.LENGTH_SHORT).show();
                            //基本信息显示
                            tvCarnum.setText(h_location_last.getVehicle_num());
                            tvMilleage.setText(h_location_last.getMileage());
                            tvVoltage.setText(h_location_last.getVol() + "v");
                            tvGpstime.setText(h_location_last.getGps_time());
                            //位置信息，和刷新定位的按钮
                            double lat = h_location_last.getLat();
                            double lon = h_location_last.getLon();
                            LatLng baiduPoint = BaseUtils.gpsTranstoBaidu(lat, lon);
                            MapStatus.Builder builder = new MapStatus.Builder();
                            builder.target(baiduPoint);
                            builder.zoom(18.0f);
                            mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                            showLocation(baiduPoint);
                            showMarker(baiduPoint);
                            //车辆状态 设防解防
                            guard = h_location_last.getGuard();
                            switch (guard) {
                                case 0:
                                    break;
                                case 1:
                                    //运动设防，手动
                                    ivCarstate.setImageResource(R.drawable.carstate_sportlock_manual);
                                    break;
                                case 2:
                                    //运动设防，自动
                                    ivCarstate.setImageResource(R.drawable.carstate_sportlock_auto);
                                    break;
                                case 3:
                                    //运动解防
                                    ivCarstate.setImageResource(R.drawable.carstate_sportunlock);
                                    break;
                                case 4:
                                    //静止设防（手动）
                                    ivCarstate.setImageResource(R.drawable.carstate_staticlock_manual);
                                    break;
                                case 5:
                                    //静止设防（自动）
                                    ivCarstate.setImageResource(R.drawable.carstate_staticlock_auto);
                                    break;
                                case 6:
                                    //静止解防
                                    ivCarstate.setImageResource(R.drawable.carstate_staticunlock);
                                    break;
                                default:
                                    break;
                            }
                            //当刷新状态为true时
                            if (isRefresh) {
                                refreshCount++; // 累计刷新次数，到10就结束
                                //状态改变，即可结束
                                if (guard != recordGuard) {
                                    stopUpdateData();
                                    startUpdateData(15, 15, false);
                                }
                                if (refreshCount == 10) {
                                    stopUpdateData();
                                    startUpdateData(15, 15, false);
                                    //失败提示
                                    new SweetAlertDialog(mActivity, SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("提示!")
                                            .setContentText("指令执行失败")
                                            .setConfirmText("确定")
                                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                @Override
                                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                    sweetAlertDialog.dismiss();
                                                }
                                            })
                                            .show();
                                }
                            }
                        }
                    }
                });
    }


    /**
     * bd平台的更新数据
     * @param start
     * @param second
     * @param isRefresh
     */
    private void bd_updateData(final long start, final long second, final boolean isRefresh){

        MapKeyApplication application = (MapKeyApplication) getApplication();
        tvCarnum.setText(GetAppUtils.getCarnum(application));
        //请求远程控制列表参数
        String termanalNum = GetAppUtils.getTermanalNum(application);
        Req_control_func req_control_func = new Req_control_func();
        req_control_func.setTerminalNum(termanalNum);
        String param = new Gson().toJson(req_control_func);


        //请求在线，离线状态参数
        final Req_Bd_info_get req_bd_info_get = new Req_Bd_info_get();
        String username = application.getUsername();
        String password = application.getPassword();
        req_bd_info_get.setUsernum(username);
        req_bd_info_get.setPassword(password);
        final String req_bd_info_get_param = new Gson().toJson(req_bd_info_get);

        //请求最后一条轨迹信息的参数
        Req_bd_location_last req_bd_location_last = new Req_bd_location_last();
        req_bd_location_last.setPassword(password);
        req_bd_location_last.setUsernum(username);
        final String bd_Location_last_param = new Gson().toJson(req_bd_location_last);

        // -->先获得远程控制列表判断是否有设防解防和远程控制等
        //--> 再获得离线状态
        //--> 再开始轮询（间隔多少秒）
        //获得最后一条轨迹数据
        //指定下面的retrywhen 在主线程
        //出错后过5秒重新订阅
        subscribe = PerfectHttp.createService(PandingService.class).control_func(param) // -->先获得远程控制列表判断是否有设防解防和远程控制等
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .flatMap(new Func1<Control_func, Observable<Bd_info_get>>() {
                    @Override
                    public Observable<Bd_info_get> call(Control_func control_func) {
                        //检查bd平台是否有远程控制
                        checkControlfunc(control_func);
                        Observable<Bd_info_get> bd_info_getObservable = PerfectHttp.createService(PandingService.class).bd_info_get(req_bd_info_get_param);//--> 再获得离线状态
                        return bd_info_getObservable;
                    }
                })
                .flatMap(new Func1<Bd_info_get, Observable<Long>>() {
                    @Override
                    public Observable<Long> call(Bd_info_get bdInfoGet) {
                        //检查车辆离线状态
                        checkBdCarIsOff(bdInfoGet);
                        Observable<Long> interval = Observable.interval(start, second, TimeUnit.SECONDS);//--> 再开始轮询（间隔多少秒）
                        return interval;
                    }
                })
                .flatMap(new Func1<Long, Observable<Bd_location_last>>() {
                    @Override
                    public Observable<Bd_location_last> call(Long aLong) {
                        Observable<Bd_location_last> h_location_lastObservable =
                                PerfectHttp.createService(PandingService.class)
                                        .bd_location_last(bd_Location_last_param); //获得最后一条轨迹数据
                        return h_location_lastObservable;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()) //指定下面的retrywhen 在主线程
                //出错后过5秒重新订阅
                .retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
                    @Override
                    public Observable<?> call(Observable<? extends Throwable> observable) {
                        return observable.flatMap(new Func1<Throwable, Observable<?>>() {
                            @Override
                            public Observable<?> call(Throwable throwable) {
                                return Observable.timer(5, TimeUnit.SECONDS);
                            }
                        });
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bd_location_last>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bd_location_last bdlocationlast) {
                        if (bdlocationlast.getErrcode() == 0) {
                            //Toast.makeText(mActivity,"你成功在刷新了，加油",Toast.LENGTH_SHORT).show();
                            //基本信息显示
                            tvMilleage.setText(bdlocationlast.getMileage()+"km");
                            tvVoltage.setText(bdlocationlast.getVol() + "v");
                            tvGpstime.setText(bdlocationlast.getCretattime());
                            //位置信息，和刷新定位的按钮
                            double lat =Double.parseDouble(bdlocationlast.getLat());
                            double lon = Double.parseDouble(bdlocationlast.getLng());
                            LatLng baiduPoint = BaseUtils.gpsTranstoBaidu(lat, lon);
                            MapStatus.Builder builder = new MapStatus.Builder();
                            builder.target(baiduPoint);
                            builder.zoom(18.0f);
                            mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                            showLocation(baiduPoint);
                            showMarker(baiduPoint);
                            //车辆状态 设防解防
                            bdguardCode = bdlocationlast.getGuardCode();
                            switch (bdguardCode) {

                                case "000":
                                    //静止解防
                                    ivCarstate.setImageResource(R.drawable.carstate_staticunlock);
                                    break;
                                case "100":
                                    //运动解防
                                    ivCarstate.setImageResource(R.drawable.carstate_sportunlock);
                                    break;
                                case "010":
                                    //静止设防（自动）
                                    ivCarstate.setImageResource(R.drawable.carstate_staticlock_auto);

                                    break;
                                case "011":
                                    //静止设防（手动）
                                    ivCarstate.setImageResource(R.drawable.carstate_staticlock_manual);
                                    break;
                                case "110":
                                    //运动设防，自动
                                    ivCarstate.setImageResource(R.drawable.carstate_sportlock_auto);
                                    break;
                                case "111":
                                    //运动设防，手动
                                    ivCarstate.setImageResource(R.drawable.carstate_sportlock_manual);
                                    break;
                                default:
                                    break;
                            }
                            //当刷新状态为true时
                            if (isRefresh) {
                                refreshCount++; // 累计刷新次数，到10就结束
                                //状态改变，即可结束
                                if (!TextUtils.equals(bdguardCode,bdrecordguradcode)){
                                    stopUpdateData();
                                    startUpdateData(15, 15, false);
                                }
                                if (refreshCount == 10) {
                                    stopUpdateData();
                                    startUpdateData(15, 15, false);
                                    //失败提示
                                    new SweetAlertDialog(mActivity, SweetAlertDialog.ERROR_TYPE)
                                            .setTitleText("提示!")
                                            .setContentText("指令执行失败")
                                            .setConfirmText("确定")
                                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                @Override
                                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                                    sweetAlertDialog.dismiss();
                                                }
                                            })
                                            .show();
                                }
                            }
                        }
                    }
                });
    }


    /**
     * 检查是否有设防解防的功能
     *
     * @param control_func
     */
    private void checkControlfunc(Control_func control_func) {
        if (control_func.getErrcode() == 0) {
            int total = control_func.getTotal();
            if (total > 0) {
                List<Control_func.FuncListBean> funcList = control_func.getFuncList();
                //判断有没有设防解防功能,没有的话，设防解防这些都不显示，静止解防这些都不显示
                //默认运动的图标
                for (Control_func.FuncListBean fl : funcList) {
                    if (TextUtils.equals(fl.getButtonCode(), "HSETALARM")
                            ||TextUtils.equals(fl.getButtonCode(), "BDSETALARM")) {
                        llLock.setOnClickListener(SwzFragment.this);
                        llUnlock.setOnClickListener(SwzFragment.this);
                    }

                }
            }
        }
    }

    /**
     * 检查H车辆是否在线
     */
    private void checkCarIsOff(H_status h_status) {
        if (h_status.getErrcode() == 0) {
            String carStatus = h_status.getCarStatus();
            //是否离线
            if (TextUtils.equals("未上线", carStatus)) {
                ivCarstate.setImageResource(R.drawable.carstate_off);
            }
        }
    }

    /**
     * 检查bd车辆是否在线
     * @param bdInfoGet
     */
    private void checkBdCarIsOff(Bd_info_get bdInfoGet) {
        if(bdInfoGet.getErrcode()==0){
            //离线
            if(bdInfoGet.getCzhuangtai()==0){
                ivCarstate.setImageResource(R.drawable.carstate_off);
            }
        }
    }

    /**
     * 更新位置信息，textview
     *
     * @param baiduPoint
     */
    private void showLocation(LatLng baiduPoint) {

        mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(baiduPoint));// 搜索地址
        mSearch.setOnGetGeoCodeResultListener(addresslistener);
    }

    /**
     * 地址监听
     */
    OnGetGeoCoderResultListener addresslistener = new OnGetGeoCoderResultListener() {
        public void onGetGeoCodeResult(GeoCodeResult result) {
            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                // 没有检索到结果
            }
        }

        @Override
        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
            String address = "";
            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                // 没有找到检索结果

            } else {
                address = result.getAddress();
            }
            if (!TextUtils.isEmpty(address)) {
                if(tvLocation!=null){
                    tvLocation.setText(address);
                }
            }

        }
    };

    /**
     * 显示InfoWindow
     *
     * @param baiduPoint
     */
    private void showMarker(LatLng baiduPoint) {
        //创建InfoWindow , 传入 view， 地理坐标， y 轴偏移量
        mMarker.setPosition(baiduPoint);
    }

    /**
     * 停止更新
     */
    private void stopUpdateData() {
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
        stopUpdateData();
        mMapView.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_unlock:
                unlock();
                break;
            case R.id.ll_lock:
                lock();
                break;
        }
    }

    /**
     * 设防
     */
    private void lock() {
        //h平台设防
        if(TextUtils.equals(vehiclegroup,"H")){
            //1245,都是设防的，就不不要再设防了
            if (guard == 1 || guard == 2 || guard == 4 || guard == 5) {
                Toast.makeText(mActivity, "车辆已处于设防状态", Toast.LENGTH_SHORT).show();
                return;
            }

            MapKeyApplication application = (MapKeyApplication) mActivity.getApplication();
            Req_H_client_control req_H_client_control = new Req_H_client_control();
            req_H_client_control.setTerminalNum(GetAppUtils.getTermanalNum(application));
            req_H_client_control.setCarNo(application.getLoginHSingle().getCarLicenseNum());
            req_H_client_control.setCode(SETALARMO);
            String param = new Gson().toJson(req_H_client_control);
            PerfectHttp.createService(PandingService.class).h_client_control(param)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<H_Client_control>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(H_Client_control HClient_control) {

                        }
                    });
        }
        //bd平台设防
        else if(TextUtils.equals(vehiclegroup,"BD")){
            if(TextUtils.equals(bdguardCode,"010")||TextUtils.equals(bdguardCode,"011")||
                    TextUtils.equals(bdguardCode,"110")||TextUtils.equals(bdguardCode,"111")){
                Toast.makeText(mActivity, "车辆已处于设防状态", Toast.LENGTH_SHORT).show();
                return;
            }
            MapKeyApplication application = (MapKeyApplication) getApplication();
            String username = application.getUsername();
            String password = application.getPassword();
            Req_Bd_client_control req_bd_client_control = new Req_Bd_client_control();
            req_bd_client_control.setUsernum(username);
            req_bd_client_control.setPassword(password);
            req_bd_client_control.setClientType("Android");
            req_bd_client_control.setCode(BDShefang);

            String param = new Gson().toJson(req_bd_client_control);

            PerfectHttp.createService(PandingService.class).bd_client_control(param)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Bd_client_control>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(Bd_client_control bd_client_control) {

                        }
                    });
        }

        //刷新车辆状态
        continueRefresh();

    }

    /**
     * 解防
     */
    private void unlock() {
        //h平台解防
        if(TextUtils.equals(vehiclegroup,"H")){
            if (guard == 3 || guard == 6) {
                Toast.makeText(mActivity, "车辆已处于解防状态", Toast.LENGTH_SHORT).show();
                return;
            }

            MapKeyApplication application = (MapKeyApplication) mActivity.getApplication();
            Req_H_client_control req_H_client_control = new Req_H_client_control();
            req_H_client_control.setTerminalNum(GetAppUtils.getTermanalNum(application));
            req_H_client_control.setCarNo(application.getLoginHSingle().getCarLicenseNum());
            req_H_client_control.setCode(SETALARMOFF);
            String param = new Gson().toJson(req_H_client_control);
            PerfectHttp.createService(PandingService.class).h_client_control(param)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<H_Client_control>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(H_Client_control HClient_control) {

                        }
                    });
        }
        //波导平台解防
        else if(TextUtils.equals(vehiclegroup,"BD")){
            if(TextUtils.equals(bdguardCode,"000")||TextUtils.equals(bdguardCode,"100")){
                Toast.makeText(mActivity, "车辆已处于解防状态", Toast.LENGTH_SHORT).show();
                return;
            }
            MapKeyApplication application = (MapKeyApplication) getApplication();
            String username = application.getUsername();
            String password = application.getPassword();
            Req_Bd_client_control req_bd_client_control = new Req_Bd_client_control();
            req_bd_client_control.setUsernum(username);
            req_bd_client_control.setPassword(password);
            req_bd_client_control.setClientType("Android");
            req_bd_client_control.setCode(BDJieFang);

            String param = new Gson().toJson(req_bd_client_control);

            PerfectHttp.createService(PandingService.class).bd_client_control(param)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Bd_client_control>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(Bd_client_control bd_client_control) {

                        }
                    });
        }

        //刷新车辆状态
        continueRefresh();
    }

    /**
     * 发送指令后更新
     *
     */
    private void continueRefresh() {
        //弹框 显示正在发送指令
        Toast.makeText(mActivity, "指令发送成功", Toast.LENGTH_SHORT).show();
        if(TextUtils.equals(vehiclegroup,"H")){
            //记录当前的guard状态
            recordGuard = guard;
            //停止获得数据
            //重新发起有refresh的startupdate
            //在startupdate refresh里面进行判断，是否更新状态了
        }else if(TextUtils.equals(vehiclegroup,"BD")){
            bdrecordguradcode = bdguardCode;
        }

        stopUpdateData();
        startUpdateData(2, 2, true);
        //20秒内，即10次2秒 ，倒计时
        refreshCount = 1;

    }
}
