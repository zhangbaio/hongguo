package com.dragon.read.kmp.reader.state;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public final int a;
    public final zl4.b b;
    public final qg4.n c;

    static {
        Covode.recordClassIndex(608573);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && Intrinsics.areEqual(this.b, fVar.b) && Intrinsics.areEqual(this.c, fVar.c);
    }

    public int hashCode() {
        return (((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DerivedThemeLocals(theme=" + this.a + ", colorScheme=" + this.b + ", appColorScheme=" + this.c + ')';
    }

    public f(int i, zl4.b colorScheme, qg4.n appColorScheme) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(appColorScheme, "appColorScheme");
        this.a = i;
        this.b = colorScheme;
        this.c = appColorScheme;
    }
}
