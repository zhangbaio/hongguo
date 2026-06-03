package com.dragon.read.component.shortvideo.homepage.impl;

import android.util.Pair;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.AppProperty;
import com.dragon.read.base.ssconfig.template.ImageSearchEntranceInSearchbar;
import com.dragon.read.base.ssconfig.template.ShortVideoSearchSideEntrance;
import com.dragon.read.component.shortvideo.api.SeriesMallDataTransformService;
import com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi;
import com.dragon.read.component.shortvideo.api.i;
import com.dragon.read.component.shortvideo.brickservice.BSConfigService;
import com.dragon.read.component.shortvideo.brickservice.BsSeriesPostService;
import com.dragon.read.component.shortvideo.brickservice.BsStyleConfigService;
import com.dragon.read.component.shortvideo.impl.config.ShortSeriesCommonConfig;
import com.dragon.read.component.shortvideo.impl.config.VideoFeedLandingPlayerOptConfig;
import com.dragon.read.component.shortvideo.impl.seriesdetail.n5;
import com.dragon.read.component.shortvideo.impl.utils.w0;
import com.dragon.read.component.shortvideo.impl.utils.x0;
import com.dragon.read.rpc.model.VideoDetailRequest;
import com.dragon.read.rpc.model.VideoDetailVideoData;
import com.dragon.read.saas.ugc.model.AddPostBusinessParam;
import com.dragon.read.saas.ugc.model.DoArticleActionRequest;
import com.dragon.read.saas.ugc.model.SaasUgcActionCategory;
import com.dragon.read.saas.ugc.model.UgcActionObjectType;
import com.dragon.read.saas.ugc.model.UgcActionReasonType;
import com.dragon.read.saas.ugc.model.UgcActionType;
import com.dragon.read.util.kotlin.m;
import com.dragon.read.video.VideoDetailModel;
import gr3.b;
import gr3.c;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import nq2.n0;
import nx3.h;
import ox3.e;
import z44.c2;
import z44.g;
import z44.o0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShowSeriesDistributeImpl implements ShortSeriesDistributeApi {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(599231);
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public b getFeedLandingDiskCacheProvider() {
        return e.a;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public SeriesMallDataTransformService getSeriesMallDataTransformServiceImpl() {
        return w0.a;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public i getSeriesMallTopTabStrategyHelper() {
        return x0.a;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public c getVideoFeedLandingCacheHelper() {
        return h.a;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean canShowNewDramaCalendarEntrance() {
        return ShortVideoSearchSideEntrance.a.b().enable;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean enableAdjustPublishButtonWidth() {
        return ShortSeriesCommonConfig.a.a().enableAdjustPublishButtonWidth;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean enableFixLandingSingleTabPause() {
        return ShortSeriesCommonConfig.a.a().enableFixLandingSingleTabPause;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean enableFixSeriesMallTabAdapter() {
        return ShortSeriesCommonConfig.a.a().enableFixSeriesMallTabAdapter;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean enableFixSingleTabStickyEvent() {
        return ShortSeriesCommonConfig.a.a().enableFixSingleTabStickyEvent;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean enableFixVideoEpisodeAnimatorNpe() {
        return ShortSeriesCommonConfig.a.a().enableFixVideoEpisodeAnimatorNpe;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean enableFixVideoInfiniteFlow() {
        return ShortSeriesCommonConfig.a.a().enableFixVideoInfiniteFlow;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean enablePostTabInvalidDataFilter() {
        return ShortSeriesCommonConfig.a.a().enablePostTabInvalidDataFilter;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean enablePugcVideoModelPreload() {
        return ShortSeriesCommonConfig.a.a().enablePreloadPugcVideoModel;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean enableRemoveVideoBottomExtendViewFactory() {
        return ShortSeriesCommonConfig.a.a().enableRemoveVideoBottomExtendViewFactory;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean enableVideoFeedCommitOpt() {
        return VideoFeedLandingPlayerOptConfig.a.b().enableCommitOpt;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean canShowImageSearchEntryBanner() {
        if (n0.a.a() && !ImageSearchEntranceInSearchbar.a.a()) {
            return true;
        }
        return false;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean canShowPUGCVideoAlbum() {
        Boolean bool;
        BsStyleConfigService a = BsStyleConfigService.Companion.a();
        if (a != null) {
            bool = Boolean.valueOf(a.enablePugcVideoAlbum());
        } else {
            bool = null;
        }
        return m.d(bool);
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public boolean enableNewUserOptV711() {
        Boolean bool;
        BSConfigService a = BSConfigService.Companion.a();
        if (a != null) {
            bool = Boolean.valueOf(a.enableNewUserOptV711());
        } else {
            bool = null;
        }
        return m.d(bool);
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public void onBookMallTabListLoaded(List<Integer> bookMallTabTypeList) {
        Intrinsics.checkNotNullParameter(bookMallTabTypeList, "bookMallTabTypeList");
        BsSeriesPostService a = BsSeriesPostService.Companion.a();
        if (a != null) {
            a.onBookMallTabListLoaded(bookMallTabTypeList);
        }
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public Observable<Map<String, Pair<VideoDetailModel, VideoDetailVideoData>>> requestMultiVideoDetailModel(VideoDetailRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Observable<Map<String, Pair<VideoDetailModel, VideoDetailVideoData>>> o = new n5().o(request);
        Intrinsics.checkNotNullExpressionValue(o, "requestMultiVideoDetailModel(...)");
        return o;
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public Single<Boolean> doActionDislike(l34.c args) {
        Intrinsics.checkNotNullParameter(args, "args");
        DoArticleActionRequest doArticleActionRequest = new DoArticleActionRequest();
        doArticleActionRequest.objectID = args.a;
        UgcActionObjectType findByValue = UgcActionObjectType.findByValue(args.b);
        if (findByValue == null) {
            findByValue = UgcActionObjectType.Book;
        }
        doArticleActionRequest.objectType = findByValue;
        doArticleActionRequest.actionType = UgcActionType.Dislike;
        doArticleActionRequest.reasonType = UgcActionReasonType.Server;
        doArticleActionRequest.actionReason = args.c;
        doArticleActionRequest.actionCategory = SaasUgcActionCategory.Default;
        doArticleActionRequest.extra = args.d;
        doArticleActionRequest.appID = AppProperty.getAppId();
        AddPostBusinessParam addPostBusinessParam = new AddPostBusinessParam();
        addPostBusinessParam.recommendInfo = args.e;
        addPostBusinessParam.searchQuery = args.f;
        doArticleActionRequest.businessParam = addPostBusinessParam;
        return g.a.c(doArticleActionRequest);
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public o0 createVideoPublishReporter(String scene, long j, String str, String str2) {
        boolean z;
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (str2 != null && str2.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            str2 = o0.p.a(scene);
        }
        return new o0(str2, j, str);
    }

    @Override // com.dragon.read.component.shortvideo.api.ShortSeriesDistributeApi
    public void addUserVideo(String vid, String title, String cover, double d, List<Long> publishApps, boolean z, String addVideoJsbVersion, Map<String, ? extends Object> extraMap, Map<String, ? extends Object> businessVideoParamMap, Map<String, ? extends Object> reportMap, Function2<? super Long, ? super String, Unit> onUploadSuccess, Function1<? super Throwable, Unit> onUploadFailed) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(publishApps, "publishApps");
        Intrinsics.checkNotNullParameter(addVideoJsbVersion, "addVideoJsbVersion");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        Intrinsics.checkNotNullParameter(businessVideoParamMap, "businessVideoParamMap");
        Intrinsics.checkNotNullParameter(reportMap, "reportMap");
        Intrinsics.checkNotNullParameter(onUploadSuccess, "onUploadSuccess");
        Intrinsics.checkNotNullParameter(onUploadFailed, "onUploadFailed");
        c2.a.N(vid, title, cover, d, publishApps, z, addVideoJsbVersion, extraMap, businessVideoParamMap, reportMap, onUploadSuccess, onUploadFailed);
    }
}
