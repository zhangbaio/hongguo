package wm4;

import androidx.compose.ui.graphics.l0;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u implements hk4.a {
    public static final int j;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public boolean g;
    public final l0 h;
    public final l0 i;

    static {
        Covode.recordClassIndex(608675);
        j = 8;
    }

    public /* synthetic */ u(String str, String str2, String str3, String str4, String str5, int i, boolean z, l0 l0Var, l0 l0Var2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, i, z, l0Var, l0Var2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return Intrinsics.areEqual(this.a, uVar.a) && Intrinsics.areEqual(this.b, uVar.b) && Intrinsics.areEqual(this.c, uVar.c) && Intrinsics.areEqual(this.d, uVar.d) && Intrinsics.areEqual(this.e, uVar.e) && this.f == uVar.f && this.g == uVar.g && Intrinsics.areEqual(this.h, uVar.h) && Intrinsics.areEqual(this.i, uVar.i);
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f) * 31) + androidx.compose.animation.m.a(this.g)) * 31;
        l0 l0Var = this.h;
        int v = (hashCode + (l0Var == null ? 0 : l0.v(l0Var.x()))) * 31;
        l0 l0Var2 = this.i;
        return v + (l0Var2 != null ? l0.v(l0Var2.x()) : 0);
    }

    public String toString() {
        return "RelatedWorkCardItemState(id=" + this.a + ", coverUrl=" + this.b + ", title=" + this.c + ", subTitle=" + this.d + ", highlightText=" + this.e + ", paddingBottom=" + this.f + ", isShown=" + this.g + ", mainTitleColor=" + this.h + ", subInfoColor1=" + this.i + ')';
    }

    @Override // hk4.a
    public boolean isShown() {
        return this.g;
    }

    @Override // hk4.a
    public void setShown(boolean z) {
        this.g = z;
    }

    private u(String id, String coverUrl, String title, String subTitle, String highlightText, int i, boolean z, l0 l0Var, l0 l0Var2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(highlightText, "highlightText");
        this.a = id;
        this.b = coverUrl;
        this.c = title;
        this.d = subTitle;
        this.e = highlightText;
        this.f = i;
        this.g = z;
        this.h = l0Var;
        this.i = l0Var2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ u(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, boolean r19, androidx.compose.ui.graphics.l0 r20, androidx.compose.ui.graphics.l0 r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22 & 64
            if (r0 == 0) goto L7
            r0 = 0
            r8 = 0
            goto L9
        L7:
            r8 = r19
        L9:
            r11 = 0
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r9 = r20
            r10 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wm4.u.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean, androidx.compose.ui.graphics.l0, androidx.compose.ui.graphics.l0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
