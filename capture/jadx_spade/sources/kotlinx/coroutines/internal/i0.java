package kotlinx.coroutines.internal;

import com.bytedance.covode.number.Covode;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final /* synthetic */ class i0 {
    static {
        Covode.recordClassIndex(659269);
    }

    public static final String c(String str, String str2) {
        String d = g0.d(str);
        if (d != null) {
            return d;
        }
        return str2;
    }

    public static final boolean d(String str, boolean z) {
        String d = g0.d(str);
        if (d != null) {
            return Boolean.parseBoolean(d);
        }
        return z;
    }

    public static final int a(String str, int i, int i2, int i3) {
        return (int) g0.c(str, i, i2, i3);
    }

    public static final long b(String str, long j, long j2, long j3) {
        Long longOrNull;
        String d = g0.d(str);
        if (d == null) {
            return j;
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(d);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            boolean z = false;
            if (j2 <= longValue && longValue <= j3) {
                z = true;
            }
            if (z) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d + '\'').toString());
    }

    public static /* synthetic */ int e(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return g0.b(str, i, i2, i3);
    }

    public static /* synthetic */ long f(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return g0.c(str, j, j4, j3);
    }
}
