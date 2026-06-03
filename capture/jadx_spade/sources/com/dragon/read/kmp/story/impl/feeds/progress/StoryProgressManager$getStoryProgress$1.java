package com.dragon.read.kmp.story.impl.feeds.progress;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressManager", f = "StoryProgressManager.kt", i = {}, l = {ConstantsAPI.COMMAND_PAY_INSURANCE}, m = "getStoryProgress", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryProgressManager$getStoryProgress$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StoryProgressManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryProgressManager$getStoryProgress$1(StoryProgressManager storyProgressManager, Continuation<? super StoryProgressManager$getStoryProgress$1> continuation) {
        super(continuation);
        this.this$0 = storyProgressManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
