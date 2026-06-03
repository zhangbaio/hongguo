package com.dragon.read.kmp.profile.guestprofile.view;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public final boolean a;
    public final String b;
    public final String c;

    static {
        Covode.recordClassIndex(608168);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && Intrinsics.areEqual(this.b, fVar.b) && Intrinsics.areEqual(this.c, fVar.c);
    }

    public int hashCode() {
        return (((androidx.compose.animation.m.a(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ProfileCoverState(isDefaultCover=" + this.a + ", bgCoverUrl=" + this.b + ", bgCoverColor=" + this.c + ')';
    }

    public f(boolean z, String bgCoverUrl, String bgCoverColor) {
        Intrinsics.checkNotNullParameter(bgCoverUrl, "bgCoverUrl");
        Intrinsics.checkNotNullParameter(bgCoverColor, "bgCoverColor");
        this.a = z;
        this.b = bgCoverUrl;
        this.c = bgCoverColor;
    }
}
