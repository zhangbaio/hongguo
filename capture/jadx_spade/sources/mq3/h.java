package mq3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface h extends dp3.a {
    void F(int i, String str, boolean z);

    void a(String str, long j, long j2);

    Runnable o(int i);

    boolean w(SaasVideoData saasVideoData);

    public static final class a {
        static {
            Covode.recordClassIndex(598204);
        }

        public static /* synthetic */ void a(h hVar, int i, String str, boolean z, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    z = false;
                }
                hVar.F(i, str, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestAndPreloadCommentCount");
        }
    }
}
