package com.ttnet.org.chromium.base;

import android.os.Looper;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class r extends HandlerDelegate {
    WeakReference<a> c;

    public interface a {
        void handleMsg(Message message);
    }

    static {
        Covode.recordClassIndex(654264);
    }

    public void handleMessage(Message message) {
        a aVar = this.c.get();
        if (aVar != null && message != null) {
            aVar.handleMsg(message);
        }
    }

    public r(Looper looper, a aVar) {
        super(looper);
        this.c = new WeakReference<>(aVar);
    }
}
