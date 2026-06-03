package com.dragon.read.kmp.story.impl.album.base;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.community.base.sdk.load.KmpCSSLoadStatus;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$2$1", f = "StoryAlbumScrollList.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryAlbumScrollListKt$StoryAlbumScrollList$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $allowPrevLoad$delegate;
    final /* synthetic */ boolean $hasPrev;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ Function0<Unit> $onLoadPrev;
    final /* synthetic */ int $prevLoadThreshold;
    final /* synthetic */ KmpCSSLoadStatus $prevLoadingStatus;
    final /* synthetic */ MutableState<Boolean> $prevTriggeredAtTop$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryAlbumScrollListKt$StoryAlbumScrollList$2$1(Function0<Unit> function0, LazyListState lazyListState, int i, boolean z, KmpCSSLoadStatus kmpCSSLoadStatus, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super StoryAlbumScrollListKt$StoryAlbumScrollList$2$1> continuation) {
        super(2, continuation);
        this.$onLoadPrev = function0;
        this.$listState = lazyListState;
        this.$prevLoadThreshold = i;
        this.$hasPrev = z;
        this.$prevLoadingStatus = kmpCSSLoadStatus;
        this.$allowPrevLoad$delegate = mutableState;
        this.$prevTriggeredAtTop$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryAlbumScrollListKt$StoryAlbumScrollList$2$1(this.$onLoadPrev, this.$listState, this.$prevLoadThreshold, this.$hasPrev, this.$prevLoadingStatus, this.$allowPrevLoad$delegate, this.$prevTriggeredAtTop$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryAlbumScrollListKt$StoryAlbumScrollList$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Triple invokeSuspend$lambda$0(LazyListState lazyListState) {
        return new Triple(Integer.valueOf(lazyListState.u()), Integer.valueOf(lazyListState.v()), Boolean.valueOf(lazyListState.b()));
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
            if (this.$onLoadPrev == null) {
                return Unit.INSTANCE;
            }
            final LazyListState lazyListState = this.$listState;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.album.base.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Triple invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = StoryAlbumScrollListKt$StoryAlbumScrollList$2$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            }));
            a aVar = new a(this.$prevLoadThreshold, this.$hasPrev, this.$prevLoadingStatus, this.$onLoadPrev, this.$allowPrevLoad$delegate, this.$prevTriggeredAtTop$delegate);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ int a;
        final /* synthetic */ boolean b;
        final /* synthetic */ KmpCSSLoadStatus c;
        final /* synthetic */ Function0<Unit> d;
        final /* synthetic */ MutableState<Boolean> e;
        final /* synthetic */ MutableState<Boolean> f;

        a(int i, boolean z, KmpCSSLoadStatus kmpCSSLoadStatus, Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
            this.a = i;
            this.b = z;
            this.c = kmpCSSLoadStatus;
            this.d = function0;
            this.e = mutableState;
            this.f = mutableState2;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Triple<Integer, Integer, Boolean> triple, Continuation<? super Unit> continuation) {
            boolean z;
            boolean m;
            boolean m2;
            boolean q;
            KmpCSSLoadStatus kmpCSSLoadStatus;
            int intValue = triple.component1().intValue();
            int intValue2 = triple.component2().intValue();
            boolean booleanValue = triple.component3().booleanValue();
            if (intValue <= this.a && intValue2 == 0) {
                z = true;
            } else {
                z = false;
            }
            m = StoryAlbumScrollListKt.m(this.e);
            if (!m && !z) {
                StoryAlbumScrollListKt.p(this.e, true);
            }
            if (!z) {
                StoryAlbumScrollListKt.r(this.f, false);
            }
            m2 = StoryAlbumScrollListKt.m(this.e);
            if ((m2 || booleanValue) && z && this.b) {
                q = StoryAlbumScrollListKt.q(this.f);
                if (!q && (kmpCSSLoadStatus = this.c) != KmpCSSLoadStatus.Loading && kmpCSSLoadStatus != KmpCSSLoadStatus.Error) {
                    StoryAlbumScrollListKt.r(this.f, true);
                    this.d.invoke();
                }
            }
            return Unit.INSTANCE;
        }
    }
}
