package ps3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public final ShortSeriesLaunchArgs a;
    public final boolean b;

    static {
        Covode.recordClassIndex(599034);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.areEqual(this.a, iVar.a) && this.b == iVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + m.a(this.b);
    }

    public String toString() {
        return "VideoFeedShortSeriesLaunchResult(launchArgs=" + this.a + ", enableSharePlayer=" + this.b + ')';
    }

    public i(ShortSeriesLaunchArgs launchArgs, boolean z) {
        Intrinsics.checkNotNullParameter(launchArgs, "launchArgs");
        this.a = launchArgs;
        this.b = z;
    }
}
