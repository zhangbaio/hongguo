package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d0 {
    static {
        Covode.recordClassIndex(608868);
    }

    public static final String a(c0 c0Var, String str) {
        boolean z;
        List split$default;
        boolean z2;
        Intrinsics.checkNotNullParameter(c0Var, "<this>");
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return "";
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{";"}, false, 0, 6, (Object) null);
        Iterator it2 = split$default.iterator();
        while (it2.hasNext()) {
            String z3 = c0Var.z("https://" + ((String) it2.next()));
            if (z3.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return z3;
            }
        }
        return "";
    }
}
