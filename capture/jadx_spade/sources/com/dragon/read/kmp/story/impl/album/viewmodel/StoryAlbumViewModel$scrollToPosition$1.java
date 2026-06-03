package com.dragon.read.kmp.story.impl.album.viewmodel;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.album.viewmodel.StoryAlbumViewModel$scrollToPosition$1", f = "StoryAlbumViewModel.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryAlbumViewModel$scrollToPosition$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ StoryAlbumViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryAlbumViewModel$scrollToPosition$1(StoryAlbumViewModel storyAlbumViewModel, int i, Continuation<? super StoryAlbumViewModel$scrollToPosition$1> continuation) {
        super(2, continuation);
        this.this$0 = storyAlbumViewModel;
        this.$position = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryAlbumViewModel$scrollToPosition$1(this.this$0, this.$position, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryAlbumViewModel$scrollToPosition$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            int i2 = this.$position;
            this.label = 1;
            if (LazyListState.q(lazyListState, i2, 0, this, 2, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
