package gk4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.a1;
import gk4.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {
    public static final a a;
    private static final Lazy<xn0.b> b;
    private static final Lazy<List<Long>> c;
    private static final Lazy<List<Long>> d;

    public static final class a {
        static {
            Covode.recordClassIndex(607795);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<Long> e() {
            return (List) k.c.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final xn0.b h() {
            return (xn0.b) k.b.getValue();
        }

        private final List<Long> j() {
            return (List) k.d.getValue();
        }

        public final boolean g() {
            xn0.b h = h();
            if (h == null) {
                return false;
            }
            return h.getBoolean("force_bookmall", false);
        }

        public final long i() {
            xn0.b h = h();
            if (h == null) {
                return 0L;
            }
            return h.getLong("shown", 0L);
        }

        private final void o() {
            xn0.b h = h();
            if (h != null) {
                h.b("shown", a1.a.b());
            }
        }

        public final void k() {
            e().clear();
            j().clear();
            l();
            n();
            o();
        }

        private final void l() {
            xn0.b h = h();
            if (h != null) {
                List<Long> e = e();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(e, 10));
                Iterator<T> it2 = e.iterator();
                while (it2.hasNext()) {
                    arrayList.add(String.valueOf(((Number) it2.next()).longValue()));
                }
                h.h("bookmall_records", (String[]) arrayList.toArray(new String[0]));
            }
        }

        private final void n() {
            xn0.b h = h();
            if (h != null) {
                List<Long> j = j();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(j, 10));
                Iterator<T> it2 = j.iterator();
                while (it2.hasNext()) {
                    arrayList.add(String.valueOf(((Number) it2.next()).longValue()));
                }
                h.h("seriesmall_records", (String[]) arrayList.toArray(new String[0]));
            }
        }

        public final void m(boolean z) {
            xn0.b h = h();
            if (h != null) {
                h.d("force_bookmall", z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Long> r(String[] strArr) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(Long.valueOf(Long.parseLong(str)));
            }
            return CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        }

        public final void d(String tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            if (Intrinsics.areEqual(tab, "bookmall")) {
                if (e().size() >= 20) {
                    e().remove(0);
                }
                e().add(Long.valueOf(a1.a.b()));
                l();
                return;
            }
            if (Intrinsics.areEqual(tab, "seriesmall")) {
                if (j().size() >= 20) {
                    j().remove(0);
                }
                j().add(Long.valueOf(a1.a.b()));
                n();
            }
        }

        private final List<Long> p(List<Long> list, final long j) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) list, new Function1() { // from class: gk4.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean q;
                    q = k.a.q(j, ((Long) obj).longValue());
                    return Boolean.valueOf(q);
                }
            });
            return list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean q(long j, long j2) {
            a1 a1Var = a1.a;
            if (a1Var.c(j2) < a1Var.c(j)) {
                return true;
            }
            return false;
        }

        public final int f(String tab, long j) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            if (Intrinsics.areEqual(tab, "bookmall")) {
                return p(e(), j).size();
            }
            if (Intrinsics.areEqual(tab, "seriesmall")) {
                return p(j(), j).size();
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List g() {
        String[] g;
        List r;
        a aVar = a;
        xn0.b h = aVar.h();
        if (h == null || (g = h.g("bookmall_records", (String[]) null)) == null || (r = aVar.r(g)) == null) {
            return new ArrayList();
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xn0.b h() {
        xn0.a a2 = eo0.c.a.a(Reflection.getOrCreateKotlinClass(xn0.a.class));
        if (a2 != null) {
            return a2.D0("bottom_tab_landing_guide");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List i() {
        String[] g;
        List r;
        a aVar = a;
        xn0.b h = aVar.h();
        if (h == null || (g = h.g("seriesmall_records", (String[]) null)) == null || (r = aVar.r(g)) == null) {
            return new ArrayList();
        }
        return r;
    }

    static {
        Lazy<xn0.b> lazy;
        Lazy<List<Long>> lazy2;
        Lazy<List<Long>> lazy3;
        Covode.recordClassIndex(607794);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: gk4.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                xn0.b h;
                h = k.h();
                return h;
            }
        });
        b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: gk4.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List g;
                g = k.g();
                return g;
            }
        });
        c = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: gk4.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List i;
                i = k.i();
                return i;
            }
        });
        d = lazy3;
    }
}
