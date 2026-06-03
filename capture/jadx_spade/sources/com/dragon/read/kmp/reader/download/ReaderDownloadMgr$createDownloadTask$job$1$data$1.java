package com.dragon.read.kmp.reader.download;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr$createDownloadTask$job$1$data$1", f = "ReaderDownloadMgr.kt", i = {}, l = {326}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$createDownloadTask$job$1$data$1 extends SuspendLambda implements Function1<Continuation<? super an4.c>, Object> {
    final /* synthetic */ String $bookId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$createDownloadTask$job$1$data$1(String str, Continuation<? super ReaderDownloadMgr$createDownloadTask$job$1$data$1> continuation) {
        super(1, continuation);
        this.$bookId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ReaderDownloadMgr$createDownloadTask$job$1$data$1(this.$bookId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super an4.c> continuation) {
        return ((ReaderDownloadMgr$createDownloadTask$job$1$data$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            b bVar = b.a;
            String str = this.$bookId;
            this.label = 1;
            obj = bVar.a(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
