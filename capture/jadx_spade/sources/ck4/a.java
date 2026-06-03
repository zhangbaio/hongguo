package ck4;

import ak4.l;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.d1;
import com.bytedance.kmp.reading.model.x7;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends b {
    public static final int q;
    public final d1 p;

    static {
        Covode.recordClassIndex(607763);
        q = 8;
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
    public a(x7 cellViewData) {
        super(cellViewData);
        d1 d1Var;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(cellViewData, "cellViewData");
        List list = cellViewData.w;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            d1Var = (d1) firstOrNull;
        } else {
            d1Var = null;
        }
        this.p = d1Var;
    }
}
