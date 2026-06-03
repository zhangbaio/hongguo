package com.dragon.read.kmp.util.kotlin;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;
    private static final Lazy b;
    public static final int c;

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] d() {
        return new float[3];
    }

    public final float[] c() {
        return (float[]) b.getValue();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(609505);
        a = new d();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.util.kotlin.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float[] d;
                d = d.d();
                return d;
            }
        });
        b = lazy;
        c = 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0010 A[Catch: all -> 0x000b, TryCatch #0 {all -> 0x000b, blocks: (B:11:0x0002, B:4:0x0010, B:7:0x0015), top: B:10:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[Catch: all -> 0x000b, TRY_LEAVE, TryCatch #0 {all -> 0x000b, blocks: (B:11:0x0002, B:4:0x0010, B:7:0x0015), top: B:10:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float[] b(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 == 0) goto Ld
            int r0 = r2.length()     // Catch: java.lang.Throwable -> Lb
            if (r0 != 0) goto L9
            goto Ld
        L9:
            r0 = 0
            goto Le
        Lb:
            r2 = move-exception
            goto L1d
        Ld:
            r0 = 1
        Le:
            if (r0 == 0) goto L15
            float[] r2 = r1.c()     // Catch: java.lang.Throwable -> Lb
            goto L24
        L15:
            r0 = 3
            float[] r0 = new float[r0]     // Catch: java.lang.Throwable -> Lb
            com.dragon.read.kmp.util.kotlin.e.k(r2, r0)     // Catch: java.lang.Throwable -> Lb
            r2 = r0
            goto L24
        L1d:
            r2.printStackTrace()
            float[] r2 = r1.c()
        L24:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.util.kotlin.d.b(java.lang.String):float[]");
    }
}
