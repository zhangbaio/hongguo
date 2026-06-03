package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w0 {
    public static final w0 a;
    private static final Lazy b;
    public static final int c;

    private w0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v b() {
        return (v) eo0.c.a.a(Reflection.getOrCreateKotlinClass(v.class));
    }

    private final v c() {
        return (v) b.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(608884);
        a = new w0();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.service.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                v b2;
                b2 = w0.b();
                return b2;
            }
        });
        b = lazy;
        c = 8;
    }

    public final void d(Object obj, String str) {
        v c2 = c();
        if (c2 != null) {
            c2.u1(obj, str);
        }
    }
}
