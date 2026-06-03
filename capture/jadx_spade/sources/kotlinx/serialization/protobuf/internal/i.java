package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.protobuf.ProtoNumber;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class i extends p {
    static {
        Covode.recordClassIndex(660126);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(hn6.a proto, t parentWriter, SerialDescriptor descriptor) {
        super(proto, parentWriter, descriptor);
        boolean z;
        Object singleOrNull;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(parentWriter, "parentWriter");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor.getElementsCount() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            List<Annotation> elementAnnotations = descriptor.getElementAnnotations(0);
            ArrayList arrayList = new ArrayList();
            for (Object obj : elementAnnotations) {
                if (obj instanceof ProtoNumber) {
                    arrayList.add(obj);
                }
            }
            singleOrNull = CollectionsKt___CollectionsKt.singleOrNull((List<? extends Object>) arrayList);
            if (((ProtoNumber) singleOrNull) != null) {
                return;
            }
            throw new IllegalArgumentException(("Implementation of oneOf type " + descriptor.getSerialName() + " should have @ProtoNumber annotation").toString());
        }
        throw new IllegalArgumentException(("Implementation of oneOf type " + descriptor.getSerialName() + " should contain only 1 element, but get " + descriptor.getElementsCount()).toString());
    }
}
