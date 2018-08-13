/*
 * Copyright (c) 2018 Ryuusuke Azuma All Rights Reserved.
 */

package com.mynet.kazekima.fuse;

import android.support.v7.app.AppCompatActivity;

/**
 * ActivityのLifecycle通知を受けるためのインターフェース.
 * <p>
 * 本インターフェースは ActivityのLifecycle通知を受けるためのインターフェースです.
 * </p>
 */
public interface ActivityLifecycleListener {

    /**
     * ActivityのLifecycleである{@link Activity#onCreate} 通知を受けます.
     *
     * @param activity 通知を受けたActivity
     */
    void onActivityCreate(AppCompatActivity activity);

    /**
     * ActivityのLifecycleである{@link Activity#onDestroy} 通知を受けます.
     *
     * @param activity 通知を受けたActivity
     */
    void onActivityDestroy(AppCompatActivity activity);
}
