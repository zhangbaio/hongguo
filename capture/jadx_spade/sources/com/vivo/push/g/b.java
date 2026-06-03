package com.vivo.push.g;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.vivo.push.util.ContextDelegate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private static volatile b c;
    private a a;
    private Context b;

    static {
        Covode.recordClassIndex(655040);
    }

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
            }
            bVar = c;
        }
        return bVar;
    }

    public final synchronized a a(Context context) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar;
        }
        if (context == null) {
            return null;
        }
        if (aVar == null) {
            this.b = ContextDelegate.getContext(context.getApplicationContext());
            this.a = new c(this.b);
        }
        return this.a;
    }
}
