package com.panding.main.Base;

import android.support.v4.app.Fragment;

import com.panding.main.pdinterface.OperateBackstackListener;


public class BaseContentragment extends BaseFragment {
    public OperateBackstackListener mListener;

    public void setOperateBackstackListener(OperateBackstackListener mListener){
        this.mListener = mListener;
    }

    /**
     * 出栈
     */
    protected void popStack(){
        if(mListener!=null){
            mListener.popStack();
        }
    }

    /**
     * 进栈
     */
    protected void pushStack(Fragment fragment){
        if(mListener!=null){
           mListener.pushStack(fragment);
        }
    }

    protected void pushStack(Class<? extends Fragment> fragmentClass){
        if(mListener!=null){
            mListener.pushStack(fragmentClass);
        }
    }

}
