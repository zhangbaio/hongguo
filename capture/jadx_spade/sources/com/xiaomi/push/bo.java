package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.xiaomi.push.bv;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class bo implements Runnable {
    private String a;

    /* renamed from: a, reason: collision with other field name */
    private WeakReference<Context> f158a;

    static {
        Covode.recordClassIndex(655384);
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f158a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (bz.a(this.a) > bn.f156a) {
            br a = br.a(this.a);
            bq a2 = bq.a(this.a);
            a.a(a2);
            a2.a(bp.a(context, this.a, 1000));
            bv.a(context).a((bv.a) a);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.b("=====> do not need clean db");
    }

    public bo(String str, WeakReference<Context> weakReference) {
        this.a = str;
        this.f158a = weakReference;
    }
}
