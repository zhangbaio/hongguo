package com.dragon.read.kmp.reader.state;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.annotation.BDExportToObjc;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public final String a;
    public final long b;
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final long n;
    public final long o;
    public final long p;
    public final String q;

    static {
        Covode.recordClassIndex(608576);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.areEqual(this.a, iVar.a) && this.b == iVar.b && Intrinsics.areEqual(this.c, iVar.c) && this.d == iVar.d && this.e == iVar.e && this.f == iVar.f && this.g == iVar.g && this.h == iVar.h && this.i == iVar.i && this.j == iVar.j && this.k == iVar.k && this.l == iVar.l && this.m == iVar.m && this.n == iVar.n && this.o == iVar.o && this.p == iVar.p && Intrinsics.areEqual(this.q, iVar.q);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.a.hashCode() * 31) + j.a(this.b)) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31) + j.a(this.n)) * 31) + j.a(this.o)) * 31) + j.a(this.p)) * 31) + this.q.hashCode();
    }

    public String toString() {
        return "KmpHotLineItem(text=" + this.a + ", highlightCount=" + this.b + ", chapterId=" + this.c + ", startParaId=" + this.d + ", startOffsetInPara=" + this.e + ", endParaId=" + this.f + ", endOffsetInPara=" + this.g + ", startContainerIndex=" + this.h + ", startElementIndex=" + this.i + ", startElementOffset=" + this.j + ", endContainerIndex=" + this.k + ", endElementIndex=" + this.l + ", endElementOffset=" + this.m + ", digestItemIndex=" + this.n + ", digestItemId=" + this.o + ", digestHotLineId=" + this.p + ", url=" + this.q + ')';
    }

    public i(String text, long j, String chapterId, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j2, long j3, long j4, String url) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(url, "url");
        this.a = text;
        this.b = j;
        this.c = chapterId;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
        this.j = i7;
        this.k = i8;
        this.l = i9;
        this.m = i10;
        this.n = j2;
        this.o = j3;
        this.p = j4;
        this.q = url;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ i(java.lang.String r23, long r24, java.lang.String r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36, long r37, long r39, long r41, java.lang.String r43, int r44, kotlin.jvm.internal.DefaultConstructorMarker r45) {
        /*
            Method dump skipped, instructions count: 178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.state.i.<init>(java.lang.String, long, java.lang.String, int, int, int, int, int, int, int, int, int, int, long, long, long, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
