package com.dragon.read.kmp.reader.utils;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    static {
        Covode.recordClassIndex(608652);
    }

    public static final boolean a(rn0.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (!cVar.exists()) {
            cVar.mkdirs();
            return true;
        }
        return false;
    }
}
