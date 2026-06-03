package com.dragon.read.kmp.reader.detail.widget;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.d1;
import com.bytedance.kmp.reading.model.om0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int e;
    public final String a;
    public final d1 b;
    public final om0 c;
    public final boolean d;

    static {
        Covode.recordClassIndex(608398);
        e = 8;
    }

    public String toString() {
        return "BookDetailCoverItem(bookId=" + this.a + ", apiBookInfo=" + this.b + ", videoData=" + this.c + ", isBookTypeEnabled=" + this.d + ')';
    }

    public int hashCode() {
        int i;
        int a = ((androidx.compose.animation.m.a(this.d) * 31) + this.a.hashCode()) * 31;
        d1 d1Var = this.b;
        int i2 = 0;
        if (d1Var != null) {
            i = d1Var.hashCode();
        } else {
            i = 0;
        }
        int i3 = (a + i) * 31;
        om0 om0Var = this.c;
        if (om0Var != null) {
            i2 = om0Var.hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.d == aVar.d && Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c)) {
            return true;
        }
        return false;
    }

    public a(String bookId, d1 d1Var, om0 om0Var, boolean z) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        this.a = bookId;
        this.b = d1Var;
        this.c = om0Var;
        this.d = z;
    }

    public /* synthetic */ a(String str, d1 d1Var, om0 om0Var, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : d1Var, (i & 4) != 0 ? null : om0Var, (i & 8) != 0 ? false : z);
    }
}
