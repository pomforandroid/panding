package com.panding.main.pdservice.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import com.panding.main.Base.BaseContentragment;
import com.panding.main.Base.BaseFragment;
import com.panding.main.R;
import com.panding.main.pdinterface.OperateBackstackListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PdServiceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PdServiceFragment extends BaseFragment implements OperateBackstackListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public PdServiceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PdServiceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PdServiceFragment newInstance(String param1, String param2) {
        PdServiceFragment fragment = new PdServiceFragment();
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
        View view = inflater.inflate(R.layout.fragment_pd, container, false);

        //FirstFragment firstFragment = FirstFragment.newInstance(this);
        PandingFragment fragment = new PandingFragment();
        fragment.setOperateBackstackListener(this);
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.add(R.id.pdcontent,fragment,PandingFragment.class.getName());
        ft.addToBackStack(PandingFragment.class.getName());
        ft.commit();
        return view;
    }

    /**
     * 用反射获得fragment实例
     * @param fragmentClass
     */
    @Override
    public void pushStack(Class fragmentClass) {
        try {
            Method newInstance = fragmentClass.getDeclaredMethod("newInstance",OperateBackstackListener.class);
            try {
                Fragment fragment = (Fragment) newInstance.invoke(null,PdServiceFragment.this);
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.replace(R.id.pdcontent,fragment,fragmentClass.getName());
                ft.addToBackStack(fragmentClass.getName());
                ft.commit();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            Toast.makeText(getActivity(),"没有找到这个方法诶",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    /**
     * 直接传Fragment实例
     * @param fragment
     */
    @Override
    public void pushStack(Fragment fragment) {
        if(fragment instanceof BaseContentragment){
            ((BaseContentragment)fragment).setOperateBackstackListener(this);
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.replace(R.id.pdcontent,fragment,fragment.getClass().getName());
            ft.addToBackStack(fragment.getClass().getName());
            ft.commit();
        }else {
            throw new RuntimeException(mActivity.toString()
                    + " 你这个fragment继承了BaseContentragment了吗？");
        }

    }

    @Override
    public void popStack() {
        //退栈
        getChildFragmentManager().popBackStack();

    }
}
