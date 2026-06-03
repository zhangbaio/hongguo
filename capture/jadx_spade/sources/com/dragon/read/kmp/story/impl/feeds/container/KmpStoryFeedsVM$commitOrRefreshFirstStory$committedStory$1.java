package com.dragon.read.kmp.story.impl.feeds.container;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$commitOrRefreshFirstStory$committedStory$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$commitOrRefreshFirstStory$committedStory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kp4.b>, Object> {
    final /* synthetic */ kp4.b $story;
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$commitOrRefreshFirstStory$committedStory$1(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar, Continuation<? super KmpStoryFeedsVM$commitOrRefreshFirstStory$committedStory$1> continuation) {
        super(2, continuation);
        this.this$0 = kmpStoryFeedsVM;
        this.$story = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryFeedsVM$commitOrRefreshFirstStory$committedStory$1(this.this$0, this.$story, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kp4.b> continuation) {
        return ((KmpStoryFeedsVM$commitOrRefreshFirstStory$committedStory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            kp4.b n = this.this$0.k.n(this.$story.a());
            if (n == null) {
                this.this$0.k.t(this.$story);
                return this.$story;
            }
            com.dragon.read.kmp.story.impl.feeds.data.e d = n.d();
            kp4.b bVar = this.$story;
            d.k = bVar.b.a.k;
            n.c.g.j(bVar.c.g);
            this.this$0.k.v(n, this.$story.b);
            return n;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
