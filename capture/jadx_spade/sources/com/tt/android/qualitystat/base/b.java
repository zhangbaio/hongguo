package com.tt.android.qualitystat.base;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    private static final ConcurrentHashMap<String, Pair<String, Long>> a;
    public static final b b;

    private b() {
    }

    static {
        Covode.recordClassIndex(654025);
        b = new b();
        a = new ConcurrentHashMap<>();
    }

    public final boolean a(String str, String str2, int i) {
        Pair<String, Long> pair;
        boolean z;
        if (i <= 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap<String, Pair<String, Long>> concurrentHashMap = a;
        if (concurrentHashMap.containsKey(str) && (pair = concurrentHashMap.get(str)) != null) {
            boolean areEqual = Intrinsics.areEqual(pair.getFirst(), str2);
            if (currentTimeMillis - pair.getSecond().longValue() < i) {
                z = true;
            } else {
                z = false;
            }
            concurrentHashMap.put(str, new Pair<>(str2, Long.valueOf(currentTimeMillis)));
            if (!areEqual || !z) {
                return false;
            }
            return true;
        }
        concurrentHashMap.put(str, new Pair<>(str2, Long.valueOf(currentTimeMillis)));
        return false;
    }
}
