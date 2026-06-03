package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class p1 {
    public static final int C;
    public final int A;
    public final String B;
    public final long a;
    public final int b;
    public final String c;
    public final String d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public boolean n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final long w;
    public final int x;
    public final boolean y;
    public final long z;

    static {
        Covode.recordClassIndex(611625);
        C = 8;
    }

    public final boolean b() {
        if (this.o >= 0 && this.p >= 0 && this.q >= 0 && this.r >= 0 && this.s >= 0 && this.t >= 0) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        if (this.f >= 0 && this.g >= 0 && this.h >= 0 && this.i >= 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "UnderlineRemote(markId=" + this.a + ", markType=" + this.b + ", bookId=" + this.c + ", chapterId=" + this.d + ", startParaId=" + this.f + ", startOffsetInPara=" + this.g + ", endParaId=" + this.h + ", endOffsetInPara=" + this.i + ", chapterVersion=" + this.j + ", content=" + this.k + ", chapterTitle=" + this.l + ", volumeName=" + this.m + ", isDeleted=" + this.n + ')';
    }

    public final boolean a(p1 o) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(o, "o");
        if (b() && o.b()) {
            int i = (this.u * 1000000) + this.q;
            int i2 = (this.v * 1000000) + this.t;
            int i3 = (o.u * 1000000) + o.q;
            int i4 = (o.v * 1000000) + o.t;
            if (i3 <= i && i <= i4) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                return true;
            }
            if (i3 <= i2 && i2 <= i4) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                return true;
            }
        } else if (c() && o.c()) {
            int i5 = (this.f * 1000000) + this.g;
            int i6 = (this.h * 1000000) + this.i;
            int i7 = (o.f * 1000000) + o.g;
            int i8 = (o.h * 1000000) + o.i;
            if (i7 <= i5 && i5 <= i8) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            if (i7 <= i6 && i6 <= i8) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public p1(long j, int i, String bookId, String chapterId, int i2, int i3, int i4, int i5, int i6, String chapterVersion, String content, String chapterTitle, String volumeName, boolean z, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j2, int i15, boolean z2, long j3, int i16, String notes) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(chapterVersion, "chapterVersion");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(chapterTitle, "chapterTitle");
        Intrinsics.checkNotNullParameter(volumeName, "volumeName");
        Intrinsics.checkNotNullParameter(notes, "notes");
        this.a = j;
        this.b = i;
        this.c = bookId;
        this.d = chapterId;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
        this.j = chapterVersion;
        this.k = content;
        this.l = chapterTitle;
        this.m = volumeName;
        this.n = z;
        this.o = i7;
        this.p = i8;
        this.q = i9;
        this.r = i10;
        this.s = i11;
        this.t = i12;
        this.u = i13;
        this.v = i14;
        this.w = j2;
        this.x = i15;
        this.y = z2;
        this.z = j3;
        this.A = i16;
        this.B = notes;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ p1(long r35, int r37, java.lang.String r38, java.lang.String r39, int r40, int r41, int r42, int r43, int r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, boolean r49, int r50, int r51, int r52, int r53, int r54, int r55, int r56, int r57, long r58, int r60, boolean r61, long r62, int r64, java.lang.String r65, int r66, kotlin.jvm.internal.DefaultConstructorMarker r67) {
        /*
            r34 = this;
            r0 = 4194304(0x400000, float:5.877472E-39)
            r0 = r66 & r0
            if (r0 == 0) goto Lb
            r0 = 0
            r26 = r0
            goto Ld
        Lb:
            r26 = r58
        Ld:
            r0 = 8388608(0x800000, float:1.1754944E-38)
            r0 = r66 & r0
            r1 = 0
            if (r0 == 0) goto L17
            r28 = 0
            goto L19
        L17:
            r28 = r60
        L19:
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r0 = r66 & r0
            if (r0 == 0) goto L22
            r32 = 0
            goto L24
        L22:
            r32 = r64
        L24:
            r0 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r66 & r0
            if (r0 == 0) goto L2f
            java.lang.String r0 = ""
            r33 = r0
            goto L31
        L2f:
            r33 = r65
        L31:
            r2 = r34
            r3 = r35
            r5 = r37
            r6 = r38
            r7 = r39
            r8 = r40
            r9 = r41
            r10 = r42
            r11 = r43
            r12 = r44
            r13 = r45
            r14 = r46
            r15 = r47
            r16 = r48
            r17 = r49
            r18 = r50
            r19 = r51
            r20 = r52
            r21 = r53
            r22 = r54
            r23 = r55
            r24 = r56
            r25 = r57
            r29 = r61
            r30 = r62
            r2.<init>(r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r29, r30, r32, r33)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lr4.p1.<init>(long, int, java.lang.String, java.lang.String, int, int, int, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, int, int, int, int, int, int, int, long, int, boolean, long, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
