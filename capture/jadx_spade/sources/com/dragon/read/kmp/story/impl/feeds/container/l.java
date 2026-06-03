package com.dragon.read.kmp.story.impl.feeds.container;

import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    private static final List<String> a;

    public static final List<String> a() {
        return a;
    }

    static {
        List<String> listOf;
        Covode.recordClassIndex(609259);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"hot_comment_id", "cover_click_content"});
        a = listOf;
    }

    public static final void b(ym4.a aVar, Map<String, String> reportParams) {
        boolean z;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        for (String str : a) {
            String str2 = reportParams.get(str);
            if (str2 != null) {
                if (str2.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    str2 = null;
                }
                if (str2 != null) {
                    aVar.g(str, str2);
                }
            }
        }
    }
}
