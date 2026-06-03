package qs3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public final boolean a;

    static {
        Covode.recordClassIndex(599053);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.a == ((i) obj).a;
    }

    public int hashCode() {
        return m.a(this.a);
    }

    public String toString() {
        return "VideoMorePanelDialogEvent(show=" + this.a + ')';
    }

    public i(boolean z) {
        this.a = z;
    }
}
