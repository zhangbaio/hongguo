package com.dragon.read.kmp.reader.download;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.EpubImageDownloadHelper", f = "EpubImageDownloadHelper.kt", i = {0}, l = {89}, m = "fetchEpubImageInfo", n = {"bookId"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class EpubImageDownloadHelper$fetchEpubImageInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EpubImageDownloadHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EpubImageDownloadHelper$fetchEpubImageInfo$1(EpubImageDownloadHelper epubImageDownloadHelper, Continuation<? super EpubImageDownloadHelper$fetchEpubImageInfo$1> continuation) {
        super(continuation);
        this.this$0 = epubImageDownloadHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, this);
    }
}
