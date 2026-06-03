package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {
    public final String a;
    public final String b;
    public final String c;
    public final long d;
    public final String e;
    public final String f;
    public final int g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final int l;

    static {
        Covode.recordClassIndex(611255);
    }

    public k() {
        this(null, null, null, 0L, null, null, 0, null, null, null, null, 0, 4095, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Intrinsics.areEqual(this.a, kVar.a) && Intrinsics.areEqual(this.b, kVar.b) && Intrinsics.areEqual(this.c, kVar.c) && this.d == kVar.d && Intrinsics.areEqual(this.e, kVar.e) && Intrinsics.areEqual(this.f, kVar.f) && this.g == kVar.g && Intrinsics.areEqual(this.h, kVar.h) && Intrinsics.areEqual(this.i, kVar.i) && Intrinsics.areEqual(this.j, kVar.j) && Intrinsics.areEqual(this.k, kVar.k) && this.l == kVar.l;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + j.a(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l;
    }

    public String toString() {
        return "SideBarRecentWatchItem(seriesId=" + this.a + ", videoId=" + this.b + ", direction=" + this.c + ", videoIndex=" + this.d + ", recommendInfo=" + this.e + ", recommendGroupId=" + this.f + ", videoContentType=" + this.g + ", coverUrl=" + this.h + ", title=" + this.i + ", subTitle=" + this.j + ", btnText=" + this.k + ", contentType=" + this.l + ')';
    }

    public k(String seriesId, String videoId, String direction, long j, String recommendInfo, String recommendGroupId, int i, String coverUrl, String title, String subTitle, String btnText, int i2) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(recommendInfo, "recommendInfo");
        Intrinsics.checkNotNullParameter(recommendGroupId, "recommendGroupId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(btnText, "btnText");
        this.a = seriesId;
        this.b = videoId;
        this.c = direction;
        this.d = j;
        this.e = recommendInfo;
        this.f = recommendGroupId;
        this.g = i;
        this.h = coverUrl;
        this.i = title;
        this.j = subTitle;
        this.k = btnText;
        this.l = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ k(java.lang.String r16, java.lang.String r17, java.lang.String r18, long r19, java.lang.String r21, java.lang.String r22, int r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, int r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r15 = this;
            r0 = r29
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto La
            r1 = r2
            goto Lc
        La:
            r1 = r16
        Lc:
            r3 = r0 & 2
            if (r3 == 0) goto L12
            r3 = r2
            goto L14
        L12:
            r3 = r17
        L14:
            r4 = r0 & 4
            if (r4 == 0) goto L1a
            r4 = r2
            goto L1c
        L1a:
            r4 = r18
        L1c:
            r5 = r0 & 8
            if (r5 == 0) goto L23
            r5 = 0
            goto L25
        L23:
            r5 = r19
        L25:
            r7 = r0 & 16
            if (r7 == 0) goto L2b
            r7 = r2
            goto L2d
        L2b:
            r7 = r21
        L2d:
            r8 = r0 & 32
            if (r8 == 0) goto L33
            r8 = r2
            goto L35
        L33:
            r8 = r22
        L35:
            r9 = r0 & 64
            r10 = 0
            if (r9 == 0) goto L3c
            r9 = 0
            goto L3e
        L3c:
            r9 = r23
        L3e:
            r11 = r0 & 128(0x80, float:1.8E-43)
            if (r11 == 0) goto L44
            r11 = r2
            goto L46
        L44:
            r11 = r24
        L46:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L4c
            r12 = r2
            goto L4e
        L4c:
            r12 = r25
        L4e:
            r13 = r0 & 512(0x200, float:7.17E-43)
            if (r13 == 0) goto L54
            r13 = r2
            goto L56
        L54:
            r13 = r26
        L56:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L5b
            goto L5d
        L5b:
            r2 = r27
        L5d:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L62
            goto L64
        L62:
            r10 = r28
        L64:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r5
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r11
            r26 = r12
            r27 = r13
            r28 = r2
            r29 = r10
            r16.<init>(r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.leftslidepage.k.<init>(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
