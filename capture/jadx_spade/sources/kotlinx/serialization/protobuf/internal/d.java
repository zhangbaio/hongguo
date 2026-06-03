package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.a;
import kotlinx.serialization.descriptors.b;
import kotlinx.serialization.protobuf.ProtoIntegerType;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoOneOf;
import kotlinx.serialization.protobuf.ProtoPacked;
import kotlinx.serialization.protobuf.ProtoType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(660121);
    }

    public static final boolean g(long j) {
        return (j & 68719476736L) != 0;
    }

    public static final boolean i(long j) {
        return (j & 4294967296L) != 0;
    }

    public static final long j(long j, int i) {
        return (j & 1152921500311879680L) | i;
    }

    public static final ProtoIntegerType f(long j) {
        long j2 = j & 25769803776L;
        ProtoIntegerType protoIntegerType = ProtoIntegerType.DEFAULT;
        if (j2 != protoIntegerType.getSignature$kotlinx_serialization_protobuf()) {
            ProtoIntegerType protoIntegerType2 = ProtoIntegerType.SIGNED;
            if (j2 != protoIntegerType2.getSignature$kotlinx_serialization_protobuf()) {
                return ProtoIntegerType.FIXED;
            }
            return protoIntegerType2;
        }
        return protoIntegerType;
    }

    public static final boolean h(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        kotlinx.serialization.descriptors.d kind = serialDescriptor.getKind();
        if (!Intrinsics.areEqual(kind, b.i.a) && (kind instanceof kotlinx.serialization.descriptors.b)) {
            return true;
        }
        return false;
    }

    public static final long b(SerialDescriptor serialDescriptor, int i) {
        long j;
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        List<Annotation> elementAnnotations = serialDescriptor.getElementAnnotations(i);
        int i2 = i + 1;
        ProtoIntegerType protoIntegerType = ProtoIntegerType.DEFAULT;
        int size = elementAnnotations.size();
        int i3 = i2;
        boolean z = false;
        boolean z2 = false;
        for (int i4 = 0; i4 < size; i4++) {
            Annotation annotation = elementAnnotations.get(i4);
            if (annotation instanceof ProtoNumber) {
                i3 = ((ProtoNumber) annotation).number();
                a(i3, i4, serialDescriptor);
            } else if (annotation instanceof ProtoType) {
                protoIntegerType = ((ProtoType) annotation).type();
            } else if (annotation instanceof ProtoPacked) {
                z2 = true;
            } else if (annotation instanceof ProtoOneOf) {
                z = true;
            }
        }
        if (!z) {
            i2 = i3;
        }
        long j2 = 0;
        if (z2) {
            j = 4294967296L;
        } else {
            j = 0;
        }
        if (z) {
            j2 = 68719476736L;
        }
        return i2 | j2 | j | protoIntegerType.getSignature$kotlinx_serialization_protobuf();
    }

    public static final List<SerialDescriptor> e(SerialDescriptor serialDescriptor, kotlinx.serialization.modules.c serializersModule) {
        List<SerialDescriptor> list;
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(serializersModule, "serializersModule");
        kotlinx.serialization.descriptors.d kind = serialDescriptor.getKind();
        if (Intrinsics.areEqual(kind, a.C0228a.a)) {
            list = fn6.b.c(serializersModule, serialDescriptor);
        } else if (Intrinsics.areEqual(kind, a.b.a)) {
            list = CollectionsKt___CollectionsKt.toList(fn6.f.a(serialDescriptor.getElementDescriptor(1)));
        } else {
            throw new IllegalArgumentException("Class " + serialDescriptor.getSerialName() + " should be abstract or sealed or interface to be used as @ProtoOneOf property.");
        }
        for (SerialDescriptor serialDescriptor2 : list) {
            boolean z = false;
            List<Annotation> elementAnnotations = serialDescriptor2.getElementAnnotations(0);
            if (!(elementAnnotations instanceof Collection) || !elementAnnotations.isEmpty()) {
                Iterator<T> it2 = elementAnnotations.iterator();
                while (it2.hasNext()) {
                    if (((Annotation) it2.next()) instanceof ProtoNumber) {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                throw new IllegalArgumentException(serialDescriptor2.getSerialName() + " implementing oneOf type " + serialDescriptor.getSerialName() + " should have @ProtoNumber annotation in its single property.");
            }
        }
        return list;
    }

    private static final void a(int i, int i2, SerialDescriptor serialDescriptor) {
        if (i > 0) {
            return;
        }
        throw new SerializationException(i + " is not allowed in ProtoNumber for property '" + serialDescriptor.getElementName(i2) + "' of '" + serialDescriptor.getSerialName() + "', because protobuf supports field numbers in range 1..2147483647");
    }

    public static final int c(SerialDescriptor descriptor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        List<Annotation> elementAnnotations = descriptor.getElementAnnotations(i);
        if (!z) {
            i++;
        }
        int size = elementAnnotations.size();
        for (int i2 = 0; i2 < size; i2++) {
            Annotation annotation = elementAnnotations.get(i2);
            if (annotation instanceof ProtoOneOf) {
                return -2;
            }
            if (annotation instanceof ProtoNumber) {
                i = ((ProtoNumber) annotation).number();
                if (!z) {
                    a(i, i2, descriptor);
                }
            }
        }
        return i;
    }

    public static final SerialDescriptor d(SerialDescriptor serialDescriptor, kotlinx.serialization.modules.c serializersModule, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(serializersModule, "serializersModule");
        Iterator<T> it2 = e(serialDescriptor, serializersModule).iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                boolean z = false;
                if (((int) (b((SerialDescriptor) obj, 0) & 2147483647L)) == i) {
                    z = true;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (SerialDescriptor) obj;
    }
}
