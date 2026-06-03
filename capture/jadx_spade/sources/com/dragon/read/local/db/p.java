package com.dragon.read.local.db;

import com.bytedance.covode.number.Covode;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class p {
    static {
        Covode.recordClassIndex(611537);
    }

    public static <T> List<List<T>> a(List<T> list) {
        if (list != null && list.size() != 0) {
            LinkedList linkedList = new LinkedList();
            if (list.size() < 500) {
                linkedList.add(list);
                return linkedList;
            }
            int i = 0;
            int i2 = 0;
            while (i < Math.ceil((list.size() * 1.0f) / 500.0f)) {
                i++;
                int min = Math.min(list.size(), i * 500);
                linkedList.add(list.subList(i2, min));
                i2 = min;
            }
            return linkedList;
        }
        return Collections.emptyList();
    }

    public static <T> List<List<T>> b(T... tArr) {
        List asList = Arrays.asList(tArr);
        if (asList.size() == 0) {
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        if (asList.size() < 500) {
            linkedList.add(asList);
            return linkedList;
        }
        int i = 0;
        int i2 = 0;
        while (i < Math.ceil((asList.size() * 1.0f) / 500.0f)) {
            i++;
            int min = Math.min(asList.size(), i * 500);
            linkedList.add(asList.subList(i2, min));
            i2 = min;
        }
        return linkedList;
    }
}
