package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    static {
        Covode.recordClassIndex(658544);
    }

    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.property0(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return ((KProperty0) getReflected()).getDelegate();
    }

    @Override // kotlin.reflect.KProperty
    public KProperty0.Getter getGetter() {
        return ((KProperty0) getReflected()).getGetter();
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    public PropertyReference0(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
