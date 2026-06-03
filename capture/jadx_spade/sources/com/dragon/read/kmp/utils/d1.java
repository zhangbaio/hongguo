package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d1 {
    public static final int h;
    private final boolean a;
    private final xm6.a b;
    private final xm6.c c;
    private final Lazy d;
    private final Function1<Integer, Integer> e;
    private volatile long f;
    public volatile long g;

    static {
        Covode.recordClassIndex(609575);
        h = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i() {
        return 16383;
    }

    private final int h() {
        return ((Number) this.d.getValue()).intValue();
    }

    public final long m() {
        return a1.n(a1.a, null, null, 3, null) - this.f;
    }

    public final boolean f() {
        if (m() < this.g) {
            return this.b.c();
        }
        return this.a;
    }

    private final void j() {
        int i;
        this.f = a1.n(a1.a, null, null, 3, null);
        xm6.c cVar = this.c;
        Function1<Integer, Integer> function1 = this.e;
        do {
            i = cVar.b;
        } while (!cVar.a(i, function1.invoke(Integer.valueOf(i)).intValue()));
    }

    public final boolean g(boolean z) {
        boolean f = f();
        k(z);
        return f;
    }

    public final void k(boolean z) {
        this.b.d(z);
        j();
    }

    public final void l(long j) {
        if (j < 0) {
            j = Long.MAX_VALUE;
        }
        this.g = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(d1 d1Var, int i) {
        return (d1Var.h() & (i + 1)) + 1;
    }

    public final boolean c(boolean z, boolean z2) {
        if (e(this, z, z2, 0, 4, null) != 0) {
            return true;
        }
        return false;
    }

    public d1(boolean z, Number timeoutMillis, boolean z2) {
        Lazy lazy;
        long n;
        Intrinsics.checkNotNullParameter(timeoutMillis, "timeoutMillis");
        this.a = z2;
        this.b = xm6.b.a(z);
        this.c = xm6.b.c(1);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.utils.b1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i;
                i = d1.i();
                return Integer.valueOf(i);
            }
        });
        this.d = lazy;
        this.e = new Function1() { // from class: com.dragon.read.kmp.utils.c1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int n2;
                n2 = d1.n(d1.this, ((Integer) obj).intValue());
                return Integer.valueOf(n2);
            }
        };
        if (z == z2) {
            n = -1;
        } else {
            n = a1.n(a1.a, null, null, 3, null);
        }
        this.f = n;
        long longValue = timeoutMillis.longValue();
        this.g = longValue < 0 ? Long.MAX_VALUE : longValue;
    }

    public final int d(boolean z, boolean z2, int i) {
        if (Math.abs(i) != this.c.b) {
            return 0;
        }
        if (this.b.a(z, z2)) {
            j();
            int i2 = this.c.b;
            if (!this.b.c()) {
                return -i2;
            }
            return i2;
        }
        if (z != f()) {
            return 0;
        }
        k(z2);
        Unit unit = Unit.INSTANCE;
        int i3 = this.c.b;
        if (!this.b.c()) {
            i3 = -i3;
        }
        return i3;
    }

    public /* synthetic */ d1(boolean z, Number number, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? -1 : number, (i & 4) != 0 ? z : z2);
    }

    public static /* synthetic */ int e(d1 d1Var, boolean z, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = d1Var.c.b;
        }
        return d1Var.d(z, z2, i);
    }
}
