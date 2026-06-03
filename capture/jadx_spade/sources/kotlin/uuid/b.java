package kotlin.uuid;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.e;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class b extends a {
    static {
        Covode.recordClassIndex(658846);
    }

    public static final Uuid k(String hexString) {
        Intrinsics.checkNotNullParameter(hexString, "hexString");
        return Uuid.Companion.a(e.g(hexString, 0, 16, null, 4, null), e.g(hexString, 16, 32, null, 4, null));
    }

    public static final Uuid l(String hexDashString) {
        Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
        long g = e.g(hexDashString, 0, 8, null, 4, null);
        g(hexDashString, 8);
        long g2 = e.g(hexDashString, 9, 13, null, 4, null);
        g(hexDashString, 13);
        long g3 = e.g(hexDashString, 14, 18, null, 4, null);
        g(hexDashString, 18);
        long g4 = e.g(hexDashString, 19, 23, null, 4, null);
        g(hexDashString, 23);
        return Uuid.Companion.a((g << 32) | (g2 << 16) | g3, (g4 << 48) | e.g(hexDashString, 24, 36, null, 4, null));
    }

    public static final void g(String str, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.charAt(i) == '-') {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("Expected '-' (hyphen) at index " + i + ", but was '" + str.charAt(i) + '\'').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(String str, int i) {
        if (str.length() > i) {
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            sb.append(substring);
            sb.append("...");
            return sb.toString();
        }
        return str;
    }

    public static final void i(byte[] bArr, int i, long j) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i2 = 7;
        while (-1 < i2) {
            bArr[i] = (byte) (j >> (i2 << 3));
            i2--;
            i++;
        }
    }

    public static final void h(long j, byte[] dst, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        int i4 = 7 - i2;
        int i5 = 8 - i3;
        if (i5 > i4) {
            return;
        }
        while (true) {
            int i6 = e.e()[(int) ((j >> (i4 << 3)) & 255)];
            int i7 = i + 1;
            dst[i] = (byte) (i6 >> 8);
            i = i7 + 1;
            dst[i7] = (byte) i6;
            if (i4 != i5) {
                i4--;
            } else {
                return;
            }
        }
    }
}
