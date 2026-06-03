package ml4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.c7;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(608139);
        a = new a();
    }

    private a() {
    }

    public final int a(List<c7> tabList, ProfileTab profileTab) {
        Integer num;
        Intrinsics.checkNotNullParameter(tabList, "tabList");
        int i = 0;
        for (Object obj : tabList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            c7 c7Var = (c7) obj;
            Integer num2 = c7Var.b;
            if (profileTab != null) {
                num = Integer.valueOf(profileTab.getValue());
            } else {
                num = null;
            }
            if (!Intrinsics.areEqual(num2, num)) {
                Integer num3 = c7Var.b;
                int value = ProfileTab.Video.getValue();
                if (num3 == null || num3.intValue() != value || profileTab != ProfileTab.Album) {
                    i = i2;
                }
            }
            return i;
        }
        return 0;
    }
}
