package com.dragon.read.kmp.story.impl.feeds.actionbar;

import androidx.compose.runtime.State;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.actionbar.StoryTopMenuBarKt$StoryTopMenuBar$1$1", f = "StoryTopMenuBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryTopMenuBarKt$StoryTopMenuBar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isExpanded;
    final /* synthetic */ boolean $isMenuShowing;
    final /* synthetic */ State<Boolean> $isScrolling$delegate;
    final /* synthetic */ KmpStoryFeedsVM $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryTopMenuBarKt$StoryTopMenuBar$1$1(boolean z, boolean z2, KmpStoryFeedsVM kmpStoryFeedsVM, State<Boolean> state, Continuation<? super StoryTopMenuBarKt$StoryTopMenuBar$1$1> continuation) {
        super(2, continuation);
        this.$isExpanded = z;
        this.$isMenuShowing = z2;
        this.$viewModel = kmpStoryFeedsVM;
        this.$isScrolling$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryTopMenuBarKt$StoryTopMenuBar$1$1(this.$isExpanded, this.$isMenuShowing, this.$viewModel, this.$isScrolling$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryTopMenuBarKt$StoryTopMenuBar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean y;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$isExpanded) {
                y = StoryTopMenuBarKt.y(this.$isScrolling$delegate);
                if (y && this.$isMenuShowing) {
                    this.$viewModel.s1();
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
