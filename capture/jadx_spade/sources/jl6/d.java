package jl6;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.data.AbsPlayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    public final AbsPlayList a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public boolean h;
    public String i;

    static {
        Covode.recordClassIndex(655924);
    }

    public final d a(AbsPlayList absPlayList, String str, String str2, int i, int i2, boolean z, boolean z2, boolean z3, String str3) {
        return new d(absPlayList, str, str2, i, i2, z, z2, z3, str3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (Intrinsics.areEqual(this.a, dVar.a) && Intrinsics.areEqual(this.b, dVar.b) && Intrinsics.areEqual(this.c, dVar.c)) {
                    if (this.d == dVar.d) {
                        if (this.e == dVar.e) {
                            if (this.f == dVar.f) {
                                if (this.g == dVar.g) {
                                    if (!(this.h == dVar.h) || !Intrinsics.areEqual(this.i, dVar.i)) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        AbsPlayList absPlayList = this.a;
        int hashCode = (absPlayList != null ? absPlayList.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.d) * 31) + this.e) * 31;
        boolean z = this.f;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z2 = this.g;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.h;
        int i5 = (i4 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        String str3 = this.i;
        return i5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "ReqOfPlayAddress(playList=" + this.a + ", itemId=" + this.b + ", playFrom=" + this.c + ", playTone=" + this.d + ", bgNoiseId=" + this.e + ", isPreload=" + this.f + ", isCacheEnable=" + this.g + ", needCancel=" + this.h + ", reqScene=" + this.i + ")";
    }

    public d(AbsPlayList absPlayList, String str, String str2, int i, int i2, boolean z, boolean z2, boolean z3, String str3) {
        this.a = absPlayList;
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = i2;
        this.f = z;
        this.g = z2;
        this.h = z3;
        this.i = str3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ d(com.xs.fm.player.base.play.data.AbsPlayList r14, java.lang.String r15, java.lang.String r16, int r17, int r18, boolean r19, boolean r20, boolean r21, java.lang.String r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L9
            r9 = 0
            goto Lb
        L9:
            r9 = r19
        Lb:
            r1 = r0 & 64
            if (r1 == 0) goto L12
            r1 = 1
            r10 = 1
            goto L14
        L12:
            r10 = r20
        L14:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L1a
            r11 = 0
            goto L1c
        L1a:
            r11 = r21
        L1c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L24
            java.lang.String r0 = "req_default_play"
            r12 = r0
            goto L26
        L24:
            r12 = r22
        L26:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jl6.d.<init>(com.xs.fm.player.base.play.data.AbsPlayList, java.lang.String, java.lang.String, int, int, boolean, boolean, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
