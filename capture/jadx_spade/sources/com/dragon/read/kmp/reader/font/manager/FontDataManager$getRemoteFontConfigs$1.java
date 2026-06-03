package com.dragon.read.kmp.reader.font.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDataManager", f = "FontDataManager.kt", i = {0, 0, 0}, l = {180}, m = "getRemoteFontConfigs", n = {"request", "maxAttempts", "attempt"}, s = {"L$0", "I$0", "I$1"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontDataManager$getRemoteFontConfigs$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FontDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontDataManager$getRemoteFontConfigs$1(FontDataManager fontDataManager, Continuation<? super FontDataManager$getRemoteFontConfigs$1> continuation) {
        super(continuation);
        this.this$0 = fontDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object r;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        r = this.this$0.r(this);
        return r;
    }
}
