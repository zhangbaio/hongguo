package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ReflectionFactory {
    static {
        Covode.recordClassIndex(658561);
    }

    public KFunction function(FunctionReference functionReference) {
        return functionReference;
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public KProperty0 property0(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public KProperty1 property1(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public KProperty2 property2(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public KClass createKotlinClass(Class cls) {
        return new m(cls);
    }

    public KClass getOrCreateKotlinClass(Class cls) {
        return new m(cls);
    }

    public String renderLambdaToString(Lambda lambda) {
        return renderLambdaToString((FunctionBase) lambda);
    }

    public KType mutableCollectionType(KType kType) {
        u uVar = (u) kType;
        return new u(kType.getClassifier(), kType.getArguments(), uVar.c, uVar.d | 2);
    }

    public KType nothingType(KType kType) {
        u uVar = (u) kType;
        return new u(kType.getClassifier(), kType.getArguments(), uVar.c, uVar.d | 4);
    }

    public String renderLambdaToString(FunctionBase functionBase) {
        String obj = functionBase.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            return obj.substring(21);
        }
        return obj;
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return new q(cls, str);
    }

    public void setUpperBounds(KTypeParameter kTypeParameter, List<KType> list) {
        ((s) kTypeParameter).a(list);
    }

    public KClass createKotlinClass(Class cls, String str) {
        return new m(cls);
    }

    public KClass getOrCreateKotlinClass(Class cls, String str) {
        return new m(cls);
    }

    public KType platformType(KType kType, KType kType2) {
        return new u(kType.getClassifier(), kType.getArguments(), kType2, ((u) kType).d);
    }

    public KType typeOf(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        return new u(kClassifier, list, z);
    }

    public KTypeParameter typeParameter(Object obj, String str, KVariance kVariance, boolean z) {
        return new s(obj, str, kVariance, z);
    }
}
