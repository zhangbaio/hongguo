package com.dragon.read.kmp.reader.detail.repo;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final boolean a;
    public final boolean b;
    public final String c;

    static {
        Covode.recordClassIndex(608392);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.b == aVar.b && Intrinsics.areEqual(this.c, aVar.c);
    }

    public int hashCode() {
        int a = ((m.a(this.a) * 31) + m.a(this.b)) * 31;
        String str = this.c;
        return a + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BookDetailListenState(show=" + this.a + ", enabled=" + this.b + ", disabledMessage=" + this.c + ')';
    }

    public a(boolean z, boolean z2, String str) {
        this.a = z;
        this.b = z2;
        this.c = str;
    }
}
