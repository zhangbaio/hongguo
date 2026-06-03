package com.dragon.read.kmp.mine.model;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public final boolean a;
    public final String b;

    static {
        Covode.recordClassIndex(607703);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a == iVar.a && Intrinsics.areEqual(this.b, iVar.b);
    }

    public int hashCode() {
        return (m.a(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SaveStatus(canSave=" + this.a + ", toastMsg=" + this.b + ')';
    }

    public i(boolean z, String toastMsg) {
        Intrinsics.checkNotNullParameter(toastMsg, "toastMsg");
        this.a = z;
        this.b = toastMsg;
    }
}
