package fl4;

import com.bytedance.covode.number.Covode;
import fl4.s;
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
final class r {
    public static final b Companion;
    private static final Lazy<KSerializer<Object>>[] d;
    public final String a;
    public final List<s> b;
    public long c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer b() {
        return new kotlinx.serialization.internal.f(s.a.a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Intrinsics.areEqual(this.a, rVar.a) && Intrinsics.areEqual(this.b, rVar.b) && this.c == rVar.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + j.a(this.c);
    }

    public String toString() {
        return "UserFollowRecord(userId=" + this.a + ", visitRecordList=" + this.b + ", lastShowPopupTime=" + this.c + ')';
    }

    public static final class b {
        static {
            Covode.recordClassIndex(608098);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<r> serializer() {
            return a.a;
        }
    }

    public /* synthetic */ class a implements m0<r> {
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
            return new KSerializer[]{v2.a, r.d[1].getValue(), g1.a};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.profile.follow.UserFollowRecord", aVar, 3);
            g2Var.g("userId", false);
            g2Var.g("visitRecordList", true);
            g2Var.g("lastShowPopupTime", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final r deserialize(Decoder decoder) {
            int i;
            String str;
            long j;
            List list;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            Lazy[] lazyArr = r.d;
            String str2 = null;
            if (beginStructure.decodeSequentially()) {
                String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
                list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), null);
                str = decodeStringElement;
                j = beginStructure.decodeLongElement(serialDescriptor, 2);
                i = 7;
            } else {
                long j2 = 0;
                List list2 = null;
                int i2 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex == 2) {
                                    j2 = beginStructure.decodeLongElement(serialDescriptor, 2);
                                    i2 |= 4;
                                } else {
                                    throw new UnknownFieldException(decodeElementIndex);
                                }
                            } else {
                                list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), list2);
                                i2 |= 2;
                            }
                        } else {
                            str2 = beginStructure.decodeStringElement(serialDescriptor, 0);
                            i2 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i2;
                str = str2;
                j = j2;
                list = list2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new r(i, str, list, j, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, r value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            r.d(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    static {
        Lazy<KSerializer<Object>> lazy;
        Covode.recordClassIndex(608097);
        Companion = new b(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: fl4.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer b2;
                b2 = r.b();
                return b2;
            }
        });
        d = new Lazy[]{null, lazy, null};
    }

    public r(String userId, List<s> visitRecordList, long j) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(visitRecordList, "visitRecordList");
        this.a = userId;
        this.b = visitRecordList;
        this.c = j;
    }

    public static final /* synthetic */ void d(r rVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        Lazy<KSerializer<Object>>[] lazyArr = d;
        boolean z2 = false;
        dVar.encodeStringElement(serialDescriptor, 0, rVar.a);
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || !Intrinsics.areEqual(rVar.b, new ArrayList())) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeSerializableElement(serialDescriptor, 1, lazyArr[1].getValue(), rVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || rVar.c != 0) {
            z2 = true;
        }
        if (z2) {
            dVar.encodeLongElement(serialDescriptor, 2, rVar.c);
        }
    }

    public /* synthetic */ r(int i, String str, List list, long j, q2 q2Var) {
        if (1 != (i & 1)) {
            b2.b(i, 1, a.a.getDescriptor());
        }
        this.a = str;
        if ((i & 2) == 0) {
            this.b = new ArrayList();
        } else {
            this.b = list;
        }
        if ((i & 4) == 0) {
            this.c = 0L;
        } else {
            this.c = j;
        }
    }

    public /* synthetic */ r(String str, List list, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new ArrayList() : list, (i & 4) != 0 ? 0L : j);
    }
}
