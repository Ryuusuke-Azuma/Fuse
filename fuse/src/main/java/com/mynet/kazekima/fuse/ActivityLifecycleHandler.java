/*
 * Copyright (c) 2018 Ryuusuke Azuma All Rights Reserved.
 */

package com.mynet.kazekima.fuse;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ActivityのLifecycle通知を受け取り、
 * 登録された {@link ActivityLifecycleListener} へ転送することを目的としたHandlerクラス.
 * <p>
 * 本クラスはActivityのLifecycle通知が呼び出されると、登録されてあるObserverの全てに
 * 呼び出されたLifecycle通知を転送します.
 * また、Observerとなる仕組みとして {@link Observer} インタフェースを提供します.
 * {@link Observer} はLifecycle通知を {@link ActivityLifecycleListener} 経由で受けれるように
 * {@link ActivityLifecycleListener} を実装する必要があります.
 * </p>
 */
public class ActivityLifecycleHandler {

    final List<ActivityLifecycleListener> mActivityLifecycleListeners = new ArrayList<>();

    /**
     * {@link Observer} を登録します.
     *
     * @param observers 通知を受ける {@link Observer}
     */
    public void resister(Observer... observers) {
        for (Observer observer : observers) {
            ActivityLifecycleListener listener = observer.getActivityLifecycleListener();
            if (mActivityLifecycleListeners.contains(listener)) {
                continue;
            }
            mActivityLifecycleListeners.add(listener);
        }
    }

    /**
     * {@link Observer} を解除します.
     *
     * @param observers 通知を停止する {@link Observer}
     */
    public void unresister(Observer... observers) {
        for (Observer observer : observers) {
            ActivityLifecycleListener listener = observer.getActivityLifecycleListener();
            mActivityLifecycleListeners.remove(listener);
        }
    }

    /**
     * ActivityのLifecycleである{@link Activity#onCreate} 通知を受けます.
     * また、登録された {@link ActivityLifecycleListener} へ転送します.
     *
     * @param activity 通知を受けたActivity
     */
    public void onActivityCreate(AppCompatActivity activity) {
        for (ActivityLifecycleListener listener : mActivityLifecycleListeners) {
            listener.onActivityCreate(activity);
        }
    }

    /**
     * ActivityのLifecycleである{@link Activity#onDestroy} 通知を受けます.
     * また、登録された {@link ActivityLifecycleListener} へ転送します.
     *
     * @param activity 通知を受けたActivity
     */
    public void onActivityDestroy(AppCompatActivity activity) {
        for (ActivityLifecycleListener listener : mActivityLifecycleListeners) {
            listener.onActivityDestroy(activity);
        }
    }

    /**
     * Lifecycle通知を {@link ActivityLifecycleListener} 経由で受けるようにするための
     * インターフェース.
     * <p>
     * 本インターフェースは {@link Activity} を継承しないクラスがActivityのLifecycle通知を
     * 受けるためのインターフェースです.
     * </p>
     */
    public interface Observer {

        ActivityLifecycleListener getActivityLifecycleListener();
    }
}
