package com.dragon.read.kmp.util.kotlin;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.util.kotlin.CollectionKt", f = "Collection.kt", i = {0, 0}, l = {239}, m = "removeSafelySuspend", n = {"removeAction", "iterator"}, s = {"L$0", "L$1"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class CollectionKt$removeSafelySuspend$1<K, V> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    CollectionKt$removeSafelySuspend$1(Continuation<? super CollectionKt$removeSafelySuspend$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CollectionKt.b(null, null, this);
    }
}
