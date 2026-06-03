package com.dragon.read.leftslidepage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.leftslidepage.SidebarDataManager", f = "SidebarDataManager.kt", i = {1, 1, 2, 2, 3, 3, 4, 4}, l = {405, 419, 438, 448, 450}, m = "buildFunctionData", n = {"title", "funcItemList", "title", "funcItemList", "title", "funcItemList", "title", "funcItemList"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SidebarDataManager$buildFunctionData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SidebarDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SidebarDataManager$buildFunctionData$1(SidebarDataManager sidebarDataManager, Continuation<? super SidebarDataManager$buildFunctionData$1> continuation) {
        super(continuation);
        this.this$0 = sidebarDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object k;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        k = this.this$0.k(this);
        return k;
    }
}
