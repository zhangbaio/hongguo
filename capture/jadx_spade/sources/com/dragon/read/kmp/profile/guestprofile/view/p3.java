package com.dragon.read.kmp.profile.guestprofile.view;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p3 {
    public final String a;
    public final long b;
    public final org.jetbrains.compose.resources.b c;
    public final androidx.compose.ui.graphics.m0 d;
    public final androidx.compose.ui.graphics.c0 e;

    static {
        Covode.recordClassIndex(608175);
    }

    public /* synthetic */ p3(String str, long j, org.jetbrains.compose.resources.b bVar, androidx.compose.ui.graphics.m0 m0Var, androidx.compose.ui.graphics.c0 c0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, bVar, m0Var, c0Var);
    }

    public static /* synthetic */ p3 b(p3 p3Var, String str, long j, org.jetbrains.compose.resources.b bVar, androidx.compose.ui.graphics.m0 m0Var, androidx.compose.ui.graphics.c0 c0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            str = p3Var.a;
        }
        if ((i & 2) != 0) {
            j = p3Var.b;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            bVar = p3Var.c;
        }
        org.jetbrains.compose.resources.b bVar2 = bVar;
        if ((i & 8) != 0) {
            m0Var = p3Var.d;
        }
        androidx.compose.ui.graphics.m0 m0Var2 = m0Var;
        if ((i & 16) != 0) {
            c0Var = p3Var.e;
        }
        return p3Var.a(str, j2, bVar2, m0Var2, c0Var);
    }

    public final p3 a(String text, long j, org.jetbrains.compose.resources.b bVar, androidx.compose.ui.graphics.m0 m0Var, androidx.compose.ui.graphics.c0 c0Var) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new p3(text, j, bVar, m0Var, c0Var, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p3)) {
            return false;
        }
        p3 p3Var = (p3) obj;
        return Intrinsics.areEqual(this.a, p3Var.a) && androidx.compose.ui.graphics.l0.p(this.b, p3Var.b) && Intrinsics.areEqual(this.c, p3Var.c) && Intrinsics.areEqual(this.d, p3Var.d) && Intrinsics.areEqual(this.e, p3Var.e);
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + androidx.compose.ui.graphics.l0.v(this.b)) * 31;
        org.jetbrains.compose.resources.b bVar = this.c;
        int hashCode2 = (hashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
        androidx.compose.ui.graphics.m0 m0Var = this.d;
        int hashCode3 = (hashCode2 + (m0Var == null ? 0 : m0Var.hashCode())) * 31;
        androidx.compose.ui.graphics.c0 c0Var = this.e;
        return hashCode3 + (c0Var != null ? c0Var.hashCode() : 0);
    }

    public String toString() {
        return "SubscribeState(text=" + this.a + ", textColor=" + ((Object) androidx.compose.ui.graphics.l0.w(this.b)) + ", iconResId=" + this.c + ", colorFilter=" + this.d + ", brush=" + this.e + ')';
    }

    private p3(String text, long j, org.jetbrains.compose.resources.b bVar, androidx.compose.ui.graphics.m0 m0Var, androidx.compose.ui.graphics.c0 c0Var) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.a = text;
        this.b = j;
        this.c = bVar;
        this.d = m0Var;
        this.e = c0Var;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ p3(java.lang.String r10, long r11, org.jetbrains.compose.resources.b r13, androidx.compose.ui.graphics.m0 r14, androidx.compose.ui.graphics.c0 r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 16
            if (r0 == 0) goto L7
            r0 = 0
            r7 = r0
            goto L8
        L7:
            r7 = r15
        L8:
            r8 = 0
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r13
            r6 = r14
            r1.<init>(r2, r3, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.p3.<init>(java.lang.String, long, org.jetbrains.compose.resources.b, androidx.compose.ui.graphics.m0, androidx.compose.ui.graphics.c0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
