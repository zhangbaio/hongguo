package com.dragon.read.kmp.story.impl.feeds.guide;

import androidx.compose.animation.core.f1;
import androidx.compose.runtime.MutableState;
import com.dragon.read.kmp.story.impl.feeds.guide.KmpBaseStoryExitAlertHelper;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.guide.KmpStoryExitGuideDialogV2Kt$KmpStoryExitGuideDialogV2$1$1", f = "KmpStoryExitGuideDialogV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryExitGuideDialogV2Kt$KmpStoryExitGuideDialogV2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ w $agent;
    final /* synthetic */ MutableState<KmpBaseStoryExitAlertHelper.DialogEvent> $dialogEvent;
    final /* synthetic */ kp4.b $showStory;
    final /* synthetic */ f1<Boolean> $visibilityState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryExitGuideDialogV2Kt$KmpStoryExitGuideDialogV2$1$1(f1<Boolean> f1Var, w wVar, MutableState<KmpBaseStoryExitAlertHelper.DialogEvent> mutableState, kp4.b bVar, Continuation<? super KmpStoryExitGuideDialogV2Kt$KmpStoryExitGuideDialogV2$1$1> continuation) {
        super(2, continuation);
        this.$visibilityState = f1Var;
        this.$agent = wVar;
        this.$dialogEvent = mutableState;
        this.$showStory = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryExitGuideDialogV2Kt$KmpStoryExitGuideDialogV2$1$1(this.$visibilityState, this.$agent, this.$dialogEvent, this.$showStory, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryExitGuideDialogV2Kt$KmpStoryExitGuideDialogV2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$visibilityState.h() && !((Boolean) this.$visibilityState.a()).booleanValue() && !((Boolean) this.$visibilityState.b()).booleanValue()) {
                this.$agent.f.c((KmpBaseStoryExitAlertHelper.DialogEvent) this.$dialogEvent.getValue(), this.$showStory);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
