package dn4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j0 {
    public static final int k;
    public final int a;
    public final String b;
    public final String c;
    public final g d;
    public final String e;
    public final List<List<Integer>> f;
    public final String g;
    public final String h;
    public final int i;
    public final int j;

    static {
        Covode.recordClassIndex(608753);
        k = 8;
    }

    public j0() {
        this(0, null, null, null, null, null, null, null, 0, 0, 1023, null);
    }

    public final j0 a(int i, String cover, String tagText, g gVar, String title, List<? extends List<Integer>> list, String subTitle, String buttonText, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(tagText, "tagText");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        return new j0(i, cover, tagText, gVar, title, list, subTitle, buttonText, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return this.a == j0Var.a && Intrinsics.areEqual(this.b, j0Var.b) && Intrinsics.areEqual(this.c, j0Var.c) && Intrinsics.areEqual(this.d, j0Var.d) && Intrinsics.areEqual(this.e, j0Var.e) && Intrinsics.areEqual(this.f, j0Var.f) && Intrinsics.areEqual(this.g, j0Var.g) && Intrinsics.areEqual(this.h, j0Var.h) && this.i == j0Var.i && this.j == j0Var.j;
    }

    public int hashCode() {
        int hashCode = ((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        g gVar = this.d;
        int hashCode2 = (((hashCode + (gVar == null ? 0 : gVar.hashCode())) * 31) + this.e.hashCode()) * 31;
        List<List<Integer>> list = this.f;
        return ((((((((hashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i) * 31) + this.j;
    }

    public String toString() {
        return "IpSubscribeVideoCardModel(index=" + this.a + ", cover=" + this.b + ", tagText=" + this.c + ", tagBg=" + this.d + ", title=" + this.e + ", titleHighLight=" + this.f + ", subTitle=" + this.g + ", buttonText=" + this.h + ", buttonTextColor=" + this.i + ", buttonBgColor=" + this.j + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j0(int i, String cover, String tagText, g gVar, String title, List<? extends List<Integer>> list, String subTitle, String buttonText, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(tagText, "tagText");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        this.a = i;
        this.b = cover;
        this.c = tagText;
        this.d = gVar;
        this.e = title;
        this.f = list;
        this.g = subTitle;
        this.h = buttonText;
        this.i = i2;
        this.j = i3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ j0(int r12, java.lang.String r13, java.lang.String r14, dn4.g r15, java.lang.String r16, java.util.List r17, java.lang.String r18, java.lang.String r19, int r20, int r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = 0
            goto La
        L9:
            r1 = r12
        La:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L12
            r3 = r4
            goto L13
        L12:
            r3 = r13
        L13:
            r5 = r0 & 4
            if (r5 == 0) goto L19
            r5 = r4
            goto L1a
        L19:
            r5 = r14
        L1a:
            r6 = r0 & 8
            r7 = 0
            if (r6 == 0) goto L21
            r6 = r7
            goto L22
        L21:
            r6 = r15
        L22:
            r8 = r0 & 16
            if (r8 == 0) goto L28
            r8 = r4
            goto L2a
        L28:
            r8 = r16
        L2a:
            r9 = r0 & 32
            if (r9 == 0) goto L2f
            goto L31
        L2f:
            r7 = r17
        L31:
            r9 = r0 & 64
            if (r9 == 0) goto L37
            r9 = r4
            goto L39
        L37:
            r9 = r18
        L39:
            r10 = r0 & 128(0x80, float:1.8E-43)
            if (r10 == 0) goto L3e
            goto L40
        L3e:
            r4 = r19
        L40:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L46
            r10 = -1
            goto L48
        L46:
            r10 = r20
        L48:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L4d
            goto L4f
        L4d:
            r2 = r21
        L4f:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r5
            r16 = r6
            r17 = r8
            r18 = r7
            r19 = r9
            r20 = r4
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dn4.j0.<init>(int, java.lang.String, java.lang.String, dn4.g, java.lang.String, java.util.List, java.lang.String, java.lang.String, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
