package kotlin.uuid;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class a {
    static {
        Covode.recordClassIndex(658845);
    }

    public static final Uuid d(String hexString) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        return b.k(hexString);
    }

    public static final Uuid e(String hexDashString) {
        Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
        return b.l(hexDashString);
    }

    public static final Object b(Uuid uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new UuidSerialized(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final void c(byte[] bArr, int i, long j) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        b.i(bArr, i, j);
    }

    public static final void a(long j, byte[] dst, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        b.h(j, dst, i, i2, i3);
    }
}
