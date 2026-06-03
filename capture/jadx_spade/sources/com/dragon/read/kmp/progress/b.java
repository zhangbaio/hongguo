package com.dragon.read.kmp.progress;

import com.bytedance.covode.number.Covode;
import com.dragon.read.progress.j;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import lr4.t;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;

    static {
        Covode.recordClassIndex(608223);
        a = new b();
    }

    private b() {
    }

    public final Object a(String str, String str2, Continuation<? super Map<String, Integer>> continuation) {
        int mapCapacity;
        boolean z;
        Integer intOrNull;
        Map emptyMap;
        if (StringsKt__StringsKt.isBlank(str)) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        Map j0 = j.a.j0(str, str2);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(j0.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        Iterator it2 = j0.entrySet().iterator();
        while (true) {
            int i = 0;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it2.next();
            Object key = entry.getKey();
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(((t) entry.getValue()).s);
            if (intOrNull != null) {
                i = intOrNull.intValue();
            }
            linkedHashMap.put(key, Boxing.boxInt(i));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (((Number) entry2.getValue()).intValue() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return linkedHashMap2;
    }
}
