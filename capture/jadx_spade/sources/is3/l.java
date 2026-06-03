package is3;

import android.view.View;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface l {
    void a(s sVar);

    void b(Long l);

    s getDataProvider();

    long getDuration();

    View getView();

    boolean isPaused();

    boolean isPlaying();

    void pause();

    void release();

    void resume();

    void seekTo(long j);

    void setLoop(boolean z);

    void setMute(boolean z);

    void setResolution(Resolution resolution, boolean z);

    void setSpeed(float f);

    public static final class a {
        static {
            Covode.recordClassIndex(598918);
        }

        public static /* synthetic */ void a(l lVar, Long l, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    l = null;
                }
                lVar.b(l);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: play");
        }
    }
}
