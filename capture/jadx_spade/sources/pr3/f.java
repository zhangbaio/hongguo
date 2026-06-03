package pr3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.model.PrefetchScope;
import com.dragon.read.component.shortvideo.api.model.VideoModelExpireStrategy;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPlatformType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoSeriesIdType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final a k;
    public String a;
    public VideoPlatformType b;
    public VideoSeriesIdType c;
    public int d;
    public int e;
    public String f;
    public String g;
    public o h;
    public VideoModelExpireStrategy i;
    public PrefetchScope j;

    static {
        Covode.recordClassIndex(598773);
        k = new a(null);
    }

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private f() {
        this.a = "";
        this.b = VideoPlatformType.Unknown;
        this.c = VideoSeriesIdType.VideoId;
        this.d = VideoContentType.ShortSeriesPlay.getValue();
        this.f = "";
        this.g = "";
        this.i = VideoModelExpireStrategy.NONE;
        this.j = PrefetchScope.OTHER;
    }

    public final void i(PrefetchScope prefetchScope) {
        Intrinsics.checkNotNullParameter(prefetchScope, "<set-?>");
        this.j = prefetchScope;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598774);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f c(String vid, String seriesId) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            Intrinsics.checkNotNullParameter(seriesId, "seriesId");
            f fVar = new f(null);
            fVar.a = vid;
            fVar.g = seriesId;
            return fVar;
        }

        public final f b(SaasVideoData videoData, VideoModelExpireStrategy expireStrategy) {
            VideoSeriesIdType videoSeriesIdType;
            Intrinsics.checkNotNullParameter(videoData, "videoData");
            Intrinsics.checkNotNullParameter(expireStrategy, "expireStrategy");
            f fVar = new f(null);
            String vid = videoData.getVid();
            Intrinsics.checkNotNullExpressionValue(vid, "getVid(...)");
            fVar.a = vid;
            fVar.b = videoData.getVideoPlatform();
            if (!videoData.isRelatedMaterialId() && !com.dragon.read.component.shortvideo.data.saas.video.a.e(videoData)) {
                videoSeriesIdType = VideoSeriesIdType.VideoId;
            } else {
                videoSeriesIdType = VideoSeriesIdType.SeriesId;
            }
            fVar.c = videoSeriesIdType;
            VideoContentType contentType = videoData.getContentType();
            if (contentType == null) {
                if (!videoData.isRelatedMaterialId() && !com.dragon.read.component.shortvideo.data.saas.video.a.e(videoData)) {
                    contentType = VideoContentType.ShortSeriesPlay;
                } else {
                    contentType = VideoContentType.PUGC;
                }
            }
            fVar.d = contentType.getValue();
            String seriesId = videoData.getSeriesId();
            Intrinsics.checkNotNullExpressionValue(seriesId, "getSeriesId(...)");
            fVar.g = seriesId;
            fVar.i = expireStrategy;
            return fVar;
        }

        public final f d(String vid, String str, int i) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            f fVar = new f(null);
            fVar.a = vid;
            if (str == null) {
                str = "";
            }
            fVar.g = str;
            fVar.d = i;
            return fVar;
        }

        public final f a(SaasVideoData videoData, int i, String fromVideoId) {
            Intrinsics.checkNotNullParameter(videoData, "videoData");
            Intrinsics.checkNotNullParameter(fromVideoId, "fromVideoId");
            f fVar = new f(null);
            String vid = videoData.getVid();
            Intrinsics.checkNotNullExpressionValue(vid, "getVid(...)");
            fVar.a = vid;
            fVar.b = videoData.getVideoPlatform();
            VideoSeriesIdType videoSeriesIdType = videoData.getVideoSeriesIdType();
            Intrinsics.checkNotNullExpressionValue(videoSeriesIdType, "getVideoSeriesIdType(...)");
            fVar.c = videoSeriesIdType;
            VideoContentType contentType = videoData.getContentType();
            if (contentType == null) {
                if (videoData.getVideoSeriesIdType() == VideoSeriesIdType.VideoId) {
                    contentType = VideoContentType.ShortSeriesPlay;
                } else {
                    contentType = VideoContentType.PUGC;
                }
            }
            fVar.d = contentType.getValue();
            fVar.e = i;
            fVar.f = fromVideoId;
            String seriesId = videoData.getSeriesId();
            Intrinsics.checkNotNullExpressionValue(seriesId, "getSeriesId(...)");
            fVar.g = seriesId;
            return fVar;
        }

        public final f e(String vid, String str, Integer num, VideoSeriesIdType videoSeriesIdType) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            f fVar = new f(null);
            fVar.a = vid;
            if (str == null) {
                str = "";
            }
            fVar.g = str;
            if (num != null) {
                fVar.d = num.intValue();
            }
            if (videoSeriesIdType != null) {
                fVar.c = videoSeriesIdType;
            }
            return fVar;
        }

        public static /* synthetic */ f g(a aVar, SaasVideoData saasVideoData, VideoModelExpireStrategy videoModelExpireStrategy, int i, Object obj) {
            if ((i & 2) != 0) {
                videoModelExpireStrategy = VideoModelExpireStrategy.NONE;
            }
            return aVar.b(saasVideoData, videoModelExpireStrategy);
        }

        public static /* synthetic */ f f(a aVar, SaasVideoData saasVideoData, int i, String str, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                str = "";
            }
            return aVar.a(saasVideoData, i, str);
        }
    }
}
