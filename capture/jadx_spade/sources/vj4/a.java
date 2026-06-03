package vj4;

import androidx.compose.ui.text.font.c0;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final c0 a;

    static {
        Covode.recordClassIndex(607684);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: vj4.a.<init>():void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "PhoneListStyle(countryNameFontWeight=" + this.a + ')';
    }

    public a(c0 countryNameFontWeight) {
        Intrinsics.checkNotNullParameter(countryNameFontWeight, "countryNameFontWeight");
        this.a = countryNameFontWeight;
    }

    public /* synthetic */ a(c0 c0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? c0.b.a() : c0Var);
    }
}
