package gk4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import jd4.c;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f0 {
    public static final int j;
    public final String a;
    public final String b;
    public final List<h0> c;
    public final c.a d;
    public String e;
    public Integer f;
    public boolean g;
    public String h;
    public Long i;

    static {
        Covode.recordClassIndex(607825);
        j = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return Intrinsics.areEqual(this.a, f0Var.a) && Intrinsics.areEqual(this.b, f0Var.b) && Intrinsics.areEqual(this.c, f0Var.c) && Intrinsics.areEqual(this.d, f0Var.d) && Intrinsics.areEqual(this.e, f0Var.e) && Intrinsics.areEqual(this.f, f0Var.f) && this.g == f0Var.g && Intrinsics.areEqual(this.h, f0Var.h) && Intrinsics.areEqual(this.i, f0Var.i);
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        c.a aVar = this.d;
        int hashCode2 = (hashCode + (aVar == null ? 0 : aVar.hashCode())) * 31;
        String str = this.e;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.f;
        int hashCode4 = (((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + androidx.compose.animation.m.a(this.g)) * 31;
        String str2 = this.h;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.i;
        return hashCode5 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "RelationSeriesDialogModel(seriesId=" + this.a + ", vid=" + this.b + ", items=" + this.c + ", bookData=" + this.d + ", dialogTitle=" + this.e + ", nextOffset=" + this.f + ", hasMore=" + this.g + ", sessionId=" + this.h + ", cellId=" + this.i + ')';
    }

    public final boolean a() {
        boolean z;
        boolean z2 = false;
        if (this.g && this.f != null && this.h != null && this.i != null) {
            if (this.b.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z2 = true;
            }
        }
        com.dragon.read.kmp.j.a.d("RelationSeriesDialogModel", "[canLoadNextPage]=" + z2 + ", hasMore=" + this.g + ", nextOffset=" + this.f + ", sessionId=" + this.h + ", cellId=" + this.i + ", vid=" + this.b);
        return z2;
    }

    public f0(String seriesId, String vid, List<h0> items, c.a aVar, String str, Integer num, boolean z, String str2, Long l) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(items, "items");
        this.a = seriesId;
        this.b = vid;
        this.c = items;
        this.d = aVar;
        this.e = str;
        this.f = num;
        this.g = z;
        this.h = str2;
        this.i = l;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ f0(java.lang.String r13, java.lang.String r14, java.util.List r15, jd4.c.a r16, java.lang.String r17, java.lang.Integer r18, boolean r19, java.lang.String r20, java.lang.Long r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 4
            if (r1 == 0) goto Ld
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5 = r1
            goto Le
        Ld:
            r5 = r15
        Le:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L15
            r6 = r2
            goto L17
        L15:
            r6 = r16
        L17:
            r1 = r0 & 16
            if (r1 == 0) goto L1d
            r7 = r2
            goto L1f
        L1d:
            r7 = r17
        L1f:
            r1 = r0 & 32
            if (r1 == 0) goto L25
            r8 = r2
            goto L27
        L25:
            r8 = r18
        L27:
            r1 = r0 & 64
            if (r1 == 0) goto L2e
            r1 = 0
            r9 = 0
            goto L30
        L2e:
            r9 = r19
        L30:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L36
            r10 = r2
            goto L38
        L36:
            r10 = r20
        L38:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L3e
            r11 = r2
            goto L40
        L3e:
            r11 = r21
        L40:
            r2 = r12
            r3 = r13
            r4 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gk4.f0.<init>(java.lang.String, java.lang.String, java.util.List, jd4.c$a, java.lang.String, java.lang.Integer, boolean, java.lang.String, java.lang.Long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
