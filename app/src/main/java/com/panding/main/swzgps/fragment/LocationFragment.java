package com.panding.main.swzgps.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.Poi;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.google.gson.Gson;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.panding.main.Base.BaseContentragment;
import com.panding.main.Base.BaseUtils;
import com.panding.main.R;
import com.panding.main.application.GetAppUtils;
import com.panding.main.application.LocationService;
import com.panding.main.application.MapKeyApplication;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PerfectHttp;
import com.panding.main.perfecthttp.request.Req_Bd_info_get;
import com.panding.main.perfecthttp.request.Req_H_Location_last;
import com.panding.main.perfecthttp.request.Req_bd_location_last;
import com.panding.main.perfecthttp.request.Req_control_func;
import com.panding.main.perfecthttp.request.Req_h_status;
import com.panding.main.perfecthttp.response.Bd_info_get;
import com.panding.main.perfecthttp.response.Bd_location_last;
import com.panding.main.perfecthttp.response.H_Location_last;
import com.panding.main.perfecthttp.response.H_status;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LocationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocationFragment extends BaseContentragment implements View.OnClickListener  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_VEHICLE = "vehicletype";
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_count)
    TextView toolbarCount;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bmapView)
    MapView mMapView;
    @BindView(R.id.tv_myloc)
    ImageView tvMyloc;
    @BindView(R.id.cv_myloc)
    CardView cvMyloc;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.cv_carsearch)
    CardView cvCarsearch;
    @BindView(R.id.iv_switch)
    ImageView ivSwitch;
    @BindView(R.id.cv_switch)
    CardView cvSwitch;
    Unbinder unbinder;

    private BaiduMap mBaiduMap;
    private String clientID;
    private String carNum;
    private Subscription subscribe;

    BitmapDescriptor swz = BitmapDescriptorFactory.fromResource(R.drawable.swzloc);
    BitmapDescriptor swz_offline = BitmapDescriptorFactory.fromResource(R.drawable.swz_lineoff);

    BitmapDescriptor humloc = BitmapDescriptorFactory.fromResource(R.drawable.humloc);
    private Marker mMarker;
    private String gps_time;
    private String sim;
    private String mileage;
    private int speed;
    public String noclick = "noclick";
    public String hadclick = "click";
    private OverlayOptions humoption;
    private Marker humMarker;

    private String permissionInfo;
    private final int SDK_PERMISSION_REQUEST = 127;
    private LocationService locationService;
    private Subscription countSubscribe;
    private int refreshTime ;
    private MapKeyApplication application;
    private OverlayOptions ooCircle;
    private MarkerOptions option;

    private final static int TYPE_CAR = 1;
    private final static int TYPE_ALL = 2;
    private SharedPreferences refreshSP;
    private SharedPreferences.Editor refresh_edit;
    private final static String REFRESHTIME = "refreshtime";
    private String guard_status;
    private double vol;
    private int guard;
    private String rcv_time;

    // TODO: Rename and change types of parameters
    private String vehiclegroup;


    public LocationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LocationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LocationFragment newInstance(String vehiclegroup) {
        LocationFragment fragment = new LocationFragment();
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
        View view = inflater.inflate(R.layout.fragment_location, container, false);
        unbinder = ButterKnife.bind(this, view);

        //获得定位权限
        //getPersimmions();
        locationService = ((MapKeyApplication) getApplication()).locationService;

        toolbar.inflateMenu(R.menu.menu_location);
        //获得刷新时间
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_refresh:
                        if(refreshTime>0){
                            stopGetLocation();
                            startGetLocation(refreshTime);
                        }else{
                            stopGetLocation();
                            startGetLocation(10);
                        }
                        break;
                }

                return true;
            }

        });

        refreshSP = getSharedPreferences("refresh", Context.MODE_PRIVATE);
        refresh_edit = refreshSP.edit();
        application = (MapKeyApplication) getApplication();



        refreshTime = refreshSP.getInt(REFRESHTIME, 30);

        toolbarCount.setOnClickListener(this);
        toolbarTitle.setText("实时定位");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popStack();
            }
        });
        mBaiduMap = mMapView.getMap();
        //mMapView.setZoomControlsPosition(null);
        mMapView.showZoomControls(false);

        //地图加载完成
        mBaiduMap.setOnMapLoadedCallback(new BaiduMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                //初始化地图管理

                //初始化人的marker和option
                option = new MarkerOptions()
                        .position(BaseUtils.gpsTranstoBaidu(0, 0))
                        .icon(swz)
                        .anchor(0.5f, 0.5f
                        ).rotate(0);

                mMarker = (Marker) (mBaiduMap.addOverlay(option));
                mMarker.setIcon(swz);
                mMarker.setRotate(0);

                //初始化车的marker和option
                humoption = new MarkerOptions()
                        .position(BaseUtils.gpsTranstoBaidu(0, 0))
                        .icon(humloc)
                        .anchor(0.5f, 0.5f).rotate(0);

                humMarker = (Marker) (mBaiduMap.addOverlay(humoption));
                humMarker.setIcon(humloc);
                humMarker.setRotate(0);

                if(refreshTime>0) {
                    startGetLocation(refreshTime);
                }else{
                    //自动更新关闭的话，就不要开启计时了
                    startGetLocation(10);
                }
                mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        //创建InfoWindow展示的view
                        if(marker==mMarker){
                            showInfoWindow(marker);
                        }
                        return true;
                    }
                });

                cvCarsearch.setTag(hadclick);
                cvMyloc.setTag(hadclick);
                cvSwitch.setTag(hadclick);

                cvMyloc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch ((String) v.getTag()) {
                            case "click":
                                //进行定位
                                getHumanLocation();
                                cvMyloc.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                tvMyloc.setImageResource(R.drawable.myloc);
                                cvMyloc.setTag(noclick);
                                break;
                            case "noclick":
                                //移除个人定位
                                humMarker.remove();
                                //重新再定义
                                humMarker = (Marker) (mBaiduMap.addOverlay(humoption));
                                humMarker.setIcon(humloc);
                                humMarker.setRotate(0);
                                mBaiduMap.hideInfoWindow();
                                //显示车定位的marker
                                showInfoWindow(mMarker);
                                cvMyloc.setCardBackgroundColor(getResources().getColor(R.color.white));
                                tvMyloc.setImageResource(R.drawable.myloc_blue);
                                cvMyloc.setTag(hadclick);

                        }
                    }
                });

                cvCarsearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String tag = (String) cvMyloc.getTag();
                        if (TextUtils.equals(tag,noclick)){

                        }else {
                            Toast.makeText(mActivity,"请先进行个人定位",Toast.LENGTH_SHORT).show();
                        }



                        //LatLng phonePos = new LatLng(latitude, longitude);
                       /* LatLng carPos = mMarker.getPosition();
                        Intent intent = new Intent(LocationActivity.this,RoutePlanActivity.class);
                        //intent.putExtra("phonePos",phonePos);
                        intent.putExtra("carPos",carPos);
                        startActivity(intent);*/
                        /*locationService.registerListener(naviListener);
                        //注册监听
                        int type = getIntent().getIntExtra("from", 0);
                        if (type == 0) {
                            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
                        } else if (type == 1) {
                            locationService.setLocationOption(locationService.getOption());
                        }
                        Toast.makeText(LocationActivity.this,"正在定位你当前的位置...",Toast.LENGTH_SHORT).show();
                        locationService.start();// 定位SDK*/
                    }
                });
                cvSwitch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch ((String) v.getTag()) {
                            case "click":
                                cvSwitch.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
                                ivSwitch.setImageResource(R.drawable.switchmap);
                                cvSwitch.setTag(noclick);
                                //卫星地图
                                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);

                                break;
                            case "noclick":
                                cvSwitch.setCardBackgroundColor(getResources().getColor(R.color.white));
                                ivSwitch.setImageResource(R.drawable.swichmap_blue);
                                cvSwitch.setTag(hadclick);
                                //普通地图
                                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);

                        }
                    }
                });
            }
        });
        return view;
    }


    /**
     * 获得人的定位坐标
     */
    private void getHumanLocation() {

        locationService.registerListener(mListener);
        //注册监听
        int type = mActivity.getIntent().getIntExtra("from", 0);
        if (type == 0) {
            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        } else if (type == 1) {
            locationService.setLocationOption(locationService.getOption());
        }
        Toast.makeText(mActivity, "正在定位你当前的位置...", Toast.LENGTH_SHORT).show();
        locationService.start();// 定位SDK

    }



    /*****
     *
     * 定位结果回调，重写onReceiveLocation方法，可以直接拷贝如下代码到自己工程中修改
     *
     */
    private BDLocationListener naviListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // TODO Auto-generated method stub
            if (null != location && location.getLocType() != BDLocation.TypeServerError) {
                StringBuffer sb = new StringBuffer(256);
                sb.append("time : ");
                /**
                 * 时间也可以使用systemClock.elapsedRealtime()方法 获取的是自从开机以来，每次回调的时间；
                 * location.getTime() 是指服务端出本次结果的时间，如果位置不发生变化，则时间不变
                 */
                sb.append(location.getTime());
                sb.append("\nlocType : ");// 定位类型
                sb.append(location.getLocType());
                sb.append("\nlocType description : ");// *****对应的定位类型说明*****
                sb.append(location.getLocTypeDescription());
                sb.append("\nlatitude : ");// 纬度
                sb.append(location.getLatitude());
                sb.append("\nlontitude : ");// 经度
                sb.append(location.getLongitude());
                sb.append("\nradius : ");// 半径
                sb.append(location.getRadius());
                sb.append("\nCountryCode : ");// 国家码
                sb.append(location.getCountryCode());
                sb.append("\nCountry : ");// 国家名称
                sb.append(location.getCountry());
                sb.append("\ncitycode : ");// 城市编码
                sb.append(location.getCityCode());
                sb.append("\ncity : ");// 城市
                sb.append(location.getCity());
                sb.append("\nDistrict : ");// 区
                sb.append(location.getDistrict());
                sb.append("\nStreet : ");// 街道
                sb.append(location.getStreet());
                sb.append("\naddr : ");// 地址信息
                sb.append(location.getAddrStr());
                sb.append("\nUserIndoorState: ");// *****返回用户室内外判断结果*****
                sb.append(location.getUserIndoorState());
                sb.append("\nDirection(not all devices have value): ");
                sb.append(location.getDirection());// 方向
                sb.append("\nlocationdescribe: ");
                sb.append(location.getLocationDescribe());// 位置语义化信息
                sb.append("\nPoi: ");// POI信息

                if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果

                    goNavi(location.getLatitude(), location.getLongitude());
                } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果

                    goNavi(location.getLatitude(), location.getLongitude());
                } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果

                    goNavi(location.getLatitude(), location.getLongitude());

                } else if (location.getLocType() == BDLocation.TypeNetWorkException) {

                } else if (location.getLocType() == BDLocation.TypeCriteriaException) {

                }

            }
        }

        public void onConnectHotSpotMessage(String s, int i) {
        }
    };

    /*****
     *
     * 定位结果回调，重写onReceiveLocation方法，可以直接拷贝如下代码到自己工程中修改
     *
     */
    private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // TODO Auto-generated method stub
            if (null != location && location.getLocType() != BDLocation.TypeServerError) {
                StringBuffer sb = new StringBuffer(256);
                sb.append("time : ");
                /**
                 * 时间也可以使用systemClock.elapsedRealtime()方法 获取的是自从开机以来，每次回调的时间；
                 * location.getTime() 是指服务端出本次结果的时间，如果位置不发生变化，则时间不变
                 */
                sb.append(location.getTime());
                sb.append("\nlocType : ");// 定位类型
                sb.append(location.getLocType());
                sb.append("\nlocType description : ");// *****对应的定位类型说明*****
                sb.append(location.getLocTypeDescription());
                sb.append("\nlatitude : ");// 纬度
                sb.append(location.getLatitude());
                sb.append("\nlontitude : ");// 经度
                sb.append(location.getLongitude());
                sb.append("\nradius : ");// 半径
                sb.append(location.getRadius());
                sb.append("\nCountryCode : ");// 国家码
                sb.append(location.getCountryCode());
                sb.append("\nCountry : ");// 国家名称
                sb.append(location.getCountry());
                sb.append("\ncitycode : ");// 城市编码
                sb.append(location.getCityCode());
                sb.append("\ncity : ");// 城市
                sb.append(location.getCity());
                sb.append("\nDistrict : ");// 区
                sb.append(location.getDistrict());
                sb.append("\nStreet : ");// 街道
                sb.append(location.getStreet());
                sb.append("\naddr : ");// 地址信息
                sb.append(location.getAddrStr());
                sb.append("\nUserIndoorState: ");// *****返回用户室内外判断结果*****
                sb.append(location.getUserIndoorState());
                sb.append("\nDirection(not all devices have value): ");
                sb.append(location.getDirection());// 方向
                sb.append("\nlocationdescribe: ");
                sb.append(location.getLocationDescribe());// 位置语义化信息
                sb.append("\nPoi: ");// POI信息
                if (location.getPoiList() != null && !location.getPoiList().isEmpty()) {
                    for (int i = 0; i < location.getPoiList().size(); i++) {
                        Poi poi = (Poi) location.getPoiList().get(i);
                        sb.append(poi.getName() + ";");
                    }
                }
                if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                    sb.append("\nspeed : ");
                    sb.append(location.getSpeed());// 速度 单位：km/h
                    sb.append("\nsatellite : ");
                    sb.append(location.getSatelliteNumber());// 卫星数目
                    sb.append("\nheight : ");
                    sb.append(location.getAltitude());// 海拔高度 单位：米
                    sb.append("\ngps status : ");
                    sb.append(location.getGpsAccuracyStatus());// *****gps质量判断*****
                    sb.append("\ndescribe : ");
                    sb.append("gps定位成功");
                    showHumLocation(location.getLatitude(), location.getLongitude(),location.getAddrStr());
                } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                    // 运营商信息
                    if (location.hasAltitude()) {// *****如果有海拔高度*****
                        sb.append("\nheight : ");
                        sb.append(location.getAltitude());// 单位：米
                    }
                    sb.append("\noperationers : ");// 运营商信息
                    sb.append(location.getOperators());
                    sb.append("\ndescribe : ");
                    sb.append("网络定位成功");
                    showHumLocation(location.getLatitude(), location.getLongitude(),location.getAddrStr());
                } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                    sb.append("\ndescribe : ");
                    sb.append("离线定位成功，离线定位结果也是有效的");
                    showHumLocation(location.getLatitude(), location.getLongitude(),location.getAddrStr());
                } else if (location.getLocType() == BDLocation.TypeServerError) {
                    sb.append("\ndescribe : ");
                    sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
                } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                    sb.append("\ndescribe : ");
                    sb.append("网络不同导致定位失败，请检查网络是否通畅");
                } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                    sb.append("\ndescribe : ");
                    sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
                }
                //Toast.makeText(mActivity,sb.toString(),Toast.LENGTH_SHORT).show();
            }
        }

        public void onConnectHotSpotMessage(String s, int i) {
        }
    };



    /**
     * 定位成功后显示
     *  @param latitude
     * @param longitude
     * @param addrStr
     */
    private void showHumLocation(double latitude, double longitude, String addrStr) {
        locationService.stop();
        //初始化marker
        LatLng latLng = new LatLng(latitude, longitude);
        humMarker.setPosition(latLng);

        //定义用于显示该InfoWindow的坐标点
        //创建InfoWindow , 传入 view， 地理坐标， y 轴偏移量
      /*  TextView textView = new TextView(this);
        textView.setText("我的位置:"+addrStr);*/

        final Button button = new Button(mActivity);
        button.setBackgroundResource(R.drawable.popinfo);
        button.setText("我的位置:"+addrStr);
        button.setTextColor(Color.parseColor("#000000"));
        button.setTextSize(13);
        final InfoWindow.OnInfoWindowClickListener listener = new InfoWindow.OnInfoWindowClickListener() {
            public void onInfoWindowClick() {
                // LatLng llNew = new LatLng(ll.latitude + 0.005,
                // ll.longitude + 0.005);
                // marker.setPosition(llNew);
                mBaiduMap.hideInfoWindow();
            }
        };

        final InfoWindow mInfoWindow = new InfoWindow(BitmapDescriptorFactory.fromView(button), latLng, -24, listener);
        //显示InfoWindow
        mBaiduMap.showInfoWindow(mInfoWindow);
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                //创建InfoWindow展示的view
                if(marker==mMarker){
                    showInfoWindow(marker);
                }else if(marker==humMarker){
                    mBaiduMap.showInfoWindow(mInfoWindow);

                }
                return true;
            }
        });
        changeMapStatus();
    }

    private void changeMapStatus(){
        String tag = (String) cvMyloc.getTag();
        if(tag.equals(hadclick)){
            //设置地图中心点
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target((mMarker).getPosition());
            builder.zoom(18.0f);
            mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));

        }else{
            LatLngBounds.Builder builder = new LatLngBounds.Builder();

            builder.include((humMarker).getPosition());
            builder.include((mMarker).getPosition());
            mBaiduMap.setMapStatus(MapStatusUpdateFactory
                    .newLatLngBounds(builder.build()));
        }
    }

    /**
     * 停止获得车辆轨迹信息
     */
    private void stopGetLocation() {
        if (subscribe != null) {
            if (!subscribe.isUnsubscribed()) {
                subscribe.unsubscribe();
            }
        }
    }

    /**
     * 停止倒计时
     */
    private void stopCount(String second){
        if(countSubscribe!=null){
            if(!countSubscribe.isUnsubscribed()){
                countSubscribe.unsubscribe();
                toolbarCount.setText(second);
            }
        }
    }

    /**
     * 开始倒计时
     * @param second
     */
    private void startCount(final int second){
        countSubscribe = Observable.interval(0, 1, TimeUnit.SECONDS)
                .observeOn(Schedulers.io())
                .take(second)
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
                        int count = (int) (second - aLong);
                        toolbarCount.setText(count + "s");
                    }
                });
    }

    /**
     * 获得车辆的最后的轨迹信息，即实时定位
     *
     * @param second 多少秒刷新一次
     */
    private void startGetLocation(final long second) {
        if(TextUtils.equals(vehiclegroup,"H")){
            h_updateLocation(second);
        }else if(TextUtils.equals(vehiclegroup,"BD")){
            bd_updateLocation(second);
        }
    }

    /**
     * bd平台更新数据
     * @param second
     */
    private void bd_updateLocation(final long second){
        MapKeyApplication application = (MapKeyApplication) getApplication();
        carNum = application.getUsername();
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


        subscribe = PerfectHttp.createService(PandingService.class).bd_info_get(req_bd_info_get_param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .flatMap(new Func1<Bd_info_get, Observable<Long>>() {
                    @Override
                    public Observable<Long> call(Bd_info_get bdinfoget) {
                        updateBdStatus(bdinfoget);
                        return Observable.interval(0, second, TimeUnit.SECONDS);
                    }
                })
                .flatMap(new Func1<Long, Observable<Bd_location_last>>() {
                    @Override
                    public Observable<Bd_location_last> call(Long aLong) {

                        return PerfectHttp.createService(PandingService.class).bd_location_last(bd_Location_last_param);
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
                    public void onNext(Bd_location_last bd_location_last) {
                        if(refreshTime>0) {
                            stopCount(second + "s");
                            startCount((int) second);
                        }else{
                            toolbarCount.setText("已关闭");
                        }
                        if(bd_location_last.getErrcode()==0) {

                            double lat = Double.parseDouble(bd_location_last.getBlat());
                            double lon = Double.parseDouble(bd_location_last.getBlng());
                            gps_time = bd_location_last.getCretattime();
                            //设备号
                            sim = bd_location_last.getEquid();
                            //里程
                            mileage = bd_location_last.getMileage()+"";
                            speed = bd_location_last.getSpe();

                            vol = Double.parseDouble(bd_location_last.getVol());

                            guard_status = bd_location_last.getGuardStatus();
                            //guard = bd_location_last.get();
                            LatLng baiduPoint = new LatLng(lat, lon);
                            //marker位置
                            mMarker.setPosition(baiduPoint);

                            changeMapStatus();

                            showInfoWindow(mMarker);

                            if(refreshTime<0) {
                                if (!subscribe.isUnsubscribed()){
                                    subscribe.unsubscribe();
                                }
                            }
                        }
                    }
                });
    }

    /**
     * bd平台更新状态
     * @param bdinfoget
     */
    private void updateBdStatus(Bd_info_get bdinfoget) {
        if(bdinfoget.getErrcode()==0){
            int czhuangtai = bdinfoget.getCzhuangtai();
            if(czhuangtai==0){
                mMarker.setIcon(swz_offline);
            }else{
                mMarker.setIcon(swz);
            }
        }
    }

    /**
     * h平台更新数据
     * @param second
     */
    private void h_updateLocation(final long second){

        //请求在线，离线状态参数
        Req_h_status req_h_status = new Req_h_status();
        String objectId = application.getLoginHSingle().getObjectId();
        req_h_status.setObjectId(objectId);
        final String req_h_status_param = new Gson().toJson(req_h_status);

        //历史轨迹参数
        clientID = application.getLoginHSingle().getObjectId();
        carNum = application.getLoginHSingle().getCarLicenseNum();
        final Req_H_Location_last req_H_location_last = new Req_H_Location_last();
        req_H_location_last.setObjectId(clientID);
        req_H_location_last.setVehicleNum(carNum);
        final String param = new Gson().toJson(req_H_location_last);


        subscribe = PerfectHttp.createService(PandingService.class).h_status(req_h_status_param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .flatMap(new Func1<H_status, Observable<Long>>() {
                    @Override
                    public Observable<Long> call(H_status h_status) {
                        updateStatus(h_status);
                        return Observable.interval(0, second, TimeUnit.SECONDS);
                    }
                })
                .flatMap(new Func1<Long, Observable<H_Location_last>>() {
                    @Override
                    public Observable<H_Location_last> call(Long aLong) {

                        return PerfectHttp.createService(PandingService.class).h_location_last(param);
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
                    public void onNext(H_Location_last HLocation_last) {
                        if(refreshTime>0) {
                            stopCount(second + "s");
                            startCount((int) second);
                        }else{
                            toolbarCount.setText("已关闭");
                        }
                        //获得车辆状态
                        if(HLocation_last.getErrcode()==0) {
                            double lat = HLocation_last.getLat();
                            double lon = HLocation_last.getLon();
                            gps_time = HLocation_last.getGps_time();
                            rcv_time = HLocation_last.getRcv_time();
                            //设备号
                            sim = HLocation_last.getSim();
                            //里程
                            mileage = HLocation_last.getMileage();
                            speed = HLocation_last.getSpeed();

                            vol = HLocation_last.getVol();

                            guard_status = HLocation_last.getGuard_status();
                            guard = HLocation_last.getGuard();
                            LatLng baiduPoint = BaseUtils.gpsTranstoBaidu(lat, lon);
                            //marker位置
                            mMarker.setPosition(baiduPoint);

                            changeMapStatus();

                            showInfoWindow(mMarker);

                            if(refreshTime<0) {
                                if (!subscribe.isUnsubscribed()){
                                    subscribe.unsubscribe();
                                }
                            }
                        }
                    }
                });
    }

    /**
     * 波导平台更新状态
     * @param h_status
     */
    private void updateStatus(H_status h_status) {
        if(h_status.getErrcode()==0){
            String carStatus = h_status.getCarStatus();
            if(TextUtils.equals("未上线",carStatus)){
                mMarker.setIcon(swz_offline);
            }else{
                mMarker.setIcon(swz);
            }
        }
    }

    private void showInfoWindow(final Marker marker) {
        final InfoWindow.OnInfoWindowClickListener listener = new InfoWindow.OnInfoWindowClickListener() {
            public void onInfoWindowClick() {
                // LatLng llNew = new LatLng(ll.latitude + 0.005,
                // ll.longitude + 0.005);
                // marker.setPosition(llNew);
                mBaiduMap.hideInfoWindow();
            }
        };

        GeoCoder mSearch = GeoCoder.newInstance();
        mSearch.reverseGeoCode(new ReverseGeoCodeOption().location(marker.getPosition()));// 搜索地址
        OnGetGeoCoderResultListener addresslistener = new OnGetGeoCoderResultListener() {
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

                } else {
                    address = result.getAddress().toString()+" "+result.getSematicDescription();
                }

                View view = getLayout(address);
                //定义用于显示该InfoWindow的坐标点
                LatLng pt = marker.getPosition();
                //创建InfoWindow , 传入 view， 地理坐标， y 轴偏移量
                InfoWindow mInfoWindow = new InfoWindow(BitmapDescriptorFactory.fromView(view), pt, -24, listener);
                //显示InfoWindow
                mBaiduMap.showInfoWindow(mInfoWindow);
            }
        };
        mSearch.setOnGetGeoCodeResultListener(addresslistener);
    }

    private View getLayout(String address) {
//        View.inflate(this,R.layout.layout_popup,null);
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        View view = inflater.inflate(R.layout.layout_popup_h, null);
        view.getBackground().setAlpha(200);
        TextView tvCarnum = (TextView) view.findViewById(R.id.tv_carnum);
        TextView tvSim = (TextView) view.findViewById(R.id.tv_sim);
        TextView tvLocation = (TextView) view.findViewById(R.id.tv_location);
        TextView tvTime = (TextView) view.findViewById(R.id.tv_time);
        TextView tvRvctime = (TextView) view.findViewById(R.id.tv_rvctime);
        TextView tvspeed = (TextView) view.findViewById(R.id.tv_speed);
        TextView tvMileage = (TextView) view.findViewById(R.id.tv_mileage);
        TextView tvVoltage = (TextView) view.findViewById(R.id.tv_voltage);
        TextView tvState = (TextView) view.findViewById(R.id.tv_state);
        if(vol>=0){
            tvVoltage.setText("电压:"+vol+"v");
        }else{
            tvVoltage.setText("电压: --");
        }

        if(guard==-1){
            tvState.setText("状态：--");
        }else{
            tvState.setText("状态："+guard_status);
        }

        tvCarnum.setText("车牌号:" + carNum);
        tvSim.setText("设备号:" + sim);
        tvLocation.setText("位置:" + address);
        tvTime.setText("卫星时间:" + gps_time);
        tvMileage.setText("总里程:" + mileage + "Km");
        tvspeed.setText("速度:" + speed + "Km/h");
        tvRvctime.setText("系统时间:"+rcv_time);
        return view;
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
    public void onDestroyView() {
        super.onDestroyView();
        super.onDestroy();
        if (subscribe != null) {
            if (!subscribe.isUnsubscribed()) {
                subscribe.unsubscribe();
            }
        }
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        ViewHolder contentView = new ViewHolder(R.layout.choose_mode);
        final DialogPlus dialog = DialogPlus.newDialog(mActivity)
                .setContentHolder(contentView)
                .setGravity(Gravity.CENTER)
                .setCancelable(true)
                .setContentWidth(480)
                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .setContentBackgroundResource(R.drawable.dialog_background)
                .create();

        View holderView = dialog.getHolderView();
        final ImageView iv_10s = (ImageView) holderView.findViewById(R.id.iv_10s);
        final ImageView iv_20s = (ImageView) holderView.findViewById(R.id.iv_20s);
        final ImageView iv_30s = (ImageView) holderView.findViewById(R.id.iv_30s);
        final ImageView iv_close = (ImageView) holderView.findViewById(R.id.iv_close);

        switch (refreshTime){
            case 10:
                iv_10s.setVisibility(View.VISIBLE);
                iv_20s.setVisibility(View.INVISIBLE);
                iv_30s.setVisibility(View.INVISIBLE);
                iv_close.setVisibility(View.INVISIBLE);
                break;
            case 20:
                iv_10s.setVisibility(View.INVISIBLE);
                iv_20s.setVisibility(View.VISIBLE);
                iv_30s.setVisibility(View.INVISIBLE);
                iv_close.setVisibility(View.INVISIBLE);
                break;
            case 30:
                iv_10s.setVisibility(View.INVISIBLE);
                iv_20s.setVisibility(View.INVISIBLE);
                iv_30s.setVisibility(View.VISIBLE);
                iv_close.setVisibility(View.INVISIBLE);
                break;
            case -1:
                iv_10s.setVisibility(View.INVISIBLE);
                iv_20s.setVisibility(View.INVISIBLE);
                iv_30s.setVisibility(View.INVISIBLE);
                iv_close.setVisibility(View.VISIBLE);
                break;
        }

        holderView.findViewById(R.id.rl_10s).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_10s.setVisibility(View.VISIBLE);
                iv_20s.setVisibility(View.INVISIBLE);
                iv_30s.setVisibility(View.INVISIBLE);
                iv_close.setVisibility(View.INVISIBLE);
                refreshTime = 10;
                refresh_edit.putInt(REFRESHTIME,refreshTime);
                stopGetLocation();
                stopCount("10s");
                startGetLocation(10);
                dialog.dismiss();
            }
        });
        holderView.findViewById(R.id.rl_20s).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_10s.setVisibility(View.INVISIBLE);
                iv_20s.setVisibility(View.VISIBLE);
                iv_30s.setVisibility(View.INVISIBLE);
                iv_close.setVisibility(View.INVISIBLE);
                refreshTime = 20;
                refresh_edit.putInt(REFRESHTIME,refreshTime);
                stopGetLocation();
                stopCount("20s");
                startGetLocation(20);
                dialog.dismiss();
            }
        });
        holderView.findViewById(R.id.rl_30s).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_10s.setVisibility(View.INVISIBLE);
                iv_20s.setVisibility(View.INVISIBLE);
                iv_30s.setVisibility(View.VISIBLE);
                iv_close.setVisibility(View.INVISIBLE);
                refreshTime = 30;
                refresh_edit.putInt(REFRESHTIME,refreshTime);
                stopGetLocation();
                stopCount("20s");
                startGetLocation(30);
                dialog.dismiss();
            }
        });
        holderView.findViewById(R.id.rl_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_10s.setVisibility(View.INVISIBLE);
                iv_20s.setVisibility(View.INVISIBLE);
                iv_30s.setVisibility(View.INVISIBLE);
                iv_close.setVisibility(View.VISIBLE);
                refreshTime = -1;
                refresh_edit.putInt(REFRESHTIME,refreshTime);
                stopGetLocation();
                stopCount("已关闭");
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /**
     * 获得位置后发起导航
     * @param latitude
     * @param longitude
     */
    private double phonelat;
    private double phonelon;
    private void goNavi(double latitude, double longitude){
        phonelat = latitude;
        phonelon = longitude;

        //停止定位
        locationService.stop();
    }

}
