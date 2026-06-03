package com.dragon.read.kmp.reader.download;

import com.dragon.read.kmp.reader.download.ReaderDownloadMgr;
import java.util.Map;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr$executeDownloadTask$job$1", f = "ReaderDownloadMgr.kt", i = {}, l = {674}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$executeDownloadTask$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bookId;
    final /* synthetic */ Deferred<ReaderDownloadMgr.a> $singleTask;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$executeDownloadTask$job$1(Deferred<ReaderDownloadMgr.a> deferred, String str, Continuation<? super ReaderDownloadMgr$executeDownloadTask$job$1> continuation) {
        super(2, continuation);
        this.$singleTask = deferred;
        this.$bookId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReaderDownloadMgr$executeDownloadTask$job$1(this.$singleTask, this.$bookId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReaderDownloadMgr$executeDownloadTask$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Map map;
        com.dragon.read.kmp.i iVar;
        String stackTraceToString;
        com.dragon.read.kmp.i iVar2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Deferred<ReaderDownloadMgr.a> deferred = this.$singleTask;
                this.label = 1;
                obj = deferred.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            ReaderDownloadMgr.a aVar = (ReaderDownloadMgr.a) obj;
            iVar2 = ReaderDownloadMgr.h;
            iVar2.d("下载器 - 批量下载结束, bookId = " + aVar.a + ", value = " + aVar);
        } catch (Throwable th) {
            map = ReaderDownloadMgr.e;
            map.remove(this.$bookId);
            iVar = ReaderDownloadMgr.h;
            StringBuilder sb = new StringBuilder();
            sb.append("下载器 - 启动批量下载出错, error = ");
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(th);
            sb.append(stackTraceToString);
            com.dragon.read.kmp.i.c(iVar, sb.toString(), (Throwable) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
