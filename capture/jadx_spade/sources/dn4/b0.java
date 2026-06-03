package dn4;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b0 {
    public static final int j;
    public final int a;
    public final String b;
    public final String c;
    public final g d;
    public final String e;
    public final List<List<Integer>> f;
    public final String g;
    public final boolean h;
    public final boolean i;

    static {
        Covode.recordClassIndex(608751);
        j = 8;
    }

    public b0() {
        this(0, null, null, null, null, null, null, false, false, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.a == b0Var.a && Intrinsics.areEqual(this.b, b0Var.b) && Intrinsics.areEqual(this.c, b0Var.c) && Intrinsics.areEqual(this.d, b0Var.d) && Intrinsics.areEqual(this.e, b0Var.e) && Intrinsics.areEqual(this.f, b0Var.f) && Intrinsics.areEqual(this.g, b0Var.g) && this.h == b0Var.h && this.i == b0Var.i;
    }

    public int hashCode() {
        int hashCode = ((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        g gVar = this.d;
        int hashCode2 = (((hashCode + (gVar == null ? 0 : gVar.hashCode())) * 31) + this.e.hashCode()) * 31;
        List<List<Integer>> list = this.f;
        return ((((((hashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.g.hashCode()) * 31) + androidx.compose.animation.m.a(this.h)) * 31) + androidx.compose.animation.m.a(this.i);
    }

    public String toString() {
        return "IpNormalCardModel(index=" + this.a + ", cover=" + this.b + ", tagText=" + this.c + ", tagBg=" + this.d + ", title=" + this.e + ", titleHighLight=" + this.f + ", subTitle=" + this.g + ", hasVideoIcon=" + this.h + ", showCoverBorder=" + this.i + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b0(int i, String cover, String tagText, g gVar, String title, List<? extends List<Integer>> list, String subTitle, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(tagText, "tagText");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        this.a = i;
        this.b = cover;
        this.c = tagText;
        this.d = gVar;
        this.e = title;
        this.f = list;
        this.g = subTitle;
        this.h = z;
        this.i = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ b0(int r11, java.lang.String r12, java.lang.String r13, dn4.g r14, java.lang.String r15, java.util.List r16, java.lang.String r17, boolean r18, boolean r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
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
            java.lang.String r4 = ""
            if (r3 == 0) goto L12
            r3 = r4
            goto L13
        L12:
            r3 = r12
        L13:
            r5 = r0 & 4
            if (r5 == 0) goto L19
            r5 = r4
            goto L1a
        L19:
            r5 = r13
        L1a:
            r6 = r0 & 8
            r7 = 0
            if (r6 == 0) goto L21
            r6 = r7
            goto L22
        L21:
            r6 = r14
        L22:
            r8 = r0 & 16
            if (r8 == 0) goto L28
            r8 = r4
            goto L29
        L28:
            r8 = r15
        L29:
            r9 = r0 & 32
            if (r9 == 0) goto L2e
            goto L30
        L2e:
            r7 = r16
        L30:
            r9 = r0 & 64
            if (r9 == 0) goto L35
            goto L37
        L35:
            r4 = r17
        L37:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L3d
            r9 = 1
            goto L3f
        L3d:
            r9 = r18
        L3f:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L44
            goto L46
        L44:
            r2 = r19
        L46:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r5
            r15 = r6
            r16 = r8
            r17 = r7
            r18 = r4
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dn4.b0.<init>(int, java.lang.String, java.lang.String, dn4.g, java.lang.String, java.util.List, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
