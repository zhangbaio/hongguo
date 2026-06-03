package kotlinx.coroutines.debug.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1 extends Lambda implements Function1<c.a<?>, DebuggerInfo> {
    public DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DebuggerInfo invoke(c.a<?> aVar) {
        boolean e;
        CoroutineContext context;
        e = c.a.e(aVar);
        if (e || (context = aVar.b.getContext()) == null) {
            return null;
        }
        return new DebuggerInfo(aVar.b, context);
    }
}
