package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final String a;
    public final int b;

    static {
        Covode.recordClassIndex(608819);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public String toString() {
        return "AddBookshelfItem(itemId=" + this.a + ", bookType=" + this.b + ')';
    }

    public a(String itemId, int i) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.a = itemId;
        this.b = i;
    }
}
