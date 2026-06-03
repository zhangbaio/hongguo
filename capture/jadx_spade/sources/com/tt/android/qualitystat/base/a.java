package com.tt.android.qualitystat.base;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.lang.ref.WeakReference;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static WeakReference<Context> a;
    public static final a b;

    private a() {
    }

    public final Context getContext() {
        return a.get();
    }

    static {
        Covode.recordClassIndex(654024);
        b = new a();
        a = new WeakReference<>(null);
    }

    public final void a(Context context) {
        a.clear();
        a = new WeakReference<>(context.getApplicationContext());
    }
}
