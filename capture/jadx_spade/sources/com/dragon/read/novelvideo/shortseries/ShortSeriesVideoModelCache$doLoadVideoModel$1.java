package com.dragon.read.novelvideo.shortseries;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache", f = "ShortSeriesVideoModelCache.kt", i = {0}, l = {85}, m = "doLoadVideoModel", n = {"params"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ShortSeriesVideoModelCache$doLoadVideoModel$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShortSeriesVideoModelCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortSeriesVideoModelCache$doLoadVideoModel$1(ShortSeriesVideoModelCache shortSeriesVideoModelCache, Continuation<? super ShortSeriesVideoModelCache$doLoadVideoModel$1> continuation) {
        super(continuation);
        this.this$0 = shortSeriesVideoModelCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object doLoadVideoModel;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        doLoadVideoModel = this.this$0.doLoadVideoModel(null, this);
        return doLoadVideoModel;
    }
}
