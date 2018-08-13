/*
 * Copyright (c) 2018 Ryuusuke Azuma All Rights Reserved.
 */

package com.mynet.kazekima.fuse;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * {@link Activity} アクセスの為のBridgeクラス.
 * <p>
 * 本クラスは {@link Activity} を継承しないクラスが {@link Activity} リソース
 * を取得する為のクラスです.
 * </p>
 */
public class ActivityBridge {

    private static final ActivityBridge sInstances = new ActivityBridge();
    private final Map<String, ActivitySession> mSessions = new HashMap<>();
    private final Stack<String> mStack = new Stack<>();

    /**
     * {@link ActivityBridge} インスタンスを取得します.
     *
     * @return {@link ActivityBridge} のインスタンス
     */
    public static ActivityBridge getInstances() {
        return sInstances;
    }

    /**
     * {@link ActivitySession} を追加します.
     *
     * @param session 追加する {@link ActivitySession}
     */
    public void addSession(ActivitySession session) {
        mSessions.put(session.getTag(), session);
        mStack.push(session.getTag());
    }

    /**
     * {@link ActivitySession} を削除します.
     *
     * @param session 削除する {@link ActivitySession}
     */
    public void deleteSession(ActivitySession session) {
        ActivitySession deleteSession = mSessions.get(session.getTag());
        if (deleteSession == null) {
            return;
        }
        if (deleteSession.hashCode() == session.hashCode()) {
            mSessions.remove(session.getTag());
            mStack.remove(session.getTag());
        }
    }

    /**
     * {@link AppCompatActivity} を取得します.
     *
     * @return {@link AppCompatActivity}
     */
    public AppCompatActivity getActivity() {
        ActivitySession targetSession = mSessions.get(mStack.peek());
        if (targetSession == null) {
            return null;
        }
        return targetSession.getActivity();
    }

    /**
     * {@link Context} を取得します.
     *
     * @return {@link Context}
     */
    public Context getContext() {
        ActivitySession targetSession = mSessions.get(mStack.peek());
        if (targetSession == null) {
            return null;
        }
        return targetSession.getActivity().getApplicationContext();
    }

    /**
     * {@link Resources} を取得します.
     *
     * @return {@link Resources}
     */
    public Resources getResources() {
        ActivitySession targetSession = mSessions.get(mStack.peek());
        if (targetSession == null) {
            return null;
        }
        return targetSession.getActivity().getResources();
    }
}
