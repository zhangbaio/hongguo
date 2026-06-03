package ht3;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    public static final int c;
    public final List<Pair<String, Boolean>> a;
    public final boolean b;

    static {
        Covode.recordClassIndex(599224);
        c = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return Intrinsics.areEqual(this.a, jVar.a) && this.b == jVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + androidx.compose.animation.m.a(this.b);
    }

    public String toString() {
        return "SeriesFollowUpdateEvent(followUpdateList=" + this.a + ", isFakeSuccess=" + this.b + ')';
    }

    public j(List<Pair<String, Boolean>> followUpdateList, boolean z) {
        Intrinsics.checkNotNullParameter(followUpdateList, "followUpdateList");
        this.a = followUpdateList;
        this.b = z;
    }

    public /* synthetic */ j(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? false : z);
    }
}
