package ps3;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.dragon.read.component.shortvideo.data.ugc.SaaSSeriesUgcPostData;
import com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostData;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.VideoSeriesIdType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;

    static {
        Covode.recordClassIndex(599025);
        a = new c();
    }

    private c() {
    }

    public final void a(SaaSSeriesUgcPostData originData, SaaSSeriesUgcPostData copyData) {
        Intrinsics.checkNotNullParameter(originData, "originData");
        Intrinsics.checkNotNullParameter(copyData, "copyData");
        b(originData, copyData);
        SaasVideoDetailModel bindDetailModel = originData.getBindDetailModel();
        if (bindDetailModel != null) {
            copyData.setBindDetailModel(bindDetailModel);
        }
        copyData.setReportedShowOnce(originData.getReportedShowOnce());
        copyData.setTrailerTitle(originData.getTrailerTitle());
        copyData.setInsertFromScene(originData.getInsertFromScene());
        copyData.setTrailer(originData.getTrailer());
    }

    public final void b(SaaSUgcPostData originData, SaaSUgcPostData copyData) {
        Intrinsics.checkNotNullParameter(originData, "originData");
        Intrinsics.checkNotNullParameter(copyData, "copyData");
        copyData.setVid(originData.getVid());
        copyData.setVideoSeriesIdType(VideoSeriesIdType.SeriesId);
        copyData.setContentType(originData.getContentType());
        copyData.setTitle(originData.getTitle());
        copyData.setSeriesName(originData.getSeriesName());
        copyData.setHasDigg(originData.isHasDigg());
        copyData.setDiggCount(originData.getDiggCount());
        copyData.setRecommendInfo(originData.getRecommendInfo());
        copyData.setRecommendGroupId(originData.getRecommendGroupId());
        copyData.setCover(originData.getCover());
        copyData.setVertical(originData.isVertical());
        copyData.setDuration(originData.getDuration());
        copyData.setPrivate(originData.isPrivate());
        copyData.setPlayCnt(originData.getPlayCnt());
        copyData.setSeriesId(originData.getSeriesId());
        copyData.setEpisodesId(originData.getEpisodesId());
        copyData.setEnableVisionProduct(originData.isEnableVisionProduct());
        copyData.setVideoRecordInfo(copyData.getVideoRecordInfo());
        copyData.setSecondaryInfoList(originData.getSecondaryInfoList());
        copyData.setUserInfo(originData.getUserInfo());
        copyData.setVideoShareInfo(originData.getVideoShareInfo());
        copyData.setBottomBar(originData.getBottomBar());
        copyData.setRelatedAlbumId(originData.getRelatedAlbumId());
        copyData.setVideoRecordInfo(originData.getVideoRecordInfo());
        copyData.setCreateTime(Long.valueOf(originData.getCreateTime()));
        copyData.setFollowedCount(originData.getFollowedCount());
        copyData.setSeriesPlayCnt(originData.getSeriesPlayCnt());
        copyData.setRecTagList(originData.getRecTagList());
        copyData.setVideoTagInfo(originData.getVideoTagInfo());
    }
}
