package com.dragon.read.kmp.shortvideo.distribution.infinite;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.infinite.VideoInfiniteOutViewKt$VideoInfiniteOutView$2$1", f = "VideoInfiniteOutView.kt", i = {}, l = {103, 110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class VideoInfiniteOutViewKt$VideoInfiniteOutView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<Integer, Integer> $itemWidthMap;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ MutableState<Integer> $scrollToCenterIndex;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoInfiniteOutViewKt$VideoInfiniteOutView$2$1(MutableState<Integer> mutableState, Map<Integer, Integer> map, LazyListState lazyListState, Continuation<? super VideoInfiniteOutViewKt$VideoInfiniteOutView$2$1> continuation) {
        super(2, continuation);
        this.$scrollToCenterIndex = mutableState;
        this.$itemWidthMap = map;
        this.$listState = lazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoInfiniteOutViewKt$VideoInfiniteOutView$2$1(this.$scrollToCenterIndex, this.$itemWidthMap, this.$listState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoInfiniteOutViewKt$VideoInfiniteOutView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int i;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (((Number) this.$scrollToCenterIndex.getValue()).intValue() < 0) {
            return Unit.INSTANCE;
        }
        int intValue = ((Number) this.$scrollToCenterIndex.getValue()).intValue();
        Integer num = this.$itemWidthMap.get(Boxing.boxInt(intValue));
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        if (((int) (this.$listState.x().a() >> 32)) > 0 && i > 0) {
            int c = ((this.$listState.x().c() - this.$listState.x().b()) - i) / 2;
            if (intValue >= 0 && intValue < this.$listState.x().f()) {
                this.label = 2;
                if (this.$listState.D(intValue, -c, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (intValue >= 0 && intValue < this.$listState.x().f()) {
            LazyListState lazyListState = this.$listState;
            this.label = 1;
            if (LazyListState.E(lazyListState, intValue, 0, this, 2, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
