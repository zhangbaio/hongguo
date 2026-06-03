package com.dragon.read.kmp.search.searchlinkpage;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.x7;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f0 extends d0 {
    public static final int f;
    public final x7 e;

    static {
        Covode.recordClassIndex(608795);
        f = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f0) && Intrinsics.areEqual(this.e, ((f0) obj).e);
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public String toString() {
        return "VideoCardModel(cellViewData=" + this.e + ')';
    }

    @Override // com.dragon.read.kmp.search.searchlinkpage.d0
    public String a() {
        om0 om0Var;
        String str;
        List list = this.e.v;
        if (list == null || (om0Var = (om0) list.get(0)) == null || (str = om0Var.p) == null) {
            return "";
        }
        return str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(x7 cellViewData) {
        super(false, null, false, 7, null);
        Intrinsics.checkNotNullParameter(cellViewData, "cellViewData");
        this.e = cellViewData;
    }
}
