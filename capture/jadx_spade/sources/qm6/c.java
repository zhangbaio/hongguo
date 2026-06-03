package qm6;

import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.h;
import kotlin.jvm.internal.Intrinsics;
import kotlin.l;
import kotlin.m;
import kotlin.p;
import kotlin.ranges.IntRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c extends b {
    static {
        Covode.recordClassIndex(658257);
    }

    public static String e(byte[] bArr) {
        String joinToString$default;
        if (bArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(h.a(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return joinToString$default;
    }

    public static String f(int[] iArr) {
        String joinToString$default;
        if (iArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(l.a(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return joinToString$default;
    }

    public static String g(short[] sArr) {
        String joinToString$default;
        if (sArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(p.a(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return joinToString$default;
    }

    public static String h(long[] jArr) {
        String joinToString$default;
        if (jArr == null || (joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(m.a(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) {
            return "null";
        }
        return joinToString$default;
    }

    public static boolean a(short[] sArr, short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    public static boolean b(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    public static boolean c(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    public static boolean d(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    public static byte[] i(byte[] sliceArray, IntRange indices) {
        byte[] sliceArray2;
        Intrinsics.checkNotNullParameter(sliceArray, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(indices, "indices");
        sliceArray2 = ArraysKt___ArraysKt.sliceArray(sliceArray, indices);
        return h.j(sliceArray2);
    }
}
