package com.dragon.read.kmp.story.impl.album.viewmodel;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$handlePrependResult$1", f = "StoryAlbumViewModel.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryAlbumViewModel$handlePrependResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $anchorIndex;
    final /* synthetic */ int $anchorOffset;
    final /* synthetic */ Ref$IntRef $totalShift;
    int label;
    final /* synthetic */ StoryAlbumViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryAlbumViewModel$handlePrependResult$1(StoryAlbumViewModel storyAlbumViewModel, int i, Ref$IntRef ref$IntRef, int i2, Continuation<? super StoryAlbumViewModel$handlePrependResult$1> continuation) {
        super(2, continuation);
        this.this$0 = storyAlbumViewModel;
        this.$anchorIndex = i;
        this.$totalShift = ref$IntRef;
        this.$anchorOffset = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryAlbumViewModel$handlePrependResult$1(this.this$0, this.$anchorIndex, this.$totalShift, this.$anchorOffset, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryAlbumViewModel$handlePrependResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            LazyListState lazyListState = this.this$0.b;
            int i2 = this.$anchorIndex + this.$totalShift.element;
            int i3 = this.$anchorOffset;
            this.label = 1;
            if (lazyListState.D(i2, i3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
