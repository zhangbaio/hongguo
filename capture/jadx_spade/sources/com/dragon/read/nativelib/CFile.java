package com.dragon.read.nativelib;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CFile {
    public static final CFile a;

    private CFile() {
    }

    private final native Object[] nativeCalPathSizeWithDepth(String str, int i, int i2, Object[] objArr);

    private final native long[] nativeCalPathSizeWithSubPaths(String str, String[] strArr);

    private final native Object[] nativeGetListFile(String str);

    static {
        Covode.recordClassIndex(612440);
        a = new CFile();
        System.loadLibrary("common-logic");
    }

    public final long a(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        long[] nativeCalPathSizeWithSubPaths = nativeCalPathSizeWithSubPaths(path, new String[0]);
        if (nativeCalPathSizeWithSubPaths != null) {
            return nativeCalPathSizeWithSubPaths[0];
        }
        return -1L;
    }

    public final List<Pair<Boolean, String>> c(String path) {
        IntRange until;
        IntProgression step;
        Intrinsics.checkNotNullParameter(path, "path");
        Object[] nativeGetListFile = nativeGetListFile(path);
        if (nativeGetListFile == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        until = RangesKt___RangesKt.until(0, nativeGetListFile.length);
        step = RangesKt___RangesKt.step(until, 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                Object obj = nativeGetListFile[first];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                Object obj2 = nativeGetListFile[first + 1];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                arrayList.add(new Pair((Boolean) obj, (String) obj2));
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        return arrayList;
    }

    public final Map<String, Long> b(String path, int i, Map<String, Integer> bizDepth) {
        IntRange until;
        IntProgression step;
        Map<String, Long> emptyMap;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(bizDepth, "bizDepth");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Integer> entry : bizDepth.entrySet()) {
            String key = entry.getKey();
            int intValue = entry.getValue().intValue();
            arrayList.add(key);
            arrayList.add(Integer.valueOf(intValue));
        }
        int max = Math.max(i, 0);
        int size = bizDepth.size();
        Object[] array = arrayList.toArray();
        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
        Object[] nativeCalPathSizeWithDepth = nativeCalPathSizeWithDepth(path, max, size, array);
        if (nativeCalPathSizeWithDepth == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        until = RangesKt___RangesKt.until(0, nativeCalPathSizeWithDepth.length);
        step = RangesKt___RangesKt.step(until, 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                Object obj = nativeCalPathSizeWithDepth[first];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = nativeCalPathSizeWithDepth[first + 1];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
                linkedHashMap.put((String) obj, (Long) obj2);
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        return linkedHashMap;
    }
}
