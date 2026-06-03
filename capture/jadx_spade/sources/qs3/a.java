package qs3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final boolean a;

    static {
        Covode.recordClassIndex(599044);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.a == ((a) obj).a;
    }

    public int hashCode() {
        return m.a(this.a);
    }

    public String toString() {
        return "CloseSplitScreenEvent(isNeedClose=" + this.a + ')';
    }

    public a(boolean z) {
        this.a = z;
    }
}
