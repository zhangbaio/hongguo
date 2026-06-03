package com.dragon.read.kmp.reader.download;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr", f = "ReaderDownloadMgr.kt", i = {0}, l = {TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES}, m = "blockingGetDownloadPercent", n = {"bookId"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$blockingGetDownloadPercent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReaderDownloadMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$blockingGetDownloadPercent$1(ReaderDownloadMgr readerDownloadMgr, Continuation<? super ReaderDownloadMgr$blockingGetDownloadPercent$1> continuation) {
        super(continuation);
        this.this$0 = readerDownloadMgr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.t(null, this);
    }
}
