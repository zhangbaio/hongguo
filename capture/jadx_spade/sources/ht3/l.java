package ht3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    public final boolean a;

    static {
        Covode.recordClassIndex(599226);
    }

    public l() {
        this(false, 1, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && this.a == ((l) obj).a;
    }

    public int hashCode() {
        return androidx.compose.animation.m.a(this.a);
    }

    public String toString() {
        return "ShortSeriesRetainToSeriesFeedTabEvent(autoRefresh=" + this.a + ')';
    }

    public l(boolean z) {
        this.a = z;
    }

    public /* synthetic */ l(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
