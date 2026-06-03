package com.dragon.read.kmp.reader.state;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.annotation.BDExportToObjc;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h {
    public static final int e = 0;
    public final String a;
    public final String b;
    public final boolean c;
    public final String d;

    static {
        Covode.recordClassIndex(608575);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Intrinsics.areEqual(this.a, hVar.a) && Intrinsics.areEqual(this.b, hVar.b) && this.c == hVar.c && Intrinsics.areEqual(this.d, hVar.d);
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + androidx.compose.animation.m.a(this.c)) * 31;
        String str = this.d;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "KmpCopyrightItem(label=" + this.a + ", value=" + this.b + ", clickable=" + this.c + ", url=" + this.d + ')';
    }

    public h(String label, String value, boolean z, String str) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = label;
        this.b = value;
        this.c = z;
        this.d = str;
    }

    public /* synthetic */ h(String str, String str2, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3);
    }
}
