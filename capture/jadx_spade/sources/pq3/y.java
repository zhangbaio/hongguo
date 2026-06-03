package pq3;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y {
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    static {
        Covode.recordClassIndex(598265);
    }

    public y() {
        this(false, 0, 0, 0, 0, 0, 0, 0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.a == yVar.a && this.b == yVar.b && this.c == yVar.c && this.d == yVar.d && this.e == yVar.e && this.f == yVar.f && this.g == yVar.g && this.h == yVar.h && this.i == yVar.i;
    }

    public int hashCode() {
        return (((((((((((((((androidx.compose.animation.m.a(this.a) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i;
    }

    public String toString() {
        return "ShortSeriesGuideConfig(enable=" + this.a + ", slideGuideMaxTime=" + this.b + ", enterInnerGuideMaxTime=" + this.c + ", collectGuideMaxTime=" + this.d + ", slideGuideLoop=" + this.e + ", collectGuideLoop=" + this.f + ", enterInnerGuideWatchVideoThreshold=" + this.g + ", enterInnerGuideDuration=" + this.h + ", enterInnerGuideWatchVideoDurationThreshold=" + this.i + ')';
    }

    public y(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = i7;
        this.i = i8;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ y(boolean r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = 0
            goto La
        L9:
            r1 = r11
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = 0
            goto L11
        L10:
            r3 = r12
        L11:
            r4 = r0 & 4
            if (r4 == 0) goto L17
            r4 = 0
            goto L18
        L17:
            r4 = r13
        L18:
            r5 = r0 & 8
            if (r5 == 0) goto L1e
            r5 = 0
            goto L1f
        L1e:
            r5 = r14
        L1f:
            r6 = r0 & 16
            if (r6 == 0) goto L25
            r6 = 0
            goto L26
        L25:
            r6 = r15
        L26:
            r7 = r0 & 32
            if (r7 == 0) goto L2c
            r7 = 0
            goto L2e
        L2c:
            r7 = r16
        L2e:
            r8 = r0 & 64
            if (r8 == 0) goto L34
            r8 = 0
            goto L36
        L34:
            r8 = r17
        L36:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L3c
            r9 = 0
            goto L3e
        L3c:
            r9 = r18
        L3e:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L43
            goto L45
        L43:
            r2 = r19
        L45:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pq3.y.<init>(boolean, int, int, int, int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
