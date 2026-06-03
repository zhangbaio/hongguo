package qs3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public final boolean a;

    static {
        Covode.recordClassIndex(599052);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.a == ((h) obj).a;
    }

    public int hashCode() {
        return m.a(this.a);
    }

    public String toString() {
        return "VideoFeedTabLongPressSpeedEvent(isCancel=" + this.a + ')';
    }

    public h(boolean z) {
        this.a = z;
    }
}
