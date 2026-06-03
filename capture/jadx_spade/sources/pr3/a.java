package pr3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final int a;
    public final Object b;

    static {
        Covode.recordClassIndex(598761);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && Intrinsics.areEqual(this.b, aVar.b);
    }

    public int hashCode() {
        int i = this.a * 31;
        Object obj = this.b;
        return i + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "CommonLayerEvent(type=" + this.a + ", params=" + this.b + ')';
    }

    public final int getType() {
        return this.a;
    }

    public a(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public /* synthetic */ a(int i, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : obj);
    }
}
