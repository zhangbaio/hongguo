package nn4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final int c;
    public String a;
    public List<j> b;

    static {
        Covode.recordClassIndex(608811);
        c = 8;
    }

    public i(String text, List<j> highlights) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(highlights, "highlights");
        this.a = "";
        CollectionsKt__CollectionsKt.emptyList();
        this.a = text;
        this.b = highlights;
    }
}
