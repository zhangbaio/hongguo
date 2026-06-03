package kotlin.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ContinuationInterceptor extends CoroutineContext.Element {
    public static final b Key;

    public static final class b implements CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ b a;

        static {
            Covode.recordClassIndex(658298);
            a = new b();
        }

        private b() {
        }
    }

    static {
        Covode.recordClassIndex(658296);
        Key = b.a;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key);

    <T> Continuation<T> interceptContinuation(Continuation<? super T> continuation);

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    CoroutineContext minusKey(CoroutineContext.Key<?> key);

    void releaseInterceptedContinuation(Continuation<?> continuation);

    public static final class a {
        static {
            Covode.recordClassIndex(658297);
        }

        public static <E extends CoroutineContext.Element> E a(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<E> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (key instanceof kotlin.coroutines.a) {
                kotlin.coroutines.a aVar = (kotlin.coroutines.a) key;
                if (!aVar.a(continuationInterceptor.getKey())) {
                    return null;
                }
                E e = (E) aVar.b(continuationInterceptor);
                if (!(e instanceof CoroutineContext.Element)) {
                    return null;
                }
                return e;
            }
            if (ContinuationInterceptor.Key != key) {
                return null;
            }
            Intrinsics.checkNotNull(continuationInterceptor, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return continuationInterceptor;
        }

        public static CoroutineContext b(ContinuationInterceptor continuationInterceptor, CoroutineContext.Key<?> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            if (key instanceof kotlin.coroutines.a) {
                kotlin.coroutines.a aVar = (kotlin.coroutines.a) key;
                if (aVar.a(continuationInterceptor.getKey()) && aVar.b(continuationInterceptor) != null) {
                    return EmptyCoroutineContext.INSTANCE;
                }
                return continuationInterceptor;
            }
            if (ContinuationInterceptor.Key == key) {
                return EmptyCoroutineContext.INSTANCE;
            }
            return continuationInterceptor;
        }
    }
}
