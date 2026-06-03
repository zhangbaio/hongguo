package com.dragon.read.kmp.vip.impl.ui;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;
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
import kotlinx.serialization.internal.v0;
import kotlinx.serialization.internal.v2;
import zm6.l;
import zm6.m;

@Serializable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final b Companion;
    public static final int d;
    private static int e;
    public long a;
    public int b;
    public String c;

    public static final class b {
        static {
            Covode.recordClassIndex(609612);
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<d> serializer() {
            return a.a;
        }

        public final void b(int i) {
            d.e = i;
        }

        public final d a(String userId) {
            boolean z;
            Intrinsics.checkNotNullParameter(userId, "userId");
            String string = xn0.c.a("chapter_end_vip_coupon_kv_repo").getString("chapter_end_vip_coupon_config_" + userId, "");
            if (string.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                gn6.a c = h.c();
                c.getSerializersModule();
                d dVar = (d) c.c(en6.a.u(d.Companion.serializer()), string);
                if (dVar == null) {
                    d dVar2 = new d();
                    dVar2.g(userId);
                    return dVar2;
                }
                return dVar;
            }
            d dVar3 = new d();
            dVar3.g(userId);
            return dVar3;
        }
    }

    private final int b() {
        return e;
    }

    public /* synthetic */ class a implements m0<d> {
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
            return new KSerializer[]{g1.a, v0.a, v2.a};
        }

        static {
            a aVar = new a();
            a = aVar;
            b = 8;
            g2 g2Var = new g2("com.dragon.read.kmp.vip.impl.ui.VipCouponShowConfig", aVar, 3);
            g2Var.g("show_time", true);
            g2Var.g("count", true);
            g2Var.g("user_id", true);
            descriptor = g2Var;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final d deserialize(Decoder decoder) {
            int i;
            String str;
            int i2;
            long j;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.c beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
                i = beginStructure.decodeIntElement(serialDescriptor, 1);
                str = beginStructure.decodeStringElement(serialDescriptor, 2);
                j = decodeLongElement;
                i2 = 7;
            } else {
                long j2 = 0;
                int i3 = 0;
                boolean z = true;
                String str2 = null;
                int i4 = 0;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex != -1) {
                        if (decodeElementIndex != 0) {
                            if (decodeElementIndex != 1) {
                                if (decodeElementIndex == 2) {
                                    str2 = beginStructure.decodeStringElement(serialDescriptor, 2);
                                    i3 |= 4;
                                } else {
                                    throw new UnknownFieldException(decodeElementIndex);
                                }
                            } else {
                                i4 = beginStructure.decodeIntElement(serialDescriptor, 1);
                                i3 |= 2;
                            }
                        } else {
                            j2 = beginStructure.decodeLongElement(serialDescriptor, 0);
                            i3 |= 1;
                        }
                    } else {
                        z = false;
                    }
                }
                i = i4;
                str = str2;
                i2 = i3;
                j = j2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new d(i2, j, i, str, null);
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, d value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = descriptor;
            kotlinx.serialization.encoding.d beginStructure = encoder.beginStructure(serialDescriptor);
            d.i(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public d() {
        this.c = "";
    }

    public final boolean d() {
        if (this.b >= b()) {
            return true;
        }
        return false;
    }

    public final void f() {
        this.b = 0;
        this.a = 0L;
        h(this);
    }

    static {
        Covode.recordClassIndex(609611);
        Companion = new b(null);
        d = 8;
        e = 3;
    }

    public final void e() {
        this.b = b();
        this.a = Clock.System.INSTANCE.now().toEpochMilliseconds();
        h(this);
    }

    public final void update() {
        this.b++;
        this.a = Clock.System.INSTANCE.now().toEpochMilliseconds();
        h(this);
    }

    public final boolean c() {
        if (this.a == 0) {
            return false;
        }
        l a2 = l.Companion.a();
        Instant.a aVar = Instant.Companion;
        return !Intrinsics.areEqual(m.c(aVar.a(this.a), a2).b(), m.c(aVar.a(Clock.System.INSTANCE.now().toEpochMilliseconds()), a2).b());
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void h(d config) {
        Intrinsics.checkNotNullParameter(config, "config");
        xn0.b a2 = xn0.c.a("chapter_end_vip_coupon_kv_repo");
        String str = "chapter_end_vip_coupon_config_" + config.c;
        gn6.a c = h.c();
        c.getSerializersModule();
        a2.storeString(str, c.a(Companion.serializer(), config));
    }

    public static final /* synthetic */ void i(d dVar, kotlinx.serialization.encoding.d dVar2, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 0) || dVar.a != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dVar2.encodeLongElement(serialDescriptor, 0, dVar.a);
        }
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 1) || dVar.b != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            dVar2.encodeIntElement(serialDescriptor, 1, dVar.b);
        }
        if (dVar2.shouldEncodeElementDefault(serialDescriptor, 2) || !Intrinsics.areEqual(dVar.c, "")) {
            z3 = true;
        }
        if (z3) {
            dVar2.encodeStringElement(serialDescriptor, 2, dVar.c);
        }
    }

    public /* synthetic */ d(int i, long j, int i2, String str, q2 q2Var) {
        if ((i & 0) != 0) {
            b2.b(i, 0, a.a.getDescriptor());
        }
        this.a = (i & 1) == 0 ? 0L : j;
        if ((i & 2) == 0) {
            this.b = 0;
        } else {
            this.b = i2;
        }
        if ((i & 4) == 0) {
            this.c = "";
        } else {
            this.c = str;
        }
    }
}
