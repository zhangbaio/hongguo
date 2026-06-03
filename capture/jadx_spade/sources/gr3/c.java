package gr3;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.feed.VideoFeedLandingCacheExpireReason;
import com.dragon.read.component.shortvideo.constant.VideoFeedLandingCacheSaveFrom;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.model.VideoFeedLandingCacheData;
import com.dragon.read.component.shortvideo.model.VideoFeedLandingCacheTabData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface c {
    void a(String str, String str2, VideoFeedLandingCacheSaveFrom videoFeedLandingCacheSaveFrom);

    void b(com.dragon.read.component.shortvideo.data.saas.video.d dVar, int i, VideoFeedLandingCacheSaveFrom videoFeedLandingCacheSaveFrom);

    void c();

    boolean d();

    void e(Context context, int i);

    VideoFeedLandingCacheData f();

    void h(VideoFeedLandingCacheTabData videoFeedLandingCacheTabData);

    void i();

    void j(com.dragon.read.component.shortvideo.data.saas.video.d dVar, int i);

    boolean k(boolean z);

    VideoFeedLandingCacheExpireReason m();

    String n(boolean z);

    boolean o();

    void p(SaasVideoData saasVideoData);

    void q();

    VideoFeedLandingCacheTabData r();

    void s(Lifecycle lifecycle);

    public static final class a {
        static {
            Covode.recordClassIndex(598737);
        }

        public static void a(c cVar, Lifecycle lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        }

        public static void b(c cVar) {
        }

        public static void c(c cVar) {
        }

        public static VideoFeedLandingCacheData d(c cVar) {
            return null;
        }

        public static boolean g(c cVar) {
            return false;
        }

        public static void h(c cVar, com.dragon.read.component.shortvideo.data.saas.video.d dVar, int i) {
        }

        public static void i(c cVar) {
        }

        public static void j(c cVar, SaasVideoData videoData) {
            Intrinsics.checkNotNullParameter(videoData, "videoData");
        }

        public static void k(c cVar, String seriesId, String vid, VideoFeedLandingCacheSaveFrom saveFrom) {
            Intrinsics.checkNotNullParameter(seriesId, "seriesId");
            Intrinsics.checkNotNullParameter(vid, "vid");
            Intrinsics.checkNotNullParameter(saveFrom, "saveFrom");
        }

        public static VideoFeedLandingCacheExpireReason e(c cVar) {
            return VideoFeedLandingCacheExpireReason.NONE;
        }

        public static /* synthetic */ String f(c cVar, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return cVar.n(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFilterIds");
        }
    }
}
