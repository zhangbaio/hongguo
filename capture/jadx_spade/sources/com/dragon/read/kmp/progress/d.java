package com.dragon.read.kmp.progress;

import com.bytedance.covode.number.Covode;
import com.dragon.read.progress.ChapterProgress;
import h45.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;

    static {
        Covode.recordClassIndex(608225);
        a = new d();
    }

    private d() {
    }

    public final Object a(String str, Continuation<? super Map<String, c>> continuation) {
        int mapCapacity;
        Map b = k.a.b(str);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(b.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Map.Entry entry : b.entrySet()) {
            Object key = entry.getKey();
            Integer progressInReader = ((ChapterProgress) entry.getValue()).getProgressInReader();
            Intrinsics.checkNotNullExpressionValue(progressInReader, "getProgressInReader(...)");
            linkedHashMap.put(key, new c(progressInReader.intValue()));
        }
        return linkedHashMap;
    }
}
