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
public final class q {
    public static final b Companion;
    public final boolean a;
    public final boolean b;
    public final boolean c;

    static {
        Covode.recordClassIndex(607801);
        Companion = new b(null);
    }

    public q() {
        this(false, false, false, 7, (DefaultConstructorMarker) null);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(607802);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<q> serializer() {
            return a.a;
        }

        public final q b() {
            return new q(false, false, false, 7, (DefaultConstructorMarker) null);
        }

        public final q a() {
            String str;
            Object m773constructorimpl;
            yg4.a aVar = yg4.a.a;
            com.dragon.read.kmp.service.l lVar = (com.dragon.read.kmp.service.l) eo0.c.a.a(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.service.l.class));
            Object obj = null;
            boolean z = true;
            if (lVar != null) {
                str = lVar.k0("custom_profile_album_landing_opt", "", true, true);
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
                    m773constructorimpl = Result.m773constructorimpl(c.c(q.Companion.serializer(), str));
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
            q qVar = (q) obj;
            if (qVar == null) {
                return b();
            }
            return qVar;
        }
    }

    public /* synthetic */ class a implements kotlinx.serialization.internal.m0<q> {
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
            kotlinx.serialization.internal.i iVar = kotlinx.serialization.internal.i.a;
            return new KSerializer[]{iVar, iVar, iVar};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.model.CustomProfileAlbumLandingOpt", aVar, 3);
            g2Var.g("enable_default_landing_hot_opt", true);
            g2Var.g("enable_custom_profile_recommond_landing_opt", true);
            g2Var.g("enable_recent_float_enhance", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final q deserialize(Decoder decoder) {
            boolean z;
            boolean z2;
            boolean z3;
            int i;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                z = decodeBooleanElement;
                z2 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                z3 = decodeBooleanElement2;
                i = 7;
            } else {
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                int i2 = 0;
                boolean z7 = true;
                while (z7) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex == 2) {
                                    z5 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                                    i2 |= 4;
                                } else {
                                    throw new UnknownFieldException(decodeElementIndex);
                                }
                            } else {
                                z6 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                                i2 |= 2;
                            }
                        } else {
                            z4 = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                            i2 |= 1;
                        }
                    } else {
                        z7 = false;
                    }
                }
                z = z4;
                z2 = z5;
                z3 = z6;
                i = i2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new q(i, z, z3, z2, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, q value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            q.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public q(boolean z, boolean z2, boolean z3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
    }

    public static final /* synthetic */ void a(q qVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || qVar.a) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeBooleanElement(serialDescriptor, 0, qVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || qVar.b) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeBooleanElement(serialDescriptor, 1, qVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || qVar.c) {
            z3 = true;
        }
        if (z3) {
            dVar.encodeBooleanElement(serialDescriptor, 2, qVar.c);
        }
    }

    public /* synthetic */ q(int i, boolean z, boolean z2, boolean z3, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = false;
        } else {
            this.a = z;
        }
        if ((i & 2) == 0) {
            this.b = false;
        } else {
            this.b = z2;
        }
        if ((i & 4) == 0) {
            this.c = false;
        } else {
            this.c = z3;
        }
    }

    public /* synthetic */ q(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }
}
