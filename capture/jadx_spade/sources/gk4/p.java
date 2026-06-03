package gk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public final int a;
    public final int b;
    public final String c;
    public final boolean d;

    static {
        Covode.recordClassIndex(607800);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.a == pVar.a && this.b == pVar.b && Intrinsics.areEqual(this.c, pVar.c) && this.d == pVar.d;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + androidx.compose.animation.m.a(this.d);
    }

    public String toString() {
        return "CornerTag(textColor=" + this.a + ", bgColor=" + this.b + ", text=" + this.c + ", isVip=" + this.d + ')';
    }

    public p(int i, int i2, String text, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.a = i;
        this.b = i2;
        this.c = text;
        this.d = z;
    }
}
