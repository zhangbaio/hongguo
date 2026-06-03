package com.dragon.read.kmp.reader.state;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.annotation.BDExportToObjc;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    public final String a;
    public final String b;
    public final String c;

    static {
        Covode.recordClassIndex(608577);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return Intrinsics.areEqual(this.a, jVar.a) && Intrinsics.areEqual(this.b, jVar.b) && Intrinsics.areEqual(this.c, jVar.c);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "KmpRankAward(algoType=" + this.a + ", awardText=" + this.b + ", url=" + this.c + ')';
    }

    public j(String algoType, String str, String str2) {
        Intrinsics.checkNotNullParameter(algoType, "algoType");
        this.a = algoType;
        this.b = str;
        this.c = str2;
    }
}
