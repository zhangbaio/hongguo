package com.ss.ttvideoengine;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;
import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTVideoEngineLooperThread {
    private List<Condition> mCondList;
    private TTVideoEngine mEngine;
    private Lock mEngineMsgLock;
    Parcel mEngineMsgRetValue;
    private Lock mMainMsgLock;
    Parcel mMainMsgRetValue;
    private HandlerThread mMessageThread;
    private Handler mEngineMsgHandler = null;
    private Handler mMainLooperHandler = null;
    private boolean mIsHandlingMainMsg = false;
    boolean mInjectedMsgThread = false;
    boolean mInjectedMsgNotAllowDestroy = false;

    static {
        Covode.recordClassIndex(652359);
    }
}
