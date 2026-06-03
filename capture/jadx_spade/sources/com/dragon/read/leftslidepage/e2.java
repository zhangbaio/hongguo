package com.dragon.read.leftslidepage;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.c4;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e2 extends ViewModel {
    public static final a h;
    public static final int i;
    private final s a;
    private final d b;
    private final List<Runnable> c;
    private final List<ReportType> d;
    public boolean e;
    public final MutableState<Integer> f;
    private final c g;

    public static final class a {
        static {
            Covode.recordClassIndex(611277);
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
            Covode.recordClassIndex(611278);
            int[] iArr = new int[ReportType.values().length];
            try {
                iArr[ReportType.Game.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReportType.Msg.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReportType.RecentWatch.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReportType.Subscribe.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReportType.Follow.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(611276);
        h = new a(null);
        i = 8;
    }

    public final MutableState<com.dragon.read.leftslidepage.b> O0() {
        return this.a.g;
    }

    public final MutableState<q> P0() {
        return this.a.e;
    }

    public final MutableState<i> Q0() {
        return this.a.d;
    }

    public final MutableState<j> R0() {
        return this.a.b;
    }

    public final MutableState<l> S0() {
        return this.a.c;
    }

    public final MutableState<w> T0() {
        return this.a.f;
    }

    public final MutableState<v> U0() {
        return this.a.a;
    }

    public final void W0() {
        this.b.c(this.g);
    }

    public final void X0() {
        this.b.h(this.g);
    }

    public final void M0() {
        com.dragon.read.kmp.j.a.d("VideoFeedTabLeftSlideViewModel", "clearAreaRecord");
        this.d.clear();
    }

    public final void a1() {
        this.b.f(u.a.b());
    }

    public final void b1() {
        this.b.e(u.a.c());
    }

    public final void c1() {
        this.b.a(u.a.d());
    }

    public static final class c implements com.dragon.read.leftslidepage.c {
        @Override // com.dragon.read.leftslidepage.c
        public void onDrawerOpened() {
            com.dragon.read.kmp.j.a.d("VideoFeedTabLeftSlideViewModel", "onDrawerOpened");
            e2.this.e = true;
            e2.this.V0();
            e2.this.g1();
        }

        @Override // com.dragon.read.leftslidepage.c
        public void onDrawerClosed() {
            com.dragon.read.kmp.j.a.d("VideoFeedTabLeftSlideViewModel", "onDrawerClosed");
            e2.this.e = false;
            MutableState<Integer> mutableState = e2.this.f;
            mutableState.setValue(Integer.valueOf(((Number) mutableState.getValue()).intValue() + 1));
        }

        c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1() {
        while (!this.c.isEmpty()) {
            try {
                this.c.remove(0).run();
            } catch (Exception e) {
                com.dragon.read.kmp.j.a.b("VideoFeedTabLeftSlideViewModel", "Failed to process pending show event", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0() {
        String str;
        w wVar;
        String str2;
        com.dragon.read.leftslidepage.b bVar;
        w wVar2;
        com.dragon.read.leftslidepage.b bVar2;
        com.dragon.read.leftslidepage.b bVar3;
        String str3;
        if (!((v) this.a.a.getValue()).a) {
            m1(this, false, ((v) this.a.a.getValue()).e, 0, null, 8, null);
        }
        int i2 = 0;
        for (Object obj : this.d) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ReportType reportType = (ReportType) obj;
            String str4 = "";
            if (reportType == ReportType.Func) {
                q qVar = (q) this.a.e.getValue();
                int N0 = N0(reportType);
                for (p pVar : qVar.b) {
                    if (pVar.getType() == FunctionItemType.RESERVE) {
                        w wVar3 = (w) this.a.f.getValue();
                        if (wVar3 != null && (str3 = wVar3.b) != null) {
                        }
                        str3 = "";
                    } else {
                        if (pVar.getType() == FunctionItemType.FOLLOW_UPDATE && (bVar3 = (com.dragon.read.leftslidepage.b) this.a.g.getValue()) != null && (str3 = bVar3.b) != null) {
                        }
                        str3 = "";
                    }
                    l1(false, pVar.b, N0, str3);
                }
            } else {
                int[] iArr = b.a;
                int i4 = iArr[reportType.ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 == 4 ? (wVar2 = (w) this.a.f.getValue()) == null || (str = wVar2.a) == null : i4 != 5 || (bVar2 = (com.dragon.read.leftslidepage.b) this.a.g.getValue()) == null || (str = bVar2.a) == null) {
                                str = "";
                            }
                        } else {
                            str = ((l) this.a.c.getValue()).a.a;
                        }
                    } else {
                        str = ((j) this.a.b.getValue()).a.a;
                    }
                } else {
                    str = ((i) this.a.d.getValue()).a.a;
                }
                int i5 = iArr[reportType.ordinal()];
                if (i5 == 4 ? !((wVar = (w) this.a.f.getValue()) == null || (str2 = wVar.b) == null) : !(i5 != 5 || (bVar = (com.dragon.read.leftslidepage.b) this.a.g.getValue()) == null || (str2 = bVar.b) == null)) {
                    str4 = str2;
                }
                l1(false, str, N0(reportType), str4);
            }
            i2 = i3;
        }
    }

    public final int N0(ReportType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!this.d.contains(type)) {
            return -1;
        }
        return this.d.indexOf(type) + 1;
    }

    public final void h1(final boolean z) {
        Runnable runnable = new Runnable() { // from class: com.dragon.read.leftslidepage.c2
            @Override // java.lang.Runnable
            public final void run() {
                e2.i1(z);
            }
        };
        if (!z && !this.e) {
            this.c.add(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(boolean z) {
        String str;
        ym4.a aVar = new ym4.a();
        aVar.g("position", "sidebar");
        aVar.g("tab_name", "feed");
        ym4.o oVar = ym4.o.a;
        if (z) {
            str = "click_game_entrance";
        } else {
            str = "show_game_entrance";
        }
        oVar.a(str, aVar);
    }

    public final void L0(ReportType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        com.dragon.read.kmp.j.a.d("VideoFeedTabLeftSlideViewModel", "addAreaRecord " + type);
        this.d.add(type);
    }

    public final void Y0(int i2, p data) {
        Intrinsics.checkNotNullParameter(data, "data");
        com.dragon.read.kmp.j.a.d("VideoFeedTabLeftSlideViewModel", "onFuncItemClick on business click");
        this.b.i(i2, data, u.a.a(data));
    }

    public final void f1(ReportType reportType, String str) {
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        this.b.d(reportType, str, u.a.g(reportType, str));
    }

    public e2(s sidebarInfo, d funDepend) {
        Intrinsics.checkNotNullParameter(sidebarInfo, "sidebarInfo");
        Intrinsics.checkNotNullParameter(funDepend, "funDepend");
        this.a = sidebarInfo;
        this.b = funDepend;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.f = c4.a(0);
        this.g = new c();
    }

    public final void Z0(int i2, r data) {
        boolean z;
        Intrinsics.checkNotNullParameter(data, "data");
        String str = data.d;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            com.dragon.read.kmp.j.a.d("VideoFeedTabLeftSlideViewModel", "game url cannot be empty");
            return;
        }
        com.dragon.read.kmp.j.a.d("VideoFeedTabLeftSlideViewModel", "onGameItemClick scheme is " + str);
        zm4.d.a.c(str, null, com.dragon.read.kmp.utils.k0.a.b().h(new ym4.j().d("tab_name", "sidebar").d("module_name", "function_bar")));
    }

    public final void d1(k data, String areaTitle, int i2) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(areaTitle, "areaTitle");
        this.b.g(data, areaTitle, i2, u.a.e(data, areaTitle, i2));
    }

    public final void e1(g2 data, String str, int i2) {
        Map<String, Object> emptyMap;
        Intrinsics.checkNotNullParameter(data, "data");
        k kVar = data.c;
        if (kVar == null || (emptyMap = u.a.f(kVar, str, i2)) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        this.b.b(data, str, i2, emptyMap);
    }

    public final void j1(final boolean z, final String areaTile, final r game) {
        Intrinsics.checkNotNullParameter(areaTile, "areaTile");
        Intrinsics.checkNotNullParameter(game, "game");
        Runnable runnable = new Runnable() { // from class: com.dragon.read.leftslidepage.d2
            @Override // java.lang.Runnable
            public final void run() {
                e2.k1(z, game, areaTile);
            }
        };
        if (!z && !this.e) {
            this.c.add(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(boolean z, r rVar, String str) {
        String str2;
        String str3;
        String str4;
        ym4.a aVar = new ym4.a();
        aVar.g("position", "sidebar");
        aVar.g("game_id", rVar.a);
        aVar.g("module_name", str);
        aVar.g("game_type", "mini_game");
        aVar.g("tab_name", "feed");
        if (rVar.f) {
            str2 = "history";
        } else {
            str2 = "recommend";
        }
        aVar.g("game_distributed_type", str2);
        ym4.o oVar = ym4.o.a;
        if (z) {
            str3 = "click_game";
        } else {
            str3 = "show_game";
        }
        oVar.a(str3, aVar);
        ym4.a aVar2 = new ym4.a();
        aVar2.g("_param_for_special", "micro_game");
        aVar2.g("mp_id", rVar.a);
        aVar2.g("mp_name", rVar.b);
        aVar2.g("scene", "261036");
        aVar2.g("launch_from", "homepage");
        aVar2.g("location", "sidebar_card");
        if (z) {
            str4 = "mp_click";
        } else {
            str4 = "mp_show";
        }
        oVar.d(str4, aVar2);
    }

    public final void l1(final boolean z, final String moduleName, final int i2, final String str) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Runnable runnable = new Runnable() { // from class: com.dragon.read.leftslidepage.a2
            @Override // java.lang.Runnable
            public final void run() {
                e2.n1(moduleName, i2, str, z);
            }
        };
        if (!z && !this.e) {
            this.c.add(runnable);
        } else {
            runnable.run();
        }
    }

    public final void o1(final boolean z, final int i2, final k data, final String areaTitle) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(areaTitle, "areaTitle");
        Runnable runnable = new Runnable() { // from class: com.dragon.read.leftslidepage.b2
            @Override // java.lang.Runnable
            public final void run() {
                e2.p1(areaTitle, i2, data, z);
            }
        };
        if (!z && !this.e) {
            this.c.add(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(String str, int i2, String str2, boolean z) {
        ym4.a g = new ym4.a().h(com.dragon.read.kmp.utils.k0.a.b().i()).g("tab_name", "feed").g("module_name", str).g("rank", Integer.valueOf(i2)).g("position", "sidebar");
        if (str2 == null) {
            str2 = "";
        }
        ym4.a g2 = g.g("side_label", str2);
        if (z) {
            ym4.o.a.a("click_module", g2);
        } else {
            ym4.o.a.a("show_module", g2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(String str, int i2, k kVar, boolean z) {
        ym4.a g = new ym4.a().h(com.dragon.read.kmp.utils.k0.a.b().i()).g("tab_name", "feed").g("module_name", str).g("rank", Integer.valueOf(i2)).g("position", "sidebar").g("src_material_id", kVar.a).g("material_id", kVar.b).g("material_type", x.a(kVar.g)).g("direction", kVar.c).g("material_rank", Long.valueOf(kVar.d)).g("recommend_info", kVar.e).g("recommend_group_id", kVar.f);
        if (z) {
            ym4.o.a.a("click_video", g);
        } else {
            ym4.o.a.a("show_video", g);
        }
    }

    public static /* synthetic */ void m1(e2 e2Var, boolean z, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        e2Var.l1(z, str, i2, str2);
    }
}
