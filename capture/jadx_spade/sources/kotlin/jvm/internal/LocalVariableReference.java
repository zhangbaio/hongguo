package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import kotlin.KotlinNothingValueException;
import kotlin.reflect.KDeclarationContainer;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LocalVariableReference extends PropertyReference0 {
    static {
        Covode.recordClassIndex(658528);
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
}
