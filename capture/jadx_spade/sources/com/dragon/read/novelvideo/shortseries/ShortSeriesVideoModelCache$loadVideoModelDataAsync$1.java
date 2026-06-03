package com.dragon.read.novelvideo.shortseries;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache", f = "ShortSeriesVideoModelCache.kt", i = {0, 1}, l = {ConstantsAPI.COMMAND_FINDER_OPEN_EVENT, 45}, m = "loadVideoModelDataAsync", n = {"logText", "logText"}, s = {"L$0", "L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ShortSeriesVideoModelCache$loadVideoModelDataAsync$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShortSeriesVideoModelCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortSeriesVideoModelCache$loadVideoModelDataAsync$1(ShortSeriesVideoModelCache shortSeriesVideoModelCache, Continuation<? super ShortSeriesVideoModelCache$loadVideoModelDataAsync$1> continuation) {
        super(continuation);
        this.this$0 = shortSeriesVideoModelCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadVideoModelDataAsync(null, this);
    }
}
