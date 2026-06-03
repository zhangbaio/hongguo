package im4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public final String a;
    public final String b;
    public final long c;
    public final boolean d;
    public final boolean e;
    public final String f;
    public final String g;
    public final boolean h;
    public final String i;
    public final boolean j;
    public final boolean k;

    static {
        Covode.recordClassIndex(608464);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b) && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && Intrinsics.areEqual(this.f, bVar.f) && Intrinsics.areEqual(this.g, bVar.g) && this.h == bVar.h && Intrinsics.areEqual(this.i, bVar.i) && this.j == bVar.j && this.k == bVar.k;
    }

    public int hashCode() {
        int hashCode = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + j.a(this.c)) * 31) + m.a(this.d)) * 31) + m.a(this.e)) * 31;
        String str = this.f;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        return ((((((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + m.a(this.h)) * 31) + this.i.hashCode()) * 31) + m.a(this.j)) * 31) + m.a(this.k);
    }

    public String toString() {
        return "KmpRequestArgs(bookId=" + this.a + ", chapterId=" + this.b + ", toneId=" + this.c + ", isAudio=" + this.d + ", isLocalBook=" + this.e + ", version=" + this.f + ", contentMd5=" + this.g + ", isContentNewCoordinate=" + this.h + ", from=" + this.i + ", enableNetCache=" + this.j + ", forceRequestNet=" + this.k + ')';
    }

    public b(String bookId, String chapterId, long j, boolean z, boolean z2, String str, String str2, boolean z3, String from, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(from, "from");
        this.a = bookId;
        this.b = chapterId;
        this.c = j;
        this.d = z;
        this.e = z2;
        this.f = str;
        this.g = str2;
        this.h = z3;
        this.i = from;
        this.j = z4;
        this.k = z5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ b(java.lang.String r17, java.lang.String r18, long r19, boolean r21, boolean r22, java.lang.String r23, java.lang.String r24, boolean r25, java.lang.String r26, boolean r27, boolean r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L9
            r10 = r2
            goto Lb
        L9:
            r10 = r23
        Lb:
            r1 = r0 & 64
            if (r1 == 0) goto L11
            r11 = r2
            goto L13
        L11:
            r11 = r24
        L13:
            r1 = r0 & 128(0x80, float:1.8E-43)
            r2 = 0
            if (r1 == 0) goto L1a
            r12 = 0
            goto L1c
        L1a:
            r12 = r25
        L1c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L24
            java.lang.String r1 = ""
            r13 = r1
            goto L26
        L24:
            r13 = r26
        L26:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L2d
            r1 = 1
            r14 = 1
            goto L2f
        L2d:
            r14 = r27
        L2f:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L35
            r15 = 0
            goto L37
        L35:
            r15 = r28
        L37:
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r8 = r21
            r9 = r22
            r3.<init>(r4, r5, r6, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: im4.b.<init>(java.lang.String, java.lang.String, long, boolean, boolean, java.lang.String, java.lang.String, boolean, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
