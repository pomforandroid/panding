package com.panding.main;

import android.os.Bundle;
import android.os.Process;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.gson.Gson;
import com.panding.main.Base.BaseActivity;
import com.panding.main.Base.BaseFragment;
import com.panding.main.Base.CheckPermissionsActivity;
import com.panding.main.account.fragment.AccountContentFragment;
import com.panding.main.account.fragment.AccountFragment;
import com.panding.main.carclub.fragment.CarClubContentFragment;
import com.panding.main.pdservice.fragment.PdServiceFragment;
import com.panding.main.perfecthttp.PandingService;
import com.panding.main.perfecthttp.PdPerfectHttp;
import com.panding.main.perfecthttp.PerfectHttp;
import com.panding.main.perfecthttp.request.Req_pd_baoxian_get;
import com.panding.main.perfecthttp.request.Req_pd_remind_get;
import com.panding.main.perfecthttp.request.Req_pd_repair_get;
import com.panding.main.perfecthttp.request.Req_pd_vip_get;
import com.panding.main.perfecthttp.response.Pd_baoxian_get;
import com.panding.main.perfecthttp.response.Pd_remind_get;
import com.panding.main.perfecthttp.response.Pd_repair_get;
import com.panding.main.perfecthttp.response.Pd_vip_get;
import com.panding.main.swzgps.fragment.SwzContentFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends CheckPermissionsActivity {

    private static final String[] TAGS = {"swz", "panding", "carclue", "account"};
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
    private ArrayList<Fragment> fragments;
    private int prePos;
    private String PRE = "PREPOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            //默认为0
            prePos = 0;
            fragments = new ArrayList<>(3);
            buildFragmentList();
        } else {
            //内存被回收了，fragments的list也被回收了，重新add进去
            prePos = savedInstanceState.getInt(PRE);
            fragments = new ArrayList<>(3);
            SwzContentFragment swzContentFragment = (SwzContentFragment) getSupportFragmentManager().findFragmentByTag(TAGS[0]);
            PdServiceFragment pdServiceFragment = (PdServiceFragment) getSupportFragmentManager().findFragmentByTag(TAGS[1]);
            CarClubContentFragment carClubContentFragment = (CarClubContentFragment) getSupportFragmentManager().findFragmentByTag(TAGS[2]);
            AccountFragment accountFragment = (AccountFragment) getSupportFragmentManager().findFragmentByTag(TAGS[3]);
            fragments.add(swzContentFragment);
            fragments.add(pdServiceFragment);
            fragments.add(carClubContentFragment);
            fragments.add(accountFragment);
        }

        setDefaultFragment(prePos);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.navigation_gps) {
                    switchFragment(0);
                }

                if (tabId == R.id.navigation_home) {
                    switchFragment(1);
                }

                if (tabId == R.id.navigation_carclub) {
                    switchFragment(2);
                }

                if (tabId == R.id.navigation_account) {
                    switchFragment(3);
                }

            }
        },false);

    }

    /**
     * 通过网络访问获得pd的数据，存入sharepreference中
     */
    private void getPdData(){
        String pdPassword = getPDPassword();
        String pdUsername = getPDUsername();

        //保险信息参数
        Req_pd_baoxian_get req_pd_baoxian_get = new Req_pd_baoxian_get();
        req_pd_baoxian_get.setPassword(pdPassword);
        req_pd_baoxian_get.setUsername(pdUsername);
        String baoxian_param = new Gson().toJson(req_pd_baoxian_get);
        //提醒信息参数
        Req_pd_remind_get req_pd_remind_get = new Req_pd_remind_get();
        req_pd_remind_get.setUsername(pdUsername);
        req_pd_remind_get.setPassword(pdPassword);
        String remind_param = new Gson().toJson(req_pd_remind_get);
        //维修信息参数
        Req_pd_repair_get req_pd_repair_get = new Req_pd_repair_get();
        req_pd_repair_get.setUsername(pdUsername);
        req_pd_repair_get.setPassword(pdPassword);
        String repair_param = new Gson().toJson(req_pd_repair_get);
        //会员信息参数
        Req_pd_vip_get req_pd_vip_get = new Req_pd_vip_get();
        req_pd_vip_get.setPassword(pdPassword);
        req_pd_vip_get.setUsername(pdUsername);
        String vipget_param = new Gson().toJson(req_pd_vip_get);

        Observable<Pd_baoxian_get> pd_baoxian_getObservable = PdPerfectHttp.createService(PandingService.class)
                .pd_baoxian_get(baoxian_param);
        Observable<Pd_remind_get> pd_remind_getObservable = PdPerfectHttp.createService(PandingService.class)
                .pd_remind_get(remind_param);
        Observable<Pd_repair_get> pd_repair_getObservable = PdPerfectHttp.createService(PandingService.class)
                .pd_repair_get(repair_param);
        Observable<Pd_vip_get> pd_vip_getObservable = PdPerfectHttp.createService(PandingService.class)
                .pd_vip_get(vipget_param);
        Observable.merge(pd_baoxian_getObservable,pd_remind_getObservable
                ,pd_repair_getObservable,pd_vip_getObservable)
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

                    }
                });
    }

    private void buildFragmentList() {
        SwzContentFragment swzContentFragment = new SwzContentFragment();
        PdServiceFragment pdServiceFragment = new PdServiceFragment();
        CarClubContentFragment carClubContentFragment = new CarClubContentFragment();
        AccountContentFragment accountContentFragment = new AccountContentFragment();

        fragments.add(swzContentFragment);
        fragments.add(pdServiceFragment);
        fragments.add(carClubContentFragment);
        fragments.add(accountContentFragment);
    }

    private void switchFragment(int pos) {
        //Toast.makeText(this,prePos+" -> "+pos,Toast.LENGTH_LONG).show();
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        Fragment from = fragments.get(prePos);
        Fragment to = fragments.get(pos);
        if (!to.isAdded()) {
            transaction.hide(from)
                    .add(R.id.content, to, TAGS[pos])
                    .commit();
        } else {
            transaction.hide(from)
                    .show(to)
                    .commit();
        }
        prePos = pos;
    }

    //设置默认
    private void setDefaultFragment(int pos) {
        Fragment now = fragments.get(pos);
        if (!now.isAdded()) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, fragments.get(pos), TAGS[pos])
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .show(now)
                    .commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存上一个位置
        outState.putInt(PRE, prePos);
    }

    private long exitTime = 0;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
            Process.killProcess(Process.myPid());
        }
    }
}
