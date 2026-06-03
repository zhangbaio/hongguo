package fn6;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.p2;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    static {
        Covode.recordClassIndex(659804);
    }

    public static final KClass<?> a(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor instanceof c) {
            return ((c) serialDescriptor).b;
        }
        if (serialDescriptor instanceof p2) {
            return a(((p2) serialDescriptor).a);
        }
        return null;
    }

    public static final SerialDescriptor d(SerialDescriptor serialDescriptor, KClass<?> context) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return new c(serialDescriptor, context);
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor b(kotlinx.serialization.modules.c cVar, SerialDescriptor descriptor) {
        KSerializer c;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        KClass<?> a = a(descriptor);
        if (a == null || (c = kotlinx.serialization.modules.c.c(cVar, a, null, 2, null)) == null) {
            return null;
        }
        return c.getDescriptor();
    }

    @ExperimentalSerializationApi
    public static final List<SerialDescriptor> c(kotlinx.serialization.modules.c cVar, SerialDescriptor descriptor) {
        Collection<KSerializer<?>> collection;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        KClass<?> a = a(descriptor);
        if (a == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Map<KClass<?>, KSerializer<?>> map = ((kotlinx.serialization.modules.b) cVar).b.get(a);
        if (map != null) {
            collection = map.values();
        } else {
            collection = null;
        }
        if (collection == null) {
            collection = CollectionsKt__CollectionsKt.emptyList();
        }
        Collection<KSerializer<?>> collection2 = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(collection2, 10));
        Iterator<T> it2 = collection2.iterator();
        while (it2.hasNext()) {
            arrayList.add(((KSerializer) it2.next()).getDescriptor());
        }
        return arrayList;
    }
}
