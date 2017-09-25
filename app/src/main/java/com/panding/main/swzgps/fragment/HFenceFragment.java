package com.panding.main.swzgps.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension;
import com.panding.main.Base.BaseContentragment;
import com.panding.main.R;
import com.panding.main.application.GetAppUtils;
import com.panding.main.application.MapKeyApplication;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PerfectHttp;
import com.panding.main.perfecthttp.adapter.DividerItemDecoration;
import com.panding.main.perfecthttp.adapter.HFenceSwipeAdapter;
import com.panding.main.perfecthttp.adapter.ItemTouchHelperCallback;
import com.panding.main.perfecthttp.request.Req_H_Location_last;
import com.panding.main.perfecthttp.request.Req_Hfence_get;
import com.panding.main.perfecthttp.response.H_Location_last;
import com.panding.main.perfecthttp.response.Hfence_get;

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
 * Use the {@link HFenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HFenceFragment extends BaseContentragment implements HFenceSwipeAdapter.OnDeleteClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.tv_ticks)
    TextView tvTicks;
    @BindView(R.id.bt_add)
    Button btAdd;
    Unbinder unbinder;

    private HFenceSwipeAdapter adapter;
    private ItemTouchHelperExtension mItemTouchHelper;

    private ItemTouchHelperCallback mCallback;
    private String userID;

    // TODO: Rename and change types of parameters
    private Subscription subscribe;
    private Subscription add_subscribe;


    public HFenceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HFenceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HFenceFragment newInstance() {
        HFenceFragment fragment = new HFenceFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hfence, container, false);
        unbinder = ButterKnife.bind(this, view);

        toolbarTitle.setText("电子围栏列表");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            popStack();
            }
        });


        MapKeyApplication application = (MapKeyApplication) getApplication();
        userID = GetAppUtils.getUserID(application);
        rv.setLayoutManager(new LinearLayoutManager(mActivity));
        adapter = new HFenceSwipeAdapter(mActivity,userID);
        rv.setAdapter(adapter);
        rv.addItemDecoration(new DividerItemDecoration(mActivity));
        mCallback = new ItemTouchHelperCallback();
        mItemTouchHelper = new ItemTouchHelperExtension(mCallback);

        mItemTouchHelper.attachToRecyclerView(rv);
        adapter.setItemTouchHelperExtension(mItemTouchHelper);
        adapter.setOnDeleteClickListener(this);
        initData();
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapKeyApplication application = (MapKeyApplication) getApplication();
                String carLicenseNum = application.getLoginHSingle().getCarLicenseNum();
                String objectId = application.getLoginHSingle().getObjectId();
                Req_H_Location_last req_H_location_last = new Req_H_Location_last();
                req_H_location_last.setVehicleNum(carLicenseNum);
                req_H_location_last.setObjectId(objectId);
                String param = new Gson().toJson(req_H_location_last);

                add_subscribe = PerfectHttp.createService(PandingService.class).h_location_last(param)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<H_Location_last>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                EleFenceFragment eleFenceFragment = EleFenceFragment.newInstance(39.92235, 116.380338);
                                pushStack(eleFenceFragment);
                            }

                            @Override
                            public void onNext(H_Location_last hLocation_last) {
                                if (hLocation_last.getErrcode() == 0) {
                                    EleFenceFragment eleFenceFragment = EleFenceFragment.
                                            newInstance(hLocation_last.getLat(), hLocation_last.getLon());
                                    pushStack(eleFenceFragment);

                                } else {
                                    EleFenceFragment eleFenceFragment = EleFenceFragment.newInstance(39.92235, 116.380338);
                                    pushStack(eleFenceFragment);
                                }
                            }

                        });


            }
        });
        return view;
    }

    /**
     * 停止更新
     */
    private void stopInitdata() {
        if (subscribe != null) {
            if (subscribe != null) {
                if (!subscribe.isUnsubscribed()) {
                    subscribe.unsubscribe();
                }
            }
        }
        if (add_subscribe != null) {
            if (add_subscribe != null) {
                if (!add_subscribe.isUnsubscribed()) {
                    add_subscribe.unsubscribe();
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        stopInitdata();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        Req_Hfence_get req_hfence_get = new Req_Hfence_get();
        req_hfence_get.setUserId(userID);

        String param = new Gson().toJson(req_hfence_get);

        subscribe = PerfectHttp.createService(PandingService.class).hfence_get(param)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Hfence_get>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        tvTicks.setText("没有围栏信息");
                    }

                    @Override
                    public void onNext(Hfence_get hfence_get) {
                        if (hfence_get.getErrcode() == 0) {
                            tvTicks.setText("");

                            final List<Hfence_get.AreaBean> area = hfence_get.getArea();
                            if (area.size() == 0) {
                                tvTicks.setText("没有围栏信息");
                            }

                            adapter.updateData(area);
                            //点击进入绑定的fragment
                            adapter.setOnItemClickListener(new HFenceSwipeAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(int position, View view, RecyclerView.ViewHolder vh) {
                                    Hfence_get.AreaBean areaBean = area.get(position);
                                    FenceBindFragment fenceBindFragment = FenceBindFragment.newInstance(areaBean);
                                    pushStack(fenceBindFragment);
                                    /*Hfence_get.AreaBean areaBean = area.get(position);
                                    Intent intent = new Intent(mActivity, BindCarActivity.class);
                                    intent.putExtra("area", areaBean);
                                    startActivity(intent);*/
                                }
                            });

                        } else {
                            tvTicks.setText("没有围栏信息");
                        }
                    }
                });


    }


    @Override
    public void onDeleteClick(boolean success) {
        if (success) {
            Toast.makeText(mActivity, "删除成功", Toast.LENGTH_SHORT).show();
            //关闭右侧的按钮
            mItemTouchHelper.closeOpened();
        } else {
            Toast.makeText(mActivity, "删除失败", Toast.LENGTH_SHORT).show();
            mItemTouchHelper.closeOpened();
        }

    }
}
