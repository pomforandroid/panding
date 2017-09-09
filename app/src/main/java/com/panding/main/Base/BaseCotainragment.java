package com.panding.main.Base;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseCotainragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  getContent(inflater,  container,
                 savedInstanceState);
        return view;
    }

    protected View view;

    public abstract View getContent(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState);

  /*  private View getContent(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_pd, container, false);
        PandingFragment fragment = new PandingFragment();
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.add(R.id.pdcontent,fragment,PandingFragment.class.getName());
        ft.addToBackStack(PandingFragment.class.getName());
        ft.commit();
    }*/

}
