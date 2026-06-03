package com.dragon.read.component.shortvideo.data.saas.video;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.model.videotag.SaasVideoTagInfo;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaaSVideoBottomBar;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasCategorySchema;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasUrgeUpdateData;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasVideoDirectoryItem;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasVideoHighlight;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
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
public final class SaasModelWrapperBySelf extends SaasVideoDetailModelWrapper {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final f _abstractSecondaryInfoList$delegate;
    private final f _bigImages$delegate;
    private final f _bindVideoDetail$delegate;
    private final h _canShowBackToStartBtn$delegate;
    private final h _canShowDownloadIcon$delegate;
    private final f _categorySchema$delegate;
    private final f _celebrityList$delegate;
    private final f _detailRecTagList$delegate;
    private final f _dirData$delegate;
    private final f _directoryItems$delegate;
    private final h _disableInsertAd$delegate;
    private final h _duration$delegate;
    private final h _enableVisionProduct$delegate;
    private final h _episodeCnt$delegate;
    private final f _episodeListBtnText$delegate;
    private final f _episodeListText$delegate;
    private final h _episodeTotalCnt$delegate;
    private final f _episodesCover$delegate;
    private final f _episodesId$delegate;
    private final f _episodesIntroduction$delegate;
    private final f _episodesList$delegate;
    private final f _episodesListCountText$delegate;
    private final h _episodesListWithTrail$delegate;
    private final f _episodesListWithTrailAfterCut$delegate;
    private final h _episodesPlayCount$delegate;
    private final f _episodesStatus$delegate;
    private final f _episodesTitle$delegate;
    private final h _followed$delegate;
    private final h _followedCnt$delegate;
    private final f _fromPlayListId$delegate;
    private final h _fromPrefetch$delegate;
    private final f _fromSrcChannelId$delegate;
    private final f _fromSrcMaterialId$delegate;
    private final h _hasAppendTrailer$delegate;
    private final h _hasHighlight$delegate;
    private final f _hasShowNextEpisodeAnim$delegate;
    private final f _highlight$delegate;
    private final h _highlightSeriesId$delegate;
    private final h _highlightVid$delegate;
    private final h _inEpisodeEndInner$delegate;
    private final h _insertAdRitType$delegate;
    private final h _localList$delegate;
    private final f _mainCreates$delegate;
    private final h _onlineSubscribed$delegate;
    private final h _onlineTime$delegate;
    private final f _payInfo$delegate;
    private final f _playerSerialVideoList$delegate;
    private final h _postDataIndex$delegate;
    private final f _recTagList$delegate;
    private final f _recommendGroupId$delegate;
    private final f _recommendInfo$delegate;
    private final h _refreshFromInnerToOuter$delegate;
    private final h _relatedAlbumId$delegate;
    private final f _relatedMaterialId$delegate;
    private final f _rpcData$delegate;
    private final f _secondaryInfoList$delegate;
    private final h _seriesColorHex$delegate;
    private final f _seriesIntro$delegate;
    private final f _seriesSubTitleList$delegate;
    private final h _showBackToStartBtnOnce$delegate;
    private final h _showMaterialGuidanceAnim$delegate;
    private final h _slideToNewRecommendFeed$delegate;
    private final f _smallEpisodesCover$delegate;
    private final f _style$delegate;
    private final f _subTitleList$delegate;
    private final h _supportListen$delegate;
    private final f _tabTrailerList$delegate;
    private final f _trailerList$delegate;
    private final h _ugcRelated$delegate;
    private final f _ugcUserInfo$delegate;
    private final f _updateTag$delegate;
    private final f _urgeUpdateData$delegate;
    private final f _useStatus$delegate;
    private final f _videoBottomBar$delegate;
    private final f _videoContentType$delegate;
    private final f _videoPlatformType$delegate;
    private final f _videoRecordInfo$delegate;
    private final f _videoRelateBook$delegate;
    private final f _videoSelectPanelGuideText$delegate;
    private final f _videoShareInfo$delegate;
    private final f _videoTagInfo$delegate;
    private final f _videoUpdateInfo$delegate;

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SecondaryInfo> get_abstractSecondaryInfoList() {
        return (List) this._abstractSecondaryInfoList$delegate.d(this, $$delegatedProperties[1]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<String> get_bigImages() {
        return (List) this._bigImages$delegate.d(this, $$delegatedProperties[75]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SaasVideoDetailModel get_bindVideoDetail() {
        return (SaasVideoDetailModel) this._bindVideoDetail$delegate.d(this, $$delegatedProperties[67]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SaasCategorySchema> get_categorySchema() {
        return (List) this._categorySchema$delegate.d(this, $$delegatedProperties[30]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<Celebrity> get_celebrityList() {
        return (List) this._celebrityList$delegate.d(this, $$delegatedProperties[52]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SecondaryInfo> get_detailRecTagList() {
        return (List) this._detailRecTagList$delegate.d(this, $$delegatedProperties[74]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected EpisodeLockData get_dirData() {
        return (EpisodeLockData) this._dirData$delegate.d(this, $$delegatedProperties[31]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SaasVideoDirectoryItem> get_directoryItems() {
        return (List) this._directoryItems$delegate.d(this, $$delegatedProperties[32]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodeListBtnText() {
        return (String) this._episodeListBtnText$delegate.d(this, $$delegatedProperties[55]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodeListText() {
        return (String) this._episodeListText$delegate.d(this, $$delegatedProperties[54]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodesCover() {
        return (String) this._episodesCover$delegate.d(this, $$delegatedProperties[18]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodesId() {
        return (String) this._episodesId$delegate.d(this, $$delegatedProperties[9]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodesIntroduction() {
        return (String) this._episodesIntroduction$delegate.d(this, $$delegatedProperties[28]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SaasVideoData> get_episodesList() {
        return (List) this._episodesList$delegate.d(this, $$delegatedProperties[13]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodesListCountText() {
        return (String) this._episodesListCountText$delegate.d(this, $$delegatedProperties[27]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SaasVideoData> get_episodesListWithTrail() {
        return (List) this._episodesListWithTrail$delegate.d(this, $$delegatedProperties[16]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SaasVideoData> get_episodesListWithTrailAfterCut() {
        return (List) this._episodesListWithTrailAfterCut$delegate.d(this, $$delegatedProperties[24]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SeriesStatus get_episodesStatus() {
        return (SeriesStatus) this._episodesStatus$delegate.d(this, $$delegatedProperties[7]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodesTitle() {
        return (String) this._episodesTitle$delegate.d(this, $$delegatedProperties[6]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_fromPlayListId() {
        return (String) this._fromPlayListId$delegate.d(this, $$delegatedProperties[38]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_fromSrcChannelId() {
        return (String) this._fromSrcChannelId$delegate.d(this, $$delegatedProperties[39]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_fromSrcMaterialId() {
        return (String) this._fromSrcMaterialId$delegate.d(this, $$delegatedProperties[37]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected Boolean get_hasShowNextEpisodeAnim() {
        return (Boolean) this._hasShowNextEpisodeAnim$delegate.d(this, $$delegatedProperties[40]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SaasVideoHighlight get_highlight() {
        return (SaasVideoHighlight) this._highlight$delegate.d(this, $$delegatedProperties[33]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_highlightSeriesId() {
        return (String) this._highlightSeriesId$delegate.d(this, $$delegatedProperties[43]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_highlightVid() {
        return (String) this._highlightVid$delegate.d(this, $$delegatedProperties[44]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<UgcUserInfo> get_mainCreates() {
        return (List) this._mainCreates$delegate.d(this, $$delegatedProperties[76]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoPayInfo get_payInfo() {
        return (VideoPayInfo) this._payInfo$delegate.d(this, $$delegatedProperties[41]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SaasVideoData> get_playerSerialVideoList() {
        return (List) this._playerSerialVideoList$delegate.d(this, $$delegatedProperties[72]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SecondaryInfo> get_recTagList() {
        return (List) this._recTagList$delegate.d(this, $$delegatedProperties[73]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_recommendGroupId() {
        return (String) this._recommendGroupId$delegate.d(this, $$delegatedProperties[36]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_recommendInfo() {
        return (String) this._recommendInfo$delegate.d(this, $$delegatedProperties[35]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_relatedMaterialId() {
        return (String) this._relatedMaterialId$delegate.d(this, $$delegatedProperties[3]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected Serializable get_rpcData() {
        return (Serializable) this._rpcData$delegate.d(this, $$delegatedProperties[81]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SecondaryInfo> get_secondaryInfoList() {
        return (List) this._secondaryInfoList$delegate.d(this, $$delegatedProperties[0]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_seriesColorHex() {
        return (String) this._seriesColorHex$delegate.d(this, $$delegatedProperties[15]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_seriesIntro() {
        return (String) this._seriesIntro$delegate.d(this, $$delegatedProperties[25]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<String> get_seriesSubTitleList() {
        return (List) this._seriesSubTitleList$delegate.d(this, $$delegatedProperties[53]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_smallEpisodesCover() {
        return (String) this._smallEpisodesCover$delegate.d(this, $$delegatedProperties[19]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SaaSVideoDetailStyle get_style() {
        return (SaaSVideoDetailStyle) this._style$delegate.d(this, $$delegatedProperties[77]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SecondaryInfo> get_subTitleList() {
        return (List) this._subTitleList$delegate.d(this, $$delegatedProperties[79]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<Serializable> get_tabTrailerList() {
        return (List) this._tabTrailerList$delegate.d(this, $$delegatedProperties[56]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SaasVideoData> get_trailerList() {
        return (List) this._trailerList$delegate.d(this, $$delegatedProperties[14]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected UgcUserInfo get_ugcUserInfo() {
        return (UgcUserInfo) this._ugcUserInfo$delegate.d(this, $$delegatedProperties[64]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_updateTag() {
        return (String) this._updateTag$delegate.d(this, $$delegatedProperties[17]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SaasUrgeUpdateData get_urgeUpdateData() {
        return (SaasUrgeUpdateData) this._urgeUpdateData$delegate.d(this, $$delegatedProperties[78]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected UseStatus get_useStatus() {
        return (UseStatus) this._useStatus$delegate.d(this, $$delegatedProperties[59]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SaaSVideoBottomBar get_videoBottomBar() {
        return (SaaSVideoBottomBar) this._videoBottomBar$delegate.d(this, $$delegatedProperties[65]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoContentType get_videoContentType() {
        return (VideoContentType) this._videoContentType$delegate.d(this, $$delegatedProperties[4]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoPlatformType get_videoPlatformType() {
        return (VideoPlatformType) this._videoPlatformType$delegate.d(this, $$delegatedProperties[29]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoRecordInfo get_videoRecordInfo() {
        return (VideoRecordInfo) this._videoRecordInfo$delegate.d(this, $$delegatedProperties[20]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoRelateBook get_videoRelateBook() {
        return (VideoRelateBook) this._videoRelateBook$delegate.d(this, $$delegatedProperties[70]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_videoSelectPanelGuideText() {
        return (String) this._videoSelectPanelGuideText$delegate.d(this, $$delegatedProperties[50]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoShareInfo get_videoShareInfo() {
        return (VideoShareInfo) this._videoShareInfo$delegate.d(this, $$delegatedProperties[51]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SaasVideoTagInfo get_videoTagInfo() {
        return (SaasVideoTagInfo) this._videoTagInfo$delegate.d(this, $$delegatedProperties[63]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoUpdateInfo get_videoUpdateInfo() {
        return (VideoUpdateInfo) this._videoUpdateInfo$delegate.d(this, $$delegatedProperties[48]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_canShowBackToStartBtn() {
        return ((Boolean) this._canShowBackToStartBtn$delegate.d(this, $$delegatedProperties[45])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_canShowDownloadIcon() {
        return ((Boolean) this._canShowDownloadIcon$delegate.d(this, $$delegatedProperties[71])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_disableInsertAd() {
        return ((Boolean) this._disableInsertAd$delegate.d(this, $$delegatedProperties[34])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected long get_duration() {
        return ((Number) this._duration$delegate.d(this, $$delegatedProperties[5])).longValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_enableVisionProduct() {
        return ((Boolean) this._enableVisionProduct$delegate.d(this, $$delegatedProperties[22])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected int get_episodeCnt() {
        return ((Number) this._episodeCnt$delegate.d(this, $$delegatedProperties[8])).intValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected int get_episodeTotalCnt() {
        return ((Number) this._episodeTotalCnt$delegate.d(this, $$delegatedProperties[49])).intValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected long get_episodesPlayCount() {
        return ((Number) this._episodesPlayCount$delegate.d(this, $$delegatedProperties[26])).longValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_followed() {
        return ((Boolean) this._followed$delegate.d(this, $$delegatedProperties[10])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected long get_followedCnt() {
        return ((Number) this._followedCnt$delegate.d(this, $$delegatedProperties[11])).longValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_fromPrefetch() {
        return ((Boolean) this._fromPrefetch$delegate.d(this, $$delegatedProperties[47])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_hasAppendTrailer() {
        return ((Boolean) this._hasAppendTrailer$delegate.d(this, $$delegatedProperties[57])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_hasHighlight() {
        return ((Boolean) this._hasHighlight$delegate.d(this, $$delegatedProperties[42])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_inEpisodeEndInner() {
        return ((Boolean) this._inEpisodeEndInner$delegate.d(this, $$delegatedProperties[60])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected int get_insertAdRitType() {
        return ((Number) this._insertAdRitType$delegate.d(this, $$delegatedProperties[23])).intValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_localList() {
        return ((Boolean) this._localList$delegate.d(this, $$delegatedProperties[12])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_onlineSubscribed() {
        return ((Boolean) this._onlineSubscribed$delegate.d(this, $$delegatedProperties[68])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected long get_onlineTime() {
        return ((Number) this._onlineTime$delegate.d(this, $$delegatedProperties[69])).longValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected int get_postDataIndex() {
        return ((Number) this._postDataIndex$delegate.d(this, $$delegatedProperties[58])).intValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_refreshFromInnerToOuter() {
        return ((Boolean) this._refreshFromInnerToOuter$delegate.d(this, $$delegatedProperties[61])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected long get_relatedAlbumId() {
        return ((Number) this._relatedAlbumId$delegate.d(this, $$delegatedProperties[66])).longValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_showBackToStartBtnOnce() {
        return ((Boolean) this._showBackToStartBtnOnce$delegate.d(this, $$delegatedProperties[46])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_showMaterialGuidanceAnim() {
        return ((Boolean) this._showMaterialGuidanceAnim$delegate.d(this, $$delegatedProperties[2])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_slideToNewRecommendFeed() {
        return ((Boolean) this._slideToNewRecommendFeed$delegate.d(this, $$delegatedProperties[62])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_supportListen() {
        return ((Boolean) this._supportListen$delegate.d(this, $$delegatedProperties[80])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_ugcRelated() {
        return ((Boolean) this._ugcRelated$delegate.d(this, $$delegatedProperties[21])).booleanValue();
    }

    static {
        Covode.recordClassIndex(599118);
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_secondaryInfoList", "get_secondaryInfoList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_abstractSecondaryInfoList", "get_abstractSecondaryInfoList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_showMaterialGuidanceAnim", "get_showMaterialGuidanceAnim()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_relatedMaterialId", "get_relatedMaterialId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_videoContentType", "get_videoContentType()Lseriessdk/com/dragon/read/saas/rpc/model/VideoContentType;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_duration", "get_duration()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodesTitle", "get_episodesTitle()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodesStatus", "get_episodesStatus()Lseriessdk/com/dragon/read/saas/rpc/model/SeriesStatus;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodeCnt", "get_episodeCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodesId", "get_episodesId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_followed", "get_followed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_followedCnt", "get_followedCnt()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_localList", "get_localList()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodesList", "get_episodesList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_trailerList", "get_trailerList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_seriesColorHex", "get_seriesColorHex()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodesListWithTrail", "get_episodesListWithTrail()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_updateTag", "get_updateTag()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodesCover", "get_episodesCover()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_smallEpisodesCover", "get_smallEpisodesCover()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_videoRecordInfo", "get_videoRecordInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoRecordInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_ugcRelated", "get_ugcRelated()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_enableVisionProduct", "get_enableVisionProduct()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_insertAdRitType", "get_insertAdRitType()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodesListWithTrailAfterCut", "get_episodesListWithTrailAfterCut()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_seriesIntro", "get_seriesIntro()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodesPlayCount", "get_episodesPlayCount()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodesListCountText", "get_episodesListCountText()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodesIntroduction", "get_episodesIntroduction()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_videoPlatformType", "get_videoPlatformType()Lseriessdk/com/dragon/read/saas/rpc/model/VideoPlatformType;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_categorySchema", "get_categorySchema()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_dirData", "get_dirData()Lseriessdk/com/dragon/read/saas/rpc/model/EpisodeLockData;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_directoryItems", "get_directoryItems()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_highlight", "get_highlight()Lcom/dragon/read/component/shortvideo/data/saas/rpcmodel/SaasVideoHighlight;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_disableInsertAd", "get_disableInsertAd()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_recommendInfo", "get_recommendInfo()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_recommendGroupId", "get_recommendGroupId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_fromSrcMaterialId", "get_fromSrcMaterialId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_fromPlayListId", "get_fromPlayListId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_fromSrcChannelId", "get_fromSrcChannelId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_hasShowNextEpisodeAnim", "get_hasShowNextEpisodeAnim()Ljava/lang/Boolean;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_payInfo", "get_payInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoPayInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_hasHighlight", "get_hasHighlight()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_highlightSeriesId", "get_highlightSeriesId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_highlightVid", "get_highlightVid()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_canShowBackToStartBtn", "get_canShowBackToStartBtn()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_showBackToStartBtnOnce", "get_showBackToStartBtnOnce()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_fromPrefetch", "get_fromPrefetch()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_videoUpdateInfo", "get_videoUpdateInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoUpdateInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodeTotalCnt", "get_episodeTotalCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_videoSelectPanelGuideText", "get_videoSelectPanelGuideText()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_videoShareInfo", "get_videoShareInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoShareInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_celebrityList", "get_celebrityList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_seriesSubTitleList", "get_seriesSubTitleList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodeListText", "get_episodeListText()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_episodeListBtnText", "get_episodeListBtnText()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_tabTrailerList", "get_tabTrailerList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_hasAppendTrailer", "get_hasAppendTrailer()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_postDataIndex", "get_postDataIndex()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_useStatus", "get_useStatus()Lseriessdk/com/dragon/read/saas/rpc/model/UseStatus;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_inEpisodeEndInner", "get_inEpisodeEndInner()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_refreshFromInnerToOuter", "get_refreshFromInnerToOuter()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_slideToNewRecommendFeed", "get_slideToNewRecommendFeed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_videoTagInfo", "get_videoTagInfo()Lcom/dragon/read/component/shortvideo/data/saas/model/videotag/SaasVideoTagInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_ugcUserInfo", "get_ugcUserInfo()Lseriessdk/com/dragon/read/saas/rpc/model/UgcUserInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_videoBottomBar", "get_videoBottomBar()Lcom/dragon/read/component/shortvideo/data/saas/rpcmodel/SaaSVideoBottomBar;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_relatedAlbumId", "get_relatedAlbumId()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_bindVideoDetail", "get_bindVideoDetail()Lcom/dragon/read/component/shortvideo/data/saas/video/SaasVideoDetailModel;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_onlineSubscribed", "get_onlineSubscribed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_onlineTime", "get_onlineTime()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_videoRelateBook", "get_videoRelateBook()Lseriessdk/com/dragon/read/saas/rpc/model/VideoRelateBook;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_canShowDownloadIcon", "get_canShowDownloadIcon()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_playerSerialVideoList", "get_playerSerialVideoList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_recTagList", "get_recTagList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_detailRecTagList", "get_detailRecTagList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_bigImages", "get_bigImages()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_mainCreates", "get_mainCreates()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_style", "get_style()Lseriessdk/com/dragon/read/saas/rpc/model/SaaSVideoDetailStyle;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_urgeUpdateData", "get_urgeUpdateData()Lcom/dragon/read/component/shortvideo/data/saas/rpcmodel/SaasUrgeUpdateData;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_subTitleList", "get_subTitleList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_supportListen", "get_supportListen()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperBySelf.class, "_rpcData", "get_rpcData()Ljava/io/Serializable;", 0))};
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_abstractSecondaryInfoList(List<SecondaryInfo> list) {
        this._abstractSecondaryInfoList$delegate.e(this, $$delegatedProperties[1], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_bigImages(List<String> list) {
        this._bigImages$delegate.e(this, $$delegatedProperties[75], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_bindVideoDetail(SaasVideoDetailModel saasVideoDetailModel) {
        this._bindVideoDetail$delegate.e(this, $$delegatedProperties[67], saasVideoDetailModel);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_canShowBackToStartBtn(boolean z) {
        this._canShowBackToStartBtn$delegate.e(this, $$delegatedProperties[45], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_canShowDownloadIcon(boolean z) {
        this._canShowDownloadIcon$delegate.e(this, $$delegatedProperties[71], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_categorySchema(List<SaasCategorySchema> list) {
        this._categorySchema$delegate.e(this, $$delegatedProperties[30], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_celebrityList(List<Celebrity> list) {
        this._celebrityList$delegate.e(this, $$delegatedProperties[52], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_detailRecTagList(List<SecondaryInfo> list) {
        this._detailRecTagList$delegate.e(this, $$delegatedProperties[74], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_dirData(EpisodeLockData episodeLockData) {
        this._dirData$delegate.e(this, $$delegatedProperties[31], episodeLockData);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_directoryItems(List<SaasVideoDirectoryItem> list) {
        this._directoryItems$delegate.e(this, $$delegatedProperties[32], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_disableInsertAd(boolean z) {
        this._disableInsertAd$delegate.e(this, $$delegatedProperties[34], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_duration(long j) {
        this._duration$delegate.e(this, $$delegatedProperties[5], Long.valueOf(j));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_enableVisionProduct(boolean z) {
        this._enableVisionProduct$delegate.e(this, $$delegatedProperties[22], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodeCnt(int i) {
        this._episodeCnt$delegate.e(this, $$delegatedProperties[8], Integer.valueOf(i));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodeListBtnText(String str) {
        this._episodeListBtnText$delegate.e(this, $$delegatedProperties[55], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodeListText(String str) {
        this._episodeListText$delegate.e(this, $$delegatedProperties[54], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodeTotalCnt(int i) {
        this._episodeTotalCnt$delegate.e(this, $$delegatedProperties[49], Integer.valueOf(i));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesCover(String str) {
        this._episodesCover$delegate.e(this, $$delegatedProperties[18], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesId(String str) {
        this._episodesId$delegate.e(this, $$delegatedProperties[9], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesIntroduction(String str) {
        this._episodesIntroduction$delegate.e(this, $$delegatedProperties[28], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesList(List<SaasVideoData> list) {
        this._episodesList$delegate.e(this, $$delegatedProperties[13], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesListCountText(String str) {
        this._episodesListCountText$delegate.e(this, $$delegatedProperties[27], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesListWithTrail(List<SaasVideoData> list) {
        this._episodesListWithTrail$delegate.e(this, $$delegatedProperties[16], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesListWithTrailAfterCut(List<SaasVideoData> list) {
        this._episodesListWithTrailAfterCut$delegate.e(this, $$delegatedProperties[24], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesPlayCount(long j) {
        this._episodesPlayCount$delegate.e(this, $$delegatedProperties[26], Long.valueOf(j));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesStatus(SeriesStatus seriesStatus) {
        this._episodesStatus$delegate.e(this, $$delegatedProperties[7], seriesStatus);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesTitle(String str) {
        this._episodesTitle$delegate.e(this, $$delegatedProperties[6], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_followed(boolean z) {
        this._followed$delegate.e(this, $$delegatedProperties[10], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_followedCnt(long j) {
        this._followedCnt$delegate.e(this, $$delegatedProperties[11], Long.valueOf(j));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_fromPlayListId(String str) {
        this._fromPlayListId$delegate.e(this, $$delegatedProperties[38], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_fromPrefetch(boolean z) {
        this._fromPrefetch$delegate.e(this, $$delegatedProperties[47], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_fromSrcChannelId(String str) {
        this._fromSrcChannelId$delegate.e(this, $$delegatedProperties[39], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_fromSrcMaterialId(String str) {
        this._fromSrcMaterialId$delegate.e(this, $$delegatedProperties[37], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_hasAppendTrailer(boolean z) {
        this._hasAppendTrailer$delegate.e(this, $$delegatedProperties[57], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_hasHighlight(boolean z) {
        this._hasHighlight$delegate.e(this, $$delegatedProperties[42], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_hasShowNextEpisodeAnim(Boolean bool) {
        this._hasShowNextEpisodeAnim$delegate.e(this, $$delegatedProperties[40], bool);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_highlight(SaasVideoHighlight saasVideoHighlight) {
        this._highlight$delegate.e(this, $$delegatedProperties[33], saasVideoHighlight);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_inEpisodeEndInner(boolean z) {
        this._inEpisodeEndInner$delegate.e(this, $$delegatedProperties[60], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_insertAdRitType(int i) {
        this._insertAdRitType$delegate.e(this, $$delegatedProperties[23], Integer.valueOf(i));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_localList(boolean z) {
        this._localList$delegate.e(this, $$delegatedProperties[12], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_mainCreates(List<UgcUserInfo> list) {
        this._mainCreates$delegate.e(this, $$delegatedProperties[76], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_onlineSubscribed(boolean z) {
        this._onlineSubscribed$delegate.e(this, $$delegatedProperties[68], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_onlineTime(long j) {
        this._onlineTime$delegate.e(this, $$delegatedProperties[69], Long.valueOf(j));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_payInfo(VideoPayInfo videoPayInfo) {
        this._payInfo$delegate.e(this, $$delegatedProperties[41], videoPayInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_playerSerialVideoList(List<SaasVideoData> list) {
        this._playerSerialVideoList$delegate.e(this, $$delegatedProperties[72], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_postDataIndex(int i) {
        this._postDataIndex$delegate.e(this, $$delegatedProperties[58], Integer.valueOf(i));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_recTagList(List<SecondaryInfo> list) {
        this._recTagList$delegate.e(this, $$delegatedProperties[73], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_recommendGroupId(String str) {
        this._recommendGroupId$delegate.e(this, $$delegatedProperties[36], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_recommendInfo(String str) {
        this._recommendInfo$delegate.e(this, $$delegatedProperties[35], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_refreshFromInnerToOuter(boolean z) {
        this._refreshFromInnerToOuter$delegate.e(this, $$delegatedProperties[61], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_relatedAlbumId(long j) {
        this._relatedAlbumId$delegate.e(this, $$delegatedProperties[66], Long.valueOf(j));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_relatedMaterialId(String str) {
        this._relatedMaterialId$delegate.e(this, $$delegatedProperties[3], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_rpcData(Serializable serializable) {
        this._rpcData$delegate.e(this, $$delegatedProperties[81], serializable);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_secondaryInfoList(List<SecondaryInfo> list) {
        this._secondaryInfoList$delegate.e(this, $$delegatedProperties[0], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_seriesIntro(String str) {
        this._seriesIntro$delegate.e(this, $$delegatedProperties[25], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_seriesSubTitleList(List<String> list) {
        this._seriesSubTitleList$delegate.e(this, $$delegatedProperties[53], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_showBackToStartBtnOnce(boolean z) {
        this._showBackToStartBtnOnce$delegate.e(this, $$delegatedProperties[46], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_showMaterialGuidanceAnim(boolean z) {
        this._showMaterialGuidanceAnim$delegate.e(this, $$delegatedProperties[2], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_slideToNewRecommendFeed(boolean z) {
        this._slideToNewRecommendFeed$delegate.e(this, $$delegatedProperties[62], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_smallEpisodesCover(String str) {
        this._smallEpisodesCover$delegate.e(this, $$delegatedProperties[19], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_style(SaaSVideoDetailStyle saaSVideoDetailStyle) {
        this._style$delegate.e(this, $$delegatedProperties[77], saaSVideoDetailStyle);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_subTitleList(List<SecondaryInfo> list) {
        this._subTitleList$delegate.e(this, $$delegatedProperties[79], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_supportListen(boolean z) {
        this._supportListen$delegate.e(this, $$delegatedProperties[80], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_tabTrailerList(List<Serializable> list) {
        this._tabTrailerList$delegate.e(this, $$delegatedProperties[56], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_trailerList(List<SaasVideoData> list) {
        this._trailerList$delegate.e(this, $$delegatedProperties[14], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_ugcRelated(boolean z) {
        this._ugcRelated$delegate.e(this, $$delegatedProperties[21], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_ugcUserInfo(UgcUserInfo ugcUserInfo) {
        this._ugcUserInfo$delegate.e(this, $$delegatedProperties[64], ugcUserInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_updateTag(String str) {
        this._updateTag$delegate.e(this, $$delegatedProperties[17], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_urgeUpdateData(SaasUrgeUpdateData saasUrgeUpdateData) {
        this._urgeUpdateData$delegate.e(this, $$delegatedProperties[78], saasUrgeUpdateData);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_useStatus(UseStatus useStatus) {
        this._useStatus$delegate.e(this, $$delegatedProperties[59], useStatus);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoBottomBar(SaaSVideoBottomBar saaSVideoBottomBar) {
        this._videoBottomBar$delegate.e(this, $$delegatedProperties[65], saaSVideoBottomBar);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoContentType(VideoContentType videoContentType) {
        this._videoContentType$delegate.e(this, $$delegatedProperties[4], videoContentType);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoPlatformType(VideoPlatformType videoPlatformType) {
        this._videoPlatformType$delegate.e(this, $$delegatedProperties[29], videoPlatformType);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoRecordInfo(VideoRecordInfo videoRecordInfo) {
        this._videoRecordInfo$delegate.e(this, $$delegatedProperties[20], videoRecordInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoRelateBook(VideoRelateBook videoRelateBook) {
        this._videoRelateBook$delegate.e(this, $$delegatedProperties[70], videoRelateBook);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoSelectPanelGuideText(String str) {
        this._videoSelectPanelGuideText$delegate.e(this, $$delegatedProperties[50], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoShareInfo(VideoShareInfo videoShareInfo) {
        this._videoShareInfo$delegate.e(this, $$delegatedProperties[51], videoShareInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoTagInfo(SaasVideoTagInfo saasVideoTagInfo) {
        this._videoTagInfo$delegate.e(this, $$delegatedProperties[63], saasVideoTagInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoUpdateInfo(VideoUpdateInfo videoUpdateInfo) {
        this._videoUpdateInfo$delegate.e(this, $$delegatedProperties[48], videoUpdateInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_highlightSeriesId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this._highlightSeriesId$delegate.e(this, $$delegatedProperties[43], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_highlightVid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this._highlightVid$delegate.e(this, $$delegatedProperties[44], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_seriesColorHex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this._seriesColorHex$delegate.e(this, $$delegatedProperties[15], str);
    }

    public SaasModelWrapperBySelf(final SaasVideoDetailModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this._secondaryInfoList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.d1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List secondaryInfoList;
                secondaryInfoList = SaasVideoDetailModel.this.getSecondaryInfoList();
                return secondaryInfoList;
            }
        });
        this._abstractSecondaryInfoList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.f1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List abstractSecondaryInfoList;
                abstractSecondaryInfoList = SaasVideoDetailModel.this.getAbstractSecondaryInfoList();
                return abstractSecondaryInfoList;
            }
        });
        this._showMaterialGuidanceAnim$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.r1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isShowMaterialGuidanceAnim;
                isShowMaterialGuidanceAnim = SaasVideoDetailModel.this.isShowMaterialGuidanceAnim();
                return Boolean.valueOf(isShowMaterialGuidanceAnim);
            }
        });
        this._relatedMaterialId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.d2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String relatedMaterialId;
                relatedMaterialId = SaasVideoDetailModel.this.getRelatedMaterialId();
                return relatedMaterialId;
            }
        });
        this._videoContentType$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.p2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoContentType videoContentType;
                videoContentType = SaasVideoDetailModel.this.getVideoContentType();
                return videoContentType;
            }
        });
        this._duration$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.b3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long duration;
                duration = SaasVideoDetailModel.this.getDuration();
                return Long.valueOf(duration);
            }
        });
        this._episodesTitle$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.n3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String episodesTitle;
                episodesTitle = SaasVideoDetailModel.this.getEpisodesTitle();
                return episodesTitle;
            }
        });
        this._episodesStatus$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.z3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesStatus episodesStatus;
                episodesStatus = SaasVideoDetailModel.this.getEpisodesStatus();
                return episodesStatus;
            }
        });
        this._episodeCnt$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.d4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int episodeCnt;
                episodeCnt = SaasVideoDetailModel.this.getEpisodeCnt();
                return Integer.valueOf(episodeCnt);
            }
        });
        this._episodesId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.e4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String episodesId;
                episodesId = SaasVideoDetailModel.this.getEpisodesId();
                return episodesId;
            }
        });
        this._followed$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.o1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isFollowed;
                isFollowed = SaasVideoDetailModel.this.isFollowed();
                return Boolean.valueOf(isFollowed);
            }
        });
        this._followedCnt$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.z1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long followedCnt;
                followedCnt = SaasVideoDetailModel.this.getFollowedCnt();
                return Long.valueOf(followedCnt);
            }
        });
        this._localList$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.k2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isLocalList;
                isLocalList = SaasVideoDetailModel.this.isLocalList();
                return Boolean.valueOf(isLocalList);
            }
        });
        this._episodesList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.v2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List episodesList;
                episodesList = SaasVideoDetailModel.this.getEpisodesList();
                return episodesList;
            }
        });
        this._trailerList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.g3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List trailerList;
                trailerList = SaasVideoDetailModel.this.getTrailerList();
                return trailerList;
            }
        });
        this._seriesColorHex$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.r3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String seriesColorHex;
                seriesColorHex = SaasVideoDetailModel.this.getSeriesColorHex();
                return seriesColorHex;
            }
        });
        this._episodesListWithTrail$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.c4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List episodesListWithTrail;
                episodesListWithTrail = SaasVideoDetailModel.this.getEpisodesListWithTrail();
                return episodesListWithTrail;
            }
        });
        this._updateTag$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.f4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String updateTag;
                updateTag = SaasVideoDetailModel.this.getUpdateTag();
                return updateTag;
            }
        });
        this._episodesCover$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.g4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String episodesCover;
                episodesCover = SaasVideoDetailModel.this.getEpisodesCover();
                return episodesCover;
            }
        });
        this._smallEpisodesCover$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.e1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String smallEpisodesCover;
                smallEpisodesCover = SaasVideoDetailModel.this.getSmallEpisodesCover();
                return smallEpisodesCover;
            }
        });
        this._videoRecordInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.g1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoRecordInfo videoRecordInfo;
                videoRecordInfo = SaasVideoDetailModel.this.getVideoRecordInfo();
                return videoRecordInfo;
            }
        });
        this._ugcRelated$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.h1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isUgcRelated;
                isUgcRelated = SaasVideoDetailModel.this.isUgcRelated();
                return Boolean.valueOf(isUgcRelated);
            }
        });
        this._enableVisionProduct$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.i1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isEnableVisionProduct;
                isEnableVisionProduct = SaasVideoDetailModel.this.isEnableVisionProduct();
                return Boolean.valueOf(isEnableVisionProduct);
            }
        });
        this._insertAdRitType$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.j1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int insertAdRitType;
                insertAdRitType = SaasVideoDetailModel.this.getInsertAdRitType();
                return Integer.valueOf(insertAdRitType);
            }
        });
        this._episodesListWithTrailAfterCut$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.k1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List episodesListWithTrailAfterCut;
                episodesListWithTrailAfterCut = SaasVideoDetailModel.this.getEpisodesListWithTrailAfterCut();
                return episodesListWithTrailAfterCut;
            }
        });
        this._seriesIntro$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.l1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String seriesIntro;
                seriesIntro = SaasVideoDetailModel.this.getSeriesIntro();
                return seriesIntro;
            }
        });
        this._episodesPlayCount$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.m1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long episodesPlayCount;
                episodesPlayCount = SaasVideoDetailModel.this.getEpisodesPlayCount();
                return Long.valueOf(episodesPlayCount);
            }
        });
        this._episodesListCountText$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.n1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String episodesListCountText;
                episodesListCountText = SaasVideoDetailModel.this.getEpisodesListCountText();
                return episodesListCountText;
            }
        });
        this._episodesIntroduction$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.p1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String episodesIntroduction;
                episodesIntroduction = SaasVideoDetailModel.this.getEpisodesIntroduction();
                return episodesIntroduction;
            }
        });
        this._videoPlatformType$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.q1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoPlatformType videoPlatformType;
                videoPlatformType = SaasVideoDetailModel.this.getVideoPlatformType();
                return videoPlatformType;
            }
        });
        this._categorySchema$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.s1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List categorySchema;
                categorySchema = SaasVideoDetailModel.this.getCategorySchema();
                return categorySchema;
            }
        });
        this._dirData$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.t1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                EpisodeLockData dirData;
                dirData = SaasVideoDetailModel.this.getDirData();
                return dirData;
            }
        });
        this._directoryItems$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.u1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List directoryItems;
                directoryItems = SaasVideoDetailModel.this.getDirectoryItems();
                return directoryItems;
            }
        });
        this._highlight$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.v1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SaasVideoHighlight highlight;
                highlight = SaasVideoDetailModel.this.getHighlight();
                return highlight;
            }
        });
        this._disableInsertAd$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.w1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isDisableInsertAd;
                isDisableInsertAd = SaasVideoDetailModel.this.isDisableInsertAd();
                return Boolean.valueOf(isDisableInsertAd);
            }
        });
        this._recommendInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.x1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String recommendInfo;
                recommendInfo = SaasVideoDetailModel.this.getRecommendInfo();
                return recommendInfo;
            }
        });
        this._recommendGroupId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.y1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String recommendGroupId;
                recommendGroupId = SaasVideoDetailModel.this.getRecommendGroupId();
                return recommendGroupId;
            }
        });
        this._fromSrcMaterialId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.a2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String fromSrcMaterialId;
                fromSrcMaterialId = SaasVideoDetailModel.this.getFromSrcMaterialId();
                return fromSrcMaterialId;
            }
        });
        this._fromPlayListId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.b2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String fromPlayListId;
                fromPlayListId = SaasVideoDetailModel.this.getFromPlayListId();
                return fromPlayListId;
            }
        });
        this._fromSrcChannelId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.c2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String fromSrcChannelId;
                fromSrcChannelId = SaasVideoDetailModel.this.getFromSrcChannelId();
                return fromSrcChannelId;
            }
        });
        this._hasShowNextEpisodeAnim$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.e2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Boolean hasShowNextEpisodeAnim;
                hasShowNextEpisodeAnim = SaasVideoDetailModel.this.getHasShowNextEpisodeAnim();
                return hasShowNextEpisodeAnim;
            }
        });
        this._payInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.f2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoPayInfo payInfo;
                payInfo = SaasVideoDetailModel.this.getPayInfo();
                return payInfo;
            }
        });
        this._hasHighlight$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.g2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isHasHighlight;
                isHasHighlight = SaasVideoDetailModel.this.isHasHighlight();
                return Boolean.valueOf(isHasHighlight);
            }
        });
        this._highlightSeriesId$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.h2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String highlightSeriesId;
                highlightSeriesId = SaasVideoDetailModel.this.getHighlightSeriesId();
                return highlightSeriesId;
            }
        });
        this._highlightVid$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.i2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String highlightVid;
                highlightVid = SaasVideoDetailModel.this.getHighlightVid();
                return highlightVid;
            }
        });
        this._canShowBackToStartBtn$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.j2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isCanShowBackToStartBtn;
                isCanShowBackToStartBtn = SaasVideoDetailModel.this.isCanShowBackToStartBtn();
                return Boolean.valueOf(isCanShowBackToStartBtn);
            }
        });
        this._showBackToStartBtnOnce$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.l2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isShowBackToStartBtnOnce;
                isShowBackToStartBtnOnce = SaasVideoDetailModel.this.isShowBackToStartBtnOnce();
                return Boolean.valueOf(isShowBackToStartBtnOnce);
            }
        });
        this._fromPrefetch$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.m2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isFromPrefetch;
                isFromPrefetch = SaasVideoDetailModel.this.isFromPrefetch();
                return Boolean.valueOf(isFromPrefetch);
            }
        });
        this._videoUpdateInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.n2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoUpdateInfo videoUpdateInfo;
                videoUpdateInfo = SaasVideoDetailModel.this.getVideoUpdateInfo();
                return videoUpdateInfo;
            }
        });
        this._episodeTotalCnt$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.o2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int episodeTotalCnt;
                episodeTotalCnt = SaasVideoDetailModel.this.getEpisodeTotalCnt();
                return Integer.valueOf(episodeTotalCnt);
            }
        });
        this._videoSelectPanelGuideText$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.q2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String videoSelectPanelGuideText;
                videoSelectPanelGuideText = SaasVideoDetailModel.this.getVideoSelectPanelGuideText();
                return videoSelectPanelGuideText;
            }
        });
        this._videoShareInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.r2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoShareInfo videoShareInfo;
                videoShareInfo = SaasVideoDetailModel.this.getVideoShareInfo();
                return videoShareInfo;
            }
        });
        this._celebrityList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.s2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List celebrityList;
                celebrityList = SaasVideoDetailModel.this.getCelebrityList();
                return celebrityList;
            }
        });
        this._seriesSubTitleList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.t2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List seriesSubTitleList;
                seriesSubTitleList = SaasVideoDetailModel.this.getSeriesSubTitleList();
                return seriesSubTitleList;
            }
        });
        this._episodeListText$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.u2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String episodeListText;
                episodeListText = SaasVideoDetailModel.this.getEpisodeListText();
                return episodeListText;
            }
        });
        this._episodeListBtnText$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.w2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String episodeListBtnText;
                episodeListBtnText = SaasVideoDetailModel.this.getEpisodeListBtnText();
                return episodeListBtnText;
            }
        });
        this._tabTrailerList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.x2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List tabTrailerList;
                tabTrailerList = SaasVideoDetailModel.this.getTabTrailerList();
                return tabTrailerList;
            }
        });
        this._hasAppendTrailer$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.y2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean hasAppendTrailer;
                hasAppendTrailer = SaasVideoDetailModel.this.getHasAppendTrailer();
                return Boolean.valueOf(hasAppendTrailer);
            }
        });
        this._postDataIndex$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.z2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int postDataIndex;
                postDataIndex = SaasVideoDetailModel.this.getPostDataIndex();
                return Integer.valueOf(postDataIndex);
            }
        });
        this._useStatus$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.a3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                UseStatus useStatus;
                useStatus = SaasVideoDetailModel.this.useStatus;
                return useStatus;
            }
        });
        this._inEpisodeEndInner$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.c3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isInEpisodeEndInner;
                isInEpisodeEndInner = SaasVideoDetailModel.this.isInEpisodeEndInner();
                return Boolean.valueOf(isInEpisodeEndInner);
            }
        });
        this._refreshFromInnerToOuter$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.d3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean refreshFromInnerToOuter;
                refreshFromInnerToOuter = SaasVideoDetailModel.this.getRefreshFromInnerToOuter();
                return Boolean.valueOf(refreshFromInnerToOuter);
            }
        });
        this._slideToNewRecommendFeed$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.e3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isSlideToNewRecommendFeed;
                isSlideToNewRecommendFeed = SaasVideoDetailModel.this.isSlideToNewRecommendFeed();
                return Boolean.valueOf(isSlideToNewRecommendFeed);
            }
        });
        this._videoTagInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.f3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SaasVideoTagInfo videoTagInfo;
                videoTagInfo = SaasVideoDetailModel.this.getVideoTagInfo();
                return videoTagInfo;
            }
        });
        this._ugcUserInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.h3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                UgcUserInfo ugcUserInfo;
                ugcUserInfo = SaasVideoDetailModel.this.getUgcUserInfo();
                return ugcUserInfo;
            }
        });
        this._videoBottomBar$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.i3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SaaSVideoBottomBar videoBottomBar;
                videoBottomBar = SaasVideoDetailModel.this.getVideoBottomBar();
                return videoBottomBar;
            }
        });
        this._relatedAlbumId$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.j3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long relatedAlbumId;
                relatedAlbumId = SaasVideoDetailModel.this.getRelatedAlbumId();
                return Long.valueOf(relatedAlbumId);
            }
        });
        this._bindVideoDetail$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.k3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SaasVideoDetailModel bindVideoDetail;
                bindVideoDetail = SaasVideoDetailModel.this.getBindVideoDetail();
                return bindVideoDetail;
            }
        });
        this._onlineSubscribed$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.l3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isOnlineSubscribed;
                isOnlineSubscribed = SaasVideoDetailModel.this.isOnlineSubscribed();
                return Boolean.valueOf(isOnlineSubscribed);
            }
        });
        this._onlineTime$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.m3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long onlineTime;
                onlineTime = SaasVideoDetailModel.this.getOnlineTime();
                return Long.valueOf(onlineTime);
            }
        });
        this._videoRelateBook$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.o3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoRelateBook videoRelateBook;
                videoRelateBook = SaasVideoDetailModel.this.getVideoRelateBook();
                return videoRelateBook;
            }
        });
        this._canShowDownloadIcon$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.p3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isCanShowDownloadIcon;
                isCanShowDownloadIcon = SaasVideoDetailModel.this.isCanShowDownloadIcon();
                return Boolean.valueOf(isCanShowDownloadIcon);
            }
        });
        this._playerSerialVideoList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.q3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List playerSerialVideoList;
                playerSerialVideoList = SaasVideoDetailModel.this.getPlayerSerialVideoList();
                return playerSerialVideoList;
            }
        });
        this._recTagList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.s3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List recTagList;
                recTagList = SaasVideoDetailModel.this.getRecTagList();
                return recTagList;
            }
        });
        this._detailRecTagList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.t3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List detailRecTagList;
                detailRecTagList = SaasVideoDetailModel.this.getDetailRecTagList();
                return detailRecTagList;
            }
        });
        this._bigImages$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.u3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List bigImages;
                bigImages = SaasVideoDetailModel.this.getBigImages();
                return bigImages;
            }
        });
        this._mainCreates$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.v3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List mainCreates;
                mainCreates = SaasVideoDetailModel.this.getMainCreates();
                return mainCreates;
            }
        });
        this._style$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.w3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SaaSVideoDetailStyle style;
                style = SaasVideoDetailModel.this.getStyle();
                return style;
            }
        });
        this._urgeUpdateData$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.x3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SaasUrgeUpdateData urgeUpdateData;
                urgeUpdateData = SaasVideoDetailModel.this.getUrgeUpdateData();
                return urgeUpdateData;
            }
        });
        this._subTitleList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.y3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List subTitleList;
                subTitleList = SaasVideoDetailModel.this.getSubTitleList();
                return subTitleList;
            }
        });
        this._supportListen$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.a4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isSupportListen;
                isSupportListen = SaasVideoDetailModel.this.isSupportListen();
                return Boolean.valueOf(isSupportListen);
            }
        });
        this._rpcData$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.b4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Serializable rpcData;
                rpcData = SaasVideoDetailModel.this.getRpcData();
                return rpcData;
            }
        });
        loadVideoDataInfo();
    }
}
