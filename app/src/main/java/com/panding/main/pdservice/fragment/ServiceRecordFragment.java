package com.panding.main.pdservice.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.panding.main.Base.BaseContentragment;
import com.panding.main.R;
import com.panding.main.perfecthttp.adapter.ServiceRecodAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ServiceRecordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ServiceRecordFragment extends BaseContentragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.goback)
    ImageView goback;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ServiceRecordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ServiceRecordFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ServiceRecordFragment newInstance(String param1, String param2) {
        ServiceRecordFragment fragment = new ServiceRecordFragment();
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
        View view = inflater.inflate(R.layout.fragment_service_record, container, false);
        unbinder = ButterKnife.bind(this, view);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popStack();
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(mActivity));
        rv.setAdapter(new ServiceRecodAdapter());
        tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ServiceCommentFragment serviceCommentFragment = new ServiceCommentFragment();
                pushStack(serviceCommentFragment);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
