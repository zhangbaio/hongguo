package kotlinx.serialization.protobuf.internal;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.k1;
import kotlinx.serialization.protobuf.ProtoIntegerType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ProtobufDecoder extends s {
    protected final hn6.a c;
    protected final q d;
    protected final SerialDescriptor e;
    private int[] f;
    private Map<Integer, Integer> g;
    private Map<Integer, Integer> h;
    private boolean i;
    private final d0 j;

    static {
        Covode.recordClassIndex(660134);
    }

    @Override // kotlinx.serialization.encoding.c
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.protobuf.internal.s, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        return !this.i;
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.c
    public kotlinx.serialization.modules.c getSerializersModule() {
        return this.c.getSerializersModule();
    }

    @Override // kotlinx.serialization.protobuf.internal.s
    protected byte j(long j) {
        return (byte) p(j);
    }

    @Override // kotlinx.serialization.protobuf.internal.s
    protected char k(long j) {
        return (char) p(j);
    }

    @Override // kotlinx.serialization.protobuf.internal.s
    protected short r(long j) {
        return (short) p(j);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) h(deserializer, null);
    }

    private final int A(int i) {
        Map<Integer, Integer> map = this.g;
        Intrinsics.checkNotNull(map);
        Integer num = map.get(Integer.valueOf(i));
        if (num == null) {
            num = -1;
        }
        return num.intValue();
    }

    private final int z(int i) {
        int[] iArr = this.f;
        if (iArr != null) {
            boolean z = false;
            if (i >= 0 && i < iArr.length) {
                z = true;
            }
            if (z) {
                return iArr[i];
            }
            return -1;
        }
        return A(i);
    }

    public final void B(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int elementsCount = descriptor.getElementsCount();
        if (elementsCount < 32) {
            int i = elementsCount + 1;
            int[] iArr = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                iArr[i2] = -1;
            }
            for (int i3 = 0; i3 < elementsCount; i3++) {
                int c = d.c(descriptor, i3, false);
                if (c <= elementsCount && c != -2) {
                    iArr[c] = i3;
                } else {
                    C(descriptor, elementsCount);
                    return;
                }
            }
            this.f = iArr;
            return;
        }
        C(descriptor, elementsCount);
    }

    @Override // kotlinx.serialization.protobuf.internal.s
    protected boolean i(long j) {
        int p = p(j);
        if (p != 0) {
            if (p == 1) {
                return true;
            }
            throw new SerializationException("Unexpected boolean value: " + p);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.protobuf.internal.s
    protected double l(long j) {
        try {
            if (j == 19500) {
                j = this.d.n();
            } else {
                j = this.d.m();
            }
            return j;
        } catch (ProtobufDecodingException e) {
            throw new ProtobufDecodingException("Error while decoding proto number " + ((int) (j & 2147483647L)) + " of " + this.e.getSerialName(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.protobuf.internal.s
    protected float n(long j) {
        try {
            if (j == 19500) {
                j = this.d.p();
            } else {
                j = this.d.o();
            }
            return j;
        } catch (ProtobufDecodingException e) {
            throw new ProtobufDecodingException("Error while decoding proto number " + ((int) (j & 2147483647L)) + " of " + this.e.getSerialName(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.lang.String] */
    @Override // kotlinx.serialization.protobuf.internal.s
    protected String s(long j) {
        try {
            if (j == 19500) {
                j = this.d.x();
            } else {
                j = this.d.w();
            }
            return j;
        } catch (ProtobufDecodingException e) {
            throw new ProtobufDecodingException("Error while decoding proto number " + ((int) (j & 2147483647L)) + " of " + this.e.getSerialName(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v8, types: [byte[]] */
    private final byte[] v(byte[] bArr) {
        byte[] plus;
        long d = d();
        try {
            if (d == 19500) {
                d = this.d.l();
            } else {
                d = this.d.k();
            }
            if (bArr != null) {
                plus = ArraysKt___ArraysJvmKt.plus(bArr, (byte[]) d);
                return plus;
            }
            return d;
        } catch (ProtobufDecodingException e) {
            throw new ProtobufDecodingException("Error while decoding proto number " + ((int) (d & 2147483647L)) + " of " + this.e.getSerialName(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v8, types: [int] */
    @Override // kotlinx.serialization.protobuf.internal.s
    protected int p(long j) {
        try {
            if (j == 19500) {
                j = this.d.r();
            } else {
                j = this.d.q(d.f(j));
            }
            return j;
        } catch (ProtobufDecodingException e) {
            throw new ProtobufDecodingException("Error while decoding proto number " + ((int) (j & 2147483647L)) + " of " + this.e.getSerialName(), e);
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.s
    protected long q(long j) {
        try {
            if (j == 19500) {
                j = this.d.v();
            } else {
                j = this.d.t(d.f(j));
            }
            return j;
        } catch (ProtobufDecodingException e) {
            throw new ProtobufDecodingException("Error while decoding proto number " + ((int) (j & 2147483647L)) + " of " + this.e.getSerialName(), e);
        }
    }

    @Override // kotlinx.serialization.encoding.c
    public int decodeElementIndex(SerialDescriptor descriptor) {
        Map<Integer, Integer> map;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        while (true) {
            try {
                int y = this.d.y();
                if (y == -1) {
                    return this.j.d();
                }
                if (y != 0) {
                    int z = z(y);
                    if (z == -1) {
                        this.d.z();
                    } else {
                        if (d.g(d.b(descriptor, z)) && (map = this.h) != null) {
                            map.put(Integer.valueOf(z), Integer.valueOf(y));
                        }
                        this.j.a(z);
                        return z;
                    }
                } else {
                    throw new SerializationException("0 is not allowed as the protobuf field number in " + descriptor.getSerialName() + ", the input bytes may have been corrupted");
                }
            } catch (ProtobufDecodingException e) {
                throw new ProtobufDecodingException("Fail to get element index for " + descriptor.getSerialName() + " in " + this.e.getSerialName(), e);
            }
        }
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public kotlinx.serialization.encoding.c beginStructure(SerialDescriptor descriptor) {
        q c;
        Integer num;
        q d;
        q c2;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        try {
            kotlinx.serialization.descriptors.d kind = descriptor.getKind();
            e.b bVar = e.b.a;
            if (Intrinsics.areEqual(kind, bVar)) {
                long d2 = d();
                if (!Intrinsics.areEqual(this.e.getKind(), bVar) || d2 == 19500 || Intrinsics.areEqual(this.e, descriptor)) {
                    if (this.d.c == ProtoWireType.SIZE_DELIMITED && d.h(descriptor.getElementDescriptor(0))) {
                        return new m(this.c, new q(this.d.h()), descriptor);
                    }
                    return new u(this.c, this.d, d2, descriptor);
                }
                c2 = o.c(this.d, d2);
                c2.y();
                return new u(this.c, c2, ProtoIntegerType.DEFAULT.getSignature$kotlinx_serialization_protobuf() | 0 | 1, descriptor);
            }
            if (!Intrinsics.areEqual(kind, e.a.a) && !Intrinsics.areEqual(kind, e.d.a) && !(kind instanceof kotlinx.serialization.descriptors.a)) {
                if (Intrinsics.areEqual(kind, e.c.a)) {
                    hn6.a aVar = this.c;
                    d = o.d(this.d, d());
                    return new e(aVar, d, d(), descriptor);
                }
                throw new SerializationException("Primitives are not supported at top-level");
            }
            long d3 = d();
            if (d3 == 19500 && Intrinsics.areEqual(this.e, descriptor)) {
                return this;
            }
            if (d.g(d3)) {
                int i = ((int) (d3 & 2147483647L)) - 1;
                Map<Integer, Integer> map = this.h;
                if (map != null && (num = map.get(Integer.valueOf(i))) != null) {
                    d3 = d.j(d3, num.intValue());
                }
                return new l(this.c, this.d, d3, descriptor);
            }
            hn6.a aVar2 = this.c;
            c = o.c(this.d, d3);
            return new ProtobufDecoder(aVar2, c, descriptor);
        } catch (ProtobufDecodingException e) {
            throw new ProtobufDecodingException("Fail to begin structure for " + descriptor.getSerialName() + " in " + this.e.getSerialName() + " at proto number " + ((int) (d() & 2147483647L)), e);
        }
    }

    @Override // kotlinx.serialization.protobuf.internal.s
    protected int m(long j, SerialDescriptor enumDescription) {
        Intrinsics.checkNotNullParameter(enumDescription, "enumDescription");
        return x(enumDescription, p(j));
    }

    @Override // kotlinx.serialization.protobuf.internal.s
    protected long t(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return d.b(serialDescriptor, i);
    }

    private final int x(SerialDescriptor serialDescriptor, int i) {
        if (i < serialDescriptor.getElementsCount() && i >= 0 && d.c(serialDescriptor, i, true) == i) {
            return i;
        }
        return y(serialDescriptor, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E(SerialDescriptor serialDescriptor, int i) {
        if (!serialDescriptor.isElementOptional(i)) {
            SerialDescriptor elementDescriptor = serialDescriptor.getElementDescriptor(i);
            kotlinx.serialization.descriptors.d kind = elementDescriptor.getKind();
            if (!Intrinsics.areEqual(kind, e.c.a) && !Intrinsics.areEqual(kind, e.b.a)) {
                if (elementDescriptor.isNullable()) {
                    this.i = true;
                    return true;
                }
            } else {
                this.i = false;
                return true;
            }
        }
        return false;
    }

    private final int y(SerialDescriptor serialDescriptor, int i) {
        int elementsCount = serialDescriptor.getElementsCount();
        for (int i2 = 0; i2 < elementsCount; i2++) {
            if (d.c(serialDescriptor, i2, true) == i) {
                return i2;
            }
        }
        throw new ProtobufDecodingException(i + " is not among valid " + this.e.getSerialName() + " enum proto numbers", null, 2, null);
    }

    private final void C(SerialDescriptor serialDescriptor, int i) {
        HashMap hashMap = new HashMap(i, 1.0f);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (d.c(serialDescriptor, i3, false) == -2) {
                List<SerialDescriptor> e = d.e(serialDescriptor.getElementDescriptor(i3), getSerializersModule());
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(e, 10));
                Iterator<T> it2 = e.iterator();
                while (it2.hasNext()) {
                    arrayList.add(Integer.valueOf((int) (d.b((SerialDescriptor) it2.next(), 0) & 2147483647L)));
                }
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    D(hashMap, ((Number) it4.next()).intValue(), i3);
                }
                i2++;
            } else {
                D(hashMap, d.c(serialDescriptor, i3, false), i3);
            }
        }
        if (i2 > 0) {
            this.h = new HashMap(i2, 1.0f);
        }
        this.g = hashMap;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.util.LinkedHashMap, java.util.Map] */
    private final <T> T w(DeserializationStrategy<? extends T> deserializationStrategy, T t) {
        Map map;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNull(deserializationStrategy, "null cannot be cast to non-null type kotlinx.serialization.internal.MapLikeSerializer<kotlin.Any?, kotlin.Any?, T of kotlinx.serialization.protobuf.internal.ProtobufDecoder.deserializeMap, *>");
        k1 k1Var = (k1) deserializationStrategy;
        KSerializer j = en6.a.j(k1Var.a, k1Var.b);
        Set set = null;
        if (t instanceof Map) {
            map = (Map) t;
        } else {
            map = null;
        }
        if (map != null) {
            set = map.entrySet();
        }
        kotlinx.serialization.internal.a n = en6.a.n(j);
        Intrinsics.checkNotNull(n, "null cannot be cast to non-null type kotlinx.serialization.internal.AbstractCollectionSerializer<kotlin.collections.Map.Entry<kotlin.Any?, kotlin.Any?>, kotlin.collections.Set<kotlin.collections.Map.Entry<kotlin.Any?, kotlin.Any?>>, *>");
        Set<Map.Entry> set2 = (Set) n.h(this, set);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(set2, 10));
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        ?? r0 = (T) new LinkedHashMap(coerceAtLeast);
        for (Map.Entry entry : set2) {
            r0.put(entry.getKey(), entry.getValue());
        }
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.protobuf.internal.s
    protected <T> T h(DeserializationStrategy<? extends T> deserializer, T t) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        try {
            if (deserializer instanceof k1) {
                return (T) w(deserializer, t);
            }
            if (Intrinsics.areEqual(deserializer.getDescriptor(), en6.a.c().getDescriptor())) {
                return (T) v((byte[]) t);
            }
            if (deserializer instanceof kotlinx.serialization.internal.a) {
                return (T) ((kotlinx.serialization.internal.a) deserializer).h(this, t);
            }
            return deserializer.deserialize(this);
        } catch (ProtobufDecodingException e) {
            long d = d();
            if (!Intrinsics.areEqual(this.e, deserializer.getDescriptor())) {
                if (Intrinsics.areEqual(this.e.getKind(), e.b.a) && !Intrinsics.areEqual(deserializer.getDescriptor().getKind(), e.c.a)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error while decoding index ");
                    sb.append(((int) (d & 2147483647L)) - 1);
                    sb.append(" in repeated field of ");
                    sb.append(deserializer.getDescriptor().getSerialName());
                    str = sb.toString();
                } else if (Intrinsics.areEqual(this.e.getKind(), e.c.a)) {
                    int i = ((int) (d & 2147483647L)) - 1;
                    int i2 = i / 2;
                    if (i % 2 == 0) {
                        str2 = "key";
                    } else {
                        str2 = "value";
                    }
                    str = "Error while decoding " + str2 + " of index " + i2 + " in map field of " + deserializer.getDescriptor().getSerialName();
                } else {
                    str = "Error while decoding " + deserializer.getDescriptor().getSerialName() + " at proto number " + ((int) (d & 2147483647L)) + " of " + this.e.getSerialName();
                }
            } else {
                str = "Error while decoding " + this.e.getSerialName();
            }
            throw new ProtobufDecodingException(str, e);
        }
    }

    private final void D(Map<Integer, Integer> map, int i, int i2) {
        map.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public ProtobufDecoder(hn6.a proto, q reader, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.c = proto;
        this.d = reader;
        this.e = descriptor;
        this.j = new d0(descriptor, new ProtobufDecoder$elementMarker$1(this));
        B(descriptor);
    }
}
