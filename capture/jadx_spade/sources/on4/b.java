package on4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.me0;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nn4.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int e;
    public List<? extends d> a = CollectionsKt__CollectionsKt.emptyList();
    public String b = "";
    public int c;
    public me0 d;

    static {
        Covode.recordClassIndex(608818);
        e = 8;
    }

    public final void a(List<? extends d> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.a = list;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }
}
