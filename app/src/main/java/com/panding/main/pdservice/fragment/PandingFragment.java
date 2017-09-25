package com.panding.main.pdservice.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.panding.main.Base.BaseContentragment;
import com.panding.main.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PandingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PandingFragment extends BaseContentragment implements ViewPagerEx.OnPageChangeListener, BaseSliderView.OnSliderClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.slider)
    SliderLayout slider;
    Unbinder unbinder;
    @BindView(R.id.ll_service)
    LinearLayout llService;
    @BindView(R.id.ll_carecar)
    LinearLayout llCarecar;
    @BindView(R.id.ll_insurance)
    LinearLayout llInsurance;
    @BindView(R.id.ll_adviser)
    LinearLayout llAdviser;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public PandingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PandingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PandingFragment newInstance(String param1, String param2) {
        PandingFragment fragment = new PandingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_panding, container, false);
        unbinder = ButterKnife.bind(this, view);
        llService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pushStack(SecondFragment.class);
                ServiceRecordFragment serviceRecordFragment = new ServiceRecordFragment();
                pushStack(serviceRecordFragment);
            }
        });

        llCarecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CareCarFragment careCarFragment = new CareCarFragment();
                pushStack(careCarFragment);
            }
        });

        llInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsuranceFragment insuranceFragment = new InsuranceFragment();
                pushStack(insuranceFragment);
            }
        });

        llAdviser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdviserFragment adviserFragment = new AdviserFragment();
                pushStack(adviserFragment);
            }
        });

        initSlider();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initSlider() {
        HashMap<String, Integer> url_maps = new HashMap<String, Integer>();
        url_maps.put("新车上市", R.drawable.lunbo_1);
        url_maps.put("火爆抢购", R.drawable.lunbo_2);


        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(mActivity);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            slider.addSlider(textSliderView);
        }
        slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(4000);
        slider.addOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
