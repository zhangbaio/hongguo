package kotlin.ranges;

import androidx.collection.w;
import com.bytedance.covode.number.Covode;
import kotlin.UInt;
import kotlin.ULong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class t {
    static {
        Covode.recordClassIndex(658656);
    }

    public static o a(int i, int i2) {
        int compare;
        compare = Integer.compare(i2 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            return o.e.a();
        }
        return new o(i, UInt.m790constructorimpl(i2 - 1), null);
    }

    public static r b(long j, long j2) {
        if (w.a(j2, 0L) <= 0) {
            return r.e.a();
        }
        return new r(j, ULong.m850constructorimpl(j2 - ULong.m850constructorimpl(1 & 4294967295L)), null);
    }
}
