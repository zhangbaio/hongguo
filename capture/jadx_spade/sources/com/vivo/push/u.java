package com.vivo.push;

import android.os.Looper;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class u extends HandlerDelegate {
    static {
        Covode.recordClassIndex(655157);
    }

    u(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof s) {
            s sVar = (s) obj;
            com.vivo.push.util.t.c("PushClientThread", "PushClientThread-handleMessage, task = ".concat(String.valueOf(sVar)));
            sVar.run();
        }
    }
}
