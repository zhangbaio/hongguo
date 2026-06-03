package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.i0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class BufferedChannelKt {
    private static final d<Object> a;
    public static final int b;
    private static final int c;
    public static final f0 d;
    private static final f0 e;
    private static final f0 f;
    private static final f0 g;
    private static final f0 h;
    private static final f0 i;
    private static final f0 j;
    private static final f0 k;
    private static final f0 l;
    private static final f0 m;
    private static final f0 n;
    private static final f0 o;
    private static final f0 p;
    private static final f0 q;
    private static final f0 r;
    private static final f0 s;

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A(int i2) {
        if (i2 == 0) {
            return 0L;
        }
        if (i2 != Integer.MAX_VALUE) {
            return i2;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(long j2, boolean z) {
        return (z ? 4611686018427387904L : 0L) + j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w(long j2, int i2) {
        return (i2 << 60) + j2;
    }

    public static final <E> KFunction<d<E>> y() {
        return BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    }

    public static final f0 z() {
        return l;
    }

    static {
        int e2;
        int e3;
        Covode.recordClassIndex(659070);
        a = new d<>(-1L, null, null, 0);
        e2 = i0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        b = e2;
        e3 = i0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        c = e3;
        d = new f0("BUFFERED");
        e = new f0("SHOULD_BUFFER");
        f = new f0("S_RESUMING_BY_RCV");
        g = new f0("RESUMING_BY_EB");
        h = new f0("POISONED");
        i = new f0("DONE_RCV");
        j = new f0("INTERRUPTED_SEND");
        k = new f0("INTERRUPTED_RCV");
        l = new f0("CHANNEL_CLOSED");
        m = new f0("SUSPEND");
        n = new f0("SUSPEND_NO_WAITER");
        o = new f0("FAILED");
        p = new f0("NO_RECEIVE_RESULT");
        q = new f0("CLOSE_HANDLER_CLOSED");
        r = new f0("CLOSE_HANDLER_INVOKED");
        s = new f0("NO_CLOSE_CAUSE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> d<E> x(long j2, d<E> dVar) {
        return new d<>(j2, dVar, dVar.x(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean B(CancellableContinuation<? super T> cancellableContinuation, T t, Function1<? super Throwable, Unit> function1) {
        Object tryResume = cancellableContinuation.tryResume(t, null, function1);
        if (tryResume != null) {
            cancellableContinuation.completeResume(tryResume);
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean C(CancellableContinuation cancellableContinuation, Object obj, Function1 function1, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        return B(cancellableContinuation, obj, function1);
    }
}
