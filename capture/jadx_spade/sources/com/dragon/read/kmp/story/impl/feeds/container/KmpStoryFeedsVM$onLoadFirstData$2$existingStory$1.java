package com.dragon.read.kmp.story.impl.feeds.container;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$onLoadFirstData$2$existingStory$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$onLoadFirstData$2$existingStory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kp4.b>, Object> {
    final /* synthetic */ com.dragon.read.kmp.story.impl.feeds.data.e $storyData;
    final /* synthetic */ KmpStoryFeedsVM $this_runCatching;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$onLoadFirstData$2$existingStory$1(KmpStoryFeedsVM kmpStoryFeedsVM, com.dragon.read.kmp.story.impl.feeds.data.e eVar, Continuation<? super KmpStoryFeedsVM$onLoadFirstData$2$existingStory$1> continuation) {
        super(2, continuation);
        this.$this_runCatching = kmpStoryFeedsVM;
        this.$storyData = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryFeedsVM$onLoadFirstData$2$existingStory$1(this.$this_runCatching, this.$storyData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kp4.b> continuation) {
        return ((KmpStoryFeedsVM$onLoadFirstData$2$existingStory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.$this_runCatching.k.n(this.$storyData.a);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
