package com.panding.main.pdservice.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.panding.main.Base.BaseContentragment;
import com.panding.main.R;
import com.panding.main.pdinterface.OperateBackstackListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends BaseContentragment{


    private OperateBackstackListener mListener;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    public FirstFragment() {
        // Required empty public constructor
    }


    private FirstFragment(OperateBackstackListener mListener) {
        // Required empty public constructor
        this.mListener =mListener;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(OperateBackstackListener mListener) {
        FirstFragment fragment = new FirstFragment(mListener);
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
        View view =  inflater.inflate(R.layout.fragment_first, container, false);
        Button btnext = (Button) view.findViewById(R.id.bt_next);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mListener!=null){
                    mListener.pushStack(SecondFragment.class);
                }
                /*SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.pdcontent,secondFragment,SecondFragment.class.getName());
                ft.addToBackStack(SecondFragment.class.getName());
                ft.commit();*/
            }
        });


        return view;
    }

}
