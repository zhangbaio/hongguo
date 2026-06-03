package com.dragon.read.kmp.search.searchlinkpage;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final int b;
    public final List<d0> a;

    static {
        Covode.recordClassIndex(608789);
        b = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && Intrinsics.areEqual(this.a, ((d) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "SearchLinkCardData(cardList=" + this.a + ')';
    }

    public d(List<d0> cardList) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        this.a = cardList;
    }
}
