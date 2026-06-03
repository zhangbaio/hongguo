package com.dragon.read.kmp.story.impl.feeds.guide;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.x;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1", f = "KmpNextStoryBottomGuideHelper.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<kp4.b> $currentBottomStory$delegate;
    final /* synthetic */ State<kp4.b> $currentStory$delegate;
    final /* synthetic */ LazyListState $listState;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KmpNextStoryBottomGuideHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1(LazyListState lazyListState, KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper, State<kp4.b> state, State<kp4.b> state2, Continuation<? super KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.this$0 = kmpNextStoryBottomGuideHelper;
        this.$currentStory$delegate = state;
        this.$currentBottomStory$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1 kmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1 = new KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1(this.$listState, this.this$0, this.$currentStory$delegate, this.$currentBottomStory$delegate, continuation);
        kmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1.L$0 = obj;
        return kmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final LazyListState lazyListState = this.$listState;
            final Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    x x;
                    x = lazyListState.x();
                    return x;
                }
            });
            final Flow<List<? extends androidx.compose.foundation.lazy.o>> flow = new Flow<List<? extends androidx.compose.foundation.lazy.o>>() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$map$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super List<? extends androidx.compose.foundation.lazy.o>> flowCollector, Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }

                /* renamed from: com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector a;

                    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$map$1$2", f = "KmpNextStoryBottomGuideHelper.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.a = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.a
                            androidx.compose.foundation.lazy.x r5 = (androidx.compose.foundation.lazy.x) r5
                            java.util.List r5 = r5.h()
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            };
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<List<? extends androidx.compose.foundation.lazy.o>>() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$filter$1
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super List<? extends androidx.compose.foundation.lazy.o>> flowCollector, Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended2) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }

                /* renamed from: com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector a;

                    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$filter$1$2", f = "KmpNextStoryBottomGuideHelper.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        Object L$1;
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

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.a = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$filter$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.ResultKt.throwOnFailure(r6)
                            goto L49
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            kotlin.ResultKt.throwOnFailure(r6)
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.a
                            r2 = r5
                            java.util.List r2 = (java.util.List) r2
                            boolean r2 = r2.isEmpty()
                            r2 = r2 ^ r3
                            if (r2 == 0) goto L49
                            r0.label = r3
                            java.lang.Object r5 = r6.emit(r5, r0)
                            if (r5 != r1) goto L49
                            return r1
                        L49:
                            kotlin.Unit r5 = kotlin.Unit.INSTANCE
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }
            });
            final KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper = this.this$0;
            final State<kp4.b> state = this.$currentStory$delegate;
            final State<kp4.b> state2 = this.$currentBottomStory$delegate;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1.4
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(List<? extends androidx.compose.foundation.lazy.o> list, Continuation<? super Unit> continuation) {
                    kp4.b m;
                    kp4.b n;
                    kp4.b m2;
                    kp4.b n2;
                    boolean N;
                    boolean z;
                    Job job;
                    tp4.b bVar;
                    String str;
                    boolean z2;
                    Job job2;
                    kp4.b m3;
                    kp4.b bVar2;
                    kp4.b bVar3;
                    String str2;
                    Job e;
                    tp4.b bVar4;
                    String str3;
                    KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper2 = KmpNextStoryBottomGuideHelper.this;
                    m = KmpNextStoryBottomGuideHelper.m(state);
                    n = KmpNextStoryBottomGuideHelper.n(state2);
                    kmpNextStoryBottomGuideHelper2.P(m, n);
                    KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper3 = KmpNextStoryBottomGuideHelper.this;
                    m2 = KmpNextStoryBottomGuideHelper.m(state);
                    n2 = KmpNextStoryBottomGuideHelper.n(state2);
                    N = kmpNextStoryBottomGuideHelper3.N(m2, n2, list);
                    kmpNextStoryBottomGuideHelper3.d = N;
                    if (!((Boolean) KmpNextStoryBottomGuideHelper.this.b.getValue()).booleanValue()) {
                        z2 = KmpNextStoryBottomGuideHelper.this.d;
                        if (z2) {
                            job2 = KmpNextStoryBottomGuideHelper.this.i;
                            if (job2 != null) {
                                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                            }
                            KmpNextStoryBottomGuideHelper.this.i = null;
                            KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper4 = KmpNextStoryBottomGuideHelper.this;
                            m3 = KmpNextStoryBottomGuideHelper.m(state);
                            kmpNextStoryBottomGuideHelper4.f = m3;
                            KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper5 = KmpNextStoryBottomGuideHelper.this;
                            kmpNextStoryBottomGuideHelper5.g = kmpNextStoryBottomGuideHelper5.a.y.h();
                            bVar2 = KmpNextStoryBottomGuideHelper.this.f;
                            if (bVar2 != null) {
                                KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper6 = KmpNextStoryBottomGuideHelper.this;
                                CoroutineScope coroutineScope2 = coroutineScope;
                                bVar3 = kmpNextStoryBottomGuideHelper6.g;
                                if (bVar3 != null) {
                                    kmpNextStoryBottomGuideHelper6.Q("pct_90", bVar2, bVar3);
                                    com.dragon.read.kmp.story.impl.feeds.o oVar = com.dragon.read.kmp.story.impl.feeds.o.a;
                                    str2 = kmpNextStoryBottomGuideHelper6.e;
                                    if (str2 == null) {
                                        str2 = "";
                                    }
                                    oVar.a(str2);
                                    e = kotlinx.coroutines.i.e(coroutineScope2, null, null, new KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1$4$1$1$1(kmpNextStoryBottomGuideHelper6, null), 3, null);
                                    kmpNextStoryBottomGuideHelper6.i = e;
                                    bVar4 = kmpNextStoryBottomGuideHelper6.o;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("当前篇");
                                    str3 = kmpNextStoryBottomGuideHelper6.e;
                                    sb.append(str3);
                                    sb.append(" 开始展示引导");
                                    bVar4.d(sb.toString());
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    if (((Boolean) KmpNextStoryBottomGuideHelper.this.b.getValue()).booleanValue()) {
                        z = KmpNextStoryBottomGuideHelper.this.d;
                        if (!z) {
                            KmpNextStoryBottomGuideHelper.this.J();
                            job = KmpNextStoryBottomGuideHelper.this.i;
                            if (job != null) {
                                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                            }
                            KmpNextStoryBottomGuideHelper.this.i = null;
                            bVar = KmpNextStoryBottomGuideHelper.this.o;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("当前篇");
                            str = KmpNextStoryBottomGuideHelper.this.e;
                            sb2.append(str);
                            sb2.append(" 正在展示的引导被强制隐藏");
                            bVar.a(sb2.toString());
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (distinctUntilChanged.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
