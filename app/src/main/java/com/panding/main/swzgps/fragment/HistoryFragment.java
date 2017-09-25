package com.panding.main.swzgps.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.VehicleInfo;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.google.gson.Gson;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.panding.main.Base.BaseContentragment;
import com.panding.main.R;
import com.panding.main.application.MapKeyApplication;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PerfectHttp;
import com.panding.main.perfecthttp.request.Req_Bd_location_history;
import com.panding.main.perfecthttp.request.Req_H_Location_history;
import com.panding.main.perfecthttp.response.Bd_location_history;
import com.panding.main.perfecthttp.response.H_Location_history;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.joda.time.DateTime;

import java.util.ArrayList;
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
import rx.schedulers.Schedulers;

import static com.baidu.mapapi.utils.CoordinateConverter.CoordType.GPS;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends BaseContentragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_VEHICLE = "vehicletype";
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.speed_decrease)
    ImageView speedDecrease;
    @BindView(R.id.control)
    ImageView control;
    @BindView(R.id.speed_increase)
    ImageView speedIncrease;
    @BindView(R.id.starttime)
    MaterialEditText starttime;
    @BindView(R.id.endtime)
    MaterialEditText endtime;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.tv_show)
    TextView tvShow;
    Unbinder unbinder;

    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private Polyline mPolyline;
    private Marker mMoveMarker;
    private Handler mHandler;


    // 通过设置间隔时间和距离可以控制速度和图标移动的距离
    private static final int TIME_INTERVAL = 80;
    private static final double DISTANCE = 0.00002;
    private Subscription subscribe;
    private static String pattern = "yyyy-MM-dd HH:mm";

    private int recordIndex = 0;
    private final static String stopState = "stop";
    private final static String startState = "start";
    private int initSpeed = 1200; //初始速度
    private int accSpeed = 400; // 加速度 + - 400
    private String clientID;
    private String carNum;
    private ArrayList<H_Location_history.LocationListBean> lonLat_all;
    private SweetAlertDialog pDialog;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String vehiclegroup;
    private MapKeyApplication application;
    private List<Bd_location_history.ItemsBean> locaitonItems;
    private Subscription getdateSub;


    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String vehiclegroup) {
        HistoryFragment fragment = new HistoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        unbinder = ButterKnife.bind(this, view);

        toolbarTitle.setText("轨迹回放");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popStack();
            }
        });
        toolbar.inflateMenu(R.menu.menu_history);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //Toast.makeText(HistoryActivity.this,"搜索",Toast.LENGTH_SHORT).show();
                recordIndex = 0;
                mBaiduMap.clear();
                stopHistory();
                //搜索历史数据
                getHistoryLocation(starttime.getText().toString(), endtime.getText().toString());
                return true;
            }
        });

        mMapView = (MapView) view.findViewById(R.id.bmapView);
        //mMapView.onCreate(mActivity, savedInstanceState);
        mBaiduMap = mMapView.getMap();

        mHandler = new Handler(Looper.getMainLooper());
        //drawPolyLine();

        application = (MapKeyApplication) getApplication();


        //获取当前时间
        final DateTime nowDateTime = new DateTime();

        final String endTime = nowDateTime.toString(pattern);
        //当前时间的一个小时之前
        final DateTime startDateTime = nowDateTime.minusHours(12);
        String startTime = startDateTime.toString(pattern);
        //Toast.makeText(this, endTime, Toast.LENGTH_SHORT).show();

        endtime.setText(endTime);
        starttime.setText(startTime);

        getHistoryLocation(startTime, endTime);

        mMapView.showZoomControls(false);

        //减速
        speedDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (initSpeed + accSpeed > 2000) {
                    Toast.makeText(mActivity, "已达最慢速度", Toast.LENGTH_SHORT).show();
                    return;
                }
                initSpeed = initSpeed + accSpeed;
                //先暂停
                stopHistory();
                //再开始

                //Toast.makeText(HistoryActivity.this, "速度" + initSpeed, Toast.LENGTH_SHORT).show();
                startHistory(locaitonItems,lonLat_all, initSpeed);
            }
        });

        //加速
        speedIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (initSpeed - accSpeed <= 0) {
                    Toast.makeText(mActivity, "已达最高速度", Toast.LENGTH_SHORT).show();
                    return;
                }
                initSpeed = initSpeed - accSpeed;
                //先暂停
                stopHistory();
                //再开始
                //Toast.makeText(HistoryActivity.this, "速度" + initSpeed, Toast.LENGTH_SHORT).show();
                startHistory(locaitonItems,lonLat_all, initSpeed);
            }
        });
        control.setImageResource(R.drawable.stop);
        control.setTag(0);
        //暂停，播放
        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开始动画播放
                switch ((int) v.getTag()) {
                    case 0:
                        //播放状态
                        setControlState(stopState);
                        stopHistory();
                        break;
                    case 1:
                        //暂停状态
                        setControlState(startState);
                        startHistory(locaitonItems,lonLat_all, initSpeed);
                        break;
                }

            }
        });

        starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //设置默认
                int year = startDateTime.getYear();
                int monthOfYear = startDateTime.getMonthOfYear();
                int dayOfMonth = startDateTime.getDayOfMonth();
                int hourOfDay = startDateTime.getHourOfDay();
                int minuteOfHour = startDateTime.getMinuteOfHour();
                Log.e("datetime", year + "--" + monthOfYear + "--" + dayOfMonth + "--" + hourOfDay + "--" + minuteOfHour);
