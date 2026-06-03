package lm4;

import com.bytedance.covode.number.Covode;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class d implements com.dragon.read.kmp.b {
    public static final int j;
    private boolean f;
    private Boolean i;
    public final com.dragon.read.kmp.i a = new com.dragon.read.kmp.i(com.dragon.read.kmp.reader.utils.p.o("Font"));
    private int b = 23;
    private final int c = pn4.a.a(23);
    private final int d = pn4.a.a(28);
    public final Integer[] e = e.a();
    private Boolean g = Boolean.FALSE;
    private String h = "";

    static {
        Covode.recordClassIndex(608479);
        j = 8;
    }

    public void a() {
    }

    public Boolean b() {
        return this.g;
    }

    public String c() {
        return this.h;
    }

    public int f() {
        return this.c;
    }

    public int g() {
        return this.b;
    }

    public int h() {
        return this.d;
    }

    public Boolean i() {
        return this.i;
    }

    public final int d() {
        Object last;
        last = ArraysKt___ArraysKt.last(this.e);
        return ((Number) last).intValue();
    }

    public final int e() {
        Object first;
        first = ArraysKt___ArraysKt.first(this.e);
        return ((Number) first).intValue();
    }

    public final boolean j() {
        int length = this.e.length - 1;
        if (length < 0) {
            return false;
        }
        while (true) {
            int i = length - 1;
            if (g() > this.e[length].intValue()) {
                o(this.e[length].intValue());
                return true;
            }
            if (i >= 0) {
                length = i;
            } else {
                return false;
            }
        }
    }

    public final boolean k() {
        int length = this.e.length;
        for (int i = 0; i < length; i++) {
            if (g() < this.e[i].intValue()) {
                o(this.e[i].intValue());
                return true;
            }
        }
        return false;
    }

    public void l(Boolean bool) {
        this.g = bool;
    }

    public void n(boolean z) {
        this.f = z;
    }

    public void o(int i) {
        this.b = i;
    }

    public void p(Boolean bool) {
        this.i = bool;
    }

    public void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.h = str;
    }
}
