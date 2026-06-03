package com.dragon.read.component.shortvideo.api;

import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.rpc.model.VideoDetailRequest;
import com.dragon.read.rpc.model.VideoDetailVideoData;
import com.dragon.read.video.VideoDetailModel;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface ShortSeriesDistributeApi extends IService {
    public static final a Companion;
    public static final ShortSeriesDistributeApi IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598189);
            a = new a();
        }

        private a() {
        }
    }

    void addUserVideo(String str, String str2, String str3, double d, List<Long> list, boolean z, String str4, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, ? extends Object> map3, Function2<? super Long, ? super String, Unit> function2, Function1<? super Throwable, Unit> function1);

    boolean canShowImageSearchEntryBanner();

    boolean canShowNewDramaCalendarEntrance();

    boolean canShowPUGCVideoAlbum();

    v createVideoPublishReporter(String str, long j, String str2, String str3);

    Single<Boolean> doActionDislike(l34.c cVar);

    boolean enableAdjustPublishButtonWidth();

    boolean enableFixLandingSingleTabPause();

    boolean enableFixSeriesMallTabAdapter();

    boolean enableFixSingleTabStickyEvent();

    boolean enableFixVideoEpisodeAnimatorNpe();

    boolean enableFixVideoInfiniteFlow();

    boolean enableNewUserOptV711();

    boolean enablePostTabInvalidDataFilter();

    boolean enablePugcVideoModelPreload();

    boolean enableRemoveVideoBottomExtendViewFactory();

    boolean enableVideoFeedCommitOpt();

    gr3.b getFeedLandingDiskCacheProvider();

    SeriesMallDataTransformService getSeriesMallDataTransformServiceImpl();

    i getSeriesMallTopTabStrategyHelper();

    gr3.c getVideoFeedLandingCacheHelper();

    void onBookMallTabListLoaded(List<Integer> list);

    Observable<Map<String, Pair<VideoDetailModel, VideoDetailVideoData>>> requestMultiVideoDetailModel(VideoDetailRequest videoDetailRequest);

    static {
        Covode.recordClassIndex(598188);
        Companion = a.a;
        Object service = ServiceManager.getService(ShortSeriesDistributeApi.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(...)");
        IMPL = (ShortSeriesDistributeApi) service;
    }
}
