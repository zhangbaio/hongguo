package gk4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m0<T> {
    public final List<T> a;

    static {
        Covode.recordClassIndex(607842);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m0) && Intrinsics.areEqual(this.a, ((m0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "StableListHolder(value=" + this.a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m0(List<? extends T> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = value;
    }
}
