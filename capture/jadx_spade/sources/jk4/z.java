package jk4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z {
    public static final int h;
    public final String a;
    public final String b;
    public final boolean c;
    public final List<String> d;
    public String e;
    public final String f;
    public final String g;

    static {
        Covode.recordClassIndex(607877);
        h = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return Intrinsics.areEqual(this.a, zVar.a) && Intrinsics.areEqual(this.b, zVar.b) && this.c == zVar.c && Intrinsics.areEqual(this.d, zVar.d) && Intrinsics.areEqual(this.e, zVar.e) && Intrinsics.areEqual(this.f, zVar.f) && Intrinsics.areEqual(this.g, zVar.g);
    }

    public int hashCode() {
        int hashCode = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + androidx.compose.animation.m.a(this.c)) * 31) + this.d.hashCode()) * 31;
        String str = this.e;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.g;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SeriesNpsCardParams(researchId=" + this.a + ", researchTitle=" + this.b + ", isSingleSelection=" + this.c + ", selectItems=" + this.d + ", submitBtnText=" + this.e + ", srcMaterialId=" + this.f + ", materialId=" + this.g + ')';
    }

    public z(String researchId, String researchTitle, boolean z, List<String> selectItems, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(researchId, "researchId");
        Intrinsics.checkNotNullParameter(researchTitle, "researchTitle");
        Intrinsics.checkNotNullParameter(selectItems, "selectItems");
        this.a = researchId;
        this.b = researchTitle;
        this.c = z;
        this.d = selectItems;
        this.e = str;
        this.f = str2;
        this.g = str3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ z(java.lang.String r11, java.lang.String r12, boolean r13, java.util.List r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 16
            r1 = 0
            if (r0 == 0) goto L7
            r7 = r1
            goto L8
        L7:
            r7 = r15
        L8:
            r0 = r18 & 32
            if (r0 == 0) goto Le
            r8 = r1
            goto L10
        Le:
            r8 = r16
        L10:
            r0 = r18 & 64
            if (r0 == 0) goto L16
            r9 = r1
            goto L18
        L16:
            r9 = r17
        L18:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jk4.z.<init>(java.lang.String, java.lang.String, boolean, java.util.List, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
