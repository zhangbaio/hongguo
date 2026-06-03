package com.dragon.read.kmp.reader.download;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmprpc.reader.saas.model.r2;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import dm4.u;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kh4.a;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class EpubImageDownloadHelper {
    public static final EpubImageDownloadHelper a;
    private static final di6.e<String, r2> b;
    private static final com.dragon.read.kmp.i c;
    public static final int d;

    private EpubImageDownloadHelper() {
    }

    public static final class a implements kh4.a {
        final /* synthetic */ CancellableContinuation<Boolean> a;
        final /* synthetic */ xm6.c b;
        final /* synthetic */ xm6.c c;
        final /* synthetic */ l d;

        private final void a() {
            if (this.a.isActive()) {
                Set<String> set = this.d.a;
                boolean z = false;
                if (set != null && this.b.b + this.c.b == set.size()) {
                    z = true;
                }
                if (z) {
                    CancellableContinuation<Boolean> cancellableContinuation = this.a;
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m773constructorimpl(Boolean.TRUE));
                }
            }
        }

        public void onCanceled(DownloadInfo downloadInfo) {
            a.a.a(this, downloadInfo);
        }

        public void onFirstStart(DownloadInfo downloadInfo) {
            a.a.b(this, downloadInfo);
        }

        public void onFirstSuccess(DownloadInfo downloadInfo) {
            a.a.c(this, downloadInfo);
        }

        public void onPause(DownloadInfo downloadInfo) {
            a.a.d(this, downloadInfo);
        }

        public void onPrepare(DownloadInfo downloadInfo) {
            a.a.e(this, downloadInfo);
        }

        public void onProgress(DownloadInfo downloadInfo) {
            a.a.f(this, downloadInfo);
        }

        public void onStart(DownloadInfo downloadInfo) {
            a.a.i(this, downloadInfo);
        }

        public void onSuccessed(DownloadInfo entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.c.c();
            a();
        }

        public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
            a.a.g(this, downloadInfo, baseException);
        }

        public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
            a.a.h(this, downloadInfo, baseException);
        }

        public void onFailed(DownloadInfo entity, BaseException e) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(e, "e");
            this.b.c();
            a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super Boolean> cancellableContinuation, xm6.c cVar, xm6.c cVar2, l lVar) {
            this.a = cancellableContinuation;
            this.b = cVar;
            this.c = cVar2;
            this.d = lVar;
        }
    }

    static {
        Covode.recordClassIndex(608415);
        a = new EpubImageDownloadHelper();
        b = new di6.e<>();
        c = new com.dragon.read.kmp.i("EpubImageDownloadHelper");
        d = 8;
    }

    public final String f(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        return com.dragon.read.kmp.local.a.a.d(u.b.b(), bookId);
    }

    public final boolean g(String bookId, String chapterId) {
        Map<String, ? extends List<String>> map;
        List<String> list;
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        r2 r2Var = (r2) b.get(bookId);
        if (r2Var != null && (map = r2Var.a) != null && (list = map.get(chapterId)) != null) {
            return !list.isEmpty();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r10, java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$autoDownloadEpubImages$1
            if (r0 == 0) goto L13
            r0 = r12
            com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$autoDownloadEpubImages$1 r0 = (com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$autoDownloadEpubImages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$autoDownloadEpubImages$1 r0 = new com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$autoDownloadEpubImages$1
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 3
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L43
            if (r1 == r3) goto L3f
            if (r1 == r2) goto L37
            if (r1 != r8) goto L2f
            kotlin.ResultKt.throwOnFailure(r12)
            goto L96
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L78
        L3f:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L5e
        L43:
            kotlin.ResultKt.throwOnFailure(r12)
            di6.e<java.lang.String, com.dragon.read.kmprpc.reader.saas.model.r2> r12 = com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.b
            java.lang.Object r12 = r12.get(r10)
            com.dragon.read.kmprpc.reader.saas.model.r2 r12 = (com.dragon.read.kmprpc.reader.saas.model.r2) r12
            if (r12 == 0) goto L61
            com.dragon.read.kmp.reader.download.EpubImageTaskDispatcher r11 = new com.dragon.read.kmp.reader.download.EpubImageTaskDispatcher
            r11.<init>()
            r0.label = r3
            java.lang.Object r10 = r11.c(r12, r10, r0)
            if (r10 != r7) goto L5e
            return r7
        L5e:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L61:
            com.dragon.read.kmprpc.reader.saas.model.a3 r12 = new com.dragon.read.kmprpc.reader.saas.model.a3
            r12.<init>(r10, r11)
            com.dragon.read.kmprpc.reader.saas.rpc.ReaderApiService r1 = com.dragon.read.kmprpc.reader.saas.rpc.ReaderApiService.a
            r3 = 0
            r5 = 2
            r6 = 0
            r0.L$0 = r10
            r0.label = r2
            r2 = r12
            r4 = r0
            java.lang.Object r12 = com.dragon.read.kmprpc.reader.saas.rpc.ReaderApiService.f(r1, r2, r3, r4, r5, r6)
            if (r12 != r7) goto L78
            return r7
        L78:
            com.dragon.read.kmprpc.reader.saas.model.b3 r12 = (com.dragon.read.kmprpc.reader.saas.model.b3) r12
            if (r12 == 0) goto L96
            com.dragon.read.kmprpc.reader.saas.model.r2 r11 = r12.c
            if (r11 == 0) goto L96
            di6.e<java.lang.String, com.dragon.read.kmprpc.reader.saas.model.r2> r12 = com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.b
            r12.put(r10, r11)
            com.dragon.read.kmp.reader.download.EpubImageTaskDispatcher r12 = new com.dragon.read.kmp.reader.download.EpubImageTaskDispatcher
            r12.<init>()
            r1 = 0
            r0.L$0 = r1
            r0.label = r8
            java.lang.Object r10 = r12.c(r11, r10, r0)
            if (r10 != r7) goto L96
            return r7
        L96:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.b(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$fetchEpubImageInfo$1
            if (r0 == 0) goto L13
            r0 = r10
            com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$fetchEpubImageInfo$1 r0 = (com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$fetchEpubImageInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$fetchEpubImageInfo$1 r0 = new com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$fetchEpubImageInfo$1
            r0.<init>(r7, r10)
        L18:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r8 = r4.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L70
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r10)
            com.dragon.read.kmp.i r10 = com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "start fetch image info "
            r1.append(r3)
            kotlinx.datetime.Clock$System r3 = kotlinx.datetime.Clock.System.INSTANCE
            kotlinx.datetime.Instant r3 = r3.now()
            long r5 = r3.toEpochMilliseconds()
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r10.d(r1)
            com.dragon.read.kmprpc.reader.saas.model.a3 r10 = new com.dragon.read.kmprpc.reader.saas.model.a3
            r10.<init>(r8, r9)
            com.dragon.read.kmprpc.reader.saas.rpc.ReaderApiService r1 = com.dragon.read.kmprpc.reader.saas.rpc.ReaderApiService.a
            r3 = 0
            r5 = 2
            r6 = 0
            r4.L$0 = r8
            r4.label = r2
            r2 = r10
            java.lang.Object r10 = com.dragon.read.kmprpc.reader.saas.rpc.ReaderApiService.f(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L70
            return r0
        L70:
            com.dragon.read.kmprpc.reader.saas.model.b3 r10 = (com.dragon.read.kmprpc.reader.saas.model.b3) r10
            if (r10 == 0) goto L7d
            com.dragon.read.kmprpc.reader.saas.model.r2 r9 = r10.c
            if (r9 == 0) goto L7d
            di6.e<java.lang.String, com.dragon.read.kmprpc.reader.saas.model.r2> r0 = com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.b
            r0.put(r8, r9)
        L7d:
            com.dragon.read.kmp.i r8 = com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "end fetch image info "
            r9.append(r0)
            kotlinx.datetime.Clock$System r0 = kotlinx.datetime.Clock.System.INSTANCE
            kotlinx.datetime.Instant r0 = r0.now()
            long r0 = r0.toEpochMilliseconds()
            r9.append(r0)
            r0 = 32
            r9.append(r0)
            if (r10 == 0) goto Lae
            com.dragon.read.kmprpc.reader.saas.model.r2 r10 = r10.c
            if (r10 == 0) goto Lae
            java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> r10 = r10.a
            if (r10 == 0) goto Lae
            int r10 = r10.size()
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            goto Laf
        Lae:
            r10 = 0
        Laf:
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.d(r9)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.e(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r10, java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$downloadEpubImages$1
            if (r0 == 0) goto L13
            r0 = r13
            com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$downloadEpubImages$1 r0 = (com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$downloadEpubImages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$downloadEpubImages$1 r0 = new com.dragon.read.kmp.reader.download.EpubImageDownloadHelper$downloadEpubImages$1
            r0.<init>(r9, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 3
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L48
            if (r1 == r3) goto L44
            if (r1 == r2) goto L37
            if (r1 != r8) goto L2f
            kotlin.ResultKt.throwOnFailure(r13)
            goto L95
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            java.lang.Object r10 = r0.L$1
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L78
        L44:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L5e
        L48:
            kotlin.ResultKt.throwOnFailure(r13)
            di6.e<java.lang.String, com.dragon.read.kmprpc.reader.saas.model.r2> r13 = com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.b
            java.lang.Object r13 = r13.get(r10)
            com.dragon.read.kmprpc.reader.saas.model.r2 r13 = (com.dragon.read.kmprpc.reader.saas.model.r2) r13
            if (r13 == 0) goto L5f
            r0.label = r3
            java.lang.Object r13 = r9.c(r13, r10, r12, r0)
            if (r13 != r7) goto L5e
            return r7
        L5e:
            return r13
        L5f:
            com.dragon.read.kmprpc.reader.saas.model.a3 r13 = new com.dragon.read.kmprpc.reader.saas.model.a3
            r13.<init>(r10, r11)
            com.dragon.read.kmprpc.reader.saas.rpc.ReaderApiService r1 = com.dragon.read.kmprpc.reader.saas.rpc.ReaderApiService.a
            r3 = 0
            r5 = 2
            r6 = 0
            r0.L$0 = r10
            r0.L$1 = r12
            r0.label = r2
            r2 = r13
            r4 = r0
            java.lang.Object r13 = com.dragon.read.kmprpc.reader.saas.rpc.ReaderApiService.f(r1, r2, r3, r4, r5, r6)
            if (r13 != r7) goto L78
            return r7
        L78:
            com.dragon.read.kmprpc.reader.saas.model.b3 r13 = (com.dragon.read.kmprpc.reader.saas.model.b3) r13
            if (r13 == 0) goto L9c
            com.dragon.read.kmprpc.reader.saas.model.r2 r11 = r13.c
            if (r11 == 0) goto L9c
            di6.e<java.lang.String, com.dragon.read.kmprpc.reader.saas.model.r2> r13 = com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.b
            r13.put(r10, r11)
            com.dragon.read.kmp.reader.download.EpubImageDownloadHelper r13 = com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.a
            r1 = 0
            r0.L$0 = r1
            r0.L$1 = r1
            r0.label = r8
            java.lang.Object r13 = r13.c(r11, r10, r12, r0)
            if (r13 != r7) goto L95
            return r7
        L95:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r10 = r13.booleanValue()
            goto L9d
        L9c:
            r10 = 0
        L9d:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.d(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x01e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object c(com.dragon.read.kmprpc.reader.saas.model.r2 r18, java.lang.String r19, java.lang.String r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.EpubImageDownloadHelper.c(com.dragon.read.kmprpc.reader.saas.model.r2, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
