package kotlinx.coroutines.reactive;

import com.bytedance.covode.number.Covode;
import java.util.ServiceLoader;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.reactivestreams.Publisher;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private static final a[] a;

    static {
        Sequence asSequence;
        Covode.recordClassIndex(659293);
        asSequence = SequencesKt__SequencesKt.asSequence(ServiceLoader.load(a.class, a.class.getClassLoader()).iterator());
        a = (a[]) SequencesKt___SequencesKt.toList(asSequence).toArray(new a[0]);
    }

    public static final <T> Publisher<T> a(Publisher<T> publisher, CoroutineContext coroutineContext) {
        for (a aVar : a) {
            publisher = aVar.a(publisher, coroutineContext);
        }
        return publisher;
    }
}
