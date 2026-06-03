package com.dragon.read.kmp.story.impl.feeds.progress;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import yo4.c;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressService$tryUpdateProgressForStory$1", f = "StoryProgressService.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryProgressService$tryUpdateProgressForStory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $currentPage;
    final /* synthetic */ int $currentPageOffset;
    final /* synthetic */ kp4.b $story;
    int label;
    final /* synthetic */ StoryProgressService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryProgressService$tryUpdateProgressForStory$1(StoryProgressService storyProgressService, kp4.b bVar, c cVar, int i, Continuation<? super StoryProgressService$tryUpdateProgressForStory$1> continuation) {
        super(2, continuation);
        this.this$0 = storyProgressService;
        this.$story = bVar;
        this.$currentPage = cVar;
        this.$currentPageOffset = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryProgressService$tryUpdateProgressForStory$1(this.this$0, this.$story, this.$currentPage, this.$currentPageOffset, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryProgressService$tryUpdateProgressForStory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            StoryProgressService storyProgressService = this.this$0;
            kp4.b bVar = this.$story;
            c cVar = this.$currentPage;
            int i2 = this.$currentPageOffset;
            this.label = 1;
            if (storyProgressService.h(bVar, cVar, i2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
