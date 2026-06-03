package is3;

import android.graphics.Rect;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.autoplay.VideoAutoPlayType;
import kotlin.Pair;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface r {

    public static final class a {
        static {
            Covode.recordClassIndex(598926);
        }

        public static boolean a(r rVar) {
            return true;
        }
    }

    boolean a();

    boolean b();

    void c();

    void d();

    void e(VideoAutoPlayType videoAutoPlayType);

    void f();

    Pair<Rect, Boolean> getGlobalVisibleRect();

    int getPosition();

    int getViewHeight();

    boolean isPlaying();
}
