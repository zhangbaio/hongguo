package vn4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int c;
    public final boolean a;
    public final List<c> b;

    static {
        Covode.recordClassIndex(608942);
        c = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && Intrinsics.areEqual(this.b, bVar.b);
    }

    public int hashCode() {
        return (m.a(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SharePosterContent(supportQRVisibleSwitch=" + this.a + ", posterImages=" + this.b + ')';
    }

    public b(boolean z, List<c> posterImages) {
        Intrinsics.checkNotNullParameter(posterImages, "posterImages");
        this.a = z;
        this.b = posterImages;
    }

    public /* synthetic */ b(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
