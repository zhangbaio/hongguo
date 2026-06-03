package kotlinx.coroutines.selects;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DelayKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class OnTimeout {
    private final long a;

    static {
        Covode.recordClassIndex(659338);
    }

    public static final class a implements Runnable {
        final /* synthetic */ h a;
        final /* synthetic */ OnTimeout b;

        public a(h hVar, OnTimeout onTimeout) {
            this.a = hVar;
            this.b = onTimeout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.trySelect(this.b, Unit.INSTANCE);
        }
    }

    public final b b() {
        OnTimeout$selectClause$1 onTimeout$selectClause$1 = OnTimeout$selectClause$1.INSTANCE;
        Intrinsics.checkNotNull(onTimeout$selectClause$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new c(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onTimeout$selectClause$1, 3), null, 4, null);
    }

    public OnTimeout(long j) {
        this.a = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(h<?> hVar, Object obj) {
        if (this.a <= 0) {
            hVar.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }
        a aVar = new a(hVar, this);
        Intrinsics.checkNotNull(hVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        CoroutineContext context = hVar.getContext();
        hVar.disposeOnCompletion(DelayKt.getDelay(context).invokeOnTimeout(this.a, aVar, context));
    }
}
