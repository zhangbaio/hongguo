package com.dragon.read.kmp.star_fans;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.service.l;
import com.dragon.read.kmp.utils.v;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
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
import kotlinx.serialization.internal.u0;
import kotlinx.serialization.internal.v0;
import yn0.a;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final b Companion;
    public static final int d;
    private static final f e;
    public final int[] a;
    public final int b;
    public final boolean c;

    public f() {
        this((int[]) null, 0, false, 7, (DefaultConstructorMarker) null);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(609154);
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
            boolean z;
            Object m773constructorimpl;
            yg4.a aVar = yg4.a.a;
            l lVar = (l) eo0.c.a.a(Reflection.getOrCreateKotlinClass(l.class));
            Object obj = null;
            if (lVar != null) {
                str = lVar.L9("star_fans_task_retry_config_v721", "");
            } else {
                str = null;
            }
            v vVar = v.a;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
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
                return f.e;
            }
            return fVar;
        }
    }

    public /* synthetic */ class a implements m0<f> {
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
            return new KSerializer[]{u0.c, v0.a, kotlinx.serialization.internal.i.a};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.star_fans.StarFansTaskConfig", aVar, 3);
            g2Var.g("non_retry_err_codes", true);
            g2Var.g("max_retry_count", true);
            g2Var.g("enable_task_list_prefetch", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final f deserialize(Decoder decoder) {
            boolean z;
            int i;
            int i2;
            int[] iArr;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                int[] iArr2 = (int[]) beginStructure.decodeSerializableElement(serialDescriptor, 0, u0.c, null);
                int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
                iArr = iArr2;
                z = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                i = decodeIntElement;
                i2 = 7;
            } else {
                int[] iArr3 = null;
                boolean z2 = false;
                int i3 = 0;
                int i4 = 0;
                boolean z3 = true;
                while (z3) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex == 2) {
                                    z2 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                                    i4 |= 4;
                                } else {
                                    throw new UnknownFieldException(decodeElementIndex);
                                }
                            } else {
                                i3 = beginStructure.decodeIntElement(serialDescriptor, 1);
                                i4 |= 2;
                            }
                        } else {
                            iArr3 = (int[]) beginStructure.decodeSerializableElement(serialDescriptor, 0, u0.c, iArr3);
                            i4 |= 1;
                        }
                    } else {
                        z3 = false;
                    }
                }
                z = z2;
                i = i3;
                i2 = i4;
                iArr = iArr3;
            }
            beginStructure.endStructure(serialDescriptor);
            return new f(i2, iArr, i, z, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, f value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            f.d(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    static {
        Covode.recordClassIndex(609153);
        Companion = new b(null);
        d = 8;
        e = new f((int[]) null, 0, false, 7, (DefaultConstructorMarker) null);
    }

    public final boolean b(Integer num) {
        if (num == null) {
            return false;
        }
        return ArraysKt___ArraysKt.contains(this.a, num.intValue());
    }

    public final boolean c(int i) {
        int i2 = this.b;
        if (i2 < 0 || i <= i2) {
            return false;
        }
        return true;
    }

    public f(int[] nonRetryErrCodes, int i, boolean z) {
        Intrinsics.checkNotNullParameter(nonRetryErrCodes, "nonRetryErrCodes");
        this.a = nonRetryErrCodes;
        this.b = i;
        this.c = z;
    }

    public static final /* synthetic */ void d(f fVar, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || !Intrinsics.areEqual(fVar.a, new int[]{10002, 10006, 10007, 10009})) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeSerializableElement(serialDescriptor, 0, u0.c, fVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || fVar.b != 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeIntElement(serialDescriptor, 1, fVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || fVar.c) {
            z3 = true;
        }
        if (z3) {
            dVar.encodeBooleanElement(serialDescriptor, 2, fVar.c);
        }
    }

    public /* synthetic */ f(int i, int[] iArr, int i2, boolean z, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = new int[]{10002, 10006, 10007, 10009};
        } else {
            this.a = iArr;
        }
        if ((i & 2) == 0) {
            this.b = 3;
        } else {
            this.b = i2;
        }
        if ((i & 4) == 0) {
            this.c = false;
        } else {
            this.c = z;
        }
    }

    public /* synthetic */ f(int[] iArr, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new int[]{10002, 10006, 10007, 10009} : iArr, (i2 & 2) != 0 ? 3 : i, (i2 & 4) != 0 ? false : z);
    }
}
