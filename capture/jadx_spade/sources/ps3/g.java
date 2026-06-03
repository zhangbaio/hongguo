package ps3;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.dragon.read.component.shortvideo.api.config.ssconfig.SaasVideoTagInfoCrashUploadV711;
import com.dragon.read.component.shortvideo.data.saas.model.videotag.SaasGradientOrientation;
import com.dragon.read.component.shortvideo.data.saas.model.videotag.SaasVideoTagInfo;
import com.dragon.read.component.shortvideo.data.saas.model.videotag.SaasVideoTagInfoType;
import com.dragon.read.component.shortvideo.data.saas.model.videotag.SaasVideoTagMode;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasCategorySchema;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaasVideoDirectoryItem;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModelWrapper;
import com.dragon.read.component.shortvideo.data.saas.video.m7;
import com.dragon.read.util.r0;
import com.google.gson.reflect.TypeToken;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import seriessdk.com.dragon.read.saas.rpc.model.DownloadConfig;
import seriessdk.com.dragon.read.saas.rpc.model.EpisodeInfo;
import seriessdk.com.dragon.read.saas.rpc.model.EpisodeLockData;
import seriessdk.com.dragon.read.saas.rpc.model.GradientOrientation;
import seriessdk.com.dragon.read.saas.rpc.model.InsertAdRitType;
import seriessdk.com.dragon.read.saas.rpc.model.SaaSVideoDetailData;
import seriessdk.com.dragon.read.saas.rpc.model.TagInfoType;
import seriessdk.com.dragon.read.saas.rpc.model.UseStatus;
import seriessdk.com.dragon.read.saas.rpc.model.VideoBottomBar;
import seriessdk.com.dragon.read.saas.rpc.model.VideoDetailInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPlatformType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoTagInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoTagInfoType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoTagMode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class g {
    private static final LogHelper a;

    class a extends TypeToken<List<SaasCategorySchema>> {
        a() {
        }
    }

    static {
        Covode.recordClassIndex(599032);
        a = new LogHelper("VideoDetailParserUtils");
    }

    public static SaasVideoDetailModel b(Object obj) {
        return m7.a(obj);
    }

    public static SaasVideoDetailModel c(SaaSVideoDetailData saaSVideoDetailData) {
        return d(saaSVideoDetailData, "");
    }

    public static SaasVideoDetailModel e(VideoDetailInfo videoDetailInfo) {
        return f(videoDetailInfo, "");
    }

    public static SaasVideoTagInfo i(VideoTagInfo videoTagInfo) throws JSONException {
        Integer num;
        Integer num2;
        int i;
        int i2;
        try {
            String str = videoTagInfo.text;
            List list = videoTagInfo.bgColor;
            List list2 = videoTagInfo.darkBgColor;
            String str2 = videoTagInfo.iconUrl;
            String str3 = videoTagInfo.darkIconUrl;
            boolean z = videoTagInfo.canUseBrandColor;
            String str4 = videoTagInfo.textColor;
            String str5 = videoTagInfo.darkTextColor;
            SaasVideoTagMode.a aVar = SaasVideoTagMode.Companion;
            VideoTagMode videoTagMode = videoTagInfo.mode;
            if (videoTagMode != null) {
                num = Integer.valueOf(videoTagMode.getValue());
            } else {
                num = null;
            }
            SaasVideoTagMode a2 = aVar.a(num);
            SaasGradientOrientation.a aVar2 = SaasGradientOrientation.Companion;
            GradientOrientation gradientOrientation = videoTagInfo.bgColorOrientation;
            if (gradientOrientation != null) {
                num2 = Integer.valueOf(gradientOrientation.getValue());
            } else {
                num2 = null;
            }
            SaasGradientOrientation a3 = aVar2.a(num2);
            SaasVideoTagInfoType.a aVar3 = SaasVideoTagInfoType.Companion;
            VideoTagInfoType videoTagInfoType = videoTagInfo.tagInfoType;
            if (videoTagInfoType != null) {
                i = videoTagInfoType.getValue();
            } else {
                i = 0;
            }
            SaasVideoTagInfoType a4 = aVar3.a(i);
            TagInfoType tagInfoType = videoTagInfo.infoType;
            if (tagInfoType != null) {
                i2 = tagInfoType.getValue();
            } else {
                i2 = 1;
            }
            return new SaasVideoTagInfo(str, list, list2, str2, str3, z, str4, str5, a2, a3, a4, TagInfoType.findByValue(i2));
        } catch (Throwable th) {
            if (SaasVideoTagInfoCrashUploadV711.a.a().enable) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("error_stack", Log.getStackTraceString(th));
                AppLogNewUtils.onEventV3("video_tag_info_parse_error", jSONObject);
            }
            return null;
        }
    }

    public static SaasVideoDetailModel a(SaasVideoDetailModel saasVideoDetailModel) {
        SaasVideoDetailModel b = b(saasVideoDetailModel);
        if (saasVideoDetailModel != null && !(b instanceof SaasVideoDetailModelWrapper)) {
            b.setEpisodesId(String.valueOf(saasVideoDetailModel.getEpisodesId()));
            b.setFollowed(saasVideoDetailModel.isFollowed());
            b.setFollowedCnt(saasVideoDetailModel.getFollowedCnt());
            b.setEpisodeCnt(saasVideoDetailModel.getEpisodeCnt());
            b.setSeasonIndex(saasVideoDetailModel.getSeasonIndex());
            b.setEpisodesStatus(saasVideoDetailModel.getEpisodesStatus());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < saasVideoDetailModel.getEpisodesList().size(); i++) {
                arrayList.add(saasVideoDetailModel.getEpisodesList().get(i));
            }
            b.setEpisodesList(arrayList);
            b.setEpisodesTitle(saasVideoDetailModel.getEpisodesTitle());
            b.setUpdateTag(saasVideoDetailModel.getUpdateTag());
            b.setUgcUserInfo(saasVideoDetailModel.getUgcUserInfo());
            b.setVideoBottomBar(saasVideoDetailModel.getVideoBottomBar());
            b.setRelatedAlbumId(saasVideoDetailModel.getRelatedAlbumId());
            b.setBindVideoDetail(saasVideoDetailModel.getBindVideoDetail());
            b.setVideoContentType(saasVideoDetailModel.getVideoContentType());
            b.setDuration(saasVideoDetailModel.getDuration());
            b.setEpisodesCover(saasVideoDetailModel.getEpisodesCover());
            b.setVideoRecordInfo(saasVideoDetailModel.getVideoRecordInfo());
            b.setSecondaryInfoList(saasVideoDetailModel.getSecondaryInfoList());
            b.setAbstractSecondaryInfoList(saasVideoDetailModel.getAbstractSecondaryInfoList());
            b.setSeriesIntro(saasVideoDetailModel.getSeriesIntro());
            b.setEpisodesPlayCount(saasVideoDetailModel.getEpisodesPlayCount());
            b.setEpisodesListCountText(saasVideoDetailModel.getEpisodesListCountText());
            b.setEpisodesIntroduction(saasVideoDetailModel.getEpisodesIntroduction());
            b.setVideoPlatformType(saasVideoDetailModel.getVideoPlatformType());
            b.setSeriesColorHex(saasVideoDetailModel.getSeriesColorHex());
            b.setCategorySchema(saasVideoDetailModel.getCategorySchema());
            b.setDirData(saasVideoDetailModel.getDirData());
            b.setDirectoryItems(saasVideoDetailModel.getDirectoryItems());
            b.setHighlight(saasVideoDetailModel.getHighlight());
            b.setDisableInsertAd(saasVideoDetailModel.isDisableInsertAd());
            b.setRecommendInfo(saasVideoDetailModel.getRecommendInfo());
            b.setRecommendGroupId(saasVideoDetailModel.getRecommendGroupId());
            b.setPayInfo(saasVideoDetailModel.getPayInfo());
            b.setVideoUpdateInfo(saasVideoDetailModel.getVideoUpdateInfo());
            b.setEpisodeTotalCnt(saasVideoDetailModel.getEpisodeTotalCnt());
            b.setVideoShareInfo(saasVideoDetailModel.getVideoShareInfo());
            b.setCelebrityList(saasVideoDetailModel.getCelebrityList());
            b.setSeriesSubTitleList(saasVideoDetailModel.getSeriesSubTitleList());
            if (saasVideoDetailModel.getUseStatus() != null) {
                b.setUseStatus(saasVideoDetailModel.getUseStatus());
            }
            b.setCanShowDownloadIcon(saasVideoDetailModel.isCanShowDownloadIcon());
            b.setVideoTagInfo(saasVideoDetailModel.getVideoTagInfo());
            b.setEnableVisionProduct(saasVideoDetailModel.isEnableVisionProduct());
            b.setInsertAdRitType(saasVideoDetailModel.getInsertAdRitType());
            b.setSubTitleList(saasVideoDetailModel.getSubTitleList());
            b.setMainCreates(saasVideoDetailModel.getMainCreates());
            b.setSupportListen(saasVideoDetailModel.isSupportListen());
            b.setAiUsageType(saasVideoDetailModel.getAiUsageType());
            b.setVideoRelateBook(saasVideoDetailModel.getVideoRelateBook());
            b.setPlayBtnSchema(saasVideoDetailModel.getPlayBtnSchema());
            b.setCreateTime(saasVideoDetailModel.getCreateTime());
        }
        if (!r0.a(saasVideoDetailModel.getTrailerList())) {
            if (!r0.a(saasVideoDetailModel.getEpisodesList()) && saasVideoDetailModel.getTrailerList().get(0).isVertical() && !saasVideoDetailModel.getEpisodesList().get(0).isVertical()) {
                a.i("剧为横，预告片为竖，横屏屏蔽预告片", new Object[0]);
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < saasVideoDetailModel.getTrailerList().size(); i2++) {
                    arrayList2.add(saasVideoDetailModel.getTrailerList().get(i2));
                }
                b.setTrailerList(saasVideoDetailModel.getTrailerList());
            }
        }
        b.setRpcData(saasVideoDetailModel.getRpcData());
        return b;
    }

    public static SaasVideoDetailModel f(VideoDetailInfo videoDetailInfo, String str) {
        return g(videoDetailInfo, null, str);
    }

    public static SaasVideoDetailModel d(SaaSVideoDetailData saaSVideoDetailData, String str) {
        VideoDetailInfo videoDetailInfo = saaSVideoDetailData.videoData;
        EpisodeLockData episodeLockData = saaSVideoDetailData.lockData;
        SaasVideoDetailModel b = b(videoDetailInfo);
        VideoPlatformType videoPlatformType = VideoPlatformType.Unknown;
        if (videoDetailInfo != null) {
            h(b, videoDetailInfo, str);
            videoPlatformType = videoDetailInfo.videoPlatform;
        }
        b.setTrailerList(e.a.b(saaSVideoDetailData.previewMaterialList, "", str, videoPlatformType));
        if (!r0.a(b.getEpisodesListWithTrail())) {
            for (int i = 0; i < b.getEpisodesListWithTrail().size(); i++) {
                b.getEpisodesListWithTrail().get(i).setVideoDetailModelVertical(Boolean.valueOf(b.getEpisodesListWithTrail().get(0).isVertical()));
            }
        }
        if (!r0.a(b.getEpisodesList())) {
            for (int i2 = 0; i2 < b.getEpisodesList().size(); i2++) {
                b.getEpisodesList().get(i2).setVideoDetailModelVertical(Boolean.valueOf(b.getEpisodesList().get(0).isVertical()));
            }
        }
        if (!r0.a(b.getTrailerList())) {
            for (int i3 = 0; i3 < b.getTrailerList().size(); i3++) {
                b.getTrailerList().get(i3).setVideoDetailModelVertical(Boolean.valueOf(b.getTrailerList().get(0).isVertical()));
            }
        }
        b.setDirData(episodeLockData);
        b.setVideoRelateBook(saaSVideoDetailData.videoRelateBook);
        b.setStyle(saaSVideoDetailData.style);
        b.setRpcData(saaSVideoDetailData);
        return b;
    }

    public static SaasVideoDetailModel g(VideoDetailInfo videoDetailInfo, EpisodeLockData episodeLockData, String str) {
        SaasVideoDetailModel b = b(videoDetailInfo);
        if (videoDetailInfo != null) {
            h(b, videoDetailInfo, str);
        }
        b.setDirData(episodeLockData);
        return b;
    }

    private static void h(SaasVideoDetailModel saasVideoDetailModel, VideoDetailInfo videoDetailInfo, String str) {
        if (saasVideoDetailModel instanceof SaasVideoDetailModelWrapper) {
            return;
        }
        saasVideoDetailModel.setEpisodesId(String.valueOf(videoDetailInfo.seriesId));
        saasVideoDetailModel.setFollowed(videoDetailInfo.followed);
        saasVideoDetailModel.setFollowedCnt(videoDetailInfo.followedCnt);
        saasVideoDetailModel.setEpisodeCnt(videoDetailInfo.episodeCnt);
        saasVideoDetailModel.setSeasonIndex(videoDetailInfo.seasonIndex);
        saasVideoDetailModel.setEpisodesStatus(videoDetailInfo.seriesStatus);
        saasVideoDetailModel.setEpisodesList(e.a.b(videoDetailInfo.videoList, videoDetailInfo.seriesColorHex, str, videoDetailInfo.videoPlatform));
        saasVideoDetailModel.setEpisodesTitle(videoDetailInfo.seriesTitle);
        saasVideoDetailModel.setVideoContentType(videoDetailInfo.contentType);
        saasVideoDetailModel.setDuration(videoDetailInfo.duration);
        saasVideoDetailModel.setDetailRecTagList(videoDetailInfo.detailRecTags);
        saasVideoDetailModel.setVideoCategoryType(videoDetailInfo.videoCategoryType);
        saasVideoDetailModel.setEnableVisionProduct(videoDetailInfo.enableVisionProduct);
        InsertAdRitType insertAdRitType = videoDetailInfo.insertAdRitType;
        if (insertAdRitType != null) {
            saasVideoDetailModel.setInsertAdRitType(insertAdRitType.getValue());
        }
        saasVideoDetailModel.setVideoRecordInfo(videoDetailInfo.recordInfo);
        saasVideoDetailModel.setSecondaryInfoList(videoDetailInfo.secondaryInfos);
        saasVideoDetailModel.setAbstractSecondaryInfoList(videoDetailInfo.abstractTags);
        saasVideoDetailModel.setSeriesIntro(videoDetailInfo.seriesIntro);
        saasVideoDetailModel.setEpisodesPlayCount(videoDetailInfo.seriesPlayCnt);
        saasVideoDetailModel.setEpisodesListCountText(videoDetailInfo.episodeRightText);
        saasVideoDetailModel.setEpisodesIntroduction(videoDetailInfo.seriesIntro);
        saasVideoDetailModel.setVideoPlatformType(videoDetailInfo.videoPlatform);
        saasVideoDetailModel.setSeriesColorHex(videoDetailInfo.seriesColorHex);
        saasVideoDetailModel.setUgcUserInfo(videoDetailInfo.ugcUserInfo);
        VideoBottomBar videoBottomBar = videoDetailInfo.bottomBar;
        if (videoBottomBar != null) {
            saasVideoDetailModel.setVideoBottomBar(d.a.l(videoBottomBar));
        }
        saasVideoDetailModel.setRelatedAlbumId(videoDetailInfo.relatedAlbumId);
        VideoTagInfo videoTagInfo = videoDetailInfo.videoTagInfo;
        if (videoTagInfo != null) {
            try {
                saasVideoDetailModel.setVideoTagInfo(i(videoTagInfo));
            } catch (JSONException unused) {
            }
        }
        saasVideoDetailModel.setRecTagList(videoDetailInfo.recTags);
        saasVideoDetailModel.setBigImages(videoDetailInfo.bigImages);
        saasVideoDetailModel.setMainCreates(videoDetailInfo.mainCreatorUsers);
        if (!r0.a(videoDetailInfo.videoDetailList)) {
            saasVideoDetailModel.setBindVideoDetail(e((VideoDetailInfo) videoDetailInfo.videoDetailList.get(0)));
        }
        saasVideoDetailModel.setCategorySchema((List) JSONUtils.fromJson(videoDetailInfo.categorySchema, new a().getType()));
        if (videoDetailInfo.videoList != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < videoDetailInfo.videoList.size(); i++) {
                SaasVideoDirectoryItem saasVideoDirectoryItem = new SaasVideoDirectoryItem();
                saasVideoDirectoryItem.videoId = ((EpisodeInfo) videoDetailInfo.videoList.get(i)).vid;
                saasVideoDirectoryItem.needUnlock = ((EpisodeInfo) videoDetailInfo.videoList.get(i)).needUnlock;
                saasVideoDirectoryItem.waitFree = ((EpisodeInfo) videoDetailInfo.videoList.get(i)).waitFree;
                saasVideoDirectoryItem.trialDuration = ((EpisodeInfo) videoDetailInfo.videoList.get(i)).trialDuration;
                arrayList.add(saasVideoDirectoryItem);
            }
            saasVideoDetailModel.setDirectoryItems(arrayList);
        }
        saasVideoDetailModel.setDisableInsertAd(videoDetailInfo.disableInsertAd);
        saasVideoDetailModel.setRecommendInfo(videoDetailInfo.recommendInfo);
        saasVideoDetailModel.setRecommendGroupId(videoDetailInfo.recommendGroupId);
        saasVideoDetailModel.setPayInfo(videoDetailInfo.payInfo);
        saasVideoDetailModel.setVideoUpdateInfo(videoDetailInfo.updateInfo);
        saasVideoDetailModel.setEpisodeTotalCnt(videoDetailInfo.episodeTotalCnt);
        saasVideoDetailModel.setVideoShareInfo(videoDetailInfo.shareInfo);
        saasVideoDetailModel.setCelebrityList(videoDetailInfo.celebrities);
        List<String> list = videoDetailInfo.seriesSubTitleList;
        if (list != null) {
            saasVideoDetailModel.setSeriesSubTitleList(list);
        }
        saasVideoDetailModel.setEpisodesCover(videoDetailInfo.seriesCover);
        if (!r0.a(saasVideoDetailModel.getEpisodesListWithTrail())) {
            for (int i2 = 0; i2 < saasVideoDetailModel.getEpisodesListWithTrail().size(); i2++) {
                ((tq3.e) ShortSeriesApi.Companion.c().getDocker().d(tq3.e.class)).M2(saasVideoDetailModel.getEpisodesListWithTrail().get(i2));
            }
        }
        UseStatus useStatus = videoDetailInfo.status;
        if (useStatus != null) {
            saasVideoDetailModel.setUseStatus(useStatus);
        }
        DownloadConfig downloadConfig = videoDetailInfo.downloadConfig;
        if (downloadConfig != null) {
            saasVideoDetailModel.setCanShowDownloadIcon(downloadConfig.canDownload);
        }
        saasVideoDetailModel.setOnlineSubscribed(videoDetailInfo.onlineSubscribed);
        saasVideoDetailModel.setOnlineTime(videoDetailInfo.onlineTime);
        saasVideoDetailModel.setSubTitleList(videoDetailInfo.subTitleList);
        saasVideoDetailModel.setMainCreates(videoDetailInfo.mainCreatorUsers);
        saasVideoDetailModel.setSupportListen(videoDetailInfo.supportListen);
        if (videoDetailInfo.aiUsageType != null) {
            saasVideoDetailModel.setAiUsageType(r7.getValue());
        }
        String str2 = videoDetailInfo.playBtnSchema;
        if (str2 != null) {
            saasVideoDetailModel.setPlayBtnSchema(str2);
        }
        saasVideoDetailModel.setCreateTime(videoDetailInfo.createTime);
        String str3 = videoDetailInfo.videoCategoryType;
        if (str3 != null) {
            saasVideoDetailModel.putExtraData("video_category_type", str3);
        }
    }
}
