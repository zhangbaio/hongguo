package nn4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends d {
    public static final int z;
    public m u;
    public k v;
    public List<String> w = CollectionsKt__CollectionsKt.emptyList();
    public boolean x;
    public boolean y;

    static {
        Covode.recordClassIndex(608807);
        z = 8;
    }

    public final void m(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.w = list;
    }
}
