package com.unionpay;

import android.os.Bundle;
import android.os.Handler;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class i implements n36.d {
    static {
        Covode.recordClassIndex(654867);
    }

    i() {
    }

    public final void a(int i, Bundle bundle) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler.Callback callback;
        handler = a.W;
        if (handler == null) {
            callback = a.c0;
            Handler unused = a.W = new HandlerDelegate(callback);
        }
        handler2 = a.W;
        handler3 = a.W;
        handler2.sendMessage(handler3.obtainMessage(1003, Integer.valueOf(i)));
    }
}
