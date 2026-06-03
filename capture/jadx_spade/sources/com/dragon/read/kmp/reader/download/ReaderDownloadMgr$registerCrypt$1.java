package com.dragon.read.kmp.reader.download;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr", f = "ReaderDownloadMgr.kt", i = {}, l = {833}, m = "registerCrypt", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$registerCrypt$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReaderDownloadMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$registerCrypt$1(ReaderDownloadMgr readerDownloadMgr, Continuation<? super ReaderDownloadMgr$registerCrypt$1> continuation) {
        super(continuation);
        this.this$0 = readerDownloadMgr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d0(null, this);
    }
}
