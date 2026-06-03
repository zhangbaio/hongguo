package tl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.u;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    static {
        Covode.recordClassIndex(608160);
    }

    public static final boolean a(ProfileTab profileTab) {
        if ((profileTab == ProfileTab.Video || ol4.a.a(profileTab)) && u.d()) {
            return true;
        }
        return false;
    }

    public static final boolean b(ProfileTab profileTab, boolean z) {
        if (profileTab == ProfileTab.Video && !z && u.d()) {
            return true;
        }
        return false;
    }
}
