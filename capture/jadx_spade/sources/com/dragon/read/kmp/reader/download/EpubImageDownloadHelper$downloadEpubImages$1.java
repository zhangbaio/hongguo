package com.dragon.read.kmp.reader.download;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.EpubImageDownloadHelper", f = "EpubImageDownloadHelper.kt", i = {1, 1}, l = {108, 114, 120}, m = "downloadEpubImages", n = {"bookId", "chapterId"}, s = {"L$0", "L$1"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class EpubImageDownloadHelper$downloadEpubImages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EpubImageDownloadHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EpubImageDownloadHelper$downloadEpubImages$1(EpubImageDownloadHelper epubImageDownloadHelper, Continuation<? super EpubImageDownloadHelper$downloadEpubImages$1> continuation) {
        super(continuation);
        this.this$0 = epubImageDownloadHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, null, this);
    }
}
