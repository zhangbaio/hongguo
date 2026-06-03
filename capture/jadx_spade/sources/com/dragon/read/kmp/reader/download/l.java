package com.dragon.read.kmp.reader.download;

import com.bytedance.covode.number.Covode;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    public static final int f;
    public final Set<String> a;
    public final String b;
    public final String c;
    public int d;
    public int e;

    static {
        Covode.recordClassIndex(608414);
        f = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Intrinsics.areEqual(this.a, lVar.a) && Intrinsics.areEqual(this.b, lVar.b) && Intrinsics.areEqual(this.c, lVar.c) && this.d == lVar.d && this.e == lVar.e;
    }

    public int hashCode() {
        Set<String> set = this.a;
        int hashCode = (set == null ? 0 : set.hashCode()) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        return "EpubChapterImageTask(imageSource=" + this.a + ", bookId=" + this.b + ", chapterId=" + this.c + ", unfinishedSize=" + this.d + ", finishedSize=" + this.e + ')';
    }

    public l(Set<String> set, String str, String str2, int i, int i2) {
        this.a = set;
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ l(java.util.Set r8, java.lang.String r9, java.lang.String r10, int r11, int r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto L7
            r3 = r0
            goto L8
        L7:
            r3 = r9
        L8:
            r9 = r13 & 4
            if (r9 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r10
        Lf:
            r9 = r13 & 8
            r10 = 0
            if (r9 == 0) goto L16
            r5 = 0
            goto L17
        L16:
            r5 = r11
        L17:
            r9 = r13 & 16
            if (r9 == 0) goto L1d
            r6 = 0
            goto L1e
        L1d:
            r6 = r12
        L1e:
            r1 = r7
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.l.<init>(java.util.Set, java.lang.String, java.lang.String, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
