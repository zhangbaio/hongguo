package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 {
    static {
        Covode.recordClassIndex(609547);
    }

    public static final <T> boolean a(Collection<? extends T> collection) {
        boolean z;
        if (collection != null && !collection.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        return !z;
    }

    public static final <K, V> boolean b(Map<K, ? extends V> map) {
        boolean z;
        if (map != null && !map.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        return !z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> c(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (!(!map.isEmpty())) {
            return null;
        }
        return map;
    }
}
