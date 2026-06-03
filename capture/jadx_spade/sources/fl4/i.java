package fl4;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.g1;
import kotlinx.serialization.internal.g2;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q2;
import kotlinx.serialization.internal.v2;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class i {
    public static final b Companion;
    private static final Lazy<KSerializer<Object>>[] c;
    public final List<String> a;
    public long b;

    public i() {
        this((List) null, 0L, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return new kotlinx.serialization.internal.f(v2.a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.areEqual(this.a, iVar.a) && this.b == iVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + j.a(this.b);
    }

    public String toString() {
        return "RecommendFollowUserRecord(filterList=" + this.a + ", lastShowPopupTime=" + this.b + ')';
    }

    public static final class b {
        static {
            Covode.recordClassIndex(608094);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<i> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class a implements m0<i> {
        public static final a a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        private a() {
        }

        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        public KSerializer<?>[] a() {
            return m0.a.a(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final KSerializer<?>[] b() {
            return new KSerializer[]{i.c[0].getValue(), g1.a};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.profile.follow.RecommendFollowUserRecord", aVar, 2);
            g2Var.g("filterList", true);
            g2Var.g("lastShowPopupTime", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final i deserialize(Decoder decoder) {
            int i;
            List list;
            long j;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            Lazy[] lazyArr = i.c;
            List list2 = null;
            if (beginStructure.decodeSequentially()) {
                list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
                j = beginStructure.decodeLongElement(serialDescriptor, 1);
                i = 3;
            } else {
                long j2 = 0;
                int i2 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex == 1) {
                                j2 = beginStructure.decodeLongElement(serialDescriptor, 1);
                                i2 |= 2;
                            } else {
                                throw new UnknownFieldException(decodeElementIndex);
                            }
                        } else {
                            list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i2;
                list = list2;
                j = j2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new i(i, list, j, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, i value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            i.d(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(608093);
        Companion = new b(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: fl4.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer b2;
                b2 = i.b();
                return b2;
            }
        });
        c = new Lazy[]{lazy, null};
    }

    public i(List<String> filterList, long j) {
        Intrinsics.checkNotNullParameter(filterList, "filterList");
        this.a = filterList;
        this.b = j;
    }

    public static final /* synthetic */ void d(i iVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        Lazy<KSerializer<Object>>[] lazyArr = c;
        boolean z2 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(iVar.a, new ArrayList())) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeSerializableElement(serialDescriptor, 0, lazyArr[0].getValue(), iVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || iVar.b != 0) {
            z2 = true;
        }
        if (z2) {
            dVar.encodeLongElement(serialDescriptor, 1, iVar.b);
        }
    }

    public /* synthetic */ i(int i, List list, long j, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, a.a.getDescriptor());
        }
        this.a = (i & 1) == 0 ? new ArrayList() : list;
        if ((i & 2) == 0) {
            this.b = 0L;
        } else {
            this.b = j;
        }
    }

    public /* synthetic */ i(List list, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? 0L : j);
    }
}
