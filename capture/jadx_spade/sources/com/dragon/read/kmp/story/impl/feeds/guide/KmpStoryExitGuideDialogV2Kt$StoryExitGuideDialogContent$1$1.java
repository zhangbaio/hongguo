package com.dragon.read.kmp.story.impl.feeds.guide;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.l0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.guide.KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1", f = "KmpStoryExitGuideDialogV2.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<l0> $bgColor;
    final /* synthetic */ kp4.b $story;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1(kp4.b bVar, MutableState<l0> mutableState, Continuation<? super KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1> continuation) {
        super(2, continuation);
        this.$story = bVar;
        this.$bgColor = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1(this.$story, this.$bgColor, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            String str = this.$story.d().n;
            if (str == null) {
                return Unit.INSTANCE;
            }
            CoroutineDispatcher io2 = Dispatchers.getIO();
            KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1$color$1 kmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1$color$1 = new KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1$color$1(str, null);
            this.label = 1;
            obj = BuildersKt.withContext(io2, kmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1$color$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.$bgColor.setValue(l0.j(((l0) obj).x()));
        return Unit.INSTANCE;
    }
}
