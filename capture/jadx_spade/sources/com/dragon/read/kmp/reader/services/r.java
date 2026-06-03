package com.dragon.read.kmp.reader.services;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r implements c {
    public static final r a;

    static {
        Covode.recordClassIndex(608550);
        a = new r();
    }

    private r() {
    }

    @Override // com.dragon.read.kmp.reader.services.c
    public qj4.a X6(String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return new qj4.b(prefix);
    }
}
