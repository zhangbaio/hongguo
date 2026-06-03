package ql4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int d;
    public final LoadStatus a;
    public final boolean b;
    public final al4.a c;

    static {
        Covode.recordClassIndex(608148);
        d = 8;
    }

    public a() {
        this(null, false, null, 7, null);
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
        return (((this.a.hashCode() * 31) + m.a(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "OneTabLoadState(loadStatus=" + this.a + ", fromFilterOption=" + this.b + ", errorState=" + this.c + ')';
    }

    public a(LoadStatus loadStatus, boolean z, al4.a errorState) {
        Intrinsics.checkNotNullParameter(loadStatus, "loadStatus");
        Intrinsics.checkNotNullParameter(errorState, "errorState");
        this.a = loadStatus;
        this.b = z;
        this.c = errorState;
    }

    public /* synthetic */ a(LoadStatus loadStatus, boolean z, al4.a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? LoadStatus.Init : loadStatus, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new al4.a() : aVar);
    }
}
