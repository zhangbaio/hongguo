package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e<T> implements q<T> {
    public final k<T> a;

    static {
        Covode.recordClassIndex(659593);
    }

    @Override // kotlinx.datetime.internal.format.n
    public kotlinx.datetime.internal.format.parser.u<T> a() {
        return this.a.a();
    }

    @Override // kotlinx.datetime.internal.format.n
    public bn6.e<T> b() {
        return this.a.b();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "BasicFormatStructure(" + this.a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(k<? super T> directive) {
        Intrinsics.checkNotNullParameter(directive, "directive");
        this.a = directive;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof e) && Intrinsics.areEqual(this.a, ((e) obj).a)) {
            return true;
        }
        return false;
    }
}
