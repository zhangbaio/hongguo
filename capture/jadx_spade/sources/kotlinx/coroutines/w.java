package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class w {
    public final Object a;
    public final Function1<Throwable, Unit> b;

    static {
        Covode.recordClassIndex(658922);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return Intrinsics.areEqual(this.a, wVar.a) && Intrinsics.areEqual(this.b, wVar.b);
    }

    public int hashCode() {
        Object obj = this.a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.a + ", onCancellation=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(Object obj, Function1<? super Throwable, Unit> function1) {
        this.a = obj;
        this.b = function1;
    }
}
