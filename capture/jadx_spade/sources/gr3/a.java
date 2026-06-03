package gr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.feed.LandingCacheType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {
    com.dragon.read.component.shortvideo.data.saas.video.d a();

    LandingCacheType b();

    Object c();

    /* renamed from: gr3.a$a, reason: collision with other inner class name */
    public static final class C0164a {
        static {
            Covode.recordClassIndex(598733);
        }

        public static com.dragon.read.component.shortvideo.data.saas.video.d a(a aVar) {
            return null;
        }

        public static Object b(a aVar) {
            com.dragon.read.component.shortvideo.data.saas.video.d a = aVar.a();
            if (aVar.b() == LandingCacheType.Video && a != null) {
                return a;
            }
            return aVar;
        }
    }
}
