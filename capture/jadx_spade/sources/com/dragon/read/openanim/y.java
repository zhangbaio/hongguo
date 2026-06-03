package com.dragon.read.openanim;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y {
    public static final y a;
    private static final Lazy b;
    public static final int c;

    private y() {
    }

    private final w b() {
        return (w) b.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(612645);
        a = new y();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.openanim.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                w e;
                e = y.e();
                return e;
            }
        });
        b = lazy;
        c = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w e() {
        Object m773constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl((w) eo0.c.a.a(Reflection.getOrCreateKotlinClass(w.class)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m779isFailureimpl(m773constructorimpl)) {
            m773constructorimpl = null;
        }
        return (w) m773constructorimpl;
    }

    public final void c(float f, float f2, float f3, float f4, float f5, String sceneKey, String str, String str2, byte[] bArr) {
        Intrinsics.checkNotNullParameter(sceneKey, "sceneKey");
        w b2 = b();
        if (b2 != null) {
            b2.W7(f, f2, f3, f4, f5, sceneKey, str, str2, bArr);
        }
    }

    public static /* synthetic */ void d(y yVar, float f, float f2, float f3, float f4, float f5, String str, String str2, String str3, byte[] bArr, int i, Object obj) {
        float f6;
        String str4;
        String str5;
        String str6;
        byte[] bArr2;
        if ((i & 16) != 0) {
            f6 = 0.0f;
        } else {
            f6 = f5;
        }
        if ((i & 32) != 0) {
            str4 = "history_filter";
        } else {
            str4 = str;
        }
        if ((i & 64) != 0) {
            str5 = null;
        } else {
            str5 = str2;
        }
        if ((i & 128) != 0) {
            str6 = null;
        } else {
            str6 = str3;
        }
        if ((i & 256) != 0) {
            bArr2 = null;
        } else {
            bArr2 = bArr;
        }
        yVar.c(f, f2, f3, f4, f6, str4, str5, str6, bArr2);
    }
}
