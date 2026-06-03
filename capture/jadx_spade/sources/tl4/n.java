package tl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.c0;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.c7;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public static final n a;

    static {
        Covode.recordClassIndex(608161);
        a = new n();
    }

    private n() {
    }

    public final l a(c7 userProfileTab, rl4.c tabParam) {
        Intrinsics.checkNotNullParameter(userProfileTab, "userProfileTab");
        Intrinsics.checkNotNullParameter(tabParam, "tabParam");
        ProfileTab profileTab = tabParam.b;
        ProfileTab profileTab2 = tabParam.f;
        rl4.a a2 = rl4.b.a.a(userProfileTab, profileTab2);
        boolean z = false;
        if (profileTab != null && c0.b(profileTab)) {
            z = true;
        }
        if (z) {
            return new ll4.a(tabParam, a2);
        }
        if (profileTab == ProfileTab.Video && profileTab2 == ProfileTab.Album) {
            return new hl4.a(tabParam, a2);
        }
        return new l(tabParam, a2);
    }
}
