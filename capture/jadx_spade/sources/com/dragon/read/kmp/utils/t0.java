package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t0 {
    public static final t0 a;

    static {
        Covode.recordClassIndex(609565);
        a = new t0();
    }

    private t0() {
    }

    public final String b(Collection<?> strings, String str) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        return c(strings.iterator(), str);
    }

    public final String c(Iterator<?> strings, String str) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        if (!strings.hasNext()) {
            return "";
        }
        String valueOf = String.valueOf(strings.next());
        if (!strings.hasNext()) {
            return valueOf;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append(valueOf);
        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
        while (strings.hasNext()) {
            sb.append(str);
            sb.append(strings.next());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final boolean a(String str, String str2, boolean z) {
        if (str == str2) {
            return true;
        }
        if (str != null && str2 != null) {
            if (z) {
                return StringsKt__StringsJVMKt.equals(str, str2, true);
            }
            return Intrinsics.areEqual(str, str2);
        }
        return false;
    }
}
