package com.dragon.read.kmp.shortvideo.distribution.page.viewmodel;

import androidx.compose.material.n2;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.lifecycle.ViewModel;
import co4.a;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.BookstoreTabType;
import com.bytedance.kmp.reading.model.SelectorDisplayStyle;
import com.bytedance.kmp.reading.model.VideoRanklistLandingPageStyle;
import com.bytedance.kmp.reading.model.a8;
import com.bytedance.kmp.reading.model.p90;
import com.bytedance.kmp.reading.model.v90;
import com.bytedance.kmp.reading.model.x7;
import com.bytedance.kmp.reading.model.xl;
import com.bytedance.kmp.reading.model.y7;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.basenovel.ui.ui.v0;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.i;
import com.dragon.read.kmp.shortvideo.distribution.infinite.f;
import com.dragon.read.kmp.shortvideo.distribution.infinite.g;
import com.dragon.read.kmp.shortvideo.distribution.infinite.h;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import com.dragon.read.kmp.utils.a1;
import com.dragon.read.kmp.utils.c0;
import com.dragon.read.kmp.utils.k0;
import com.dragon.read.kmp.utils.q0;
import eo4.j;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io4.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ym4.k;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesRankViewModel extends ViewModel {
    public static final int q;
    public final lo4.b a;
    private final Lazy b;
    public final j c;
    public final MutableState<ko4.b> d;
    public final List<io4.b> e;
    public final no4.a f;
    public MutableState<g> g;
    public MutableState<FilterType> h;
    public Disposable i;
    public MutableState<com.dragon.read.kmp.shortvideo.distribution.infinite.d> j;
    private final List<String> k;
    public n2 l;
    public final co4.a m;
    public int n;
    public CoroutineScope o;
    public final com.dragon.read.kmp.shortvideo.distribution.infinite.e p;

    static {
        Covode.recordClassIndex(609087);
        q = 8;
    }

    public final void Z0() {
    }

    public final void a1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i U0() {
        return new i("KmpSeriesRankViewModel");
    }

    private final void M0() {
        lo4.a aVar = this.a.k;
        if (aVar != null) {
            aVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i O0() {
        return (i) this.b.getValue();
    }

    public final boolean Q0() {
        lo4.a aVar = this.a.k;
        if (aVar != null) {
            return aVar.d();
        }
        return false;
    }

    public final boolean R0() {
        if (!((ko4.b) this.d.getValue()).b && !P0()) {
            return false;
        }
        return true;
    }

    private final boolean P0() {
        List<io4.b> list = this.e;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            if (!((io4.b) it2.next()).p.c.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final io4.b N0() {
        int i = this.n;
        if (this.e.isEmpty() || i < 0 || i >= this.e.size()) {
            return null;
        }
        return this.e.get(i);
    }

    public final void V0() {
        int i;
        O0().d("kmp page onCreate");
        Integer num = this.a.j;
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        if (i > 0 && S0(i)) {
            O0().d("use preload data success");
        } else {
            T0();
        }
    }

    public final void W0() {
        int intValue;
        M0();
        Disposable disposable = this.i;
        if (disposable != null) {
            q0.a(disposable);
        }
        Integer num = this.a.j;
        if (num != null && (intValue = num.intValue()) > 0) {
            gd4.c.a.b(intValue);
        }
        oo4.e.b.cancel();
        this.a.k = null;
    }

    public final void T0() {
        String str;
        String str2;
        String str3;
        lo4.b bVar = this.a;
        LoadStatus loadStatus = ((ko4.b) this.d.getValue()).a;
        LoadStatus loadStatus2 = LoadStatus.Loading;
        if (loadStatus != loadStatus2) {
            MutableState<ko4.b> mutableState = this.d;
            mutableState.setValue(ko4.b.b((ko4.b) mutableState.getValue(), loadStatus2, false, null, null, null, 0, 62, null));
        }
        String str4 = bVar.c;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        String str5 = bVar.d;
        String str6 = bVar.e;
        if (str6 == null) {
            str2 = "";
        } else {
            str2 = str6;
        }
        String str7 = bVar.f;
        if (str7 == null) {
            str3 = "";
        } else {
            str3 = str7;
        }
        d1(str, str5, str2, str3, bVar.b, bVar.a, bVar.c(), bVar.m, bVar.o);
    }

    public static final class b implements com.dragon.read.kmp.shortvideo.distribution.infinite.f {
        final /* synthetic */ io4.b b;

        @Override // com.dragon.read.kmp.shortvideo.distribution.infinite.f
        public void e(com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar) {
            f.a.e(this, dVar);
        }

        @Override // com.dragon.read.kmp.shortvideo.distribution.infinite.f
        public void d(com.dragon.read.kmp.shortvideo.distribution.infinite.d filterItem) {
            Intrinsics.checkNotNullParameter(filterItem, "filterItem");
            SeriesRankViewModel.this.j1(filterItem);
        }

        @Override // com.dragon.read.kmp.shortvideo.distribution.infinite.f
        public void c(com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar, FilterType filterType) {
            f.a.c(this, dVar, filterType);
        }

        b(io4.b bVar) {
            this.b = bVar;
        }

        @Override // com.dragon.read.kmp.shortvideo.distribution.infinite.f
        public void a(com.dragon.read.kmp.shortvideo.distribution.infinite.d filterItem, FilterType filterType) {
            String str;
            Intrinsics.checkNotNullParameter(filterItem, "filterItem");
            Intrinsics.checkNotNullParameter(filterType, "filterType");
            SeriesRankViewModel.this.j1(filterItem);
            SeriesRankViewModel seriesRankViewModel = SeriesRankViewModel.this;
            no4.a aVar = seriesRankViewModel.f;
            io4.b N0 = seriesRankViewModel.N0();
            if (N0 != null) {
                str = N0.f();
            } else {
                str = null;
            }
            p90 p90Var = filterItem.b;
            aVar.b(str, "confirm", p90Var.a, p90Var.b);
        }

        @Override // com.dragon.read.kmp.shortvideo.distribution.infinite.f
        public void b(boolean z, FilterType filterType) {
            String str;
            String str2;
            com.dragon.read.kmp.shortvideo.distribution.infinite.d g;
            p90 p90Var;
            com.dragon.read.kmp.shortvideo.distribution.infinite.d g2;
            p90 p90Var2;
            Intrinsics.checkNotNullParameter(filterType, "filterType");
            if (z) {
                g b = h.b(this.b.p, filterType);
                SeriesRankViewModel seriesRankViewModel = SeriesRankViewModel.this;
                no4.a aVar = seriesRankViewModel.f;
                io4.b N0 = seriesRankViewModel.N0();
                String str3 = null;
                if (N0 != null) {
                    str = N0.f();
                } else {
                    str = null;
                }
                if (b != null && (g2 = h.g(b)) != null && (p90Var2 = g2.b) != null) {
                    str2 = p90Var2.a;
                } else {
                    str2 = null;
                }
                if (b != null && (g = h.g(b)) != null && (p90Var = g.b) != null) {
                    str3 = p90Var.b;
                }
                aVar.b(str, "unfold", str2, str3);
            }
        }
    }

    public static final class a implements gd4.a<io4.e> {
        a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(io4.e data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.b != null && data.a) {
                SeriesRankViewModel.this.O0().d("preload data success");
                SeriesRankViewModel.this.X0(data.b);
            } else {
                SeriesRankViewModel.this.O0().d("preload data error");
                MutableState<ko4.b> mutableState = SeriesRankViewModel.this.d;
                mutableState.setValue(ko4.b.b((ko4.b) mutableState.getValue(), LoadStatus.Error, false, null, null, null, 0, 62, null));
            }
        }
    }

    public final void b1(io4.b bVar) {
        if (bVar == null) {
            return;
        }
        i1(bVar);
    }

    private final boolean S0(int i) {
        if (i <= 0) {
            return false;
        }
        return gd4.c.a.a(i, new a());
    }

    private final void c1(io4.b bVar) {
        lo4.a aVar;
        boolean z = false;
        if (bVar != null && io4.c.b(bVar)) {
            z = true;
        }
        if (z && (aVar = this.a.k) != null) {
            aVar.b(bVar);
        }
    }

    public final void k1(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        CoroutineScope coroutineScope = this.o;
        if (coroutineScope == null) {
            return;
        }
        kotlinx.coroutines.i.e(coroutineScope, null, null, new SeriesRankViewModel$updateSubscribeStatus$1(jsonString, null), 3, null);
    }

    public final void i1(io4.b distributeModel) {
        Intrinsics.checkNotNullParameter(distributeModel, "distributeModel");
        k0 k0Var = k0.a;
        k b2 = k0Var.b();
        ym4.a aVar = new ym4.a();
        aVar.g("list_name", distributeModel.c());
        aVar.g("parent_filter_tag_name", distributeModel.f());
        if (this.a.c()) {
            aVar.g("filter_position", "interact_topic_page");
            String str = this.a.g;
            if (str == null) {
                str = "video_cover";
            }
            aVar.g("interact_topic_page_entrance", str);
            aVar.g("interact_topic_name", distributeModel.f());
        } else {
            aVar.g("filter_position", "ranking_list_page");
        }
        b2.g(aVar);
        k0Var.d(b2.i());
    }

    public SeriesRankViewModel(lo4.b params) {
        Lazy lazy;
        List<String> listOf;
        Intrinsics.checkNotNullParameter(params, "params");
        this.a = params;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                i U0;
                U0 = SeriesRankViewModel.U0();
                return U0;
            }
        });
        this.b = lazy;
        this.c = new j();
        this.d = SnapshotStateKt.mutableStateOf$default(new ko4.b(null, false, null, null, null, 0, 63, null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.e = new ArrayList();
        this.f = new no4.a(params.k);
        this.g = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.h = SnapshotStateKt.mutableStateOf$default(FilterType.DEFAULT, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.j = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"ranklist_celebrity", "ranklist_series_actor", "ranklist_actor_fans", "female_actor_ranklist", "male_actor_ranklist"});
        this.k = listOf;
        this.m = new a.C0013a().e(9).b(true).d(6).c(true).a();
        this.p = new com.dragon.read.kmp.shortvideo.distribution.infinite.e() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel$iInfiniteHelperImpl$1
            @Override // com.dragon.read.kmp.shortvideo.distribution.infinite.e
            public void a(g infiniteFilterData, FilterType filterType) {
                String str;
                CoroutineScope coroutineScope;
                Intrinsics.checkNotNullParameter(infiniteFilterData, "infiniteFilterData");
                Intrinsics.checkNotNullParameter(filterType, "filterType");
                SeriesRankViewModel.this.g.setValue(infiniteFilterData);
                SeriesRankViewModel.this.h.setValue(filterType);
                SeriesRankViewModel seriesRankViewModel = SeriesRankViewModel.this;
                no4.a aVar = seriesRankViewModel.f;
                io4.b N0 = seriesRankViewModel.N0();
                if (N0 != null) {
                    str = N0.f();
                } else {
                    str = null;
                }
                no4.a.c(aVar, str, null, null, null, 14, null);
                if (bo4.h.a(infiniteFilterData, filterType) || (coroutineScope = SeriesRankViewModel.this.o) == null) {
                    return;
                }
                kotlinx.coroutines.i.e(coroutineScope, null, null, new SeriesRankViewModel$iInfiniteHelperImpl$1$showInfiniteDialog$1(SeriesRankViewModel.this, null), 3, null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar) {
        int i;
        boolean contains;
        ko4.a aVar;
        this.j.setValue(dVar);
        if (dVar == null) {
            return;
        }
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) ((ko4.b) this.d.getValue()).c);
        if (!mutableList.isEmpty() && (i = this.n) >= 0 && i < mutableList.size()) {
            contains = CollectionsKt___CollectionsKt.contains(this.k, dVar.b.b);
            if (contains) {
                aVar = new ko4.a(qg4.c.a(Theme.LIGHT).a1(), qg4.c.a(Theme.DARK).a1(), null);
            } else {
                aVar = new ko4.a(qg4.c.a(Theme.LIGHT).b(), qg4.c.a(Theme.DARK).b(), null);
            }
            mutableList.set(i, aVar);
            MutableState<ko4.b> mutableState = this.d;
            mutableState.setValue(ko4.b.b((ko4.b) mutableState.getValue(), null, false, mutableList, null, null, 0, 59, null));
        }
    }

    public final void Y0(int i) {
        String str;
        String str2;
        String str3;
        g gVar;
        int i2;
        MutableState<List<com.dragon.read.kmp.shortvideo.distribution.infinite.d>> mutableState;
        List list;
        Integer l;
        String str4;
        this.n = i;
        no4.a aVar = this.f;
        io4.b N0 = N0();
        com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar = null;
        if (N0 != null) {
            str = N0.f();
        } else {
            str = null;
        }
        io4.b N02 = N0();
        if (N02 != null) {
            str2 = N02.d();
        } else {
            str2 = null;
        }
        io4.b N03 = N0();
        if (N03 != null) {
            str3 = N03.c();
        } else {
            str3 = null;
        }
        aVar.e(str, str2, str3);
        if (this.a.c()) {
            no4.a aVar2 = this.f;
            io4.b N04 = N0();
            if (N04 != null) {
                str4 = N04.f();
            } else {
                str4 = null;
            }
            aVar2.f(str4, this.a.g);
        }
        b1(N0());
        io4.b N05 = N0();
        if (N05 != null) {
            gVar = N05.p;
        } else {
            gVar = null;
        }
        if (gVar != null && (l = gVar.l()) != null) {
            i2 = l.intValue();
        } else {
            i2 = 0;
        }
        if (gVar != null && (mutableState = gVar.a) != null && (list = (List) mutableState.getValue()) != null) {
            dVar = (com.dragon.read.kmp.shortvideo.distribution.infinite.d) CollectionsKt___CollectionsKt.getOrNull(list, i2);
        }
        j1(dVar);
        c1(N0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0(xl xlVar) {
        boolean z;
        int value;
        BookstoreTabType bookstoreTabType;
        String str;
        int value2;
        Integer num;
        boolean z2;
        v90 v90Var;
        List list;
        long j;
        String str2;
        String str3;
        boolean z3;
        int i;
        Integer num2;
        Boolean bool;
        boolean z4;
        Integer num3;
        v90 v90Var2;
        oo4.e.b.c();
        boolean c = this.a.c();
        List<x7> list2 = xlVar.c;
        if (list2 != null && !list2.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            O0().d("parseRankingFirstPageData error, cellDatas is null");
            MutableState<ko4.b> mutableState = this.d;
            mutableState.setValue(ko4.b.b((ko4.b) mutableState.getValue(), LoadStatus.Error, false, null, null, null, 0, 62, null));
            return;
        }
        x7 x7Var = (x7) CollectionsKt___CollectionsKt.getOrNull(list2, 0);
        if (x7Var == null) {
            O0().d("parseRankingFirstPageData error, cellData is null");
            MutableState<ko4.b> mutableState2 = this.d;
            mutableState2.setValue(ko4.b.b((ko4.b) mutableState2.getValue(), LoadStatus.Error, false, null, null, null, 0, 62, null));
            return;
        }
        po4.a aVar = po4.a.a;
        if (c) {
            value = BookstoreTabType.video_topic_landpage.getValue();
        } else {
            value = BookstoreTabType.ranklist_landpage.getValue();
        }
        List<v0> b2 = aVar.b(list2, value);
        if (this.a.c()) {
            bookstoreTabType = BookstoreTabType.video_topic_landpage;
        } else {
            bookstoreTabType = BookstoreTabType.ranklist_landpage;
        }
        int value3 = bookstoreTabType.getValue();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        y7 y7Var = x7Var.U1;
        if (y7Var != null && (v90Var2 = y7Var.a) != null) {
            str = v90Var2.getType();
        } else {
            str = null;
        }
        y7 y7Var2 = x7Var.U1;
        if (y7Var2 != null && (num3 = y7Var2.o) != null) {
            value2 = num3.intValue();
        } else {
            value2 = SelectorDisplayStyle.Default.getValue();
        }
        int i2 = value2;
        y7 y7Var3 = x7Var.U1;
        if (y7Var3 != null && (v90Var = y7Var3.a) != null && (list = v90Var.a) != null) {
            Iterator it2 = list.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                Object next = it2.next();
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                p90 p90Var = (p90) next;
                Long l = x7Var.a;
                if (l != null) {
                    j = l.longValue();
                } else {
                    j = 0;
                }
                Iterator it4 = it2;
                long j2 = j;
                String str4 = x7Var.I2;
                if (str4 == null) {
                    str4 = "";
                }
                b.a aVar2 = new b.a(j2, str4);
                String str5 = p90Var.b;
                if (str5 == null) {
                    str5 = "";
                }
                aVar2.d(str5);
                aVar2.g = value3;
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                aVar2.h = str2;
                String str6 = p90Var.a;
                if (str6 == null) {
                    str6 = "";
                }
                aVar2.i = str6;
                aVar2.j = p90Var.h;
                String str7 = this.a.m;
                if (str7 == null) {
                    str7 = "";
                }
                aVar2.b(str7);
                io4.b bVar = new io4.b(p90Var, aVar2);
                if (str == null) {
                    str3 = "";
                } else {
                    str3 = str;
                }
                bVar.h(str3);
                bVar.n = i2;
                String str8 = this.a.o;
                if (str8 != null) {
                    if (str8.length() > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        str8 = null;
                    }
                    if (str8 != null) {
                        bVar.i(str8);
                    }
                }
                Boolean bool2 = p90Var.c;
                Boolean bool3 = Boolean.TRUE;
                if (Intrinsics.areEqual(bool2, bool3) && (bool = x7Var.o2) != null) {
                    z3 = bool.booleanValue();
                } else {
                    z3 = false;
                }
                bVar.h = z3;
                if (Intrinsics.areEqual(p90Var.c, bool3) && (num2 = x7Var.n2) != null) {
                    i = num2.intValue();
                } else {
                    i = 0;
                }
                bVar.i = i;
                if (Intrinsics.areEqual(p90Var.c, bool3)) {
                    List<x7> list3 = bVar.d;
                    List list4 = x7Var.u;
                    if (list4 == null) {
                        list4 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    list3.addAll(list4);
                    bVar.f = x7Var.E3;
                    bVar.e = x7Var.D3;
                    bVar.g = x7Var.U1;
                    bVar.c.addAll(b2);
                    this.n = i3;
                    bVar.l = true;
                }
                if (Intrinsics.areEqual(p90Var.c, bool3) && this.a.b()) {
                    bVar.o = true;
                }
                if (Intrinsics.areEqual(p90Var.b, "ranklist_celebrity") && !po4.b.g(bVar)) {
                    arrayList2.add(new ko4.a(qg4.c.a(Theme.LIGHT).a1(), qg4.c.a(Theme.DARK).a1(), null));
                } else {
                    arrayList2.add(new ko4.a(qg4.c.a(Theme.LIGHT).b(), qg4.c.a(Theme.DARK).b(), null));
                }
                bVar.p.o(new b(bVar));
                arrayList.add(bVar);
                i3 = i4;
                it2 = it4;
            }
        }
        if (arrayList.isEmpty()) {
            O0().d("parseRankingFirstPageData error, tabItemList is null");
            MutableState<ko4.b> mutableState3 = this.d;
            mutableState3.setValue(ko4.b.b((ko4.b) mutableState3.getValue(), LoadStatus.Error, false, null, null, null, 0, 62, null));
            return;
        }
        this.e.clear();
        this.e.addAll(arrayList);
        a8 a8Var = x7Var.o0;
        if (a8Var != null) {
            num = a8Var.r0;
        } else {
            num = null;
        }
        VideoRanklistLandingPageStyle a2 = bo4.b.a(num);
        MutableState<ko4.b> mutableState4 = this.d;
        ko4.b bVar2 = (ko4.b) mutableState4.getValue();
        LoadStatus loadStatus = LoadStatus.Content;
        String str9 = x7Var.c0;
        if (a2 == VideoRanklistLandingPageStyle.RankListTopBarStyle) {
            z2 = true;
        } else {
            z2 = false;
        }
        mutableState4.setValue(ko4.b.b(bVar2, loadStatus, z2, arrayList2, str9, null, i2, 16, null));
        c1(N0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(String str, String str2, String str3, String str4, long j, SeriesRankViewModel seriesRankViewModel, xl xlVar) {
        int i;
        x7 x7Var;
        List list;
        oo4.g gVar = oo4.g.a;
        List list2 = xlVar.c;
        if (!c0.a(list2)) {
            list2 = null;
        }
        if (list2 != null && (x7Var = (x7) list2.get(0)) != null && (list = x7Var.u) != null) {
            i = list.size();
        } else {
            i = 0;
        }
        gVar.a(false, str, str2, str3, str4, j, null, null, null, i, true);
        Intrinsics.checkNotNull(xlVar);
        seriesRankViewModel.X0(xlVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(SeriesRankViewModel seriesRankViewModel, String str, String str2, String str3, String str4, long j, Throwable th) {
        i.c(seriesRankViewModel.O0(), "requestFirstPageData error, it=" + th, (Throwable) null, 2, (Object) null);
        oo4.g.a.a(false, str, str2, str3, str4, j, null, th, Integer.valueOf(po4.b.c(th)), 0, true);
        MutableState<ko4.b> mutableState = seriesRankViewModel.d;
        mutableState.setValue(ko4.b.b((ko4.b) mutableState.getValue(), LoadStatus.Error, false, null, null, null, 0, 62, null));
        oo4.e.b.cancel();
        return Unit.INSTANCE;
    }

    public final void d1(final String selectedItems, final String str, final String str2, final String str3, String str4, String str5, boolean z, String str6, String str7) {
        String str8;
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        O0().d("requestFirstPageData, selectedItems=" + selectedItems + ", subSelectedItems=" + str + ", panelSelectedItems=" + str2 + ", backgroundSelectedItems=" + str3 + ", stickIds=" + str4 + ", sessionId=" + str5 + ", isTopic=" + z + ", celebrityUserId=" + str6 + ", rankVersion=" + str7);
        oo4.e eVar = oo4.e.b;
        if (z) {
            str8 = "topic";
        } else {
            str8 = "ranking";
        }
        eVar.a(str8);
        final long n = a1.n(a1.a, null, null, 3, null);
        Observable<xl> e = this.c.e(selectedItems, str, str2, str3, str4, str5, z, str6, str7);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable<xl> observeOn = e.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g1;
                g1 = SeriesRankViewModel.g1(selectedItems, str, str2, str3, n, this, (xl) obj);
                return g1;
            }
        };
        Consumer<? super xl> consumer = new Consumer() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesRankViewModel.h1(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e1;
                e1 = SeriesRankViewModel.e1(SeriesRankViewModel.this, selectedItems, str, str2, str3, n, (Throwable) obj);
                return e1;
            }
        };
        this.i = observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesRankViewModel.f1(Function1.this, obj);
            }
        });
    }
}
