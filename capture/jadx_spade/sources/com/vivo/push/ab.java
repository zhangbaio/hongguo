package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class ab {
    protected Context a;
    protected Handler b;
    private final Object c = new Object();

    static {
        Covode.recordClassIndex(654979);
    }

    public abstract void b(Message message);

    public ab() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.a = context;
    }

    class a extends HandlerDelegate {
        static {
            Covode.recordClassIndex(654980);
        }

        public final void handleMessage(Message message) {
            ab.this.b(message);
        }

        public a(Looper looper) {
            super(looper);
        }
    }

    public final void a(Message message) {
        synchronized (this.c) {
            Handler handler = this.b;
            if (handler == null) {
                String str = "Dead worker dropping a message: " + message.what;
                com.vivo.push.util.t.e(getClass().getSimpleName(), str + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                handler.sendMessage(message);
            }
        }
    }
}
