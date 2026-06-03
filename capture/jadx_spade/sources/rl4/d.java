package rl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.kmp.s;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(608154);
    }

    public static final ym4.a a(c cVar) {
        Integer num;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        ym4.a aVar = new ym4.a();
        ProfileTab profileTab = cVar.d;
        Integer num2 = null;
        if (profileTab != null) {
            num = Integer.valueOf(profileTab.getValue());
        } else {
            num = null;
        }
        aVar.g("profile_tab_name", s.b(num));
        ProfileTab profileTab2 = cVar.f;
        if (profileTab2 != null) {
            num2 = Integer.valueOf(profileTab2.getValue());
        }
        aVar.g("profile_sub_tab_name", s.a(num2));
        aVar.g("sort_type", FilterOptionHeaderType.Companion.c(cVar.j));
        return aVar;
    }
}
