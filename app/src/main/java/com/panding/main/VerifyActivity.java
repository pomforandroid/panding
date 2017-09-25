package com.panding.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.panding.main.customview.NoScrollViewPager;
import com.panding.main.pdinterface.OnStepListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerifyActivity extends AppCompatActivity implements OnStepListener {

    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rb_step1)
    RadioButton rbStep1;
    @BindView(R.id.rb_step2)
    RadioButton rbStep2;
    @BindView(R.id.rb_step3)
    RadioButton rbStep3;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.main_viewpager)
    NoScrollViewPager mainViewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        ButterKnife.bind(this);

        toolbarTitle.setText("账户激活");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rbStep1.setEnabled(false);
        rbStep2.setEnabled(false);
        rbStep3.setEnabled(false);

        //初始化viewpage第一个页面
        List<Fragment> fragments = new ArrayList<>();
        VerifyStepFragment step1_frag = VerifyStepFragment.newInstance(R.layout.fragment_verify_step1);
        VerifyStepFragment step2_frag = VerifyStepFragment.newInstance(R.layout.fragment_verify_step2);
        VerifyStepFragment step3_frag = VerifyStepFragment.newInstance(R.layout.fragment_verify_step3);

        //设置监听事件，让按下下一步时，可回调到下面的gostep方法
        step1_frag.setOnStepListener(VerifyActivity.this);
        step2_frag.setOnStepListener(VerifyActivity.this);
        step3_frag.setOnStepListener(VerifyActivity.this);

        fragments.add(step1_frag);
        fragments.add(step2_frag);
        fragments.add(step3_frag);
        NotePagerAdapter pagerAdapter = new NotePagerAdapter(getSupportFragmentManager(), fragments);
        mainViewpager.setAdapter(pagerAdapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_step1:
                        mainViewpager.setCurrentItem(0);
                        break;
                    case R.id.rb_step2:
                        mainViewpager.setCurrentItem(1);
                        break;
                    case R.id.rb_step3:
                        mainViewpager.setCurrentItem(2);
                        break;
                }
            }
        });
        rbStep1.setChecked(true);
    }

    @Override
    public void goStep(int id,boolean isNext) {
        switch (id){
            case 0:
                if(isNext){
                    rbStep2.setChecked(true);
                }
                break;
            case 1:
                if(isNext){
                    rbStep3.setChecked(true);
                }
                break;
            case 2:
                if(isNext){
                    Intent intent = new Intent(this,LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                break;
        }

    }

    private class NotePagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> mFragments;

        public NotePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

    }
}
