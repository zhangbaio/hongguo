package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public final String a;
    public final int b;

    static {
        Covode.recordClassIndex(608824);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual(this.a, eVar.a) && this.b == eVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public String toString() {
        return "DeleteHistoryItem(bookId=" + this.a + ", bookType=" + this.b + ')';
    }

    public e(String bookId, int i) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        this.a = bookId;
        this.b = i;
    }
}
