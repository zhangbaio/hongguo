package com.dragon.read.kmp.mine.model;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o;
import androidx.compose.foundation.lazy.x;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.k0;
import com.dragon.read.kmp.utils.p0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j extends ViewModel {
    public static final a g;
    public static final int h;
    private final fk4.a a;
    private final StateFlow<fk4.c> b;
    public boolean c;
    public LazyListState d;
    private final b e;
    private final HashSet<String> f;

    public static final class a {
        static {
            Covode.recordClassIndex(607705);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(607704);
        g = new a(null);
        h = 8;
    }

    public static final class b implements fk4.b {
        @Override // fk4.b
        public void onDrawerClosed() {
            j.this.c = false;
        }

        @Override // fk4.b
        public void onDrawerOpened() {
            x x;
            List h;
            l lVar;
            j.this.c = true;
            LazyListState lazyListState = j.this.d;
            if (lazyListState != null && (x = lazyListState.x()) != null && (h = x.h()) != null) {
                j jVar = j.this;
                Iterator it2 = h.iterator();
                while (it2.hasNext()) {
                    int index = ((o) it2.next()).getIndex();
                    List<l> list = ((fk4.c) jVar.b.getValue()).a;
                    if (list != null && (lVar = (l) CollectionsKt___CollectionsKt.getOrNull(list, index)) != null) {
                        jVar.N0(lVar, index, true);
                    }
                }
            }
        }

        b() {
        }
    }

    public final void K0() {
        this.a.b(this.e);
    }

    public final void L0() {
        this.a.d(this.e);
    }

    private final boolean J0(String str) {
        return this.f.contains(str);
    }

    private final ym4.a H0(ym4.a aVar) {
        aVar.g("position", "sidebar");
        return aVar;
    }

    private final ym4.a G0(ym4.a aVar, String str) {
        aVar.g("module_name", str);
        return aVar;
    }

    private final ym4.a I0(ym4.a aVar, int i) {
        aVar.g("rank", Integer.valueOf(i + 1));
        return aVar;
    }

    public j(fk4.a iDepend, StateFlow<fk4.c> sidebarPageParams) {
        Intrinsics.checkNotNullParameter(iDepend, "iDepend");
        Intrinsics.checkNotNullParameter(sidebarPageParams, "sidebarPageParams");
        this.a = iDepend;
        this.b = sidebarPageParams;
        this.e = new b();
        this.f = new HashSet<>();
    }

    public final void M0(l sidebarFunctionItemModel, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(sidebarFunctionItemModel, "sidebarFunctionItemModel");
        this.a.c(sidebarFunctionItemModel);
        String str = sidebarFunctionItemModel.c;
        O0(this, sidebarFunctionItemModel, i, false, 4, null);
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            com.dragon.read.kmp.j.a.d("SidePageViewModel", "onItemClick on business click");
            this.a.a(sidebarFunctionItemModel, i);
            return;
        }
        com.dragon.read.kmp.j.a.d("SidePageViewModel", "onItemClick scheme is " + str);
        ym4.j jVar = new ym4.j();
        String str2 = sidebarFunctionItemModel.b;
        if (str2 == null) {
            str2 = "";
        }
        jVar.d("module_name", str2);
        zm4.d.a.c(str, null, k0.a.b().h(jVar));
    }

    public final void N0(l sidebarFunctionItemModel, int i, boolean z) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(sidebarFunctionItemModel, "sidebarFunctionItemModel");
        String str3 = "";
        if (z) {
            String str4 = sidebarFunctionItemModel.b;
            if (str4 == null) {
                str4 = "";
            }
            if (J0(str4)) {
                return;
            }
            HashSet<String> hashSet = this.f;
            String str5 = sidebarFunctionItemModel.b;
            if (str5 == null) {
                str5 = "";
            }
            hashSet.add(str5);
        }
        ym4.a aVar = new ym4.a();
        ym4.a g2 = aVar.g("tab_name", "mine");
        String str6 = sidebarFunctionItemModel.b;
        if (str6 != null) {
            str3 = str6;
        }
        p0.b(H0(I0(G0(g2, str3), i)));
        ym4.o oVar = ym4.o.a;
        if (z) {
            str = "show_module";
        } else {
            str = "click_module";
        }
        oVar.a(str, aVar);
        if (Intrinsics.areEqual(sidebarFunctionItemModel.f, Boolean.TRUE)) {
            if (z) {
                str2 = "show_red_dot";
            } else {
                str2 = "click_red_dot";
            }
            ym4.a aVar2 = new ym4.a();
            aVar2.g("tab_name", "mine");
            aVar2.g("position", sidebarFunctionItemModel.b);
            aVar2.g("red_dot_string", "point");
            Unit unit = Unit.INSTANCE;
            oVar.a(str2, aVar2);
        }
    }

    public static /* synthetic */ void O0(j jVar, l lVar, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        jVar.N0(lVar, i, z);
    }
}
