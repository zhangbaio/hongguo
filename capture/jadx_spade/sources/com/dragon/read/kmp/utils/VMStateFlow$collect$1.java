package com.dragon.read.kmp.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.utils.VMStateFlow", f = "VMStateFlowWrapper.kt", i = {}, l = {43}, m = "collect", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class VMStateFlow$collect$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VMStateFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VMStateFlow$collect$1(VMStateFlow<T> vMStateFlow, Continuation<? super VMStateFlow$collect$1> continuation) {
        super(continuation);
        this.this$0 = vMStateFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
