package com.dragon.read.kmp.shortvideo.distribution.infinite;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.p90;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public final String a;
    public final p90 b;
    public final String c;
    public final Integer d;
    public final g e;
    public final g f;

    static {
        Covode.recordClassIndex(609025);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.a, dVar.a) && Intrinsics.areEqual(this.b, dVar.b) && Intrinsics.areEqual(this.c, dVar.c) && Intrinsics.areEqual(this.d, dVar.d) && Intrinsics.areEqual(this.e, dVar.e) && Intrinsics.areEqual(this.f, dVar.f);
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        Integer num = this.d;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        g gVar = this.e;
        int hashCode3 = (hashCode2 + (gVar == null ? 0 : gVar.hashCode())) * 31;
        g gVar2 = this.f;
        return hashCode3 + (gVar2 != null ? gVar2.hashCode() : 0);
    }

    public String toString() {
        return "FilterItem(type=" + this.a + ", selectorItem=" + this.b + ", rowName=" + this.c + ", rankListStructStyle=" + this.d + ", panelFilterData=" + this.e + ", backgroundFilterData=" + this.f + ')';
    }

    public final String getType() {
        return this.a;
    }

    public d(String type, p90 selectorItem, String rowName, Integer num, g gVar, g gVar2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(selectorItem, "selectorItem");
        Intrinsics.checkNotNullParameter(rowName, "rowName");
        this.a = type;
        this.b = selectorItem;
        this.c = rowName;
        this.d = num;
        this.e = gVar;
        this.f = gVar2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ d(java.lang.String r8, com.bytedance.kmp.reading.model.p90 r9, java.lang.String r10, java.lang.Integer r11, com.dragon.read.kmp.shortvideo.distribution.infinite.g r12, com.dragon.read.kmp.shortvideo.distribution.infinite.g r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 4
            if (r15 == 0) goto L6
            java.lang.String r10 = ""
        L6:
            r3 = r10
            r10 = r14 & 8
            r15 = 0
            if (r10 == 0) goto Le
            r4 = r15
            goto Lf
        Le:
            r4 = r11
        Lf:
            r10 = r14 & 16
            if (r10 == 0) goto L15
            r5 = r15
            goto L16
        L15:
            r5 = r12
        L16:
            r10 = r14 & 32
            if (r10 == 0) goto L1c
            r6 = r15
            goto L1d
        L1c:
            r6 = r13
        L1d:
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.infinite.d.<init>(java.lang.String, com.bytedance.kmp.reading.model.p90, java.lang.String, java.lang.Integer, com.dragon.read.kmp.shortvideo.distribution.infinite.g, com.dragon.read.kmp.shortvideo.distribution.infinite.g, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
