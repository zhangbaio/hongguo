package kotlinx.coroutines.selects;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d<Q> implements SelectClause1<Q> {
    private final Object a;
    private final Function3<Object, h<?>, Object, Unit> b;
    private final Function3<Object, Object, Object, Object> c;
    private final Function3<h<?>, Object, Object, Function1<Throwable, Unit>> d;

    static {
        Covode.recordClassIndex(659347);
    }

    @Override // kotlinx.coroutines.selects.SelectClause1, kotlinx.coroutines.selects.g
    public Object getClauseObject() {
        return this.a;
    }

    @Override // kotlinx.coroutines.selects.SelectClause1, kotlinx.coroutines.selects.g
    public Function3<h<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor() {
        return this.d;
    }

    @Override // kotlinx.coroutines.selects.SelectClause1, kotlinx.coroutines.selects.g
    public Function3<Object, Object, Object, Object> getProcessResFunc() {
        return this.c;
    }

    @Override // kotlinx.coroutines.selects.SelectClause1, kotlinx.coroutines.selects.g
    public Function3<Object, h<?>, Object, Unit> getRegFunc() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Object obj, Function3<Object, ? super h<?>, Object, Unit> function3, Function3<Object, Object, Object, ? extends Object> function32, Function3<? super h<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> function33) {
        this.a = obj;
        this.b = function3;
        this.c = function32;
        this.d = function33;
    }

    public /* synthetic */ d(Object obj, Function3 function3, Function3 function32, Function3 function33, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function3, function32, (i & 8) != 0 ? null : function33);
    }
}
