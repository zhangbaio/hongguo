package com.dragon.read.kmp.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.utils.AppUtils", f = "AppUtils.kt", i = {0, 0}, l = {61}, m = "sendLocalBroadcast", n = {"intent", "withPlatform"}, s = {"L$0", "Z$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class AppUtils$sendLocalBroadcast$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppUtils$sendLocalBroadcast$1(AppUtils appUtils, Continuation<? super AppUtils$sendLocalBroadcast$1> continuation) {
        super(continuation);
        this.this$0 = appUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, false, this);
    }
}
