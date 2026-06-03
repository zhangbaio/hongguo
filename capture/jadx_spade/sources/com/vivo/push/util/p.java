package com.vivo.push.util;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.h.u;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class p implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ o b;

    static {
        Covode.recordClassIndex(655201);
    }

    @Override // java.lang.Runnable
    public final void run() {
        InsideNotificationItem insideNotificationItem;
        long j;
        Context context;
        InsideNotificationItem insideNotificationItem2;
        long j2;
        int i;
        NotifyArriveCallbackByUser notifyArriveCallbackByUser;
        u.a aVar;
        insideNotificationItem = this.b.b;
        if (insideNotificationItem != null) {
            ad c = ad.c();
            j = this.b.c;
            c.a("com.vivo.push.notify_key", j);
            context = this.b.a;
            List list = this.a;
            insideNotificationItem2 = this.b.b;
            j2 = this.b.c;
            i = this.b.e;
            notifyArriveCallbackByUser = this.b.f;
            aVar = this.b.g;
            NotifyAdapterUtil.pushNotification(context, list, insideNotificationItem2, j2, i, notifyArriveCallbackByUser, aVar);
        }
    }

    p(o oVar, List list) {
        this.b = oVar;
        this.a = list;
    }
}
