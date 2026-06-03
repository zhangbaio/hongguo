package com.dragon.read.kmp.profile.justsaw;

import androidx.compose.foundation.lazy.grid.e0;
import androidx.compose.foundation.lazy.grid.p;
import androidx.compose.foundation.lazy.staggeredgrid.m;
import androidx.compose.foundation.lazy.staggeredgrid.w;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.compose.common.collapsiblelayout.CollapsibleListState;
import com.dragon.read.kmp.compose.common.list.ScrollableListState;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.kmp.utils.k0;
import com.dragon.read.kmp.utils.v0;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import gk4.o0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import tl4.l;
import x0.t;
import ym4.k;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProfileTabJustSawViewModel {
    public static final int n;
    public final l a;
    public final String b;
    public final String c;
    private final com.dragon.read.kmp.i d;
    public final i e;
    private List<? extends Object> f;
    private ScrollableListState g;
    private CollapsibleListState h;
    private CoroutineScope i;
    public Function0<Unit> j;
    private int k;
    private Job l;
    private final rl4.c m;

    static {
        Covode.recordClassIndex(608197);
        n = 8;
    }

    private final void h() {
        this.e.k();
        this.a.z(true);
    }

    public final void t() {
        Job job = this.l;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    private final boolean r() {
        FilterOptionHeaderType filterOptionHeaderType;
        rl4.c cVar = this.m;
        if (cVar.b == ProfileTab.Video && (((filterOptionHeaderType = cVar.j) == FilterOptionHeaderType.LATEST_TYPE || filterOptionHeaderType == FilterOptionHeaderType.HOTTEST_TYPE) && this.a.d.x())) {
            return true;
        }
        return false;
    }

    private final void w() {
        CoroutineScope coroutineScope = this.i;
        if (coroutineScope == null) {
            return;
        }
        kotlinx.coroutines.i.e(coroutineScope, null, null, new ProfileTabJustSawViewModel$scrollToVideoIndex$1(this, null), 3, null);
    }

    public final void n() {
        v(false);
        this.d.d("find in current dataList index:" + this.k);
        if (this.k > 0) {
            p(this, false, 1, null);
            w();
        } else {
            h();
        }
    }

    public final void s() {
        if (this.k != -1) {
            return;
        }
        int i = 0;
        for (Object obj : this.f) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (obj instanceof o0) {
                String I = ((o0) obj).I();
                if (!v0.a.a(I) && Intrinsics.areEqual(this.b, I)) {
                    this.k = i;
                }
            } else if (obj instanceof jl4.b) {
                String str = ((jl4.b) obj).a.a;
                if (!v0.a.a(str) && Intrinsics.areEqual(this.c, str)) {
                    this.k = i;
                }
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int i(Object obj) {
        if (obj instanceof p) {
            return ((p) obj).getIndex();
        }
        if (obj instanceof m) {
            return ((m) obj).getIndex();
        }
        return -1;
    }

    private final long j(Object obj) {
        if (obj instanceof p) {
            return ((p) obj).d();
        }
        if (obj instanceof m) {
            return ((m) obj).d();
        }
        return x0.p.b.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long k(Object obj) {
        if (obj instanceof p) {
            return ((p) obj).a();
        }
        if (obj instanceof m) {
            return ((m) obj).a();
        }
        return t.b.a();
    }

    private final int l(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof e0) {
            return ((e0) obj).c();
        }
        if (!(obj instanceof w)) {
            return 0;
        }
        return ((w) obj).c();
    }

    private final int m(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof e0) {
            return ((e0) obj).b();
        }
        if (!(obj instanceof w)) {
            return 0;
        }
        return ((w) obj).b();
    }

    public final void o(boolean z) {
        Function0<Unit> function0;
        i iVar = this.e;
        boolean z2 = iVar.b;
        iVar.c(z);
        if (!z && !z2 && (function0 = this.j) != null) {
            function0.invoke();
        }
        Job job = this.l;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void v(boolean z) {
        k b = k0.a.b();
        ym4.a aVar = new ym4.a();
        b.i();
        aVar.g("tab_name", b.i().get("tab_name"));
        aVar.g("category_name", b.i().get("category_name"));
        aVar.g("profile_tab_name", b.i().get("module_name"));
        aVar.g("category_tab_type", b.i().get("category_tab_type"));
        aVar.g("bubble_type", "just_watch");
        if (z) {
            o.a.d("show_guide_bubble", aVar);
        } else {
            aVar.g("clicked_content", "just_watch");
            o.a.d("click_guide_bubble", aVar);
        }
    }

    public final void q(boolean z) {
        if (z) {
            this.e.a();
            s();
            if (this.m.j == FilterOptionHeaderType.HOTTEST_TYPE) {
                this.d.a("onLoadJustSawSuccess 目前在最热tab 重置状态");
                this.e.g();
                return;
            }
            if (!this.a.d.r() && this.k == -1) {
                this.d.a("onLoadJustSawSuccess 没有更多数据了 justSawIndex:" + this.k);
                ig4.g.b("定位失败，请重试", (ToastDuration) null, 2, (Object) null);
                this.e.g();
                return;
            }
            if (this.k == -1) {
                this.d.a("onLoadJustSawSuccess 还有更多数据 justSawIndex:" + this.k);
                this.a.z(true);
                return;
            }
            this.d.a("onLoadJustSawSuccess 已经拉下来刚刚看过的视频 justSawIndex:" + this.k);
            o(false);
            w();
            return;
        }
        this.e.a();
        ig4.g.b("定位失败，请重试", (ToastDuration) null, 2, (Object) null);
        this.e.g();
    }

    private final void x(ScrollableListState scrollableListState, CoroutineScope coroutineScope) {
        Job e;
        this.e.l();
        e = kotlinx.coroutines.i.e(coroutineScope, null, null, new ProfileTabJustSawViewModel$showJustSawButtonFirstEnter$1(scrollableListState, this, null), 3, null);
        this.l = e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(Object obj, Object obj2) {
        int coerceAtLeast;
        float f;
        if (!(obj instanceof p) && !(obj instanceof m)) {
            return false;
        }
        int m = m(obj2);
        int l = l(obj2);
        int l2 = x0.p.l(j(obj));
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Math.min(x0.p.l(j(obj)) + ((int) (k(obj) & 4294967295L)), l) - Math.max(l2, m), 0);
        if (((int) (k(obj) & 4294967295L)) > 0) {
            f = coerceAtLeast / ((int) (k(obj) & 4294967295L));
        } else {
            f = 0.0f;
        }
        if (f <= 0.55f) {
            return false;
        }
        return true;
    }

    public ProfileTabJustSawViewModel(l tabViewModel, String justSawVid, String justSawAlbumId) {
        Intrinsics.checkNotNullParameter(tabViewModel, "tabViewModel");
        Intrinsics.checkNotNullParameter(justSawVid, "justSawVid");
        Intrinsics.checkNotNullParameter(justSawAlbumId, "justSawAlbumId");
        this.a = tabViewModel;
        this.b = justSawVid;
        this.c = justSawAlbumId;
        this.d = new com.dragon.read.kmp.i("JustSawViewModel");
        this.e = new i();
        this.f = CollectionsKt__CollectionsKt.emptyList();
        this.k = -1;
        this.m = tabViewModel.a;
    }

    public static /* synthetic */ void p(ProfileTabJustSawViewModel profileTabJustSawViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        profileTabJustSawViewModel.o(z);
    }

    public final void u(List<? extends Object> list, ScrollableListState scrollListState, CollapsibleListState collapsibleListState, CoroutineScope coroutineScope) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(scrollListState, "scrollListState");
        Intrinsics.checkNotNullParameter(collapsibleListState, "collapsibleListState");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        if (this.e.b || !r()) {
            return;
        }
        this.f = list;
        this.g = scrollListState;
        this.h = collapsibleListState;
        this.i = coroutineScope;
        this.k = -1;
        s();
        if (this.k != -1) {
            Iterator it2 = scrollListState.i().iterator();
            while (true) {
                if (it2.hasNext()) {
                    obj = it2.next();
                    if (i(obj) == this.k) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj == null) {
                this.d.d("first screen didn't find just saw video, show button");
                x(scrollListState, coroutineScope);
                return;
            } else if (g(obj, scrollListState.f())) {
                this.d.d("try hide button");
                p(this, false, 1, null);
                return;
            } else {
                x(scrollListState, coroutineScope);
                return;
            }
        }
        this.d.d("first enter didn't find just saw video, show button");
        x(scrollListState, coroutineScope);
    }
}
