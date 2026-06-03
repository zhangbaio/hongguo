package il4;

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
    private static final a e;
    public final boolean a;
    public final boolean b;
    public final int c;
    public final boolean d;

    public a() {
        this(false, false, 0, false, 15, (DefaultConstructorMarker) null);
    }

    public static final class b {
        static {
            Covode.recordClassIndex(608122);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<a> serializer() {
            return C0170a.a;
        }

        public final a a() {
            String str;
            Object m773constructorimpl;
            yg4.a aVar = yg4.a.a;
            l lVar = (l) c.a.a(Reflection.getOrCreateKotlinClass(l.class));
            Object obj = null;
            boolean z = true;
            if (lVar != null) {
                str = lVar.k0("album_detail_optimize_v709", "", true, true);
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
                return a.e;
            }
            return aVar2;
        }
    }

    /* renamed from: il4.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0170a implements m0<a> {
        public static final C0170a a;
        public static final int b;
        private static final SerialDescriptor descriptor;

        private C0170a() {
        }

        public final SerialDescriptor getDescriptor() {
            return descriptor;
        }

        public KSerializer<?>[] a() {
            return m0.a.a(this);
        }

        public final KSerializer<?>[] b() {
            i iVar = i.a;
            return new KSerializer[]{iVar, iVar, v0.a, iVar};
        }

        static {
            C0170a c0170a = new C0170a();
            a = c0170a;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.profile.guestprofile.album.config.ProfileAlbumOptConfig", c0170a, 4);
            g2Var.g("enable_pin_top", true);
            g2Var.g("opt_collect", true);
            g2Var.g("album_subInfo_type", true);
            g2Var.g("enable_album_cover_show_digg", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final a deserialize(Decoder decoder) {
            boolean z;
            boolean z2;
            int i;
            boolean z3;
            int i2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 2);
                z = decodeBooleanElement;
                z2 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                i = decodeIntElement;
                z3 = decodeBooleanElement2;
                i2 = 15;
            } else {
                boolean z4 = false;
                boolean z5 = false;
                int i3 = 0;
                boolean z6 = false;
                int i4 = 0;
                boolean z7 = true;
                while (z7) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex != 2) {
                                    if (decodeElementIndex == 3) {
                                        z5 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                                        i4 |= 8;
                                    } else {
                                        throw new UnknownFieldException(decodeElementIndex);
                                    }
                                } else {
                                    i3 = beginStructure.decodeIntElement(serialDescriptor, 2);
                                    i4 |= 4;
                                }
                            } else {
                                z6 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                                i4 |= 2;
                            }
                        } else {
                            z4 = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                            i4 |= 1;
                        }
                    } else {
                        z7 = false;
                    }
                }
                z = z4;
                z2 = z5;
                i = i3;
                z3 = z6;
                i2 = i4;
            }
            beginStructure.endStructure(serialDescriptor);
            return new a(i2, z, z3, i, z2, (q2) null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, a value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            d beginStructure = encoder.beginStructure(serialDescriptor);
            a.d(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public final boolean c() {
        if (this.c == 1) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        if (this.c == 2) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(608121);
        Companion = new b(null);
        e = new a(false, false, 0, false, 15, (DefaultConstructorMarker) null);
    }

    public static final /* synthetic */ void d(a aVar, d dVar, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 0) || aVar.a) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar.encodeBooleanElement(serialDescriptor, 0, aVar.a);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 1) || aVar.b) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar.encodeBooleanElement(serialDescriptor, 1, aVar.b);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 2) || aVar.c != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            dVar.encodeIntElement(serialDescriptor, 2, aVar.c);
        }
        if (dVar.shouldEncodeElementDefault(serialDescriptor, 3) || aVar.d) {
            z4 = true;
        }
        if (z4) {
            dVar.encodeBooleanElement(serialDescriptor, 3, aVar.d);
        }
    }

    public a(boolean z, boolean z2, int i, boolean z3) {
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = z3;
    }

    public /* synthetic */ a(int i, boolean z, boolean z2, int i2, boolean z3, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, C0170a.a.getDescriptor());
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
            this.c = 0;
        } else {
            this.c = i2;
        }
        if ((i & 8) == 0) {
            this.d = false;
        } else {
            this.d = z3;
        }
    }

    public /* synthetic */ a(boolean z, boolean z2, int i, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? false : z3);
    }
}
