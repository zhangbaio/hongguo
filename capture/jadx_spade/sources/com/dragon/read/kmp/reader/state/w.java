package com.dragon.read.kmp.reader.state;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.annotation.BDExportToObjc;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w {
    public static final int e = 0;
    public final String a;
    public final String b;
    public final boolean c;
    public final TagStyle d;

    static {
        Covode.recordClassIndex(608587);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return Intrinsics.areEqual(this.a, wVar.a) && Intrinsics.areEqual(this.b, wVar.b) && this.c == wVar.c && this.d == wVar.d;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + androidx.compose.animation.m.a(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "TagItemKmp(text=" + this.a + ", url=" + this.b + ", highlighted=" + this.c + ", style=" + this.d + ')';
    }

    public w(String text, String str, boolean z, TagStyle style) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        this.a = text;
        this.b = str;
        this.c = z;
        this.d = style;
    }
}
