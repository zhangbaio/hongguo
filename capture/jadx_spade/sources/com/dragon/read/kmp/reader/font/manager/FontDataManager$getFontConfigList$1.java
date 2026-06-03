package com.dragon.read.kmp.reader.font.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDataManager", f = "FontDataManager.kt", i = {}, l = {61, 71}, m = "getFontConfigList", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontDataManager$getFontConfigList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FontDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontDataManager$getFontConfigList$1(FontDataManager fontDataManager, Continuation<? super FontDataManager$getFontConfigList$1> continuation) {
        super(continuation);
        this.this$0 = fontDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p(this);
    }
}
