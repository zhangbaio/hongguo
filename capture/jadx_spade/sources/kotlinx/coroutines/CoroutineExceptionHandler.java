package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {
    public static final Key Key;

    public static final class Key implements CoroutineContext.Key<CoroutineExceptionHandler> {
        static final /* synthetic */ Key $$INSTANCE;

        static {
            Covode.recordClassIndex(658934);
            $$INSTANCE = new Key();
        }

        private Key() {
        }
    }

    static {
        Covode.recordClassIndex(658932);
        Key = Key.$$INSTANCE;
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);

    public static final class DefaultImpls {
        static {
            Covode.recordClassIndex(658933);
        }

        public static <E extends CoroutineContext.Element> E get(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.a.b(coroutineExceptionHandler, key);
        }

        public static CoroutineContext minusKey(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.a.c(coroutineExceptionHandler, key);
        }

        public static CoroutineContext plus(CoroutineExceptionHandler coroutineExceptionHandler, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.a.d(coroutineExceptionHandler, coroutineContext);
        }

        public static <R> R fold(CoroutineExceptionHandler coroutineExceptionHandler, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.a.a(coroutineExceptionHandler, r, function2);
        }
    }
}
