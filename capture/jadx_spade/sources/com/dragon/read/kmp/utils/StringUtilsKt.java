package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StringUtilsKt {
    static {
        Covode.recordClassIndex(609566);
    }

    public static final boolean a(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        return !z;
    }

    public static final String takeIfNotEmpty(String str) {
        boolean z;
        if (str != null) {
            if (str.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return str;
            }
        }
        return null;
    }

    public static final String b(String str) {
        boolean contains$default;
        if (str != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "《", false, 2, (Object) null);
            if (!contains$default) {
                return (char) 12298 + str + (char) 12299;
            }
        }
        return String.valueOf(str);
    }

    public static final String c(String str, int i, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return str;
        }
        if (i < 0) {
            i = 0;
        }
        int length = str.length();
        if (i2 > length || i2 < 0) {
            i2 = length;
        }
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }
}
