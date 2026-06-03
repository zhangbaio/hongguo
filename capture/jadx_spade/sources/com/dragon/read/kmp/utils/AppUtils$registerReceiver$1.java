package com.dragon.read.kmp.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.utils.AppUtils", f = "AppUtils.kt", i = {}, l = {73}, m = "registerReceiver", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class AppUtils$registerReceiver$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppUtils$registerReceiver$1(AppUtils appUtils, Continuation<? super AppUtils$registerReceiver$1> continuation) {
        super(continuation);
        this.this$0 = appUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerReceiver(null, null, this);
    }
}
