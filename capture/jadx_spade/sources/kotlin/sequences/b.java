package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b<T, K> extends kotlin.collections.b<T> {
    private final Iterator<T> c;
    private final Function1<T, K> d;
    private final HashSet<K> e;

    static {
        Covode.recordClassIndex(658707);
    }

    @Override // kotlin.collections.b
    protected void c() {
        while (this.c.hasNext()) {
            T next = this.c.next();
            if (this.e.add(this.d.invoke(next))) {
                e(next);
                return;
            }
        }
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Iterator<? extends T> source, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        this.c = source;
        this.d = keySelector;
        this.e = new HashSet<>();
    }
}
