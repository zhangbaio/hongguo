package com.dragon.read.kmp.story.impl.feeds.actionbar;

import com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopTitleBarKt$StoryTopTitleBar$2$1", f = "StoryTopTitleBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryTopTitleBarKt$StoryTopTitleBar$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $appTheme;
    final /* synthetic */ KmpStoryPolarisTaskCoordinator $coordinator;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryTopTitleBarKt$StoryTopTitleBar$2$1(KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator, int i, Continuation<? super StoryTopTitleBarKt$StoryTopTitleBar$2$1> continuation) {
        super(2, continuation);
        this.$coordinator = kmpStoryPolarisTaskCoordinator;
        this.$appTheme = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryTopTitleBarKt$StoryTopTitleBar$2$1(this.$coordinator, this.$appTheme, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryTopTitleBarKt$StoryTopTitleBar$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$coordinator.x(this.$appTheme);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
