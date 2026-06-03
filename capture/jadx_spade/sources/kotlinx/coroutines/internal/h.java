package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.ServiceLoader;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class h {
    private static final Collection<CoroutineExceptionHandler> a;

    public static final Collection<CoroutineExceptionHandler> a() {
        return a;
    }

    static {
        Sequence asSequence;
        Covode.recordClassIndex(659221);
        asSequence = SequencesKt__SequencesKt.asSequence(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator());
        a = SequencesKt___SequencesKt.toList(asSequence);
    }

    public static final void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
