package com.ttnet.org.chromium.base;

import com.bytedance.covode.number.Covode;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CollectionUtil {
    static {
        Covode.recordClassIndex(654169);
    }

    private CollectionUtil() {
    }

    public static int[] a(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }
}
