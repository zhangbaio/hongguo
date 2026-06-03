package com.dragon.read.kmp.reader.download;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.DownloadViewMgr$initDownloadViewText$1", f = "DownloadViewMgr.kt", i = {0, 1, 1, 1, 2}, l = {121, 126, 133, 138}, m = "invokeSuspend", n = {"bookId", "bookId", "hasFullDownloaded", "percent", "bookId"}, s = {"L$0", "L$0", "L$1", "I$0", "L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class DownloadViewMgr$initDownloadViewText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ cm4.i $reader;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadViewMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadViewMgr$initDownloadViewText$1(DownloadViewMgr downloadViewMgr, cm4.i iVar, Continuation<? super DownloadViewMgr$initDownloadViewText$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadViewMgr;
        this.$reader = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewMgr$initDownloadViewText$1(this.this$0, this.$reader, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadViewMgr$initDownloadViewText$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.reader.download.DownloadViewMgr$initDownloadViewText$1$1", f = "DownloadViewMgr.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.reader.download.DownloadViewMgr$initDownloadViewText$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bookId;
        final /* synthetic */ Ref$BooleanRef $hasFullDownloaded;
        final /* synthetic */ int $percent;
        final /* synthetic */ cm4.i $reader;
        int label;
        final /* synthetic */ DownloadViewMgr this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DownloadViewMgr downloadViewMgr, cm4.i iVar, int i, String str, Ref$BooleanRef ref$BooleanRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = downloadViewMgr;
            this.$reader = iVar;
            this.$percent = i;
            this.$bookId = str;
            this.$hasFullDownloaded = ref$BooleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$reader, this.$percent, this.$bookId, this.$hasFullDownloaded, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                DownloadViewMgr downloadViewMgr = this.this$0;
                cm4.i iVar = this.$reader;
                int i2 = this.$percent;
                String str = this.$bookId;
                boolean z = this.$hasFullDownloaded.element;
                this.label = 1;
                if (downloadViewMgr.t(iVar, i2, str, z, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.dragon.read.kmp.reader.download.DownloadViewMgr$initDownloadViewText$1$2", f = "DownloadViewMgr.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.reader.download.DownloadViewMgr$initDownloadViewText$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bookId;
        final /* synthetic */ cm4.i $reader;
        int label;
        final /* synthetic */ DownloadViewMgr this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DownloadViewMgr downloadViewMgr, cm4.i iVar, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = downloadViewMgr;
            this.$reader = iVar;
            this.$bookId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$reader, this.$bookId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                DownloadViewMgr downloadViewMgr = this.this$0;
                cm4.i iVar = this.$reader;
                String str = this.$bookId;
                this.label = 1;
                if (downloadViewMgr.t(iVar, -1, str, false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ee, code lost:
    
        if (r9 == false) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e2 A[Catch: Exception -> 0x0052, TryCatch #1 {Exception -> 0x0052, blocks: (B:15:0x0028, B:20:0x00d4, B:22:0x00e2, B:25:0x00f2, B:28:0x00f0, B:35:0x004c, B:37:0x0084, B:39:0x00b1, B:50:0x0075), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0112 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.DownloadViewMgr$initDownloadViewText$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
