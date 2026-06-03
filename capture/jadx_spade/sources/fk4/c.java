package fk4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.mine.model.l;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final int b;
    public final List<l> a;

    static {
        Covode.recordClassIndex(607788);
        b = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final c a(List<l> list) {
        return new c(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Intrinsics.areEqual(this.a, ((c) obj).a);
    }

    public int hashCode() {
        List<l> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "SideBarPageParams(functionModels=" + this.a + ')';
    }

    public c(List<l> list) {
        this.a = list;
    }

    public /* synthetic */ c(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }
}
