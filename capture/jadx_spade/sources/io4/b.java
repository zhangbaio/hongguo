package io4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SelectorDisplayStyle;
import com.bytedance.kmp.reading.model.bj0;
import com.bytedance.kmp.reading.model.p90;
import com.bytedance.kmp.reading.model.s90;
import com.bytedance.kmp.reading.model.v90;
import com.bytedance.kmp.reading.model.x7;
import com.bytedance.kmp.reading.model.y7;
import com.dragon.read.kmp.basenovel.ui.ui.v0;
import com.dragon.read.kmp.shortvideo.distribution.infinite.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public final p90 a;
    public final a b;
    public final List<v0> c;
    public final List<x7> d;
    public bj0 e;
    public String f;
    public y7 g;
    public boolean h;
    public int i;
    public String j;
    public String k;
    public boolean l;
    public boolean m;
    public int n;
    public boolean o;
    public com.dragon.read.kmp.shortvideo.distribution.infinite.g p;

    static {
        Covode.recordClassIndex(609035);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io4.b.<init>():void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b);
    }

    public int hashCode() {
        p90 p90Var = this.a;
        return ((p90Var == null ? 0 : p90Var.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "DistributeModel(tabSelectorItem=" + this.a + ", commonParams=" + this.b + ')';
    }

    public final s90 b() {
        return this.b.j;
    }

    private final com.dragon.read.kmp.shortvideo.distribution.infinite.g a() {
        p90 p90Var = this.a;
        if (p90Var != null) {
            return h.q(p90Var);
        }
        return null;
    }

    public final String f() {
        String str;
        p90 p90Var = this.a;
        if (p90Var == null || (str = p90Var.a) == null) {
            return "";
        }
        return str;
    }

    public final String e() {
        p90 p90Var;
        String str;
        com.dragon.read.kmp.shortvideo.distribution.infinite.d g = h.g(this.p);
        if (g == null || (p90Var = g.b) == null || (str = p90Var.a) == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c() {
        /*
            r1 = this;
            com.bytedance.kmp.reading.model.p90 r0 = r1.a
            if (r0 == 0) goto L1b
            com.bytedance.kmp.reading.model.y7 r0 = r0.B
            if (r0 == 0) goto L1b
            com.bytedance.kmp.reading.model.v90 r0 = r0.a
            if (r0 == 0) goto L1b
            java.util.List r0 = r0.a
            if (r0 == 0) goto L1b
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            com.bytedance.kmp.reading.model.p90 r0 = (com.bytedance.kmp.reading.model.p90) r0
            if (r0 == 0) goto L1b
            java.lang.String r0 = r0.k
            goto L1c
        L1b:
            r0 = 0
        L1c:
            if (r0 == 0) goto L23
            java.lang.String r0 = r1.e()
            return r0
        L23:
            java.lang.String r0 = r1.f()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io4.b.c():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String d() {
        /*
            r1 = this;
            com.bytedance.kmp.reading.model.p90 r0 = r1.a
            if (r0 == 0) goto L1b
            com.bytedance.kmp.reading.model.y7 r0 = r0.B
            if (r0 == 0) goto L1b
            com.bytedance.kmp.reading.model.v90 r0 = r0.a
            if (r0 == 0) goto L1b
            java.util.List r0 = r0.a
            if (r0 == 0) goto L1b
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            com.bytedance.kmp.reading.model.p90 r0 = (com.bytedance.kmp.reading.model.p90) r0
            if (r0 == 0) goto L1b
            java.lang.String r0 = r0.k
            goto L1c
        L1b:
            r0 = 0
        L1c:
            if (r0 == 0) goto L25
            com.dragon.read.kmp.shortvideo.distribution.infinite.g r0 = r1.p
            java.lang.String r0 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.h(r0)
            return r0
        L25:
            com.dragon.read.kmp.shortvideo.distribution.infinite.g r0 = r1.p
            java.lang.String r0 = com.dragon.read.kmp.shortvideo.distribution.infinite.h.e(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io4.b.d():java.lang.String");
    }

    public static final class a {
        public static final int l;
        public final long a;
        public final String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public int g;
        public String h;
        public String i;
        public s90 j;
        public String k;

        static {
            Covode.recordClassIndex(609036);
            l = 8;
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f = str;
        }

        public final void b(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.k = str;
        }

        public final void c(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.e = str;
        }

        public final void d(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }

        public final void e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.d = str;
        }

        public a(long j, String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            this.a = j;
            this.b = sessionId;
            this.c = "";
            this.d = "";
            this.e = "";
            this.f = "";
            this.h = "";
            this.i = "";
            this.k = "";
        }

        public /* synthetic */ a(long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str);
        }
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.k = str;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.j = str;
    }

    public final void g(y7 y7Var) {
        v90 v90Var;
        List<p90> list;
        v90 v90Var2;
        List<p90> list2;
        y7 y7Var2;
        y7 y7Var3 = this.g;
        this.g = y7Var;
        if (y7Var != null && (v90Var = y7Var.a) != null && (list = v90Var.a) != null) {
            for (p90 p90Var : list) {
                if (y7Var3 != null && (v90Var2 = y7Var3.a) != null && (list2 = v90Var2.a) != null) {
                    for (p90 p90Var2 : list2) {
                        if (Intrinsics.areEqual(p90Var2.a, p90Var.a) && (y7Var2 = p90Var.B) != null) {
                            h.n(y7Var2, p90Var2.B);
                        }
                    }
                }
            }
        }
    }

    public b(p90 p90Var, a commonParams) {
        Integer num;
        Intrinsics.checkNotNullParameter(commonParams, "commonParams");
        this.a = p90Var;
        this.b = commonParams;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.j = "";
        this.k = "";
        this.m = true;
        this.n = SelectorDisplayStyle.Default.getValue();
        com.dragon.read.kmp.shortvideo.distribution.infinite.g a2 = a();
        a2 = a2 == null ? new com.dragon.read.kmp.shortvideo.distribution.infinite.g(null, null, null, 7, null) : a2;
        if (p90Var != null) {
            num = p90Var.A;
        } else {
            num = null;
        }
        a2.d = num;
        this.p = a2;
    }

    public /* synthetic */ b(p90 p90Var, a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : p90Var, (i & 2) != 0 ? new a(0L, null, 3, null) : aVar);
    }
}
