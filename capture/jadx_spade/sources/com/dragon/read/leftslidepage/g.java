package com.dragon.read.leftslidepage;

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
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q2;
import yn0.a;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final b Companion;
    private static final g e;
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    public g() {
        this(false, false, false, false, 15, (DefaultConstructorMarker) null);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(611249);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<g> serializer() {
            return a.a;
        }

        public final g a() {
            String str;
            Object m773constructorimpl;
            yg4.a aVar = yg4.a.a;
            com.dragon.read.kmp.service.l lVar = (com.dragon.read.kmp.service.l) eo0.c.a.a(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.service.l.class));
            Object obj = null;
            boolean z = true;
            if (lVar != null) {
                str = lVar.k0("feed_left_drawer_subscribe_section_v717", "", true, true);
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
                    m773constructorimpl = Result.m773constructorimpl(c.c(g.Companion.serializer(), str));
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
            g gVar = (g) obj;
            if (gVar == null) {
                return g.e;
            }
            return gVar;
        }
    }

    public /* synthetic */ class a implements kotlinx.serialization.internal.m0<g> {
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
            return new KSerializer[]{iVar, iVar, iVar, iVar};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.leftslidepage.KmpFeedLeftDrawerSubscribeSectionConfig", aVar, 4);
            g2Var.g("show_subscribe", true);
            g2Var.g("show_follow", true);
            g2Var.g("show_function_subscribe_title", true);
            g2Var.g("show_function_follow_title", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final g deserialize(Decoder decoder) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            int i;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                z = decodeBooleanElement;
                z2 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                z3 = decodeBooleanElement3;
                z4 = decodeBooleanElement2;
                i = 15;
            } else {
                boolean z5 = false;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                int i2 = 0;
                boolean z9 = true;
                while (z9) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex != 2) {
                                    if (decodeElementIndex == 3) {
                                        z6 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                                        i2 |= 8;
                                    } else {
                                        throw new UnknownFieldException(decodeElementIndex);
                                    }
                                } else {
                                    z7 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                                    i2 |= 4;
                                }
                            } else {
                                z8 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                                i2 |= 2;
                            }
                        } else {
                            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                            i2 |= 1;
                        }
                    } else {
                        z9 = false;
                    }
                }
                z = z5;
                z2 = z6;
                z3 = z7;
                z4 = z8;
                i = i2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new g(i, z, z4, z3, z2, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, g value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            g.b(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    static {
        Covode.recordClassIndex(611248);
        Companion = new b(null);
        yg4.a.c(yg4.a.a, "feed_left_drawer_subscribe_section_v717", "侧边栏 预约/追更 模块开关", (String) null, 4, (Object) null);
        e = new g(false, false, false, false, 15, (DefaultConstructorMarker) null);
    }

    public static final /* synthetic */ void b(g gVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || gVar.a) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeBooleanElement(serialDescriptor, 0, gVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || gVar.b) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeBooleanElement(serialDescriptor, 1, gVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || gVar.c) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeBooleanElement(serialDescriptor, 2, gVar.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || gVar.d) {
            z4 = true;
        }
        if (z4) {
            dVar.encodeBooleanElement(serialDescriptor, 3, gVar.d);
        }
    }

    public g(boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
    }

    public /* synthetic */ g(int i, boolean z, boolean z2, boolean z3, boolean z4, q2 q2Var) {
        if ((i & 0) != 0) {
            kotlinx.serialization.internal.b2.b(i, 0, a.a.getDescriptor());
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
        if ((i & 8) == 0) {
            this.d = false;
        } else {
            this.d = z4;
        }
    }

    public /* synthetic */ g(boolean z, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4);
    }
}
