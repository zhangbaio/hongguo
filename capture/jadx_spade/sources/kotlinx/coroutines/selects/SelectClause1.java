package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface SelectClause1<Q> extends g {
    @Override // kotlinx.coroutines.selects.g
    /* synthetic */ Object getClauseObject();

    @Override // kotlinx.coroutines.selects.g
    /* synthetic */ Function3<h<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor();

    @Override // kotlinx.coroutines.selects.g
    /* synthetic */ Function3<Object, Object, Object, Object> getProcessResFunc();

    @Override // kotlinx.coroutines.selects.g
    /* synthetic */ Function3<Object, h<?>, Object, Unit> getRegFunc();
}
