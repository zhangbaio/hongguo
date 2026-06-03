package lk4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.polaris.video.l3;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements pg1.d {
    static {
        Covode.recordClassIndex(607899);
    }

    public boolean isFirstEnter() {
        return false;
    }

    public boolean isCounting() {
        if (!NsCommonDepend.IMPL.audioPlayManager().isCurrentPlayerPlaying() && !l3.a.R()) {
            return false;
        }
        return true;
    }
}
