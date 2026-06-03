package eo4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.ClientReqType;
import com.bytedance.kmp.reading.model.ClientTemplate;
import com.bytedance.kmp.reading.model.UnlimitedShortSeriesChangeType;
import com.bytedance.kmp.reading.model.a30;
import com.bytedance.kmp.reading.model.bj0;
import com.bytedance.kmp.reading.model.j7;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.p90;
import com.bytedance.kmp.reading.model.v90;
import com.bytedance.kmp.reading.model.vl;
import com.bytedance.kmp.reading.model.wl;
import com.bytedance.kmp.reading.model.x7;
import com.bytedance.kmp.reading.model.y7;
import com.bytedance.kmp.reading.rpc.BookApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.basenovel.ui.ui.v0;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.service.d1;
import com.dragon.read.kmp.service.m0;
import com.dragon.read.kmp.service.q;
import com.dragon.read.kmp.utils.StringUtilsKt;
import ec4.g0;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io4.b;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final a h;
    public static final int i;
    private long a;
    private int c;
    private String b = "";
    private b.a d = new b.a(0, null, 3, null);
    private io4.b e = new io4.b(null, null, 3, null);
    private final di6.c<String> f = new di6.c<>();
    private final xm6.d g = xm6.b.e(0);

    public static final class a {
        static {
            Covode.recordClassIndex(609011);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609010);
        h = new a(null);
        i = 8;
    }

    private final int j() {
        return this.e.i;
    }

    public final boolean i() {
        return this.e.h;
    }

    private final String g() {
        return CollectionsKt___CollectionsKt.joinToString$default(this.f, ",", null, null, 0, null, new Function1() { // from class: eo4.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence h2;
                h2 = f.h((String) obj);
                return h2;
            }
        }, 30, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r1 != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.reactivex.Observable<kotlin.Pair<java.util.List<com.dragon.read.kmp.basenovel.ui.ui.v0>, kotlin.Pair<java.util.List<com.bytedance.kmp.reading.model.x7>, com.bytedance.kmp.reading.model.y7>>> k() {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: eo4.f.k():io.reactivex.Observable");
    }

    public final Observable<Triple<List<v0>, com.dragon.read.kmp.shortvideo.distribution.infinite.g, Triple<List<x7>, y7, bj0>>> o() {
        String str;
        if (this.a == 0) {
            com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "ShortSeriesDistributeListRepository", "requestFirstPageData error, cellId is 0", (Throwable) null, 4, (Object) null);
        }
        final long c = this.g.c();
        long j = this.a;
        int value = ClientTemplate.VideoFlow.getValue();
        int value2 = UnlimitedShortSeriesChangeType.ChangeFilter.getValue();
        b.a aVar = this.d;
        String str2 = aVar.c;
        String str3 = aVar.d;
        String str4 = aVar.e;
        String str5 = aVar.f;
        int i2 = this.c;
        int value3 = ClientReqType.LoadMore.getValue();
        q a2 = m0.a();
        if (a2 != null) {
            str = a2.getSessionId();
        } else {
            str = null;
        }
        Observable h2 = BookApiService.h(BookApiService.a, new vl(Long.valueOf(j), (Long) null, (Long) null, (Integer) null, (String) null, (Long) null, (Integer) null, (Long) null, Integer.valueOf(i2), (Integer) null, (Long) null, (Long) null, (String) null, (String) null, (Long) null, (Integer) null, (Long) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (String) null, this.e.j, Integer.valueOf(value3), (Integer) null, (Long) null, (Integer) null, (Long) null, (Long) null, (String) null, (Long) null, (Integer) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (Long) null, (Integer) null, (String) null, (String) null, Integer.valueOf(value), (Integer) null, (String) null, (Long) null, (String) null, str2, (String) null, (String) null, Integer.valueOf(value2), (String) null, (String) null, (Long) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Long) null, (a30) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (String) null, (Integer) null, (List) null, (String) null, (Integer) null, String.valueOf(d1.b(b1.a.p())), (String) null, str, (List) null, (Integer) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, str3, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (List) null, (Boolean) null, (String) null, (String) null, (Boolean) null, (Long) null, (String) null, (String) null, str4, str5, this.d.k, -50331906, -18939905, -536952833, 16383, (DefaultConstructorMarker) null), (zn0.g) null, 2, (Object) null);
        final Function1 function1 = new Function1() { // from class: eo4.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Triple p;
                p = f.p(c, this, (wl) obj);
                return p;
            }
        };
        Observable map = h2.map(new Function() { // from class: eo4.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Triple q;
                q = f.q(Function1.this, obj);
                return q;
            }
        });
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable<Triple<List<v0>, com.dragon.read.kmp.shortvideo.distribution.infinite.g, Triple<List<x7>, y7, bj0>>> subscribeOn = map.subscribeOn(io2);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "subscribeOn(...)");
        return subscribeOn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence h(String it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        if (!StringUtilsKt.a(it2)) {
            return "";
        }
        return it2;
    }

    public final void r(String backgroundSelectedItems) {
        Intrinsics.checkNotNullParameter(backgroundSelectedItems, "backgroundSelectedItems");
        this.d.a(backgroundSelectedItems);
    }

    public final void s(String celebrityUserId) {
        Intrinsics.checkNotNullParameter(celebrityUserId, "celebrityUserId");
        this.d.b(celebrityUserId);
    }

    public final void u(String panelSelectedItems) {
        Intrinsics.checkNotNullParameter(panelSelectedItems, "panelSelectedItems");
        this.d.c(panelSelectedItems);
    }

    public final void w(String subSelectedItems) {
        Intrinsics.checkNotNullParameter(subSelectedItems, "subSelectedItems");
        this.d.e(subSelectedItems);
    }

    public final void t(io4.b distributeModel) {
        Intrinsics.checkNotNullParameter(distributeModel, "distributeModel");
        this.e = distributeModel;
        b.a aVar = distributeModel.b;
        this.d = aVar;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.g;
    }

    private final void f(List<? extends v0> list) {
        om0 videoData;
        String str;
        if (g0.Companion.a().a.contains(this.d.c)) {
            for (v0 v0Var : list) {
                if ((v0Var instanceof io4.d) && (videoData = ((io4.d) v0Var).getVideoData()) != null && (str = videoData.p) != null) {
                    if (this.f.contains(str)) {
                        this.f.remove(str);
                    }
                    if (this.f.size() >= 200) {
                        this.f.remove(0);
                    }
                    this.f.add(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair m(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (Pair) function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Triple q(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (Triple) function1.invoke(p0);
    }

    private final void v(boolean z, int i2, String str) {
        io4.b bVar = this.e;
        bVar.h = z;
        bVar.i = i2;
        bVar.i(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair l(long j, f fVar, wl it2) {
        boolean z;
        List emptyList;
        y7 y7Var;
        x7 x7Var;
        x7 x7Var2;
        Intrinsics.checkNotNullParameter(it2, "it");
        bc4.b.c(bc4.b.a, new bc4.a(it2.a, it2.c, it2.b), false, 0, 6, (Object) null);
        if (j == fVar.g.b) {
            z = true;
        } else {
            z = false;
        }
        List<v0> n = fVar.n(it2.c, false, z);
        j7 j7Var = it2.c;
        if (j7Var == null || (x7Var2 = j7Var.a) == null || (emptyList = x7Var2.u) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        j7 j7Var2 = it2.c;
        if (j7Var2 != null && (x7Var = j7Var2.a) != null) {
            y7Var = x7Var.U1;
        } else {
            y7Var = null;
        }
        return new Pair(n, new Pair(emptyList, y7Var));
    }

    private final List<v0> n(j7 j7Var, boolean z, boolean z2) {
        boolean z3;
        String str;
        String str2;
        Long l;
        String str3;
        x7 x7Var;
        x7 x7Var2 = null;
        if (z2) {
            if (z) {
                this.f.clear();
                io4.b bVar = this.e;
                if (j7Var != null && (x7Var = j7Var.a) != null) {
                    str3 = x7Var.E3;
                } else {
                    str3 = null;
                }
                bVar.f = str3;
            }
            int i2 = 0;
            if (j7Var != null) {
                z3 = Intrinsics.areEqual(j7Var.b, Boolean.TRUE);
            } else {
                z3 = false;
            }
            if (j7Var != null && (l = j7Var.c) != null) {
                i2 = (int) l.longValue();
            }
            if (j7Var == null || (str = j7Var.f) == null) {
                str = "";
            }
            v(z3, i2, str);
            if (j7Var != null && (str2 = j7Var.d) != null) {
                this.b = str2;
            }
        }
        if (j7Var != null) {
            x7Var2 = j7Var.a;
        }
        if (x7Var2 != null) {
            List<v0> b = po4.a.a.b(CollectionsKt__CollectionsJVMKt.listOf(x7Var2), this.c);
            if (b.isEmpty()) {
                com.dragon.read.kmp.j.a.d("ShortSeriesDistributeListRepository", "parseCellChangeData, modelList is empty");
            }
            if (z2) {
                f(b);
            }
            return b;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Triple p(long j, f fVar, wl it2) {
        boolean z;
        com.dragon.read.kmp.shortvideo.distribution.infinite.g gVar;
        List emptyList;
        y7 y7Var;
        x7 x7Var;
        x7 x7Var2;
        x7 x7Var3;
        x7 x7Var4;
        y7 y7Var2;
        v90 v90Var;
        List<p90> list;
        Intrinsics.checkNotNullParameter(it2, "it");
        bc4.b.c(bc4.b.a, new bc4.a(it2.a, it2, it2.b), false, 0, 6, (Object) null);
        if (j == fVar.g.b) {
            z = true;
        } else {
            z = false;
        }
        List<v0> n = fVar.n(it2.c, true, z);
        j7 j7Var = it2.c;
        bj0 bj0Var = null;
        if (j7Var != null && (x7Var4 = j7Var.a) != null && (y7Var2 = x7Var4.U1) != null && (v90Var = y7Var2.a) != null && (list = v90Var.a) != null) {
            for (p90 p90Var : list) {
                if (Intrinsics.areEqual(p90Var.c, Boolean.TRUE)) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        p90Var = null;
        if (p90Var != null) {
            gVar = com.dragon.read.kmp.shortvideo.distribution.infinite.h.q(p90Var);
        } else {
            gVar = null;
        }
        j7 j7Var2 = it2.c;
        if (j7Var2 == null || (x7Var3 = j7Var2.a) == null || (emptyList = x7Var3.u) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        j7 j7Var3 = it2.c;
        if (j7Var3 != null && (x7Var2 = j7Var3.a) != null) {
            y7Var = x7Var2.U1;
        } else {
            y7Var = null;
        }
        if (j7Var3 != null && (x7Var = j7Var3.a) != null) {
            bj0Var = x7Var.D3;
        }
        return new Triple(n, gVar, new Triple(emptyList, y7Var, bj0Var));
    }
}
