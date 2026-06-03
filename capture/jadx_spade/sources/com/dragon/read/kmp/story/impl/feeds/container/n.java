package com.dragon.read.kmp.story.impl.feeds.container;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.q6;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public static final int i;
    public final LoadStatus a;
    public final LoadStatus b;
    public final mg4.b c;
    public final q6 d;
    public final boolean e;
    public final String f;
    public final boolean g;
    public final boolean h;

    static {
        Covode.recordClassIndex(609261);
        i = 8;
    }

    public n() {
        this(null, null, null, null, false, null, false, false, 255, null);
    }

    public final n a(LoadStatus containerStatus, LoadStatus footerStatus, mg4.b loadConfig, q6 q6Var, boolean z, String str, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(containerStatus, "containerStatus");
        Intrinsics.checkNotNullParameter(footerStatus, "footerStatus");
        Intrinsics.checkNotNullParameter(loadConfig, "loadConfig");
        return new n(containerStatus, footerStatus, loadConfig, q6Var, z, str, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.a == nVar.a && this.b == nVar.b && Intrinsics.areEqual(this.c, nVar.c) && Intrinsics.areEqual(this.d, nVar.d) && this.e == nVar.e && Intrinsics.areEqual(this.f, nVar.f) && this.g == nVar.g && this.h == nVar.h;
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        q6 q6Var = this.d;
        int hashCode2 = (((hashCode + (q6Var == null ? 0 : q6Var.hashCode())) * 31) + androidx.compose.animation.m.a(this.e)) * 31;
        String str = this.f;
        return ((((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + androidx.compose.animation.m.a(this.g)) * 31) + androidx.compose.animation.m.a(this.h);
    }

    public String toString() {
        return "StoryFeedsUiState(containerStatus=" + this.a + ", footerStatus=" + this.b + ", loadConfig=" + this.c + ", offset=" + this.d + ", hasMore=" + this.e + ", sessionId=" + this.f + ", isMenuShowing=" + this.g + ", isFirstFeedDataReady=" + this.h + ')';
    }

    public n(LoadStatus containerStatus, LoadStatus footerStatus, mg4.b loadConfig, q6 q6Var, boolean z, String str, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(containerStatus, "containerStatus");
        Intrinsics.checkNotNullParameter(footerStatus, "footerStatus");
        Intrinsics.checkNotNullParameter(loadConfig, "loadConfig");
        this.a = containerStatus;
        this.b = footerStatus;
        this.c = loadConfig;
        this.d = q6Var;
        this.e = z;
        this.f = str;
        this.g = z2;
        this.h = z3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ n(com.dragon.read.kmp.compose.common.load.LoadStatus r13, com.dragon.read.kmp.compose.common.load.LoadStatus r14, mg4.b r15, com.bytedance.kmp.ugc.model.q6 r16, boolean r17, java.lang.String r18, boolean r19, boolean r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 1
            if (r1 == 0) goto L9
            com.dragon.read.kmp.compose.common.load.LoadStatus r1 = com.dragon.read.kmp.compose.common.load.LoadStatus.Init
            goto La
        L9:
            r1 = r13
        La:
            r2 = r0 & 2
            if (r2 == 0) goto L11
            com.dragon.read.kmp.compose.common.load.LoadStatus r2 = com.dragon.read.kmp.compose.common.load.LoadStatus.Init
            goto L12
        L11:
            r2 = r14
        L12:
            r3 = r0 & 4
            if (r3 == 0) goto L25
            mg4.b r3 = new mg4.b
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 31
            r11 = 0
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            goto L26
        L25:
            r3 = r15
        L26:
            r4 = r0 & 8
            r5 = 0
            if (r4 == 0) goto L2d
            r4 = r5
            goto L2f
        L2d:
            r4 = r16
        L2f:
            r6 = r0 & 16
            r7 = 1
            if (r6 == 0) goto L36
            r6 = 1
            goto L38
        L36:
            r6 = r17
        L38:
            r8 = r0 & 32
            if (r8 == 0) goto L3d
            goto L3f
        L3d:
            r5 = r18
        L3f:
            r8 = r0 & 64
            if (r8 == 0) goto L44
            goto L46
        L44:
            r7 = r19
        L46:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L4c
            r0 = 0
            goto L4e
        L4c:
            r0 = r20
        L4e:
            r13 = r12
            r14 = r1
            r15 = r2
            r16 = r3
            r17 = r4
            r18 = r6
            r19 = r5
            r20 = r7
            r21 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.n.<init>(com.dragon.read.kmp.compose.common.load.LoadStatus, com.dragon.read.kmp.compose.common.load.LoadStatus, mg4.b, com.bytedance.kmp.ugc.model.q6, boolean, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
