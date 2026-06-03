package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c<T, K> implements Sequence<T> {
    private final Sequence<T> a;
    private final Function1<T, K> b;

    static {
        Covode.recordClassIndex(658708);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new b(this.a.iterator(), this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Sequence<? extends T> source, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        this.a = source;
        this.b = keySelector;
    }
}
