package com.dragon.read.kmp.reader.detail;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t2 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final Integer f;
    public final String g;

    static {
        Covode.recordClassIndex(608374);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t2)) {
            return false;
        }
        t2 t2Var = (t2) obj;
        return Intrinsics.areEqual(this.a, t2Var.a) && Intrinsics.areEqual(this.b, t2Var.b) && Intrinsics.areEqual(this.c, t2Var.c) && this.d == t2Var.d && Intrinsics.areEqual(this.e, t2Var.e) && Intrinsics.areEqual(this.f, t2Var.f) && Intrinsics.areEqual(this.g, t2Var.g);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + androidx.compose.animation.m.a(this.d)) * 31) + this.e.hashCode()) * 31;
        Integer num = this.f;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.g;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "MetaRowScore(score=" + this.a + ", bookId=" + this.b + ", bookName=" + this.c + ", isNoCopyright=" + this.d + ", label=" + this.e + ", scoreCnt=" + this.f + ", scoreText=" + this.g + ')';
    }

    public t2(String score, String bookId, String str, boolean z, String label, Integer num, String str2) {
        Intrinsics.checkNotNullParameter(score, "score");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(label, "label");
        this.a = score;
        this.b = bookId;
        this.c = str;
        this.d = z;
        this.e = label;
        this.f = num;
        this.g = str2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ t2(java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13, java.lang.String r14, java.lang.Integer r15, java.lang.String r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17 & 16
            if (r0 == 0) goto L9
            java.lang.String r0 = "评分"
            r6 = r0
            goto La
        L9:
            r6 = r14
        La:
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r7 = r15
            r8 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.t2.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
