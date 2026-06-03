package dn6;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.a;
import kotlinx.serialization.descriptors.d;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e<T> extends kotlinx.serialization.internal.b<T> {
    private final KClass<T> a;
    private List<? extends Annotation> b;
    private final Lazy c;

    static {
        Covode.recordClassIndex(659780);
    }

    public KClass<T> g() {
        return this.a;
    }

    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + g() + ')';
    }

    public e(KClass<T> baseClass) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        this.a = baseClass;
        this.b = CollectionsKt__CollectionsKt.emptyList();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: dn6.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SerialDescriptor j;
                j = e.j(e.this);
                return j;
            }
        });
        this.c = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor j(final e eVar) {
        return fn6.b.d(SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Polymorphic", a.C0228a.a, new SerialDescriptor[0], new Function1() { // from class: dn6.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k;
                k = e.k(e.this, (fn6.a) obj);
                return k;
            }
        }), eVar.g());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(KClass<T> baseClass, Annotation[] classAnnotations) {
        this(baseClass);
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        this.b = ArraysKt___ArraysJvmKt.asList(classAnnotations);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(e eVar, fn6.a buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
        fn6.a.b(buildSerialDescriptor, "type", en6.a.I(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
        fn6.a.b(buildSerialDescriptor, "value", SerialDescriptorsKt.buildSerialDescriptor$default("kotlinx.serialization.Polymorphic<" + eVar.g().getSimpleName() + '>', d.a.a, new SerialDescriptor[0], null, 8, null), null, false, 12, null);
        buildSerialDescriptor.c(eVar.b);
        return Unit.INSTANCE;
    }
}
