package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s0 {
    public static final s0 a;

    static {
        Covode.recordClassIndex(608881);
        a = new s0();
    }

    private s0() {
    }

    public final androidx.compose.ui.text.font.j a(String fontFamily) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        t tVar = (t) eo0.c.a.a(Reflection.getOrCreateKotlinClass(t.class));
        if (tVar != null) {
            return tVar.z6(fontFamily);
        }
        return null;
    }

    public final void b(String fontFamily, Function1<? super androidx.compose.ui.text.font.j, Unit> callback) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(callback, "callback");
        t tVar = (t) eo0.c.a.a(Reflection.getOrCreateKotlinClass(t.class));
        if (tVar != null) {
            tVar.h2(fontFamily, callback);
        } else {
            callback.invoke(null);
        }
    }
}
