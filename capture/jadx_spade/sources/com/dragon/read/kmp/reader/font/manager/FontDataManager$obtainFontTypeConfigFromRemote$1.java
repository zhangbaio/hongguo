package com.dragon.read.kmp.reader.font.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDataManager", f = "FontDataManager.kt", i = {0, 0, 1, 1, 2, 2}, l = {257, 150, 156}, m = "obtainFontTypeConfigFromRemote", n = {"notNullDataSource", "$this$withLock_u24default$iv", "notNullDataSource", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "remoteConfigs"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontDataManager$obtainFontTypeConfigFromRemote$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FontDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontDataManager$obtainFontTypeConfigFromRemote$1(FontDataManager fontDataManager, Continuation<? super FontDataManager$obtainFontTypeConfigFromRemote$1> continuation) {
        super(continuation);
        this.this$0 = fontDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object s;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        s = this.this$0.s(this);
        return s;
    }
}
