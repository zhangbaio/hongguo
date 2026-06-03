package wr3;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final List<Pair<String, Boolean>> a;

    static {
        Covode.recordClassIndex(598835);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ReserveStateChangeEvent(reserveStateList=" + this.a + ')';
    }

    public a(List<Pair<String, Boolean>> reserveStateList) {
        Intrinsics.checkNotNullParameter(reserveStateList, "reserveStateList");
        this.a = reserveStateList;
    }
}
