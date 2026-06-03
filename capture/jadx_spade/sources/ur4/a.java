package ur4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.model.BottomTabBarItemType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final BottomTabBarItemType a;

    static {
        Covode.recordClassIndex(611951);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.a == ((a) obj).a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "OnMainTabClickEvent(itemType=" + this.a + ')';
    }

    public a(BottomTabBarItemType itemType) {
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        this.a = itemType;
    }
}
