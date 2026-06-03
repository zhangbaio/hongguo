package com.dragon.read.kmp.reader.download;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr", f = "ReaderDownloadMgr.kt", i = {}, l = {904}, m = "removeAllChapterCache", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$removeAllChapterCache$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReaderDownloadMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$removeAllChapterCache$2(ReaderDownloadMgr readerDownloadMgr, Continuation<? super ReaderDownloadMgr$removeAllChapterCache$2> continuation) {
        super(continuation);
        this.this$0 = readerDownloadMgr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e0(null, this);
    }
}
