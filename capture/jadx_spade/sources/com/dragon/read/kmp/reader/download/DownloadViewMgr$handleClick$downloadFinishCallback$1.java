package com.dragon.read.kmp.reader.download;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.DownloadViewMgr$handleClick$downloadFinishCallback$1", f = "DownloadViewMgr.kt", i = {0}, l = {66, 73, 80}, m = "invokeSuspend", n = {"userId"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class DownloadViewMgr$handleClick$downloadFinishCallback$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bookId;
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DownloadViewMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadViewMgr$handleClick$downloadFinishCallback$1(DownloadViewMgr downloadViewMgr, String str, Continuation<? super DownloadViewMgr$handleClick$downloadFinishCallback$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadViewMgr;
        this.$bookId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadViewMgr$handleClick$downloadFinishCallback$1 downloadViewMgr$handleClick$downloadFinishCallback$1 = new DownloadViewMgr$handleClick$downloadFinishCallback$1(this.this$0, this.$bookId, continuation);
        downloadViewMgr$handleClick$downloadFinishCallback$1.Z$0 = ((Boolean) obj).booleanValue();
        return downloadViewMgr$handleClick$downloadFinishCallback$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((DownloadViewMgr$handleClick$downloadFinishCallback$1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.reader.download.DownloadViewMgr$handleClick$downloadFinishCallback$1$1", f = "DownloadViewMgr.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.reader.download.DownloadViewMgr$handleClick$downloadFinishCallback$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isInBookshelf;
        int label;
        final /* synthetic */ DownloadViewMgr this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DownloadViewMgr downloadViewMgr, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = downloadViewMgr;
            this.$isInBookshelf = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$isInBookshelf, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            wf4.b bVar;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                bVar = this.this$0.b;
                bVar.a(this.$isInBookshelf);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009c A[Catch: all -> 0x0024, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0024, blocks: (B:13:0x001f, B:23:0x009c), top: B:2:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L2f
            if (r1 == r4) goto L27
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            kotlin.ResultKt.throwOnFailure(r8)
            goto Ldc
        L17:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1f:
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L24
            goto Lc6
        L24:
            r8 = move-exception
            goto Lab
        L27:
            java.lang.Object r1 = r7.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L54
        L2f:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r7.Z$0
            com.dragon.read.kmp.reader.download.DownloadViewMgr r1 = r7.this$0
            com.dragon.read.kmp.reader.download.DownloadUiState r1 = com.dragon.read.kmp.reader.download.DownloadViewMgr.d(r1)
            r1.k(r4)
            if (r8 == 0) goto Ldc
            dm4.u r8 = dm4.u.b
            java.lang.String r1 = r8.b()
            dm4.n r8 = dm4.n.b
            java.lang.String r6 = r7.$bookId
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = r8.b(r1, r6, r7)
            if (r8 != r0) goto L54
            return r0
        L54:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L9c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "bookId = "
            r8.append(r0)
            java.lang.String r0 = r7.$bookId
            r8.append(r0)
            java.lang.String r0 = ", 已在书架/收藏"
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            com.dragon.read.kmp.network.ReaderErrorException r0 = new com.dragon.read.kmp.network.ReaderErrorException
            r1 = 100000000(0x5f5e100, float:2.3122341E-35)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r0.<init>(r1, r8)
            com.dragon.read.kmp.reader.download.DownloadViewMgr r8 = r7.this$0
            com.dragon.read.kmp.i r8 = com.dragon.read.kmp.reader.download.DownloadViewMgr.b(r8)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "自动添加书架/收藏失败，error = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.dragon.read.kmp.i.c(r8, r0, r5, r3, r5)
            goto Ldc
        L9c:
            dm4.n r8 = dm4.n.b     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = r7.$bookId     // Catch: java.lang.Throwable -> L24
            r7.L$0 = r5     // Catch: java.lang.Throwable -> L24
            r7.label = r3     // Catch: java.lang.Throwable -> L24
            java.lang.Object r8 = r8.a(r1, r6, r7)     // Catch: java.lang.Throwable -> L24
            if (r8 != r0) goto Lc6
            return r0
        Lab:
            com.dragon.read.kmp.reader.download.DownloadViewMgr r1 = r7.this$0
            com.dragon.read.kmp.i r1 = com.dragon.read.kmp.reader.download.DownloadViewMgr.b(r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "KmpReaderBookshelfDependImpl.addBookshelf，error = "
            r4.append(r6)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            com.dragon.read.kmp.i.c(r1, r8, r5, r3, r5)
            r4 = 0
        Lc6:
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
            com.dragon.read.kmp.reader.download.DownloadViewMgr$handleClick$downloadFinishCallback$1$1 r1 = new com.dragon.read.kmp.reader.download.DownloadViewMgr$handleClick$downloadFinishCallback$1$1
            com.dragon.read.kmp.reader.download.DownloadViewMgr r3 = r7.this$0
            r1.<init>(r3, r4, r5)
            r7.L$0 = r5
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r7)
            if (r8 != r0) goto Ldc
            return r0
        Ldc:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.DownloadViewMgr$handleClick$downloadFinishCallback$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
