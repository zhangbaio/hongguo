package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class t {
    private static final Handler a;
    private static final HandlerThread b;
    private static final Handler c;

    static {
        Covode.recordClassIndex(655156);
        a = new HandlerDelegate(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        b = handlerThread;
        handlerThread.start();
        c = new u(handlerThread.getLooper());
    }

    public static void a(Runnable runnable) {
        a.post(runnable);
    }

    public static void b(Runnable runnable) {
        Handler handler = c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void a(r rVar) {
        Handler handler = c;
        handler.removeCallbacks(rVar);
        handler.postDelayed(rVar, 15000L);
    }

    public static void a(s sVar, long j) {
        if (sVar == null) {
            com.vivo.push.util.t.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a2 = sVar.a();
        if (j > 0) {
            c.removeMessages(a2);
        }
        Message message = new Message();
        message.what = a2;
        message.obj = sVar;
        c.sendMessageDelayed(message, j);
    }
}
