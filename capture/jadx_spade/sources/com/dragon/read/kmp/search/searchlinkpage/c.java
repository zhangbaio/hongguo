package com.dragon.read.kmp.search.searchlinkpage;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c extends d0 {
    public static final int g;
    public final String e;
    public final List<List<Long>> f;

    static {
        Covode.recordClassIndex(608788);
        g = 8;
    }

    @Override // com.dragon.read.kmp.search.searchlinkpage.d0
    public String a() {
        return "";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.e, cVar.e) && Intrinsics.areEqual(this.f, cVar.f);
    }

    public int hashCode() {
        return (this.e.hashCode() * 31) + this.f.hashCode();
    }

    public String toString() {
        return "SearchItemModel(text=" + this.e + ", range=" + this.f + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(String text, List<? extends List<Long>> range) {
        super(false, null, false, 7, null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        this.e = text;
        this.f = range;
    }
}
