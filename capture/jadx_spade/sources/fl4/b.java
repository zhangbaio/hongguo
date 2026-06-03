package fl4;

import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
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
import kotlinx.serialization.internal.v0;
import kotlinx.serialization.internal.v2;
import kotlinx.serialization.internal.w1;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class b {
    public static final C0156b Companion;
    private static final Lazy<KSerializer<Object>>[] c;
    public Pair<String, Integer> a;
    public long b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return new w1(v2.a, v0.a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && this.b == bVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + j.a(this.b);
    }

    public String toString() {
        return "FollowFrequency(dayPopupCount=" + this.a + ", lastPopupTime=" + this.b + ')';
    }

    /* renamed from: fl4.b$b, reason: collision with other inner class name */
    public static final class C0156b {
        static {
            Covode.recordClassIndex(608091);
        }

        private C0156b() {
        }

        public /* synthetic */ C0156b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<b> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class a implements m0<b> {
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
            return new KSerializer[]{b.c[0].getValue(), g1.a};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.profile.follow.FollowFrequency", aVar, 2);
            g2Var.g("dayPopupCount", false);
            g2Var.g("lastPopupTime", false);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final b deserialize(Decoder decoder) {
            int i;
            Pair pair;
            long j;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            Lazy[] lazyArr = b.c;
            Pair pair2 = null;
            if (beginStructure.decodeSequentially()) {
                pair = (Pair) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
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
                            pair2 = (Pair) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), pair2);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i2;
                pair = pair2;
                j = j2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new b(i, pair, j, null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, b value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            b.e(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(608090);
        Companion = new C0156b(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: fl4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer b;
                b = b.b();
                return b;
            }
        });
        c = new Lazy[]{lazy, null};
    }

    public final void d(Pair<String, Integer> pair) {
        Intrinsics.checkNotNullParameter(pair, "<set-?>");
        this.a = pair;
    }

    public b(Pair<String, Integer> dayPopupCount, long j) {
        Intrinsics.checkNotNullParameter(dayPopupCount, "dayPopupCount");
        this.a = dayPopupCount;
        this.b = j;
    }

    public static final /* synthetic */ void e(b bVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        dVar.encodeSerializableElement(serialDescriptor, 0, c[0].getValue(), bVar.a);
        dVar.encodeLongElement(serialDescriptor, 1, bVar.b);
    }

    public /* synthetic */ b(int i, Pair pair, long j, q2 q2Var) {
        if (3 != (i & 3)) {
            b2.b(i, 3, a.a.getDescriptor());
        }
        this.a = pair;
        this.b = j;
    }
}
