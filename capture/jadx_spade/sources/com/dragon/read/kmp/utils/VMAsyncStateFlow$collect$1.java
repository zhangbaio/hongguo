package com.dragon.read.kmp.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.utils.VMAsyncStateFlow", f = "VMStateFlowWrapper.kt", i = {}, l = {61}, m = "collect", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class VMAsyncStateFlow$collect$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ g1<Object> this$0;

    VMAsyncStateFlow$collect$1(g1<Object> g1Var, Continuation<? super VMAsyncStateFlow$collect$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
