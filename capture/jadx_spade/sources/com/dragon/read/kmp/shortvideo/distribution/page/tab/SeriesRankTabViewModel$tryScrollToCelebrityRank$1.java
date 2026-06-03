package com.dragon.read.kmp.shortvideo.distribution.page.tab;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabViewModel$tryScrollToCelebrityRank$1", f = "SeriesRankTabViewModel.kt", i = {}, l = {369, 374}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesRankTabViewModel$tryScrollToCelebrityRank$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $celebrityUserId;
    final /* synthetic */ int $scrollIndex;
    int label;
    final /* synthetic */ SeriesRankTabViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesRankTabViewModel$tryScrollToCelebrityRank$1(SeriesRankTabViewModel seriesRankTabViewModel, int i, String str, Continuation<? super SeriesRankTabViewModel$tryScrollToCelebrityRank$1> continuation) {
        super(2, continuation);
        this.this$0 = seriesRankTabViewModel;
        this.$scrollIndex = i;
        this.$celebrityUserId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesRankTabViewModel$tryScrollToCelebrityRank$1(this.this$0, this.$scrollIndex, this.$celebrityUserId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesRankTabViewModel$tryScrollToCelebrityRank$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        this.this$0.m.setValue((Object) null);
                        this.this$0.n.setValue(Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                this.this$0.z = true;
                LazyListState lazyListState = this.this$0.A;
                if (lazyListState != null) {
                    int i2 = this.$scrollIndex;
                    this.label = 1;
                    if (LazyListState.E(lazyListState, i2, 0, this, 2, (Object) null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            this.this$0.z = false;
            this.this$0.m.setValue(this.$celebrityUserId);
            this.label = 2;
            if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.this$0.m.setValue((Object) null);
            this.this$0.n.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.this$0.z = false;
            throw th;
        }
    }
}
