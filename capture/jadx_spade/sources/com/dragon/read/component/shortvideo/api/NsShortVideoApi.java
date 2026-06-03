package com.dragon.read.component.shortvideo.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.kmp.reading.model.ug0;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.dragon.read.api.bookapi.BookInfo;
import com.dragon.read.base.AbsFragment;
import com.dragon.read.base.AbsRightSlideFragment;
import com.dragon.read.base.RightSlideScene;
import com.dragon.read.base.ssconfig.template.MineTabLoadOpt;
import com.dragon.read.base.util.AdLog;
import com.dragon.read.component.biz.interfaces.NsReaderActivity;
import com.dragon.read.component.shortvideo.album.AbsMineAlbumListFragment;
import com.dragon.read.component.shortvideo.api.model.FollowScene;
import com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.dragon.read.component.shortvideo.data.ugc.SaaSSeriesUgcPostData;
import com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostData;
import com.dragon.read.component.shortvideo.model.OpenVideoLikeActivityArgs;
import com.dragon.read.feed.bookmall.card.model.staggered.InfiniteCell;
import com.dragon.read.pages.bookmall.model.VideoTabModel;
import com.dragon.read.pages.record.model.RecordTabType;
import com.dragon.read.recyler.RecyclerClient;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.rpc.model.BottomTabBarItemType;
import com.dragon.read.rpc.model.CellViewData;
import com.dragon.read.rpc.model.MimeEntranceData;
import com.dragon.read.rpc.model.NovelToVideoData;
import com.dragon.read.rpc.model.RelateSeries;
import com.dragon.read.rpc.model.StatData;
import com.dragon.read.rpc.model.StatReportScene;
import com.dragon.read.rpc.model.VideoAlbumDetailInfo;
import com.dragon.read.rpc.model.VideoTagInfo;
import com.dragon.read.rpc.model.VideoTimePointReqType;
import com.dragon.read.rpc.model.VideoTimePointResponse;
import com.dragon.read.util.screenshot.ScreenshotPageData;
import com.dragon.read.video.VideoData;
import com.dragon.read.video.VideoDetailModel;
import com.dragon.read.widget.ScaleBookCover;
import com.dragon.reader.lib.parserlevel.processor.IParagraphLayoutProcessor;
import com.ss.ttvideoengine.model.VideoModel;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pr3.r;
import qo3.m0;
import qo3.n0;
import qo3.w0;
import seriessdk.com.dragon.read.saas.rpc.model.VideoShareInfo;
import xb1.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface NsShortVideoApi extends IService {
    public static final String COLD_START_TAG;
    public static final a Companion;
    public static final String HongguoFlavor;
    public static final NsShortVideoApi IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598161);
            a = new a();
        }

        private a() {
        }
    }

    void addLikeModel(tu4.a aVar);

    void addStatReportData(StatData statData, StatReportScene statReportScene);

    void appendVideoWorkList(ArrayList<String> arrayList, boolean z, String str);

    c attachLivePreviewController(RecyclerView recyclerView, String str, Observable<Boolean> observable);

    is3.j autoPlaySeries();

    boolean canShowVideoCommentNPSCard(String str);

    boolean changeCollectBtnText();

    boolean changeHistoryListenTabPos();

    boolean checkEpisodesHasTwoLinesSubTitle(Context context, List<? extends VideoData> list);

    boolean checkVideoModelInvaild(String str);

    void clearMineWorksPreloadCache();

    void clearPendingVideoPendantRecover();

    void clearPlayletScoreShowRecord();

    void clearProfileFollowCache();

    int coldStartInHistoryDays();

    boolean collectAddFilmAndTeleFilter();

    void collectVideo(Context context, com.dragon.read.video.k kVar, boolean z, FollowScene followScene, boolean z2);

    AbsFragment createMineSelectMultiTabFragment(String str, Bundle bundle);

    AbsFragment createOtherPugcVideoListOneTabFragment(int i, String str, String str2);

    AbsFragment createSeriesMineTabActorAndBrandOneTabFragment(int i, String str, String str2, Bundle bundle);

    boolean currentIsListenMode();

    boolean defaultMute();

    void deleteLikeModel(tu4.a aVar);

    void destroyVideoPendant();

    Single<Boolean> diggPicTextLike(String str, boolean z, String str2);

    Single<Boolean> diggVideoLike(tu4.a aVar, boolean z, String str);

    void dismissListenModeNotification();

    void dispatchFollowUpdateStateChange(List<Pair<String, Boolean>> list, boolean z);

    Single<l34.d> doPostAction(String str, int i, Boolean bool);

    void doUserSubscribe(String str, Integer num, Function2<? super String, ? super Integer, Unit> function2, Function1<? super Integer, Unit> function1, Function0<Unit> function0);

    boolean enableBindToutiao();

    boolean enableBookMallDoubleColStyleSwitch();

    boolean enableColdStartInCollect();

    boolean enableColdStartInHistory();

    boolean enableCollectCard(boolean z);

    boolean enableDarkMask();

    boolean enableDouyinLoginOptimize();

    boolean enableFQNewUserOpt();

    boolean enableFixLynxCnyTabVisibilityDispatch();

    boolean enableFixMineTabEditTopBar();

    boolean enableFixMineTabNumError();

    boolean enableFixNewVideoMallCnyBtnConflict();

    boolean enableFixRecycleViewCrash();

    boolean enableFloatingWindow();

    boolean enableFollowUpdateMotionComic();

    boolean enableFontScaleChange();

    boolean enableHighlightFixInSingleColumns();

    boolean enableHistoryRepeatFilter();

    boolean enableHistoryRepeatMonitor();

    MineTabLoadOpt enableMinePageLoadOptimize();

    boolean enableMinePageSubTabSmoothScroll();

    boolean enableMinePostTab();

    boolean enableMultiRoles();

    boolean enableNaturalEComRevert();

    boolean enableNewBrandColorOpt();

    boolean enableNewFilmTeleFragment();

    boolean enableNewUserOpt();

    boolean enableOnlyPreloadSeriesXml();

    boolean enableOuterTopAreaFade();

    boolean enablePayVideo();

    boolean enablePayVideoMidAd(Context context, String str);

    boolean enablePicEComSearchImageSizeOpt();

    boolean enablePrefetchSingleModel();

    boolean enableProgressBarVibrate();

    boolean enablePugcVideoAd();

    boolean enablePugcVideoAlbum();

    boolean enableReaderSingleEngineOpt();

    boolean enableRecentVideoEarlyPrefetch();

    boolean enableRecentWatchVideoModelDisk();

    boolean enableReportPugcTabTrace();

    boolean enableReportShowTabOnHotStart();

    boolean enableRouteToSelfSeriesProfilePage(String str);

    boolean enableScaleCommentDialogFont();

    boolean enableSearchTagAlignEdge();

    boolean enableSeriesMallCnyTabExitRetain();

    boolean enableShortSeriesCoverTopBg();

    boolean enableShortSeriesWithTotalAppFontChange();

    void enableShowBackToFirstGuide(String str, boolean z);

    boolean enableSingleTabRightSlide();

    boolean enableStopVideoPicSearch();

    boolean enableSubscribeDialogStyleOpt();

    Pair<Boolean, String> enableUpload(ws3.q qVar, int i);

    boolean enableUseTabType16();

    boolean enableVideoLandingOpt();

    boolean enableVideoModelPreload();

    boolean enableVideoTabTagAlignEdge();

    boolean enableWatchPreferenceRedDot();

    boolean enableZoomCommentPanelFont();

    void enqueue(List<pr3.n> list);

    boolean exitRetentionWithFreshConfig();

    void fetchShortSeriesGenreAd(int i, String str, AdLog adLog, b.b bVar);

    Observable<List<l34.s>> fetchUserProfileTab(String str);

    boolean fixActivityEntranceConflictWithSearchBar();

    boolean fixAutoPlayCardReportDurationIssue();

    boolean fixBottomTabFragmentOverlap();

    boolean fixRecyclerViewPrefetchCrash();

    boolean fixVideoTabLoadMore();

    boolean getAllHotStartRefreshEnable();

    boolean getAppFakeExitEnable();

    int getBackIconResId();

    int getBrandBtnColorStyle();

    Single<String> getCurPlayVidForReaderSingleCol(Object obj, String str);

    long getCurrentPlayProgress();

    xr3.c getCurrentScaleConfig();

    String getDanmuGeckoResPath(String str);

    int getEComPicDialogPosition();

    String getExitRetainCacheSeriesId();

    int getExitRetentionToMultiTabDuration();

    long getExitRetentionToVideoFeedTabDuration();

    gr3.b getFeedLandingDiskCacheProvider();

    Pair<String, l34.q> getFollowShowToastText(boolean z);

    String getFollowUpdateEntryText();

    String getFollowUpdatePageSchema();

    List<String> getFromParamKeys();

    boolean getFullScreenLoginPageAnimOptEnable();

    List<Object> getGlobalBridge();

    String getHighlightVid(CellViewData cellViewData, boolean z);

    int getHotStartRefreshDuration();

    m getImageConfig();

    int getInnerFeedVideoPos(String str);

    com.dragon.read.component.shortvideo.api.b getInnerPushService();

    String getIntroduction(String str);

    VideoTimePointResponse getMatchBookData(String str, Consumer<VideoTimePointResponse> consumer, Consumer<Throwable> consumer2);

    VideoTimePointResponse getMatchVideoData(String str, VideoTimePointReqType videoTimePointReqType, Consumer<VideoTimePointResponse> consumer, Consumer<Throwable> consumer2);

    f getMineLikeFragmentProviderService();

    g getPlayletCommentService();

    hs3.a getPrivacyPopupStyleService();

    bu4.c getPrivacySettingItem();

    View getRankActivityEntranceViewFromKmp(Context context, ug0 ug0Var);

    Integer getRelationType(String str);

    AbsRightSlideFragment getRightSlideFragment(RightSlideScene rightSlideScene, Activity activity);

    ScreenshotPageData getScreenshotPageData(Context context);

    j getSeriesPayContentRepository();

    List<String> getSeriesPostPreloadFontList();

    int getSeriesRecommendProgressStyle();

    k getSeriesSubscribeCalendarManager();

    n0 getSeriesSubscribeManager();

    String getSeriesSubscribeText();

    View getShortSeriesCatalogView(Context context, rq3.n nVar);

    l getShortSeriesEventListener();

    Drawable getShortSeriesTagBgDrawable(Context context, VideoTagInfo videoTagInfo);

    Drawable getShortSeriesTagBgDrawable(Context context, VideoTagInfo videoTagInfo, float f);

    Drawable getShortSeriesTagBgDrawableOrNull(Context context, VideoTagInfo videoTagInfo);

    Integer getShortSeriesTagTextColor(Context context, VideoTagInfo videoTagInfo);

    o getShortVideoCommentService();

    boolean getShowVideoLikeInMime();

    String getTabName(BottomTabBarItemType bottomTabBarItemType);

    BehaviorSubject<String> getTargetSeriesIdObserver();

    s getVideoFeedFastPlayManager();

    gr3.c getVideoFeedLandingCacheHelper();

    BSVideoHistoryService getVideoHistoryService();

    u getVideoLiveRoomService();

    int getVideoProgressUploadOptThreshold();

    Class<?> getVideoRecordActivityClazz();

    String getVideoRecordSelectedIndex();

    et3.b getVideoReporterApi();

    long getVideoTabBackPressDuration();

    NovelToVideoData getVideoTimePointDataByStartPara(List<? extends NovelToVideoData> list, int i, int i2);

    boolean hadLaunchedPlayer();

    void handleCurePlayEvent(pr3.a aVar);

    void handlePlayletSameProductParams(Uri uri, Bundle bundle);

    void handleReaderMoreSettingItem(NsReaderActivity nsReaderActivity, List<wr5.n> list, Function2<? super Boolean, ? super String, Unit> function2);

    void handleVideoLikeUiConfig(Context context);

    void hideGoldCoinTimeCounter(String str);

    boolean historyAddFilmAndTeleTab();

    void initCpuPowerMonitor();

    void initSDK();

    void initSeriesSubscribeHelper();

    boolean interceptMessagePageVideoPublish();

    boolean isBackFromSeriesActivity();

    boolean isEnableVideoCommentDialogLeftSwipeBack();

    boolean isEnableVoiceFocusOpt();

    boolean isExitRetentionToMultiTab(BottomTabBarItemType bottomTabBarItemType, int i);

    boolean isExitRetentionToVideoFeedRecommendFromShortVideo(int i);

    boolean isExitRetentionToVideoFeedTab(BottomTabBarItemType bottomTabBarItemType, int i);

    boolean isFixMineTabShowVideo();

    boolean isFixSearchVideoCardFoldSize();

    boolean isFixVideoRecordDuration();

    boolean isForceLoginWhenCollect();

    boolean isForceLoginWhenLike();

    boolean isFromPlayPageToBookmall();

    boolean isFromReaderAdPosition();

    boolean isGenreAdInProgress();

    boolean isHongguo(String str);

    boolean isInFestivalProduceGuidance();

    boolean isInShortSeriesActivityDetailFragment(Context context);

    boolean isMineLeftPageSlideEnable();

    boolean isMoreAdaptationGuideEnable();

    boolean isPayVideo(Context context, String str);

    boolean isPugcSharePanelEnable();

    boolean isReaderAddVideoButtonV2Enable();

    boolean isReaderAddVideoSyncButtonEnable();

    boolean isSeriesReturnVisitScrollPrefetchEnable();

    boolean isSeriesSharePanelEnable(VideoShareInfo videoShareInfo);

    boolean isShortSeriesActivity(Context context);

    boolean isShortSeriesDetailActivity(Context context);

    boolean isShortSeriesLandActivity(Context context);

    boolean isShortSeriesMineActivity(Context context);

    boolean isShortSeriesTagBgBold();

    boolean isShowAdvanceDanmaku();

    boolean isShowRepeatDanmaku();

    boolean isShowVideoSyncButton(String str, String str2);

    boolean isVideoButtonTipsShowed(String str, String str2);

    boolean isVideoDetailActivity(Context context);

    boolean isVideoFeedTabVisible();

    boolean isVideoPendantShowing();

    boolean isVideoProgressUploadOptEnable();

    boolean isVideoTabBackPressRefreshEnable();

    boolean isWatchSeriesTaskRunning();

    Observable<r> loadVideoModel(boolean z, pr3.f fVar);

    void makeSureLogin(String str, Function0<Unit> function0);

    void makeSureSeriesScaleMatchApp();

    void markCanPauseVideoWhenLossAudioFocus();

    void markGuestProfileFirstScreenStartTime();

    void middleNodeTrace(String str);

    AbsMineAlbumListFragment mineAlbumFragment();

    AbsFragment myPlayletCommentListFragment();

    boolean needLiveBlurCover();

    RecyclerView.ItemDecoration newMineGridSpacingItemDecoration(boolean z, int i, boolean z2);

    RecyclerView.ItemDecoration newRecordPageWithTopFilterDecoration(boolean z, boolean z2);

    AbsFragment newVideoLikeFragment(RecordTabType recordTabType);

    void notifyUserRelationChange(String str, int i);

    void notifyUserRelationChange(String str, boolean z);

    Observable<xr3.c> observeScaleConfigChange();

    ws3.c obtainFeedTabFragmentProvider(ws3.b bVar);

    void onActivityResult(AppCompatActivity appCompatActivity, int i, int i2, Intent intent);

    void onBookmallTabInvisible();

    void onDataSet(MimeEntranceData mimeEntranceData);

    void onEnterShortSeriesFeedTab();

    void onHandleReaderSyncMenuCurrentValue(Map<String, String> map);

    void onHandleReaderSyncMenuDefault(Map<String, String> map);

    void onKeyUp(int i, KeyEvent keyEvent);

    void onMainFragmentActivityRestoreInstanceState();

    void onSeriesReserveStateChange(List<Pair<String, Boolean>> list);

    void onShortSeriesFeedTabRedDotShow();

    void onSplashSyncInit();

    void onSyncReaderSyncMenuValueToLocal(Map<String, String> map);

    void openChannelOrderDialog(List<String> list);

    void openSeriesGenreAd(AdLog adLog, com.bytedance.tomato.entity.reward.f fVar, b.b bVar);

    void openShortSeriesActivity(ShortSeriesLaunchArgs shortSeriesLaunchArgs);

    void openShortSeriesDetailActivity(l34.k kVar);

    void openShortSeriesMineActivity(Context context, PageRecorder pageRecorder);

    void openVideoLikeActivity(OpenVideoLikeActivityArgs openVideoLikeActivityArgs);

    void openVideoPlayerForJsb(BulletContainerView bulletContainerView, ArrayList<String> arrayList, int i, boolean z, String str, boolean z2, boolean z3, IBDXBridgeContext iBDXBridgeContext);

    InfiniteCell parseDetailCommentCardModel(CellViewData cellViewData, CellViewData cellViewData2);

    void parseSeriesUgcPostData(SaaSSeriesUgcPostData saaSSeriesUgcPostData, VideoTabModel.VideoData videoData);

    void parseSeriesUgcPostData(SaaSSeriesUgcPostData saaSSeriesUgcPostData, VideoDetailModel videoDetailModel);

    void parseUgcPostData(SaaSUgcPostData saaSUgcPostData, VideoTabModel.VideoData videoData);

    void parseUgcPostData(SaaSUgcPostData saaSUgcPostData, VideoAlbumDetailInfo videoAlbumDetailInfo, VideoTabModel.VideoData videoData, boolean z);

    void parseUgcPostData(SaaSUgcPostData saaSUgcPostData, VideoDetailModel videoDetailModel);

    pr3.q parseVideoHighlightModel(CellViewData cellViewData, boolean z);

    tu4.a parseVideoLikeModel(com.dragon.read.component.shortvideo.data.saas.video.d dVar, SaasVideoDetailModel saasVideoDetailModel);

    VideoModel parseVideoModel(String str);

    void prefetchMultiVideoModel(List<l34.e> list, int i);

    void prefetchSingleVideoModel(String str, String str2, int i);

    void prepareConfigOnColdStart();

    void prepareNovelToVideoData(String str, VideoTimePointReqType videoTimePointReqType);

    void prepareVideoFeedABValue();

    IParagraphLayoutProcessor provideSeriesParaLayoutProcessor();

    Drawable provideShortSeriesPreloadCover(boolean z);

    hs3.b provideVideoButtonView(NsReaderActivity nsReaderActivity);

    i35.d provideVideoReaderLifecycle();

    hs3.c provideVideoReaderMenuBizDispatcher(NsReaderActivity nsReaderActivity, qr5.a aVar);

    t providerVideoLivePreviewLayout(Context context);

    m0 recordDataManager();

    void recordVideoCommentNPSCardClose(String str);

    void recordVideoCommentNPSCardShow(String str);

    void refreshVideoData(l34.f fVar);

    void registerDetailCommentCardViewHolderFactory(RecyclerClient recyclerClient, com.dragon.read.base.impression.a aVar, q64.r rVar);

    void registerMineWorksEventObserver();

    void registerUserRelationChangeListener(boolean z, w wVar);

    void releaseLivePreviewController(Context context, String str);

    void releaseRightSlideFragments();

    void removeRightSlideFragment(RightSlideScene rightSlideScene);

    void reportLauncherServiceParseSuccess(String str);

    void reportShowNotification(String str, int i);

    void requestShortSeriesFeedButtonRedDot();

    void resumePreload();

    boolean safeGetActivityFromContext();

    void scrollToTargetItem(String str, AbsFragment absFragment);

    void setBookCoverOtherInfo(BookInfo bookInfo, ScaleBookCover scaleBookCover);

    void setGusetPugcDataSource(p pVar);

    void setVideoPendantRemoved(boolean z);

    void setVideoPendantShowing(boolean z);

    n shortSeriesText();

    boolean shouldShowVideoPendant();

    void showFloatingWindowTips(Context context, Function1<? super Boolean, Unit> function1);

    void showFollowUpdateSuccessToast(String str);

    void showLandingSelectDialog(Function1<? super gk4.y, Unit> function1, Function0<Unit> function0);

    void showMorePanelDialog();

    void showReportDialog(Activity activity, String str, String str2, String str3, Function0<Unit> function0, Function0<Unit> function02);

    void showSeriesNotification();

    void showShortSeriesTag(TextView textView, VideoTagInfo videoTagInfo);

    void showShortSeriesTag(TextView textView, VideoTagInfo videoTagInfo, float f, boolean z);

    void startTrace(int i);

    void startUploadVideo(AppCompatActivity appCompatActivity, BulletContainerView bulletContainerView, String str, String str2, IBDXBridgeContext iBDXBridgeContext);

    void stopCurrentJumpVideoCounting();

    void stopUploadVideo(String str, String str2);

    void subscribeOpTypeChange(int i, String str);

    dv4.a transform(VideoTabModel.VideoData videoData);

    dv4.a transform(RelateSeries relateSeries);

    dv4.a transform(hu4.c cVar);

    Observable<List<com.dragon.read.component.shortvideo.data.saas.video.d>> transformVideoData(List<? extends VideoTabModel> list);

    boolean tryBackToPortraitAndRun(Context context, boolean z, String str, Function1<? super FragmentActivity, Unit> function1);

    Long tryGetJumpVideoRetainTime(String str);

    void tryHideTakeCashGuidePendant();

    void tryPreloadMineWorksData(String str);

    void tryPrepareLandingCacheVideo(Context context, int i);

    boolean tryPrepareVideo(ShortSeriesLaunchArgs shortSeriesLaunchArgs, int i);

    void tryReportPendingConsumeData();

    boolean tryRestorePlayerFromLaunch(Context context, PageRecorder pageRecorder);

    void tryShowGoldCoinTimeCounter(String str);

    void tryShowShortSeriesAppWidgetPendant();

    void tryShowVideoPolarisPendant(String str);

    void updateItemDecorationSpanCount(RecyclerView.ItemDecoration itemDecoration, int i);

    void updateLastVideoScene(String str, int i);

    void updateRetainToShortSeriesEnable(boolean z);

    void updateSeekBarStyle();

    boolean useNewPreferencePage();

    AbsFragment videoPublishedFragment();

    w0 videoRecordRouter();

    static {
        Covode.recordClassIndex(598160);
        Companion = a.a;
        HongguoFlavor = "hongguo";
        COLD_START_TAG = "video_series";
        Object service = ServiceManager.getService(NsShortVideoApi.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(...)");
        IMPL = (NsShortVideoApi) service;
    }

    public static final class b {
        static {
            Covode.recordClassIndex(598162);
        }

        public static void m(NsShortVideoApi nsShortVideoApi) {
        }

        public static boolean h(NsShortVideoApi nsShortVideoApi, String flavor) {
            Intrinsics.checkNotNullParameter(flavor, "flavor");
            return NsShortVideoApi.HongguoFlavor.equals(flavor);
        }

        public static /* synthetic */ Pair e(NsShortVideoApi nsShortVideoApi, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return nsShortVideoApi.getFollowShowToastText(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFollowShowToastText");
        }

        public static /* synthetic */ AbsFragment l(NsShortVideoApi nsShortVideoApi, RecordTabType recordTabType, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    recordTabType = null;
                }
                return nsShortVideoApi.newVideoLikeFragment(recordTabType);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newVideoLikeFragment");
        }

        public static /* synthetic */ Observable i(NsShortVideoApi nsShortVideoApi, boolean z, pr3.f fVar, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return nsShortVideoApi.loadVideoModel(z, fVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadVideoModel");
        }

        public static /* synthetic */ RecyclerView.ItemDecoration k(NsShortVideoApi nsShortVideoApi, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = false;
                }
                return nsShortVideoApi.newRecordPageWithTopFilterDecoration(z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newRecordPageWithTopFilterDecoration");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ c a(NsShortVideoApi nsShortVideoApi, RecyclerView recyclerView, String str, Observable observable, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    observable = Observable.empty();
                }
                return nsShortVideoApi.attachLivePreviewController(recyclerView, str, observable);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachLivePreviewController");
        }

        public static /* synthetic */ Single c(NsShortVideoApi nsShortVideoApi, String str, boolean z, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = null;
                }
                return nsShortVideoApi.diggPicTextLike(str, z, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: diggPicTextLike");
        }

        public static /* synthetic */ Single d(NsShortVideoApi nsShortVideoApi, tu4.a aVar, boolean z, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str = null;
                }
                return nsShortVideoApi.diggVideoLike(aVar, z, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: diggVideoLike");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VideoTimePointResponse f(NsShortVideoApi nsShortVideoApi, String str, Consumer consumer, Consumer consumer2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    consumer = null;
                }
                if ((i & 4) != 0) {
                    consumer2 = null;
                }
                return nsShortVideoApi.getMatchBookData(str, consumer, consumer2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMatchBookData");
        }

        public static /* synthetic */ RecyclerView.ItemDecoration j(NsShortVideoApi nsShortVideoApi, boolean z, int i, boolean z2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    z = false;
                }
                if ((i2 & 2) != 0) {
                    i = -1;
                }
                if ((i2 & 4) != 0) {
                    z2 = false;
                }
                return nsShortVideoApi.newMineGridSpacingItemDecoration(z, i, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newMineGridSpacingItemDecoration");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VideoTimePointResponse g(NsShortVideoApi nsShortVideoApi, String str, VideoTimePointReqType videoTimePointReqType, Consumer consumer, Consumer consumer2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    consumer = null;
                }
                if ((i & 8) != 0) {
                    consumer2 = null;
                }
                return nsShortVideoApi.getMatchVideoData(str, videoTimePointReqType, consumer, consumer2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMatchVideoData");
        }

        public static /* synthetic */ void b(NsShortVideoApi nsShortVideoApi, Context context, com.dragon.read.video.k kVar, boolean z, FollowScene followScene, boolean z2, int i, Object obj) {
            boolean z3;
            if (obj == null) {
                if ((i & 16) != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                nsShortVideoApi.collectVideo(context, kVar, z, followScene, z3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collectVideo");
        }

        public static /* synthetic */ void n(NsShortVideoApi nsShortVideoApi, AppCompatActivity appCompatActivity, BulletContainerView bulletContainerView, String str, String str2, IBDXBridgeContext iBDXBridgeContext, int i, Object obj) {
            if (obj == null) {
                if ((i & 16) != 0) {
                    iBDXBridgeContext = null;
                }
                nsShortVideoApi.startUploadVideo(appCompatActivity, bulletContainerView, str, str2, iBDXBridgeContext);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startUploadVideo");
        }
    }
}
