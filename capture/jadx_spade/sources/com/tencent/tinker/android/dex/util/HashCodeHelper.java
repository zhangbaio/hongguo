package com.tencent.tinker.android.dex.util;

import com.bytedance.covode.number.Covode;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class HashCodeHelper {
    static {
        Covode.recordClassIndex(653627);
    }

    private HashCodeHelper() {
        throw new UnsupportedOperationException();
    }

    public static int hash(Object... objArr) {
        int hashCode;
        if (objArr == null || objArr.length == 0) {
            return 0;
        }
        int i = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                if (obj instanceof Number) {
                    hashCode = obj.hashCode();
                } else if (obj instanceof boolean[]) {
                    hashCode = Arrays.hashCode((boolean[]) obj);
                } else if (obj instanceof byte[]) {
                    hashCode = Arrays.hashCode((byte[]) obj);
                } else if (obj instanceof char[]) {
                    hashCode = Arrays.hashCode((char[]) obj);
                } else if (obj instanceof short[]) {
                    hashCode = Arrays.hashCode((short[]) obj);
                } else if (obj instanceof int[]) {
                    hashCode = Arrays.hashCode((int[]) obj);
                } else if (obj instanceof long[]) {
                    hashCode = Arrays.hashCode((long[]) obj);
                } else if (obj instanceof float[]) {
                    hashCode = Arrays.hashCode((float[]) obj);
                } else if (obj instanceof double[]) {
                    hashCode = Arrays.hashCode((double[]) obj);
                } else if (obj instanceof Object[]) {
                    hashCode = Arrays.hashCode((Object[]) obj);
                } else if (obj.getClass().isArray()) {
                    for (int i2 = 0; i2 < Array.getLength(obj); i2++) {
                        i += hash(Array.get(obj, i2));
                    }
                } else {
                    hashCode = obj.hashCode();
                }
                i += hashCode;
            }
        }
        return i;
    }
}
