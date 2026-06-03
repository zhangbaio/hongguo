package com.dragon.read.kmp.saas.reader.depend;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpDownloadDependImpl implements dm4.a {
    public static final KmpDownloadDependImpl a;

    static {
        Covode.recordClassIndex(608723);
        a = new KmpDownloadDependImpl();
    }

    private KmpDownloadDependImpl() {
    }

    @Override // dm4.a
    public void d(com.dragon.read.kmp.reader.download.a downloadTask) {
        Intrinsics.checkNotNullParameter(downloadTask, "downloadTask");
        bg4.d.x0.a().bookService().e(new vt4.a(downloadTask.a).a(downloadTask.b).c(downloadTask.d).b(downloadTask.e).d(downloadTask.c));
    }

    @Override // dm4.a
    public String a(String bookId, float f) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        return bg4.d.x0.a().bookService().a(bookId, f);
    }

    @Override // dm4.a
    public void c(String bookId, boolean z) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        bg4.d.x0.a().bookService().e(new vt4.a(bookId).a(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dm4.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Float> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.dragon.read.kmp.saas.reader.depend.KmpDownloadDependImpl$getDownloadPercent$1
            if (r0 == 0) goto L13
            r0 = r6
            com.dragon.read.kmp.saas.reader.depend.KmpDownloadDependImpl$getDownloadPercent$1 r0 = (com.dragon.read.kmp.saas.reader.depend.KmpDownloadDependImpl$getDownloadPercent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.saas.reader.depend.KmpDownloadDependImpl$getDownloadPercent$1 r0 = new com.dragon.read.kmp.saas.reader.depend.KmpDownloadDependImpl$getDownloadPercent$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            bg4.d$a r6 = bg4.d.x0
            bg4.d r6 = r6.a()
            bg4.a r6 = r6.bookService()
            r0.label = r3
            java.lang.Object r6 = r6.f(r5, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            java.lang.Number r6 = (java.lang.Number) r6
            float r5 = r6.floatValue()
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.saas.reader.depend.KmpDownloadDependImpl.f(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
