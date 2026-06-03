package com.vivo.push.restructure.request;

import android.os.Looper;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.vivo.push.util.g;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class e extends HandlerDelegate {
    final /* synthetic */ d a;

    static {
        Covode.recordClassIndex(655145);
    }

    public final void handleMessage(Message message) {
        Map map;
        Map map2;
        int i = message.what;
        map = this.a.a;
        if (map.containsKey(Integer.valueOf(i))) {
            map2 = this.a.a;
            g.a().execute(new f(this, (b) map2.remove(Integer.valueOf(i))));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e(d dVar, Looper looper) {
        super(looper);
        this.a = dVar;
    }
}
