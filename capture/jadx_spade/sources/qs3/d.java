package qs3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public final long a;
    public boolean b;

    static {
        Covode.recordClassIndex(599048);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a == dVar.a && this.b == dVar.b;
    }

    public int hashCode() {
        return (j.a(this.a) * 31) + m.a(this.b);
    }

    public String toString() {
        return "ShortSeriesActivityFinishEvent(timeStamp=" + this.a + ", isSeriesAttribute=" + this.b + ')';
    }

    public d(long j, boolean z) {
        this.a = j;
        this.b = z;
    }

    public /* synthetic */ d(long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? false : z);
    }
}
