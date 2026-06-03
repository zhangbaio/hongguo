package com.dragon.read.kmp.reader.font;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s0 {
    static {
        Covode.recordClassIndex(608435);
    }

    public static final boolean b(h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        if (hVar.l == 1) {
            return true;
        }
        return false;
    }

    public static final boolean a(h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        return Intrinsics.areEqual(hVar.b, Font.DEFAULT.getFontFamily());
    }
}
