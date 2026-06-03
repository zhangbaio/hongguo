package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface g {
    Object getClauseObject();

    Function3<h<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor();

    Function3<Object, Object, Object, Object> getProcessResFunc();

    Function3<Object, h<?>, Object, Unit> getRegFunc();
}
