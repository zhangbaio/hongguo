package com.dragon.read.kmp.reader.download;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.DownloadViewMgr$updateDownloadTextView$1", f = "DownloadViewMgr.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_FXAA}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class DownloadViewMgr$updateDownloadTextView$1 extends SuspendLambda implements Function2<cm4.i, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DownloadViewMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadViewMgr$updateDownloadTextView$1(DownloadViewMgr downloadViewMgr, Continuation<? super DownloadViewMgr$updateDownloadTextView$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadViewMgr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DownloadViewMgr$updateDownloadTextView$1 downloadViewMgr$updateDownloadTextView$1 = new DownloadViewMgr$updateDownloadTextView$1(this.this$0, continuation);
        downloadViewMgr$updateDownloadTextView$1.L$0 = obj;
        return downloadViewMgr$updateDownloadTextView$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(cm4.i iVar, Continuation<? super Unit> continuation) {
        return ((DownloadViewMgr$updateDownloadTextView$1) create(iVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.dragon.read.kmp.i iVar;
        Object f;
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
            cm4.i iVar2 = (cm4.i) this.L$0;
            iVar = this.this$0.d;
            iVar.d("点击了下载");
            DownloadViewMgr downloadViewMgr = this.this$0;
            this.label = 1;
            f = downloadViewMgr.f(iVar2, this);
            if (f == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
