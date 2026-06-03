package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    public static final r a;

    static {
        Covode.recordClassIndex(609537);
        a = new r();
    }

    private r() {
    }

    public final String a(String str) {
        boolean z;
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        String replace$default5;
        String replace$default6;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return "";
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(str, "&amp;", "&", false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "&lt;", "<", false, 4, (Object) null);
        replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "&gt;", ">", false, 4, (Object) null);
        replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "&quot;", "\"", false, 4, (Object) null);
        replace$default5 = StringsKt__StringsJVMKt.replace$default(replace$default4, "&apos;", "'", false, 4, (Object) null);
        replace$default6 = StringsKt__StringsJVMKt.replace$default(replace$default5, "&nbsp;", " ", false, 4, (Object) null);
        return replace$default6;
    }
}
