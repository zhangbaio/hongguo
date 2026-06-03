package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d0 {
    static {
        Covode.recordClassIndex(609549);
    }

    public static final String b(Map<String, ? extends Object> map, String key, String str) {
        String obj;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        Object obj2 = map.get(key);
        if (obj2 != null && (obj = obj2.toString()) != null) {
            return obj;
        }
        return str;
    }

    public static final boolean a(Map<String, ? extends Object> map, String key, boolean z) {
        Boolean booleanStrictOrNull;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = map.get(key);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            booleanStrictOrNull = StringsKt__StringsKt.toBooleanStrictOrNull((String) obj);
            if (booleanStrictOrNull != null) {
                return booleanStrictOrNull.booleanValue();
            }
            return z;
        }
        if (obj instanceof Number) {
            if (((Number) obj).intValue() != 0) {
                return true;
            }
            return false;
        }
        return z;
    }

    public static /* synthetic */ String c(Map map, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return b(map, str, str2);
    }
}
