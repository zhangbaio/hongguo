package com.dragon.read.kmp.saas.reader.depend;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.n0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h implements dm4.j {
    public static final h a;

    static {
        Covode.recordClassIndex(608729);
        a = new h();
    }

    private h() {
    }

    @Override // dm4.j
    public void a(String event, ym4.a args) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(args, "args");
        com.dragon.read.reader.depend.a.b.m(event, n0.a(args));
    }
}
