package com.dragon.read.kmp.reader.download;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr", f = "ReaderDownloadMgr.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {920, 924, 927}, m = "retry", n = {"block", "currentDelay", "times", "maxDelay", "factor", "block", "currentDelay", "times", "maxDelay", "factor"}, s = {"L$0", "L$1", "I$0", "J$0", "D$0", "L$0", "L$1", "I$0", "J$0", "D$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$retry$1<T> extends ContinuationImpl {
    double D$0;
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReaderDownloadMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$retry$1(ReaderDownloadMgr readerDownloadMgr, Continuation<? super ReaderDownloadMgr$retry$1> continuation) {
        super(continuation);
        this.this$0 = readerDownloadMgr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f0;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        f0 = this.this$0.f0(0, 0L, 0L, 0.0d, null, this);
        return f0;
    }
}
