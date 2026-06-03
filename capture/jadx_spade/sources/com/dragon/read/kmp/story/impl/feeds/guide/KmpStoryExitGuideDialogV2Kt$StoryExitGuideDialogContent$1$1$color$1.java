package com.dragon.read.kmp.story.impl.feeds.guide;

import androidx.compose.ui.graphics.l0;
import com.dragon.read.kmp.story.impl.KmpStoryPlatformHelper;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.guide.KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1$color$1", f = "KmpStoryExitGuideDialogV2.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1$color$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super l0>, Object> {
    final /* synthetic */ String $coverUrl;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1$color$1(String str, Continuation<? super KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1$color$1> continuation) {
        super(2, continuation);
        this.$coverUrl = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1$color$1(this.$coverUrl, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super l0> continuation) {
        return ((KmpStoryExitGuideDialogV2Kt$StoryExitGuideDialogContent$1$1$color$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            KmpStoryPlatformHelper kmpStoryPlatformHelper = KmpStoryPlatformHelper.a;
            String str = this.$coverUrl;
            this.label = 1;
            obj = KmpStoryPlatformHelper.d(kmpStoryPlatformHelper, str, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return l0.j(cq4.a.a.a((float[]) obj));
    }
}
