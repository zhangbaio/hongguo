package ps3;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.ssconfig.PlayerBugfixV645;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import java.util.ArrayList;
import java.util.List;
import seriessdk.com.dragon.read.saas.rpc.model.DisclaimerInfo;
import seriessdk.com.dragon.read.saas.rpc.model.EpisodeInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoContentType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoPlatformType;
import seriessdk.com.dragon.read.saas.rpc.model.VideoSeriesIdType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final e a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(599028);
            int[] iArr = new int[VideoContentType.values().length];
            try {
                iArr[VideoContentType.PUGC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(599027);
        a = new e();
    }

    private e() {
    }

    public final List<SaasVideoData> c(List<? extends EpisodeInfo> list, String str, VideoPlatformType videoPlatformType) {
        return b(list, str, "", videoPlatformType);
    }

    public final List<SaasVideoData> b(List<? extends EpisodeInfo> list, String str, String str2, VideoPlatformType videoPlatformType) {
        boolean z;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) != null) {
                    SaasVideoData a2 = a(list.get(i), list.size(), videoPlatformType, "", "");
                    a2.setIndexInList(i);
                    if (!TextUtils.isEmpty(str)) {
                        a2.setSeriesColorHex(str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        a2.setRecommendInfo(str2);
                    }
                    if (i + 1 < list.size()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    a2.setHasNextVideoChapter(z2);
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    public final SaasVideoData a(EpisodeInfo episodeInfo, long j, VideoPlatformType videoPlatformType, String str, String str2) {
        int i;
        VideoSeriesIdType videoSeriesIdType;
        SaasVideoData saasVideoData = new SaasVideoData();
        if (episodeInfo != null) {
            saasVideoData.setVid(episodeInfo.vid);
            saasVideoData.setSeriesId(episodeInfo.seriesId);
            saasVideoData.setCover(episodeInfo.cover);
            saasVideoData.setEpisodeCover(episodeInfo.episodeCover);
            saasVideoData.setDuration(episodeInfo.duration);
            saasVideoData.setTitle(episodeInfo.title);
            saasVideoData.setVideoDesc(episodeInfo.videoDesc);
            saasVideoData.setEpisodesId(episodeInfo.seriesId);
            saasVideoData.setDiggCount(episodeInfo.diggedCount);
            saasVideoData.setHasDigg(episodeInfo.userDigg);
            saasVideoData.setCommentCount(episodeInfo.commentCount);
            saasVideoData.setVertical(episodeInfo.vertical);
            saasVideoData.setFollowed(episodeInfo.followed);
            saasVideoData.setContentType(episodeInfo.contentType);
            saasVideoData.setRecommendInfo(str);
            saasVideoData.setRecommendGroupId(str2);
            if (PlayerBugfixV645.a.a().fixVideoModelPugc) {
                VideoContentType videoContentType = episodeInfo.contentType;
                if (videoContentType == null) {
                    i = -1;
                } else {
                    i = a.a[videoContentType.ordinal()];
                }
                if (i == 1) {
                    videoSeriesIdType = VideoSeriesIdType.SeriesId;
                } else {
                    videoSeriesIdType = VideoSeriesIdType.VideoId;
                }
                saasVideoData.setVideoSeriesIdType(videoSeriesIdType);
            }
            saasVideoData.setEpisodesCount(j);
            saasVideoData.setVideoPlatform(videoPlatformType);
            saasVideoData.setDisablePlay(episodeInfo.disablePlay);
            saasVideoData.setBgColorHex(episodeInfo.videoBgColorHex);
            saasVideoData.setVidIndex(episodeInfo.vidIndex);
            saasVideoData.setPayInfo(episodeInfo.payInfo);
            saasVideoData.setTrailer(Boolean.valueOf(episodeInfo.isPreviewMaterial));
            saasVideoData.setSecondaryInfoList(episodeInfo.secondaryInfoList);
            if (TextUtils.isEmpty(episodeInfo.vid) && !TextUtils.isEmpty(episodeInfo.relatedMaterialId)) {
                saasVideoData.setVid(episodeInfo.relatedMaterialId);
            }
            if (episodeInfo.isPreviewMaterial) {
                saasVideoData.setIsRelatedMaterialId(true);
            }
            saasVideoData.setTrialDuration(episodeInfo.trialDuration);
            DisclaimerInfo disclaimerInfo = episodeInfo.disclaimerInfo;
            if (disclaimerInfo != null) {
                saasVideoData.setDisclaimerInfo(disclaimerInfo);
            }
            saasVideoData.setPrivate(episodeInfo.isPrivate);
            saasVideoData.setNewlyUpdate(episodeInfo.isNewlyUpdate);
        }
        return saasVideoData;
    }
}
