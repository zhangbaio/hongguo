package gk4;

import com.bytedance.covode.number.Covode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.g2;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q2;
import yn0.a;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l0 {
    public static final b Companion;
    public final boolean a;

    static {
        Covode.recordClassIndex(607838);
        Companion = new b(null);
    }

    public l0() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(607839);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<l0> serializer() {
            return a.a;
        }

        public final l0 b() {
            return new l0(false, 1, (DefaultConstructorMarker) null);
        }

        public final l0 a() {
            String str;
            Object m773constructorimpl;
            yg4.a aVar = yg4.a.a;
            com.dragon.read.kmp.service.l lVar = (com.dragon.read.kmp.service.l) eo0.c.a.a(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.service.l.class));
            Object obj = null;
            boolean z = true;
            if (lVar != null) {
                str = lVar.k0("short_video_profile_followed_recommend_v709", "", true, true);
            } else {
                str = null;
            }
            com.dragon.read.kmp.utils.v vVar = com.dragon.read.kmp.utils.v.a;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (!z) {
                try {
                    Result.Companion companion = Result.Companion;
                    gn6.a c = com.dragon.read.kmp.base.h.c();
                    c.getSerializersModule();
                    m773constructorimpl = Result.m773constructorimpl(c.c(l0.Companion.serializer(), str));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
                }
                Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
                if (m776exceptionOrNullimpl != null) {
                    a.a.b(yn0.b.b, "JSONUtils", "fromJson json error " + m776exceptionOrNullimpl.getMessage(), false, 4, (Object) null);
                }
                if (!Result.m779isFailureimpl(m773constructorimpl)) {
                    obj = m773constructorimpl;
                }
            }
            l0 l0Var = (l0) obj;
            if (l0Var == null) {
                return b();
            }
            return l0Var;
        }
    }

    public /* synthetic */ class a implements kotlinx.serialization.internal.m0<l0> {
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

        public final KSerializer<?>[] b() {
            return new KSerializer[]{kotlinx.serialization.internal.i.a};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.model.ShortVideoProfileFollowedRecommendV709", aVar, 1);
            g2Var.g("enable", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final l0 deserialize(Decoder decoder) {
            boolean z;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            int i = 1;
            if (beginStructure.decodeSequentially()) {
                z = beginStructure.decodeBooleanElement(serialDescriptor, 0);
            } else {
                z = false;
                int i2 = 0;
                while (i != 0) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex == 0) {
                            z = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                            i2 |= 1;
                        } else {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                    } else {
                        i = 0;
                    }
                }
                i = i2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new l0(i, z, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, l0 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            l0.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public l0(boolean z) {
        this.a = z;
    }

    public /* synthetic */ l0(int i, boolean z, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = false;
        } else {
            this.a = z;
        }
    }

    public static final /* synthetic */ void a(l0 l0Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z = true;
        if (!dVar.shouldEncodeElementDefault(serialDescriptor, 0) && !l0Var.a) {
            z = false;
        }
        if (z) {
            dVar.encodeBooleanElement(serialDescriptor, 0, l0Var.a);
        }
    }

    public /* synthetic */ l0(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
