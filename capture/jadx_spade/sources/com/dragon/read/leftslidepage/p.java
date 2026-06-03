package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public final FunctionItemType a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    static {
        Covode.recordClassIndex(611263);
    }

    public p() {
        this(null, null, null, null, null, 31, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.a == pVar.a && Intrinsics.areEqual(this.b, pVar.b) && Intrinsics.areEqual(this.c, pVar.c) && Intrinsics.areEqual(this.d, pVar.d) && Intrinsics.areEqual(this.e, pVar.e);
    }

    public int hashCode() {
        int hashCode = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String str = this.e;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SidebarFuncItemData(type=" + this.a + ", name=" + this.b + ", iconUrl=" + this.c + ", darkIconUrl=" + this.d + ", moreText=" + this.e + ')';
    }

    public final FunctionItemType getType() {
        return this.a;
    }

    public p(FunctionItemType type, String name, String iconUrl, String darkIconUrl, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(darkIconUrl, "darkIconUrl");
        this.a = type;
        this.b = name;
        this.c = iconUrl;
        this.d = darkIconUrl;
        this.e = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ p(com.dragon.read.leftslidepage.FunctionItemType r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L6
            com.dragon.read.leftslidepage.FunctionItemType r4 = com.dragon.read.leftslidepage.FunctionItemType.RESERVE
        L6:
            r10 = r9 & 2
            java.lang.String r0 = ""
            if (r10 == 0) goto Le
            r10 = r0
            goto Lf
        Le:
            r10 = r5
        Lf:
            r5 = r9 & 4
            if (r5 == 0) goto L15
            r1 = r0
            goto L16
        L15:
            r1 = r6
        L16:
            r5 = r9 & 8
            if (r5 == 0) goto L1b
            goto L1c
        L1b:
            r0 = r7
        L1c:
            r5 = r9 & 16
            if (r5 == 0) goto L21
            r8 = 0
        L21:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r0
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.p.<init>(com.dragon.read.leftslidepage.FunctionItemType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
