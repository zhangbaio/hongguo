package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k0 implements d {
    public static final k0 b;
    public static final int c;
    private final /* synthetic */ d a;

    static {
        Covode.recordClassIndex(608875);
        b = new k0();
        c = 8;
    }

    @Override // com.dragon.read.kmp.service.d
    public String z5() {
        return this.a.z5();
    }

    private k0() {
        eo0.a a = eo0.c.a.a(Reflection.getOrCreateKotlinClass(d.class));
        Intrinsics.checkNotNull(a);
        this.a = (d) a;
    }
}
