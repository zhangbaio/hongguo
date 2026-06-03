package kotlinx.serialization.protobuf.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
/* synthetic */ class ProtobufDecoder$elementMarker$1 extends FunctionReferenceImpl implements Function2<SerialDescriptor, Integer, Boolean> {
    ProtobufDecoder$elementMarker$1(Object obj) {
        super(2, obj, ProtobufDecoder.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(SerialDescriptor serialDescriptor, Integer num) {
        return invoke(serialDescriptor, num.intValue());
    }

    public final Boolean invoke(SerialDescriptor p0, int i) {
        boolean E;
        Intrinsics.checkNotNullParameter(p0, "p0");
        E = ((ProtobufDecoder) this.receiver).E(p0, i);
        return Boolean.valueOf(E);
    }
}
