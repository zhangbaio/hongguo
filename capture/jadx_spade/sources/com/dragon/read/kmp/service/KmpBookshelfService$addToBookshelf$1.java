package com.dragon.read.kmp.service;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.service.KmpBookshelfService", f = "KmpBookshelfService.android.kt", i = {}, l = {54}, m = "addToBookshelf", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpBookshelfService$addToBookshelf$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpBookshelfService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpBookshelfService$addToBookshelf$1(KmpBookshelfService kmpBookshelfService, Continuation<? super KmpBookshelfService$addToBookshelf$1> continuation) {
        super(continuation);
        this.this$0 = kmpBookshelfService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, false, this);
    }
}
