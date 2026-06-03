package pq3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    public final String a;
    public final boolean b;
    public final int c;
    public final boolean d;

    static {
        Covode.recordClassIndex(598236);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return Intrinsics.areEqual(this.a, jVar.a) && this.b == jVar.b && this.c == jVar.c && this.d == jVar.d;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + androidx.compose.animation.m.a(this.b)) * 31) + this.c) * 31) + androidx.compose.animation.m.a(this.d);
    }

    public String toString() {
        return "PeakDownConfig(peakDownShiftResolution=" + this.a + ", srOpenState=" + this.b + ", resolutionInPeakMinEpisodeIndex=" + this.c + ", inPeakPeriodByServer=" + this.d + ')';
    }

    public j(String peakDownShiftResolution, boolean z, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(peakDownShiftResolution, "peakDownShiftResolution");
        this.a = peakDownShiftResolution;
        this.b = z;
        this.c = i;
        this.d = z2;
    }
}
