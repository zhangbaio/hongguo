package com.dragon.read.kmp.reader.download;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr", f = "ReaderDownloadMgr.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {856, 857, 859, 860}, m = "saveChapterDownloadPercentOrThrowError", n = {"targetUserId", "bookId", "percent", "size", "targetUserId", "bookId", "percent", "size", "targetUserId", "bookId", "percent"}, s = {"L$0", "L$1", "F$0", "I$0", "L$0", "L$1", "F$0", "I$0", "L$0", "L$1", "F$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$saveChapterDownloadPercentOrThrowError$1 extends ContinuationImpl {
    float F$0;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReaderDownloadMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$saveChapterDownloadPercentOrThrowError$1(ReaderDownloadMgr readerDownloadMgr, Continuation<? super ReaderDownloadMgr$saveChapterDownloadPercentOrThrowError$1> continuation) {
        super(continuation);
        this.this$0 = readerDownloadMgr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object h0;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h0 = this.this$0.h0(null, null, 0.0f, 0, this);
        return h0;
    }
}
