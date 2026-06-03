package ol4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    private static final Set<Integer> a;

    static {
        Set<Integer> of;
        Covode.recordClassIndex(608142);
        of = SetsKt__SetsKt.setOf((Object[]) new Integer[]{Integer.valueOf(ProfileTab.CelebrityWorksMix.getValue()), Integer.valueOf(ProfileTab.CelebrityWorks.getValue()), Integer.valueOf(ProfileTab.ProduceVideo.getValue()), Integer.valueOf(ProfileTab.DirectorWorks.getValue()), Integer.valueOf(ProfileTab.Video.getValue()), Integer.valueOf(ProfileTab.WriterWorks.getValue())});
        a = of;
    }

    public static final boolean b(Integer num) {
        boolean contains;
        contains = CollectionsKt___CollectionsKt.contains(a, num);
        return contains;
    }

    public static final boolean a(ProfileTab profileTab) {
        Integer num;
        if (profileTab != null) {
            num = Integer.valueOf(profileTab.getValue());
        } else {
            num = null;
        }
        return b(num);
    }
}
