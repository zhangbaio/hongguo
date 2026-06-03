package com.dragon.read.leftslidepage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.leftslidepage.SidebarDataManager", f = "SidebarDataManager.kt", i = {0, 1}, l = {141, 145}, m = "fetchMsgData", n = {"pullNotification", "pullNotification"}, s = {"Z$0", "Z$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SidebarDataManager$fetchMsgData$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SidebarDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SidebarDataManager$fetchMsgData$1(SidebarDataManager sidebarDataManager, Continuation<? super SidebarDataManager$fetchMsgData$1> continuation) {
        super(continuation);
        this.this$0 = sidebarDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object p;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        p = this.this$0.p(false, false, this);
        return p;
    }
}
