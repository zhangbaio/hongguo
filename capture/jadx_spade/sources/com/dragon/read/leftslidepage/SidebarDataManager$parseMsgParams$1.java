package com.dragon.read.leftslidepage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.leftslidepage.SidebarDataManager", f = "SidebarDataManager.kt", i = {0, 0, 0, 1, 1, 1}, l = {172, 173}, m = "parseMsgParams", n = {"resp", "notification", "pullNotification", "notification", "areaTitle", "pullNotification"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SidebarDataManager$parseMsgParams$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SidebarDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SidebarDataManager$parseMsgParams$1(SidebarDataManager sidebarDataManager, Continuation<? super SidebarDataManager$parseMsgParams$1> continuation) {
        super(continuation);
        this.this$0 = sidebarDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object w;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        w = this.this$0.w(null, false, this);
        return w;
    }
}
