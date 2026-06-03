package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.protobuf.ProtoNumber;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class j extends ProtobufDecoder {
    private final int k;
    private boolean l;

    static {
        Covode.recordClassIndex(660127);
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.encoding.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.l) {
            return -1;
        }
        this.l = true;
        return 0;
    }

    @Override // kotlinx.serialization.protobuf.internal.ProtobufDecoder, kotlinx.serialization.encoding.Decoder
    public kotlinx.serialization.encoding.c beginStructure(SerialDescriptor descriptor) {
        q c;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        kotlinx.serialization.descriptors.d kind = descriptor.getKind();
        if (!Intrinsics.areEqual(kind, e.a.a) && !Intrinsics.areEqual(kind, e.d.a) && !(kind instanceof kotlinx.serialization.descriptors.a)) {
            throw new SerializationException("Type " + descriptor.getKind() + " cannot be directly child of oneof element");
        }
        long d = d();
        if (d == 19500 && Intrinsics.areEqual(this.e, descriptor)) {
            return this;
        }
        if (!d.g(d)) {
            hn6.a aVar = this.c;
            c = o.c(this.d, d);
            return new ProtobufDecoder(aVar, c, descriptor);
        }
        throw new SerializationException("An oneof element cannot be directly child of another oneof element");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(hn6.a proto, q decoder, SerialDescriptor descriptor) {
        super(proto, decoder, descriptor);
        boolean z;
        Object singleOrNull;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
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
            ProtoNumber protoNumber = (ProtoNumber) singleOrNull;
            if (protoNumber != null) {
                this.k = protoNumber.number();
                return;
            }
            throw new IllegalArgumentException(("Implementation of oneOf type " + descriptor.getSerialName() + " should have @ProtoNumber annotation").toString());
        }
        throw new IllegalArgumentException(("Implementation of oneOf type " + descriptor.getSerialName() + " should contain only 1 element, but get " + descriptor.getElementsCount()).toString());
    }
}
