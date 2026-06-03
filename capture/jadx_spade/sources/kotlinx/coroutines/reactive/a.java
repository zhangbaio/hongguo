package kotlinx.coroutines.reactive;

import kotlin.coroutines.CoroutineContext;
import org.reactivestreams.Publisher;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface a {
    <T> Publisher<T> a(Publisher<T> publisher, CoroutineContext coroutineContext);
}
