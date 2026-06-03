package com.dragon.read.kmp.shortvideo.distribution.page.tab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UserRelationType;
import com.bytedance.kmp.reading.model.bj0;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.p90;
import com.bytedance.kmp.reading.model.vd0;
import com.bytedance.kmp.reading.model.x7;
import com.bytedance.kmp.reading.model.y7;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.shortvideo.distribution.infinite.f;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import com.dragon.read.kmp.utils.a1;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io4.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesRankTabViewModel {
    public static final a F;
    public static final int G;
    public LazyListState A;
    public final com.dragon.read.kmp.shortvideo.distribution.infinite.f B;
    public com.dragon.read.kmp.shortvideo.distribution.infinite.e C;
    private final c D;
    private final Job E;
    public final int a;
    public final io4.b b;
    public final co4.a c;
    public final lo4.a d;
    public LazyListState e;
    public final com.dragon.read.kmp.shortvideo.distribution.page.tab.b f;
    private Disposable g;
    private Disposable h;
    public final MutableState<com.dragon.read.kmp.shortvideo.distribution.page.tab.a> i;
    public final MutableState<List<io4.f>> j;
    private Disposable k;
    public final MutableState<bj0> l;
    public final MutableState<String> m;
    public final MutableState<Boolean> n;
    private boolean o;
    public final eo4.f p;
    private final oo4.c q;
    public CoroutineScope r;
    public boolean s;
    public final no4.b t;
    public final Set<String> u;
    public final Set<String> v;
    public final MutableState<Integer> w;
    private boolean x;
    private boolean y;
    private boolean z;

    public static final class a {
        static {
            Covode.recordClassIndex(609078);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(609079);
            int[] iArr = new int[FilterType.values().length];
            try {
                iArr[FilterType.PANEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FilterType.BACKGROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(609077);
        F = new a(null);
        G = 8;
    }

    public final void n0(io4.f item, int i) {
        Intrinsics.checkNotNullParameter(item, "item");
    }

    public final com.dragon.read.kmp.shortvideo.distribution.infinite.g y() {
        return this.b.p;
    }

    public final void U() {
        com.dragon.read.kmp.shortvideo.distribution.page.search.b.a.a(new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.h0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit V;
                V = SeriesRankTabViewModel.V(SeriesRankTabViewModel.this, (io4.a) obj, ((Integer) obj2).intValue());
                return V;
            }
        }, new Function2() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.i0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit W;
                W = SeriesRankTabViewModel.W(SeriesRankTabViewModel.this, (io4.a) obj, ((Integer) obj2).intValue());
                return W;
            }
        });
    }

    public final String x() {
        if (B()) {
            return "starring_actor_ranking_list_page";
        }
        return "actor_ranking_list_page";
    }

    private final void A0() {
        bj0 bj0Var;
        MutableState<bj0> mutableState = this.l;
        if (B()) {
            bj0Var = this.b.e;
        } else {
            bj0Var = null;
        }
        mutableState.setValue(bj0Var);
    }

    private final void t0() {
        lo4.a aVar;
        if (io4.c.b(this.b) && (aVar = this.d) != null) {
            aVar.b(this.b);
        }
    }

    private final void u0() {
        CoroutineScope coroutineScope = this.r;
        if (coroutineScope == null) {
            return;
        }
        kotlinx.coroutines.i.e(coroutineScope, null, null, new SeriesRankTabViewModel$scrollContentToTop$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0() {
        Integer l = y().l();
        if (l != null && l.intValue() >= 0) {
            this.w.setValue(l);
        }
    }

    public final boolean B() {
        String str;
        p90 p90Var;
        com.dragon.read.kmp.shortvideo.distribution.infinite.d g = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(y());
        if (g != null && (p90Var = g.b) != null) {
            str = p90Var.b;
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "ranklist_actor_fans");
    }

    public final boolean C() {
        String str;
        p90 p90Var = this.b.a;
        if (p90Var != null) {
            str = p90Var.b;
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "ranklist_celebrity");
    }

    public final void e0() {
        if (this.x) {
            return;
        }
        this.x = true;
        oo4.e eVar = oo4.e.b;
        b.a aVar = this.b.b;
        eVar.b(aVar.c, aVar.d);
    }

    private final boolean D() {
        androidx.compose.foundation.lazy.x x;
        List h;
        androidx.compose.foundation.lazy.o oVar;
        LazyListState lazyListState = this.A;
        if (lazyListState != null && (x = lazyListState.x()) != null && (h = x.h()) != null && (oVar = (androidx.compose.foundation.lazy.o) CollectionsKt___CollectionsKt.last(h)) != null) {
            return Intrinsics.areEqual(oVar.getKey(), "foot_view");
        }
        return false;
    }

    public final void Z() {
        this.f.e();
        com.dragon.read.kmp.utils.q0.a(this.h);
        com.dragon.read.kmp.utils.q0.a(this.g);
        com.dragon.read.kmp.utils.q0.a(this.k);
        Job.DefaultImpls.cancel$default(this.E, (CancellationException) null, 1, (Object) null);
        this.b.p.p(this.B);
    }

    public final void o0() {
        this.s = true;
        if (((Boolean) this.n.getValue()).booleanValue() && this.o && !this.z) {
            this.n.setValue(Boolean.FALSE);
        }
        if (!this.y) {
            com.dragon.read.kmp.service.q a2 = com.dragon.read.kmp.service.m0.a();
            if (a2 != null) {
                a2.b0("series_ranking_scroll_fps_kmp");
            }
            this.y = true;
        }
    }

    public final void p0() {
        if (this.s) {
            this.q.d(D());
            s0(v());
        }
        this.s = false;
        if (this.y) {
            com.dragon.read.kmp.service.q a2 = com.dragon.read.kmp.service.m0.a();
            if (a2 != null) {
                a2.H0("series_ranking_scroll_fps_kmp");
            }
            this.y = false;
        }
    }

    private final List<io4.d> v() {
        androidx.compose.foundation.lazy.x x;
        List h;
        ArrayList arrayList = new ArrayList();
        LazyListState lazyListState = this.A;
        if (lazyListState != null && (x = lazyListState.x()) != null && (h = x.h()) != null) {
            Iterator it2 = h.iterator();
            while (it2.hasNext()) {
                int index = ((androidx.compose.foundation.lazy.o) it2.next()).getIndex();
                if (((com.dragon.read.kmp.basenovel.ui.ui.a) this.f).c) {
                    index--;
                }
                if (index >= 0 && index < this.b.c.size()) {
                    com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var = (com.dragon.read.kmp.basenovel.ui.ui.v0) CollectionsKt___CollectionsKt.getOrNull(this.b.c, index);
                    if (v0Var instanceof io4.d) {
                        arrayList.add(v0Var);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void z0() {
        boolean z;
        io4.a aVar;
        String str;
        bj0 bj0Var;
        cj0 cj0Var;
        if (!this.o) {
            io4.b bVar = this.b;
            if (bVar.o) {
                String str2 = bVar.b.k;
                if (str2.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.n.setValue(Boolean.FALSE);
                    return;
                }
                SnapshotStateList snapshotStateList = ((com.dragon.read.kmp.basenovel.ui.ui.a) this.f).a;
                if (snapshotStateList.isEmpty()) {
                    this.n.setValue(Boolean.FALSE);
                    return;
                }
                Iterator it2 = snapshotStateList.iterator();
                int i = 0;
                while (true) {
                    if (it2.hasNext()) {
                        com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var = (com.dragon.read.kmp.basenovel.ui.ui.v0) it2.next();
                        if (v0Var instanceof io4.a) {
                            aVar = (io4.a) v0Var;
                        } else {
                            aVar = null;
                        }
                        if (aVar != null && (bj0Var = aVar.a) != null && (cj0Var = bj0Var.a) != null) {
                            str = cj0Var.a;
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(str, str2)) {
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        i = -1;
                        break;
                    }
                }
                if (i < 0) {
                    com.dragon.read.kmp.j.a.d("SeriesRankTabViewModel", "tryScrollToCelebrityRank: target not found, celebrityUserId=" + str2);
                    this.n.setValue(Boolean.FALSE);
                    return;
                }
                this.o = true;
                int max = Math.max(i - 3, 0);
                CoroutineScope coroutineScope = this.r;
                if (coroutineScope == null) {
                    return;
                }
                kotlinx.coroutines.i.e(coroutineScope, null, null, new SeriesRankTabViewModel$tryScrollToCelebrityRank$1(this, max, str2, null), 3, null);
            }
        }
    }

    private final void X() {
        String str;
        String str2;
        com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar;
        MutableState<Set<String>> mutableState;
        Set set;
        com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
        StringBuilder sb = new StringBuilder();
        sb.append("onCreate name:");
        p90 p90Var = this.b.a;
        String str3 = null;
        if (p90Var != null) {
            str = p90Var.a;
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(", videoModel:");
        sb.append(hashCode());
        sb.append(",tabModel:");
        sb.append(this.b.hashCode());
        jVar.d("SeriesRankTabViewModel", sb.toString());
        this.p.t(this.b);
        this.p.w(this.b.p.m());
        eo4.f fVar = this.p;
        com.dragon.read.kmp.shortvideo.distribution.infinite.d g = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(this.b.p);
        if (g == null || (gVar = g.e) == null || (mutableState = gVar.b) == null || (set = (Set) mutableState.getValue()) == null || (str2 = CollectionsKt___CollectionsKt.joinToString$default(set, ",", null, null, 0, null, null, 62, null)) == null) {
            str2 = "";
        }
        fVar.u(str2);
        this.p.s(this.b.b.k);
        y().o(this.B);
        if (!this.b.c.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("have data name:");
            p90 p90Var2 = this.b.a;
            if (p90Var2 != null) {
                str3 = p90Var2.a;
            }
            sb2.append(str3);
            sb2.append(", offset:");
            sb2.append(this.b.i);
            sb2.append(",hasMore:");
            sb2.append(this.b.h);
            sb2.append(" data size:");
            sb2.append(this.b.c.size());
            jVar.d("SeriesRankTabViewModel", sb2.toString());
            this.f.b(this.b.c, true);
            if (!this.p.i()) {
                this.f.j();
            }
            if (!((Collection) this.b.p.a.getValue()).isEmpty()) {
                io4.b bVar = this.b;
                if (bVar.l) {
                    boolean z = bVar.m;
                }
            }
            A0();
            v0();
            L(new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.q0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit Y;
                    Y = SeriesRankTabViewModel.Y(SeriesRankTabViewModel.this);
                    return Y;
                }
            });
        } else {
            f0(false);
        }
        this.b.m = false;
    }

    public static final class d implements com.dragon.read.kmp.shortvideo.distribution.infinite.f {
        @Override // com.dragon.read.kmp.shortvideo.distribution.infinite.f
        public void d(com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar) {
            f.a.b(this, dVar);
        }

        @Override // com.dragon.read.kmp.shortvideo.distribution.infinite.f
        public void e(com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar) {
            f.a.e(this, dVar);
        }

        d() {
        }

        @Override // com.dragon.read.kmp.shortvideo.distribution.infinite.f
        public void b(boolean z, FilterType filterType) {
            f.a.a(this, z, filterType);
        }

        @Override // com.dragon.read.kmp.shortvideo.distribution.infinite.f
        public void a(com.dragon.read.kmp.shortvideo.distribution.infinite.d filterItem, FilterType filterType) {
            Intrinsics.checkNotNullParameter(filterItem, "filterItem");
            Intrinsics.checkNotNullParameter(filterType, "filterType");
            SeriesRankTabViewModel.this.k0(filterItem, filterType);
            SeriesRankTabViewModel.this.v0();
            SeriesRankTabViewModel.this.t.k(filterItem);
        }

        @Override // com.dragon.read.kmp.shortvideo.distribution.infinite.f
        public void c(com.dragon.read.kmp.shortvideo.distribution.infinite.d filterItem, FilterType filterType) {
            boolean contains;
            Intrinsics.checkNotNullParameter(filterItem, "filterItem");
            Intrinsics.checkNotNullParameter(filterType, "filterType");
            contains = CollectionsKt___CollectionsKt.contains(SeriesRankTabViewModel.this.v, filterItem.b.a);
            if (contains) {
                return;
            }
            Set<String> set = SeriesRankTabViewModel.this.v;
            String str = filterItem.b.a;
            if (str == null) {
                str = "";
            }
            set.add(str);
            SeriesRankTabViewModel.this.t.l(filterItem);
        }
    }

    public static final class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            String str2;
            boolean contains;
            om0 videoData;
            String str3;
            Boolean bool;
            String stringExtra;
            String str4;
            if (intent != null) {
                str = intent.getAction();
            } else {
                str = null;
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 182802552) {
                    if (hashCode != 1552963718 || !str.equals("com.dragon.read.kmp.shortvideo.utils.ACTION_USER_RELATION_CHANGE") || (stringExtra = intent.getStringExtra("com.dragon.read.kmp.shortvideo.utils.EXTRA_USER_ID")) == null) {
                        return;
                    }
                    UserRelationType a = UserRelationType.Companion.a(intent.getIntExtra("com.dragon.read.kmp.shortvideo.utils.EXTRA_RELATION_TYPE", UserRelationType.None.getValue()));
                    for (com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var : ((com.dragon.read.kmp.basenovel.ui.ui.a) SeriesRankTabViewModel.this.f).a) {
                        if (v0Var instanceof io4.a) {
                            io4.a aVar = (io4.a) v0Var;
                            cj0 cj0Var = aVar.a.a;
                            if (cj0Var != null) {
                                str4 = cj0Var.a;
                            } else {
                                str4 = null;
                            }
                            if (Intrinsics.areEqual(str4, stringExtra)) {
                                aVar.h.setValue(a);
                            }
                        }
                    }
                    return;
                }
                if (str.equals("action_subscribe_status_update")) {
                    Map<String, Object> f = com.dragon.read.kmp.utils.v.a.f(intent.getStringExtra("key_subscribe_item"));
                    for (com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var2 : ((com.dragon.read.kmp.basenovel.ui.ui.a) SeriesRankTabViewModel.this.f).a) {
                        if (v0Var2 instanceof io4.g) {
                            io4.g gVar = (io4.g) v0Var2;
                            if (gVar.g()) {
                                Set<String> keySet = f.keySet();
                                om0 videoData2 = gVar.getVideoData();
                                if (videoData2 != null) {
                                    str2 = videoData2.p;
                                } else {
                                    str2 = null;
                                }
                                contains = CollectionsKt___CollectionsKt.contains(keySet, str2);
                                if (contains && (videoData = gVar.getVideoData()) != null && (str3 = videoData.p) != null) {
                                    MutableState<Boolean> mutableState = gVar.e;
                                    Object obj = f.get(str3);
                                    if (obj instanceof Boolean) {
                                        bool = (Boolean) obj;
                                    } else {
                                        bool = null;
                                    }
                                    mutableState.setValue(Boolean.valueOf(Intrinsics.areEqual(bool, Boolean.TRUE)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(SeriesRankTabViewModel seriesRankTabViewModel) {
        seriesRankTabViewModel.w0(false);
        return Unit.INSTANCE;
    }

    private final boolean Q(String str) {
        if (!Intrinsics.areEqual(str, "starring_actor_ranking_list_page") && !Intrinsics.areEqual(str, "starring_actor_ranking_list_page_search")) {
            return false;
        }
        return true;
    }

    private final int w(String str) {
        if (Intrinsics.areEqual(str, "starring_actor_ranking_list_page")) {
            return 29;
        }
        if (Intrinsics.areEqual(str, "starring_actor_ranking_list_page_search")) {
            return 30;
        }
        return 19;
    }

    public final void R(com.dragon.read.kmp.shortvideo.distribution.infinite.d selectorItem) {
        Intrinsics.checkNotNullParameter(selectorItem, "selectorItem");
        l0(this, selectorItem, null, 2, null);
        this.t.t(selectorItem);
        v0();
    }

    public final void a0(boolean z) {
        com.dragon.read.kmp.j.a.d("SeriesRankTabViewModel", "onErrorRetry isFromFilter:" + z);
        f0(z);
    }

    public final void b0(FilterType filterType) {
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        com.dragon.read.kmp.shortvideo.distribution.infinite.e eVar = this.C;
        if (eVar != null) {
            eVar.a(y(), filterType);
        }
    }

    private final void w0(boolean z) {
        if (z) {
            MutableState<com.dragon.read.kmp.shortvideo.distribution.page.tab.a> mutableState = this.i;
            mutableState.setValue(com.dragon.read.kmp.shortvideo.distribution.page.tab.a.b((com.dragon.read.kmp.shortvideo.distribution.page.tab.a) mutableState.getValue(), null, LoadStatus.Content, 1, null));
        } else {
            MutableState<com.dragon.read.kmp.shortvideo.distribution.page.tab.a> mutableState2 = this.i;
            mutableState2.setValue(com.dragon.read.kmp.shortvideo.distribution.page.tab.a.b((com.dragon.read.kmp.shortvideo.distribution.page.tab.a) mutableState2.getValue(), LoadStatus.Content, null, 2, null));
        }
    }

    private final void y0(boolean z) {
        if (z) {
            MutableState<com.dragon.read.kmp.shortvideo.distribution.page.tab.a> mutableState = this.i;
            mutableState.setValue(com.dragon.read.kmp.shortvideo.distribution.page.tab.a.b((com.dragon.read.kmp.shortvideo.distribution.page.tab.a) mutableState.getValue(), null, LoadStatus.Loading, 1, null));
        } else {
            MutableState<com.dragon.read.kmp.shortvideo.distribution.page.tab.a> mutableState2 = this.i;
            mutableState2.setValue(com.dragon.read.kmp.shortvideo.distribution.page.tab.a.b((com.dragon.read.kmp.shortvideo.distribution.page.tab.a) mutableState2.getValue(), LoadStatus.Loading, null, 2, null));
        }
    }

    private final ym4.k z(om0 om0Var) {
        return com.dragon.read.kmp.utils.k0.a.b().g(this.t.e(om0Var)).d("list_name", this.b.c()).d("parent_list_name", this.b.f());
    }

    public final void F(boolean z) {
        if (!this.c.b) {
            return;
        }
        if (!this.f.c()) {
            this.f.j();
            return;
        }
        this.f.k();
        boolean D = D();
        G(this.q, D);
        if (z) {
            this.q.d(D);
        }
    }

    public final void m0(com.dragon.read.kmp.shortvideo.distribution.infinite.d selectorItem) {
        boolean contains;
        Intrinsics.checkNotNullParameter(selectorItem, "selectorItem");
        contains = CollectionsKt___CollectionsKt.contains(this.u, selectorItem.b.a);
        if (contains) {
            return;
        }
        Set<String> set = this.u;
        String str = selectorItem.b.a;
        if (str == null) {
            str = "";
        }
        set.add(str);
        this.t.o(selectorItem);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
    
        if (r0 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void L(final kotlin.jvm.functions.Function0<kotlin.Unit> r5) {
        /*
            r4 = this;
            io.reactivex.disposables.Disposable r0 = r4.k
            com.dragon.read.kmp.utils.q0.a(r0)
            boolean r0 = r4.B()
            if (r0 != 0) goto L18
            androidx.compose.runtime.MutableState<java.util.List<io4.f>> r0 = r4.j
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r0.setValue(r1)
            r5.invoke()
            return
        L18:
            lo4.a r0 = r4.d
            if (r0 != 0) goto L29
            androidx.compose.runtime.MutableState<java.util.List<io4.f>> r0 = r4.j
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r0.setValue(r1)
            r5.invoke()
            return
        L29:
            java.lang.String r1 = "hongguo_actor_fans_ranklist_activity"
            io.reactivex.Observable r0 = r0.e(r1)
            if (r0 == 0) goto L5d
            com.bytedance.kmp.rxkmp.KSchedulers r1 = com.bytedance.kmp.rxkmp.KSchedulers.INSTANCE
            io.reactivex.Scheduler r1 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            java.lang.String r2 = "mainThread()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.Observable r0 = r0.observeOn(r1)
            if (r0 == 0) goto L5d
            com.dragon.read.kmp.shortvideo.distribution.page.tab.j0 r1 = new com.dragon.read.kmp.shortvideo.distribution.page.tab.j0
            r1.<init>()
            com.dragon.read.kmp.shortvideo.distribution.page.tab.k0 r2 = new com.dragon.read.kmp.shortvideo.distribution.page.tab.k0
            r2.<init>()
            com.dragon.read.kmp.shortvideo.distribution.page.tab.l0 r1 = new com.dragon.read.kmp.shortvideo.distribution.page.tab.l0
            r1.<init>()
            com.dragon.read.kmp.shortvideo.distribution.page.tab.m0 r3 = new com.dragon.read.kmp.shortvideo.distribution.page.tab.m0
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r2, r3)
            if (r0 == 0) goto L5d
            goto L6a
        L5d:
            androidx.compose.runtime.MutableState<java.util.List<io4.f>> r0 = r4.j
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r0.setValue(r1)
            r5.invoke()
            r0 = 0
        L6a:
            r4.k = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.tab.SeriesRankTabViewModel.L(kotlin.jvm.functions.Function0):void");
    }

    private final void s0(List<? extends io4.d> list) {
        boolean z;
        Object m773constructorimpl;
        if (!this.c.d) {
            return;
        }
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        com.dragon.read.kmp.j.a.d("SeriesRankTabViewModel", "prefetchVideoDetail preloadItems:" + list.size());
        try {
            Result.Companion companion = Result.Companion;
            CoroutineScope coroutineScope = this.r;
            Job job = null;
            if (coroutineScope != null) {
                job = kotlinx.coroutines.i.e(coroutineScope, Dispatchers.getIO(), null, new SeriesRankTabViewModel$prefetchVideoDetail$1$1(this, list, null), 2, null);
            }
            m773constructorimpl = Result.m773constructorimpl(job);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
        if (m776exceptionOrNullimpl != null) {
            com.dragon.read.kmp.j.a.d("SeriesRankTabViewModel", "prefetchVideoDetail error:" + m776exceptionOrNullimpl.getMessage());
        }
    }

    public final void q0(io4.g data) {
        vd0 vd0Var;
        boolean z;
        Intrinsics.checkNotNullParameter(data, "data");
        om0 videoData = data.getVideoData();
        if (videoData == null || (vd0Var = videoData.X0) == null) {
            return;
        }
        ym4.k z2 = z(videoData);
        String str = vd0Var.p;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            String str2 = vd0Var.E;
            if (str2 == null) {
                return;
            }
            zm4.d dVar = zm4.d.a;
            String str3 = videoData.z;
            if (str3 != null) {
                z2.d("from_src_channel_id", ld4.a.a.e(str3));
            }
            Unit unit = Unit.INSTANCE;
            zm4.d.d(dVar, str2, null, z2, 2, null);
            this.t.m(data, "preview_detail_page");
            return;
        }
        String str4 = vd0Var.p;
        if (str4 == null) {
            return;
        }
        E(data, str4);
    }

    private final void A(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar) {
        String str;
        String str2;
        com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar2;
        MutableState<Set<String>> mutableState;
        Set set;
        String joinToString$default;
        com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar3;
        MutableState<Set<String>> mutableState2;
        Set set2;
        if (gVar != null) {
            y().g((List) gVar.a.getValue());
            y().c();
            y().a((Set) gVar.b.getValue());
            y().d(gVar.c);
            y().f = gVar.f;
            com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
            StringBuilder sb = new StringBuilder();
            sb.append("initInfiniteFilter name:");
            p90 p90Var = this.b.a;
            if (p90Var != null) {
                str = p90Var.a;
            } else {
                str = null;
            }
            sb.append(str);
            sb.append(", offset:");
            sb.append(this.b.i);
            sb.append(",hasMore:");
            sb.append(this.b.h);
            sb.append(" data size:");
            sb.append(this.b.c.size());
            jVar.d("SeriesRankTabViewModel", sb.toString());
            this.p.w(y().m());
            eo4.f fVar = this.p;
            com.dragon.read.kmp.shortvideo.distribution.infinite.d g = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(y());
            String str3 = "";
            if (g == null || (gVar3 = g.e) == null || (mutableState2 = gVar3.b) == null || (set2 = (Set) mutableState2.getValue()) == null || (str2 = CollectionsKt___CollectionsKt.joinToString$default(set2, ",", null, null, 0, null, null, 62, null)) == null) {
                str2 = "";
            }
            fVar.u(str2);
            eo4.f fVar2 = this.p;
            com.dragon.read.kmp.shortvideo.distribution.infinite.d g2 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(y());
            if (g2 != null && (gVar2 = g2.f) != null && (mutableState = gVar2.b) != null && (set = (Set) mutableState.getValue()) != null && (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(set, ",", null, null, 0, null, null, 62, null)) != null) {
                str3 = joinToString$default;
            }
            fVar2.r(str3);
        }
    }

    private final void f0(final boolean z) {
        String str;
        Disposable disposable = this.g;
        boolean z2 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z2 = true;
        }
        if (z2) {
            com.dragon.read.kmp.j.a.d("SeriesRankTabViewModel", "last first page request is in progress,isFromFilter:" + z + ", stop this request!");
            return;
        }
        com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
        StringBuilder sb = new StringBuilder();
        sb.append("onCreate name:");
        p90 p90Var = this.b.a;
        if (p90Var != null) {
            str = p90Var.a;
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(", offset:");
        sb.append(this.b.i);
        sb.append(",hasMore:");
        sb.append(this.b.h);
        sb.append(" isFromFilter:");
        sb.append(z);
        sb.append(" request first page data");
        jVar.d("SeriesRankTabViewModel", sb.toString());
        y0(z);
        this.f.l(FootLoadingState.INIT);
        final long n = a1.n(a1.a, null, null, 3, null);
        Observable<Triple<List<com.dragon.read.kmp.basenovel.ui.ui.v0>, com.dragon.read.kmp.shortvideo.distribution.infinite.g, Triple<List<x7>, y7, bj0>>> o = this.p.o();
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable<Triple<List<com.dragon.read.kmp.basenovel.ui.ui.v0>, com.dragon.read.kmp.shortvideo.distribution.infinite.g, Triple<List<x7>, y7, bj0>>> observeOn = o.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g0;
                g0 = SeriesRankTabViewModel.g0(z, this, n, (Triple) obj);
                return g0;
            }
        };
        Consumer<? super Triple<List<com.dragon.read.kmp.basenovel.ui.ui.v0>, com.dragon.read.kmp.shortvideo.distribution.infinite.g, Triple<List<x7>, y7, bj0>>> consumer = new Consumer() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.n0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesRankTabViewModel.h0(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i0;
                i0 = SeriesRankTabViewModel.i0(SeriesRankTabViewModel.this, z, n, (Throwable) obj);
                return i0;
            }
        };
        this.g = observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.p0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesRankTabViewModel.j0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(SeriesRankTabViewModel seriesRankTabViewModel, boolean z) {
        seriesRankTabViewModel.w0(z);
        return Unit.INSTANCE;
    }

    private final void r0(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        SnapshotStateList snapshotStateList = ((com.dragon.read.kmp.basenovel.ui.ui.a) this.f).a;
        if (i < snapshotStateList.size() && i2 >= 0) {
            int max = Math.max(i, 0);
            int min = Math.min(i2, snapshotStateList.size() - 1);
            if (max <= min) {
                while (true) {
                    com.dragon.read.kmp.basenovel.ui.ui.v0 v0Var = (com.dragon.read.kmp.basenovel.ui.ui.v0) CollectionsKt___CollectionsKt.getOrNull(snapshotStateList, max);
                    if (v0Var instanceof io4.d) {
                        arrayList.add(v0Var);
                    }
                    if (max == min) {
                        break;
                    } else {
                        max++;
                    }
                }
            }
            s0(arrayList);
        }
    }

    private final void x0(boolean z, boolean z2) {
        if (z) {
            if (z2) {
                MutableState<com.dragon.read.kmp.shortvideo.distribution.page.tab.a> mutableState = this.i;
                mutableState.setValue(com.dragon.read.kmp.shortvideo.distribution.page.tab.a.b((com.dragon.read.kmp.shortvideo.distribution.page.tab.a) mutableState.getValue(), null, LoadStatus.Empty, 1, null));
                return;
            } else {
                MutableState<com.dragon.read.kmp.shortvideo.distribution.page.tab.a> mutableState2 = this.i;
                mutableState2.setValue(com.dragon.read.kmp.shortvideo.distribution.page.tab.a.b((com.dragon.read.kmp.shortvideo.distribution.page.tab.a) mutableState2.getValue(), null, LoadStatus.Error, 1, null));
                return;
            }
        }
        MutableState<com.dragon.read.kmp.shortvideo.distribution.page.tab.a> mutableState3 = this.i;
        mutableState3.setValue(com.dragon.read.kmp.shortvideo.distribution.page.tab.a.b((com.dragon.read.kmp.shortvideo.distribution.page.tab.a) mutableState3.getValue(), LoadStatus.Error, null, 2, null));
    }

    public final void E(io4.g data, String schema) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(schema, "schema");
        om0 videoData = data.getVideoData();
        if (videoData == null) {
            return;
        }
        zm4.d.d(zm4.d.a, schema, null, z(videoData).m("card_position"), 2, null);
        this.t.m(data, "trailer");
    }

    private final void G(final oo4.c cVar, boolean z) {
        Disposable disposable = this.h;
        boolean z2 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z2 = true;
        }
        if (z2) {
            com.dragon.read.kmp.j.a.d("SeriesRankTabViewModel", "last load more request is in progress, stop this request!");
            return;
        }
        cVar.c(z);
        final long n = a1.n(a1.a, null, null, 3, null);
        Observable<Pair<List<com.dragon.read.kmp.basenovel.ui.ui.v0>, Pair<List<x7>, y7>>> k = this.p.k();
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable<Pair<List<com.dragon.read.kmp.basenovel.ui.ui.v0>, Pair<List<x7>, y7>>> observeOn = k.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit H;
                H = SeriesRankTabViewModel.H(oo4.c.this, this, n, (Pair) obj);
                return H;
            }
        };
        Consumer<? super Pair<List<com.dragon.read.kmp.basenovel.ui.ui.v0>, Pair<List<x7>, y7>>> consumer = new Consumer() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.s0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesRankTabViewModel.I(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.t0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit J;
                J = SeriesRankTabViewModel.J(SeriesRankTabViewModel.this, n, (Throwable) obj);
                return J;
            }
        };
        this.h = observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.u0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SeriesRankTabViewModel.K(Function1.this, obj);
            }
        });
    }

    public final void T(io4.f item, int i) {
        lo4.a aVar;
        Intrinsics.checkNotNullParameter(item, "item");
        boolean z = true;
        if (item.a.length() != 0) {
            z = false;
        }
        if (!z && (aVar = this.d) != null) {
            String str = item.a;
            ym4.k b2 = com.dragon.read.kmp.utils.k0.a.b();
            b2.d("profile_position", "actor_ranking_list_page");
            b2.c("is_landing_page", 1);
            Unit unit = Unit.INSTANCE;
            ym4.a aVar2 = new ym4.a();
            aVar2.g("enter_from_type", 19);
            aVar2.g("filter_option_header_type", 1);
            aVar2.g("open_vote_panel", Boolean.TRUE);
            aVar2.g("hightlight_tab_type", "5");
            aVar.g(str, b2, aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar, FilterType filterType) {
        MutableState<String> mutableState;
        String str;
        p90 p90Var;
        String str2;
        MutableState<String> mutableState2;
        String str3;
        p90 p90Var2;
        p90 p90Var3;
        MutableState<String> mutableState3;
        String str4;
        p90 p90Var4;
        com.dragon.read.kmp.shortvideo.distribution.infinite.g b2 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.b(y(), filterType);
        if (b2 == null || b2.n(dVar.b.b)) {
            return;
        }
        b2.c();
        String str5 = dVar.b.b;
        String str6 = "";
        if (str5 == null) {
            str5 = "";
        }
        b2.b(str5);
        int i = b.a[filterType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                eo4.f fVar = this.p;
                String str7 = dVar.b.b;
                if (str7 == null) {
                    str7 = "";
                }
                fVar.w(str7);
                com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar = dVar.e;
                if (gVar != null && (mutableState3 = gVar.g) != null) {
                    com.dragon.read.kmp.shortvideo.distribution.infinite.d g = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(gVar);
                    if (g == null || (p90Var4 = g.b) == null || (str4 = p90Var4.z) == null) {
                        str4 = "";
                    }
                    mutableState3.setValue(str4);
                }
                eo4.f fVar2 = this.p;
                com.dragon.read.kmp.shortvideo.distribution.infinite.d g2 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(gVar);
                if (g2 == null || (p90Var3 = g2.b) == null || (str = p90Var3.b) == null) {
                    str = "";
                }
                fVar2.u(str);
                com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar2 = dVar.f;
                if (gVar2 != null && (mutableState2 = gVar2.h) != null) {
                    com.dragon.read.kmp.shortvideo.distribution.infinite.d g3 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(gVar2);
                    if (g3 == null || (p90Var2 = g3.b) == null || (str3 = p90Var2.z) == null) {
                        str3 = "";
                    }
                    mutableState2.setValue(str3);
                }
                eo4.f fVar3 = this.p;
                com.dragon.read.kmp.shortvideo.distribution.infinite.d g4 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.g(gVar2);
                if (g4 != null && (p90Var = g4.b) != null && (str2 = p90Var.b) != null) {
                    str6 = str2;
                }
                fVar3.r(str6);
            } else {
                MutableState<String> mutableState4 = b2.h;
                String str8 = dVar.b.z;
                if (str8 == null) {
                    str8 = "";
                }
                mutableState4.setValue(str8);
                eo4.f fVar4 = this.p;
                String str9 = dVar.b.b;
                if (str9 == null) {
                    str9 = "";
                }
                fVar4.r(str9);
                com.dragon.read.kmp.shortvideo.distribution.infinite.g b3 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.b(y(), FilterType.PANEL);
                if (b3 != null && (mutableState = b3.g) != null) {
                    mutableState.setValue("");
                }
                this.p.u("");
            }
        } else {
            MutableState<String> mutableState5 = b2.g;
            String str10 = dVar.b.z;
            if (str10 == null) {
                str10 = "";
            }
            mutableState5.setValue(str10);
            eo4.f fVar5 = this.p;
            String str11 = dVar.b.b;
            if (str11 != null) {
                str6 = str11;
            }
            fVar5.u(str6);
        }
        this.l.setValue((Object) null);
        f0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(SeriesRankTabViewModel seriesRankTabViewModel, io4.a model, int i) {
        Intrinsics.checkNotNullParameter(model, "model");
        seriesRankTabViewModel.t.u(true, model, "starring_actor_ranking_list_page_search");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(SeriesRankTabViewModel seriesRankTabViewModel, io4.a model, int i) {
        Intrinsics.checkNotNullParameter(model, "model");
        seriesRankTabViewModel.t.u(false, model, "starring_actor_ranking_list_page_search");
        seriesRankTabViewModel.u(model, i, "starring_actor_ranking_list_page_search");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(SeriesRankTabViewModel seriesRankTabViewModel, Function0 function0, List list) {
        MutableState<List<io4.f>> mutableState = seriesRankTabViewModel.j;
        Intrinsics.checkNotNull(list);
        mutableState.setValue(CollectionsKt___CollectionsKt.take(list, 10));
        com.dragon.read.kmp.j.a.d("SeriesRankTabViewModel", "loadRecentSupport success, size=" + list.size());
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(SeriesRankTabViewModel seriesRankTabViewModel, Function0 function0, Throwable th) {
        seriesRankTabViewModel.j.setValue(CollectionsKt__CollectionsKt.emptyList());
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SeriesRankTabViewModel", "loadRecentSupport error, " + th.getMessage(), (Throwable) null, 4, (Object) null);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(SeriesRankTabViewModel seriesRankTabViewModel, long j, Throwable th) {
        seriesRankTabViewModel.f.i();
        oo4.g gVar = oo4.g.a;
        io4.b bVar = seriesRankTabViewModel.b;
        b.a aVar = bVar.b;
        gVar.a(true, aVar.c, aVar.d, aVar.e, aVar.f, j, Integer.valueOf(bVar.c.size()), th, Integer.valueOf(po4.b.c(th)), 0, true);
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SeriesRankTabViewModel", "load more data error, " + th.getMessage(), (Throwable) null, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public final void u(io4.a model, int i, String profilePosition) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(profilePosition, "profilePosition");
        lo4.a aVar = this.d;
        if (aVar != null) {
            ym4.k b2 = com.dragon.read.kmp.utils.k0.a.b();
            b2.d("profile_position", profilePosition);
            b2.c("is_landing_page", 1);
            Unit unit = Unit.INSTANCE;
            ym4.a aVar2 = new ym4.a();
            aVar2.g("enter_from_type", Integer.valueOf(w(profilePosition)));
            aVar2.g("filter_option_header_type", 1);
            if (Q(profilePosition)) {
                aVar2.g("hightlight_tab_type", "5");
            }
            aVar.j(model, i, b2, aVar2);
        }
    }

    public final void S(io4.g model, int i, View view, Context context) {
        Intrinsics.checkNotNullParameter(model, "model");
        ym4.k b2 = com.dragon.read.kmp.utils.k0.a.b();
        b2.g(this.t.b(model, i).b);
        lo4.a aVar = this.d;
        if (aVar != null) {
            aVar.l(model, i, view, context, b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(boolean z, SeriesRankTabViewModel seriesRankTabViewModel, long j, Triple triple) {
        boolean z2;
        List<? extends com.dragon.read.kmp.basenovel.ui.ui.v0> list = (List) triple.getFirst();
        com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar = (com.dragon.read.kmp.shortvideo.distribution.infinite.g) triple.getSecond();
        boolean z3 = false;
        if (list.isEmpty() && z) {
            if (gVar != null && com.dragon.read.kmp.shortvideo.distribution.infinite.h.l(gVar)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                throw new IllegalStateException("data is empty!".toString());
            }
        }
        if (list.isEmpty()) {
            z3 = true;
        }
        if (!z3) {
            oo4.g gVar2 = oo4.g.a;
            b.a aVar = seriesRankTabViewModel.b.b;
            gVar2.a(false, aVar.c, aVar.d, aVar.e, aVar.f, j, null, null, null, list.size(), true);
            seriesRankTabViewModel.c0(gVar, (Triple) triple.getThird(), list, z);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("data is null or empty!".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(SeriesRankTabViewModel seriesRankTabViewModel, boolean z, long j, Throwable th) {
        boolean z2;
        String message = th.getMessage();
        boolean z3 = false;
        if (message != null && message.equals("data is empty")) {
            z2 = z;
            z3 = true;
        } else {
            z2 = z;
        }
        seriesRankTabViewModel.x0(z2, z3);
        oo4.g gVar = oo4.g.a;
        b.a aVar = seriesRankTabViewModel.b.b;
        gVar.a(false, aVar.c, aVar.d, aVar.e, aVar.f, j, null, th, Integer.valueOf(po4.b.c(th)), 0, true);
        com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SeriesRankTabViewModel", "requestFirstPageData error, " + th.getMessage(), (Throwable) null, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public SeriesRankTabViewModel(int i, io4.b tabModel, co4.a shortSeriesDistributeListConfig, lo4.a aVar) {
        Job e;
        Intrinsics.checkNotNullParameter(tabModel, "tabModel");
        Intrinsics.checkNotNullParameter(shortSeriesDistributeListConfig, "shortSeriesDistributeListConfig");
        this.a = i;
        this.b = tabModel;
        this.c = shortSeriesDistributeListConfig;
        this.d = aVar;
        this.f = new com.dragon.read.kmp.shortvideo.distribution.page.tab.b(this);
        this.i = SnapshotStateKt.mutableStateOf$default(new com.dragon.read.kmp.shortvideo.distribution.page.tab.a(null, null, 3, null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.j = SnapshotStateKt.mutableStateOf$default(CollectionsKt__CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.l = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.m = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.n = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(tabModel.o), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.p = new eo4.f();
        this.q = new oo4.c();
        this.t = new no4.b(aVar, tabModel, i);
        this.u = new LinkedHashSet();
        this.v = new LinkedHashSet();
        this.w = SnapshotStateKt.mutableStateOf$default(-1, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.B = new d();
        this.D = new c();
        e = kotlinx.coroutines.i.e(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SeriesRankTabViewModel$receiverJob$1(this, null), 3, null);
        this.E = e;
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(oo4.c cVar, SeriesRankTabViewModel seriesRankTabViewModel, long j, Pair pair) {
        cVar.a();
        if (((List) pair.getFirst()).isEmpty()) {
            com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "SeriesRankTabViewModel", "load more data is null or empty!", (Throwable) null, 4, (Object) null);
            return Unit.INSTANCE;
        }
        oo4.g gVar = oo4.g.a;
        io4.b bVar = seriesRankTabViewModel.b;
        b.a aVar = bVar.b;
        gVar.a(true, aVar.c, aVar.d, aVar.e, aVar.f, j, Integer.valueOf(bVar.c.size()), null, null, ((List) pair.getFirst()).size(), true);
        seriesRankTabViewModel.b.c.addAll((Collection) pair.getFirst());
        seriesRankTabViewModel.b.d.addAll((Collection) ((Pair) pair.getSecond()).getFirst());
        seriesRankTabViewModel.f.a((List) pair.getFirst());
        seriesRankTabViewModel.t0();
        if (!seriesRankTabViewModel.p.i()) {
            seriesRankTabViewModel.f.j();
        } else {
            seriesRankTabViewModel.f.l(FootLoadingState.GONE);
        }
        return Unit.INSTANCE;
    }

    private final void c0(com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar, Triple<? extends List<x7>, y7, bj0> triple, List<? extends com.dragon.read.kmp.basenovel.ui.ui.v0> list, final boolean z) {
        com.dragon.read.kmp.shortvideo.distribution.infinite.g c2;
        A(gVar);
        if (!this.p.i()) {
            this.f.j();
        }
        this.b.c.clear();
        this.b.c.addAll(list);
        this.b.d.clear();
        this.b.d.addAll(triple.getFirst());
        this.b.e = triple.getThird();
        if (z) {
            this.b.g(triple.getSecond());
            y7 y7Var = this.b.g;
            if (y7Var != null && (c2 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.c(y7Var)) != null) {
                A(c2);
            }
        } else {
            this.b.g = triple.getSecond();
        }
        A0();
        this.f.b(list, true);
        u0();
        v0();
        L(new Function0() { // from class: com.dragon.read.kmp.shortvideo.distribution.page.tab.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit d0;
                d0 = SeriesRankTabViewModel.d0(SeriesRankTabViewModel.this, z);
                return d0;
            }
        });
        if (this.c.c.a) {
            F(false);
        }
        if (z) {
            this.t.j(com.dragon.read.kmp.shortvideo.distribution.infinite.h.e(gVar));
        }
        t0();
        r0(0, 9);
    }

    static /* synthetic */ void l0(SeriesRankTabViewModel seriesRankTabViewModel, com.dragon.read.kmp.shortvideo.distribution.infinite.d dVar, FilterType filterType, int i, Object obj) {
        if ((i & 2) != 0) {
            filterType = FilterType.DEFAULT;
        }
        seriesRankTabViewModel.k0(dVar, filterType);
    }
}
