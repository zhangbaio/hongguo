package com.tencent.tinker.lib.utils;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ArrayUtils {
    static {
        Covode.recordClassIndex(653922);
    }

    public static int size(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public static boolean isEmpty(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static int size(Collection<?> collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        if (map != null && !map.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(long[] jArr) {
        if (jArr != null && jArr.length != 0) {
            return false;
        }
        return true;
    }

    public static <T> boolean isEmpty(T[] tArr) {
        if (tArr != null && tArr.length != 0) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(boolean[] zArr) {
        if (zArr != null && zArr.length != 0) {
            return false;
        }
        return true;
    }

    public static <T> boolean contains(T[] tArr, T t) {
        if (indexOf(tArr, t) != -1) {
            return true;
        }
        return false;
    }

    public static boolean contains(char[] cArr, char c) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean containsAll(char[] cArr, char[] cArr2) {
        if (cArr2 == null) {
            return true;
        }
        for (char c : cArr2) {
            if (!contains(cArr, c)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsAny(T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return false;
        }
        for (T t : tArr2) {
            if (contains(tArr, t)) {
                return true;
            }
        }
        return false;
    }

    public static <T> int indexOf(T[] tArr, T t) {
        if (tArr == null) {
            return -1;
        }
        for (int i = 0; i < tArr.length; i++) {
            T t2 = tArr[i];
            if (t2 == t || (t2 != null && t2.equals(t))) {
                return i;
            }
        }
        return -1;
    }

    public static boolean contains(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean containsAll(T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t : tArr2) {
            if (!contains(tArr, t)) {
                return false;
            }
        }
        return true;
    }

    public static boolean contains(long[] jArr, long j) {
        if (jArr == null) {
            return false;
        }
        for (long j2 : jArr) {
            if (j2 == j) {
                return true;
            }
        }
        return false;
    }
}
