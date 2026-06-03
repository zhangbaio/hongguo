package com.dragon.read.leftslidepage;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.leftslidepage.SidebarDataManager", f = "SidebarDataManager.kt", i = {1}, l = {204, TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_FXAA, 247}, m = "fetchSidebarContent", n = {"data"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SidebarDataManager$fetchSidebarContent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SidebarDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SidebarDataManager$fetchSidebarContent$1(SidebarDataManager sidebarDataManager, Continuation<? super SidebarDataManager$fetchSidebarContent$1> continuation) {
        super(continuation);
        this.this$0 = sidebarDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object q;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        q = this.this$0.q(this);
        return q;
    }
}
