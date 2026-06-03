package com.dragon.read.kmp.saas.reader.depend;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.f0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f implements dm4.i {
    public static final f a;

    static {
        Covode.recordClassIndex(608727);
        a = new f();
    }

    private f() {
    }

    @Override // dm4.i
    public boolean isNetworkAvailable(Context context) {
        return f0.a.b(context);
    }
}
