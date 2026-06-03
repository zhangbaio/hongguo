package com.dragon.read.kmp.story.impl.feeds.container;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient$scrollToTargetStoryPage$2", f = "KmpStoryClient.kt", i = {}, l = {185, 188, 191}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryClient$scrollToTargetStoryPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $adapterIndex;
    final /* synthetic */ int $offset;
    final /* synthetic */ boolean $smooth;
    int label;
    final /* synthetic */ KmpStoryClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryClient$scrollToTargetStoryPage$2(boolean z, KmpStoryClient kmpStoryClient, int i, int i2, Continuation<? super KmpStoryClient$scrollToTargetStoryPage$2> continuation) {
        super(2, continuation);
        this.$smooth = z;
        this.this$0 = kmpStoryClient;
        this.$adapterIndex = i;
        this.$offset = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryClient$scrollToTargetStoryPage$2(this.$smooth, this.this$0, this.$adapterIndex, this.$offset, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryClient$scrollToTargetStoryPage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        LazyListState lazyListState;
        LazyListState lazyListState2;
        LazyListState lazyListState3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable unused) {
            lazyListState = this.this$0.a;
            int i2 = this.$adapterIndex;
            int i3 = this.$offset;
            this.label = 2;
            if (lazyListState.D(i2, i3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            if (this.$smooth) {
                lazyListState3 = this.this$0.a;
                int i4 = this.$adapterIndex;
                int i5 = this.$offset;
                this.label = 1;
                if (lazyListState3.p(i4, i5, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                lazyListState2 = this.this$0.a;
                int i6 = this.$adapterIndex;
                int i7 = this.$offset;
                this.label = 3;
                if (lazyListState2.D(i6, i7, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}
