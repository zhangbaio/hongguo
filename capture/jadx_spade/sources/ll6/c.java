package ll6;

import com.bytedance.common.utility.collection.WeakContainer;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import rl6.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    private static final bl6.a a;
    private static final WeakContainer<qk6.c> b;
    private static final ArrayList<qk6.c> c;
    private static final WeakContainer<qk6.b> d;
    private static final WeakContainer<ll6.a> e;
    private static final WeakContainer<ll6.b> f;
    private static final WeakContainer<qk6.d> g;
    private static String h;
    private static String i;
    public static final c j;

    private c() {
    }

    public static final class a implements rk6.b {
        final /* synthetic */ Runnable a;

        @Override // rk6.b
        public void onCancel() {
            c.j.j(this.a, true);
        }

        @Override // rk6.b
        public void onFinish() {
            c.j.j(this.a, true);
        }

        a(Runnable runnable) {
            this.a = runnable;
        }
    }

    public static final class b implements rk6.b {
        final /* synthetic */ Runnable a;

        @Override // rk6.b
        public void onCancel() {
            c.j.m(this.a, true);
        }

        @Override // rk6.b
        public void onFinish() {
            c.j.m(this.a, true);
        }

        b(Runnable runnable) {
            this.a = runnable;
        }
    }

    /* renamed from: ll6.c$c, reason: collision with other inner class name */
    public static final class C0237c implements rk6.b {
        final /* synthetic */ Runnable a;

        @Override // rk6.b
        public void onCancel() {
            c.j.k(this.a, true);
        }

        @Override // rk6.b
        public void onFinish() {
            c.j.k(this.a, true);
        }

        C0237c(Runnable runnable) {
            this.a = runnable;
        }
    }

    public static final class d implements rk6.b {
        final /* synthetic */ Runnable a;

        @Override // rk6.b
        public void onCancel() {
            c.j.l(this.a, true);
        }

        @Override // rk6.b
        public void onFinish() {
            c.j.l(this.a, true);
        }

        d(Runnable runnable) {
            this.a = runnable;
        }
    }

    static {
        Covode.recordClassIndex(655936);
        j = new c();
        a = new bl6.a("FMSDKPlayerTrace-PlayInterceptorHandler");
        b = new WeakContainer<>();
        c = new ArrayList<>();
        d = new WeakContainer<>();
        e = new WeakContainer<>();
        f = new WeakContainer<>();
        g = new WeakContainer<>();
    }

    public final void e(qk6.d dVar) {
        WeakContainer<qk6.d> weakContainer = g;
        synchronized (weakContainer) {
            weakContainer.add(dVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void f(ll6.a aVar) {
        WeakContainer<ll6.a> weakContainer = e;
        synchronized (weakContainer) {
            weakContainer.add(aVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void g(ll6.b bVar) {
        WeakContainer<ll6.b> weakContainer = f;
        synchronized (weakContainer) {
            weakContainer.add(bVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void h(qk6.b bVar) {
        WeakContainer<qk6.b> weakContainer = d;
        synchronized (weakContainer) {
            weakContainer.add(bVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void i(qk6.c cVar) {
        WeakContainer<qk6.c> weakContainer = b;
        synchronized (weakContainer) {
            weakContainer.add(cVar);
            c.add(cVar);
        }
    }

    public final void r(qk6.d dVar) {
        WeakContainer<qk6.d> weakContainer = g;
        synchronized (weakContainer) {
            weakContainer.remove(dVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void s(ll6.a aVar) {
        WeakContainer<ll6.a> weakContainer = e;
        synchronized (weakContainer) {
            weakContainer.remove(aVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void t(ll6.b bVar) {
        WeakContainer<ll6.b> weakContainer = f;
        synchronized (weakContainer) {
            weakContainer.remove(bVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void u(qk6.b bVar) {
        WeakContainer<qk6.b> weakContainer = d;
        synchronized (weakContainer) {
            weakContainer.remove(bVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void v(qk6.c cVar) {
        WeakContainer<qk6.c> weakContainer = b;
        synchronized (weakContainer) {
            weakContainer.remove(cVar);
            c.remove(cVar);
        }
    }

    public final void n(Runnable runnable) {
        boolean z;
        c.a aVar = new c.a();
        Iterator it2 = g.iterator();
        while (it2.hasNext()) {
            ((qk6.d) it2.next()).j();
        }
        bl6.a aVar2 = a;
        StringBuilder sb = new StringBuilder();
        sb.append("doManualChangeChapterInterceptors: manualChangeInterceptors size = ");
        WeakContainer<ll6.a> weakContainer = e;
        sb.append(weakContainer.size());
        aVar2.d(sb.toString(), new Object[0]);
        if (!rl6.c.i()) {
            Iterator it4 = weakContainer.iterator();
            z = false;
            while (it4.hasNext()) {
                ll6.a each = (ll6.a) it4.next();
                Intrinsics.checkExpressionValueIsNotNull(each, "each");
                rk6.a c2 = each.c();
                if (c2 != null) {
                    c2.k = "change_play_intercept";
                    c2.l = each.a();
                    aVar.d(c2);
                    if (h == null) {
                        h = each.a();
                    }
                    a.d("doManualChangeChapterInterceptors playManualChangeChapterTip: " + each.a(), new Object[0]);
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            aVar.c(new a(runnable));
            aVar.h();
        } else {
            j(runnable, false);
        }
    }

    public final void o(Runnable runnable) {
        boolean z;
        c.a aVar = new c.a();
        Iterator it2 = g.iterator();
        while (it2.hasNext()) {
            ((qk6.d) it2.next()).q();
        }
        bl6.a aVar2 = a;
        StringBuilder sb = new StringBuilder();
        sb.append("doManualResumePlayInterceptors: manualResumeInterceptors size = ");
        WeakContainer<ll6.b> weakContainer = f;
        sb.append(weakContainer.size());
        aVar2.d(sb.toString(), new Object[0]);
        if (!rl6.c.i()) {
            Iterator it4 = weakContainer.iterator();
            z = false;
            while (it4.hasNext()) {
                ll6.b each = (ll6.b) it4.next();
                Intrinsics.checkExpressionValueIsNotNull(each, "each");
                rk6.a c2 = each.c();
                if (c2 != null) {
                    c2.k = "resume_play_intercept";
                    c2.l = each.a();
                    aVar.d(c2);
                    if (h == null) {
                        h = each.a();
                    }
                    a.d("doManualResumePlayInterceptors playManualChangeChapterTip: " + each.a(), new Object[0]);
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            aVar.c(new b(runnable));
            aVar.h();
        } else {
            m(runnable, false);
        }
    }

    public final void p(Runnable runnable) {
        boolean z;
        c.a aVar = new c.a();
        Iterator it2 = g.iterator();
        while (it2.hasNext()) {
            ((qk6.d) it2.next()).f();
        }
        bl6.a aVar2 = a;
        StringBuilder sb = new StringBuilder();
        sb.append("doNextInterceptors: nextInterceptors size = ");
        WeakContainer<qk6.b> weakContainer = d;
        sb.append(weakContainer.size());
        aVar2.d(sb.toString(), new Object[0]);
        if (!rl6.c.i()) {
            Iterator it4 = weakContainer.iterator();
            z = false;
            while (it4.hasNext()) {
                qk6.b each = (qk6.b) it4.next();
                Intrinsics.checkExpressionValueIsNotNull(each, "each");
                rk6.a c2 = each.c();
                if (c2 != null) {
                    c2.k = "next_play_intercept";
                    c2.l = each.a();
                    aVar.d(c2);
                    if (h == null) {
                        h = each.a();
                    }
                    a.d("doNextInterceptors playAutoPlayNextTip: " + each.a(), new Object[0]);
                    z = true;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            aVar.c(new C0237c(runnable));
            aVar.h();
        } else {
            k(runnable, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Runnable runnable, boolean z) {
        String str;
        String str2;
        Iterator it2 = e.iterator();
        while (it2.hasNext()) {
            ((ll6.a) it2.next()).b();
        }
        Iterator it4 = e.iterator();
        boolean z2 = false;
        while (it4.hasNext()) {
            ll6.a each = (ll6.a) it4.next();
            if (each.d()) {
                bl6.a aVar = a;
                StringBuilder sb = new StringBuilder();
                sb.append("interceptManualChange by: ");
                Intrinsics.checkExpressionValueIsNotNull(each, "each");
                sb.append(each.a());
                aVar.d(sb.toString(), new Object[0]);
                if (i == null) {
                    i = each.a();
                }
                z2 = true;
            }
        }
        ml6.b bVar = ml6.b.a;
        String str3 = h;
        if (str3 == null) {
            str = "";
        } else {
            str = str3;
        }
        String str4 = i;
        if (str4 == null) {
            str2 = "";
        } else {
            str2 = str4;
        }
        bVar.i("change_chapter_intercept", z, str, z2, str2);
        h = null;
        i = null;
        Iterator it5 = g.iterator();
        while (it5.hasNext()) {
            ((qk6.d) it5.next()).n(z2);
        }
        if (!z2) {
            if (runnable != null) {
                runnable.run();
            }
        } else {
            zk6.c.n(new zk6.b("tips_and_intercepted", -1));
            zk6.c.t("is_intercept", "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Runnable runnable, boolean z) {
        String str;
        String str2;
        Iterator it2 = d.iterator();
        while (it2.hasNext()) {
            ((qk6.b) it2.next()).b();
        }
        if (!il6.a.B().canPlayNext()) {
            return;
        }
        Iterator it4 = d.iterator();
        boolean z2 = false;
        while (it4.hasNext()) {
            qk6.b each = (qk6.b) it4.next();
            if (each.interceptAutoPlayNext()) {
                bl6.a aVar = a;
                StringBuilder sb = new StringBuilder();
                sb.append("interceptAutoPlayNext by: ");
                Intrinsics.checkExpressionValueIsNotNull(each, "each");
                sb.append(each.a());
                aVar.d(sb.toString(), new Object[0]);
                if (i == null) {
                    i = each.a();
                }
                z2 = true;
            }
        }
        ml6.b bVar = ml6.b.a;
        String str3 = h;
        if (str3 == null) {
            str = "";
        } else {
            str = str3;
        }
        String str4 = i;
        if (str4 == null) {
            str2 = "";
        } else {
            str2 = str4;
        }
        bVar.i("next_play_intercept", z, str, z2, str2);
        h = null;
        i = null;
        Iterator it5 = g.iterator();
        while (it5.hasNext()) {
            ((qk6.d) it5.next()).o(z2);
        }
        if (!z2) {
            if (runnable != null) {
                runnable.run();
            }
        } else {
            zk6.c.n(new zk6.b("tips_and_intercepted", -1));
            zk6.c.t("is_intercept", "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Runnable runnable, boolean z) {
        String str;
        String str2;
        Iterator it2 = f.iterator();
        while (it2.hasNext()) {
            ((ll6.b) it2.next()).d();
        }
        Iterator it4 = f.iterator();
        boolean z2 = false;
        while (it4.hasNext()) {
            ll6.b each = (ll6.b) it4.next();
            if (each.b()) {
                bl6.a aVar = a;
                StringBuilder sb = new StringBuilder();
                sb.append("interceptManualResumePlay by: ");
                Intrinsics.checkExpressionValueIsNotNull(each, "each");
                sb.append(each.a());
                aVar.d(sb.toString(), new Object[0]);
                if (i == null) {
                    i = each.a();
                }
                z2 = true;
            }
        }
        ml6.b bVar = ml6.b.a;
        String str3 = h;
        if (str3 == null) {
            str = "";
        } else {
            str = str3;
        }
        String str4 = i;
        if (str4 == null) {
            str2 = "";
        } else {
            str2 = str4;
        }
        bVar.i("resume_play_intercept", z, str, z2, str2);
        h = null;
        i = null;
        Iterator it5 = g.iterator();
        while (it5.hasNext()) {
            ((qk6.d) it5.next()).t(z2);
        }
        if (!z2 && runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Runnable runnable, boolean z) {
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4;
        rl6.a aVar;
        rl6.a aVar2;
        lk6.b bVar = lk6.c.a;
        if (bVar != null && (aVar2 = bVar.v) != null && aVar2.n()) {
            Iterator<qk6.c> it2 = c.iterator();
            while (it2.hasNext()) {
                it2.next().c();
            }
        } else {
            Iterator it4 = b.iterator();
            while (it4.hasNext()) {
                ((qk6.c) it4.next()).c();
            }
        }
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null && (aVar = bVar2.v) != null && aVar.n()) {
            Iterator<qk6.c> it5 = c.iterator();
            z2 = false;
            while (it5.hasNext()) {
                qk6.c each = it5.next();
                if (each.d()) {
                    bl6.a aVar3 = a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("interceptStartPlay by: ");
                    Intrinsics.checkExpressionValueIsNotNull(each, "each");
                    sb.append(each.a());
                    aVar3.d(sb.toString(), new Object[0]);
                    if (i == null) {
                        i = each.a();
                    }
                    z2 = true;
                }
            }
        } else {
            Iterator it6 = b.iterator();
            z2 = false;
            while (it6.hasNext()) {
                qk6.c each2 = (qk6.c) it6.next();
                if (each2.d()) {
                    bl6.a aVar4 = a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("interceptStartPlay by: ");
                    Intrinsics.checkExpressionValueIsNotNull(each2, "each");
                    sb2.append(each2.a());
                    aVar4.d(sb2.toString(), new Object[0]);
                    if (i == null) {
                        i = each2.a();
                    }
                    z2 = true;
                }
            }
        }
        ml6.b bVar3 = ml6.b.a;
        String str5 = h;
        if (str5 == null) {
            str = "";
        } else {
            str = str5;
        }
        String str6 = i;
        if (str6 == null) {
            str2 = "";
        } else {
            str2 = str6;
        }
        bVar3.i("start_play_intercept", z, str, z2, str2);
        al6.b bVar4 = al6.b.e;
        String str7 = h;
        if (str7 == null) {
            str3 = "";
        } else {
            str3 = str7;
        }
        String str8 = i;
        if (str8 == null) {
            str4 = "";
        } else {
            str4 = str8;
        }
        bVar4.z("start_play_intercept", z, str3, z2, str4);
        h = null;
        i = null;
        Iterator it7 = g.iterator();
        while (it7.hasNext()) {
            ((qk6.d) it7.next()).b(z2, z);
        }
        if (!z2) {
            zk6.c.n(new zk6.b("end_intercepted", -1));
            al6.b.e.q("playmanager_interceptor_handler", System.currentTimeMillis());
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        zk6.c.n(new zk6.b("tips_and_intercepted", -1));
        zk6.c.t("is_intercept", "1");
        al6.b.e.g("intercept");
    }

    public final void q(boolean z, Runnable runnable, boolean z2) {
        boolean z3;
        rl6.a aVar;
        c.a aVar2 = new c.a();
        Iterator it2 = g.iterator();
        while (it2.hasNext()) {
            ((qk6.d) it2.next()).k();
        }
        if (!rl6.c.i()) {
            bl6.a aVar3 = a;
            StringBuilder sb = new StringBuilder();
            sb.append("doStartInterceptors: startInterceptors size = ");
            WeakContainer<qk6.c> weakContainer = b;
            sb.append(weakContainer.size());
            aVar3.d(sb.toString(), new Object[0]);
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (aVar = bVar.v) != null && aVar.n()) {
                Iterator<qk6.c> it4 = c.iterator();
                z3 = false;
                while (it4.hasNext()) {
                    qk6.c each = it4.next();
                    Intrinsics.checkExpressionValueIsNotNull(each, "each");
                    rk6.a b2 = each.b();
                    if (b2 != null && aVar2.g(b2)) {
                        b2.k = "start_play_intercept";
                        b2.l = each.a();
                        aVar2.d(b2);
                        if (h == null) {
                            h = each.a();
                        }
                        a.d("doStartInterceptors by Queue tryPlayTipAndPlayStart: " + each.a(), new Object[0]);
                        z3 = true;
                    }
                }
            } else {
                Iterator it5 = weakContainer.iterator();
                z3 = false;
                while (it5.hasNext()) {
                    qk6.c each2 = (qk6.c) it5.next();
                    Intrinsics.checkExpressionValueIsNotNull(each2, "each");
                    rk6.a b3 = each2.b();
                    if (b3 != null && aVar2.g(b3)) {
                        b3.k = "start_play_intercept";
                        b3.l = each2.a();
                        aVar2.d(b3);
                        if (h == null) {
                            h = each2.a();
                        }
                        a.d("doStartInterceptors tryPlayTipAndPlayStart: " + each2.a(), new Object[0]);
                        z3 = true;
                    }
                }
            }
            if (!z3 && !z) {
                Iterator it6 = f.iterator();
                while (it6.hasNext()) {
                    ll6.b each3 = (ll6.b) it6.next();
                    Intrinsics.checkExpressionValueIsNotNull(each3, "each");
                    rk6.a c2 = each3.c();
                    if (c2 != null) {
                        c2.k = "resume_play_intercept";
                        c2.l = each3.a();
                        aVar2.d(c2);
                        if (h == null) {
                            h = each3.a();
                        }
                        a.d("doStartInterceptors tryPlayTipAndPlayResume: " + each3.a(), new Object[0]);
                        z3 = true;
                    }
                }
            }
            if (z2) {
                rl6.c.g();
            }
        } else {
            z3 = false;
        }
        if (z3) {
            aVar2.c(new d(runnable));
            aVar2.h();
        } else {
            l(runnable, false);
        }
    }
}
