package io4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.xl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final int c;
    public final boolean a;
    public final xl b;

    static {
        Covode.recordClassIndex(609041);
        c = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && Intrinsics.areEqual(this.b, eVar.b);
    }

    public int hashCode() {
        int a = m.a(this.a) * 31;
        xl xlVar = this.b;
        return a + (xlVar == null ? 0 : xlVar.hashCode());
    }

    public String toString() {
        return "KmpRankingPreloadModel(isSuccess=" + this.a + ", distributeModel=" + this.b + ')';
    }

    public e(boolean z, xl xlVar) {
        this.a = z;
        this.b = xlVar;
    }
}
