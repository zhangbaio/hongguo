package com.dragon.read.leftslidepage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.leftslidepage.SidebarDataManager", f = "SidebarDataManager.kt", i = {0}, l = {256}, m = "parseRecentWatchParams", n = {"resp"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SidebarDataManager$parseRecentWatchParams$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SidebarDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SidebarDataManager$parseRecentWatchParams$1(SidebarDataManager sidebarDataManager, Continuation<? super SidebarDataManager$parseRecentWatchParams$1> continuation) {
        super(continuation);
        this.this$0 = sidebarDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object z;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        z = this.this$0.z(null, this);
        return z;
    }
}
