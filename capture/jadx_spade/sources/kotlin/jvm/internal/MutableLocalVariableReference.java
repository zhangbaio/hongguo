package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import kotlin.KotlinNothingValueException;
import kotlin.reflect.KDeclarationContainer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MutableLocalVariableReference extends MutablePropertyReference0 {
    static {
        Covode.recordClassIndex(658533);
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        o.b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KDeclarationContainer getOwner() {
        o.b();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(Object obj) {
        o.b();
        throw new KotlinNothingValueException();
    }
}
