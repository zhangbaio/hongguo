package com.dragon.read.leftslidepage;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.leftslidepage.SidebarDataManager", f = "SidebarDataManager.kt", i = {0, 1, 1}, l = {373, 374}, m = "parseGameParams", n = {"resp", "resp", "areaTitle"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SidebarDataManager$parseGameParams$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SidebarDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SidebarDataManager$parseGameParams$1(SidebarDataManager sidebarDataManager, Continuation<? super SidebarDataManager$parseGameParams$1> continuation) {
        super(continuation);
        this.this$0 = sidebarDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object u;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        u = this.this$0.u(null, this);
        return u;
    }
}
