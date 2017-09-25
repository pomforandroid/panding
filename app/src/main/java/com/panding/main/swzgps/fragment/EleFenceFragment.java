package com.panding.main.swzgps.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.google.gson.Gson;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.panding.main.Base.BaseContentragment;
import com.panding.main.R;
import com.panding.main.application.GetAppUtils;
import com.panding.main.application.MapKeyApplication;
import com.panding.main.baidu.overlayutil.PoiOverlay;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PerfectHttp;
import com.panding.main.perfecthttp.request.Area;
import com.panding.main.perfecthttp.request.Req_Hfence_post;
import com.panding.main.perfecthttp.response.Hfence_post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.panding.main.R.drawable.suggest;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EleFenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EleFenceFragment extends BaseContentragment implements OnGetPoiSearchResultListener, OnGetSuggestionResultListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_LAT = "Lat";
    private static final String ARG_LON = "Lon";

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bmapView_ele)
    MapView mMapView;
    @BindView(R.id.button_clear)
    Button buttonClear;
    @BindView(R.id.button_save)
    Button buttonSave;
    @BindView(R.id.linearLayout1)
    LinearLayout linearLayout1;
    @BindView(R.id.city_search)
    EditText citySearch;
    @BindView(R.id.item_DeleteCity)
    ImageView itemDeleteCity;
    @BindView(R.id.add_search)
    AutoCompleteTextView addSearch;
    @BindView(R.id.item_DeleteAdd)
    ImageView itemDeleteAdd;
    @BindView(R.id.button_search)
    Button buttonSearch;
    @BindView(R.id.linearLayout_se)
    LinearLayout linearLayoutSe;
    Unbinder unbinder;

    private BaiduMap mBaiduMap;
    // GeoCoder mSearch = null; // 搜索模块，也可去掉地图模块独立使用
    ArrayList<LatLng> point = new ArrayList<LatLng>();

    // 坐标转换
    CoordinateConverter converter;

    Polyline mPolyline;

    private Marker markerStart;// 开始标记
    private Marker mMarkerCar;// 车标记

    private PoiSearch mPoiSearch = null;
    private SuggestionSearch mSuggestionSearch = null;

    private List<String> suggest;
    /**
     * 搜索关键字输入窗口
     */
    private ArrayAdapter<String> sugAdapter = null;
    private int loadIndex = 0;

    LatLng center = new LatLng(39.92235, 116.380338);
    int radius = 500;
    LatLng southwest = new LatLng(39.92235, 116.380338);
    LatLng northeast = new LatLng(39.947246, 116.414977);
    LatLngBounds searchbound = new LatLngBounds.Builder().include(southwest).include(northeast).build();

    int searchType = 0; // 搜索的类型，在显示时区分

    private String userID;

    private JSONArray pos_list = new JSONArray();
    private int pos_index = 0;

    BitmapDescriptor icon_car;// 车图标
    BitmapDescriptor icon_start;// 起始图标
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Subscription subscribe;
    private double mLat;
    private double mLon;


    public EleFenceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EleFenceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EleFenceFragment newInstance(double lat, double lon) {
        EleFenceFragment fragment = new EleFenceFragment();
        Bundle args = new Bundle();
        args.putDouble(ARG_LAT, lat);
        args.putDouble(ARG_LON, lon);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mLat = getArguments().getDouble(ARG_LAT);
            mLon = getArguments().getDouble(ARG_LAT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ele_fence, container, false);
        unbinder = ButterKnife.bind(this, view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            popStack();
            }
        });
        toolbarTitle.setText("区域设置");

        MapKeyApplication application = (MapKeyApplication) getApplication();
        userID= GetAppUtils.getUserID(application);


        icon_start = BitmapDescriptorFactory.fromResource(R.drawable.swzloc);
        icon_car = BitmapDescriptorFactory.fromResource(R.drawable.black_car_north);

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBaiduMap.clear();
                point.clear();
                pos_index = 0;
                pos_list = new JSONArray();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point.size() <= 2) {
                    Toast.makeText(mActivity, "围栏区域必须是封闭!", Toast.LENGTH_LONG).show();
                } else {
                    showDialog();
                }
            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchButtonProcess(v);
            }
        });

        // 初始化地图

        mBaiduMap = mMapView.getMap();
        // 普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);

        mMapView.getMap().animateMapStatus(MapStatusUpdateFactory.zoomTo(17));

        // mBaiduMap.setOnMapTouchListener(arg0);
        // 点击地图事件
        mBaiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            public boolean onMapPoiClick(MapPoi arg0) {
                return false;
            }

            public void onMapClick(LatLng arg0) {
                mBaiduMap.clear();
                point.add(arg0);

                JSONObject pos = new JSONObject();
                try {
                    pos.put("idx", pos_index);
                    pos.put("x", baiduToGcj02(arg0).latitude);
                    pos.put("y", baiduToGcj02(arg0).longitude);
                    pos_index++;
                    pos_list.put(pos);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                List<LatLng> points = new ArrayList<LatLng>();

                if (point.size() >= 1) {
                    // 起始图标
                    MarkerOptions ooA = new MarkerOptions().position(point.get(0)).icon(icon_start).zIndex(9)
                            .draggable(false);
                    markerStart = (Marker) (mBaiduMap.addOverlay(ooA));
                }

                if (point.size() > 1 && point.size() < 3) {
                    for (LatLng ll : point) {
                        points.add(ll);
                    }
                    OverlayOptions ooPolyline = new PolylineOptions().width(5).color(0xAA2e2efe).points(points);
                    mPolyline = (Polyline) mBaiduMap.addOverlay(ooPolyline);
                }
                if (point.size() > 2) {
                    for (LatLng ll : point) {
                        points.add(ll);
                    }
                    OverlayOptions ooPolygon = new PolygonOptions().points(points)
                            .stroke(new Stroke(point.size(), 0xAA2e2efe)).fillColor(0xAAa7dfff);
                    mBaiduMap.addOverlay(ooPolygon);
                }
                // Toast.makeText(EleFenceActivity.this, "lat" + arg0.latitude,
                // Toast.LENGTH_SHORT).show();
                // mBaiduMap.hideInfoWindow();
            }
        });

        mPoiSearch = PoiSearch.newInstance();
        mPoiSearch.setOnGetPoiSearchResultListener(this);

        // 初始化建议搜索模块，注册建议搜索事件监听
        mSuggestionSearch = SuggestionSearch.newInstance();
        mSuggestionSearch.setOnGetSuggestionResultListener(this);


        sugAdapter = new ArrayAdapter<String>(mActivity, android.R.layout.simple_dropdown_item_1line);
        addSearch.setAdapter(sugAdapter);
        addSearch.setThreshold(1);
        // mBaiduMap = ((SupportMapFragment)
        // (getSupportFragmentManager().findFragmentById(R.id.map))).getBaiduMap();

        /**
         * 当输入关键字变化时，动态更新建议列表
         */
        addSearch.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() <= 0) {
                    return;
                }

                /**
                 * 使用建议搜索服务获取建议列表，结果在onSuggestionResult()中更新
                 */
                mSuggestionSearch.requestSuggestion(
                        (new SuggestionSearchOption()).keyword(cs.toString()).city(citySearch.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        showCarPoi();
        return view;
    }

    // 显示车位置
    private void showCarPoi() {

        LatLng carPoint = new LatLng(mLat,mLon);

        OverlayOptions option = new MarkerOptions().position(carPoint).icon(icon_car);

        // 在地图上添加Marker，并显示
        mMarkerCar = (Marker) (mBaiduMap.addOverlay(option));
        mMapView.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(carPoint));// 设置地图中心点
    }

    /**
     * 弹出保存框
     */
    private void showDialog() {
        ViewHolder contentView = new ViewHolder(R.layout.dialog_save_fence);
        final DialogPlus dialog = DialogPlus.newDialog(mActivity)
                .setContentHolder(contentView)
                .setGravity(Gravity.CENTER)
                .setContentWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setContentHeight(ViewGroup.LayoutParams.MATCH_PARENT-96)
                .setCancelable(true)
                .setContentBackgroundResource(R.drawable.dialog_background)
                .create();

        View holderView = dialog.getHolderView();
        final EditText et_name = (EditText)holderView.findViewById(R.id.et_name);

        holderView.findViewById(R.id.ll_comfirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapKeyApplication application = (MapKeyApplication) getApplication();
                String userID = GetAppUtils.getUserID(application);

                String areaName = et_name.getText().toString();
                Req_Hfence_post req_hfence_post = new Req_Hfence_post();

                Area area = new Area();
                area.setAreaName(areaName);
                area.setMode("area");
                req_hfence_post.setUserId(userID);
                List<Area.PosListBean> posList = new ArrayList<Area.PosListBean>();
                //添加所有点坐标
                for(int i=0;i<pos_list.length();i++){
                    try {
                        pos_list.getJSONObject(i).getDouble("x");
                        double x = pos_list.getJSONObject(i).getDouble("x");
                        double y = pos_list.getJSONObject(i).getDouble("y");
                        int pos_index = pos_list.getJSONObject(i).getInt("idx");

                        Area.PosListBean posListBean = new Area.PosListBean();
                        posListBean.setIdx(pos_index);
                        posListBean.setX(x);
                        posListBean.setY(y);
                        posList.add(posListBean);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                area.setPosList(posList);
                req_hfence_post.setArea(new Gson().toJson(area));

                String param = new Gson().toJson(req_hfence_post);

                subscribe = PerfectHttp.createService(PandingService.class).hfence_post(param)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Hfence_post>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(Hfence_post hfence_post) {
                                if (hfence_post.getErrcode() == 0) {
                                    Toast.makeText(mActivity, hfence_post.getMsg(), Toast.LENGTH_LONG)
                                            .show();
                                    popStack();
                                }
                            }
                        });

                //保存操作
                dialog.dismiss();
            }
        });
        holderView.findViewById(R.id.ll_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    @Override
    public void onPause() {
        super.onPause();
        // activity 暂停时同时暂停地图控件
        mMapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        // activity 恢复时同时恢复地图控件
        mMapView.onResume();

    }


    // @Override
    // protected void onDestroy() {
    //
    // }

    /**
     * 响应城市内搜索按钮点击事件
     *
     * @param v
     */
    public void searchButtonProcess(View v) {
        searchType = 1;
        String citystr = citySearch.getText().toString();
        String keystr = addSearch.getText().toString();
        mPoiSearch.searchInCity((new PoiCitySearchOption()).city(citystr).keyword(keystr).pageNum(loadIndex));
    }

    /**
     * 获取POI搜索结果，包括searchInCity，searchNearby，searchInBound返回的搜索结果
     *
     * @param result
     */
    public void onGetPoiResult(PoiResult result) {
        if (result == null || result.error == SearchResult.ERRORNO.RESULT_NOT_FOUND) {
            Toast.makeText(mActivity, "未找到结果", Toast.LENGTH_LONG).show();
            return;
        }
        if (result.error == SearchResult.ERRORNO.NO_ERROR) {
            mBaiduMap.clear();
            PoiOverlay overlay = new MyPoiOverlay(mBaiduMap);
            mBaiduMap.setOnMarkerClickListener(overlay);
            overlay.setData(result);
            overlay.addToMap();
            overlay.zoomToSpan();
            return;
        }
        if (result.error == SearchResult.ERRORNO.AMBIGUOUS_KEYWORD) {

            // 当输入关键字在本市没有找到，但在其他城市找到时，返回包含该关键字信息的城市列表
            String strInfo = "在";
            for (CityInfo cityInfo : result.getSuggestCityList()) {
                strInfo += cityInfo.city;
                strInfo += ",";
            }
            strInfo += "找到结果";
            Toast.makeText(mActivity, strInfo, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 获取POI详情搜索结果，得到searchPoiDetail返回的搜索结果
     *
     * @param result
     */
    public void onGetPoiDetailResult(PoiDetailResult result) {
        if (result.error != SearchResult.ERRORNO.NO_ERROR) {
            Toast.makeText(mActivity, "抱歉，未找到结果", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mActivity, result.getName() + ": " + result.getAddress(), Toast.LENGTH_SHORT)
                    .show();
        }
    }

    @Override
    public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

    }

    /**
     * 获取在线建议搜索结果，得到requestSuggestion返回的搜索结果
     *
     * @param res
     */
    @Override
    public void onGetSuggestionResult(SuggestionResult res) {
        if (res == null || res.getAllSuggestions() == null) {
            return;
        }
        suggest = new ArrayList<String>();
        for (SuggestionResult.SuggestionInfo info : res.getAllSuggestions()) {
            if (info.key != null) {
                suggest.add(info.key);
            }
        }
        sugAdapter = new ArrayAdapter<String>(mActivity, android.R.layout.simple_dropdown_item_1line,
                suggest);
        addSearch.setAdapter(sugAdapter);
        sugAdapter.notifyDataSetChanged();
    }

    private class MyPoiOverlay extends PoiOverlay {

        public MyPoiOverlay(BaiduMap baiduMap) {
            super(baiduMap);
        }

        @Override
        public boolean onPoiClick(int index) {
            super.onPoiClick(index);
            PoiInfo poi = getPoiResult().getAllPoi().get(index);
            // if (poi.hasCaterDetails) {
            mPoiSearch.searchPoiDetail((new PoiDetailSearchOption()).poiUid(poi.uid));
            // }
            return true;
        }
    }

    /**
     * 百度坐标系 (BD-09) 与 火星坐标系 (GCJ-02)的转换 即 百度 转 谷歌、高德
     *
     * @returns {*[]}
     */
    private LatLng baiduToGcj02(LatLng baiduPoi) {
        double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
        double x = baiduPoi.longitude - 0.0065;
        double y = baiduPoi.latitude - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        double gg_lng = z * Math.cos(theta);
        double gg_lat = z * Math.sin(theta);
        LatLng baiduP = new LatLng(gg_lat, gg_lng);
        return baiduP;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (subscribe != null) {
            if (subscribe != null) {
                if (!subscribe.isUnsubscribed()) {
                    subscribe.unsubscribe();
                }
            }
        }
        unbinder.unbind();
        mMapView.onDestroy();
        mPoiSearch.destroy();
        mSuggestionSearch.destroy();
    }


}
