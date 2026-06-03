package com.ss.ttvideoengine.utils;

import android.os.Looper;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class WeakHandler extends HandlerDelegate {
    private final WeakReference<IHandler> mRef;

    public interface IHandler {
        void handleMessage(Message message);
    }

    static {
        Covode.recordClassIndex(652769);
    }

    public void handleMessage(Message message) {
        IHandler iHandler = this.mRef.get();
        if (iHandler != null) {
            iHandler.handleMessage(message);
        }
    }

    public WeakHandler(IHandler iHandler) {
        this.mRef = new WeakReference<>(iHandler);
    }

    public WeakHandler(Looper looper, IHandler iHandler) {
        super(looper);
        this.mRef = new WeakReference<>(iHandler);
    }
}
