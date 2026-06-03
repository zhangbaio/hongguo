package com.dragon.read.component.shortvideo.data.saas.video;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaaSVideoBottomBar;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasCategorySchema;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasClipVideoHighlight;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasLongPressAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import seriessdk.com.dragon.read.saas.rpc.model.DisclaimerInfo;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoDetailInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPayInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPlatformType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoSeriesIdType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaasVideoData implements Serializable {
    private List<SecondaryInfo> abstractSecondaryInfoList;
    private String backToFirstGuideContent;
    private int backToFirstGuideShowTime;
    private String bgColorHex;
    private SaaSVideoBottomBar bottomBar;

    @SerializedName("category_schema")
    public List<SaasCategorySchema> categorySchema;
    private List<SaasClipVideoHighlight> clipVideoHighlightList;
    private long commentCount;
    private VideoContentType contentType;
    private String cover;
    private long diggCount;
    private boolean disablePlay;
    private DisclaimerInfo disclaimerInfo;
    private long duration;
    private boolean enableVisionProduct;
    private String episodeCover;
    private long episodesCount;
    private String episodesId;
    private Map<String, Object> extra;
    private boolean followed;
    private String fromPlayListId;
    private String fromSrcChannelId;
    private String fromSrcMaterialId;
    private boolean hasDigg;
    private boolean hasNextVideoChapter;
    private boolean hasPreviewVideo;
    private String highlightVid;
    private String hotCommentId;
    private String hotCommentServerRecommendInfo;
    private int indexInList;
    private boolean isInsertedFromFeed;
    private boolean isNewlyUpdate;
    private boolean isPrivate;
    private boolean isShown;
    private boolean isSlideToNewRecommendFeed;
    private boolean isSubscribed;
    private Boolean isTrailer;
    private Boolean isVideoDetailModelVertical;
    private LocalFileSourceInfo localFileSourceInfo;
    private SaasLongPressAction longPressAction;
    private VideoPayInfo payInfo;
    private long playCnt;
    private int playStatus;
    private String postId;
    private int recTextIconType;
    private String recommendGroupId;
    private String recommendInfo;
    private String recommendReasonList;
    private String recommendText;
    private long seasonIndex;
    private List<SecondaryInfo> secondaryInfoList;
    private long segmentId;
    private String seriesColorHex;
    private String seriesName;
    private Boolean showBackToFirstGuide;
    private boolean showPlayCnt;
    private boolean showRecommendText;
    private String subTitle;
    private List<SecondaryInfo> subTitleList;
    private boolean supportListen;
    private Serializable tagInfo;
    private String title;
    private long trialDuration;
    private String updateTag;
    private boolean useHighlightSegment;
    private boolean vertical;
    private String vid;
    private long vidIndex;
    private String videoCategoryType;
    private String videoDesc;
    private VideoDetailInfo videoDetailData;
    private VideoPlatformType videoPlatform;
    private VideoSeriesIdType videoSeriesIdType;
    private String seriesId = "";
    private boolean isRelatedMaterialId = false;
    private long forceStartTime = -1;

    static {
        Covode.recordClassIndex(599119);
    }

    public String getVideoModel() {
        return null;
    }

    public List<SecondaryInfo> getAbstractSecondaryInfoList() {
        return this.abstractSecondaryInfoList;
    }

    public String getBackToFirstGuideContent() {
        return this.backToFirstGuideContent;
    }

    public int getBackToFirstGuideShowTime() {
        return this.backToFirstGuideShowTime;
    }

    public String getBgColorHex() {
        return this.bgColorHex;
    }

    public SaaSVideoBottomBar getBottomBar() {
        return this.bottomBar;
    }

    public List<SaasCategorySchema> getCategorySchema() {
        return this.categorySchema;
    }

    public List<SaasClipVideoHighlight> getClipVideoHighlightList() {
        return this.clipVideoHighlightList;
    }

    public long getCommentCount() {
        return this.commentCount;
    }

    public VideoContentType getContentType() {
        return this.contentType;
    }

    public String getCover() {
        return this.cover;
    }

    public long getDiggCount() {
        return this.diggCount;
    }

    public DisclaimerInfo getDisclaimerInfo() {
        return this.disclaimerInfo;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getEpisodeCover() {
        return this.episodeCover;
    }

    public long getEpisodesCount() {
        return this.episodesCount;
    }

    public String getEpisodesId() {
        return this.episodesId;
    }

    public Map<String, Object> getExtraData() {
        return this.extra;
    }

    public long getForceStartTime() {
        return this.forceStartTime;
    }

    public String getFromPlayListId() {
        return this.fromPlayListId;
    }

    public String getFromSrcChannelId() {
        return this.fromSrcChannelId;
    }

    public String getFromSrcMaterialId() {
        return this.fromSrcMaterialId;
    }

    public String getHighlightVid() {
        return this.highlightVid;
    }

    public String getHotCommentId() {
        return this.hotCommentId;
    }

    public String getHotCommentServerRecommendInfo() {
        return this.hotCommentServerRecommendInfo;
    }

    public int getIndexInList() {
        return this.indexInList;
    }

    public LocalFileSourceInfo getLocalFileSourceInfo() {
        return this.localFileSourceInfo;
    }

    public SaasLongPressAction getLongPressAction() {
        return this.longPressAction;
    }

    public VideoPayInfo getPayInfo() {
        return this.payInfo;
    }

    public long getPlayCnt() {
        return this.playCnt;
    }

    public int getPlayStatus() {
        return this.playStatus;
    }

    public String getPostId() {
        return this.postId;
    }

    public int getRecTextIconType() {
        return this.recTextIconType;
    }

    public String getRecommendGroupId() {
        return this.recommendGroupId;
    }

    public String getRecommendInfo() {
        return this.recommendInfo;
    }

    public String getRecommendReasonList() {
        return this.recommendReasonList;
    }

    public String getRecommendText() {
        return this.recommendText;
    }

    public long getSeasonIndex() {
        return this.seasonIndex;
    }

    public List<SecondaryInfo> getSecondaryInfoList() {
        return this.secondaryInfoList;
    }

    public long getSegmentId() {
        return this.segmentId;
    }

    public String getSeriesColorHex() {
        return this.seriesColorHex;
    }

    public String getSeriesId() {
        return this.seriesId;
    }

    public String getSeriesName() {
        return this.seriesName;
    }

    public Boolean getShowBackToFirstGuide() {
        return this.showBackToFirstGuide;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public List<SecondaryInfo> getSubTitleList() {
        return this.subTitleList;
    }

    public Serializable getTagInfo() {
        return this.tagInfo;
    }

    public String getTitle() {
        return this.title;
    }

    public Boolean getTrailer() {
        return this.isTrailer;
    }

    public long getTrialDuration() {
        return this.trialDuration;
    }

    public String getUpdateTag() {
        return this.updateTag;
    }

    public String getVid() {
        return this.vid;
    }

    public long getVidIndex() {
        return this.vidIndex;
    }

    public String getVideoCategoryType() {
        return this.videoCategoryType;
    }

    public String getVideoDesc() {
        return this.videoDesc;
    }

    public VideoDetailInfo getVideoDetailData() {
        return this.videoDetailData;
    }

    public Boolean getVideoDetailModelVertical() {
        return this.isVideoDetailModelVertical;
    }

    public VideoPlatformType getVideoPlatform() {
        return this.videoPlatform;
    }

    public VideoSeriesIdType getVideoSeriesIdType() {
        return this.videoSeriesIdType;
    }

    public boolean isDisablePlay() {
        return this.disablePlay;
    }

    public boolean isEnableVisionProduct() {
        return this.enableVisionProduct;
    }

    public boolean isFollowed() {
        return this.followed;
    }

    public boolean isHasDigg() {
        return this.hasDigg;
    }

    public boolean isHasNextVideoChapter() {
        return this.hasNextVideoChapter;
    }

    public boolean isHasPreviewVideo() {
        return this.hasPreviewVideo;
    }

    public boolean isInsertedFromFeed() {
        return this.isInsertedFromFeed;
    }

    public boolean isNewlyUpdate() {
        return this.isNewlyUpdate;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isRelatedMaterialId() {
        return this.isRelatedMaterialId;
    }

    public boolean isShowPlayCnt() {
        return this.showPlayCnt;
    }

    public boolean isShowRecommendText() {
        return this.showRecommendText;
    }

    public boolean isShown() {
        return this.isShown;
    }

    public boolean isSlideToNewRecommendFeed() {
        return this.isSlideToNewRecommendFeed;
    }

    public boolean isSubscribed() {
        return this.isSubscribed;
    }

    public boolean isSupportListen() {
        return this.supportListen;
    }

    public boolean isUseHighlightSegment() {
        return this.useHighlightSegment;
    }

    public boolean isVertical() {
        return this.vertical;
    }

    public boolean isPlaying() {
        if (this.playStatus == 1) {
            return true;
        }
        return false;
    }

    public boolean isFromDouyin() {
        if (this.videoPlatform == VideoPlatformType.PlatformDouyin) {
            return true;
        }
        return false;
    }

    public boolean isPause() {
        if (this.playStatus == 2) {
            return true;
        }
        return false;
    }

    public boolean isTargetVideo() {
        int i = this.playStatus;
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    public SaasVideoData() {
        Boolean bool = Boolean.FALSE;
        this.showBackToFirstGuide = bool;
        this.backToFirstGuideShowTime = 0;
        this.tagInfo = null;
        this.isTrailer = bool;
        this.isVideoDetailModelVertical = Boolean.TRUE;
        this.recTextIconType = 0;
        this.videoSeriesIdType = VideoSeriesIdType.VideoId;
        this.isSlideToNewRecommendFeed = false;
        this.isSubscribed = true;
        this.hasPreviewVideo = false;
        this.isNewlyUpdate = false;
        this.seasonIndex = 0L;
        this.extra = new HashMap();
    }

    public String toString() {
        return "SaasVideoData{hash = " + hashCode() + ", vid='" + this.vid + "', seriesId='" + this.seriesId + "'}";
    }

    public void setAbstractSecondaryInfoList(List<SecondaryInfo> list) {
        this.abstractSecondaryInfoList = list;
    }

    public void setBackToFirstGuideContent(String str) {
        this.backToFirstGuideContent = str;
    }

    public void setBackToFirstGuideShowTime(int i) {
        this.backToFirstGuideShowTime = i;
    }

    public void setBgColorHex(String str) {
        this.bgColorHex = str;
    }

    public void setBottomBar(SaaSVideoBottomBar saaSVideoBottomBar) {
        this.bottomBar = saaSVideoBottomBar;
    }

    public void setCategorySchema(List<SaasCategorySchema> list) {
        this.categorySchema = list;
    }

    public void setClipVideoHighlightList(List<SaasClipVideoHighlight> list) {
        this.clipVideoHighlightList = list;
    }

    public void setCommentCount(long j) {
        this.commentCount = j;
    }

    public void setContentType(VideoContentType videoContentType) {
        this.contentType = videoContentType;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setDiggCount(long j) {
        this.diggCount = j;
    }

    public void setDisablePlay(boolean z) {
        this.disablePlay = z;
    }

    public void setDisclaimerInfo(DisclaimerInfo disclaimerInfo) {
        this.disclaimerInfo = disclaimerInfo;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setEnableVisionProduct(boolean z) {
        this.enableVisionProduct = z;
    }

    public void setEpisodeCover(String str) {
        this.episodeCover = str;
    }

    public void setEpisodesCount(long j) {
        this.episodesCount = j;
    }

    public void setEpisodesId(String str) {
        this.episodesId = str;
    }

    public void setFollowed(boolean z) {
        this.followed = z;
    }

    public void setForceStartTime(long j) {
        this.forceStartTime = j;
    }

    public void setFromPlayListId(String str) {
        this.fromPlayListId = str;
    }

    public void setFromSrcChannelId(String str) {
        this.fromSrcChannelId = str;
    }

    public void setFromSrcMaterialId(String str) {
        this.fromSrcMaterialId = str;
    }

    public void setHasDigg(boolean z) {
        this.hasDigg = z;
    }

    public void setHasNextVideoChapter(boolean z) {
        this.hasNextVideoChapter = z;
    }

    public void setHasPreviewVideo(boolean z) {
        this.hasPreviewVideo = z;
    }

    public void setHighlightVid(String str) {
        this.highlightVid = str;
    }

    public void setHotCommentId(String str) {
        this.hotCommentId = str;
    }

    public void setHotCommentServerRecommendInfo(String str) {
        this.hotCommentServerRecommendInfo = str;
    }

    public void setIndexInList(int i) {
        this.indexInList = i;
    }

    public void setInsertedFromFeed(boolean z) {
        this.isInsertedFromFeed = z;
    }

    public void setLocalFileSourceInfo(LocalFileSourceInfo localFileSourceInfo) {
        this.localFileSourceInfo = localFileSourceInfo;
    }

    public void setLongPressAction(SaasLongPressAction saasLongPressAction) {
        this.longPressAction = saasLongPressAction;
    }

    public void setNewlyUpdate(boolean z) {
        this.isNewlyUpdate = z;
    }

    public void setPayInfo(VideoPayInfo videoPayInfo) {
        this.payInfo = videoPayInfo;
    }

    public void setPlayCnt(long j) {
        this.playCnt = j;
    }

    public void setPlayStatus(int i) {
        this.playStatus = i;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public void setPrivate(boolean z) {
        this.isPrivate = z;
    }

    public void setRecTextIconType(int i) {
        this.recTextIconType = i;
    }

    public void setRecommendGroupId(String str) {
        this.recommendGroupId = str;
    }

    public void setRecommendInfo(String str) {
        this.recommendInfo = str;
    }

    public void setRecommendReasonList(String str) {
        this.recommendReasonList = str;
    }

    public void setRecommendText(String str) {
        this.recommendText = str;
    }

    public void setSeasonIndex(long j) {
        this.seasonIndex = j;
    }

    public void setSecondaryInfoList(List<SecondaryInfo> list) {
        this.secondaryInfoList = list;
    }

    public void setSegmentId(long j) {
        this.segmentId = j;
    }

    public void setSeriesColorHex(String str) {
        this.seriesColorHex = str;
    }

    public void setSeriesId(String str) {
        this.seriesId = str;
    }

    public void setSeriesName(String str) {
        this.seriesName = str;
    }

    public void setShowBackToFirstGuide(Boolean bool) {
        this.showBackToFirstGuide = bool;
    }

    public void setShowPlayCnt(boolean z) {
        this.showPlayCnt = z;
    }

    public void setShowRecommendText(boolean z) {
        this.showRecommendText = z;
    }

    public void setShown(boolean z) {
        this.isShown = z;
    }

    public void setSlideToNewRecommendFeed(boolean z) {
        this.isSlideToNewRecommendFeed = z;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setSubTitleList(List<SecondaryInfo> list) {
        this.subTitleList = list;
    }

    public void setSubscribed(boolean z) {
        this.isSubscribed = z;
    }

    public void setSupportListen(boolean z) {
        this.supportListen = z;
    }

    public void setTagInfo(Serializable serializable) {
        this.tagInfo = serializable;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTrailer(Boolean bool) {
        this.isTrailer = bool;
    }

    public void setTrialDuration(long j) {
        this.trialDuration = j;
    }

    public void setUpdateTag(String str) {
        this.updateTag = str;
    }

    public void setUseHighlightSegment(boolean z) {
        this.useHighlightSegment = z;
    }

    public void setVertical(boolean z) {
        this.vertical = z;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public void setVidIndex(long j) {
        this.vidIndex = j;
    }

    public void setVideoCategoryType(String str) {
        this.videoCategoryType = str;
    }

    public void setVideoDesc(String str) {
        this.videoDesc = str;
    }

    public void setVideoDetailData(VideoDetailInfo videoDetailInfo) {
        this.videoDetailData = videoDetailInfo;
    }

    public void setVideoDetailModelVertical(Boolean bool) {
        this.isVideoDetailModelVertical = bool;
    }

    public void setVideoPlatform(VideoPlatformType videoPlatformType) {
        this.videoPlatform = videoPlatformType;
    }

    public void setVideoSeriesIdType(VideoSeriesIdType videoSeriesIdType) {
        this.videoSeriesIdType = videoSeriesIdType;
    }

    public void setIsRelatedMaterialId(boolean z) {
        VideoSeriesIdType videoSeriesIdType;
        this.isRelatedMaterialId = z;
        if (z) {
            videoSeriesIdType = VideoSeriesIdType.SeriesId;
        } else {
            videoSeriesIdType = VideoSeriesIdType.VideoId;
        }
        this.videoSeriesIdType = videoSeriesIdType;
    }
}
