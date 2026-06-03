package com.dragon.read.component.shortvideo.data.saas.video;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.dragon.read.component.shortvideo.data.saas.model.videotag.SaasVideoTagInfo;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaaSVideoBottomBar;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasCategorySchema;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasVideoDirectoryItem;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import seriessdk.com.dragon.read.saas.rpc.model.Celebrity;
import seriessdk.com.dragon.read.saas.rpc.model.DownloadConfig;
import seriessdk.com.dragon.read.saas.rpc.model.EpisodeInfo;
import seriessdk.com.dragon.read.saas.rpc.model.InsertAdRitType;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;
import seriessdk.com.dragon.read.saas.rpc.model.SeriesStatus;
import seriessdk.com.dragon.read.saas.rpc.model.UgcUserInfo;
import seriessdk.com.dragon.read.saas.rpc.model.UseStatus;
import seriessdk.com.dragon.read.saas.rpc.model.VideoBottomBar;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoDetailInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPayInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPlatformType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoRecordInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoShareInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoUpdateInfo;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasModelWrapperByRpc extends SaasVideoDetailModelWrapper {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final f _abstractSecondaryInfoList$delegate;
    private final f _bigImages$delegate;
    private final f _bindVideoDetail$delegate;
    private final h _canShowDownloadIcon$delegate;
    private final f _categorySchema$delegate;
    private final f _celebrityList$delegate;
    private final f _currentVideoData$delegate;
    private final f _detailRecTagList$delegate;
    private final f _directoryItems$delegate;
    private final h _disableInsertAd$delegate;
    private final h _duration$delegate;
    private final h _enableVisionProduct$delegate;
    private final h _episodeCnt$delegate;
    private final h _episodeTotalCnt$delegate;
    private final f _episodesCover$delegate;
    private final f _episodesId$delegate;
    private final f _episodesIntroduction$delegate;
    private final f _episodesListCountText$delegate;
    private final h _episodesPlayCount$delegate;
    private final f _episodesStatus$delegate;
    private final f _episodesTitle$delegate;
    private final h _followed$delegate;
    private final h _followedCnt$delegate;
    private final h _insertAdRitType$delegate;
    private final f _mainCreates$delegate;
    private final h _onlineSubscribed$delegate;
    private final h _onlineTime$delegate;
    private final f _payInfo$delegate;
    private final f _recTagList$delegate;
    private final f _recommendGroupId$delegate;
    private final f _recommendInfo$delegate;
    private final h _relatedAlbumId$delegate;
    private final f _secondaryInfoList$delegate;
    private final h _seriesColorHex$delegate;
    private final f _seriesIntro$delegate;
    private final f _seriesSubTitleList$delegate;
    private final f _subTitleList$delegate;
    private final h _supportListen$delegate;
    private final f _ugcUserInfo$delegate;
    private final f _useStatus$delegate;
    private final f _videoBottomBar$delegate;
    private final f _videoContentType$delegate;
    private final f _videoPlatformType$delegate;
    private final f _videoRecordInfo$delegate;
    private final f _videoShareInfo$delegate;
    private final f _videoTagInfo$delegate;
    private final f _videoUpdateInfo$delegate;
    private final VideoDetailInfo rpc;

    public static final class a extends TypeToken<List<? extends SaasCategorySchema>> {
        a() {
        }
    }

    public final VideoDetailInfo getRpc() {
        return this.rpc;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SecondaryInfo> get_abstractSecondaryInfoList() {
        return (List) this._abstractSecondaryInfoList$delegate.d(this, $$delegatedProperties[13]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<String> get_bigImages() {
        return (List) this._bigImages$delegate.d(this, $$delegatedProperties[23]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SaasVideoDetailModel get_bindVideoDetail() {
        return (SaasVideoDetailModel) this._bindVideoDetail$delegate.d(this, $$delegatedProperties[44]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SaasCategorySchema> get_categorySchema() {
        return (List) this._categorySchema$delegate.d(this, $$delegatedProperties[45]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<Celebrity> get_celebrityList() {
        return (List) this._celebrityList$delegate.d(this, $$delegatedProperties[31]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SaasVideoData get_currentVideoData() {
        return (SaasVideoData) this._currentVideoData$delegate.d(this, $$delegatedProperties[41]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SecondaryInfo> get_detailRecTagList() {
        return (List) this._detailRecTagList$delegate.d(this, $$delegatedProperties[8]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SaasVideoDirectoryItem> get_directoryItems() {
        return (List) this._directoryItems$delegate.d(this, $$delegatedProperties[46]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodesCover() {
        return (String) this._episodesCover$delegate.d(this, $$delegatedProperties[33]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodesId() {
        return (String) this._episodesId$delegate.d(this, $$delegatedProperties[0]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodesIntroduction() {
        return (String) this._episodesIntroduction$delegate.d(this, $$delegatedProperties[17]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodesListCountText() {
        return (String) this._episodesListCountText$delegate.d(this, $$delegatedProperties[16]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SeriesStatus get_episodesStatus() {
        return (SeriesStatus) this._episodesStatus$delegate.d(this, $$delegatedProperties[4]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_episodesTitle() {
        return (String) this._episodesTitle$delegate.d(this, $$delegatedProperties[5]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<UgcUserInfo> get_mainCreates() {
        return (List) this._mainCreates$delegate.d(this, $$delegatedProperties[39]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoPayInfo get_payInfo() {
        return (VideoPayInfo) this._payInfo$delegate.d(this, $$delegatedProperties[27]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SecondaryInfo> get_recTagList() {
        return (List) this._recTagList$delegate.d(this, $$delegatedProperties[22]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_recommendGroupId() {
        return (String) this._recommendGroupId$delegate.d(this, $$delegatedProperties[26]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_recommendInfo() {
        return (String) this._recommendInfo$delegate.d(this, $$delegatedProperties[25]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SecondaryInfo> get_secondaryInfoList() {
        return (List) this._secondaryInfoList$delegate.d(this, $$delegatedProperties[12]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_seriesColorHex() {
        return (String) this._seriesColorHex$delegate.d(this, $$delegatedProperties[19]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected String get_seriesIntro() {
        return (String) this._seriesIntro$delegate.d(this, $$delegatedProperties[14]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<String> get_seriesSubTitleList() {
        return (List) this._seriesSubTitleList$delegate.d(this, $$delegatedProperties[32]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected List<SecondaryInfo> get_subTitleList() {
        return (List) this._subTitleList$delegate.d(this, $$delegatedProperties[38]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected UgcUserInfo get_ugcUserInfo() {
        return (UgcUserInfo) this._ugcUserInfo$delegate.d(this, $$delegatedProperties[20]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected UseStatus get_useStatus() {
        return (UseStatus) this._useStatus$delegate.d(this, $$delegatedProperties[34]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SaaSVideoBottomBar get_videoBottomBar() {
        return (SaaSVideoBottomBar) this._videoBottomBar$delegate.d(this, $$delegatedProperties[42]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoContentType get_videoContentType() {
        return (VideoContentType) this._videoContentType$delegate.d(this, $$delegatedProperties[6]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoPlatformType get_videoPlatformType() {
        return (VideoPlatformType) this._videoPlatformType$delegate.d(this, $$delegatedProperties[18]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoRecordInfo get_videoRecordInfo() {
        return (VideoRecordInfo) this._videoRecordInfo$delegate.d(this, $$delegatedProperties[11]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoShareInfo get_videoShareInfo() {
        return (VideoShareInfo) this._videoShareInfo$delegate.d(this, $$delegatedProperties[30]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected SaasVideoTagInfo get_videoTagInfo() {
        return (SaasVideoTagInfo) this._videoTagInfo$delegate.d(this, $$delegatedProperties[43]);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected VideoUpdateInfo get_videoUpdateInfo() {
        return (VideoUpdateInfo) this._videoUpdateInfo$delegate.d(this, $$delegatedProperties[28]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SaasCategorySchema> parseCategorySchema() {
        try {
            return (List) JSONUtils.fromJson(this.rpc.categorySchema, new a().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    private final List<SaasVideoData> parseVideoDataList() {
        return ps3.e.a.b(this.rpc.videoList, get_seriesColorHex(), "", get_videoPlatformType());
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_canShowDownloadIcon() {
        return ((Boolean) this._canShowDownloadIcon$delegate.d(this, $$delegatedProperties[35])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_disableInsertAd() {
        return ((Boolean) this._disableInsertAd$delegate.d(this, $$delegatedProperties[24])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected long get_duration() {
        return ((Number) this._duration$delegate.d(this, $$delegatedProperties[7])).longValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_enableVisionProduct() {
        return ((Boolean) this._enableVisionProduct$delegate.d(this, $$delegatedProperties[9])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected int get_episodeCnt() {
        return ((Number) this._episodeCnt$delegate.d(this, $$delegatedProperties[3])).intValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected int get_episodeTotalCnt() {
        return ((Number) this._episodeTotalCnt$delegate.d(this, $$delegatedProperties[29])).intValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected long get_episodesPlayCount() {
        return ((Number) this._episodesPlayCount$delegate.d(this, $$delegatedProperties[15])).longValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_followed() {
        return ((Boolean) this._followed$delegate.d(this, $$delegatedProperties[1])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected long get_followedCnt() {
        return ((Number) this._followedCnt$delegate.d(this, $$delegatedProperties[2])).longValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected int get_insertAdRitType() {
        return ((Number) this._insertAdRitType$delegate.d(this, $$delegatedProperties[10])).intValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_onlineSubscribed() {
        return ((Boolean) this._onlineSubscribed$delegate.d(this, $$delegatedProperties[36])).booleanValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected long get_onlineTime() {
        return ((Number) this._onlineTime$delegate.d(this, $$delegatedProperties[37])).longValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected long get_relatedAlbumId() {
        return ((Number) this._relatedAlbumId$delegate.d(this, $$delegatedProperties[21])).longValue();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected boolean get_supportListen() {
        return ((Boolean) this._supportListen$delegate.d(this, $$delegatedProperties[40])).booleanValue();
    }

    static {
        Covode.recordClassIndex(599117);
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_episodesId", "get_episodesId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_followed", "get_followed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_followedCnt", "get_followedCnt()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_episodeCnt", "get_episodeCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_episodesStatus", "get_episodesStatus()Lseriessdk/com/dragon/read/saas/rpc/model/SeriesStatus;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_episodesTitle", "get_episodesTitle()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_videoContentType", "get_videoContentType()Lseriessdk/com/dragon/read/saas/rpc/model/VideoContentType;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_duration", "get_duration()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_detailRecTagList", "get_detailRecTagList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_enableVisionProduct", "get_enableVisionProduct()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_insertAdRitType", "get_insertAdRitType()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_videoRecordInfo", "get_videoRecordInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoRecordInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_secondaryInfoList", "get_secondaryInfoList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_abstractSecondaryInfoList", "get_abstractSecondaryInfoList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_seriesIntro", "get_seriesIntro()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_episodesPlayCount", "get_episodesPlayCount()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_episodesListCountText", "get_episodesListCountText()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_episodesIntroduction", "get_episodesIntroduction()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_videoPlatformType", "get_videoPlatformType()Lseriessdk/com/dragon/read/saas/rpc/model/VideoPlatformType;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_seriesColorHex", "get_seriesColorHex()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_ugcUserInfo", "get_ugcUserInfo()Lseriessdk/com/dragon/read/saas/rpc/model/UgcUserInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_relatedAlbumId", "get_relatedAlbumId()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_recTagList", "get_recTagList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_bigImages", "get_bigImages()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_disableInsertAd", "get_disableInsertAd()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_recommendInfo", "get_recommendInfo()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_recommendGroupId", "get_recommendGroupId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_payInfo", "get_payInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoPayInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_videoUpdateInfo", "get_videoUpdateInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoUpdateInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_episodeTotalCnt", "get_episodeTotalCnt()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_videoShareInfo", "get_videoShareInfo()Lseriessdk/com/dragon/read/saas/rpc/model/VideoShareInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_celebrityList", "get_celebrityList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_seriesSubTitleList", "get_seriesSubTitleList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_episodesCover", "get_episodesCover()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_useStatus", "get_useStatus()Lseriessdk/com/dragon/read/saas/rpc/model/UseStatus;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_canShowDownloadIcon", "get_canShowDownloadIcon()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_onlineSubscribed", "get_onlineSubscribed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_onlineTime", "get_onlineTime()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_subTitleList", "get_subTitleList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_mainCreates", "get_mainCreates()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_supportListen", "get_supportListen()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_currentVideoData", "get_currentVideoData()Lcom/dragon/read/component/shortvideo/data/saas/video/SaasVideoData;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_videoBottomBar", "get_videoBottomBar()Lcom/dragon/read/component/shortvideo/data/saas/rpcmodel/SaaSVideoBottomBar;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_videoTagInfo", "get_videoTagInfo()Lcom/dragon/read/component/shortvideo/data/saas/model/videotag/SaasVideoTagInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_bindVideoDetail", "get_bindVideoDetail()Lcom/dragon/read/component/shortvideo/data/saas/video/SaasVideoDetailModel;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_categorySchema", "get_categorySchema()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SaasModelWrapperByRpc.class, "_directoryItems", "get_directoryItems()Ljava/util/List;", 0))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _abstractSecondaryInfoList_delegate$lambda$13(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.abstractTags;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _bigImages_delegate$lambda$23(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.bigImages;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _celebrityList_delegate$lambda$31(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.celebrities;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _detailRecTagList_delegate$lambda$8(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.detailRecTags;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _disableInsertAd_delegate$lambda$24(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.disableInsertAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _duration_delegate$lambda$7(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.duration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _enableVisionProduct_delegate$lambda$9(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.enableVisionProduct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _episodeCnt_delegate$lambda$3(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.episodeCnt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _episodeTotalCnt_delegate$lambda$29(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.episodeTotalCnt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodesCover_delegate$lambda$33(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.seriesCover;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodesIntroduction_delegate$lambda$17(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.seriesIntro;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodesListCountText_delegate$lambda$16(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.episodeRightText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _episodesPlayCount_delegate$lambda$15(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.seriesPlayCnt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SeriesStatus _episodesStatus_delegate$lambda$4(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.seriesStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodesTitle_delegate$lambda$5(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.seriesTitle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _followedCnt_delegate$lambda$2(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.followedCnt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _followed_delegate$lambda$1(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.followed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _mainCreates_delegate$lambda$39(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.mainCreatorUsers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _onlineTime_delegate$lambda$37(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.onlineTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPayInfo _payInfo_delegate$lambda$27(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.payInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _recTagList_delegate$lambda$22(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.recTags;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _recommendGroupId_delegate$lambda$26(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.recommendGroupId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _recommendInfo_delegate$lambda$25(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.recommendInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long _relatedAlbumId_delegate$lambda$21(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.relatedAlbumId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _secondaryInfoList_delegate$lambda$12(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.secondaryInfos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _seriesIntro_delegate$lambda$14(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.seriesIntro;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _seriesSubTitleList_delegate$lambda$32(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.seriesSubTitleList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _subTitleList_delegate$lambda$38(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.subTitleList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _supportListen_delegate$lambda$40(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.supportListen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UgcUserInfo _ugcUserInfo_delegate$lambda$20(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.ugcUserInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UseStatus _useStatus_delegate$lambda$34(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.status;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoContentType _videoContentType_delegate$lambda$6(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.contentType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPlatformType _videoPlatformType_delegate$lambda$18(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.videoPlatform;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoRecordInfo _videoRecordInfo_delegate$lambda$11(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.recordInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoShareInfo _videoShareInfo_delegate$lambda$30(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.shareInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoUpdateInfo _videoUpdateInfo_delegate$lambda$28(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return saasModelWrapperByRpc.rpc.updateInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _canShowDownloadIcon_delegate$lambda$35(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        DownloadConfig downloadConfig = saasModelWrapperByRpc.rpc.downloadConfig;
        if (downloadConfig == null || !downloadConfig.canDownload) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaasVideoData _currentVideoData_delegate$lambda$41(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        Object firstOrNull;
        List<SaasVideoData> episodesList = saasModelWrapperByRpc.getEpisodesList();
        if (episodesList != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) episodesList);
            return (SaasVideoData) firstOrNull;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _episodesId_delegate$lambda$0(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return String.valueOf(saasModelWrapperByRpc.rpc.seriesId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _insertAdRitType_delegate$lambda$10(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        InsertAdRitType insertAdRitType = saasModelWrapperByRpc.rpc.insertAdRitType;
        if (insertAdRitType != null) {
            return insertAdRitType.getValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _onlineSubscribed_delegate$lambda$36(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        if (saasModelWrapperByRpc.rpc.onlineSubscribed) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _seriesColorHex_delegate$lambda$19(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        String str = saasModelWrapperByRpc.rpc.seriesColorHex;
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaaSVideoBottomBar _videoBottomBar_delegate$lambda$43(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        VideoBottomBar videoBottomBar = saasModelWrapperByRpc.rpc.bottomBar;
        if (videoBottomBar != null) {
            return ps3.d.a.l(videoBottomBar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaasVideoTagInfo _videoTagInfo_delegate$lambda$44(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        return ps3.g.i(saasModelWrapperByRpc.rpc.videoTagInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_abstractSecondaryInfoList(List<SecondaryInfo> list) {
        this._abstractSecondaryInfoList$delegate.e(this, $$delegatedProperties[13], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_bigImages(List<String> list) {
        this._bigImages$delegate.e(this, $$delegatedProperties[23], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_bindVideoDetail(SaasVideoDetailModel saasVideoDetailModel) {
        this._bindVideoDetail$delegate.e(this, $$delegatedProperties[44], saasVideoDetailModel);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_canShowDownloadIcon(boolean z) {
        this._canShowDownloadIcon$delegate.e(this, $$delegatedProperties[35], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_categorySchema(List<? extends SaasCategorySchema> list) {
        this._categorySchema$delegate.e(this, $$delegatedProperties[45], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_celebrityList(List<Celebrity> list) {
        this._celebrityList$delegate.e(this, $$delegatedProperties[31], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_currentVideoData(SaasVideoData saasVideoData) {
        this._currentVideoData$delegate.e(this, $$delegatedProperties[41], saasVideoData);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_detailRecTagList(List<SecondaryInfo> list) {
        this._detailRecTagList$delegate.e(this, $$delegatedProperties[8], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_directoryItems(List<? extends SaasVideoDirectoryItem> list) {
        this._directoryItems$delegate.e(this, $$delegatedProperties[46], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_disableInsertAd(boolean z) {
        this._disableInsertAd$delegate.e(this, $$delegatedProperties[24], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_duration(long j) {
        this._duration$delegate.e(this, $$delegatedProperties[7], Long.valueOf(j));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_enableVisionProduct(boolean z) {
        this._enableVisionProduct$delegate.e(this, $$delegatedProperties[9], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodeCnt(int i) {
        this._episodeCnt$delegate.e(this, $$delegatedProperties[3], Integer.valueOf(i));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodeTotalCnt(int i) {
        this._episodeTotalCnt$delegate.e(this, $$delegatedProperties[29], Integer.valueOf(i));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesCover(String str) {
        this._episodesCover$delegate.e(this, $$delegatedProperties[33], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesId(String str) {
        this._episodesId$delegate.e(this, $$delegatedProperties[0], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesIntroduction(String str) {
        this._episodesIntroduction$delegate.e(this, $$delegatedProperties[17], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesListCountText(String str) {
        this._episodesListCountText$delegate.e(this, $$delegatedProperties[16], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesPlayCount(long j) {
        this._episodesPlayCount$delegate.e(this, $$delegatedProperties[15], Long.valueOf(j));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesStatus(SeriesStatus seriesStatus) {
        this._episodesStatus$delegate.e(this, $$delegatedProperties[4], seriesStatus);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_episodesTitle(String str) {
        this._episodesTitle$delegate.e(this, $$delegatedProperties[5], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_followed(boolean z) {
        this._followed$delegate.e(this, $$delegatedProperties[1], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_followedCnt(long j) {
        this._followedCnt$delegate.e(this, $$delegatedProperties[2], Long.valueOf(j));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_insertAdRitType(int i) {
        this._insertAdRitType$delegate.e(this, $$delegatedProperties[10], Integer.valueOf(i));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_mainCreates(List<UgcUserInfo> list) {
        this._mainCreates$delegate.e(this, $$delegatedProperties[39], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_onlineSubscribed(boolean z) {
        this._onlineSubscribed$delegate.e(this, $$delegatedProperties[36], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_onlineTime(long j) {
        this._onlineTime$delegate.e(this, $$delegatedProperties[37], Long.valueOf(j));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_payInfo(VideoPayInfo videoPayInfo) {
        this._payInfo$delegate.e(this, $$delegatedProperties[27], videoPayInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_recTagList(List<SecondaryInfo> list) {
        this._recTagList$delegate.e(this, $$delegatedProperties[22], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_recommendGroupId(String str) {
        this._recommendGroupId$delegate.e(this, $$delegatedProperties[26], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_recommendInfo(String str) {
        this._recommendInfo$delegate.e(this, $$delegatedProperties[25], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_relatedAlbumId(long j) {
        this._relatedAlbumId$delegate.e(this, $$delegatedProperties[21], Long.valueOf(j));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_secondaryInfoList(List<SecondaryInfo> list) {
        this._secondaryInfoList$delegate.e(this, $$delegatedProperties[12], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_seriesIntro(String str) {
        this._seriesIntro$delegate.e(this, $$delegatedProperties[14], str);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_seriesSubTitleList(List<String> list) {
        this._seriesSubTitleList$delegate.e(this, $$delegatedProperties[32], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_subTitleList(List<SecondaryInfo> list) {
        this._subTitleList$delegate.e(this, $$delegatedProperties[38], list);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_supportListen(boolean z) {
        this._supportListen$delegate.e(this, $$delegatedProperties[40], Boolean.valueOf(z));
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_ugcUserInfo(UgcUserInfo ugcUserInfo) {
        this._ugcUserInfo$delegate.e(this, $$delegatedProperties[20], ugcUserInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_useStatus(UseStatus useStatus) {
        this._useStatus$delegate.e(this, $$delegatedProperties[34], useStatus);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoBottomBar(SaaSVideoBottomBar saaSVideoBottomBar) {
        this._videoBottomBar$delegate.e(this, $$delegatedProperties[42], saaSVideoBottomBar);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoContentType(VideoContentType videoContentType) {
        this._videoContentType$delegate.e(this, $$delegatedProperties[6], videoContentType);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoPlatformType(VideoPlatformType videoPlatformType) {
        this._videoPlatformType$delegate.e(this, $$delegatedProperties[18], videoPlatformType);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoRecordInfo(VideoRecordInfo videoRecordInfo) {
        this._videoRecordInfo$delegate.e(this, $$delegatedProperties[11], videoRecordInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoShareInfo(VideoShareInfo videoShareInfo) {
        this._videoShareInfo$delegate.e(this, $$delegatedProperties[30], videoShareInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoTagInfo(SaasVideoTagInfo saasVideoTagInfo) {
        this._videoTagInfo$delegate.e(this, $$delegatedProperties[43], saasVideoTagInfo);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_videoUpdateInfo(VideoUpdateInfo videoUpdateInfo) {
        this._videoUpdateInfo$delegate.e(this, $$delegatedProperties[28], videoUpdateInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SaasVideoDetailModel _bindVideoDetail_delegate$lambda$46(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        Object firstOrNull;
        List list = saasModelWrapperByRpc.rpc.videoDetailList;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            VideoDetailInfo videoDetailInfo = (VideoDetailInfo) firstOrNull;
            if (videoDetailInfo != null) {
                return m7.a(videoDetailInfo);
            }
        }
        return null;
    }

    private final SaasVideoDirectoryItem toDirectoryItem(EpisodeInfo episodeInfo) {
        if (episodeInfo == null) {
            return null;
        }
        SaasVideoDirectoryItem saasVideoDirectoryItem = new SaasVideoDirectoryItem();
        saasVideoDirectoryItem.videoId = episodeInfo.vid;
        saasVideoDirectoryItem.needUnlock = episodeInfo.needUnlock;
        saasVideoDirectoryItem.waitFree = episodeInfo.waitFree;
        saasVideoDirectoryItem.trialDuration = episodeInfo.trialDuration;
        return saasVideoDirectoryItem;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper
    protected void set_seriesColorHex(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this._seriesColorHex$delegate.e(this, $$delegatedProperties[19], str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _directoryItems_delegate$lambda$49(SaasModelWrapperByRpc saasModelWrapperByRpc) {
        List list = saasModelWrapperByRpc.rpc.videoList;
        if (list != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(saasModelWrapperByRpc.toDirectoryItem((EpisodeInfo) it2.next()));
            }
            return arrayList;
        }
        return null;
    }

    public SaasModelWrapperByRpc(VideoDetailInfo rpc) {
        Intrinsics.checkNotNullParameter(rpc, "rpc");
        this.rpc = rpc;
        this._episodesId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String _episodesId_delegate$lambda$0;
                _episodesId_delegate$lambda$0 = SaasModelWrapperByRpc._episodesId_delegate$lambda$0(SaasModelWrapperByRpc.this);
                return _episodesId_delegate$lambda$0;
            }
        });
        this._followed$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean _followed_delegate$lambda$1;
                _followed_delegate$lambda$1 = SaasModelWrapperByRpc._followed_delegate$lambda$1(SaasModelWrapperByRpc.this);
                return Boolean.valueOf(_followed_delegate$lambda$1);
            }
        });
        this._followedCnt$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long _followedCnt_delegate$lambda$2;
                _followedCnt_delegate$lambda$2 = SaasModelWrapperByRpc._followedCnt_delegate$lambda$2(SaasModelWrapperByRpc.this);
                return Long.valueOf(_followedCnt_delegate$lambda$2);
            }
        });
        this._episodeCnt$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int _episodeCnt_delegate$lambda$3;
                _episodeCnt_delegate$lambda$3 = SaasModelWrapperByRpc._episodeCnt_delegate$lambda$3(SaasModelWrapperByRpc.this);
                return Integer.valueOf(_episodeCnt_delegate$lambda$3);
            }
        });
        this._episodesStatus$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SeriesStatus _episodesStatus_delegate$lambda$4;
                _episodesStatus_delegate$lambda$4 = SaasModelWrapperByRpc._episodesStatus_delegate$lambda$4(SaasModelWrapperByRpc.this);
                return _episodesStatus_delegate$lambda$4;
            }
        });
        this._episodesTitle$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.s0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String _episodesTitle_delegate$lambda$5;
                _episodesTitle_delegate$lambda$5 = SaasModelWrapperByRpc._episodesTitle_delegate$lambda$5(SaasModelWrapperByRpc.this);
                return _episodesTitle_delegate$lambda$5;
            }
        });
        this._videoContentType$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.t0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoContentType _videoContentType_delegate$lambda$6;
                _videoContentType_delegate$lambda$6 = SaasModelWrapperByRpc._videoContentType_delegate$lambda$6(SaasModelWrapperByRpc.this);
                return _videoContentType_delegate$lambda$6;
            }
        });
        this._duration$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.u0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long _duration_delegate$lambda$7;
                _duration_delegate$lambda$7 = SaasModelWrapperByRpc._duration_delegate$lambda$7(SaasModelWrapperByRpc.this);
                return Long.valueOf(_duration_delegate$lambda$7);
            }
        });
        this._detailRecTagList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List _detailRecTagList_delegate$lambda$8;
                _detailRecTagList_delegate$lambda$8 = SaasModelWrapperByRpc._detailRecTagList_delegate$lambda$8(SaasModelWrapperByRpc.this);
                return _detailRecTagList_delegate$lambda$8;
            }
        });
        this._enableVisionProduct$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.w0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean _enableVisionProduct_delegate$lambda$9;
                _enableVisionProduct_delegate$lambda$9 = SaasModelWrapperByRpc._enableVisionProduct_delegate$lambda$9(SaasModelWrapperByRpc.this);
                return Boolean.valueOf(_enableVisionProduct_delegate$lambda$9);
            }
        });
        this._insertAdRitType$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int _insertAdRitType_delegate$lambda$10;
                _insertAdRitType_delegate$lambda$10 = SaasModelWrapperByRpc._insertAdRitType_delegate$lambda$10(SaasModelWrapperByRpc.this);
                return Integer.valueOf(_insertAdRitType_delegate$lambda$10);
            }
        });
        this._videoRecordInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoRecordInfo _videoRecordInfo_delegate$lambda$11;
                _videoRecordInfo_delegate$lambda$11 = SaasModelWrapperByRpc._videoRecordInfo_delegate$lambda$11(SaasModelWrapperByRpc.this);
                return _videoRecordInfo_delegate$lambda$11;
            }
        });
        this._secondaryInfoList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.p0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List _secondaryInfoList_delegate$lambda$12;
                _secondaryInfoList_delegate$lambda$12 = SaasModelWrapperByRpc._secondaryInfoList_delegate$lambda$12(SaasModelWrapperByRpc.this);
                return _secondaryInfoList_delegate$lambda$12;
            }
        });
        this._abstractSecondaryInfoList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.x0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List _abstractSecondaryInfoList_delegate$lambda$13;
                _abstractSecondaryInfoList_delegate$lambda$13 = SaasModelWrapperByRpc._abstractSecondaryInfoList_delegate$lambda$13(SaasModelWrapperByRpc.this);
                return _abstractSecondaryInfoList_delegate$lambda$13;
            }
        });
        this._seriesIntro$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.y0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String _seriesIntro_delegate$lambda$14;
                _seriesIntro_delegate$lambda$14 = SaasModelWrapperByRpc._seriesIntro_delegate$lambda$14(SaasModelWrapperByRpc.this);
                return _seriesIntro_delegate$lambda$14;
            }
        });
        this._episodesPlayCount$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.z0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long _episodesPlayCount_delegate$lambda$15;
                _episodesPlayCount_delegate$lambda$15 = SaasModelWrapperByRpc._episodesPlayCount_delegate$lambda$15(SaasModelWrapperByRpc.this);
                return Long.valueOf(_episodesPlayCount_delegate$lambda$15);
            }
        });
        this._episodesListCountText$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.a1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String _episodesListCountText_delegate$lambda$16;
                _episodesListCountText_delegate$lambda$16 = SaasModelWrapperByRpc._episodesListCountText_delegate$lambda$16(SaasModelWrapperByRpc.this);
                return _episodesListCountText_delegate$lambda$16;
            }
        });
        this._episodesIntroduction$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.b1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String _episodesIntroduction_delegate$lambda$17;
                _episodesIntroduction_delegate$lambda$17 = SaasModelWrapperByRpc._episodesIntroduction_delegate$lambda$17(SaasModelWrapperByRpc.this);
                return _episodesIntroduction_delegate$lambda$17;
            }
        });
        this._videoPlatformType$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.c1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoPlatformType _videoPlatformType_delegate$lambda$18;
                _videoPlatformType_delegate$lambda$18 = SaasModelWrapperByRpc._videoPlatformType_delegate$lambda$18(SaasModelWrapperByRpc.this);
                return _videoPlatformType_delegate$lambda$18;
            }
        });
        this._seriesColorHex$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String _seriesColorHex_delegate$lambda$19;
                _seriesColorHex_delegate$lambda$19 = SaasModelWrapperByRpc._seriesColorHex_delegate$lambda$19(SaasModelWrapperByRpc.this);
                return _seriesColorHex_delegate$lambda$19;
            }
        });
        this._ugcUserInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                UgcUserInfo _ugcUserInfo_delegate$lambda$20;
                _ugcUserInfo_delegate$lambda$20 = SaasModelWrapperByRpc._ugcUserInfo_delegate$lambda$20(SaasModelWrapperByRpc.this);
                return _ugcUserInfo_delegate$lambda$20;
            }
        });
        this._relatedAlbumId$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long _relatedAlbumId_delegate$lambda$21;
                _relatedAlbumId_delegate$lambda$21 = SaasModelWrapperByRpc._relatedAlbumId_delegate$lambda$21(SaasModelWrapperByRpc.this);
                return Long.valueOf(_relatedAlbumId_delegate$lambda$21);
            }
        });
        this._recTagList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List _recTagList_delegate$lambda$22;
                _recTagList_delegate$lambda$22 = SaasModelWrapperByRpc._recTagList_delegate$lambda$22(SaasModelWrapperByRpc.this);
                return _recTagList_delegate$lambda$22;
            }
        });
        this._bigImages$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List _bigImages_delegate$lambda$23;
                _bigImages_delegate$lambda$23 = SaasModelWrapperByRpc._bigImages_delegate$lambda$23(SaasModelWrapperByRpc.this);
                return _bigImages_delegate$lambda$23;
            }
        });
        this._disableInsertAd$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean _disableInsertAd_delegate$lambda$24;
                _disableInsertAd_delegate$lambda$24 = SaasModelWrapperByRpc._disableInsertAd_delegate$lambda$24(SaasModelWrapperByRpc.this);
                return Boolean.valueOf(_disableInsertAd_delegate$lambda$24);
            }
        });
        this._recommendInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String _recommendInfo_delegate$lambda$25;
                _recommendInfo_delegate$lambda$25 = SaasModelWrapperByRpc._recommendInfo_delegate$lambda$25(SaasModelWrapperByRpc.this);
                return _recommendInfo_delegate$lambda$25;
            }
        });
        this._recommendGroupId$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String _recommendGroupId_delegate$lambda$26;
                _recommendGroupId_delegate$lambda$26 = SaasModelWrapperByRpc._recommendGroupId_delegate$lambda$26(SaasModelWrapperByRpc.this);
                return _recommendGroupId_delegate$lambda$26;
            }
        });
        this._payInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoPayInfo _payInfo_delegate$lambda$27;
                _payInfo_delegate$lambda$27 = SaasModelWrapperByRpc._payInfo_delegate$lambda$27(SaasModelWrapperByRpc.this);
                return _payInfo_delegate$lambda$27;
            }
        });
        this._videoUpdateInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoUpdateInfo _videoUpdateInfo_delegate$lambda$28;
                _videoUpdateInfo_delegate$lambda$28 = SaasModelWrapperByRpc._videoUpdateInfo_delegate$lambda$28(SaasModelWrapperByRpc.this);
                return _videoUpdateInfo_delegate$lambda$28;
            }
        });
        this._episodeTotalCnt$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int _episodeTotalCnt_delegate$lambda$29;
                _episodeTotalCnt_delegate$lambda$29 = SaasModelWrapperByRpc._episodeTotalCnt_delegate$lambda$29(SaasModelWrapperByRpc.this);
                return Integer.valueOf(_episodeTotalCnt_delegate$lambda$29);
            }
        });
        this._videoShareInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoShareInfo _videoShareInfo_delegate$lambda$30;
                _videoShareInfo_delegate$lambda$30 = SaasModelWrapperByRpc._videoShareInfo_delegate$lambda$30(SaasModelWrapperByRpc.this);
                return _videoShareInfo_delegate$lambda$30;
            }
        });
        this._celebrityList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List _celebrityList_delegate$lambda$31;
                _celebrityList_delegate$lambda$31 = SaasModelWrapperByRpc._celebrityList_delegate$lambda$31(SaasModelWrapperByRpc.this);
                return _celebrityList_delegate$lambda$31;
            }
        });
        this._seriesSubTitleList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List _seriesSubTitleList_delegate$lambda$32;
                _seriesSubTitleList_delegate$lambda$32 = SaasModelWrapperByRpc._seriesSubTitleList_delegate$lambda$32(SaasModelWrapperByRpc.this);
                return _seriesSubTitleList_delegate$lambda$32;
            }
        });
        this._episodesCover$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String _episodesCover_delegate$lambda$33;
                _episodesCover_delegate$lambda$33 = SaasModelWrapperByRpc._episodesCover_delegate$lambda$33(SaasModelWrapperByRpc.this);
                return _episodesCover_delegate$lambda$33;
            }
        });
        this._useStatus$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                UseStatus _useStatus_delegate$lambda$34;
                _useStatus_delegate$lambda$34 = SaasModelWrapperByRpc._useStatus_delegate$lambda$34(SaasModelWrapperByRpc.this);
                return _useStatus_delegate$lambda$34;
            }
        });
        this._canShowDownloadIcon$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean _canShowDownloadIcon_delegate$lambda$35;
                _canShowDownloadIcon_delegate$lambda$35 = SaasModelWrapperByRpc._canShowDownloadIcon_delegate$lambda$35(SaasModelWrapperByRpc.this);
                return Boolean.valueOf(_canShowDownloadIcon_delegate$lambda$35);
            }
        });
        this._onlineSubscribed$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean _onlineSubscribed_delegate$lambda$36;
                _onlineSubscribed_delegate$lambda$36 = SaasModelWrapperByRpc._onlineSubscribed_delegate$lambda$36(SaasModelWrapperByRpc.this);
                return Boolean.valueOf(_onlineSubscribed_delegate$lambda$36);
            }
        });
        this._onlineTime$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long _onlineTime_delegate$lambda$37;
                _onlineTime_delegate$lambda$37 = SaasModelWrapperByRpc._onlineTime_delegate$lambda$37(SaasModelWrapperByRpc.this);
                return Long.valueOf(_onlineTime_delegate$lambda$37);
            }
        });
        this._subTitleList$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List _subTitleList_delegate$lambda$38;
                _subTitleList_delegate$lambda$38 = SaasModelWrapperByRpc._subTitleList_delegate$lambda$38(SaasModelWrapperByRpc.this);
                return _subTitleList_delegate$lambda$38;
            }
        });
        this._mainCreates$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List _mainCreates_delegate$lambda$39;
                _mainCreates_delegate$lambda$39 = SaasModelWrapperByRpc._mainCreates_delegate$lambda$39(SaasModelWrapperByRpc.this);
                return _mainCreates_delegate$lambda$39;
            }
        });
        this._supportListen$delegate = new h(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean _supportListen_delegate$lambda$40;
                _supportListen_delegate$lambda$40 = SaasModelWrapperByRpc._supportListen_delegate$lambda$40(SaasModelWrapperByRpc.this);
                return Boolean.valueOf(_supportListen_delegate$lambda$40);
            }
        });
        this._currentVideoData$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SaasVideoData _currentVideoData_delegate$lambda$41;
                _currentVideoData_delegate$lambda$41 = SaasModelWrapperByRpc._currentVideoData_delegate$lambda$41(SaasModelWrapperByRpc.this);
                return _currentVideoData_delegate$lambda$41;
            }
        });
        this._videoBottomBar$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.l0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SaaSVideoBottomBar _videoBottomBar_delegate$lambda$43;
                _videoBottomBar_delegate$lambda$43 = SaasModelWrapperByRpc._videoBottomBar_delegate$lambda$43(SaasModelWrapperByRpc.this);
                return _videoBottomBar_delegate$lambda$43;
            }
        });
        this._videoTagInfo$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.m0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SaasVideoTagInfo _videoTagInfo_delegate$lambda$44;
                _videoTagInfo_delegate$lambda$44 = SaasModelWrapperByRpc._videoTagInfo_delegate$lambda$44(SaasModelWrapperByRpc.this);
                return _videoTagInfo_delegate$lambda$44;
            }
        });
        this._bindVideoDetail$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.n0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SaasVideoDetailModel _bindVideoDetail_delegate$lambda$46;
                _bindVideoDetail_delegate$lambda$46 = SaasModelWrapperByRpc._bindVideoDetail_delegate$lambda$46(SaasModelWrapperByRpc.this);
                return _bindVideoDetail_delegate$lambda$46;
            }
        });
        this._categorySchema$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.o0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List parseCategorySchema;
                parseCategorySchema = SaasModelWrapperByRpc.this.parseCategorySchema();
                return parseCategorySchema;
            }
        });
        this._directoryItems$delegate = new f(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List _directoryItems_delegate$lambda$49;
                _directoryItems_delegate$lambda$49 = SaasModelWrapperByRpc._directoryItems_delegate$lambda$49(SaasModelWrapperByRpc.this);
                return _directoryItems_delegate$lambda$49;
            }
        });
        setEpisodesList(parseVideoDataList());
        Iterator<T> it2 = getEpisodesListWithTrail().iterator();
        while (it2.hasNext()) {
            ((tq3.e) ShortSeriesApi.Companion.c().getDocker().d(tq3.e.class)).M2((SaasVideoData) it2.next());
        }
        loadVideoDataInfo();
    }
}
