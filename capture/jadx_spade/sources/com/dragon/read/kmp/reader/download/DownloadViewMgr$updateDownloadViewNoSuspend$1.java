package com.dragon.read.kmp.reader.download;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.DownloadViewMgr$updateDownloadViewNoSuspend$1", f = "DownloadViewMgr.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class DownloadViewMgr$updateDownloadViewNoSuspend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bookId;
    final /* synthetic */ boolean $hasDownload;
    final /* synthetic */ int $percent;
    final /* synthetic */ cm4.i $reader;
    int label;
    final /* synthetic */ DownloadViewMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadViewMgr$updateDownloadViewNoSuspend$1(DownloadViewMgr downloadViewMgr, cm4.i iVar, int i, String str, boolean z, Continuation<? super DownloadViewMgr$updateDownloadViewNoSuspend$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadViewMgr;
        this.$reader = iVar;
        this.$percent = i;
        this.$bookId = str;
        this.$hasDownload = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewMgr$updateDownloadViewNoSuspend$1(this.this$0, this.$reader, this.$percent, this.$bookId, this.$hasDownload, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadViewMgr$updateDownloadViewNoSuspend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            boolean z = this.$hasDownload;
            this.label = 1;
            if (downloadViewMgr.t(iVar, i2, str, z, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
