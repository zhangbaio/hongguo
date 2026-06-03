package com.dragon.read.kmp.pay.impl;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.pay.impl.NsPayServiceImpl", f = "NsPayServiceImpl.kt", i = {}, l = {104}, m = "getCJPayParams", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class NsPayServiceImpl$getCJPayParams$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NsPayServiceImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NsPayServiceImpl$getCJPayParams$1(NsPayServiceImpl nsPayServiceImpl, Continuation<? super NsPayServiceImpl$getCJPayParams$1> continuation) {
        super(continuation);
        this.this$0 = nsPayServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.I1(null, this);
    }
}
