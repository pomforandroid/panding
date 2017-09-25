package com.panding.main.swzgps.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
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
import com.baidu.mapapi.utils.DistanceUtil;
import com.google.gson.Gson;
import com.panding.main.Base.BaseContentragment;
import com.panding.main.Base.BaseUtils;
import com.panding.main.R;
import com.panding.main.application.MapKeyApplication;
import com.panding.main.baidu.overlayutil.PoiOverlay;
import com.panding.main.customview.MSeekBar;
import com.panding.main.customview.Rotate3dAnimation;
import com.panding.main.customview.SwitchButton;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PerfectHttp;
import com.panding.main.perfecthttp.request.Req_Bd_fence_del;
import com.panding.main.perfecthttp.request.Req_Bd_fence_get;
import com.panding.main.perfecthttp.request.Req_Bd_fence_post;
import com.panding.main.perfecthttp.request.Req_Bd_fence_put;
import com.panding.main.perfecthttp.response.Bd_fence_del;
import com.panding.main.perfecthttp.response.Bd_fence_get;
import com.panding.main.perfecthttp.response.Bd_fence_post;
import com.panding.main.perfecthttp.response.Bd_fence_put;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BdFenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BdFenceFragment extends BaseContentragment implements View.OnClickListener, OnGetPoiSearchResultListener, OnGetSuggestionResultListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_radius)
    TextView tvRadius;
    @BindView(R.id.seekbar)
    MSeekBar seekbar;
    @BindView(R.id.tv_commit)
    TextView tvCommit;
    @BindView(R.id.rl_backside)
    RelativeLayout rlBackside;
    @BindView(R.id.myswitch)
    SwitchButton myswitch;
    @BindView(R.id.bt_reset)
    Button btReset;
    @BindView(R.id.ll_forward)
    LinearLayout llForward;
    @BindView(R.id.rl_content)
    RelativeLayout rlContent;
    @BindView(R.id.bmapView)
    MapView mMapView;
    @BindView(R.id.iv_reset)
    ImageView ivReset;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;
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

    private String username;
    private String password;
    private BaiduMap mBaidumap;
    private Rotate3dAnimation openAnimation;
    private Rotate3dAnimation closeAnimation;

    private int centerX;
    private int centerY;
    private int depthZ = 400;
    private int duration = 300;
    private boolean isOpen = false; //判断是否点击了重置围栏的按钮
    private ArrayList<LatLng> points;
    private LatLng firstLatlng; // 点击的第一个点，即圆心中点
    private LatLng secondLatlng; //点击的第二点，计算出半径
    private double radius; // 围栏半径
    private int validateFlag;//围栏是否可用
    private int fenceId = -1; // 记录当前的围栏id，删除清空，如果为-1则是没有围栏，不允许删除
    private PoiSearch mPoiSearch;
    private SuggestionSearch mSuggestionSearch;
    private ArrayAdapter<String> sugAdapter;
    private ArrayList<String> suggest;

    public BdFenceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BdFenceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BdFenceFragment newInstance() {
        BdFenceFragment fragment = new BdFenceFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bd_fence, container, false);
        unbinder = ButterKnife.bind(this, view);
        mBaidumap = mMapView.getMap();
        MapKeyApplication application = (MapKeyApplication) getApplication();
        username = application.getUsername();
        password = application.getPassword();

        toolbarTitle.setText("电子围栏");

        myswitch.setOnSwitchListener(new SwitchButton.OnSwitchListener() {
            @Override
            public void onSwitch(boolean check) {
                if (check) {
                    //Toast.makeText(BdFenceActivity.this, "开了", Toast.LENGTH_SHORT).show();
                    validateFlag = 1;
                    commitFence();
                } else {
                    validateFlag = 0;
                    //Toast.makeText(BdFenceActivity.this, "关了", Toast.LENGTH_SHORT).show();
                    commitFence();
                }
            }
        });
        //去掉缩放按钮
        mMapView.showZoomControls(false);
        mBaidumap.setOnMapLoadedCallback(new BaiduMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                toolbar.setNavigationOnClickListener(BdFenceFragment.this);
                btReset.setOnClickListener(BdFenceFragment.this);
                ivReset.setOnClickListener(BdFenceFragment.this);
                ivDelete.setOnClickListener(BdFenceFragment.this);
                tvCommit.setOnClickListener(BdFenceFragment.this);
                getBdFence();
            }
        });
        points = new ArrayList<>();

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                radius = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            //setOnSeekBarChangeListener
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mBaidumap.clear();
                drawFence();
            }
        });
        addressSearch();
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchButtonProcess(v);
            }
        });
        return view;
    }

    private void addressSearch() {
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
    }

    private void getBdFence() {
        Req_Bd_fence_get req_bd_fence_get = new Req_Bd_fence_get();
        req_bd_fence_get.setUsernum(username);
        req_bd_fence_get.setPassword(password);

        String param = new Gson().toJson(req_bd_fence_get);
        PerfectHttp.createService(PandingService.class).bd_fence_get(param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bd_fence_get>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bd_fence_get bd_fence_get) {
                        if (bd_fence_get.getErrcode() == 0) {

                            validateFlag = bd_fence_get.getValidateFlag();
                            if (validateFlag == 1) {
                                myswitch.setCheck(true);
                            } else {
                                myswitch.setCheck(false);
                            }

                            String lat = bd_fence_get.getLat();
                            String lng = bd_fence_get.getLng();
                            //中心点位置
                            firstLatlng = BaseUtils.gpsTranstoBaidu(Double.parseDouble(lat), Double.parseDouble(lng));
                            points.clear();
                            points.add(firstLatlng);
                            fenceId = bd_fence_get.getId();
                            radius = bd_fence_get.getRadius();


                           /* LatLngBounds.Builder builder = new LatLngBounds.Builder();
                            builder.include(latLng);*/

                            drawFence();
                        }

                    }
                });
    }

    /**
     * 画出围栏
     */
    private void drawFence(){
        if(firstLatlng==null){
            return;
        }
        seekbar.setProgress((int) radius);
        int zoomLevel = BaseUtils.getZoomLevel(radius);
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory
                .newLatLngZoom(firstLatlng, zoomLevel);
        mBaidumap.setMapStatus(mapStatusUpdate);
        mBaidumap.getMaxZoomLevel();
        OverlayOptions circleOptions = new CircleOptions()
                .center(firstLatlng)
                .radius((int) radius)
                .fillColor(0xAAa7dfff)
                .stroke(new Stroke(5, getResources().getColor(R.color.colorPrimary)));

        mBaidumap.addOverlay(circleOptions);
    }

    /**
     * 卡牌文本介绍打开效果：注意旋转角度
     */
    private void initOpenAnim() {
        //从0到90度，顺时针旋转视图，此时reverse参数为true，达到90度时动画结束时视图变得不可见，
        openAnimation = new Rotate3dAnimation(0, 90, centerX, centerY, depthZ, true);
        openAnimation.setDuration(duration);
        openAnimation.setFillAfter(true);
        openAnimation.setInterpolator(new AccelerateInterpolator());
        openAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                llForward.setVisibility(View.GONE);
                rlBackside.setVisibility(View.VISIBLE);

                //从270到360度，顺时针旋转视图，此时reverse参数为false，达到360度动画结束时视图变得可见
                Rotate3dAnimation rotateAnimation = new Rotate3dAnimation(270, 360, centerX, centerY, depthZ, false);
                rotateAnimation.setDuration(duration);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                rlContent.startAnimation(rotateAnimation);
            }
        });
    }

    /**
     * 卡牌文本介绍关闭效果：旋转角度与打开时逆行即可
     */
    private void initCloseAnim() {
        closeAnimation = new Rotate3dAnimation(360, 270, centerX, centerY, depthZ, true);
        closeAnimation.setDuration(duration);
        closeAnimation.setFillAfter(true);
        closeAnimation.setInterpolator(new AccelerateInterpolator());
        closeAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                llForward.setVisibility(View.VISIBLE);
                rlBackside.setVisibility(View.GONE);

                Rotate3dAnimation rotateAnimation = new Rotate3dAnimation(90, 0, centerX, centerY, depthZ, false);
                rotateAnimation.setDuration(duration);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                rlContent.startAnimation(rotateAnimation);
            }
        });
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
        mMapView.onDestroy();
        unbinder.unbind();
    }
    /**
     * 重置围栏
     */
    private void reset() {
        mBaidumap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                points.add(latLng);
                if (points.size() == 1) {
                    //保存第一个点
                    firstLatlng = latLng;
                }
                //在地图上添加第一点的Marker并显示
                BitmapDescriptor bitmap = BitmapDescriptorFactory
                        .fromResource(R.drawable.swzloc);
                OverlayOptions option = new MarkerOptions()
                        .position(firstLatlng)
                        .icon(bitmap);
                mBaidumap.addOverlay(option);

                if (points.size() == 2) {
                    mBaidumap.clear();
                    //保存第二个点
                    secondLatlng = latLng;
                    //计算出两点之间距离为半径
                    radius = DistanceUtil.getDistance(firstLatlng, secondLatlng);
                    //然后画出圆
                    drawFence();
                   /* int zoomLevel = BaseUtils.getZoomLevel((int) radius);
                    MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory
                            .newLatLngZoom(firstLatlng, zoomLevel);
                    mBaidumap.setMapStatus(mapStatusUpdate);
                    mBaidumap.getMaxZoomLevel();

                    OverlayOptions circleOptions = new CircleOptions()
                            .center(firstLatlng)
                            .radius((int) radius)
                            .fillColor(0xAAa7dfff)
                            .stroke(new Stroke(5, 0xAA2e2efe));

                    mBaidumap.addOverlay(circleOptions);*/

                    //再去掉第二个点
                    points.remove(1);
                }
            }

            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_reset:
                reset();
                //以旋转对象的中心点为旋转中心点，这里主要不要再onCreate方法中获取，因为视图初始绘制时，获取的宽高为0
                centerX = rlContent.getWidth() / 2;
                centerY = rlContent.getHeight() / 2;

                if (openAnimation == null) {
                    initOpenAnim();
                }

                //用作判断当前点击事件发生时动画是否正在执行
                if (openAnimation.hasStarted() && !openAnimation.hasEnded()) {
                    return;
                }

                rlContent.startAnimation(openAnimation);
                isOpen = !isOpen;
                break;

            case R.id.iv_reset:
                mBaidumap.clear();
                points.clear();
                firstLatlng = null;
                secondLatlng = null;
                break;

            case R.id.iv_delete:
                delFence();

                break;

            case R.id.tv_commit:
                if (secondLatlng == null) {
                    Toast.makeText(mActivity, "请在地图上画出围栏范围", Toast.LENGTH_SHORT).show();
                    return;
                }
                commitFence();
                break;

            default:
                //如果没有打开的话，就是退栈
                if (!isOpen) {
                    popStack();
                } else {
                    //清空图层
                    mBaidumap.clear();
                    //
                    mBaidumap.setOnMapClickListener(null);
                    //再重新获得围栏
                    getBdFence();

                    centerX = rlContent.getWidth() / 2;
                    centerY = rlContent.getHeight() / 2;

                    if (closeAnimation == null) {
                        initCloseAnim();
                    }
                    if (closeAnimation.hasStarted() && !closeAnimation.hasEnded()) {
                        return;
                    }
                    rlContent.startAnimation(closeAnimation);

                    isOpen = !isOpen;
                }
                break;
        }
    }

    /**
     * 新增或者修改围栏
     */
    private void commitFence() {
        if(firstLatlng==null){
            return;
        }

        if (fenceId == -1) {
            //新增
            LatLng gcj02_latLng = BaseUtils.baiduToGcj02(firstLatlng);
            LatLng gpsLatlng = BaseUtils.gcj02ToWgs84(gcj02_latLng);
            Req_Bd_fence_post req_bd_fence_post = new Req_Bd_fence_post();
            req_bd_fence_post.setLat(String.valueOf(gpsLatlng.latitude));
            req_bd_fence_post.setLng(String.valueOf(gpsLatlng.longitude));
            req_bd_fence_post.setPassword(password);
            req_bd_fence_post.setUsernum(username);
            req_bd_fence_post.setRadius((int) radius);
            String param = new Gson().toJson(req_bd_fence_post);
            PerfectHttp.createService(PandingService.class).bd_fence_post(param)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Bd_fence_post>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(Bd_fence_post bd_fence_post) {
                            if (bd_fence_post.getErrcode() == 0) {
                                radius = bd_fence_post.getRadius();
                                String lat = bd_fence_post.getLat();
                                String lng = bd_fence_post.getLng();
                                Toast.makeText(mActivity, bd_fence_post.getMsg(), Toast.LENGTH_SHORT)
                                        .show();
                                String userId = bd_fence_post.getUserId();
                                fenceId = bd_fence_post.getId();
                            }
                        }
                    });
        } else {
            LatLng gcj02_latLng = BaseUtils.baiduToGcj02(firstLatlng);
            LatLng gpsLatlng = BaseUtils.gcj02ToWgs84(gcj02_latLng);
            Req_Bd_fence_put req_bd_fence_put = new Req_Bd_fence_put();
            req_bd_fence_put.setId(fenceId);
            req_bd_fence_put.setPassword(password);
            req_bd_fence_put.setUsernum(username);
            req_bd_fence_put.setRadius((int) radius);
            req_bd_fence_put.setLat(String.valueOf(gpsLatlng.latitude));
            req_bd_fence_put.setLng(String.valueOf(gpsLatlng.longitude));
            req_bd_fence_put.setValidateFlag(validateFlag);
            String param = new Gson().toJson(req_bd_fence_put);
            PerfectHttp.createService(PandingService.class).bd_fence_put(param)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<Bd_fence_put>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(Bd_fence_put bd_fence_put) {
                            if (bd_fence_put.getErrcode() == 0) {
                                Toast.makeText(mActivity, bd_fence_put.getMsg(), Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    });
        }


    }

    /**
     * 删除围栏
     */
    private void delFence() {
        if (fenceId == -1) {
            Toast.makeText(mActivity, "没有围栏可删除", Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        Req_Bd_fence_del req_bd_fence_del = new Req_Bd_fence_del();
        req_bd_fence_del.setUsernum(username);
        req_bd_fence_del.setPassword(password);
        req_bd_fence_del.setId(fenceId);
        String param = new Gson().toJson(req_bd_fence_del);
        PerfectHttp.createService(PandingService.class).bd_fence_del(param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bd_fence_del>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bd_fence_del bd_fence_del) {
                        if (bd_fence_del.getErrcode() == 0) {
                            fenceId = -1;
                            mBaidumap.clear();
                            Toast.makeText(mActivity, bd_fence_del.getMsg(), Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }
                });
    }

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


    /**
     * 响应城市内搜索按钮点击事件
     *
     * @param v
     */
    public void searchButtonProcess(View v) {
        mBaidumap.clear();
        firstLatlng = null;
        secondLatlng = null;
        points.clear();
        String citystr = citySearch.getText().toString();
        String keystr = addSearch.getText().toString();
        mPoiSearch.searchInCity((new PoiCitySearchOption()).city(citystr).keyword(keystr).pageNum(0));
    }

    @Override
    public void onGetPoiResult(PoiResult result) {
        if (result == null || result.error == SearchResult.ERRORNO.RESULT_NOT_FOUND) {
            Toast.makeText(mActivity, "未找到结果", Toast.LENGTH_LONG).show();
            return;
        }
        if (result.error == SearchResult.ERRORNO.NO_ERROR) {
            mBaidumap.clear();
            PoiOverlay overlay = new MyPoiOverlay(mBaidumap);
            mBaidumap.setOnMarkerClickListener(overlay);
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

    @Override
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
}
