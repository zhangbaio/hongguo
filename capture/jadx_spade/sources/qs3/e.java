package qs3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public final boolean a;

    static {
        Covode.recordClassIndex(599049);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.a == ((e) obj).a;
    }

    public int hashCode() {
        return m.a(this.a);
    }

    public String toString() {
        return "SplitStatusChangeEvent(isSplitStatusOpen=" + this.a + ')';
    }

    public e(boolean z) {
        this.a = z;
    }
}
