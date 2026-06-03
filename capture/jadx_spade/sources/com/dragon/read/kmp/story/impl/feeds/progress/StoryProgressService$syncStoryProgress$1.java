package com.dragon.read.kmp.story.impl.feeds.progress;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressService$syncStoryProgress$1", f = "StoryProgressService.kt", i = {}, l = {76, 91}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryProgressService$syncStoryProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $showToast;
    final /* synthetic */ kp4.b $story;
    private /* synthetic */ Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ StoryProgressService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryProgressService$syncStoryProgress$1(kp4.b bVar, StoryProgressService storyProgressService, boolean z, Continuation<? super StoryProgressService$syncStoryProgress$1> continuation) {
        super(2, continuation);
        this.$story = bVar;
        this.this$0 = storyProgressService;
        this.$showToast = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StoryProgressService$syncStoryProgress$1 storyProgressService$syncStoryProgress$1 = new StoryProgressService$syncStoryProgress$1(this.$story, this.this$0, this.$showToast, continuation);
        storyProgressService$syncStoryProgress$1.L$0 = obj;
        return storyProgressService$syncStoryProgress$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryProgressService$syncStoryProgress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00c2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressService$syncStoryProgress$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
