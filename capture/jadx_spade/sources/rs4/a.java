package rs4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final String a;
    public final String b;
    public final int c;
    public final String d;
    public final boolean e;

    static {
        Covode.recordClassIndex(612460);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && this.c == aVar.c && Intrinsics.areEqual(this.d, aVar.d) && this.e == aVar.e;
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + m.a(this.e);
    }

    public String toString() {
        return "PatchAdHideEvent(planId=" + this.a + ", materialId=" + this.b + ", pageCode=" + this.c + ", type=" + this.d + ", needResumePlay=" + this.e + ')';
    }

    public final String getType() {
        return this.d;
    }

    public a(String planId, String materialId, int i, String type, boolean z) {
        Intrinsics.checkNotNullParameter(planId, "planId");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = planId;
        this.b = materialId;
        this.c = i;
        this.d = type;
        this.e = z;
    }
}
