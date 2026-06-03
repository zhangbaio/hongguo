package com.dragon.read.kmp.story.impl.feeds.container;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM", f = "KmpStoryFeedsVM.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_SUB_LANG_IDS}, m = "commitOrRefreshFirstStory", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$commitOrRefreshFirstStory$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$commitOrRefreshFirstStory$1(KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super KmpStoryFeedsVM$commitOrRefreshFirstStory$1> continuation) {
        super(continuation);
        this.this$0 = kmpStoryFeedsVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object l1;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        l1 = this.this$0.l1(null, this);
        return l1;
    }
}
