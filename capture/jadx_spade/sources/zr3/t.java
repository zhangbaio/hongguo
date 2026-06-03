package zr3;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    public final int a;
    public final int b;

    static {
        Covode.recordClassIndex(598874);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.a == tVar.a && this.b == tVar.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "ProgressHighlightDragInfo(startTrackIndex=" + this.a + ", endTrackIndex=" + this.b + ')';
    }

    public t(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
