package com.dragon.read.kmp.story.impl.album.base;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.community.base.sdk.load.KmpCSSLoadStatus;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$3$1", f = "StoryAlbumScrollList.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryAlbumScrollListKt$StoryAlbumScrollList$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ int $loadThreshold;
    final /* synthetic */ Function0<Unit> $onLoadMore;
    final /* synthetic */ KmpCSSLoadStatus $realLoadingStatus;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryAlbumScrollListKt$StoryAlbumScrollList$3$1(LazyListState lazyListState, int i, KmpCSSLoadStatus kmpCSSLoadStatus, Function0<Unit> function0, Continuation<? super StoryAlbumScrollListKt$StoryAlbumScrollList$3$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$loadThreshold = i;
        this.$realLoadingStatus = kmpCSSLoadStatus;
        this.$onLoadMore = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryAlbumScrollListKt$StoryAlbumScrollList$3$1(this.$listState, this.$loadThreshold, this.$realLoadingStatus, this.$onLoadMore, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryAlbumScrollListKt$StoryAlbumScrollList$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer invokeSuspend$lambda$0(LazyListState lazyListState) {
        Object lastOrNull;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) lazyListState.x().h());
        o oVar = (o) lastOrNull;
        if (oVar != null) {
            return Integer.valueOf(oVar.getIndex());
        }
        return null;
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
            final LazyListState lazyListState = this.$listState;
            final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.album.base.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Integer invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = StoryAlbumScrollListKt$StoryAlbumScrollList$3$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            });
            final LazyListState lazyListState2 = this.$listState;
            final int i2 = this.$loadThreshold;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Pair<? extends Boolean, ? extends Integer>>() { // from class: com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$3$1$invokeSuspend$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Pair<? extends Boolean, ? extends Integer>> flowCollector, Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, lazyListState2, i2), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }

                /* renamed from: com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$3$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector a;
                    final /* synthetic */ LazyListState b;
                    final /* synthetic */ int c;

                    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$3$1$invokeSuspend$$inlined$map$1$2", f = "StoryAlbumScrollList.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$3$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, LazyListState lazyListState, int i) {
                        this.a = flowCollector;
                        this.b = lazyListState;
                        this.c = i;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$3$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r7
                            com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$3$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$3$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$3$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$3$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r7)
                            goto L69
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            kotlin.ResultKt.throwOnFailure(r7)
                            kotlinx.coroutines.flow.FlowCollector r7 = r5.a
                            java.lang.Integer r6 = (java.lang.Integer) r6
                            androidx.compose.foundation.lazy.LazyListState r2 = r5.b
                            androidx.compose.foundation.lazy.x r2 = r2.x()
                            int r2 = r2.f()
                            if (r6 == 0) goto L52
                            if (r2 <= 0) goto L52
                            int r6 = r6.intValue()
                            int r4 = r5.c
                            int r4 = r2 - r4
                            if (r6 < r4) goto L52
                            r6 = 1
                            goto L53
                        L52:
                            r6 = 0
                        L53:
                            kotlin.Pair r4 = new kotlin.Pair
                            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
                            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
                            r4.<init>(r6, r2)
                            r0.label = r3
                            java.lang.Object r6 = r7.emit(r4, r0)
                            if (r6 != r1) goto L69
                            return r1
                        L69:
                            kotlin.Unit r6 = kotlin.Unit.INSTANCE
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt$StoryAlbumScrollList$3$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            }, new Function2() { // from class: com.dragon.read.kmp.story.impl.album.base.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    boolean invokeSuspend$lambda$2;
                    invokeSuspend$lambda$2 = StoryAlbumScrollListKt$StoryAlbumScrollList$3$1.invokeSuspend$lambda$2((Pair) obj2, (Pair) obj3);
                    return Boolean.valueOf(invokeSuspend$lambda$2);
                }
            });
            a aVar = new a(this.$realLoadingStatus, this.$onLoadMore);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ KmpCSSLoadStatus a;
        final /* synthetic */ Function0<Unit> b;

        a(KmpCSSLoadStatus kmpCSSLoadStatus, Function0<Unit> function0) {
            this.a = kmpCSSLoadStatus;
            this.b = function0;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Pair<Boolean, Integer> pair, Continuation<? super Unit> continuation) {
            KmpCSSLoadStatus kmpCSSLoadStatus;
            int i;
            if (pair.getFirst().booleanValue() && (kmpCSSLoadStatus = this.a) != KmpCSSLoadStatus.Error && kmpCSSLoadStatus != KmpCSSLoadStatus.LoadNoMore && kmpCSSLoadStatus != KmpCSSLoadStatus.HIDE) {
                this.b.invoke();
                i = StoryAlbumScrollListKt.a;
                StoryAlbumScrollListKt.a = i + 1;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$2(Pair pair, Pair pair2) {
        if (((Boolean) pair.getFirst()).booleanValue() == ((Boolean) pair2.getFirst()).booleanValue() && ((Number) pair2.getSecond()).intValue() == ((Number) pair.getSecond()).intValue()) {
            return true;
        }
        return false;
    }
}
