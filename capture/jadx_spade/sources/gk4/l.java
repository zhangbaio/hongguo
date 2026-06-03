package gk4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    public final boolean a;
    public final String b;
    public final boolean c;

    static {
        Covode.recordClassIndex(607796);
    }

    public static /* synthetic */ l b(l lVar, boolean z, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = lVar.a;
        }
        if ((i & 2) != 0) {
            str = lVar.b;
        }
        if ((i & 4) != 0) {
            z2 = lVar.c;
        }
        return lVar.a(z, str, z2);
    }

    public final l a(boolean z, String resource, boolean z2) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        return new l(z, resource, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.a == lVar.a && Intrinsics.areEqual(this.b, lVar.b) && this.c == lVar.c;
    }

    public int hashCode() {
        return (((androidx.compose.animation.m.a(this.a) * 31) + this.b.hashCode()) * 31) + androidx.compose.animation.m.a(this.c);
    }

    public String toString() {
        return "BsEditStatusInfo(isEditMode=" + this.a + ", resource=" + this.b + ", isEditBook=" + this.c + ')';
    }

    public l(boolean z, String resource, boolean z2) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.a = z;
        this.b = resource;
        this.c = z2;
    }
}
