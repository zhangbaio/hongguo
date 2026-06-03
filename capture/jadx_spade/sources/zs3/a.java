package zs3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.dragon.read.component.shortvideo.api.config.MultiVideoModelOpt;
import com.dragon.read.component.shortvideo.api.config.ssconfig.SeriesResolutionABValue;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import k44.e0;
import kotlin.jvm.internal.Intrinsics;
import pr3.o;
import seriessdk.com.dragon.read.saas.rpc.model.DeviceLevel;
import seriessdk.com.dragon.read.saas.rpc.model.GetVideoBizParam;
import seriessdk.com.dragon.read.saas.rpc.model.GetVideoModelRequest;
import seriessdk.com.dragon.read.saas.rpc.model.GetVideoModelResponse;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoDetailSource;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPlatformType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoSeriesIdType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(599180);
        a = new a();
    }

    private a() {
    }

    public final void c(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        e0.a.h().Q(value);
    }

    public final Observable<GetVideoModelResponse> a(String vid, VideoPlatformType videoPlatformType, boolean z, VideoSeriesIdType videoIdType, int i, int i2, String fromVideoId, o oVar, String expireStrategy) {
        boolean z2;
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(videoIdType, "videoIdType");
        Intrinsics.checkNotNullParameter(fromVideoId, "fromVideoId");
        Intrinsics.checkNotNullParameter(expireStrategy, "expireStrategy");
        GetVideoModelRequest getVideoModelRequest = new GetVideoModelRequest();
        getVideoModelRequest.videoId = vid;
        GetVideoBizParam getVideoBizParam = new GetVideoBizParam();
        getVideoModelRequest.bizParam = getVideoBizParam;
        if (videoPlatformType == null) {
            videoPlatformType = VideoPlatformType.Outer;
        }
        getVideoBizParam.videoPlatform = videoPlatformType;
        SeriesResolutionABValue a2 = SeriesResolutionABValue.a.a();
        GetVideoBizParam getVideoBizParam2 = getVideoModelRequest.bizParam;
        getVideoBizParam2.needAllVideoDefinition = a2.requestAllDefinition;
        getVideoBizParam2.needMp4Align = a2.requestMp4Align;
        getVideoBizParam2.useOsPlayer = z;
        if (!MultiVideoModelOpt.a.a().enable) {
            getVideoModelRequest.bizParam.videoIdType = videoIdType;
        } else {
            VideoContentType findByValue = VideoContentType.findByValue(i);
            if (findByValue == null) {
                findByValue = VideoContentType.ShortSeriesPlay;
            }
            getVideoModelRequest.videoContentType = findByValue;
        }
        GetVideoBizParam getVideoBizParam3 = getVideoModelRequest.bizParam;
        getVideoBizParam3.fromVideoId = fromVideoId;
        getVideoBizParam3.source = VideoDetailSource.findByValue(i2);
        DeviceLevel deviceLevel = DeviceLevel.High;
        e0 e0Var = e0.a;
        if (e0Var.a().isLowDevice()) {
            deviceLevel = DeviceLevel.Low;
        } else if (e0Var.a().isMiddleLowDevice()) {
            deviceLevel = DeviceLevel.Middle;
        }
        GetVideoBizParam getVideoBizParam4 = getVideoModelRequest.bizParam;
        getVideoBizParam4.deviceLevel = deviceLevel;
        if (oVar != null) {
            getVideoBizParam4.useServerDns = oVar.a;
            getVideoBizParam4.useServerDnsScene = oVar.b;
        }
        if (expireStrategy.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            getVideoModelRequest.bizParam.expireStrategy = expireStrategy;
        }
        Observable<GetVideoModelResponse> subscribeOn = ShortSeriesApi.Companion.c().getRequestManager().f(getVideoModelRequest).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "subscribeOn(...)");
        return subscribeOn;
    }

    public static /* synthetic */ Observable b(a aVar, String str, VideoPlatformType videoPlatformType, boolean z, VideoSeriesIdType videoSeriesIdType, int i, int i2, String str2, o oVar, String str3, int i3, Object obj) {
        String str4;
        if ((i3 & 256) != 0) {
            str4 = "";
        } else {
            str4 = str3;
        }
        return aVar.a(str, videoPlatformType, z, videoSeriesIdType, i, i2, str2, oVar, str4);
    }
}
