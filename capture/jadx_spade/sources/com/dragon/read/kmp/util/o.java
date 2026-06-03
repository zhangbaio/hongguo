package com.dragon.read.kmp.util;

import androidx.compose.foundation.layout.f2;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final o a;

    static {
        Covode.recordClassIndex(609493);
        a = new o();
    }

    private o() {
    }

    public final Modifier a(Modifier expandClickArea, float f) {
        Intrinsics.checkNotNullParameter(expandClickArea, "$this$expandClickArea");
        return f2.r(expandClickArea, f);
    }
}
