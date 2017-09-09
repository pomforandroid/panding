package com.panding.main.pdinterface;

import android.support.v4.app.Fragment;

import com.panding.main.Base.BaseContentragment;

/**
 * 操作出栈，进栈的接口
 */

public interface OperateBackstackListener<T extends Fragment> {
    /**
     * 进栈，用反射的
     */
    void pushStack(Class<T> fragmentClass);

    /**
     * 进栈，直接传对象
     */
    void pushStack(T t);
    /**
     * 出栈
     */
    void popStack();
}
