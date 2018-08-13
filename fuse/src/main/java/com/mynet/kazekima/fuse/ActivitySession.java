/*
 * Copyright (c) 2018 Ryuusuke Azuma All Rights Reserved.
 */

package com.mynet.kazekima.fuse;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

/**
 * {@link Activity} が返すSessionクラス.
 * <p>
 * 本クラスは {@link ActivityBridge} が {@link Activity} リソース
 * を参照するためのクラスです.
 * </p>
 */
public interface ActivitySession {

    /**
     * Activity毎のタグを取得します.
     *
     * @return タグ
     */
    String getTag();

    /**
     * Activity毎の {@link AppCompatActivity} インスタンスを取得します.
     *
     * @return 自身の {@link AppCompatActivity} インスタンス
     */
    AppCompatActivity getActivity();
}
