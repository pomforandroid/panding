package com.panding.main;


import android.os.Bundle;
import android.os.Process;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.panding.main.account.fragment.AccountContentFragment;
import com.panding.main.account.fragment.AccountFragment;
import com.panding.main.carclub.fragment.CarClubContentFragment;
import com.panding.main.pdservice.fragment.PdServiceFragment;
import com.panding.main.swzgps.fragment.SwzContentFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity_bak2 extends AppCompatActivity {

    private static final String[] TAGS = {"swz", "panding", "carclue", "account"};

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
       /* bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
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
        });*/

        //设置默认
        //setDefaultFragment(prePos);

      /*  PdServiceFragment pdServiceFragment = new PdServiceFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content,pdServiceFragment,PdServiceFragment.class.getName())
                .commit();*/
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
                    .add(R.id.content, fragments.get(pos), TAGS[pos])
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
                    .add(R.id.content, fragments.get(prePos), TAGS[pos])
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