//                int secondOfMinute = startDateTime.getSecondOfMinute();

                long oneYears =  365 * 1000 * 60 * 60 * 24L;
                TimePickerDialog dialog = new TimePickerDialog.Builder()
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                DateTime dateTime = new DateTime(millseconds);
                                starttime.setText(dateTime.toString(pattern));
                            }
                        })
                        .setCancelStringId("取消")
                        .setSureStringId("确定")
                        .setTitleStringId("开始时间")
                        .setYearText("年")
                        .setMonthText("月")
                        .setDayText("日")
                        .setHourText("时")
                        .setMinuteText("分")
                        .setCyclic(false)
                        .setMinMillseconds(System.currentTimeMillis()- oneYears)
                        .setMaxMillseconds(System.currentTimeMillis() + oneYears)
                        .setCurrentMillseconds(System.currentTimeMillis())
                        .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                        .setType(Type.ALL)
                        .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                        .setWheelItemTextSize(12)
                        .build();

                dialog.show(getChildFragmentManager(),"all");
            }
        });

        endtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置默认
                int year = nowDateTime.getYear();
                int monthOfYear = nowDateTime.getMonthOfYear();

                int dayOfMonth = nowDateTime.getDayOfMonth();
                int hourOfDay = nowDateTime.getHourOfDay();
                int minuteOfHour = nowDateTime.getMinuteOfHour();
