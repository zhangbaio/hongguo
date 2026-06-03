package com.dragon.read.kmp.profile.component;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.bm0;
import com.bytedance.kmp.reading.model.vl0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class r {
    public final vl0 a;
    public final dl4.e b;
    public final String c;
    public final bm0 d;
    public final boolean e;

    static {
        Covode.recordClassIndex(608040);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Intrinsics.areEqual(this.a, rVar.a) && Intrinsics.areEqual(this.b, rVar.b) && Intrinsics.areEqual(this.c, rVar.c) && Intrinsics.areEqual(this.d, rVar.d) && this.e == rVar.e;
    }

    public int hashCode() {
        vl0 vl0Var = this.a;
        int hashCode = (vl0Var == null ? 0 : vl0Var.hashCode()) * 31;
        dl4.e eVar = this.b;
        int hashCode2 = (hashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
        String str = this.c;
        return ((((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.d.hashCode()) * 31) + androidx.compose.animation.m.a(this.e);
    }

    public String toString() {
        return "TagData(iconInfo=" + this.a + ", rankLabel=" + this.b + ", schema=" + this.c + ", titleInfo=" + this.d + ", useLabel=" + this.e + ')';
    }

    public r(vl0 vl0Var, dl4.e eVar, String str, bm0 titleInfo, boolean z) {
        Intrinsics.checkNotNullParameter(titleInfo, "titleInfo");
        this.a = vl0Var;
        this.b = eVar;
        this.c = str;
        this.d = titleInfo;
        this.e = z;
    }
}
