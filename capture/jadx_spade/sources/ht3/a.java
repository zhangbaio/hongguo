package ht3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import ql3.q0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int c;
    public final q0 a;
    public final boolean b;

    static {
        Covode.recordClassIndex(599212);
        c = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + androidx.compose.animation.m.a(this.b);
    }

    public String toString() {
        return "ContinueLastReadEvent(session=" + this.a + ", isShow=" + this.b + ')';
    }

    public a(q0 session, boolean z) {
        Intrinsics.checkNotNullParameter(session, "session");
        this.a = session;
        this.b = z;
    }
}
