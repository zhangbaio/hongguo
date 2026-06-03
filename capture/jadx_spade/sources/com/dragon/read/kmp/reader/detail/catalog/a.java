package com.dragon.read.kmp.reader.detail.catalog;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final Integer f;
    public final boolean g;

    static {
        Covode.recordClassIndex(608377);
    }

    public static /* synthetic */ a b(a aVar, String str, String str2, String str3, String str4, boolean z, Integer num, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aVar.a;
        }
        if ((i & 2) != 0) {
            str2 = aVar.b;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = aVar.c;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = aVar.d;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = aVar.e;
        }
        boolean z3 = z;
        if ((i & 32) != 0) {
            num = aVar.f;
        }
        Integer num2 = num;
        if ((i & 64) != 0) {
            z2 = aVar.g;
        }
        return aVar.a(str, str5, str6, str7, z3, num2, z2);
    }

    public final a a(String bookId, String chapterId, String title, String str, boolean z, Integer num, boolean z2) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(title, "title");
        return new a(bookId, chapterId, title, str, z, num, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && this.e == aVar.e && Intrinsics.areEqual(this.f, aVar.f) && this.g == aVar.g;
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + androidx.compose.animation.m.a(this.e)) * 31;
        Integer num = this.f;
        return ((hashCode2 + (num != null ? num.hashCode() : 0)) * 31) + androidx.compose.animation.m.a(this.g);
    }

    public String toString() {
        return "BookDetailCatalogChapter(bookId=" + this.a + ", chapterId=" + this.b + ", title=" + this.c + ", volumeName=" + this.d + ", locked=" + this.e + ", readProgressPercent=" + this.f + ", isVolume=" + this.g + ')';
    }

    public a(String bookId, String chapterId, String title, String str, boolean z, Integer num, boolean z2) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(title, "title");
        this.a = bookId;
        this.b = chapterId;
        this.c = title;
        this.d = str;
        this.e = z;
        this.f = num;
        this.g = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, boolean r15, java.lang.Integer r16, boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 16
            r1 = 0
            if (r0 == 0) goto L7
            r7 = 0
            goto L8
        L7:
            r7 = r15
        L8:
            r0 = r18 & 32
            if (r0 == 0) goto Lf
            r0 = 0
            r8 = r0
            goto L11
        Lf:
            r8 = r16
        L11:
            r0 = r18 & 64
            if (r0 == 0) goto L17
            r9 = 0
            goto L19
        L17:
            r9 = r17
        L19:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.catalog.a.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.Integer, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
