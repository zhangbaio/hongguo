package com.dragon.read.kmp.mine.search.view;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SearchSource;
import com.bytedance.kmp.reading.model.SearchTabType;
import com.bytedance.kmp.reading.model.nn;
import com.bytedance.kmp.reading.model.on;
import com.bytedance.kmp.reading.model.s80;
import com.bytedance.kmp.reading.rpc.BookApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.utils.StringUtilsKt;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MineSearchPageViewModel extends ViewModel {
    public static final a k;
    public static final int l;
    public final q a;
    public int b;
    public Disposable c;
    public final List<b0> d;
    public final Map<Integer, hn4.e> e;
    public int f;
    public final MutableState<UiState> g;
    public final MutableState<String> h;
    public List<? extends com.dragon.read.kmp.mine.data.b> i;
    private Job j;

    public static final class a {
        static {
            Covode.recordClassIndex(607775);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607774);
        k = new a(null);
        l = 8;
    }

    public final void N0() {
        qf3.a.g.a();
    }

    public final void J0() {
        Job job = this.j;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.j = null;
    }

    public final void K0() {
        b bVar = this.a.b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void P0(int i) {
        b0 b0Var = (b0) CollectionsKt___CollectionsKt.getOrNull(this.d, i);
        if (b0Var != null) {
            b0Var.d = false;
        }
    }

    public final boolean L0(int i) {
        b0 b0Var = (b0) CollectionsKt___CollectionsKt.getOrNull(this.d, i);
        boolean z = false;
        if (b0Var != null && !b0Var.d) {
            z = true;
        }
        return !z;
    }

    public final void M0(CoroutineScope scope) {
        Job e;
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (this.i != null) {
            return;
        }
        if (this.j != null) {
            J0();
        }
        e = kotlinx.coroutines.i.e(scope, Dispatchers.getIO(), null, new MineSearchPageViewModel$loadLocalHistoryDataAsync$2(this, null), 2, null);
        this.j = e;
    }

    public final void O0(int i) {
        int value;
        hn4.d dVar;
        hn4.a aVar;
        this.f = i;
        hn4.e eVar = this.e.get(Integer.valueOf(i));
        if (eVar != null && (aVar = eVar.a) != null) {
            aVar.onResume();
        }
        b0 b0Var = (b0) CollectionsKt___CollectionsKt.getOrNull(this.d, i);
        if (b0Var != null && (dVar = b0Var.b) != null) {
            value = dVar.a;
        } else {
            value = SearchTabType.MyHistory.getValue();
        }
        this.b = value;
    }

    public MineSearchPageViewModel(q params) {
        String d;
        Intrinsics.checkNotNullParameter(params, "params");
        this.a = params;
        SearchTabType searchTabType = params.c;
        this.b = (searchTabType == null ? SearchTabType.MyHistory : searchTabType).getValue();
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
        this.g = SnapshotStateKt.mutableStateOf$default(UiState.Init, (SnapshotMutationPolicy) null, 2, (Object) null);
        StringBuilder sb = new StringBuilder();
        sb.append("搜索我的");
        List<String> list = params.d;
        sb.append((list == null || (d = z0.b.d(list, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null) ? "历史/收藏/点赞/动态" : d);
        this.h = SnapshotStateKt.mutableStateOf$default(sb.toString(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final void Q0(String searchText) {
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        Disposable disposable = this.c;
        boolean z = false;
        if (disposable != null && !disposable.isDisposed()) {
            z = true;
        }
        if (z) {
            return;
        }
        nn nnVar = new nn(searchText, (Long) null, (String) null, (String) null, (Boolean) null, Integer.valueOf(this.b), (String) null, (Integer) null, Integer.valueOf(SearchSource.HgMyTab.getValue()), "clks_mine###", (String) null, (Short) null, (Integer) null, (String) null, (Integer) null, (Boolean) null, (Long) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Long) null, (String) null, (Long) null, (Boolean) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Long) null, (String) null, (Boolean) null, (Long) null, (String) null, -802, 262143, (DefaultConstructorMarker) null);
        qf3.a.g.e();
        this.d.clear();
        this.e.clear();
        this.g.setValue(UiState.Loading);
        Observable A = BookApiService.A(BookApiService.a, nnVar, (zn0.g) null, 2, (Object) null);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = A.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.mine.search.view.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = MineSearchPageViewModel.R0(MineSearchPageViewModel.this, (on) obj);
                return R0;
            }
        };
        Consumer consumer = new Consumer() { // from class: com.dragon.read.kmp.mine.search.view.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MineSearchPageViewModel.S0(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.mine.search.view.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit T0;
                T0 = MineSearchPageViewModel.T0(MineSearchPageViewModel.this, (Throwable) obj);
                return T0;
            }
        };
        this.c = observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.mine.search.view.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MineSearchPageViewModel.U0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(MineSearchPageViewModel mineSearchPageViewModel, Throwable th) {
        qf3.a.g.d();
        com.dragon.read.kmp.j.a.b("MineSearchPageViewModel", "getSearchTabRx error", th);
        mineSearchPageViewModel.g.setValue(UiState.Error);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(MineSearchPageViewModel mineSearchPageViewModel, on onVar) {
        boolean z;
        String str;
        boolean z2;
        int i;
        int value;
        String str2;
        String str3;
        String str4;
        String str5;
        List<s80> list = onVar.c;
        boolean z3 = true;
        int i2 = 0;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            mineSearchPageViewModel.g.setValue(UiState.Empty);
            qf3.a.g.d();
            return Unit.INSTANCE;
        }
        qf3.a.g.b();
        String str6 = null;
        String str7 = null;
        for (s80 s80Var : list) {
            if (StringUtilsKt.a(s80Var.i)) {
                str7 = s80Var.i;
            }
            List<b0> list2 = mineSearchPageViewModel.d;
            Integer num = s80Var.E;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            Integer num2 = s80Var.a;
            if (num2 != null) {
                value = num2.intValue();
            } else {
                value = SearchTabType.MyHistory.getValue();
            }
            int i3 = value;
            String str8 = s80Var.b;
            String str9 = "";
            if (str8 == null) {
                str2 = "";
            } else {
                str2 = str8;
            }
            String str10 = s80Var.i;
            if (str10 == null) {
                str3 = "";
            } else {
                str3 = str10;
            }
            String str11 = s80Var.g;
            if (str11 == null) {
                str4 = "";
            } else {
                str4 = str11;
            }
            String str12 = s80Var.h;
            if (str12 == null) {
                str5 = "";
            } else {
                str5 = str12;
            }
            hn4.d dVar = new hn4.d(i3, str2, str3, str5, str4, null, null);
            dVar.f = SearchSource.HgMyTab.getValue();
            dVar.n = "clks_mine###";
            String str13 = mineSearchPageViewModel.a.e;
            if (str13 != null) {
                str9 = str13;
            }
            dVar.c(str9);
            Unit unit = Unit.INSTANCE;
            list2.add(new b0(i, dVar, s80Var, false, 8, null));
        }
        Iterator<b0> it2 = mineSearchPageViewModel.d.iterator();
        int i4 = 0;
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().b.a == mineSearchPageViewModel.b) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        Integer valueOf = Integer.valueOf(i4);
        if (valueOf.intValue() == -1) {
            z3 = false;
        }
        if (!z3) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        }
        mineSearchPageViewModel.f = i2;
        s80 s80Var2 = (s80) CollectionsKt___CollectionsKt.getOrNull(list, i2);
        if (s80Var2 != null && (str = s80Var2.h) != null) {
            str6 = str;
        }
        mineSearchPageViewModel.g.setValue(UiState.Success);
        com.dragon.read.kmp.j.a.d("MineSearchPageViewModel", "currentSearchTabs size = " + mineSearchPageViewModel.d.size());
        dk4.a.a.a(str7, str6);
        return Unit.INSTANCE;
    }
}
