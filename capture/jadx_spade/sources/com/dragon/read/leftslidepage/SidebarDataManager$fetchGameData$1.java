package com.dragon.read.leftslidepage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.leftslidepage.SidebarDataManager", f = "SidebarDataManager.kt", i = {}, l = {359, 362}, m = "fetchGameData", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SidebarDataManager$fetchGameData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SidebarDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SidebarDataManager$fetchGameData$1(SidebarDataManager sidebarDataManager, Continuation<? super SidebarDataManager$fetchGameData$1> continuation) {
        super(continuation);
        this.this$0 = sidebarDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object o;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        o = this.this$0.o(this);
        return o;
    }
}
