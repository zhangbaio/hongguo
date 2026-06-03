package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static final boolean b;
    private static final Lazy c;
    private static final Lazy d;

    private a() {
    }

    public final boolean e() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c() {
        return SeriesFpsV679.a.a().enablePrebind;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d() {
        return SeriesFpsOpt.a.b().enablePreloadHolder;
    }

    public final boolean f() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Covode.recordClassIndex(598258);
        a = new a();
        b = SeriesFpsOpt.a.b().enableFpsOpt;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean d2;
                d2 = com.dragon.read.component.shortvideo.api.config.a.d();
                return Boolean.valueOf(d2);
            }
        });
        c = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean c2;
                c2 = com.dragon.read.component.shortvideo.api.config.a.c();
                return Boolean.valueOf(c2);
            }
        });
        d = lazy2;
    }
}
