package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final /* synthetic */ class z1 {
    static {
        Covode.recordClassIndex(659037);
    }

    public static final ExecutorCoroutineDispatcher b(final int i, final String str) {
        boolean z = true;
        if (i < 1) {
            z = false;
        }
        if (z) {
            final AtomicInteger atomicInteger = new AtomicInteger();
            return ExecutorsKt.from((ExecutorService) PThreadExecutorsUtils.newScheduledThreadPool(i, new ThreadFactory() { // from class: kotlinx.coroutines.y1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread c;
                    c = z1.c(i, str, atomicInteger, runnable);
                    return c;
                }
            }));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i + " specified").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread c(int i, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }
}
