package kotlin.coroutines.jvm.internal;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface CoroutineStackFrame {
    CoroutineStackFrame getCallerFrame();

    StackTraceElement getStackTraceElement();
}
