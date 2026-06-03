package ul6;

import android.content.Context;
import android.view.Surface;
import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.data.PlayEngineInfo;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface a {
    void a(Context context, PlayEngineInfo playEngineInfo, Surface surface);

    /* renamed from: ul6.a$a, reason: collision with other inner class name */
    public static final class C0275a {
        static {
            Covode.recordClassIndex(656041);
        }

        public static /* synthetic */ void a(a aVar, Context context, PlayEngineInfo playEngineInfo, Surface surface, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    surface = null;
                }
                aVar.a(context, playEngineInfo, surface);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepareWithSurface");
        }
    }
}
