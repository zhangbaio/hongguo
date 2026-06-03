package com.tencent.tinker.android.dex.util;

import com.bytedance.covode.number.Covode;
import java.util.Comparator;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CompareUtils {
    static {
        Covode.recordClassIndex(653625);
    }

    private CompareUtils() {
    }

    public static int sCompare(byte b, byte b2) {
        if (b == b2) {
            return 0;
        }
        return b < b2 ? -1 : 1;
    }

    public static int sCompare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    public static int sCompare(long j, long j2) {
        if (j == j2) {
            return 0;
        }
        return j < j2 ? -1 : 1;
    }

    public static int sCompare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return s < s2 ? -1 : 1;
    }

    public static int uCompare(byte b, byte b2) {
        if (b == b2) {
            return 0;
        }
        return (b & 255) < (b2 & 255) ? -1 : 1;
    }

    public static int uCompare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return (((long) i) & 4294967295L) < (((long) i2) & 4294967295L) ? -1 : 1;
    }

    public static int uCompare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return (s & 65535) < (s2 & 65535) ? -1 : 1;
    }

    public static <T extends Comparable<T>> int aArrCompare(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            int compareTo = tArr[i].compareTo(tArr2[i]);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public static int sArrCompare(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            int sCompare = sCompare(bArr[i], bArr2[i]);
            if (sCompare != 0) {
                return sCompare;
            }
        }
        return 0;
    }

    public static int uArrCompare(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            int uCompare = uCompare(bArr[i], bArr2[i]);
            if (uCompare != 0) {
                return uCompare;
            }
        }
        return 0;
    }

    public static int sArrCompare(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            int sCompare = sCompare(iArr[i], iArr2[i]);
            if (sCompare != 0) {
                return sCompare;
            }
        }
        return 0;
    }

    public static int uArrCompare(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            int uCompare = uCompare(iArr[i], iArr2[i]);
            if (uCompare != 0) {
                return uCompare;
            }
        }
        return 0;
    }

    public static int sArrCompare(long[] jArr, long[] jArr2) {
        int length = jArr.length;
        int length2 = jArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            int sCompare = sCompare(jArr[i], jArr2[i]);
            if (sCompare != 0) {
                return sCompare;
            }
        }
        return 0;
    }

    public static int uArrCompare(short[] sArr, short[] sArr2) {
        int length = sArr.length;
        int length2 = sArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            int uCompare = uCompare(sArr[i], sArr2[i]);
            if (uCompare != 0) {
                return uCompare;
            }
        }
        return 0;
    }

    public static int sArrCompare(short[] sArr, short[] sArr2) {
        int length = sArr.length;
        int length2 = sArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            int sCompare = sCompare(sArr[i], sArr2[i]);
            if (sCompare != 0) {
                return sCompare;
            }
        }
        return 0;
    }

    public static <T> int aArrCompare(T[] tArr, T[] tArr2, Comparator<T> comparator) {
        int length = tArr.length;
        int length2 = tArr2.length;
        if (length < length2) {
            return -1;
        }
        if (length > length2) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            int compare = comparator.compare(tArr[i], tArr2[i]);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }
}
