package ym4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.report.PageRecorder;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l {
    static {
        Covode.recordClassIndex(608693);
    }

    public static final k a(Object obj) {
        if (obj instanceof PageRecorder) {
            return b((PageRecorder) obj);
        }
        if (obj instanceof k) {
            return (k) obj;
        }
        return null;
    }

    public static final k b(PageRecorder pageRecorder) {
        Intrinsics.checkNotNullParameter(pageRecorder, "<this>");
        PageRecorder parentRecorder = pageRecorder.getParentRecorder();
        k kVar = null;
        if (parentRecorder != null) {
            k kVar2 = new k(parentRecorder.getPage(), parentRecorder.getModule(), parentRecorder.getObject(), null);
            Map<String, ? extends Object> extraInfoMap = parentRecorder.getExtraInfoMap();
            Intrinsics.checkNotNullExpressionValue(extraInfoMap, "getExtraInfoMap(...)");
            kVar2.b(extraInfoMap);
            kVar = kVar2;
        }
        k kVar3 = new k(pageRecorder.getPage(), pageRecorder.getModule(), pageRecorder.getObject(), kVar);
        Map<String, ? extends Object> extraInfoMap2 = pageRecorder.getExtraInfoMap();
        Intrinsics.checkNotNullExpressionValue(extraInfoMap2, "getExtraInfoMap(...)");
        kVar3.b(extraInfoMap2);
        return kVar3;
    }
}
