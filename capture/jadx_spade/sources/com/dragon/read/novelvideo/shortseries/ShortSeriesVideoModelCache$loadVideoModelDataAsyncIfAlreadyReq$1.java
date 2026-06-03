package com.dragon.read.novelvideo.shortseries;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache", f = "ShortSeriesVideoModelCache.kt", i = {0}, l = {55}, m = "loadVideoModelDataAsyncIfAlreadyReq", n = {"params"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShortSeriesVideoModelCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$1(ShortSeriesVideoModelCache shortSeriesVideoModelCache, Continuation<? super ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$1> continuation) {
        super(continuation);
        this.this$0 = shortSeriesVideoModelCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadVideoModelDataAsyncIfAlreadyReq;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadVideoModelDataAsyncIfAlreadyReq = this.this$0.loadVideoModelDataAsyncIfAlreadyReq(null, this);
        return loadVideoModelDataAsyncIfAlreadyReq;
    }
}
