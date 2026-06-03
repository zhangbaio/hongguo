package com.dragon.read.kmp.profile.guestprofile.view;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class e {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;

    static {
        Covode.recordClassIndex(608167);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual(this.a, eVar.a) && Intrinsics.areEqual(this.b, eVar.b) && Intrinsics.areEqual(this.c, eVar.c) && this.d == eVar.d;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + androidx.compose.animation.m.a(this.d);
    }

    public String toString() {
        return "ProcessedSubTitleItem(displayText=" + this.a + ", mainText=" + this.b + ", suffix=" + this.c + ", canEllipsis=" + this.d + ')';
    }

    public e(String displayText, String mainText, String suffix, boolean z) {
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        Intrinsics.checkNotNullParameter(mainText, "mainText");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        this.a = displayText;
        this.b = mainText;
        this.c = suffix;
        this.d = z;
    }
}
