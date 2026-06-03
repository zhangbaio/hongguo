package gl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.detail.series.celebrity.SubscribeViewStyle;
import com.dragon.read.kmp.u;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(608106);
        a = new a();
    }

    private a() {
    }

    public final SubscribeViewStyle a() {
        int b = u.b();
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    return SubscribeViewStyle.InAvatarRound;
                }
                return SubscribeViewStyle.OutSideRect;
            }
            return SubscribeViewStyle.InAvatarRect;
        }
        return SubscribeViewStyle.InAvatarRound;
    }
}
