package com.dragon.read.kmp.reader.download;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.DownloadViewMgr", f = "DownloadViewMgr.kt", i = {0, 0, 0}, l = {105}, m = "handleClick", n = {"reader", "bookId", "downloadFinishCallbackJob"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class DownloadViewMgr$handleClick$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadViewMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadViewMgr$handleClick$1(DownloadViewMgr downloadViewMgr, Continuation<? super DownloadViewMgr$handleClick$1> continuation) {
        super(continuation);
        this.this$0 = downloadViewMgr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        f = this.this$0.f(null, this);
        return f;
    }
}
