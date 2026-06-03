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
public final class f {
    public static final b Companion;
    private static final f b;
    public final boolean a;

    public f() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(611247);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<f> serializer() {
            return a.a;
        }

        public final f a() {
            String str;
            Object m773constructorimpl;
            yg4.a aVar = yg4.a.a;
            com.dragon.read.kmp.service.l lVar = (com.dragon.read.kmp.service.l) eo0.c.a.a(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.service.l.class));
            Object obj = null;
            boolean z = true;
            if (lVar != null) {
                str = lVar.k0("feed_left_drawer_recent_watch_v717", "", true, true);
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
                    m773constructorimpl = Result.m773constructorimpl(c.c(f.Companion.serializer(), str));
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
            f fVar = (f) obj;
            if (fVar == null) {
                return f.b;
            }
            return fVar;
        }
    }

    public /* synthetic */ class a implements kotlinx.serialization.internal.m0<f> {
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
            kotlinx.serialization.internal.g2 g2Var = new kotlinx.serialization.internal.g2("com.dragon.read.leftslidepage.KmpFeedLeftDrawerRecentWatchConfig", aVar, 1);
            g2Var.g("grid_style", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final f deserialize(Decoder decoder) {
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
            return new f(i, z, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, f value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            f.b(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    static {
        Covode.recordClassIndex(611246);
        DefaultConstructorMarker defaultConstructorMarker = null;
        Companion = new b(defaultConstructorMarker);
        yg4.a.c(yg4.a.a, "feed_left_drawer_recent_watch_v717", "侧边栏 最近在看 网格样式", (String) null, 4, (Object) null);
        b = new f(false, 1, defaultConstructorMarker);
    }

    public f(boolean z) {
        this.a = z;
    }

    public /* synthetic */ f(int i, boolean z, q2 q2Var) {
        if ((i & 0) != 0) {
            kotlinx.serialization.internal.b2.b(i, 0, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = false;
        } else {
            this.a = z;
        }
    }

    public static final /* synthetic */ void b(f fVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z = true;
        if (!dVar.shouldEncodeElementDefault(serialDescriptor, 0) && !fVar.a) {
            z = false;
        }
        if (z) {
            dVar.encodeBooleanElement(serialDescriptor, 0, fVar.a);
        }
    }

    public /* synthetic */ f(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
