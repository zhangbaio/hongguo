package an6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a implements Comparable<a> {
    public final int a;
    public final int b;

    static {
        Covode.recordClassIndex(659582);
    }

    public int hashCode() {
        throw new UnsupportedOperationException("DecimalFraction is not supposed to be used as a hash key");
    }

    public String toString() {
        String removePrefix;
        StringBuilder sb = new StringBuilder();
        int i = d.b()[this.b];
        sb.append(this.a / i);
        sb.append('.');
        removePrefix = StringsKt__StringsKt.removePrefix(String.valueOf(i + (this.a % i)), (CharSequence) "1");
        sb.append(removePrefix);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof a) && compareTo((a) obj) == 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int max = Math.max(this.b, other.b);
        return Intrinsics.compare(b(max), other.b(max));
    }

    public final int b(int i) {
        int i2 = this.b;
        if (i == i2) {
            return this.a;
        }
        if (i > i2) {
            return d.b()[i - this.b] * this.a;
        }
        return this.a / d.b()[this.b - i];
    }

    public a(int i, int i2) {
        boolean z;
        this.a = i;
        this.b = i2;
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("Digits must be non-negative, but was " + i2).toString());
    }
}
