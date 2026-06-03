package is3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    public final String a;
    public final int b;
    public final int c;

    static {
        Covode.recordClassIndex(598928);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return Intrinsics.areEqual(this.a, tVar.a) && this.b == tVar.b && this.c == tVar.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return "PreloadManagerConfig(scene=" + this.a + ", maxPreloadCount=" + this.b + ", timeoutMill=" + this.c + ')';
    }

    public t(String scene, int i, int i2) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.a = scene;
        this.b = i;
        this.c = i2;
    }

    public /* synthetic */ t(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? Integer.MAX_VALUE : i, (i3 & 4) != 0 ? 180000 : i2);
    }
}
