package com.dragon.read.kmp.story.impl.feeds.container;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$refreshStory$2", f = "KmpStoryFeedsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$refreshStory$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.dragon.read.kmp.story.impl.feeds.data.b $newContent;
    final /* synthetic */ kp4.b $story;
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$refreshStory$2(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar, com.dragon.read.kmp.story.impl.feeds.data.b bVar2, Continuation<? super KmpStoryFeedsVM$refreshStory$2> continuation) {
        super(2, continuation);
        this.this$0 = kmpStoryFeedsVM;
        this.$story = bVar;
        this.$newContent = bVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryFeedsVM$refreshStory$2(this.this$0, this.$story, this.$newContent, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryFeedsVM$refreshStory$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.k.v(this.$story, this.$newContent);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
