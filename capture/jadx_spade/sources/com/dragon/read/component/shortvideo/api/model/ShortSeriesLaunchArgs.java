package com.dragon.read.component.shortvideo.api.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.report.PageRecorder;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortSeriesLaunchArgs implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = -16;
    private float animationDrawableRadius;
    private int autoShowDialog;
    private boolean autoShowsMorePanelDialog;
    private String backToFirstGuideContent;
    private String bookIdList;
    private boolean canShowBackToStartBtn;
    private String chapterEndStrategy;
    private boolean chapterSeriesFinishBlockEnable;
    private boolean clearTop;
    private int clickVideoPos;
    private Context context;
    private Bitmap coverBitmap;
    private boolean defaultImmersiveMode;
    private boolean enableEnterAlphaAnimation;
    private boolean enableSharePlayerWhenExit;
    private Bitmap extraBitmap;
    public Bundle extraBundle;
    private View extraGroupView;
    private View extraView;
    private boolean fadingEnterTransitionExit;
    private boolean forceFirstVideoTextureView;
    private boolean fromInfinite;
    private boolean hasHighlight;
    private boolean hideEpisodeText;
    private boolean hideIntroduction;
    private boolean ignoreAudioPlayerVid;
    private boolean ignorePrepareView;
    private int innerScene;
    private InsertVideoData insertVideoData;
    private boolean isAutoEnter;
    private boolean isFixPreplayDecorBug;
    private boolean isFromLeftDrag;
    private boolean isListenMode;
    private String isMute;
    private boolean isRelatedMaterialId;
    private boolean launchCatalogPanel;
    private String moreSeriesIdList;
    private boolean needNotifyEvent;
    private boolean needStartSecond;
    private boolean needUpdateExitRect;
    private boolean newTaskFlag;
    private PageRecorder pageRecorder;
    private boolean saveCallingActivityInfo;
    private String singleRowCellName;
    private boolean startActivityWithoutAnyAnim;
    private boolean startActivityWithoutDefaultAnim;
    private boolean surfaceviewSmoothEnter;
    private int tabType;
    private Long updateExitRectDelay;
    private boolean useFadingTransition;
    private boolean useLocalList;
    private int videoPlatform;
    private View view;
    private String playType = "";
    private String albumId = "";
    private String albumSeriesId = "";
    private String seriesId = "";
    private int enterFrom = -1;
    private String source = "";
    private String albumDetailSource = "";
    private String needBuildVideoRecorder = "";
    private int resultCode = -1;
    private int videoForcePos = -1;
    private long vidForcePos = -1;
    private String vidForce = "";
    private int traceFrom = -1;
    private String highlightSeriesId = "";
    private String highlightVid = "";
    private String playerSubTag = "";
    private boolean enableStartAnimation = true;
    private boolean enableExitAnimation = true;
    private String fromVideoId = "";
    private String targetVid = "";
    private String fromPostId = "";
    public final Map<String, Serializable> extraMap = new LinkedHashMap();
    private String commentInfo = "";
    private String danmakuInfo = "";
    private String firstVideoId = "";
    private long internalSource = -1;
    private boolean clearReportVideoIdWhenExit = true;
    private ProfileType profileType = ProfileType.OBJECT;
    private String feedType = "";
    private int enterAnimId = -1;
    private int preActivityExitAnimId = -1;
    private String targetUgcId = "";

    public static final class a {
        static {
            Covode.recordClassIndex(598800);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(598799);
        Companion = new a(null);
    }

    public final String getAlbumDetailSource() {
        return this.albumDetailSource;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getAlbumSeriesId() {
        return this.albumSeriesId;
    }

    public final float getAnimationDrawableRadius() {
        return this.animationDrawableRadius;
    }

    public final int getAutoShowDialog() {
        return this.autoShowDialog;
    }

    public final boolean getAutoShowsMorePanelDialog() {
        return this.autoShowsMorePanelDialog;
    }

    public final String getBackToFirstGuideContent() {
        return this.backToFirstGuideContent;
    }

    public final String getBookIdList() {
        return this.bookIdList;
    }

    public final boolean getCanShowBackToStartBtn() {
        return this.canShowBackToStartBtn;
    }

    public final String getChapterEndStrategy() {
        return this.chapterEndStrategy;
    }

    public final boolean getChapterSeriesFinishBlockEnable() {
        return this.chapterSeriesFinishBlockEnable;
    }

    public final boolean getClearReportVideoIdWhenExit() {
        return this.clearReportVideoIdWhenExit;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public final int getClickVideoPos() {
        return this.clickVideoPos;
    }

    public final String getCommentInfo() {
        return this.commentInfo;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Bitmap getCoverBitmap() {
        return this.coverBitmap;
    }

    public final String getDanmakuInfo() {
        return this.danmakuInfo;
    }

    public final boolean getDefaultImmersiveMode() {
        return this.defaultImmersiveMode;
    }

    public final boolean getEnableEnterAlphaAnimation() {
        return this.enableEnterAlphaAnimation;
    }

    public final boolean getEnableExitAnimation() {
        return this.enableExitAnimation;
    }

    public final boolean getEnableSharePlayerWhenExit() {
        return this.enableSharePlayerWhenExit;
    }

    public final boolean getEnableStartAnimation() {
        return this.enableStartAnimation;
    }

    public final int getEnterAnimId() {
        return this.enterAnimId;
    }

    public final int getEnterFrom() {
        return this.enterFrom;
    }

    public final Bitmap getExtraBitmap() {
        return this.extraBitmap;
    }

    public final View getExtraGroupView() {
        return this.extraGroupView;
    }

    public final View getExtraView() {
        return this.extraView;
    }

    public final boolean getFadingEnterTransitionExit() {
        return this.fadingEnterTransitionExit;
    }

    public final String getFeedType() {
        return this.feedType;
    }

    public final String getFirstVideoId() {
        return this.firstVideoId;
    }

    public final boolean getForceFirstVideoTextureView() {
        return this.forceFirstVideoTextureView;
    }

    public final boolean getFromInfinite() {
        return this.fromInfinite;
    }

    public final String getFromPostId() {
        return this.fromPostId;
    }

    public final String getFromVideoId() {
        return this.fromVideoId;
    }

    public final boolean getHasHighlight() {
        return this.hasHighlight;
    }

    public final boolean getHideEpisodeText() {
        return this.hideEpisodeText;
    }

    public final boolean getHideIntroduction() {
        return this.hideIntroduction;
    }

    public final String getHighlightSeriesId() {
        return this.highlightSeriesId;
    }

    public final String getHighlightVid() {
        return this.highlightVid;
    }

    public final boolean getIgnoreAudioPlayerVid() {
        return this.ignoreAudioPlayerVid;
    }

    public final boolean getIgnorePrepareView() {
        return this.ignorePrepareView;
    }

    public final int getInnerScene() {
        return this.innerScene;
    }

    public final InsertVideoData getInsertVideoData() {
        return this.insertVideoData;
    }

    public final long getInternalSource() {
        return this.internalSource;
    }

    public final boolean getLaunchCatalogPanel() {
        return this.launchCatalogPanel;
    }

    public final String getMoreSeriesIdList() {
        return this.moreSeriesIdList;
    }

    public final String getNeedBuildVideoRecorder() {
        return this.needBuildVideoRecorder;
    }

    public final boolean getNeedNotifyEvent() {
        return this.needNotifyEvent;
    }

    public final boolean getNeedStartSecond() {
        return this.needStartSecond;
    }

    public final boolean getNeedUpdateExitRect() {
        return this.needUpdateExitRect;
    }

    public final boolean getNewTaskFlag() {
        return this.newTaskFlag;
    }

    public final PageRecorder getPageRecorder() {
        return this.pageRecorder;
    }

    public final String getPlayType() {
        return this.playType;
    }

    public final String getPlayerSubTag() {
        return this.playerSubTag;
    }

    public final int getPreActivityExitAnimId() {
        return this.preActivityExitAnimId;
    }

    public final ProfileType getProfileType() {
        return this.profileType;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final boolean getSaveCallingActivityInfo() {
        return this.saveCallingActivityInfo;
    }

    public final String getSeriesId() {
        return this.seriesId;
    }

    public final String getSingleRowCellName() {
        return this.singleRowCellName;
    }

    public final String getSource() {
        return this.source;
    }

    public final boolean getStartActivityWithoutAnyAnim() {
        return this.startActivityWithoutAnyAnim;
    }

    public final boolean getStartActivityWithoutDefaultAnim() {
        return this.startActivityWithoutDefaultAnim;
    }

    public final boolean getSurfaceviewSmoothEnter() {
        return this.surfaceviewSmoothEnter;
    }

    public final int getTabType() {
        return this.tabType;
    }

    public final String getTargetUgcId() {
        return this.targetUgcId;
    }

    public final String getTargetVid() {
        return this.targetVid;
    }

    public final int getTraceFrom() {
        return this.traceFrom;
    }

    public final Long getUpdateExitRectDelay() {
        return this.updateExitRectDelay;
    }

    public final boolean getUseFadingTransition() {
        return this.useFadingTransition;
    }

    public final boolean getUseLocalList() {
        return this.useLocalList;
    }

    public final String getVidForce() {
        return this.vidForce;
    }

    public final long getVidForcePos() {
        return this.vidForcePos;
    }

    public final int getVideoForcePos() {
        return this.videoForcePos;
    }

    public final int getVideoPlatform() {
        return this.videoPlatform;
    }

    public final View getView() {
        return this.view;
    }

    public final boolean isAutoEnter() {
        return this.isAutoEnter;
    }

    public final boolean isFixPreplayDecorBug() {
        return this.isFixPreplayDecorBug;
    }

    public final boolean isFromLeftDrag() {
        return this.isFromLeftDrag;
    }

    public final boolean isListenMode() {
        return this.isListenMode;
    }

    public final String isMute() {
        return this.isMute;
    }

    public final boolean isRelatedMaterialId() {
        return this.isRelatedMaterialId;
    }

    public final ShortSeriesLaunchArgs setAnimationDrawableRadius(float f) {
        this.animationDrawableRadius = f;
        return this;
    }

    public final ShortSeriesLaunchArgs setAutoEnter(boolean z) {
        this.isAutoEnter = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setAutoShowDialog(int i) {
        this.autoShowDialog = i;
        return this;
    }

    public final ShortSeriesLaunchArgs setAutoShowsMorePanelDialog(boolean z) {
        this.autoShowsMorePanelDialog = z;
        return this;
    }

    public final void setBackToFirstGuideContent(String str) {
        this.backToFirstGuideContent = str;
    }

    public final ShortSeriesLaunchArgs setBookIdList(String str) {
        this.bookIdList = str;
        return this;
    }

    public final ShortSeriesLaunchArgs setCanShowBackToStartBtn(boolean z) {
        this.canShowBackToStartBtn = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setChapterEndStrategy(String str) {
        this.chapterEndStrategy = str;
        return this;
    }

    public final ShortSeriesLaunchArgs setChapterSeriesFinishBlockEnable(boolean z) {
        this.chapterSeriesFinishBlockEnable = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setClearReportVideoIdWhenExit(boolean z) {
        this.clearReportVideoIdWhenExit = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setClearTop(boolean z) {
        this.clearTop = z;
        return this;
    }

    public final void setEnableEnterAlphaAnimation(boolean z) {
        this.enableEnterAlphaAnimation = z;
    }

    public final void setEnableExitAnimation(boolean z) {
        this.enableExitAnimation = z;
    }

    public final void setEnableSharePlayerWhenExit(boolean z) {
        this.enableSharePlayerWhenExit = z;
    }

    public final void setEnableStartAnimation(boolean z) {
        this.enableStartAnimation = z;
    }

    public final ShortSeriesLaunchArgs setEnterFrom(int i) {
        this.enterFrom = i;
        return this;
    }

    public final ShortSeriesLaunchArgs setExtraBundle(Bundle bundle) {
        this.extraBundle = bundle;
        return this;
    }

    public final ShortSeriesLaunchArgs setExtraGroupView(View view) {
        this.extraGroupView = view;
        return this;
    }

    public final ShortSeriesLaunchArgs setExtraView(View view) {
        this.extraView = view;
        return this;
    }

    public final void setFadingEnterTransitionExit(boolean z) {
        this.fadingEnterTransitionExit = z;
    }

    public final void setFixPreplayDecorBug(boolean z) {
        this.isFixPreplayDecorBug = z;
    }

    public final void setForceFirstVideoTextureView(boolean z) {
        this.forceFirstVideoTextureView = z;
    }

    public final ShortSeriesLaunchArgs setForceVideoTextureView(boolean z) {
        this.forceFirstVideoTextureView = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setFromInfinite(boolean z) {
        this.fromInfinite = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setFromLeftDrag(boolean z) {
        this.isFromLeftDrag = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setHasHighlight(boolean z) {
        this.hasHighlight = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setHideEpisodeText(boolean z) {
        this.hideEpisodeText = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setHideIntroduction(boolean z) {
        this.hideIntroduction = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setHighlightVid(String str) {
        this.highlightVid = str;
        return this;
    }

    public final ShortSeriesLaunchArgs setIgnoreAudioPlayerVid(boolean z) {
        this.ignoreAudioPlayerVid = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setIgnorePrepareView(boolean z) {
        this.ignorePrepareView = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setInnerScene(int i) {
        this.innerScene = i;
        return this;
    }

    public final ShortSeriesLaunchArgs setIsDefaultImmersiveMode(boolean z) {
        this.defaultImmersiveMode = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setIsListenMode(boolean z) {
        this.isListenMode = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setIsMute(String str) {
        this.isMute = str;
        return this;
    }

    public final ShortSeriesLaunchArgs setLaunchCatalogPanel(boolean z) {
        this.launchCatalogPanel = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setMoreSeriesList(String str) {
        this.moreSeriesIdList = str;
        return this;
    }

    public final ShortSeriesLaunchArgs setNeedNotifyEvent(boolean z) {
        this.needNotifyEvent = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setNeedStartSecond(boolean z) {
        this.needStartSecond = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setNeedUpdateExitRect(boolean z) {
        this.needUpdateExitRect = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setNewTaskFlag(boolean z) {
        this.newTaskFlag = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setRelatedMaterialId(boolean z) {
        this.isRelatedMaterialId = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setResultCode(int i) {
        this.resultCode = i;
        return this;
    }

    public final ShortSeriesLaunchArgs setSaveCallingActivityInfo(boolean z) {
        this.saveCallingActivityInfo = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setSingleRowCellName(String str) {
        this.singleRowCellName = str;
        return this;
    }

    public final ShortSeriesLaunchArgs setStartActivityWithoutAnyAnim(boolean z) {
        this.startActivityWithoutAnyAnim = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setStartActivityWithoutDefaultAnim(boolean z) {
        this.startActivityWithoutDefaultAnim = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setSurfaceviewSmoothEnter(boolean z) {
        this.surfaceviewSmoothEnter = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setTabType(int i) {
        this.tabType = i;
        return this;
    }

    public final ShortSeriesLaunchArgs setTraceFrom(int i) {
        this.traceFrom = i;
        return this;
    }

    public final ShortSeriesLaunchArgs setUseFadingTransition(boolean z) {
        this.useFadingTransition = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setUseLocalList(boolean z) {
        this.useLocalList = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setVidForcePos(long j) {
        this.vidForcePos = j;
        return this;
    }

    public final ShortSeriesLaunchArgs setVideoClickPos(int i) {
        this.clickVideoPos = i;
        return this;
    }

    public final ShortSeriesLaunchArgs setVideoForcePos(int i) {
        this.videoForcePos = i;
        return this;
    }

    public final ShortSeriesLaunchArgs setVideoPlatform(int i) {
        this.videoPlatform = i;
        return this;
    }

    public final ShortSeriesLaunchArgs setView(View view) {
        this.view = view;
        return this;
    }

    public final ShortSeriesLaunchArgs setAlbumId(String albumId) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        this.albumId = albumId;
        return this;
    }

    public final ShortSeriesLaunchArgs setAlbumSeriesId(String albumSeriesId) {
        Intrinsics.checkNotNullParameter(albumSeriesId, "albumSeriesId");
        this.albumSeriesId = albumSeriesId;
        return this;
    }

    public final ShortSeriesLaunchArgs setCommentInfo(String str) {
        if (str != null) {
            this.commentInfo = str;
        }
        return this;
    }

    public final ShortSeriesLaunchArgs setContext(Context context) {
        if (context != null) {
            this.context = context;
        }
        return this;
    }

    public final ShortSeriesLaunchArgs setDanmakuInfo(String str) {
        if (str != null) {
            this.danmakuInfo = str;
        }
        return this;
    }

    public final ShortSeriesLaunchArgs setFeedType(String feedType) {
        Intrinsics.checkNotNullParameter(feedType, "feedType");
        this.feedType = feedType;
        return this;
    }

    public final ShortSeriesLaunchArgs setFirstVid(String firstVid) {
        Intrinsics.checkNotNullParameter(firstVid, "firstVid");
        this.firstVideoId = firstVid;
        return this;
    }

    public final ShortSeriesLaunchArgs setFromPostId(String postId) {
        Intrinsics.checkNotNullParameter(postId, "postId");
        this.fromPostId = postId;
        return this;
    }

    public final ShortSeriesLaunchArgs setFromVideoId(String fromVideoId) {
        Intrinsics.checkNotNullParameter(fromVideoId, "fromVideoId");
        this.fromVideoId = fromVideoId;
        return this;
    }

    public final ShortSeriesLaunchArgs setHighlightSeriesId(String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        this.highlightSeriesId = seriesId;
        return this;
    }

    public final ShortSeriesLaunchArgs setInsertVideoData(InsertVideoData insertVideoData) {
        Intrinsics.checkNotNullParameter(insertVideoData, "insertVideoData");
        this.insertVideoData = insertVideoData;
        return this;
    }

    public final ShortSeriesLaunchArgs setNeedBuildVideoRecorder(String needAdd) {
        Intrinsics.checkNotNullParameter(needAdd, "needAdd");
        this.needBuildVideoRecorder = needAdd;
        return this;
    }

    public final ShortSeriesLaunchArgs setPageRecorder(PageRecorder pageRecorder) {
        if (pageRecorder != null) {
            this.pageRecorder = pageRecorder;
        }
        return this;
    }

    public final ShortSeriesLaunchArgs setPlayType(String playType) {
        Intrinsics.checkNotNullParameter(playType, "playType");
        this.playType = playType;
        return this;
    }

    public final ShortSeriesLaunchArgs setProfileType(ProfileType profileType) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        this.profileType = profileType;
        return this;
    }

    public final ShortSeriesLaunchArgs setShowBackToFirstGuideInForcePos(String guideContent) {
        Intrinsics.checkNotNullParameter(guideContent, "guideContent");
        this.backToFirstGuideContent = guideContent;
        return this;
    }

    /* renamed from: setSurfaceviewSmoothEnter, reason: collision with other method in class */
    public final void m17setSurfaceviewSmoothEnter(boolean z) {
        this.surfaceviewSmoothEnter = z;
    }

    public final ShortSeriesLaunchArgs setUpdateExitRectDelay(long j) {
        this.updateExitRectDelay = Long.valueOf(j);
        return this;
    }

    public final ShortSeriesLaunchArgs setCoverBitmap(Bitmap bitmap) {
        Bitmap bitmap2;
        if (bitmap != null) {
            bitmap2 = Bitmap.createBitmap(bitmap);
        } else {
            bitmap2 = null;
        }
        this.coverBitmap = bitmap2;
        return this;
    }

    public final ShortSeriesLaunchArgs setEnableEnterAlphaAnimation(Boolean bool) {
        boolean z;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = this.enableEnterAlphaAnimation;
        }
        this.enableEnterAlphaAnimation = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setEnableStartAnimation(Boolean bool) {
        boolean z;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = this.enableStartAnimation;
        }
        this.enableStartAnimation = z;
        return this;
    }

    public final ShortSeriesLaunchArgs setExtraBitmap(Bitmap bitmap) {
        Bitmap bitmap2;
        if (bitmap != null) {
            bitmap2 = Bitmap.createBitmap(bitmap);
        } else {
            bitmap2 = null;
        }
        this.extraBitmap = bitmap2;
        return this;
    }

    /* renamed from: setFromVideoId, reason: collision with other method in class */
    public final void m16setFromVideoId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fromVideoId = str;
    }

    public final ShortSeriesLaunchArgs setInternalSource(Long l) {
        if (l != null) {
            this.internalSource = l.longValue();
        }
        return this;
    }

    public final ShortSeriesLaunchArgs setPlayerSubTag(String subTag) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        this.playerSubTag = subTag;
        return this;
    }

    public final ShortSeriesLaunchArgs setTargetUgcId(String targetUgcId) {
        Intrinsics.checkNotNullParameter(targetUgcId, "targetUgcId");
        this.targetUgcId = targetUgcId;
        return this;
    }

    public final ShortSeriesLaunchArgs setTargetVideoId(String targetVid) {
        Intrinsics.checkNotNullParameter(targetVid, "targetVid");
        this.targetVid = targetVid;
        return this;
    }

    public final ShortSeriesLaunchArgs setVidForce(String vid) {
        Intrinsics.checkNotNullParameter(vid, "vid");
        this.vidForce = vid;
        return this;
    }

    public final ShortSeriesLaunchArgs setAlbumDetailSource(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.albumDetailSource = str;
        }
        return this;
    }

    public final ShortSeriesLaunchArgs setSeriesId(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.seriesId = str;
        }
        return this;
    }

    public final ShortSeriesLaunchArgs setSource(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            this.source = str;
        }
        return this;
    }

    public final ShortSeriesLaunchArgs setLaunchAnimId(int i, int i2) {
        this.enterAnimId = i;
        this.preActivityExitAnimId = i2;
        return this;
    }
}
