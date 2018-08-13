/*
 * Copyright (c) 2018 Ryuusuke Azuma All Rights Reserved.
 */

package com.mynet.kazekima.fuse;

import android.support.v7.app.AppCompatActivity;

/**
 * {@link ActivityLifecycleListener} を拡張したAdapterクラス.
 * <p>
 * 本クラスは {@link ActivityLifecycleListener} を拡張し、必要なLifecycle通知を限定して
 * 実装させるための拡張クラスです.
 * </p>
 */
public class ActivityLifecycleAdapter implements ActivityLifecycleListener {

    @Override
    public void onActivityCreate(AppCompatActivity activity) {
        //do nothing
    }

    @Override
    public void onActivityDestroy(AppCompatActivity activity) {
        //do nothing
    }
}
