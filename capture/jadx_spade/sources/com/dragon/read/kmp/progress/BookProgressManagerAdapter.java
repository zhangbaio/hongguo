package com.dragon.read.kmp.progress;

import com.bytedance.covode.number.Covode;
import com.dragon.read.progress.g;
import kotlin.coroutines.Continuation;
import lr4.c1;
import lr4.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookProgressManagerAdapter {
    public static final BookProgressManagerAdapter a;

    static {
        Covode.recordClassIndex(608221);
        a = new BookProgressManagerAdapter();
    }

    private BookProgressManagerAdapter() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:19|20))(3:21|22|(1:24))|11|12|(2:14|15)(1:17)))|27|6|7|(0)(0)|11|12|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        r0 = kotlin.Result.Companion;
        r5 = kotlin.Result.m773constructorimpl(kotlin.ResultKt.createFailure(r5));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.dragon.read.kmp.progress.BookProgressManagerAdapter$uploadChapterProgress$1
            if (r0 == 0) goto L13
            r0 = r5
            com.dragon.read.kmp.progress.BookProgressManagerAdapter$uploadChapterProgress$1 r0 = (com.dragon.read.kmp.progress.BookProgressManagerAdapter$uploadChapterProgress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.progress.BookProgressManagerAdapter$uploadChapterProgress$1 r0 = new com.dragon.read.kmp.progress.BookProgressManagerAdapter$uploadChapterProgress$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L54
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L54
            com.dragon.read.progress.i r5 = com.dragon.read.progress.i.a     // Catch: java.lang.Throwable -> L54
            io.reactivex.Observable r5 = r5.k()     // Catch: java.lang.Throwable -> L54
            r0.label = r3     // Catch: java.lang.Throwable -> L54
            java.lang.Object r5 = com.dragon.read.kmp.progress.a.a(r5, r0)     // Catch: java.lang.Throwable -> L54
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L54
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L54
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch: java.lang.Throwable -> L54
            java.lang.Object r5 = kotlin.Result.m773constructorimpl(r5)     // Catch: java.lang.Throwable -> L54
            goto L5f
        L54:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m773constructorimpl(r5)
        L5f:
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            boolean r1 = kotlin.Result.m779isFailureimpl(r5)
            if (r1 == 0) goto L6b
            r5 = r0
        L6b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.progress.BookProgressManagerAdapter.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object b(String str, Continuation<? super c1> continuation) {
        return g.a.t(str);
    }

    public final Object a(String str, String str2, Continuation<? super h> continuation) {
        return com.dragon.read.progress.b.a.q(str, str2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:19|20))(3:21|22|(1:24))|11|12|(2:14|15)(1:17)))|27|6|7|(0)(0)|11|12|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        r6 = kotlin.Result.Companion;
        r5 = kotlin.Result.m773constructorimpl(kotlin.ResultKt.createFailure(r5));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(lr4.c1 r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.dragon.read.kmp.progress.BookProgressManagerAdapter$updateRecentBookProgress$1
            if (r0 == 0) goto L13
            r0 = r7
            com.dragon.read.kmp.progress.BookProgressManagerAdapter$updateRecentBookProgress$1 r0 = (com.dragon.read.kmp.progress.BookProgressManagerAdapter$updateRecentBookProgress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.progress.BookProgressManagerAdapter$updateRecentBookProgress$1 r0 = new com.dragon.read.kmp.progress.BookProgressManagerAdapter$updateRecentBookProgress$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L54
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L54
            com.dragon.read.progress.j r7 = com.dragon.read.progress.j.a     // Catch: java.lang.Throwable -> L54
            io.reactivex.Observable r5 = r7.B0(r5, r6)     // Catch: java.lang.Throwable -> L54
            r0.label = r3     // Catch: java.lang.Throwable -> L54
            java.lang.Object r7 = com.dragon.read.kmp.progress.a.a(r5, r0)     // Catch: java.lang.Throwable -> L54
            if (r7 != r1) goto L45
            return r1
        L45:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L54
            boolean r5 = r7.booleanValue()     // Catch: java.lang.Throwable -> L54
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch: java.lang.Throwable -> L54
            java.lang.Object r5 = kotlin.Result.m773constructorimpl(r5)     // Catch: java.lang.Throwable -> L54
            goto L5f
        L54:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m773constructorimpl(r5)
        L5f:
            r6 = 0
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            boolean r7 = kotlin.Result.m779isFailureimpl(r5)
            if (r7 == 0) goto L6b
            r5 = r6
        L6b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.progress.BookProgressManagerAdapter.c(lr4.c1, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
