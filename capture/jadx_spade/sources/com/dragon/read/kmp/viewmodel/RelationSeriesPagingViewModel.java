package com.dragon.read.kmp.viewmodel;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState;
import gk4.f0;
import gk4.g0;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class RelationSeriesPagingViewModel extends o {
    public static final a o;
    public static final int p;
    private Disposable j;
    private Disposable k;
    private final MutableState l;
    private final MutableState m;
    public final com.dragon.read.kmp.basenovel.ui.ui.a n;

    public static final class a {
        static {
            Covode.recordClassIndex(609597);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609596);
        o = new a(null);
        p = 8;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class FirstLoadState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FirstLoadState[] $VALUES;
        public static final FirstLoadState FAIL;
        public static final FirstLoadState LOADING;
        public static final FirstLoadState SUCCESS;

        private static final /* synthetic */ FirstLoadState[] $values() {
            return new FirstLoadState[]{LOADING, SUCCESS, FAIL};
        }

        public static EnumEntries<FirstLoadState> getEntries() {
            return $ENTRIES;
        }

        public static FirstLoadState[] values() {
            return (FirstLoadState[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(609598);
            LOADING = new FirstLoadState("LOADING", 0);
            SUCCESS = new FirstLoadState("SUCCESS", 1);
            FAIL = new FirstLoadState("FAIL", 2);
            FirstLoadState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static FirstLoadState valueOf(String str) {
            return (FirstLoadState) Enum.valueOf(FirstLoadState.class, str);
        }

        private FirstLoadState(String str, int i) {
        }
    }

    public static final class b extends com.dragon.read.kmp.basenovel.ui.ui.a {
        public boolean c() {
            f0 f0Var = RelationSeriesPagingViewModel.this.b;
            if (f0Var == null || !f0Var.a()) {
                return false;
            }
            return true;
        }

        public void f() {
            if (!c()) {
                com.dragon.read.kmp.j.a.d("RelationSeriesPagingViewModel", "[adapter] no more data");
                j();
                return;
            }
            k();
            g0 E0 = RelationSeriesPagingViewModel.this.E0();
            if (E0 != null) {
                RelationSeriesPagingViewModel.this.c1(E0);
            }
        }

        b() {
        }
    }

    public final String G() {
        return (String) this.m.getValue();
    }

    public final FirstLoadState X0() {
        return (FirstLoadState) this.l.getValue();
    }

    @Override // com.dragon.read.kmp.viewmodel.o, xm4.b
    public void refresh() {
        super.refresh();
        k1(FirstLoadState.LOADING);
        j1("");
    }

    @Override // com.dragon.read.kmp.viewmodel.o
    protected void onCleared() {
        super.onCleared();
        this.n.e();
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.k;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }

    public final void j1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.m.setValue(str);
    }

    public final void k1(FirstLoadState firstLoadState) {
        Intrinsics.checkNotNullParameter(firstLoadState, "<set-?>");
        this.l.setValue(firstLoadState);
    }

    public final void i1(g0 params) {
        Intrinsics.checkNotNullParameter(params, "params");
        k1(FirstLoadState.LOADING);
        o.K0(this, params, null, null, 6, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelationSeriesPagingViewModel(xm4.a iDepend) {
        super(iDepend);
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        this.l = SnapshotStateKt.mutableStateOf$default(FirstLoadState.LOADING, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.m = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.n = new b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
    
        if (r4.intValue() != r6) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void h1(java.util.List<gk4.h0> r8) {
        /*
            r7 = this;
            xk4.i r0 = xk4.i.a
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r8 = r8.iterator()
        Lb:
            boolean r2 = r8.hasNext()
            r3 = 1
            if (r2 == 0) goto L39
            java.lang.Object r2 = r8.next()
            r4 = r2
            gk4.h0 r4 = (gk4.h0) r4
            jd4.c r4 = r4.c
            com.bytedance.kmp.reading.model.om0 r4 = r4.b
            r5 = 0
            if (r4 == 0) goto L32
            java.lang.Integer r4 = r4.y
            com.bytedance.kmp.reading.model.VideoContentType r6 = com.bytedance.kmp.reading.model.VideoContentType.ShortSeriesPlay
            int r6 = r6.getValue()
            if (r4 != 0) goto L2b
            goto L32
        L2b:
            int r4 = r4.intValue()
            if (r4 != r6) goto L32
            goto L33
        L32:
            r3 = 0
        L33:
            if (r3 == 0) goto Lb
            r1.add(r2)
            goto Lb
        L39:
            java.util.ArrayList r8 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r2)
            r8.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L48:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L5a
            java.lang.Object r2 = r1.next()
            gk4.h0 r2 = (gk4.h0) r2
            java.lang.String r2 = r2.d
            r8.add(r2)
            goto L48
        L5a:
            r1 = 9
            r0.b(r8, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.viewmodel.RelationSeriesPagingViewModel.h1(java.util.List):void");
    }

    public void c1(final g0 params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (!this.n.c()) {
            com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "RelationSeriesPagingViewModel", "[loadMore] no more data", (Throwable) null, 4, (Object) null);
            this.n.j();
            return;
        }
        com.dragon.read.kmp.j.a.d("RelationSeriesPagingViewModel", "[loadMore] start");
        this.n.k();
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<f0> j = xk4.g.a.j(params);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable<f0> observeOn = j.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.viewmodel.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d1;
                d1 = RelationSeriesPagingViewModel.d1(g0.this, this, (f0) obj);
                return d1;
            }
        };
        Consumer<? super f0> consumer = new Consumer() { // from class: com.dragon.read.kmp.viewmodel.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RelationSeriesPagingViewModel.e1(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.viewmodel.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f1;
                f1 = RelationSeriesPagingViewModel.f1(g0.this, this, (Throwable) obj);
                return f1;
            }
        };
        this.k = observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.viewmodel.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RelationSeriesPagingViewModel.g1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(String str, RelationSeriesPagingViewModel relationSeriesPagingViewModel, Throwable th) {
        com.dragon.read.kmp.j.a.d("RelationSeriesPagingViewModel", "[loadData] seriesId:" + str + " preload error： " + th);
        relationSeriesPagingViewModel.k1(FirstLoadState.FAIL);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(g0 g0Var, RelationSeriesPagingViewModel relationSeriesPagingViewModel, Throwable th) {
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "RelationSeriesPagingViewModel", "[loadMore] seriesId:" + g0Var.b + " error:" + th, (Throwable) null, 4, (Object) null);
        relationSeriesPagingViewModel.n.i();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(g0 g0Var, RelationSeriesPagingViewModel relationSeriesPagingViewModel, f0 f0Var) {
        com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
        jVar.d("RelationSeriesPagingViewModel", "[loadMore] seriesId:" + g0Var.b + " success, append " + f0Var.c.size() + " items");
        relationSeriesPagingViewModel.b = xk4.g.a.h(g0Var.b);
        relationSeriesPagingViewModel.O0(f0Var.c);
        relationSeriesPagingViewModel.n.a(f0Var.c);
        if (!relationSeriesPagingViewModel.n.c()) {
            jVar.d("RelationSeriesPagingViewModel", "[loadMore] no next page data");
            relationSeriesPagingViewModel.n.l(FootLoadingState.NOT_MORE);
        } else {
            jVar.d("RelationSeriesPagingViewModel", "[loadMore] has next page data");
            relationSeriesPagingViewModel.n.l(FootLoadingState.GONE);
        }
        relationSeriesPagingViewModel.h1(f0Var.c);
        return Unit.INSTANCE;
    }

    @Override // com.dragon.read.kmp.viewmodel.o
    public void J0(final g0 params, Function1<? super f0, Unit> function1, Function1<? super Throwable, Unit> function12) {
        Intrinsics.checkNotNullParameter(params, "params");
        final String str = params.b;
        com.dragon.read.kmp.j.a.d("RelationSeriesPagingViewModel", "[loadData] start, seriesId:" + str);
        this.n.l(FootLoadingState.GONE);
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        BehaviorSubject<f0> n = xk4.g.a.n(params);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable<f0> observeOn = n.observeOn(mainThread);
        final Function1 function13 = new Function1() { // from class: com.dragon.read.kmp.viewmodel.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Y0;
                Y0 = RelationSeriesPagingViewModel.Y0(str, this, params, (f0) obj);
                return Y0;
            }
        };
        Consumer<? super f0> consumer = new Consumer() { // from class: com.dragon.read.kmp.viewmodel.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RelationSeriesPagingViewModel.Z0(Function1.this, obj);
            }
        };
        final Function1 function14 = new Function1() { // from class: com.dragon.read.kmp.viewmodel.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit a1;
                a1 = RelationSeriesPagingViewModel.a1(str, this, (Throwable) obj);
                return a1;
            }
        };
        this.j = observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.viewmodel.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RelationSeriesPagingViewModel.b1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(String str, RelationSeriesPagingViewModel relationSeriesPagingViewModel, g0 g0Var, f0 f0Var) {
        boolean z;
        com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
        jVar.d("RelationSeriesPagingViewModel", "[loadData] seriesId:" + str + " preload success, itemCount=" + f0Var.c.size());
        Disposable disposable = relationSeriesPagingViewModel.j;
        if (disposable != null) {
            disposable.dispose();
        }
        relationSeriesPagingViewModel.k1(FirstLoadState.SUCCESS);
        String str2 = f0Var.e;
        if (str2 != null && str2.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            relationSeriesPagingViewModel.j1("更多相关好剧");
        } else {
            String str3 = f0Var.e;
            Intrinsics.checkNotNull(str3);
            relationSeriesPagingViewModel.j1(str3);
        }
        relationSeriesPagingViewModel.b = xk4.g.a.h(g0Var.b);
        relationSeriesPagingViewModel.n.b(f0Var.c, true);
        if (!relationSeriesPagingViewModel.n.c()) {
            jVar.d("RelationSeriesPagingViewModel", "[loadData] no next page data");
            relationSeriesPagingViewModel.n.l(FootLoadingState.GONE);
        } else {
            jVar.d("RelationSeriesPagingViewModel", "[loadData] has next page data");
            relationSeriesPagingViewModel.n.l(FootLoadingState.GONE);
        }
        relationSeriesPagingViewModel.N0(f0Var.c);
        relationSeriesPagingViewModel.h1(f0Var.c);
        return Unit.INSTANCE;
    }
}
