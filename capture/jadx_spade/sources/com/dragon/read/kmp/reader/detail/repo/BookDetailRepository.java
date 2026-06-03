package com.dragon.read.kmp.reader.detail.repo;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import com.dragon.read.kmp.reader.detail.catalog.r;
import com.dragon.read.kmp.service.KmpBookshelfService;
import dm4.o;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookDetailRepository {
    public static final int b;
    private com.dragon.read.kmp.reader.detail.catalog.b a;

    static {
        Covode.recordClassIndex(608394);
        b = 8;
    }

    public final List<com.dragon.read.kmp.reader.detail.catalog.a> u(boolean z) {
        com.dragon.read.kmp.reader.detail.catalog.b bVar = this.a;
        Intrinsics.checkNotNull(bVar);
        return r.a(bVar.a, z);
    }

    public final Object p(String str, Continuation<? super Boolean> continuation) {
        return KmpBookshelfService.a.c(str, BookType.READ, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:19|20))(2:21|(1:23)(2:24|(1:26)))|11|12|(1:17)(2:14|15)))|29|6|7|(0)(0)|11|12|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x002a, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        r7 = kotlin.Result.Companion;
        r6 = kotlin.Result.m773constructorimpl(kotlin.ResultKt.createFailure(r6));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(java.lang.String r6, kotlin.coroutines.Continuation<? super com.bytedance.kmp.ugc.model.xy> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestForum$1
            if (r0 == 0) goto L13
            r0 = r7
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestForum$1 r0 = (com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestForum$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestForum$1 r0 = new com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestForum$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L2a
            goto L5b
        L2a:
            r6 = move-exception
            goto L62
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            xe4.a$a r7 = xe4.a.i3
            xe4.a r2 = r7.a()
            com.dragon.read.kmp.community.bookcomment.z r2 = r2.h8()
            boolean r2 = r2.a()
            if (r2 != 0) goto L48
            return r3
        L48:
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L2a
            xe4.a r7 = r7.a()     // Catch: java.lang.Throwable -> L2a
            com.dragon.read.kmp.community.bookcomment.z r7 = r7.h8()     // Catch: java.lang.Throwable -> L2a
            r0.label = r4     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r7 = r7.h(r6, r0)     // Catch: java.lang.Throwable -> L2a
            if (r7 != r1) goto L5b
            return r1
        L5b:
            com.bytedance.kmp.ugc.model.xy r7 = (com.bytedance.kmp.ugc.model.xy) r7     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r6 = kotlin.Result.m773constructorimpl(r7)     // Catch: java.lang.Throwable -> L2a
            goto L6c
        L62:
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m773constructorimpl(r6)
        L6c:
            boolean r7 = kotlin.Result.m779isFailureimpl(r6)
            if (r7 == 0) goto L73
            goto L74
        L73:
            r3 = r6
        L74:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository.r(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:18|19))(3:20|21|(1:23))|11|12|(1:14)(1:16)))|26|6|7|(0)(0)|11|12|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        r6 = kotlin.Result.Companion;
        r5 = kotlin.Result.m773constructorimpl(kotlin.ResultKt.createFailure(r5));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.String r5, kotlin.coroutines.Continuation<? super com.dragon.read.kmp.community.bookcomment.t> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestHotComments$1
            if (r0 == 0) goto L13
            r0 = r6
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestHotComments$1 r0 = (com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestHotComments$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestHotComments$1 r0 = new com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestHotComments$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L52
            goto L4b
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L52
            xe4.a$a r6 = xe4.a.i3     // Catch: java.lang.Throwable -> L52
            xe4.a r6 = r6.a()     // Catch: java.lang.Throwable -> L52
            com.dragon.read.kmp.community.bookcomment.z r6 = r6.h8()     // Catch: java.lang.Throwable -> L52
            r0.label = r3     // Catch: java.lang.Throwable -> L52
            r2 = 10
            java.lang.Object r6 = r6.c(r5, r2, r0)     // Catch: java.lang.Throwable -> L52
            if (r6 != r1) goto L4b
            return r1
        L4b:
            com.dragon.read.kmp.community.bookcomment.t r6 = (com.dragon.read.kmp.community.bookcomment.t) r6     // Catch: java.lang.Throwable -> L52
            java.lang.Object r5 = kotlin.Result.m773constructorimpl(r6)     // Catch: java.lang.Throwable -> L52
            goto L5d
        L52:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m773constructorimpl(r5)
        L5d:
            boolean r6 = kotlin.Result.m779isFailureimpl(r5)
            if (r6 == 0) goto L64
            r5 = 0
        L64:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository.s(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:27|28))(3:29|30|(1:32))|11|12|(2:14|15)(2:17|(4:19|(1:21)|22|23)(2:24|25))))|35|6|7|(0)(0)|11|12|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004e, code lost:
    
        r10 = kotlin.Result.Companion;
        r9 = kotlin.Result.m773constructorimpl(kotlin.ResultKt.createFailure(r9));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(java.lang.String r9, kotlin.coroutines.Continuation<? super com.dragon.read.kmp.reader.detail.repo.a> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestListenState$1
            if (r0 == 0) goto L13
            r0 = r10
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestListenState$1 r0 = (com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestListenState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestListenState$1 r0 = new com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestListenState$1
            r0.<init>(r8, r10)
        L18:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L32
            if (r1 != r7) goto L2a
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L4d
            goto L46
        L2a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L32:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L4d
            com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform r1 = com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform.a     // Catch: java.lang.Throwable -> L4d
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r7     // Catch: java.lang.Throwable -> L4d
            r2 = r9
            java.lang.Object r10 = com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform.b(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4d
            if (r10 != r0) goto L46
            return r0
        L46:
            com.dragon.read.component.audio.biz.protocol.core.data.RelativeToneModel r10 = (com.dragon.read.component.audio.biz.protocol.core.data.RelativeToneModel) r10     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r9 = kotlin.Result.m773constructorimpl(r10)     // Catch: java.lang.Throwable -> L4d
            goto L58
        L4d:
            r9 = move-exception
            kotlin.Result$Companion r10 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m773constructorimpl(r9)
        L58:
            java.lang.Throwable r10 = kotlin.Result.m776exceptionOrNullimpl(r9)
            r0 = 0
            if (r10 != 0) goto L67
            com.dragon.read.component.audio.biz.protocol.core.data.RelativeToneModel r9 = (com.dragon.read.component.audio.biz.protocol.core.data.RelativeToneModel) r9
            com.dragon.read.kmp.reader.detail.repo.a r9 = new com.dragon.read.kmp.reader.detail.repo.a
            r9.<init>(r7, r7, r0)
            goto L7f
        L67:
            boolean r9 = r10 instanceof com.dragon.read.kmp.reader.detail.platform.BookDetailNoAudioSourceException
            if (r9 == 0) goto L7a
            com.dragon.read.kmp.reader.detail.repo.a r9 = new com.dragon.read.kmp.reader.detail.repo.a
            java.lang.String r10 = r10.getMessage()
            if (r10 != 0) goto L75
            java.lang.String r10 = ""
        L75:
            r0 = 0
            r9.<init>(r7, r0, r10)
            goto L7f
        L7a:
            com.dragon.read.kmp.reader.detail.repo.a r9 = new com.dragon.read.kmp.reader.detail.repo.a
            r9.<init>(r7, r7, r0)
        L7f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository.t(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(com.dragon.read.kmp.reader.detail.d r5, kotlin.coroutines.Continuation<? super kotlin.Result<com.dragon.read.kmp.reader.detail.repo.b>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$load$1
            if (r0 == 0) goto L13
            r0 = r6
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$load$1 r0 = (com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$load$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$load$1 r0 = new com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$load$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$load$2 r6 = new com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$load$2
            r2 = 0
            r6.<init>(r5, r4, r2)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.m782unboximpl()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository.k(com.dragon.read.kmp.reader.detail.d, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<com.dragon.read.kmp.reader.detail.catalog.b>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$1
            if (r0 == 0) goto L13
            r0 = r6
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$1 r0 = (com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$1 r0 = new com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$2 r6 = new com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$loadCatalog$2
            r2 = 0
            r6.<init>(r4, r5, r2)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r6, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.m782unboximpl()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository.l(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0082 A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:10:0x002f, B:11:0x007e, B:13:0x0082, B:15:0x0086, B:18:0x008b, B:19:0x0092, B:23:0x003e, B:25:0x0055, B:26:0x0060), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0086 A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:10:0x002f, B:11:0x007e, B:13:0x0082, B:15:0x0086, B:18:0x008b, B:19:0x0092, B:23:0x003e, B:25:0x0055, B:26:0x0060), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:10:0x002f, B:11:0x007e, B:13:0x0082, B:15:0x0086, B:18:0x008b, B:19:0x0092, B:23:0x003e, B:25:0x0055, B:26:0x0060), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(com.dragon.read.kmp.reader.detail.d r22, kotlin.coroutines.Continuation<? super kotlin.Result<com.bytedance.kmp.reading.model.t3>> r23) {
        /*
            r21 = this;
            r0 = r22
            r1 = r23
            boolean r2 = r1 instanceof com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestBookDetail$1
            if (r2 == 0) goto L19
            r2 = r1
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestBookDetail$1 r2 = (com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestBookDetail$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L19
            int r3 = r3 - r4
            r2.label = r3
            r3 = r21
            goto L20
        L19:
            com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestBookDetail$1 r2 = new com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$requestBookDetail$1
            r3 = r21
            r2.<init>(r3, r1)
        L20:
            r7 = r2
            java.lang.Object r1 = r7.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r7.label
            r10 = 0
            r5 = 1
            if (r4 == 0) goto L3b
            if (r4 != r5) goto L33
            kotlin.ResultKt.throwOnFailure(r1)     // Catch: java.lang.Throwable -> L93
            goto L7e
        L33:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3b:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L93
            com.bytedance.kmp.reading.model.v3 r1 = new com.bytedance.kmp.reading.model.v3     // Catch: java.lang.Throwable -> L93
            com.dragon.read.kmp.utils.i0 r4 = com.dragon.read.kmp.utils.i0.a     // Catch: java.lang.Throwable -> L93
            java.lang.String r6 = r0.a     // Catch: java.lang.Throwable -> L93
            r8 = 0
            long r8 = r4.f(r6, r8)     // Catch: java.lang.Throwable -> L93
            java.lang.Long r12 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)     // Catch: java.lang.Throwable -> L93
            r13 = 0
            com.bytedance.kmp.reading.model.DetailSource r0 = r0.b     // Catch: java.lang.Throwable -> L93
            if (r0 == 0) goto L5f
            int r0 = r0.getValue()     // Catch: java.lang.Throwable -> L93
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)     // Catch: java.lang.Throwable -> L93
            r14 = r0
            goto L60
        L5f:
            r14 = r10
        L60:
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 122(0x7a, float:1.71E-43)
            r20 = 0
            r11 = r1
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch: java.lang.Throwable -> L93
            com.bytedance.kmp.reading.rpc.BookApiService r4 = com.bytedance.kmp.reading.rpc.BookApiService.a     // Catch: java.lang.Throwable -> L93
            r6 = 0
            r8 = 2
            r9 = 0
            r7.label = r5     // Catch: java.lang.Throwable -> L93
            r5 = r1
            java.lang.Object r1 = com.bytedance.kmp.reading.rpc.BookApiService.d(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L93
            if (r1 != r2) goto L7e
            return r2
        L7e:
            com.bytedance.kmp.reading.model.w3 r1 = (com.bytedance.kmp.reading.model.w3) r1     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L84
            com.bytedance.kmp.reading.model.t3 r10 = r1.c     // Catch: java.lang.Throwable -> L93
        L84:
            if (r10 == 0) goto L8b
            java.lang.Object r0 = kotlin.Result.m773constructorimpl(r10)     // Catch: java.lang.Throwable -> L93
            goto L9e
        L8b:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = "request book detail info is null"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L93
            throw r0     // Catch: java.lang.Throwable -> L93
        L93:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m773constructorimpl(r0)
        L9e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository.o(com.dragon.read.kmp.reader.detail.d, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.lang.String r18, kotlin.coroutines.Continuation<? super java.util.List<com.dragon.read.kmp.reader.detail.widget.a>> r19) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository.m(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(2:3|(9:5|6|7|(1:(1:10)(2:54|55))(2:56|(2:58|(1:60)(2:61|(1:63)))(1:64))|11|12|(1:14)|15|(1:17)(3:19|(6:21|(5:24|(1:37)(1:30)|(3:32|33|34)(1:36)|35|22)|38|39|(4:42|(2:44|45)(1:47)|46|40)|48)|(2:50|51)(1:52))))|67|6|7|(0)(0)|11|12|(0)|15|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0033, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x008b, code lost:
    
        r1 = kotlin.Result.Companion;
        r0 = kotlin.Result.m773constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.lang.String r22, kotlin.coroutines.Continuation<? super java.util.List<com.dragon.read.kmp.reader.detail.widget.a>> r23) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository.n(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(2:3|(9:5|6|7|(1:(1:10)(2:129|130))(2:131|(1:133)(5:134|(1:136)(1:141)|137|138|(1:140)))|11|12|(1:14)|15|(16:22|(2:23|(3:25|(2:29|30)(2:124|125)|(1:32)(1:123))(2:126|127))|33|(2:34|(3:36|(2:40|41)(2:119|120)|(1:43)(1:118))(2:121|122))|44|(4:48|(1:50)(1:116)|(1:52)|(12:54|(7:57|(1:71)(1:61)|(1:63)|64|(2:66|67)(2:69|70)|68|55)|72|(1:74)|(4:78|(1:80)|(1:82)|(8:84|(4:87|(2:89|90)(2:92|93)|91|85)|94|(1:96)|(1:114)(3:100|(3:102|(3:104|(1:106)|107)|108)|109)|(1:111)|112|113))|115|(0)|(1:98)|114|(0)|112|113))|117|(0)|(5:76|78|(0)|(0)|(0))|115|(0)|(0)|114|(0)|112|113)(1:21)))|144|6|7|(0)(0)|11|12|(0)|15|(1:17)(17:19|22|(3:23|(0)(0)|123)|33|(3:34|(0)(0)|118)|44|(5:46|48|(0)(0)|(0)|(0))|117|(0)|(0)|115|(0)|(0)|114|(0)|112|113)) */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0034, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00e3, code lost:
    
        r1 = kotlin.Result.Companion;
        r0 = kotlin.Result.m773constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0152 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /* JADX WARN: Type inference failed for: r12v13, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r68, kotlin.coroutines.Continuation<? super com.dragon.read.kmp.reader.detail.repo.BookDetailRepository.a> r69) {
        /*
            Method dump skipped, instructions count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository.q(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(String str, an4.a aVar, an4.b bVar) {
        boolean z;
        boolean z2;
        boolean z3;
        Integer num;
        String str2;
        Boolean bool;
        Boolean bool2 = bVar.e;
        if (bool2 != null) {
            z = bool2.booleanValue();
        } else {
            z = false;
        }
        Boolean bool3 = bVar.f;
        if (bool3 != null) {
            z2 = bool3.booleanValue();
        } else {
            z2 = false;
        }
        if (aVar != null && (bool = aVar.d) != null) {
            z3 = bool.booleanValue();
        } else {
            z3 = false;
        }
        if (aVar != null) {
            num = aVar.f;
        } else {
            num = null;
        }
        if (aVar != null) {
            str2 = aVar.e;
        } else {
            str2 = null;
        }
        return o.b.a(str, z3, num, str2, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        public final List<com.dragon.read.kmp.reader.detail.widget.a> a;
        public final List<com.dragon.read.kmp.reader.detail.widget.a> b;
        public final String c;
        public final String d;

        static {
            Covode.recordClassIndex(608395);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d);
        }

        public int hashCode() {
            int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            String str = this.c;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.d;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "CommonPlanResult(sameAuthorItems=" + this.a + ", samePressItems=" + this.b + ", sameAuthorMoreUrl=" + this.c + ", samePressMoreUrl=" + this.d + ')';
        }

        public a(List<com.dragon.read.kmp.reader.detail.widget.a> sameAuthorItems, List<com.dragon.read.kmp.reader.detail.widget.a> samePressItems, String str, String str2) {
            Intrinsics.checkNotNullParameter(sameAuthorItems, "sameAuthorItems");
            Intrinsics.checkNotNullParameter(samePressItems, "samePressItems");
            this.a = sameAuthorItems;
            this.b = samePressItems;
            this.c = str;
            this.d = str2;
        }
    }
}
