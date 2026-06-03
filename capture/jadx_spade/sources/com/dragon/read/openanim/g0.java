package com.dragon.read.openanim;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g0 {
    static {
        Covode.recordClassIndex(612657);
    }

    public static final <T> T a(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
        return null;
    }

    public static final <T> T b(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
        return null;
    }

    public static final <T> boolean c(List<T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.add(t);
    }
}
