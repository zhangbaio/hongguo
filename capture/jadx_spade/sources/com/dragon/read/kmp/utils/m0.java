package com.dragon.read.kmp.utils;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.report.PageRecorderUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m0 {
    static {
        Covode.recordClassIndex(609559);
    }

    public static final ym4.k a() {
        PageRecorder currentPageRecorder = PageRecorderUtils.getCurrentPageRecorder();
        if (currentPageRecorder == null) {
            currentPageRecorder = new PageRecorder("", "", "", (PageRecorder) null);
        }
        return c(currentPageRecorder);
    }

    public static final ym4.k b(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        PageRecorder parentPage = PageRecorderUtils.getParentPage(context);
        Intrinsics.checkNotNullExpressionValue(parentPage, "getParentPage(...)");
        return c(parentPage);
    }

    private static final ym4.k c(PageRecorder pageRecorder) {
        ym4.k kVar;
        String page = pageRecorder.getPage();
        String module = pageRecorder.getModule();
        String object = pageRecorder.getObject();
        PageRecorder parentRecorder = pageRecorder.getParentRecorder();
        if (parentRecorder != null) {
            kVar = c(parentRecorder);
        } else {
            kVar = null;
        }
        ym4.k kVar2 = new ym4.k(page, module, object, kVar);
        Map<String, ? extends Object> extraInfoMap = pageRecorder.getExtraInfoMap();
        Intrinsics.checkNotNullExpressionValue(extraInfoMap, "getExtraInfoMap(...)");
        kVar2.b(extraInfoMap);
        return kVar2;
    }
}