//                int secondOfMinute = startDateTime.getSecondOfMinute();

                long oneYears =  365 * 1000 * 60 * 60 * 24L;
                TimePickerDialog dialog = new TimePickerDialog.Builder()
                        .setCallBack(new OnDateSetListener() {
                            @Override
                            public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                                DateTime dateTime = new DateTime(millseconds);
                                endtime.setText(dateTime.toString(pattern));
                            }
                        })
                        .setCancelStringId("取消")
                        .setSureStringId("确定")
                        .setTitleStringId("结束时间")
                        .setYearText("年")
                        .setMonthText("月")
                        .setDayText("日")
                        .setHourText("时")
                        .setMinuteText("分")
                        .setCyclic(false)
                        .setMinMillseconds(System.currentTimeMillis()- oneYears)
                        .setMaxMillseconds(System.currentTimeMillis() + oneYears)
                        .setCurrentMillseconds(System.currentTimeMillis())
                        .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                        .setType(Type.ALL)
                        .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                        .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                        .setWheelItemTextSize(12)
                        .build();

                dialog.show(getChildFragmentManager(),"all");
            }
        });
        return view;
    }

    private void setControlState(String state) {
        if (state.equals(startState)) {
            control.setImageResource(R.drawable.stop);
            control.setTag(0);
        } else if (state.equals(stopState)) {
            control.setImageResource(R.drawable.start);
            control.setTag(1);
        }
    }
    private String getAVSpeed(){
        String speed = "1x";
        switch (initSpeed){
            case 1200:
                speed="1x";
                break;
            case 1600:
                speed="1/2x";
                break;
            case 2000:
                speed="1/3x";
                break;
            case 800:
                speed="2x";
                break;
            case 400:
                speed="3x";
                break;

        }
        return speed;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }


    /**
     * 将gps坐标转换成百度坐标
     *
     * @param Lat
     * @param Lon
     * @return
     */
    private LatLng gpsTranstoBaidu(double Lat, double Lon) {
        // 获取gps经纬度
        LatLng gpsPoint = new LatLng(Lat, Lon);
        // LatLng gpsPoint = new LatLng(39.963175, 116.400244);

        // 将GPS设备采集的原始GPS坐标转换成百度坐标
        CoordinateConverter converter = new CoordinateConverter();
        converter.from(GPS);
        // sourceLatLng待转换坐标
        converter.coord(gpsPoint);
        LatLng baiduPoint = converter.convert();
        return baiduPoint;
    }

    /**
     * 停止历史轨迹动画播放
     */
    private void stopHistory() {
        if (subscribe != null) {
            if (!subscribe.isUnsubscribed()) {
                subscribe.unsubscribe();
            }
        }
        if (getdateSub != null) {
            if (!getdateSub.isUnsubscribed()) {
                getdateSub.unsubscribe();
            }
        }
    }

    /**
     * 开始轨迹动画播放
     *
     * @param lonLat_all 轨迹集合
     * @param speed      速度
     */
    private void startHistory(final List<Bd_location_history.ItemsBean> locaitonItems,final List<H_Location_history.LocationListBean> lonLat_all, final int speed) {
        if(TextUtils.equals(vehiclegroup,"H")){
            startH_history(lonLat_all,speed);
        }
        else if(TextUtils.equals(vehiclegroup,"BD")){
            startBD_history(locaitonItems,speed);
        }
    }

    private void startBD_history(final List<Bd_location_history.ItemsBean> locaitonItems, final int speed){
        subscribe = Observable.interval(0, speed, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        //Toast.makeText(BdHistoryActivity.this,aLong.intValue()+"--",Toast.LENGTH_SHORT).show();

                        int index = recordIndex;//aLong.intValue();
                        recordIndex++; // 纪录index，以暂停后继续播放
                        final Bd_location_history.ItemsBean itemsBean = locaitonItems.get(index);
                        //位置
                        LatLng position = new LatLng(Double.parseDouble(itemsBean.getBlat()),Double.parseDouble(itemsBean.getBlng()));
                        //gpsTranstoBaidu(lonLatAllBean.getLat(), lonLatAllBean.getLon());
                        //角度
                        final float direct = Float.parseFloat(itemsBean.getHax());
                        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newLatLng(position));// 设置地图中心点
                        mMoveMarker.setRotate(direct);
                        mMoveMarker.setPosition(position);
                        //描线
                        if (index > 0) {
                            LatLng beforLatlng = new LatLng(Double.parseDouble(locaitonItems.get(index - 1).getBlat()),
                                    Double.parseDouble(locaitonItems.get(index - 1).getBlng()));
                            //gpsTranstoBaidu(locaitonItems.get(index - 1).getLat(), locaitonItems.get(index - 1).getLon());
                            List<LatLng> polylines = new ArrayList<>();
                            polylines.add(beforLatlng);
                            polylines.add(position);
                            PolylineOptions polylineOptions = new PolylineOptions().points(polylines).width(10).color(Color.RED);
                            mPolyline = (Polyline) mBaiduMap.addOverlay(polylineOptions);
                        }
                        //最后一条，提示播放完毕
                        if (index == locaitonItems.size() - 1) {
                            Toast.makeText(mActivity, "播放完毕", Toast.LENGTH_SHORT).show();
                            setControlState(stopState);
                        }
                        //获得地址，并显示在图层上
                        GeoCoder mSearch = GeoCoder.newInstance();
                        mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(position));// 搜索地址
                        OnGetGeoCoderResultListener listener = new OnGetGeoCoderResultListener() {
                            public void onGetGeoCodeResult(GeoCodeResult result) {
                                if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                                    // 没有检索到结果
                                }
                                // 获取地理编码结果
                                // 返回坐标
                            }

                            @Override
                            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
                                String address = "";
                                if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                                    // 没有找到检索结果
                                    address = "正在定位中...";
                                } else {
                                    address = result.getAddress().toString();
                                    // 获取反向地理编码结果
                                }
                                tvShow.setText("播放速度"+getAVSpeed()+"\n"+"速度:" + itemsBean.getSpe()
                                        + "km/h\n 卫星时间:" + itemsBean.getCretattime() + "\n  地址:" + address);

                            }
                        };
                        mSearch.setOnGetGeoCodeResultListener(listener);

                    }
                });
    }

    private void startH_history(final List<H_Location_history.LocationListBean> lonLat_all, final int speed){
        subscribe = Observable.interval(0, speed, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        //Toast.makeText(HistoryActivity.this,aLong.intValue()+"--",Toast.LENGTH_SHORT).show();

                        int index = recordIndex;//aLong.intValue();
                        recordIndex++; // 纪录index，以暂停后继续播放
                        final H_Location_history.LocationListBean lonLatAllBean = lonLat_all.get(index);
                        //位置
                        LatLng position = gpsTranstoBaidu(lonLatAllBean.getLat(), lonLatAllBean.getLon());
                        //角度
                        final int direct = lonLatAllBean.getDirect();
                        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newLatLng(position));// 设置地图中心点
                        mMoveMarker.setRotate(0 - direct);
                        mMoveMarker.setPosition(position);
                        //描线
                        if (index > 0) {
                            LatLng beforLatlng = gpsTranstoBaidu(lonLat_all.get(index - 1).getLat(), lonLat_all.get(index - 1).getLon());
                            List<LatLng> polylines = new ArrayList<>();
                            polylines.add(beforLatlng);
                            polylines.add(position);
                            PolylineOptions polylineOptions = new PolylineOptions().points(polylines).width(10).color(Color.RED);
                            mPolyline = (Polyline) mBaiduMap.addOverlay(polylineOptions);
                        }
                        //最后一条，提示播放完毕
                        if (index == lonLat_all.size() - 1) {
                            Toast.makeText(mActivity, "播放完毕", Toast.LENGTH_SHORT).show();
                            setControlState(stopState);
                        }
                        //获得地址，并显示在图层上
                        GeoCoder mSearch = GeoCoder.newInstance();
                        mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(position));// 搜索地址
                        OnGetGeoCoderResultListener listener = new OnGetGeoCoderResultListener() {
                            public void onGetGeoCodeResult(GeoCodeResult result) {
                                if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                                    // 没有检索到结果
                                }
                                // 获取地理编码结果
                                // 返回坐标
                            }

                            @Override
                            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
                                String address = "";
                                if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                                    // 没有找到检索结果
                                    address = "正在定位中...";
                                } else {
                                    address = result.getAddress().toString();
                                    // 获取反向地理编码结果
                                }
                                tvShow.setText("播放速度"+getAVSpeed()+"\n"+"速度:" + lonLatAllBean.getSpeed() + "km/h \n里程:" + lonLatAllBean.getMileage()
                                        + "km\n 卫星时间:" + lonLatAllBean.getGps_time()+
                                        "\n 系统时间:" + lonLatAllBean.getRcv_time() + "\n  地址:" + address);

                            }
                        };
                        mSearch.setOnGetGeoCodeResultListener(listener);

                    }
                });
    }

    /**
     * 获得所有轨迹信息
     */
    private void getHistoryLocation(String startTime, String endTime) {
        pDialog = new SweetAlertDialog(mActivity, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
        pDialog.setTitleText("搜索中...");
        pDialog.setCancelable(true);
        pDialog.show();
        if(TextUtils.equals(vehiclegroup,"H")){
            getH_histroyLocation(startTime,endTime);
        }else if(TextUtils.equals(vehiclegroup,"BD")){
            getBb_histroyLocation(startTime,endTime);
        }


    }

    /**
     * hbd平台的获取历史轨迹信息
     * @param startTime
     * @param endTime
     */
    private void getBb_histroyLocation(String startTime, String endTime){
        String username = application.getUsername();
        String password = application.getPassword();

        Req_Bd_location_history req_bd_location_history = new Req_Bd_location_history();
        req_bd_location_history.setUsernum(username);
        req_bd_location_history.setPassword(password);
        req_bd_location_history.setEndtime(endTime);
        req_bd_location_history.setStarttime(startTime);

        String param = new Gson().toJson(req_bd_location_history);
        getdateSub = PerfectHttp.createService(PandingService.class).bd_location_history(param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bd_location_history>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        pDialog.dismiss();
                    }

                    @Override
                    public void onNext(Bd_location_history bd_location_history) {
                        pDialog.dismiss();
                        if (bd_location_history.getErrcode() == 0) {
                            //Toast.makeText(BdHistoryActivity.this,historyLocation.getMsg(),Toast.LENGTH_SHORT).show();

                            locaitonItems = bd_location_history.getItems();

                            Toast.makeText(mActivity, "搜索完毕，共" + bd_location_history.getItemCount() + "条轨迹纪录", Toast.LENGTH_SHORT).show();
                            /*LatLng startPoint = gpsTranstoBaidu(locaitonItems.get(0).getLat(), locaitonItems.get(0).getLng());*/
                            LatLng startPoint = new LatLng(Double.parseDouble(locaitonItems.get(0).getBlat()), Double.parseDouble(locaitonItems.get(0).getBlng()));
                            MapStatus.Builder builder = new MapStatus.Builder();
                            builder.target(startPoint);
                            builder.zoom(18.0f);
                            mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                            //初始化了车辆图标
                            OverlayOptions markerOptions;
                            markerOptions = new MarkerOptions().flat(true).anchor(0.5f, 0.5f)
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.black_car_north)).position(startPoint)
                                    .rotate(0);
                            mMoveMarker = (Marker) mBaiduMap.addOverlay(markerOptions);

                            //将图标改为播放图标
                            setControlState(stopState);
                        } else {
                            Toast.makeText(mActivity, bd_location_history.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }



    /**
     * h平台的获取历史轨迹信息
     * @param startTime
     * @param endTime
     */
    private void getH_histroyLocation(String startTime, String endTime){
        carNum = application.getLoginHSingle().getCarLicenseNum();
        clientID = application.getLoginHSingle().getObjectId();

        Req_H_Location_history req_historyLocation = new Req_H_Location_history();
        req_historyLocation.setVehicleNum(carNum);
        req_historyLocation.setObjectId(clientID);

        req_historyLocation.setStartTime(startTime);
        req_historyLocation.setEndTime(endTime);

        String param = new Gson().toJson(req_historyLocation);
        //Toast.makeText(HistoryActivity.this,historyLocation.getMsg(),Toast.LENGTH_SHORT).show();
        //初始化了车辆图标
        //将图标改为播放图标
        getdateSub = PerfectHttp.createService(PandingService.class).h_location_history(param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<H_Location_history>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        pDialog.dismiss();
                    }

                    @Override
                    public void onNext(H_Location_history historyLocation) {
                        pDialog.dismiss();
                        if (historyLocation.getErrcode() == 0) {
                            //Toast.makeText(HistoryActivity.this,historyLocation.getMsg(),Toast.LENGTH_SHORT).show();

                            lonLat_all = (ArrayList<H_Location_history.LocationListBean>) historyLocation.getLocation_list();
                            Toast.makeText(mActivity, "搜索完毕，共" + lonLat_all.size() + "条轨迹纪录", Toast.LENGTH_SHORT).show();
                            LatLng startPoint = gpsTranstoBaidu(lonLat_all.get(0).getLat(), lonLat_all.get(0).getLon());

                            MapStatus.Builder builder = new MapStatus.Builder();
                            builder.target(startPoint);
                            builder.zoom(18.0f);
                            mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                            //初始化了车辆图标
                            OverlayOptions markerOptions;
                            markerOptions = new MarkerOptions().flat(true).anchor(0.5f, 0.5f)
                                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.black_car_north)).position(startPoint)
                                    .rotate(0);
                            mMoveMarker = (Marker) mBaiduMap.addOverlay(markerOptions);

                            //将图标改为播放图标
                            setControlState(stopState);
                        } else {
                            Toast.makeText(mActivity, historyLocation.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        stopHistory();
        unbinder.unbind();
        mMapView.onDestroy();
        mBaiduMap.clear();
    }
}
