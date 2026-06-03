package kotlinx.serialization.descriptors;

import com.bytedance.covode.number.Covode;
import dn6.s;
import fn6.i;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.p;
import kotlin.reflect.KType;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.internal.n0;
import kotlinx.serialization.internal.n2;
import kotlinx.serialization.internal.p0;
import kotlinx.serialization.internal.p2;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SerialDescriptorsKt {
    static {
        Covode.recordClassIndex(659823);
    }

    @ExperimentalSerializationApi
    public static /* synthetic */ void getNonNullOriginal$annotations(SerialDescriptor serialDescriptor) {
    }

    public static /* synthetic */ void getNullable$annotations(SerialDescriptor serialDescriptor) {
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> SerialDescriptor listSerialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "T");
        p.a("kotlinx.serialization.serializer.simple");
        return listSerialDescriptor(s.c(null).getDescriptor());
    }

    public static final /* synthetic */ <T> SerialDescriptor serialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "T");
        p.a("kotlinx.serialization.serializer.simple");
        return s.c(null).getDescriptor();
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> SerialDescriptor setSerialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "T");
        p.a("kotlinx.serialization.serializer.simple");
        return setSerialDescriptor(s.c(null).getDescriptor());
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <K, V> SerialDescriptor mapSerialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "K");
        p.a("kotlinx.serialization.serializer.simple");
        SerialDescriptor descriptor = s.c(null).getDescriptor();
        Intrinsics.reifiedOperationMarker(6, "V");
        p.a("kotlinx.serialization.serializer.simple");
        return mapSerialDescriptor(descriptor, s.c(null).getDescriptor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildClassSerialDescriptor$lambda$0(fn6.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildSerialDescriptor$lambda$6(fn6.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return Unit.INSTANCE;
    }

    public static final SerialDescriptor getNonNullOriginal(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor instanceof p2) {
            return ((p2) serialDescriptor).a;
        }
        return serialDescriptor;
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor listSerialDescriptor(SerialDescriptor elementDescriptor) {
        Intrinsics.checkNotNullParameter(elementDescriptor, "elementDescriptor");
        return new kotlinx.serialization.internal.e(elementDescriptor);
    }

    public static final SerialDescriptor serialDescriptor(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return s.c(type).getDescriptor();
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor setSerialDescriptor(SerialDescriptor elementDescriptor) {
        Intrinsics.checkNotNullParameter(elementDescriptor, "elementDescriptor");
        return new p0(elementDescriptor);
    }

    public static final SerialDescriptor getNullable(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor.isNullable()) {
            return serialDescriptor;
        }
        return new p2(serialDescriptor);
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor mapSerialDescriptor(SerialDescriptor keyDescriptor, SerialDescriptor valueDescriptor) {
        Intrinsics.checkNotNullParameter(keyDescriptor, "keyDescriptor");
        Intrinsics.checkNotNullParameter(valueDescriptor, "valueDescriptor");
        return new n0(keyDescriptor, valueDescriptor);
    }

    public static final SerialDescriptor PrimitiveSerialDescriptor(String serialName, b kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (!StringsKt__StringsKt.isBlank(serialName)) {
            return n2.a(serialName, kind);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor SerialDescriptor(String serialName, SerialDescriptor original) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(original, "original");
        if (!StringsKt__StringsKt.isBlank(serialName)) {
            if (!(original.getKind() instanceof b)) {
                if (!Intrinsics.areEqual(serialName, original.getSerialName())) {
                    return new i(serialName, original);
                }
                throw new IllegalArgumentException(("The name of the wrapped descriptor (" + serialName + ") cannot be the same as the name of the original descriptor (" + original.getSerialName() + ')').toString());
            }
            throw new IllegalArgumentException("For primitive descriptors please use 'PrimitiveSerialDescriptor' instead".toString());
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final SerialDescriptor buildClassSerialDescriptor(String serialName, SerialDescriptor[] typeParameters, Function1<? super fn6.a, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        if (!StringsKt__StringsKt.isBlank(serialName)) {
            fn6.a aVar = new fn6.a(serialName);
            builderAction.invoke(aVar);
            return new c(serialName, e.a.a, aVar.c.size(), ArraysKt___ArraysKt.toList(typeParameters), aVar);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final /* synthetic */ <T> void element(fn6.a aVar, String elementName, List<? extends Annotation> annotations, boolean z) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.reifiedOperationMarker(6, "T");
        p.a("kotlinx.serialization.serializer.simple");
        aVar.a(elementName, s.c(null).getDescriptor(), annotations, z);
    }

    @InternalSerializationApi
    public static final SerialDescriptor buildSerialDescriptor(String serialName, d kind, SerialDescriptor[] typeParameters, Function1<? super fn6.a, Unit> builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (!StringsKt__StringsKt.isBlank(serialName)) {
            if (!Intrinsics.areEqual(kind, e.a.a)) {
                fn6.a aVar = new fn6.a(serialName);
                builder.invoke(aVar);
                return new c(serialName, kind, aVar.c.size(), ArraysKt___ArraysKt.toList(typeParameters), aVar);
            }
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static /* synthetic */ SerialDescriptor buildClassSerialDescriptor$default(String str, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: fn6.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit buildClassSerialDescriptor$lambda$0;
                    buildClassSerialDescriptor$lambda$0 = SerialDescriptorsKt.buildClassSerialDescriptor$lambda$0((a) obj2);
                    return buildClassSerialDescriptor$lambda$0;
                }
            };
        }
        return buildClassSerialDescriptor(str, serialDescriptorArr, function1);
    }

    public static /* synthetic */ SerialDescriptor buildSerialDescriptor$default(String str, d dVar, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: fn6.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit buildSerialDescriptor$lambda$6;
                    buildSerialDescriptor$lambda$6 = SerialDescriptorsKt.buildSerialDescriptor$lambda$6((a) obj2);
                    return buildSerialDescriptor$lambda$6;
                }
            };
        }
        return buildSerialDescriptor(str, dVar, serialDescriptorArr, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void element$default(fn6.a aVar, String elementName, List annotations, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            annotations = CollectionsKt__CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.reifiedOperationMarker(6, "T");
        p.a("kotlinx.serialization.serializer.simple");
        aVar.a(elementName, s.c(null).getDescriptor(), annotations, z);
    }
}
