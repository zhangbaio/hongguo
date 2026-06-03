package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class PropertyReference1 extends PropertyReference implements KProperty1 {
    static {
        Covode.recordClassIndex(658546);
    }

    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected KCallable computeReflected() {
        return Reflection.property1(this);
    }

    @Override // kotlin.reflect.KProperty
    public KProperty1.Getter getGetter() {
        return ((KProperty1) getReflected()).getGetter();
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(Object obj) {
        return ((KProperty1) getReflected()).getDelegate(obj);
    }

    public PropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
