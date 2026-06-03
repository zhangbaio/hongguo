package com.dragon.read.component.shortvideo.data.saas.video;

import android.text.TextUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.constant.IBaseModelDependApi;
import com.dragon.read.component.shortvideo.data.saas.model.videotag.SaasVideoTagInfo;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaaSVideoBottomBar;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasCategorySchema;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasUrgeUpdateData;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasVideoDirectoryItem;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasVideoHighlight;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import seriessdk.com.dragon.read.saas.rpc.model.Celebrity;
import seriessdk.com.dragon.read.saas.rpc.model.EpisodeLockData;
import seriessdk.com.dragon.read.saas.rpc.model.SaaSVideoDetailStyle;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;
import seriessdk.com.dragon.read.saas.rpc.model.SeriesStatus;
import seriessdk.com.dragon.read.saas.rpc.model.UgcUserInfo;
import seriessdk.com.dragon.read.saas.rpc.model.UseStatus;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPayInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPlatformType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoRecordInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoRelateBook;
import seriessdk.com.dragon.read.saas.rpc.model.VideoShareInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoUpdateInfo;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaasVideoDetailModel implements Serializable, b {
    private List<SecondaryInfo> abstractSecondaryInfoList;
    private long aiUsageType;
    private String backToFirstGuideContent;
    private List<String> bigImages;

    @SerializedName("category_schema")
    private List<SaasCategorySchema> categorySchema;
    private List<Celebrity> celebrityList;
    private long createTime;
    private List<SecondaryInfo> detailRecTagList;
    private EpisodeLockData dirData;
    private List<SaasVideoDirectoryItem> directoryItems;
    private boolean disableInsertAd;
    private long duration;
    private List<SecondaryInfo> endRecommendRecTagList;
    private int episodeCnt;
    private String episodeListBtnText;
    private String episodeListText;
    private int episodeTotalCnt;
    private String episodesCover;
    private String episodesId;
    private String episodesIntroduction;
    private List<SaasVideoData> episodesList;
    private String episodesListCountText;
    private List<SaasVideoData> episodesListWithTrailAfterCut;
    private long episodesPlayCount;
    private SeriesStatus episodesStatus;
    private String episodesTitle;
    private boolean followed;
    private long followedCnt;
    private String fromPlayListId;
    private String fromSrcChannelId;
    private String fromSrcMaterialId;
    private SaasVideoHighlight highlight;
    private List<UgcUserInfo> mainCreates;
    private String mainCreatorUserSchema;
    private boolean onlineSubscribed;
    private long onlineTime;
    private VideoPayInfo payInfo;
    private String playBtnSchema;
    private List<SaasVideoData> playerSerialVideoList;
    private int postDataIndex;
    private List<SecondaryInfo> recTagList;
    private String recommendGroupId;
    private String recommendInfo;
    private long relatedAlbumId;
    private String relatedMaterialId;
    private Serializable rpcData;
    private long seasonIndex;
    private List<SecondaryInfo> secondaryInfoList;
    private String seriesIntro;
    private String smallEpisodesCover;
    private int stickyCreatorCnt;
    private SaaSVideoDetailStyle style;
    private List<SecondaryInfo> subTitleList;
    private List<SaasVideoData> trailerList;
    private String updateTag;
    protected UseStatus useStatus;
    private String videoCategoryType;
    private VideoContentType videoContentType;
    private VideoPlatformType videoPlatformType;
    private VideoRecordInfo videoRecordInfo;
    private VideoRelateBook videoRelateBook;
    private String videoSelectPanelGuideText;
    private VideoShareInfo videoShareInfo;
    private SaasVideoTagInfo videoTagInfo;
    private VideoUpdateInfo videoUpdateInfo;
    private String recommendReasonList = null;
    private Boolean hasShowNextEpisodeAnim = Boolean.FALSE;
    private boolean hasHighlight = false;
    private String highlightSeriesId = "";
    private String highlightVid = "";
    private boolean canShowBackToStartBtn = false;
    private boolean showBackToStartBtnOnce = false;
    private boolean fromPrefetch = false;
    private List<String> seriesSubTitleList = null;
    private List<Serializable> tabTrailerList = null;
    private boolean hasAppendTrailer = false;
    private boolean refreshFromInnerToOuter = false;
    private boolean isSlideToNewRecommendFeed = false;
    private UgcUserInfo ugcUserInfo = null;
    private SaaSVideoBottomBar videoBottomBar = null;
    private SaasVideoDetailModel bindVideoDetail = null;
    private boolean isInEpisodeEndInner = false;
    private boolean canShowDownloadIcon = false;
    private boolean supportListen = false;
    private Map<String, Object> extraDataMap = new HashMap();
    private List<SaasVideoData> episodesListWithTrail = new LinkedList();
    private boolean isLocalList = false;
    private String seriesColorHex = "";
    private boolean isUgcRelated = false;
    private boolean enableVisionProduct = false;
    private int insertAdRitType = 0;
    private boolean showMaterialGuidanceAnim = false;
    private SaasUrgeUpdateData urgeUpdateData = null;

    static {
        Covode.recordClassIndex(599122);
    }

    public List<SecondaryInfo> getAbstractSecondaryInfoList() {
        return this.abstractSecondaryInfoList;
    }

    public long getAiUsageType() {
        return this.aiUsageType;
    }

    public String getBackToFirstGuideContent() {
        return this.backToFirstGuideContent;
    }

    public List<String> getBigImages() {
        return this.bigImages;
    }

    public SaasVideoDetailModel getBindVideoDetail() {
        return this.bindVideoDetail;
    }

    public List<SaasCategorySchema> getCategorySchema() {
        return this.categorySchema;
    }

    public List<Celebrity> getCelebrityList() {
        return this.celebrityList;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public List<SecondaryInfo> getDetailRecTagList() {
        return this.detailRecTagList;
    }

    public EpisodeLockData getDirData() {
        return this.dirData;
    }

    public List<SaasVideoDirectoryItem> getDirectoryItems() {
        return this.directoryItems;
    }

    public long getDuration() {
        return this.duration;
    }

    public List<SecondaryInfo> getEndRecommendRecTagList() {
        return this.endRecommendRecTagList;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public int getEpisodeCnt() {
        return this.episodeCnt;
    }

    public String getEpisodeListBtnText() {
        return this.episodeListBtnText;
    }

    public String getEpisodeListText() {
        return this.episodeListText;
    }

    public int getEpisodeTotalCnt() {
        return this.episodeTotalCnt;
    }

    public String getEpisodesCover() {
        return this.episodesCover;
    }

    public String getEpisodesId() {
        return this.episodesId;
    }

    public String getEpisodesIntroduction() {
        return this.episodesIntroduction;
    }

    public List<SaasVideoData> getEpisodesList() {
        return this.episodesList;
    }

    public String getEpisodesListCountText() {
        return this.episodesListCountText;
    }

    public List<SaasVideoData> getEpisodesListWithTrail() {
        return this.episodesListWithTrail;
    }

    public List<SaasVideoData> getEpisodesListWithTrailAfterCut() {
        return this.episodesListWithTrailAfterCut;
    }

    public long getEpisodesPlayCount() {
        return this.episodesPlayCount;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public SeriesStatus getEpisodesStatus() {
        return this.episodesStatus;
    }

    public String getEpisodesTitle() {
        return this.episodesTitle;
    }

    public Map<String, Object> getExtraData() {
        return this.extraDataMap;
    }

    public long getFollowedCnt() {
        return this.followedCnt;
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

    public boolean getHasAppendTrailer() {
        return this.hasAppendTrailer;
    }

    public Boolean getHasShowNextEpisodeAnim() {
        return this.hasShowNextEpisodeAnim;
    }

    public SaasVideoHighlight getHighlight() {
        return this.highlight;
    }

    public int getInsertAdRitType() {
        return this.insertAdRitType;
    }

    public List<UgcUserInfo> getMainCreates() {
        return this.mainCreates;
    }

    public String getMainCreatorUserSchema() {
        return this.mainCreatorUserSchema;
    }

    public long getOnlineTime() {
        return this.onlineTime;
    }

    public VideoPayInfo getPayInfo() {
        return this.payInfo;
    }

    public String getPlayBtnSchema() {
        return this.playBtnSchema;
    }

    public List<SaasVideoData> getPlayerSerialVideoList() {
        return this.playerSerialVideoList;
    }

    public int getPostDataIndex() {
        return this.postDataIndex;
    }

    public List<SecondaryInfo> getRecTagList() {
        return this.recTagList;
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

    public boolean getRefreshFromInnerToOuter() {
        return this.refreshFromInnerToOuter;
    }

    public long getRelatedAlbumId() {
        return this.relatedAlbumId;
    }

    public String getRelatedMaterialId() {
        return this.relatedMaterialId;
    }

    public Serializable getRpcData() {
        return this.rpcData;
    }

    public long getSeasonIndex() {
        return this.seasonIndex;
    }

    public List<SecondaryInfo> getSecondaryInfoList() {
        return this.secondaryInfoList;
    }

    public String getSeriesIntro() {
        return this.seriesIntro;
    }

    public List<String> getSeriesSubTitleList() {
        return this.seriesSubTitleList;
    }

    public String getSmallEpisodesCover() {
        return this.smallEpisodesCover;
    }

    public int getStickyCreatorCnt() {
        return this.stickyCreatorCnt;
    }

    public SaaSVideoDetailStyle getStyle() {
        return this.style;
    }

    public List<SecondaryInfo> getSubTitleList() {
        return this.subTitleList;
    }

    public List<Serializable> getTabTrailerList() {
        return this.tabTrailerList;
    }

    public List<SaasVideoData> getTrailerList() {
        return this.trailerList;
    }

    public UgcUserInfo getUgcUserInfo() {
        return this.ugcUserInfo;
    }

    public String getUpdateTag() {
        return this.updateTag;
    }

    public SaasUrgeUpdateData getUrgeUpdateData() {
        return this.urgeUpdateData;
    }

    public UseStatus getUseStatus() {
        return this.useStatus;
    }

    public SaaSVideoBottomBar getVideoBottomBar() {
        return this.videoBottomBar;
    }

    public String getVideoCategoryType() {
        return this.videoCategoryType;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public VideoContentType getVideoContentType() {
        return this.videoContentType;
    }

    public VideoPlatformType getVideoPlatformType() {
        return this.videoPlatformType;
    }

    public VideoRecordInfo getVideoRecordInfo() {
        return this.videoRecordInfo;
    }

    public VideoRelateBook getVideoRelateBook() {
        return this.videoRelateBook;
    }

    public String getVideoSelectPanelGuideText() {
        return this.videoSelectPanelGuideText;
    }

    public VideoShareInfo getVideoShareInfo() {
        return this.videoShareInfo;
    }

    public SaasVideoTagInfo getVideoTagInfo() {
        return this.videoTagInfo;
    }

    public VideoUpdateInfo getVideoUpdateInfo() {
        return this.videoUpdateInfo;
    }

    public boolean isCanShowBackToStartBtn() {
        return this.canShowBackToStartBtn;
    }

    public boolean isCanShowDownloadIcon() {
        return this.canShowDownloadIcon;
    }

    public boolean isDisableInsertAd() {
        return this.disableInsertAd;
    }

    public boolean isEnableVisionProduct() {
        return this.enableVisionProduct;
    }

    public boolean isFollowed() {
        return this.followed;
    }

    public boolean isFromPrefetch() {
        return this.fromPrefetch;
    }

    public boolean isHasHighlight() {
        return this.hasHighlight;
    }

    public boolean isInEpisodeEndInner() {
        return this.isInEpisodeEndInner;
    }

    public boolean isLocalList() {
        return this.isLocalList;
    }

    public boolean isOnlineSubscribed() {
        return this.onlineSubscribed;
    }

    public boolean isShowBackToStartBtnOnce() {
        return this.showBackToStartBtnOnce;
    }

    public boolean isShowMaterialGuidanceAnim() {
        return this.showMaterialGuidanceAnim;
    }

    public boolean isSlideToNewRecommendFeed() {
        return this.isSlideToNewRecommendFeed;
    }

    public boolean isSupportListen() {
        return this.supportListen;
    }

    public boolean isUgcRelated() {
        return this.isUgcRelated;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public String recommendGroupId() {
        return this.recommendGroupId;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public String recommendInfo() {
        return this.recommendInfo;
    }

    public void clearEpisodesListWithTrail() {
        getEpisodesListWithTrail().clear();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public String getDetailId() {
        return getEpisodesId();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public String getSeriesCover() {
        return getEpisodesCover();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public String getSeriesTitle() {
        return getEpisodesTitle();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public List<SaasVideoData> getEpisodeList() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(getEpisodesListWithTrail());
        return linkedList;
    }

    public String getHighlightSeriesId() {
        if (TextUtils.isEmpty(this.highlightSeriesId)) {
            return "";
        }
        return this.highlightSeriesId;
    }

    public String getHighlightVid() {
        if (TextUtils.isEmpty(this.highlightVid)) {
            return "";
        }
        return this.highlightVid;
    }

    public String getSeriesColorHex() {
        if (TextUtils.isEmpty(this.seriesColorHex)) {
            return "";
        }
        return this.seriesColorHex;
    }

    public String getUpdateInfo() {
        IBaseModelDependApi a = IBaseModelDependApi.Companion.a();
        if (a != null) {
            return a.getUpdateInfo(this);
        }
        return "";
    }

    public boolean hasTrailer() {
        return !com.dragon.read.util.r0.a(getTrailerList());
    }

    public boolean isFromDouyin() {
        if (getVideoPlatformType() == VideoPlatformType.PlatformDouyin) {
            return true;
        }
        return false;
    }

    public boolean canReserve() {
        VideoContentType videoContentType = getVideoContentType();
        if (videoContentType == null) {
            return false;
        }
        int value = videoContentType.getValue();
        if (value != VideoContentType.UnrealShortPlay.getValue() && value != VideoContentType.UnrealMotionComic.getValue()) {
            return false;
        }
        return true;
    }

    public boolean isRelatedMaterialId() {
        if (!TextUtils.isEmpty(getRelatedMaterialId()) && !isUgcRelated()) {
            return true;
        }
        return false;
    }

    public long calculateDuration() {
        List<SaasVideoData> episodesList = getEpisodesList();
        if (!ListUtils.isEmpty(episodesList)) {
            Iterator<SaasVideoData> it2 = episodesList.iterator();
            long j = 0;
            while (it2.hasNext()) {
                j += it2.next().getDuration();
            }
            return j;
        }
        return getDuration();
    }

    public Set<String> getNewlyUpdateVids() {
        HashSet hashSet = new HashSet();
        for (SaasVideoData saasVideoData : getEpisodesList()) {
            if (saasVideoData.isNewlyUpdate()) {
                hashSet.add(saasVideoData.getVid());
            }
        }
        return hashSet;
    }

    public String toString() {
        try {
            return "SaasVideoDetailModel{ hash = " + hashCode() + ", episodesId='" + getEpisodesId() + "', episodesList.size =" + getEpisodeList().size() + ", followed=" + isFollowed() + ", followedCnt=" + getFollowedCnt() + ", episodesPlayCount=" + this.episodesPlayCount + ", episodeCnt=" + getEpisodeCnt() + ", episodesListCountText='" + this.episodesListCountText + "', episodesTitle='" + getEpisodesTitle() + "', episodesIntroduction='" + this.episodesIntroduction + "', episodesStatus=" + getEpisodesStatus() + ", episodesCover='" + getEpisodesCover() + "', videoPlatformType=" + this.videoPlatformType + ", seriesColorHex='" + getSeriesColorHex() + "', episodesListWithTrail.size='" + getEpisodesListWithTrail().size() + "', categorySchema=" + this.categorySchema + ", extraDataMap=" + this.extraDataMap + '}';
        } catch (Exception unused) {
            return super.toString();
        }
    }

    public void setAbstractSecondaryInfoList(List<SecondaryInfo> list) {
        this.abstractSecondaryInfoList = list;
    }

    public void setAiUsageType(long j) {
        this.aiUsageType = j;
    }

    public void setBackToFirstGuideContent(String str) {
        this.backToFirstGuideContent = str;
    }

    public void setBigImages(List<String> list) {
        this.bigImages = list;
    }

    public void setBindVideoDetail(SaasVideoDetailModel saasVideoDetailModel) {
        this.bindVideoDetail = saasVideoDetailModel;
    }

    public void setCanShowBackToStartBtn(boolean z) {
        this.canShowBackToStartBtn = z;
    }

    public void setCanShowDownloadIcon(boolean z) {
        this.canShowDownloadIcon = z;
    }

    public void setCategorySchema(List<SaasCategorySchema> list) {
        this.categorySchema = list;
    }

    public void setCelebrityList(List<Celebrity> list) {
        this.celebrityList = list;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setDetailRecTagList(List<SecondaryInfo> list) {
        this.detailRecTagList = list;
    }

    public void setDirData(EpisodeLockData episodeLockData) {
        this.dirData = episodeLockData;
    }

    public void setDirectoryItems(List<SaasVideoDirectoryItem> list) {
        this.directoryItems = list;
    }

    public void setDisableInsertAd(boolean z) {
        this.disableInsertAd = z;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setEnableVisionProduct(boolean z) {
        this.enableVisionProduct = z;
    }

    public void setEndRecommendRecTagList(List<SecondaryInfo> list) {
        this.endRecommendRecTagList = list;
    }

    public void setEpisodeCnt(int i) {
        this.episodeCnt = i;
    }

    public void setEpisodeListBtnText(String str) {
        this.episodeListBtnText = str;
    }

    public void setEpisodeListText(String str) {
        this.episodeListText = str;
    }

    public void setEpisodeTotalCnt(int i) {
        this.episodeTotalCnt = i;
    }

    public void setEpisodesCover(String str) {
        this.episodesCover = str;
    }

    public void setEpisodesId(String str) {
        this.episodesId = str;
    }

    public void setEpisodesIntroduction(String str) {
        this.episodesIntroduction = str;
    }

    public void setEpisodesListCountText(String str) {
        this.episodesListCountText = str;
    }

    public void setEpisodesListWithTrailAfterCut(List<SaasVideoData> list) {
        this.episodesListWithTrailAfterCut = list;
    }

    public void setEpisodesPlayCount(long j) {
        this.episodesPlayCount = j;
    }

    public void setEpisodesStatus(SeriesStatus seriesStatus) {
        this.episodesStatus = seriesStatus;
    }

    public void setEpisodesTitle(String str) {
        this.episodesTitle = str;
    }

    public void setFollowed(boolean z) {
        this.followed = z;
    }

    public void setFollowedCnt(long j) {
        this.followedCnt = j;
    }

    public void setFromPlayListId(String str) {
        this.fromPlayListId = str;
    }

    public void setFromPrefetch(boolean z) {
        this.fromPrefetch = z;
    }

    public void setFromSrcChannelId(String str) {
        this.fromSrcChannelId = str;
    }

    public void setFromSrcMaterialId(String str) {
        this.fromSrcMaterialId = str;
    }

    public void setHasAppendTrailer(boolean z) {
        this.hasAppendTrailer = z;
    }

    public void setHasHighlight(boolean z) {
        this.hasHighlight = z;
    }

    public void setHasShowNextEpisodeAnim(Boolean bool) {
        this.hasShowNextEpisodeAnim = bool;
    }

    public void setHighlight(SaasVideoHighlight saasVideoHighlight) {
        this.highlight = saasVideoHighlight;
    }

    public void setHighlightSeriesId(String str) {
        this.highlightSeriesId = str;
    }

    public void setHighlightVid(String str) {
        this.highlightVid = str;
    }

    public void setInEpisodeEndInner(boolean z) {
        this.isInEpisodeEndInner = z;
    }

    public void setInsertAdRitType(int i) {
        this.insertAdRitType = i;
    }

    public void setLocalList(boolean z) {
        this.isLocalList = z;
    }

    public void setMainCreates(List<UgcUserInfo> list) {
        this.mainCreates = list;
    }

    public void setMainCreatorUserSchema(String str) {
        this.mainCreatorUserSchema = str;
    }

    public void setOnlineSubscribed(boolean z) {
        this.onlineSubscribed = z;
    }

    public void setOnlineTime(long j) {
        this.onlineTime = j;
    }

    public void setPayInfo(VideoPayInfo videoPayInfo) {
        this.payInfo = videoPayInfo;
    }

    public void setPlayBtnSchema(String str) {
        this.playBtnSchema = str;
    }

    public void setPlayerSerialVideoList(List<SaasVideoData> list) {
        this.playerSerialVideoList = list;
    }

    public void setPostDataIndex(int i) {
        this.postDataIndex = i;
    }

    public void setRecTagList(List<SecondaryInfo> list) {
        this.recTagList = list;
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

    public void setRefreshFromInnerToOuter(boolean z) {
        this.refreshFromInnerToOuter = z;
    }

    public void setRelatedAlbumId(long j) {
        this.relatedAlbumId = j;
    }

    public void setRelatedMaterialId(String str) {
        this.relatedMaterialId = str;
    }

    public void setRpcData(Serializable serializable) {
        this.rpcData = serializable;
    }

    public void setSeasonIndex(long j) {
        this.seasonIndex = j;
    }

    public void setSecondaryInfoList(List<SecondaryInfo> list) {
        this.secondaryInfoList = list;
    }

    public void setSeriesColorHex(String str) {
        this.seriesColorHex = str;
    }

    public void setSeriesIntro(String str) {
        this.seriesIntro = str;
    }

    public void setSeriesSubTitleList(List<String> list) {
        this.seriesSubTitleList = list;
    }

    public void setShowBackToStartBtnOnce(boolean z) {
        this.showBackToStartBtnOnce = z;
    }

    public void setShowMaterialGuidanceAnim(boolean z) {
        this.showMaterialGuidanceAnim = z;
    }

    public void setSlideToNewRecommendFeed(boolean z) {
        this.isSlideToNewRecommendFeed = z;
    }

    public void setSmallEpisodesCover(String str) {
        this.smallEpisodesCover = str;
    }

    public void setStickyCreatorCnt(int i) {
        this.stickyCreatorCnt = i;
    }

    public void setStyle(SaaSVideoDetailStyle saaSVideoDetailStyle) {
        this.style = saaSVideoDetailStyle;
    }

    public void setSubTitleList(List<SecondaryInfo> list) {
        this.subTitleList = list;
    }

    public void setSupportListen(boolean z) {
        this.supportListen = z;
    }

    public void setTabTrailerList(List<Serializable> list) {
        this.tabTrailerList = list;
    }

    public void setUgcRelated(boolean z) {
        this.isUgcRelated = z;
    }

    public void setUgcUserInfo(UgcUserInfo ugcUserInfo) {
        this.ugcUserInfo = ugcUserInfo;
    }

    public void setUpdateTag(String str) {
        this.updateTag = str;
    }

    public void setUrgeUpdateData(SaasUrgeUpdateData saasUrgeUpdateData) {
        this.urgeUpdateData = saasUrgeUpdateData;
    }

    public void setUseStatus(UseStatus useStatus) {
        this.useStatus = useStatus;
    }

    public void setVideoBottomBar(SaaSVideoBottomBar saaSVideoBottomBar) {
        this.videoBottomBar = saaSVideoBottomBar;
    }

    public void setVideoCategoryType(String str) {
        this.videoCategoryType = str;
    }

    public void setVideoContentType(VideoContentType videoContentType) {
        this.videoContentType = videoContentType;
    }

    public void setVideoPlatformType(VideoPlatformType videoPlatformType) {
        this.videoPlatformType = videoPlatformType;
    }

    public void setVideoRecordInfo(VideoRecordInfo videoRecordInfo) {
        this.videoRecordInfo = videoRecordInfo;
    }

    public void setVideoRelateBook(VideoRelateBook videoRelateBook) {
        this.videoRelateBook = videoRelateBook;
    }

    public void setVideoSelectPanelGuideText(String str) {
        this.videoSelectPanelGuideText = str;
    }

    public void setVideoShareInfo(VideoShareInfo videoShareInfo) {
        this.videoShareInfo = videoShareInfo;
    }

    public void setVideoTagInfo(SaasVideoTagInfo saasVideoTagInfo) {
        this.videoTagInfo = saasVideoTagInfo;
    }

    public void setVideoUpdateInfo(VideoUpdateInfo videoUpdateInfo) {
        this.videoUpdateInfo = videoUpdateInfo;
    }

    public void setEpisodesList(List<SaasVideoData> list) {
        this.episodesList = list;
        this.episodesListWithTrail.addAll(list);
    }

    public void setEpisodesListWithTrail(List<SaasVideoData> list) {
        if (list == null) {
            this.episodesListWithTrail.clear();
        } else {
            this.episodesListWithTrail.addAll(list);
        }
    }

    public void setTrailerList(List<SaasVideoData> list) {
        this.trailerList = list;
        this.episodesListWithTrail.addAll(0, list);
    }

    public void putExtraData(String str, Object obj) {
        this.extraDataMap.put(str, obj);
    }

    public void setUrgeUpdateData(boolean z, boolean z2, long j) {
        SaasUrgeUpdateData urgeUpdateData = getUrgeUpdateData();
        if (urgeUpdateData == null) {
            urgeUpdateData = new SaasUrgeUpdateData(z, z2, j);
        } else {
            urgeUpdateData.setShowUrgeButton(z);
            urgeUpdateData.setUserUrged(z2);
            urgeUpdateData.setTotalCnt(j);
        }
        setUrgeUpdateData(urgeUpdateData);
    }
}
