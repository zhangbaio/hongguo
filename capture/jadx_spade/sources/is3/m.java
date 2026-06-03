package is3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.ss.android.videoshop.api.IVideoEngineFactory;
import iw5.b;
import ls3.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface m {

    public static final class a {
        static {
            Covode.recordClassIndex(598920);
        }

        public static boolean a(m mVar) {
            return true;
        }

        public static a.C0240a b(m mVar, SaasVideoData saasVideoData) {
            return null;
        }
    }

    n a();

    a.C0240a b(SaasVideoData saasVideoData);

    IVideoEngineFactory c();

    g d();

    q e();

    k f();

    o g();

    String getSubTag();

    String getTag();

    boolean h();

    b.c.b i(SaasVideoData saasVideoData);
}
