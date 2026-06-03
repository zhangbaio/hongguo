package kotlin.time;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class j {
    private static final int[] a;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;

    static {
        Covode.recordClassIndex(658820);
        a = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        b = new int[]{1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
        c = new int[]{3, 6};
        d = new int[]{1, 2, 4, 5, 7, 8};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Instant instant) {
        int i;
        int[] iArr;
        StringBuilder sb = new StringBuilder();
        n a2 = n.h.a(instant);
        int i2 = a2.a;
        int i3 = 0;
        if (Math.abs(i2) < 1000) {
            StringBuilder sb2 = new StringBuilder();
            if (i2 >= 0) {
                sb2.append(i2 + 10000);
                Intrinsics.checkNotNullExpressionValue(sb2.deleteCharAt(0), "deleteCharAt(...)");
            } else {
                sb2.append(i2 - 10000);
                Intrinsics.checkNotNullExpressionValue(sb2.deleteCharAt(1), "deleteCharAt(...)");
            }
            sb.append((CharSequence) sb2);
        } else {
            if (i2 >= 10000) {
                sb.append('+');
            }
            sb.append(i2);
        }
        sb.append('-');
        c(sb, sb, a2.b);
        sb.append('-');
        c(sb, sb, a2.c);
        sb.append('T');
        c(sb, sb, a2.d);
        sb.append(':');
        c(sb, sb, a2.e);
        sb.append(':');
        c(sb, sb, a2.f);
        if (a2.g != 0) {
            sb.append('.');
            while (true) {
                i = a2.g;
                iArr = a;
                int i4 = i3 + 1;
                if (i % iArr[i4] != 0) {
                    break;
                }
                i3 = i4;
            }
            int i5 = i3 - (i3 % 3);
            String valueOf = String.valueOf((i / iArr[i5]) + iArr[9 - i5]);
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            String substring = valueOf.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            sb.append(substring);
        }
        sb.append('Z');
        return sb.toString();
    }

    private static final void c(Appendable appendable, StringBuilder sb, int i) {
        if (i < 10) {
            appendable.append('0');
        }
        sb.append(i);
    }
}
