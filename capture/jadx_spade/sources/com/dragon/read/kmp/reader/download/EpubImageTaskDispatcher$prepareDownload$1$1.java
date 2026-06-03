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

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.EpubImageTaskDispatcher$prepareDownload$1$1", f = "EpubImageTaskDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class EpubImageTaskDispatcher$prepareDownload$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ l $task;
    int label;
    final /* synthetic */ EpubImageTaskDispatcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EpubImageTaskDispatcher$prepareDownload$1$1(EpubImageTaskDispatcher epubImageTaskDispatcher, l lVar, Continuation<? super EpubImageTaskDispatcher$prepareDownload$1$1> continuation) {
        super(2, continuation);
        this.this$0 = epubImageTaskDispatcher;
        this.$task = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EpubImageTaskDispatcher$prepareDownload$1$1(this.this$0, this.$task, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((EpubImageTaskDispatcher$prepareDownload$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean e;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            e = this.this$0.e(this.$task);
            return Boxing.boxBoolean(e);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
