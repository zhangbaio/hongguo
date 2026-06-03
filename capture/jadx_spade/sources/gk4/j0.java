package gk4;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
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
import kotlinx.serialization.internal.v0;
import yn0.a;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j0 {
    public static final b Companion;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    static {
        Covode.recordClassIndex(607832);
        Companion = new b(null);
    }

    public j0() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 255, (DefaultConstructorMarker) null);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(607833);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<j0> serializer() {
            return a.a;
        }

        public final j0 b() {
            return new j0(0, 0, 0, 0, 0, 0, 0, 0, 255, (DefaultConstructorMarker) null);
        }

        public final j0 a() {
            String str;
            Object m773constructorimpl;
            yg4.a aVar = yg4.a.a;
            com.dragon.read.kmp.service.l lVar = (com.dragon.read.kmp.service.l) eo0.c.a.a(Reflection.getOrCreateKotlinClass(com.dragon.read.kmp.service.l.class));
            Object obj = null;
            boolean z = true;
            if (lVar != null) {
                str = lVar.k0("short_video_profile_follow_config_v709", "", true, true);
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
                    m773constructorimpl = Result.m773constructorimpl(c.c(j0.Companion.serializer(), str));
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
            j0 j0Var = (j0) obj;
            if (j0Var == null) {
                return b();
            }
            return j0Var;
        }
    }

    public /* synthetic */ class a implements kotlinx.serialization.internal.m0<j0> {
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
            v0 v0Var = v0.a;
            return new KSerializer[]{v0Var, v0Var, v0Var, v0Var, v0Var, v0Var, v0Var, v0Var};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.model.ShortVideoProfileFollowConfigV709", aVar, 8);
            g2Var.g("daily_max_count", true);
            g2Var.g("popup_interval_times", true);
            g2Var.g("same_user_interval_times", true);
            g2Var.g("consume_interval_days", true);
            g2Var.g("consume_same_user_count", true);
            g2Var.g("single_consume_same_user_times", true);
            g2Var.g("filter_recommend_follow_user_count", true);
            g2Var.g("recommend_follow_user_show_interval_times", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final j0 deserialize(Decoder decoder) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            int i10 = 0;
            if (beginStructure.decodeSequentially()) {
                int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
                int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 1);
                int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 2);
                int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 3);
                int decodeIntElement5 = beginStructure.decodeIntElement(serialDescriptor, 4);
                int decodeIntElement6 = beginStructure.decodeIntElement(serialDescriptor, 5);
                int decodeIntElement7 = beginStructure.decodeIntElement(serialDescriptor, 6);
                i3 = decodeIntElement;
                i = beginStructure.decodeIntElement(serialDescriptor, 7);
                i2 = decodeIntElement7;
                i5 = decodeIntElement6;
                i7 = decodeIntElement4;
                i9 = decodeIntElement5;
                i8 = decodeIntElement3;
                i6 = decodeIntElement2;
                i4 = 255;
            } else {
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                boolean z = true;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            z = false;
                            break;
                        case 0:
                            i10 |= 1;
                            i11 = beginStructure.decodeIntElement(serialDescriptor, 0);
                            continue;
                        case 1:
                            i18 = beginStructure.decodeIntElement(serialDescriptor, 1);
                            i10 |= 2;
                            continue;
                        case 2:
                            i17 = beginStructure.decodeIntElement(serialDescriptor, 2);
                            i10 |= 4;
                            break;
                        case 3:
                            i15 = beginStructure.decodeIntElement(serialDescriptor, 3);
                            i10 |= 8;
                            break;
                        case 4:
                            i16 = beginStructure.decodeIntElement(serialDescriptor, 4);
                            i10 |= 16;
                            break;
                        case 5:
                            i14 = beginStructure.decodeIntElement(serialDescriptor, 5);
                            i10 |= 32;
                            break;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            i13 = beginStructure.decodeIntElement(serialDescriptor, 6);
                            i10 |= 64;
                            break;
                        case 7:
                            i12 = beginStructure.decodeIntElement(serialDescriptor, 7);
                            i10 |= 128;
                            break;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                i = i12;
                i2 = i13;
                i3 = i11;
                i4 = i10;
                int i19 = i18;
                i5 = i14;
                i6 = i19;
                int i20 = i16;
                i7 = i15;
                i8 = i17;
                i9 = i20;
            }
            beginStructure.endStructure(serialDescriptor);
            return new j0(i4, i3, i6, i8, i7, i9, i5, i2, i, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, j0 value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            j0.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final /* synthetic */ void a(j0 j0Var, kotlinx.serialization.encoding.d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || j0Var.a != 3) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeIntElement(serialDescriptor, 0, j0Var.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || j0Var.b != 120) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeIntElement(serialDescriptor, 1, j0Var.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || j0Var.c != 300) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeIntElement(serialDescriptor, 2, j0Var.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || j0Var.d != 7) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeIntElement(serialDescriptor, 3, j0Var.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || j0Var.e != 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            dVar.encodeIntElement(serialDescriptor, 4, j0Var.e);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 5) || j0Var.f != 30) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            dVar.encodeIntElement(serialDescriptor, 5, j0Var.f);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 6) || j0Var.g != 500) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            dVar.encodeIntElement(serialDescriptor, 6, j0Var.g);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 7) || j0Var.h != 120) {
            z8 = true;
        }
        if (z8) {
            dVar.encodeIntElement(serialDescriptor, 7, j0Var.h);
        }
    }

    public j0(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ j0(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto L8
            r1 = 3
            goto L9
        L8:
            r1 = r10
        L9:
            r2 = r0 & 2
            r3 = 120(0x78, float:1.68E-43)
            if (r2 == 0) goto L12
            r2 = 120(0x78, float:1.68E-43)
            goto L13
        L12:
            r2 = r11
        L13:
            r4 = r0 & 4
            if (r4 == 0) goto L1a
            r4 = 300(0x12c, float:4.2E-43)
            goto L1b
        L1a:
            r4 = r12
        L1b:
            r5 = r0 & 8
            if (r5 == 0) goto L21
            r5 = 7
            goto L22
        L21:
            r5 = r13
        L22:
            r6 = r0 & 16
            if (r6 == 0) goto L28
            r6 = 2
            goto L29
        L28:
            r6 = r14
        L29:
            r7 = r0 & 32
            if (r7 == 0) goto L30
            r7 = 30
            goto L31
        L30:
            r7 = r15
        L31:
            r8 = r0 & 64
            if (r8 == 0) goto L38
            r8 = 500(0x1f4, float:7.0E-43)
            goto L3a
        L38:
            r8 = r16
        L3a:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L3f
            goto L41
        L3f:
            r3 = r17
        L41:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gk4.j0.<init>(int, int, int, int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public /* synthetic */ j0(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, a.a.getDescriptor());
        }
        this.a = (i & 1) == 0 ? 3 : i2;
        if ((i & 2) == 0) {
            this.b = 120;
        } else {
            this.b = i3;
        }
        if ((i & 4) == 0) {
            this.c = 300;
        } else {
            this.c = i4;
        }
        if ((i & 8) == 0) {
            this.d = 7;
        } else {
            this.d = i5;
        }
        if ((i & 16) == 0) {
            this.e = 2;
        } else {
            this.e = i6;
        }
        if ((i & 32) == 0) {
            this.f = 30;
        } else {
            this.f = i7;
        }
        if ((i & 64) == 0) {
            this.g = 500;
        } else {
            this.g = i8;
        }
        if ((i & 128) == 0) {
            this.h = 120;
        } else {
            this.h = i9;
        }
    }
}
