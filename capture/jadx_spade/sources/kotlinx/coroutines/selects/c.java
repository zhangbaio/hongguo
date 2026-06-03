package kotlinx.coroutines.selects;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c implements b {
    private final Object a;
    private final Function3<Object, h<?>, Object, Unit> b;
    private final Function3<h<?>, Object, Object, Function1<Throwable, Unit>> c;
    private final Function3<Object, Object, Object, Object> d;

    static {
        Covode.recordClassIndex(659345);
    }

    @Override // kotlinx.coroutines.selects.g
    public Object getClauseObject() {
        return this.a;
    }

    @Override // kotlinx.coroutines.selects.g
    public Function3<h<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor() {
        return this.c;
    }

    @Override // kotlinx.coroutines.selects.g
    public Function3<Object, Object, Object, Object> getProcessResFunc() {
        return this.d;
    }

    @Override // kotlinx.coroutines.selects.g
    public Function3<Object, h<?>, Object, Unit> getRegFunc() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Object obj, Function3<Object, ? super h<?>, Object, Unit> function3, Function3<? super h<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> function32) {
        Function3<Object, Object, Object, Object> function33;
        this.a = obj;
        this.b = function3;
        this.c = function32;
        function33 = SelectKt.a;
        this.d = function33;
    }

    public /* synthetic */ c(Object obj, Function3 function3, Function3 function32, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function3, (i & 4) != 0 ? null : function32);
    }
}
