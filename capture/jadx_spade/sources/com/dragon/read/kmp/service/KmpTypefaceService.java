package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpTypefaceService {
    public static final KmpTypefaceService a;

    static {
        Covode.recordClassIndex(608889);
        a = new KmpTypefaceService();
    }

    private KmpTypefaceService() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r5, kotlin.coroutines.Continuation<? super android.graphics.Typeface> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.dragon.read.kmp.service.KmpTypefaceService$getTypeface$1
            if (r0 == 0) goto L13
            r0 = r6
            com.dragon.read.kmp.service.KmpTypefaceService$getTypeface$1 r0 = (com.dragon.read.kmp.service.KmpTypefaceService$getTypeface$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.service.KmpTypefaceService$getTypeface$1 r0 = new com.dragon.read.kmp.service.KmpTypefaceService$getTypeface$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            eo0.c r6 = eo0.c.a
            java.lang.Class<com.dragon.read.kmp.service.z> r2 = com.dragon.read.kmp.service.z.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            eo0.a r6 = r6.a(r2)
            com.dragon.read.kmp.service.z r6 = (com.dragon.read.kmp.service.z) r6
            if (r6 == 0) goto L51
            r0.label = r3
            java.lang.Object r6 = r6.k1(r5, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            android.graphics.Typeface r6 = (android.graphics.Typeface) r6
            if (r6 != 0) goto L58
        L51:
            android.graphics.Typeface r6 = android.graphics.Typeface.DEFAULT
            java.lang.String r5 = "DEFAULT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
        L58:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.service.KmpTypefaceService.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
