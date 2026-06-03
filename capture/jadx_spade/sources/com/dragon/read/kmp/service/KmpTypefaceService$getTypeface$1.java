package com.dragon.read.kmp.service;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.service.KmpTypefaceService", f = "KmpTypefaceService.android.kt", i = {}, l = {11}, m = "getTypeface", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpTypefaceService$getTypeface$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpTypefaceService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpTypefaceService$getTypeface$1(KmpTypefaceService kmpTypefaceService, Continuation<? super KmpTypefaceService$getTypeface$1> continuation) {
        super(continuation);
        this.this$0 = kmpTypefaceService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
