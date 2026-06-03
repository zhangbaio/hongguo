package vk6;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.inter.AbsPlayListener;
import pl6.c;
import pl6.e;
import xk6.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class a extends AbsPlayListener implements e, c.b, a.b {
    static {
        Covode.recordClassIndex(655850);
    }

    public abstract boolean g(int i, String str, int i2);

    public static /* synthetic */ boolean h(a aVar, int i, String str, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            return aVar.g(i, str, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canPreloadTask");
    }
}
