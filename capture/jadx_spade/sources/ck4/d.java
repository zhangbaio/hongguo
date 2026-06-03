package ck4;

import ak4.l;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.x7;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class d extends b {
    public static final int r;
    public final boolean p;
    public final om0 q;

    static {
        Covode.recordClassIndex(607768);
        r = 8;
    }

    public String h() {
        String c = l.a.c(((yh4.b) this).d);
        if (c == null) {
            return String.valueOf(f());
        }
        return c;
    }

    public String a(int i) {
        return String.valueOf(f());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(x7 cellViewData, boolean z) {
        super(cellViewData);
        om0 om0Var;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(cellViewData, "cellViewData");
        this.p = z;
        List list = cellViewData.v;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            om0Var = (om0) firstOrNull;
        } else {
            om0Var = null;
        }
        this.q = om0Var;
    }

    public /* synthetic */ d(x7 x7Var, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(x7Var, (i & 2) != 0 ? false : z);
    }
}
