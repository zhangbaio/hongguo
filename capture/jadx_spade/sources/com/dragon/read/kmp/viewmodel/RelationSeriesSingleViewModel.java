package com.dragon.read.kmp.viewmodel;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel;
import gk4.f0;
import gk4.g0;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import jd4.c;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class RelationSeriesSingleViewModel extends o {
    public static final a l;
    public static final int m;
    private Disposable j;
    private final MutableState k;

    public static final class a {
        static {
            Covode.recordClassIndex(609600);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609599);
        l = new a(null);
        m = 8;
    }

    public final c.a V0() {
        return (c.a) this.k.getValue();
    }

    @Override // com.dragon.read.kmp.viewmodel.o
    protected void onCleared() {
        super.onCleared();
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.dragon.read.kmp.viewmodel.o, xm4.b
    public void refresh() {
        super.refresh();
        if (!Intrinsics.areEqual(this.e, E0())) {
            a1(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U0(RelationSeriesSingleViewModel relationSeriesSingleViewModel) {
        return relationSeriesSingleViewModel.G0();
    }

    private final void a1(c.a aVar) {
        this.k.setValue(aVar);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1", f = "RelationSeriesSingleViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<Boolean> $isLoadingSuccessFlow;
        int label;
        final /* synthetic */ RelationSeriesSingleViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Flow<Boolean> flow, RelationSeriesSingleViewModel relationSeriesSingleViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isLoadingSuccessFlow = flow;
            this.this$0 = relationSeriesSingleViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isLoadingSuccessFlow, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long invokeSuspend$lambda$1(Pair pair) {
            return ((Number) pair.getSecond()).longValue();
        }

        @DebugMetadata(c = "com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$1", f = "RelationSeriesSingleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00801 extends SuspendLambda implements Function3<Boolean, Long, Continuation<? super Pair<? extends Boolean, ? extends Long>>, Object> {
            /* synthetic */ long J$0;
            /* synthetic */ boolean Z$0;
            int label;

            C00801(Continuation<? super C00801> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Long l, Continuation<? super Pair<? extends Boolean, ? extends Long>> continuation) {
                return invoke(bool.booleanValue(), l.longValue(), (Continuation<? super Pair<Boolean, Long>>) continuation);
            }

            public final Object invoke(boolean z, long j, Continuation<? super Pair<Boolean, Long>> continuation) {
                C00801 c00801 = new C00801(continuation);
                c00801.Z$0 = z;
                c00801.J$0 = j;
                return c00801.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return TuplesKt.to(Boxing.boxBoolean(this.Z$0), Boxing.boxLong(this.J$0));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
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
                final Flow combine = FlowKt.combine(this.$isLoadingSuccessFlow, this.this$0.h, new C00801(null));
                Flow distinctUntilChangedBy = FlowKt.distinctUntilChangedBy(new Flow<Pair<? extends Boolean, ? extends Long>>() { // from class: com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$invokeSuspend$$inlined$filter$1
                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Pair<? extends Boolean, ? extends Long>> flowCollector, Continuation continuation) {
                        Object coroutine_suspended2;
                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (collect == coroutine_suspended2) {
                            return collect;
                        }
                        return Unit.INSTANCE;
                    }

                    /* renamed from: com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector a;

                        @DebugMetadata(c = "com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$invokeSuspend$$inlined$filter$1$2", f = "RelationSeriesSingleViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        /* renamed from: com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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
                        public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) {
                            /*
                                r9 = this;
                                boolean r0 = r11 instanceof com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r11
                                com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$invokeSuspend$$inlined$filter$1$2$1
                                r0.<init>(r11)
                            L18:
                                java.lang.Object r11 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r11)
                                goto L63
                            L29:
                                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                                r10.<init>(r11)
                                throw r10
                            L31:
                                kotlin.ResultKt.throwOnFailure(r11)
                                kotlinx.coroutines.flow.FlowCollector r11 = r9.a
                                r2 = r10
                                kotlin.Pair r2 = (kotlin.Pair) r2
                                java.lang.Object r4 = r2.component1()
                                java.lang.Boolean r4 = (java.lang.Boolean) r4
                                boolean r4 = r4.booleanValue()
                                java.lang.Object r2 = r2.component2()
                                java.lang.Number r2 = (java.lang.Number) r2
                                long r5 = r2.longValue()
                                if (r4 == 0) goto L57
                                r7 = 0
                                int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                                if (r2 <= 0) goto L57
                                r2 = 1
                                goto L58
                            L57:
                                r2 = 0
                            L58:
                                if (r2 == 0) goto L63
                                r0.label = r3
                                java.lang.Object r10 = r11.emit(r10, r0)
                                if (r10 != r1) goto L63
                                return r1
                            L63:
                                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                                return r10
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }
                }, new Function1() { // from class: com.dragon.read.kmp.viewmodel.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        long invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = RelationSeriesSingleViewModel.AnonymousClass1.invokeSuspend$lambda$1((Pair) obj2);
                        return Long.valueOf(invokeSuspend$lambda$1);
                    }
                });
                a aVar = new a(this.this$0);
                this.label = 1;
                if (distinctUntilChangedBy.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        /* renamed from: com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel$1$a */
        static final class a<T> implements FlowCollector {
            final /* synthetic */ RelationSeriesSingleViewModel a;

            a(RelationSeriesSingleViewModel relationSeriesSingleViewModel) {
                this.a = relationSeriesSingleViewModel;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(Pair<Boolean, Long> pair, Continuation<? super Unit> continuation) {
                ym4.s sVar;
                if (this.a.V0() != null) {
                    ym4.m mVar = ym4.m.a;
                    c.a V0 = this.a.V0();
                    g0 E0 = this.a.E0();
                    if (E0 != null) {
                        sVar = E0.e;
                    } else {
                        sVar = null;
                    }
                    mVar.g(true, V0, sVar);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelationSeriesSingleViewModel(xm4.a iDepend) {
        super(iDepend);
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.k = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        kotlinx.coroutines.i.e(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.viewmodel.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean U0;
                U0 = RelationSeriesSingleViewModel.U0(RelationSeriesSingleViewModel.this);
                return Boolean.valueOf(U0);
            }
        }), this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(Function1 function1, String str, Throwable th) {
        if (function1 != null) {
            Intrinsics.checkNotNull(th);
            function1.invoke(th);
        }
        com.dragon.read.kmp.j.a.d("RelationSeriesSingleViewModel", "[loadData] seriesId:" + str + " preload error");
        return Unit.INSTANCE;
    }

    @Override // com.dragon.read.kmp.viewmodel.o
    public void J0(g0 params, final Function1<? super f0, Unit> function1, final Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(params, "params");
        final String str = params.b;
        com.dragon.read.kmp.j.a.d("RelationSeriesSingleViewModel", "RelationSeriesViewModel loadData seriesId:" + str);
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        BehaviorSubject<f0> n = xk4.g.a.n(params);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable<f0> observeOn = n.observeOn(mainThread);
        final Function1 function13 = new Function1() { // from class: com.dragon.read.kmp.viewmodel.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit W0;
                W0 = RelationSeriesSingleViewModel.W0(RelationSeriesSingleViewModel.this, function1, str, (f0) obj);
                return W0;
            }
        };
        Consumer<? super f0> consumer = new Consumer() { // from class: com.dragon.read.kmp.viewmodel.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RelationSeriesSingleViewModel.X0(Function1.this, obj);
            }
        };
        final Function1 function14 = new Function1() { // from class: com.dragon.read.kmp.viewmodel.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Y0;
                Y0 = RelationSeriesSingleViewModel.Y0(Function1.this, str, (Throwable) obj);
                return Y0;
            }
        };
        this.j = observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.viewmodel.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RelationSeriesSingleViewModel.Z0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        if (r2.intValue() != r4) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit W0(com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel r5, kotlin.jvm.functions.Function1 r6, java.lang.String r7, gk4.f0 r8) {
        /*
            io.reactivex.disposables.Disposable r0 = r5.j
            if (r0 == 0) goto L7
            r0.dispose()
        L7:
            if (r6 == 0) goto Lf
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r6.invoke(r8)
        Lf:
            r5.b = r8
            java.util.List<gk4.h0> r6 = r8.c
            r5.N0(r6)
            jd4.c$a r6 = r8.d
            r5.a1(r6)
            xk4.i r5 = xk4.i.a
            java.util.List<gk4.h0> r6 = r8.c
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r6 = r6.iterator()
        L28:
            boolean r0 = r6.hasNext()
            r1 = 1
            if (r0 == 0) goto L56
            java.lang.Object r0 = r6.next()
            r2 = r0
            gk4.h0 r2 = (gk4.h0) r2
            jd4.c r2 = r2.c
            com.bytedance.kmp.reading.model.om0 r2 = r2.b
            r3 = 0
            if (r2 == 0) goto L4f
            java.lang.Integer r2 = r2.y
            com.bytedance.kmp.reading.model.VideoContentType r4 = com.bytedance.kmp.reading.model.VideoContentType.ShortSeriesPlay
            int r4 = r4.getValue()
            if (r2 != 0) goto L48
            goto L4f
        L48:
            int r2 = r2.intValue()
            if (r2 != r4) goto L4f
            goto L50
        L4f:
            r1 = 0
        L50:
            if (r1 == 0) goto L28
            r8.add(r0)
            goto L28
        L56:
            java.util.ArrayList r6 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r0)
            r6.<init>(r0)
            java.util.Iterator r8 = r8.iterator()
        L65:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L77
            java.lang.Object r0 = r8.next()
            gk4.h0 r0 = (gk4.h0) r0
            java.lang.String r0 = r0.d
            r6.add(r0)
            goto L65
        L77:
            r8 = 9
            r5.b(r6, r8, r1)
            com.dragon.read.kmp.j r5 = com.dragon.read.kmp.j.a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "[loadData] seriesId:"
            r6.append(r8)
            r6.append(r7)
            java.lang.String r7 = " preload success"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "RelationSeriesSingleViewModel"
            r5.d(r7, r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel.W0(com.dragon.read.kmp.viewmodel.RelationSeriesSingleViewModel, kotlin.jvm.functions.Function1, java.lang.String, gk4.f0):kotlin.Unit");
    }
}
