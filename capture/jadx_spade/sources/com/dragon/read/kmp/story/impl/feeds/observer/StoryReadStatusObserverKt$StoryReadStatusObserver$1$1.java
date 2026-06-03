package com.dragon.read.kmp.story.impl.feeds.observer;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt___SetsKt;
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

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt$StoryReadStatusObserver$1$1", f = "StoryReadStatusObserver.kt", i = {}, l = {ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StoryReadStatusObserverKt$StoryReadStatusObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ MutableState<Set<kp4.b>> $previousVisibleStories;
    final /* synthetic */ KmpStoryClient $storyClient;
    final /* synthetic */ KmpStoryFeedsVM $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StoryReadStatusObserverKt$StoryReadStatusObserver$1$1(LazyListState lazyListState, KmpStoryClient kmpStoryClient, MutableState<Set<kp4.b>> mutableState, KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super StoryReadStatusObserverKt$StoryReadStatusObserver$1$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$storyClient = kmpStoryClient;
        this.$previousVisibleStories = mutableState;
        this.$viewModel = kmpStoryFeedsVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StoryReadStatusObserverKt$StoryReadStatusObserver$1$1(this.$lazyListState, this.$storyClient, this.$previousVisibleStories, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StoryReadStatusObserverKt$StoryReadStatusObserver$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invokeSuspend$lambda$0(LazyListState lazyListState) {
        return lazyListState.x().h();
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
            final LazyListState lazyListState = this.$lazyListState;
            final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.p
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = StoryReadStatusObserverKt$StoryReadStatusObserver$1$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            });
            final KmpStoryClient kmpStoryClient = this.$storyClient;
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<Set<? extends kp4.b>>() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt$StoryReadStatusObserver$1$1$invokeSuspend$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Set<? extends kp4.b>> flowCollector, Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, kmpStoryClient), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }

                /* renamed from: com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt$StoryReadStatusObserver$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector a;
                    final /* synthetic */ KmpStoryClient b;

                    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt$StoryReadStatusObserver$1$1$invokeSuspend$$inlined$map$1$2", f = "StoryReadStatusObserver.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt$StoryReadStatusObserver$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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

                    public AnonymousClass2(FlowCollector flowCollector, KmpStoryClient kmpStoryClient) {
                        this.a = flowCollector;
                        this.b = kmpStoryClient;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                        /*
                            r6 = this;
                            boolean r0 = r8 instanceof com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt$StoryReadStatusObserver$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r8
                            com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt$StoryReadStatusObserver$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt$StoryReadStatusObserver$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt$StoryReadStatusObserver$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt$StoryReadStatusObserver$1$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r8)
                            goto L95
                        L29:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r8)
                            throw r7
                        L31:
                            kotlin.ResultKt.throwOnFailure(r8)
                            kotlinx.coroutines.flow.FlowCollector r8 = r6.a
                            java.util.List r7 = (java.util.List) r7
                            java.util.ArrayList r2 = new java.util.ArrayList
                            r2.<init>()
                            java.util.Iterator r7 = r7.iterator()
                        L41:
                            boolean r4 = r7.hasNext()
                            if (r4 == 0) goto L63
                            java.lang.Object r4 = r7.next()
                            androidx.compose.foundation.lazy.o r4 = (androidx.compose.foundation.lazy.o) r4
                            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient r5 = r6.b
                            com.dragon.read.kmp.story.impl.feeds.container.r r5 = r5.e
                            androidx.compose.runtime.snapshots.SnapshotStateList<yo4.c> r5 = r5.b
                            int r4 = r4.getIndex()
                            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r5, r4)
                            yo4.c r4 = (yo4.c) r4
                            if (r4 == 0) goto L41
                            r2.add(r4)
                            goto L41
                        L63:
                            java.util.ArrayList r7 = new java.util.ArrayList
                            r7.<init>()
                            java.util.Iterator r2 = r2.iterator()
                        L6c:
                            boolean r4 = r2.hasNext()
                            if (r4 == 0) goto L88
                            java.lang.Object r4 = r2.next()
                            yo4.c r4 = (yo4.c) r4
                            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient r5 = r6.b
                            java.lang.String r4 = r4.c()
                            kp4.b r4 = r5.n(r4)
                            if (r4 == 0) goto L6c
                            r7.add(r4)
                            goto L6c
                        L88:
                            java.util.Set r7 = kotlin.collections.CollectionsKt.toSet(r7)
                            r0.label = r3
                            java.lang.Object r7 = r8.emit(r7, r0)
                            if (r7 != r1) goto L95
                            return r1
                        L95:
                            kotlin.Unit r7 = kotlin.Unit.INSTANCE
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.observer.StoryReadStatusObserverKt$StoryReadStatusObserver$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            });
            a aVar = new a(this.$previousVisibleStories, this.$viewModel, this.$storyClient);
            this.label = 1;
            if (distinctUntilChanged.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ MutableState<Set<kp4.b>> a;
        final /* synthetic */ KmpStoryFeedsVM b;
        final /* synthetic */ KmpStoryClient c;

        a(MutableState<Set<kp4.b>> mutableState, KmpStoryFeedsVM kmpStoryFeedsVM, KmpStoryClient kmpStoryClient) {
            this.a = mutableState;
            this.b = kmpStoryFeedsVM;
            this.c = kmpStoryClient;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Set<kp4.b> set, Continuation<? super Unit> continuation) {
            Set<kp4.b> minus;
            Set<kp4.b> minus2;
            minus = SetsKt___SetsKt.minus((Set) set, (Iterable) this.a.getValue());
            minus2 = SetsKt___SetsKt.minus((Set) this.a.getValue(), (Iterable) set);
            KmpStoryFeedsVM kmpStoryFeedsVM = this.b;
            KmpStoryClient kmpStoryClient = this.c;
            for (kp4.b bVar : minus) {
                if (bVar.m()) {
                    bVar.q();
                } else {
                    bVar.r();
                    kmpStoryFeedsVM.I1(bVar);
                }
                kmpStoryClient.e(bVar.a(), bVar.d().getBookId());
            }
            for (kp4.b bVar2 : minus2) {
                if (bVar2.m()) {
                    bVar2.s();
                }
            }
            this.a.setValue(set);
            return Unit.INSTANCE;
        }
    }
}
