package kotlinx.coroutines.debug.internal;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.a0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DebuggerInfo implements Serializable {
    private final Long coroutineId;
    private final String dispatcher;
    private final List<StackTraceElement> lastObservedStackTrace;
    private final String lastObservedThreadName;
    private final String lastObservedThreadState;
    private final String name;
    private final long sequenceNumber;
    private final String state;

    static {
        Covode.recordClassIndex(659122);
    }

    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    public final String getDispatcher() {
        return this.dispatcher;
    }

    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public final String getState() {
        return this.state;
    }

    public DebuggerInfo(DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineContext coroutineContext) {
        Long l;
        String str;
        String str2;
        String str3;
        Thread.State state;
        a0 a0Var = (a0) coroutineContext.get(a0.b);
        if (a0Var != null) {
            l = Long.valueOf(a0Var.a);
        } else {
            l = null;
        }
        this.coroutineId = l;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.Key);
        if (continuationInterceptor != null) {
            str = continuationInterceptor.toString();
        } else {
            str = null;
        }
        this.dispatcher = str;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.Key);
        if (coroutineName != null) {
            str2 = coroutineName.getName();
        } else {
            str2 = null;
        }
        this.name = str2;
        this.state = debugCoroutineInfoImpl._state;
        Thread thread = debugCoroutineInfoImpl.lastObservedThread;
        if (thread != null && (state = thread.getState()) != null) {
            str3 = state.toString();
        } else {
            str3 = null;
        }
        this.lastObservedThreadState = str3;
        Thread thread2 = debugCoroutineInfoImpl.lastObservedThread;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : null;
        this.lastObservedStackTrace = debugCoroutineInfoImpl.e();
        this.sequenceNumber = debugCoroutineInfoImpl.a;
    }
}
