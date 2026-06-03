package com.dragon.read.kmp.reader.detail.catalog;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    static {
        Covode.recordClassIndex(608380);
    }

    public static final List<a> a(List<a> chapters, boolean z) {
        List<a> asReversed;
        boolean z2;
        String str;
        boolean z3;
        String str2;
        int indexOf$default;
        Intrinsics.checkNotNullParameter(chapters, "chapters");
        if (z) {
            asReversed = chapters;
        } else {
            asReversed = CollectionsKt__ReversedViewsKt.asReversed(chapters);
        }
        ArrayList arrayList = new ArrayList(asReversed.size());
        String str3 = null;
        for (a aVar : asReversed) {
            String str4 = aVar.d;
            boolean z4 = false;
            if (str4 != null && str4.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2 && new Regex(".*卷*：*默认*").matches(str4) && (indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str4, (char) 65306, 0, false, 6, (Object) null)) > 0) {
                str4 = StringsKt___StringsKt.take(str4, indexOf$default);
            }
            String str5 = str4;
            if (str5 != null) {
                str = StringsKt__StringsKt.trim((CharSequence) str5).toString();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (str.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 && !Intrinsics.areEqual(str, str3) && !Intrinsics.areEqual(str, "正文")) {
                z4 = true;
            }
            if (z4) {
                String str6 = aVar.a;
                String str7 = aVar.b;
                String str8 = aVar.d;
                if (str8 == null) {
                    str2 = "";
                } else {
                    str2 = str8;
                }
                arrayList.add(new a(str6, str7, str2, str8, aVar.e, null, true));
                str3 = str;
            }
            arrayList.add(a.b(aVar, null, null, null, str5, false, null, false, 119, null));
        }
        return arrayList;
    }
}
