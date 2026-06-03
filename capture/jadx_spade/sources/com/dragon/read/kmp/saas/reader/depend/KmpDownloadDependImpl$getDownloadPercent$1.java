package com.dragon.read.kmp.saas.reader.depend;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.saas.reader.depend.KmpDownloadDependImpl", f = "KmpDownloadDependImpl.kt", i = {}, l = {28}, m = "getDownloadPercent", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpDownloadDependImpl$getDownloadPercent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpDownloadDependImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpDownloadDependImpl$getDownloadPercent$1(KmpDownloadDependImpl kmpDownloadDependImpl, Continuation<? super KmpDownloadDependImpl$getDownloadPercent$1> continuation) {
        super(continuation);
        this.this$0 = kmpDownloadDependImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, this);
    }
}
