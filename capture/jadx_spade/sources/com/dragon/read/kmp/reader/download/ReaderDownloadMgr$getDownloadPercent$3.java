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

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr$getDownloadPercent$3", f = "ReaderDownloadMgr.kt", i = {}, l = {722}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$getDownloadPercent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Float>, Object> {
    final /* synthetic */ String $bookId;
    final /* synthetic */ String $targetUserId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$getDownloadPercent$3(String str, String str2, Continuation<? super ReaderDownloadMgr$getDownloadPercent$3> continuation) {
        super(2, continuation);
        this.$targetUserId = str;
        this.$bookId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReaderDownloadMgr$getDownloadPercent$3(this.$targetUserId, this.$bookId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Float> continuation) {
        return ((ReaderDownloadMgr$getDownloadPercent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.dragon.read.kmp.i iVar;
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
            ReaderDownloadMgr readerDownloadMgr = ReaderDownloadMgr.a;
            String str = this.$targetUserId;
            String str2 = this.$bookId;
            this.label = 1;
            obj = readerDownloadMgr.K(str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        float floatValue = ((Number) obj).floatValue();
        iVar = ReaderDownloadMgr.h;
        iVar.d("查询进度结果为：book_id = " + this.$bookId + ", percent = " + floatValue);
        return Boxing.boxFloat(floatValue);
    }
}
