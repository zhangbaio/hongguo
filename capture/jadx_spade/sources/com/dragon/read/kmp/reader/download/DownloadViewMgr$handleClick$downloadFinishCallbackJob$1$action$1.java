package com.dragon.read.kmp.reader.download;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.DownloadViewMgr$handleClick$downloadFinishCallbackJob$1$action$1", f = "DownloadViewMgr.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class DownloadViewMgr$handleClick$downloadFinishCallbackJob$1$action$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $arg;
    final /* synthetic */ Function2<Boolean, Continuation<? super Unit>, Object> $downloadFinishCallback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DownloadViewMgr$handleClick$downloadFinishCallbackJob$1$action$1(Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> function2, boolean z, Continuation<? super DownloadViewMgr$handleClick$downloadFinishCallbackJob$1$action$1> continuation) {
        super(2, continuation);
        this.$downloadFinishCallback = function2;
        this.$arg = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewMgr$handleClick$downloadFinishCallbackJob$1$action$1(this.$downloadFinishCallback, this.$arg, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadViewMgr$handleClick$downloadFinishCallbackJob$1$action$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Function2<Boolean, Continuation<? super Unit>, Object> function2 = this.$downloadFinishCallback;
            Boolean boxBoolean = Boxing.boxBoolean(this.$arg);
            this.label = 1;
            if (function2.invoke(boxBoolean, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
