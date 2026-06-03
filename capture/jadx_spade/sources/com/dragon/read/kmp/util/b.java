package com.dragon.read.kmp.util;

import com.bytedance.covode.number.Covode;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(609458);
    }

    public static final String a(int i) {
        return '#' + b((i >>> 24) & 255) + b((i >> 16) & 255) + b((i >> 8) & 255) + b(i & 255);
    }

    private static final String b(int i) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(i, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        String upperCase = StringsKt__StringsKt.padStart(num, 2, '0').toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
