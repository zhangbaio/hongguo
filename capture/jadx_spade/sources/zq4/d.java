package zq4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(611409);
    }

    public static final boolean a(c cVar, String chapterId) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        return Intrinsics.areEqual(chapterId, cVar.getCurrentChapterId());
    }
}
