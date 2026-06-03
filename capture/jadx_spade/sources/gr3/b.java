package gr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.feed.LandingCacheType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface b {
    LandingCacheType a();

    gr3.a f();

    public static final class a {
        static {
            Covode.recordClassIndex(598735);
        }

        public static LandingCacheType a(b bVar) {
            LandingCacheType b;
            gr3.a f = bVar.f();
            if (f == null || (b = f.b()) == null) {
                return LandingCacheType.None;
            }
            return b;
        }
    }
}
