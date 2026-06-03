package com.dragon.read.kmp.profile.guestprofile.viewmodel;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.eo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f0 {
    public static final int g;
    public final eo a;
    public final dl4.t b;
    public final jv5.d c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    static {
        Covode.recordClassIndex(608192);
        g = 8;
    }

    public static /* synthetic */ f0 b(f0 f0Var, eo eoVar, dl4.t tVar, jv5.d dVar, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            eoVar = f0Var.a;
        }
        if ((i & 2) != 0) {
            tVar = f0Var.b;
        }
        dl4.t tVar2 = tVar;
        if ((i & 4) != 0) {
            dVar = f0Var.c;
        }
        jv5.d dVar2 = dVar;
        if ((i & 8) != 0) {
            z = f0Var.d;
        }
        boolean z4 = z;
        if ((i & 16) != 0) {
            z2 = f0Var.e;
        }
        boolean z5 = z2;
        if ((i & 32) != 0) {
            z3 = f0Var.f;
        }
        return f0Var.a(eoVar, tVar2, dVar2, z4, z5, z3);
    }

    public final f0 a(eo eoVar, dl4.t seriesProfileID, jv5.d userHonor, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(seriesProfileID, "seriesProfileID");
        Intrinsics.checkNotNullParameter(userHonor, "userHonor");
        return new f0(eoVar, seriesProfileID, userHonor, z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return Intrinsics.areEqual(this.a, f0Var.a) && Intrinsics.areEqual(this.b, f0Var.b) && Intrinsics.areEqual(this.c, f0Var.c) && this.d == f0Var.d && this.e == f0Var.e && this.f == f0Var.f;
    }

    public int hashCode() {
        eo eoVar = this.a;
        return ((((((((((eoVar == null ? 0 : eoVar.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + androidx.compose.animation.m.a(this.d)) * 31) + androidx.compose.animation.m.a(this.e)) * 31) + androidx.compose.animation.m.a(this.f);
    }

    public String toString() {
        return "UserProfileState(userProfileData=" + this.a + ", seriesProfileID=" + this.b + ", userHonor=" + this.c + ", isCancelled=" + this.d + ", isShowShareEntrance=" + this.e + ", isLive=" + this.f + ')';
    }

    public f0(eo eoVar, dl4.t seriesProfileID, jv5.d userHonor, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(seriesProfileID, "seriesProfileID");
        Intrinsics.checkNotNullParameter(userHonor, "userHonor");
        this.a = eoVar;
        this.b = seriesProfileID;
        this.c = userHonor;
        this.d = z;
        this.e = z2;
        this.f = z3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ f0(com.bytedance.kmp.reading.model.eo r10, dl4.t r11, jv5.d r12, boolean r13, boolean r14, boolean r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 2
            if (r0 == 0) goto La
            dl4.t r0 = new dl4.t
            r0.<init>()
            goto Lb
        La:
            r0 = r11
        Lb:
            r1 = r16 & 4
            if (r1 == 0) goto L1d
            jv5.d r1 = new jv5.d
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 15
            r8 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L1e
        L1d:
            r1 = r12
        L1e:
            r2 = r16 & 8
            r3 = 0
            if (r2 == 0) goto L25
            r2 = 0
            goto L26
        L25:
            r2 = r13
        L26:
            r4 = r16 & 16
            if (r4 == 0) goto L2c
            r4 = 0
            goto L2d
        L2c:
            r4 = r14
        L2d:
            r5 = r16 & 32
            if (r5 == 0) goto L32
            goto L33
        L32:
            r3 = r15
        L33:
            r11 = r9
            r12 = r10
            r13 = r0
            r14 = r1
            r15 = r2
            r16 = r4
            r17 = r3
            r11.<init>(r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.viewmodel.f0.<init>(com.bytedance.kmp.reading.model.eo, dl4.t, jv5.d, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
