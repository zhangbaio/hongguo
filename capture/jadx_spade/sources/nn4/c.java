package nn4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c extends d {
    public static final int w;
    public h u;
    public List<String> v = CollectionsKt__CollectionsKt.emptyList();

    static {
        Covode.recordClassIndex(608805);
        w = 8;
    }

    public final void m(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.v = list;
    }
}
