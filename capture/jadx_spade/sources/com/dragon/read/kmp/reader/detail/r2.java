package com.dragon.read.kmp.reader.detail;

import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r2 {
    private static final ProvidableCompositionLocal<p2> a;

    public static final ProvidableCompositionLocal<p2> c() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final p2 b() {
        return new p2();
    }

    static {
        Covode.recordClassIndex(608372);
        a = androidx.compose.runtime.d0.h((SnapshotMutationPolicy) null, new Function0() { // from class: com.dragon.read.kmp.reader.detail.q2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                p2 b;
                b = r2.b();
                return b;
            }
        }, 1, (Object) null);
    }
}
