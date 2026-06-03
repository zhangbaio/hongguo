package kotlinx.coroutines.debug.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class DebugProbesImpl$dumpCoroutinesSynchronized$2 extends Lambda implements Function1<c.a<?>, Boolean> {
    public static final DebugProbesImpl$dumpCoroutinesSynchronized$2 INSTANCE = new DebugProbesImpl$dumpCoroutinesSynchronized$2();

    DebugProbesImpl$dumpCoroutinesSynchronized$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(c.a<?> aVar) {
        boolean e;
        e = c.a.e(aVar);
        return Boolean.valueOf(!e);
    }
}
