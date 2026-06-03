package com.dragon.read.kmp.star_fans;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public final boolean a;
    public final Integer b;
    public final String c;

    static {
        Covode.recordClassIndex(609157);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a == iVar.a && Intrinsics.areEqual(this.b, iVar.b) && Intrinsics.areEqual(this.c, iVar.c);
    }

    public int hashCode() {
        int a = m.a(this.a) * 31;
        Integer num = this.b;
        int hashCode = (a + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.c;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "TaskDoneResult(success=" + this.a + ", errNo=" + this.b + ", errTips=" + this.c + ')';
    }

    public i(boolean z, Integer num, String str) {
        this.a = z;
        this.b = num;
        this.c = str;
    }

    public /* synthetic */ i(boolean z, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str);
    }
}
