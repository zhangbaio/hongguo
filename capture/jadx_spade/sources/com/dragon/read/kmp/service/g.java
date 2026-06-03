package com.dragon.read.kmp.service;

import androidx.compose.foundation.gestures.s2;
import androidx.compose.runtime.MutableState;
import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final int b = 0;
    private final String a;

    static {
        Covode.recordClassIndex(608826);
    }

    public final void a() {
        KmpDialogServiceKt.h(this.a);
    }

    public final void b(boolean z) {
        r0.b(this.a, z);
    }

    public g(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.a = key;
    }

    public final void c(s2 s2Var) {
        Map map;
        map = KmpDialogServiceKt.b;
        MutableState mutableState = (MutableState) map.get(this.a);
        if (mutableState != null) {
            mutableState.setValue(s2Var);
        }
    }
}
