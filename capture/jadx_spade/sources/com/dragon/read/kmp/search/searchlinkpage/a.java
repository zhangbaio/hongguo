package com.dragon.read.kmp.search.searchlinkpage;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.d1;
import com.bytedance.kmp.reading.model.x7;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends d0 {
    public static final int f;
    public final x7 e;

    static {
        Covode.recordClassIndex(608786);
        f = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && Intrinsics.areEqual(this.e, ((a) obj).e);
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public String toString() {
        return "BookCardModel(cellViewData=" + this.e + ')';
    }

    @Override // com.dragon.read.kmp.search.searchlinkpage.d0
    public String a() {
        d1 d1Var;
        String str;
        List list = this.e.w;
        if (list == null || (d1Var = (d1) list.get(0)) == null || (str = d1Var.c) == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(x7 cellViewData) {
        super(false, null, false, 7, null);
        Intrinsics.checkNotNullParameter(cellViewData, "cellViewData");
        this.e = cellViewData;
    }
}
