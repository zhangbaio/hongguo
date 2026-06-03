package com.dragon.read.kmp.service;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.service.KmpBookshelfService", f = "KmpBookshelfService.android.kt", i = {}, l = {45}, m = "isInBookshelf", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpBookshelfService$isInBookshelf$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpBookshelfService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpBookshelfService$isInBookshelf$1(KmpBookshelfService kmpBookshelfService, Continuation<? super KmpBookshelfService$isInBookshelf$1> continuation) {
        super(continuation);
        this.this$0 = kmpBookshelfService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
