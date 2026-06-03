package gk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public final String a;
    public final String b;
    public final boolean c;

    static {
        Covode.recordClassIndex(607798);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return Intrinsics.areEqual(this.a, nVar.a) && Intrinsics.areEqual(this.b, nVar.b) && this.c == nVar.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + androidx.compose.animation.m.a(this.c);
    }

    public String toString() {
        return "ChannelItem(id=" + this.a + ", name=" + this.b + ", isFixed=" + this.c + ')';
    }

    public n(String id, String name, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.a = id;
        this.b = name;
        this.c = z;
    }
}
