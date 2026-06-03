package kotlinx.coroutines.debug.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class DebugProbesImpl$dumpCoroutinesInfoImpl$3 extends Lambda implements Function1<c.a<?>, Object> {
    final /* synthetic */ Function2<c.a<?>, CoroutineContext, Object> $create;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DebugProbesImpl$dumpCoroutinesInfoImpl$3(Function2<? super c.a<?>, ? super CoroutineContext, Object> function2) {
        super(1);
        this.$create = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(c.a<?> aVar) {
        boolean e;
        CoroutineContext context;
        e = c.a.e(aVar);
        if (e || (context = aVar.b.getContext()) == null) {
            return null;
        }
        return this.$create.invoke(aVar, context);
    }
}
