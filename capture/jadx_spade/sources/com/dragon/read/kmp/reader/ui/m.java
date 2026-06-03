package com.dragon.read.kmp.reader.ui;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public final String a;
    public final long b;
    public final long c;
    public final String d;
    public final long e;
    public final int f;

    static {
        Covode.recordClassIndex(608591);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return Intrinsics.areEqual(this.a, mVar.a) && this.b == mVar.b && this.c == mVar.c && Intrinsics.areEqual(this.d, mVar.d) && this.e == mVar.e && this.f == mVar.f;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + j.a(this.b)) * 31) + j.a(this.c)) * 31) + this.d.hashCode()) * 31) + j.a(this.e)) * 31) + this.f;
    }

    public String toString() {
        return "HotLineItem(bookId=" + this.a + ", digestHotLineId=" + this.b + ", digestItemId=" + this.c + ", cellAbstract=" + this.d + ", digestLineCnt=" + this.e + ", bookHotLineCount=" + this.f + ')';
    }

    public m(String bookId, long j, long j2, String cellAbstract, long j3, int i) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(cellAbstract, "cellAbstract");
        this.a = bookId;
        this.b = j;
        this.c = j2;
        this.d = cellAbstract;
        this.e = j3;
        this.f = i;
    }
}
