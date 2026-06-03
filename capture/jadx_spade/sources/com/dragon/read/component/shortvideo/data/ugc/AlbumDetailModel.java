package com.dragon.read.component.shortvideo.data.ugc;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaaSVideoBottomBar;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.saas.video.b;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;
import seriessdk.com.dragon.read.saas.rpc.model.SeriesStatus;
import seriessdk.com.dragon.read.saas.rpc.model.UgcUserInfo;
import seriessdk.com.dragon.read.saas.rpc.model.UserConsumeInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AlbumDetailModel implements Serializable, b {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private final String albumId;
    private SaaSVideoBottomBar bottomBar;
    private final long collectCnt;
    private final String colorHex;
    private final String cover;
    private final List<SaaSUgcPostData> defectiveDetailList;
    private Map<String, ? extends SaaSUgcPostData> defectiveDetailMap;
    private final int episodeCount;
    private List<String> episodeEntranceText;
    private final int episodeTotalCount;
    private String fromPlayListId;
    private String fromSrcChannelId;
    private String fromSrcMaterialId;
    private final String intro;
    private final boolean isDisableInsertAd;
    private final long playCnt;
    private final List<SecondaryInfo> recTags;
    private String recommendGroupId;
    private String recommendInfo;
    private final SeriesStatus seriesStates;
    private final String smallCover;
    private final List<String> subTitleList;
    private final String title;
    private final UserConsumeInfo userConsumeInfo;
    private final UgcUserInfo userInfo;
    private List<? extends SaaSUgcPostData> videoDetailList;

    public static final class a {
        static {
            Covode.recordClassIndex(599126);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599125);
        Companion = new a(null);
    }

    public long getFollowedCnt() {
        return 0L;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final SaaSVideoBottomBar getBottomBar() {
        return this.bottomBar;
    }

    public final long getCollectCnt() {
        return this.collectCnt;
    }

    public final String getColorHex() {
        return this.colorHex;
    }

    public final String getCover() {
        return this.cover;
    }

    public final List<SaaSUgcPostData> getDefectiveDetailList() {
        return this.defectiveDetailList;
    }

    public final Map<String, SaaSUgcPostData> getDefectiveDetailMap() {
        return this.defectiveDetailMap;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public String getDetailId() {
        return this.albumId;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public int getEpisodeCnt() {
        return this.episodeCount;
    }

    public final int getEpisodeCount() {
        return this.episodeCount;
    }

    public final List<String> getEpisodeEntranceText() {
        return this.episodeEntranceText;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public List<SaasVideoData> getEpisodeList() {
        return this.defectiveDetailList;
    }

    public final int getEpisodeTotalCount() {
        return this.episodeTotalCount;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public SeriesStatus getEpisodesStatus() {
        return this.seriesStates;
    }

    public final String getFromPlayListId() {
        return this.fromPlayListId;
    }

    public final String getFromSrcChannelId() {
        return this.fromSrcChannelId;
    }

    public final String getFromSrcMaterialId() {
        return this.fromSrcMaterialId;
    }

    public final String getIntro() {
        return this.intro;
    }

    public final long getPlayCnt() {
        return this.playCnt;
    }

    public final List<SecondaryInfo> getRecTags() {
        return this.recTags;
    }

    public final String getRecommendGroupId() {
        return this.recommendGroupId;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public String getSeriesColorHex() {
        return this.colorHex;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public String getSeriesCover() {
        return this.cover;
    }

    public final SeriesStatus getSeriesStates() {
        return this.seriesStates;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public String getSeriesTitle() {
        return this.title;
    }

    public final String getSmallCover() {
        return this.smallCover;
    }

    public final List<String> getSubTitleList() {
        return this.subTitleList;
    }

    public final String getTitle() {
        return this.title;
    }

    public final UserConsumeInfo getUserConsumeInfo() {
        return this.userConsumeInfo;
    }

    public final UgcUserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public VideoContentType getVideoContentType() {
        return VideoContentType.Album;
    }

    public final List<SaaSUgcPostData> getVideoDetailList() {
        return this.videoDetailList;
    }

    public final boolean isDisableInsertAd() {
        return this.isDisableInsertAd;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public String recommendGroupId() {
        return this.recommendGroupId;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.b
    public String recommendInfo() {
        return this.recommendInfo;
    }

    public final void setBottomBar(SaaSVideoBottomBar saaSVideoBottomBar) {
        this.bottomBar = saaSVideoBottomBar;
    }

    public final void setEpisodeEntranceText(List<String> list) {
        this.episodeEntranceText = list;
    }

    public final void setFromPlayListId(String str) {
        this.fromPlayListId = str;
    }

    public final void setFromSrcChannelId(String str) {
        this.fromSrcChannelId = str;
    }

    public final void setFromSrcMaterialId(String str) {
        this.fromSrcMaterialId = str;
    }

    public final void setRecommendGroupId(String str) {
        this.recommendGroupId = str;
    }

    public final void setRecommendInfo(String str) {
        this.recommendInfo = str;
    }

    public final void setVideoDetailList(List<? extends SaaSUgcPostData> list) {
        this.videoDetailList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AlbumDetailModel(String albumId, String title, String str, int i, SeriesStatus seriesStatus, String str2, String str3, int i2, List<String> list, String str4, UgcUserInfo ugcUserInfo, List<? extends SaaSUgcPostData> list2, List<? extends SaaSUgcPostData> list3, List<String> list4, long j, long j2, boolean z, List<? extends SecondaryInfo> list5, UserConsumeInfo userConsumeInfo) {
        LinkedHashMap linkedHashMap;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(title, "title");
        this.albumId = albumId;
        this.title = title;
        this.intro = str;
        this.episodeCount = i;
        this.seriesStates = seriesStatus;
        this.cover = str2;
        this.colorHex = str3;
        this.episodeTotalCount = i2;
        this.subTitleList = list;
        this.smallCover = str4;
        this.userInfo = ugcUserInfo;
        this.defectiveDetailList = list2;
        this.videoDetailList = list3;
        this.episodeEntranceText = list4;
        this.playCnt = j;
        this.collectCnt = j2;
        this.isDisableInsertAd = z;
        this.recTags = list5;
        this.userConsumeInfo = userConsumeInfo;
        if (list2 != 0) {
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj : list2) {
                String vid = ((SaaSUgcPostData) obj).getVid();
                Intrinsics.checkNotNullExpressionValue(vid, "getVid(...)");
                linkedHashMap.put(vid, obj);
            }
        } else {
            linkedHashMap = null;
        }
        this.defectiveDetailMap = linkedHashMap;
    }
}
