package en4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.h;
import com.dragon.read.kmp.service.l;
import com.dragon.read.kmp.utils.v;
import eo0.c;
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
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.b2;
import kotlinx.serialization.internal.g2;
import kotlinx.serialization.internal.i;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q2;
import kotlinx.serialization.internal.v0;
import yn0.a;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final b Companion;
    private static final a f;
    public final boolean a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public a() {
        this(false, 0, false, false, false, 31, (DefaultConstructorMarker) null);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(608758);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<a> serializer() {
            return C0152a.a;
        }

        public final a a() {
            String str;
            Object m773constructorimpl;
            yg4.a aVar = yg4.a.a;
            l lVar = (l) c.a.a(Reflection.getOrCreateKotlinClass(l.class));
            Object obj = null;
            boolean z = true;
            if (lVar != null) {
                str = lVar.k0("search_post_card_ui_experiment_v721", "", true, true);
            } else {
                str = null;
            }
            v vVar = v.a;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (!z) {
                try {
                    Result.Companion companion = Result.Companion;
                    gn6.a c = h.c();
                    c.getSerializersModule();
                    m773constructorimpl = Result.m773constructorimpl(c.c(a.Companion.serializer(), str));
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
            a aVar2 = (a) obj;
            if (aVar2 == null) {
                return a.f;
            }
            return aVar2;
        }
    }

    /* renamed from: en4.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0152a implements m0<a> {
        public static final C0152a a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        private C0152a() {
        }

        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        public KSerializer<?>[] a() {
            return m0.a.a(this);
        }

        public final KSerializer<?>[] b() {
            i iVar = i.a;
            return new KSerializer[]{iVar, v0.a, iVar, iVar, iVar};
        }

        static {
            C0152a c0152a = new C0152a();
            a = c0152a;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.search.config.SearchPostCardUiExperiment", c0152a, 5);
            g2Var.g("enable_avatar_size_opt", true);
            g2Var.g("avatar_size_dp", true);
            g2Var.g("enable_opt", true);
            g2Var.g("enable_result_tab_breath_skeleton", true);
            g2Var.g("enable_exit_landscape_before_half_search", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final a deserialize(Decoder decoder) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            int i;
            int i2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
                boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                z = decodeBooleanElement;
                z2 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                z3 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
                z4 = decodeBooleanElement2;
                i = decodeIntElement;
                i2 = 31;
            } else {
                boolean z5 = false;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                int i3 = 0;
                int i4 = 0;
                boolean z9 = true;
                while (z9) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex != 2) {
                                    if (decodeElementIndex != 3) {
                                        if (decodeElementIndex == 4) {
                                            z7 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
                                            i4 |= 16;
                                        } else {
                                            throw new UnknownFieldException(decodeElementIndex);
                                        }
                                    } else {
                                        z6 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                                        i4 |= 8;
                                    }
                                } else {
                                    z8 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                                    i4 |= 4;
                                }
                            } else {
                                i3 = beginStructure.decodeIntElement(serialDescriptor, 1);
                                i4 |= 2;
                            }
                        } else {
                            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                            i4 |= 1;
                        }
                    } else {
                        z9 = false;
                    }
                }
                z = z5;
                z2 = z6;
                z3 = z7;
                z4 = z8;
                i = i3;
                i2 = i4;
            }
            beginStructure.endStructure(serialDescriptor);
            return new a(i2, z, i, z4, z2, z3, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, a value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            d beginStructure = encoder.beginStructure(serialDescriptor);
            a.b(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    static {
        Covode.recordClassIndex(608757);
        Companion = new b(null);
        f = new a(false, 0, false, false, false, 31, (DefaultConstructorMarker) null);
    }

    public static final /* synthetic */ void b(a aVar, d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || aVar.a) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeBooleanElement(serialDescriptor, 0, aVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || aVar.b != 16) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeIntElement(serialDescriptor, 1, aVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || aVar.c) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeBooleanElement(serialDescriptor, 2, aVar.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || aVar.d) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            dVar.encodeBooleanElement(serialDescriptor, 3, aVar.d);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 4) || aVar.e) {
            z5 = true;
        }
        if (z5) {
            dVar.encodeBooleanElement(serialDescriptor, 4, aVar.e);
        }
    }

    public a(boolean z, int i, boolean z2, boolean z3, boolean z4) {
        this.a = z;
        this.b = i;
        this.c = z2;
        this.d = z3;
        this.e = z4;
    }

    public /* synthetic */ a(int i, boolean z, int i2, boolean z2, boolean z3, boolean z4, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, C0152a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.a = false;
        } else {
            this.a = z;
        }
        if ((i & 2) == 0) {
            this.b = 16;
        } else {
            this.b = i2;
        }
        if ((i & 4) == 0) {
            this.c = false;
        } else {
            this.c = z2;
        }
        if ((i & 8) == 0) {
            this.d = false;
        } else {
            this.d = z3;
        }
        if ((i & 16) == 0) {
            this.e = false;
        } else {
            this.e = z4;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(boolean r6, int r7, boolean r8, boolean r9, boolean r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r5 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L7
            r12 = 0
            goto L8
        L7:
            r12 = r6
        L8:
            r6 = r11 & 2
            r1 = 16
            if (r6 == 0) goto L11
            r2 = 16
            goto L12
        L11:
            r2 = r7
        L12:
            r6 = r11 & 4
            if (r6 == 0) goto L18
            r3 = 0
            goto L19
        L18:
            r3 = r8
        L19:
            r6 = r11 & 8
            if (r6 == 0) goto L1f
            r4 = 0
            goto L20
        L1f:
            r4 = r9
        L20:
            r6 = r11 & 16
            if (r6 == 0) goto L26
            r11 = 0
            goto L27
        L26:
            r11 = r10
        L27:
            r6 = r5
            r7 = r12
            r8 = r2
            r9 = r3
            r10 = r4
            r6.<init>(r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: en4.a.<init>(boolean, int, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
