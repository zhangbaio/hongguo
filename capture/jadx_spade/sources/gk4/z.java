package gk4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z {
    public static final int e;
    public final String a;
    public final String b;
    public final String c;
    public final List<y> d;

    static {
        Covode.recordClassIndex(607815);
        e = 8;
    }

    public z(String itemTitle, String landingTabName, String dialogTitle, List<y> dataList) {
        Intrinsics.checkNotNullParameter(itemTitle, "itemTitle");
        Intrinsics.checkNotNullParameter(landingTabName, "landingTabName");
        Intrinsics.checkNotNullParameter(dialogTitle, "dialogTitle");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.a = itemTitle;
        this.b = landingTabName;
        this.c = dialogTitle;
        this.d = dataList;
    }
}
