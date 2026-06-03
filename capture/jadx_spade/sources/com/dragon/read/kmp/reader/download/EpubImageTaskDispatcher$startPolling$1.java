package com.dragon.read.kmp.reader.download;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.EpubImageTaskDispatcher", f = "EpubImageTaskDispatcher.kt", i = {}, l = {70}, m = "startPolling", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class EpubImageTaskDispatcher$startPolling$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EpubImageTaskDispatcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EpubImageTaskDispatcher$startPolling$1(EpubImageTaskDispatcher epubImageTaskDispatcher, Continuation<? super EpubImageTaskDispatcher$startPolling$1> continuation) {
        super(continuation);
        this.this$0 = epubImageTaskDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object g;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g = this.this$0.g(this);
        return g;
    }
}
