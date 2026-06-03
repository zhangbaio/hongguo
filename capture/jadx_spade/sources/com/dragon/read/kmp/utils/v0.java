package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v0 {
    public static final v0 a;

    static {
        Covode.recordClassIndex(609568);
        a = new v0();
    }

    private v0() {
    }

    public final boolean a(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public final String b(CharSequence delimiter, Iterable<?> tokens) {
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        Iterator<?> it2 = tokens.iterator();
        if (!it2.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(it2.next());
        while (it2.hasNext()) {
            sb.append(delimiter);
            sb.append(it2.next());
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
