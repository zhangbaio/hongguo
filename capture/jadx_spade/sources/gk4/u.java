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
public final class u {
    public static final b Companion;
    private static final u c;
    public final boolean a;
    public final float b;

    public u() {
        this(false, 0.0f, 3, (DefaultConstructorMarker) null);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(607808);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<u> serializer() {
            return a.a;
        }

        public final u a() {
            String str;
            Object m773constructorimpl;
            yg4.a aVar = yg4.a.a;
            com.dragon.read.kmp.service.l lVar = (com.dragon.read.kmp.service.l) eo0.c.a.a(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.service.l.class));
            Object obj = null;
            boolean z = true;
            if (lVar != null) {
                str = lVar.k0("guest_tab_follow_guide_scroll_gate", "", true, true);
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
                    m773constructorimpl = Result.m773constructorimpl(c.c(u.Companion.serializer(), str));
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
            u uVar = (u) obj;
            if (uVar == null) {
                return u.c;
            }
            return uVar;
        }
    }

    public /* synthetic */ class a implements kotlinx.serialization.internal.m0<u> {
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
            return new KSerializer[]{kotlinx.serialization.internal.i.a, kotlinx.serialization.internal.l0.a};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.model.GuestTabFollowGuideScrollGateV717", aVar, 2);
            g2Var.g("enable", true);
            g2Var.g("scroll_threshold_y", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final u deserialize(Decoder decoder) {
            boolean z;
            float f;
            int i;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                z = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                f = beginStructure.decodeFloatElement(serialDescriptor, 1);
                i = 3;
            } else {
                z = false;
                float f2 = 0.0f;
                int i2 = 0;
                boolean z2 = true;
                while (z2) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex == 1) {
                                f2 = beginStructure.decodeFloatElement(serialDescriptor, 1);
                                i2 |= 2;
                            } else {
                                throw new UnknownFieldException(decodeElementIndex);
                            }
                        } else {
                            z = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                            i2 |= 1;
                        }
                    } else {
                        z2 = false;
                    }
                }
                f = f2;
                i = i2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new u(i, z, f, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, u value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            u.b(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    static {
        Covode.recordClassIndex(607807);
        DefaultConstructorMarker defaultConstructorMarker = null;
        Companion = new b(defaultConstructorMarker);
        c = new u(false, 0.0f, 3, defaultConstructorMarker);
    }

    public u(boolean z, float f) {
        this.a = z;
        this.b = f;
    }

    public static final /* synthetic */ void b(u uVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || uVar.a) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeBooleanElement(serialDescriptor, 0, uVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || Float.compare(uVar.b, 0.0f) != 0) {
            z2 = true;
        }
        if (z2) {
            dVar.encodeFloatElement(serialDescriptor, 1, uVar.b);
        }
    }

    public /* synthetic */ u(boolean z, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0.0f : f);
    }

    public /* synthetic */ u(int i, boolean z, float f, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = false;
        } else {
            this.a = z;
        }
        if ((i & 2) == 0) {
            this.b = 0.0f;
        } else {
            this.b = f;
        }
    }
}
