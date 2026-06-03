package com.dragon.read.kmp.shortvideo.distribution.page.search;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.g80;
import com.bytedance.kmp.reading.model.h80;
import com.bytedance.kmp.reading.rpc.ActivityApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.utils.q0;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.Job;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesRankSearchViewModel extends ViewModel {
    public static final a h;
    public static final int i;
    private final d0 a;
    public final MutableState<SeriesRankSearchUiState> b;
    public final MutableState<List<io4.a>> c;
    public final MutableState<Integer> d;
    public String e;
    private Disposable f;
    private Job g;

    public static final class a {
        static {
            Covode.recordClassIndex(609070);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609069);
        h = new a(null);
        i = 8;
    }

    public final void P0() {
        if (StringsKt__StringsKt.isBlank(this.e)) {
            this.b.setValue(SeriesRankSearchUiState.Ready);
        } else {
            this.b.setValue(SeriesRankSearchUiState.Loading);
            J0(this.e);
        }
    }

    protected void onCleared() {
        super.onCleared();
        Job job = this.g;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        q0.a(this.f);
    }

    public SeriesRankSearchViewModel(d0 params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.a = params;
        this.b = SnapshotStateKt.mutableStateOf$default(SeriesRankSearchUiState.Ready, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.c = SnapshotStateKt.mutableStateOf$default(CollectionsKt__CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.d = SnapshotStateKt.mutableStateOf$default(-1, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.e = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(final String str) {
        g80 g80Var = new g80((String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Long) null, (Long) null, 127, (DefaultConstructorMarker) null);
        g80Var.a = "hongguo_actor_fans_ranklist_activity";
        g80Var.c = str;
        g80Var.b = "hongguo_actor_fans_ranklist";
        q0.a(this.f);
        Observable b = ActivityApiService.b(ActivityApiService.a, g80Var, (zn0.g) null, 2, (Object) null);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = b.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K0;
                K0 = SeriesRankSearchViewModel.K0(SeriesRankSearchViewModel.this, str, (h80) obj);
                return K0;
            }
        };
        Consumer consumer = new Consumer() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.f0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesRankSearchViewModel.L0(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit M0;
                M0 = SeriesRankSearchViewModel.M0(str, this, (Throwable) obj);
                return M0;
            }
        };
        this.f = observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.search.h0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesRankSearchViewModel.N0(Function1.this, obj);
            }
        });
    }

    public final void O0(String input) {
        Job e;
        Intrinsics.checkNotNullParameter(input, "input");
        Job job = this.g;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (StringsKt__StringsKt.isBlank(input)) {
            q0.a(this.f);
            this.c.setValue(CollectionsKt__CollectionsKt.emptyList());
            this.d.setValue(-1);
            this.b.setValue(SeriesRankSearchUiState.Ready);
            this.e = "";
            return;
        }
        String obj = StringsKt__StringsKt.trim((CharSequence) input).toString();
        this.e = obj;
        this.b.setValue(SeriesRankSearchUiState.Loading);
        e = kotlinx.coroutines.i.e(ViewModelKt.getViewModelScope(this), null, null, new SeriesRankSearchViewModel$onInputChange$1(this, obj, null), 3, null);
        this.g = e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(String str, SeriesRankSearchViewModel seriesRankSearchViewModel, Throwable th) {
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SeriesRankSearchViewModel", "search error keyword=" + str + ", " + th.getMessage(), (Throwable) null, 4, (Object) null);
        seriesRankSearchViewModel.b.setValue(SeriesRankSearchUiState.Error);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit K0(com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchViewModel r7, java.lang.String r8, com.bytedance.kmp.reading.model.h80 r9) {
        /*
            com.bytedance.kmp.reading.model.f80 r9 = r9.b
            r0 = 0
            if (r9 == 0) goto L8
            java.util.List r9 = r9.a
            goto L9
        L8:
            r9 = r0
        L9:
            if (r9 != 0) goto Lf
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
        Lf:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r9 = r9.iterator()
        L18:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L45
            java.lang.Object r2 = r9.next()
            com.bytedance.kmp.reading.model.t20 r2 = (com.bytedance.kmp.reading.model.t20) r2
            com.bytedance.kmp.reading.model.bj0 r3 = r2.e
            if (r3 == 0) goto L3e
            io4.a r4 = new io4.a
            r4.<init>(r3)
            com.bytedance.kmp.reading.model.s20 r2 = r2.a
            if (r2 == 0) goto L38
            com.bytedance.kmp.reading.model.z70 r2 = r2.g
            if (r2 == 0) goto L38
            java.util.List r2 = r2.b
            goto L39
        L38:
            r2 = r0
        L39:
            r4.f = r2
            r4.g = r8
            goto L3f
        L3e:
            r4 = r0
        L3f:
            if (r4 == 0) goto L18
            r1.add(r4)
            goto L18
        L45:
            boolean r9 = r1.isEmpty()
            r0 = -1
            if (r9 == 0) goto L66
            androidx.compose.runtime.MutableState<java.util.List<io4.a>> r9 = r7.c
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            r9.setValue(r2)
            androidx.compose.runtime.MutableState<java.lang.Integer> r9 = r7.d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setValue(r0)
            androidx.compose.runtime.MutableState<com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchUiState> r7 = r7.b
            com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchUiState r9 = com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchUiState.Empty
            r7.setValue(r9)
            goto Lb1
        L66:
            androidx.compose.runtime.MutableState<java.util.List<io4.a>> r9 = r7.c
            r9.setValue(r1)
            androidx.compose.runtime.MutableState<java.lang.Integer> r9 = r7.d
            java.util.Iterator r2 = r1.iterator()
            r3 = 0
            r4 = 0
        L73:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto La3
            java.lang.Object r5 = r2.next()
            io4.a r5 = (io4.a) r5
            com.bytedance.kmp.reading.model.bj0 r5 = r5.a
            com.bytedance.kmp.reading.model.q20 r5 = r5.f
            if (r5 == 0) goto L94
            java.lang.String r5 = r5.c
            if (r5 == 0) goto L94
            java.lang.Integer r5 = kotlin.text.StringsKt.toIntOrNull(r5)
            if (r5 == 0) goto L94
            int r5 = r5.intValue()
            goto L95
        L94:
            r5 = 0
        L95:
            r6 = 50
            if (r5 <= r6) goto L9b
            r5 = 1
            goto L9c
        L9b:
            r5 = 0
        L9c:
            if (r5 == 0) goto La0
            r0 = r4
            goto La3
        La0:
            int r4 = r4 + 1
            goto L73
        La3:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.setValue(r0)
            androidx.compose.runtime.MutableState<com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchUiState> r7 = r7.b
            com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchUiState r9 = com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchUiState.Data
            r7.setValue(r9)
        Lb1:
            com.dragon.read.kmp.j r7 = com.dragon.read.kmp.j.a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "search success keyword="
            r9.append(r0)
            r9.append(r8)
            java.lang.String r8 = " size="
            r9.append(r8)
            int r8 = r1.size()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "SeriesRankSearchViewModel"
            r7.d(r9, r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchViewModel.K0(com.dragon.read.kmp.shortvideo.distribution.page.search.SeriesRankSearchViewModel, java.lang.String, com.bytedance.kmp.reading.model.h80):kotlin.Unit");
    }
}
