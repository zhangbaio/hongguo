package ps3;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.ListUtils;
import com.dragon.read.component.shortvideo.data.saas.rpcmodel.SaaSVideoBottomBar;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.dragon.read.component.shortvideo.data.ugc.AlbumDetailModel;
import com.dragon.read.component.shortvideo.data.ugc.SaaSSeriesUgcPostData;
import com.dragon.read.component.shortvideo.data.ugc.SaaSSeriesUgcPostDataWrapper;
import com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostData;
import com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostDataWrapper;
import com.dragon.read.component.shortvideo.data.ugc.SaasUserBaseInfo;
import com.dragon.read.component.shortvideo.data.ugc.SaasUserTag;
import com.dragon.read.component.shortvideo.data.ugc.SaasUserTitleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.EpisodeInfo;
import seriessdk.com.dragon.read.saas.rpc.model.SaaSVideoDetailData;
import seriessdk.com.dragon.read.saas.rpc.model.SaasBookInfo;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;
import seriessdk.com.dragon.read.saas.rpc.model.UgcUserInfo;
import seriessdk.com.dragon.read.saas.rpc.model.UserBaseInfo;
import seriessdk.com.dragon.read.saas.rpc.model.UserTag;
import seriessdk.com.dragon.read.saas.rpc.model.UserTitleV2;
import seriessdk.com.dragon.read.saas.rpc.model.VideoBottomBar;
import seriessdk.com.dragon.read.saas.rpc.model.VideoDetailInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoRecordInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoRelateBook;
import seriessdk.com.dragon.read.saas.rpc.model.VideoSeriesIdType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final d a;

    static {
        Covode.recordClassIndex(599026);
        a = new d();
    }

    private d() {
    }

    private final SaasUserBaseInfo h(UserBaseInfo userBaseInfo) {
        if (userBaseInfo == null) {
            return null;
        }
        SaasUserBaseInfo saasUserBaseInfo = new SaasUserBaseInfo();
        saasUserBaseInfo.setActorID(Long.valueOf(userBaseInfo.actorID));
        return saasUserBaseInfo;
    }

    private final SaasUserTitleInfo k(UserTitleV2 userTitleV2) {
        if (userTitleV2 == null) {
            return null;
        }
        SaasUserTitleInfo saasUserTitleInfo = new SaasUserTitleInfo();
        saasUserTitleInfo.setEnTitle(userTitleV2.enTitle);
        saasUserTitleInfo.setZhTitle(userTitleV2.zhTitle);
        saasUserTitleInfo.setLabel(userTitleV2.label);
        return saasUserTitleInfo;
    }

    private final SaasUserTag j(UserTag userTag) {
        if (userTag == null) {
            return null;
        }
        SaasUserTag saasUserTag = new SaasUserTag();
        ArrayList arrayList = new ArrayList();
        List list = userTag.userTitleInfo;
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                SaasUserTitleInfo k = a.k((UserTitleV2) it2.next());
                if (k != null) {
                    arrayList.add(k);
                }
            }
        }
        saasUserTag.setUserTitleInfo(arrayList);
        return saasUserTag;
    }

    public final List<SecondaryInfo> a(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            SecondaryInfo secondaryInfo = new SecondaryInfo();
            secondaryInfo.content = str;
            arrayList.add(secondaryInfo);
        }
        return arrayList;
    }

    public final SaaSVideoBottomBar l(VideoBottomBar videoBottomBar) {
        Intrinsics.checkNotNullParameter(videoBottomBar, "videoBottomBar");
        SaaSVideoBottomBar saaSVideoBottomBar = new SaaSVideoBottomBar();
        String bottomBarType = videoBottomBar.bottomBarType;
        Intrinsics.checkNotNullExpressionValue(bottomBarType, "bottomBarType");
        saaSVideoBottomBar.setType(bottomBarType);
        saaSVideoBottomBar.setGroupId(videoBottomBar.relatedGroupId);
        saaSVideoBottomBar.setTextList(videoBottomBar.text);
        saaSVideoBottomBar.setSchema(videoBottomBar.schema);
        saaSVideoBottomBar.setIconUrl(videoBottomBar.iconUrl);
        return saaSVideoBottomBar;
    }

    public final String b(UgcUserInfo ugcUserInfo) {
        String str;
        long j;
        String str2;
        List<SaasUserTitleInfo> list;
        Long actorID;
        if (ugcUserInfo == null) {
            return null;
        }
        Map map = ugcUserInfo.expandExtra;
        SaasUserTag j2 = j(ugcUserInfo.userTag);
        SaasUserBaseInfo h = h(ugcUserInfo.baseInfo);
        if (map != null) {
            str = (String) map.get("brand_id");
        } else {
            str = null;
        }
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(str);
        if (h != null && (actorID = h.getActorID()) != null) {
            j = actorID.longValue();
        } else {
            j = 0;
        }
        if (j <= 0) {
            z = false;
        }
        if (z2) {
            str2 = "video_producer_8662";
        } else if (z) {
            str2 = "actor_8662";
        } else {
            str2 = "me";
        }
        if (j2 != null) {
            list = j2.getUserTitleInfo();
        } else {
            list = null;
        }
        SaasUserTitleInfo c = c(str2, list);
        if (c == null) {
            return null;
        }
        return c.getLabel();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0035, code lost:
    
        if (r1 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.dragon.read.component.shortvideo.data.ugc.SaaSPostUserInfo i(seriessdk.com.dragon.read.saas.rpc.model.UgcUserInfo r6) {
        /*
            r5 = this;
            java.lang.String r0 = "userInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.dragon.read.component.shortvideo.data.ugc.SaaSPostUserInfo r0 = new com.dragon.read.component.shortvideo.data.ugc.SaaSPostUserInfo
            r0.<init>()
            java.lang.String r1 = r6.userID
            java.lang.String r2 = "userID"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.setUserId(r1)
            seriessdk.com.dragon.read.saas.rpc.model.UserBaseInfo r1 = r6.baseInfo
            java.lang.String r1 = r1.userAvatar
            java.lang.String r2 = "userAvatar"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.setUserAvatar(r1)
            seriessdk.com.dragon.read.saas.rpc.model.UserTag r1 = r6.userTag
            java.util.List r1 = r1.avatarDecorationList
            java.lang.String r2 = ""
            if (r1 == 0) goto L37
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r1)
            seriessdk.com.dragon.read.saas.rpc.model.AvatarDecoration r1 = (seriessdk.com.dragon.read.saas.rpc.model.AvatarDecoration) r1
            if (r1 == 0) goto L37
            java.lang.String r1 = r1.url
            if (r1 != 0) goto L38
        L37:
            r1 = r2
        L38:
            r0.setAvatarDecorationUrl(r1)
            seriessdk.com.dragon.read.saas.rpc.model.UserTag r1 = r6.userTag
            java.util.List r1 = r1.avatarDecorationList
            if (r1 == 0) goto L57
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r1)
            seriessdk.com.dragon.read.saas.rpc.model.AvatarDecoration r1 = (seriessdk.com.dragon.read.saas.rpc.model.AvatarDecoration) r1
            if (r1 == 0) goto L57
            long r3 = r1.iD
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L56
            goto L57
        L56:
            r2 = r1
        L57:
            r0.setAvatarDecorationId(r2)
            seriessdk.com.dragon.read.saas.rpc.model.UserBaseInfo r1 = r6.baseInfo
            java.lang.String r1 = r1.userName
            java.lang.String r2 = "userName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.setUserName(r1)
            seriessdk.com.dragon.read.saas.rpc.model.UserRelation r1 = r6.userRelation
            r2 = 0
            if (r1 == 0) goto L79
            seriessdk.com.dragon.read.saas.rpc.model.UserRelationType r1 = r1.relationType
            if (r1 == 0) goto L79
            int r1 = r1.getValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L7a
        L79:
            r1 = r2
        L7a:
            r0.setRelationType(r1)
            ps3.d r1 = ps3.d.a
            java.lang.String r1 = r1.b(r6)
            r0.setLabel(r1)
            com.dragon.read.component.shortvideo.data.ugc.SaasUserTag r1 = new com.dragon.read.component.shortvideo.data.ugc.SaasUserTag
            r1.<init>()
            seriessdk.com.dragon.read.saas.rpc.model.UserTag r3 = r6.userTag
            if (r3 == 0) goto L9c
            seriessdk.com.dragon.read.saas.rpc.model.UgcCreatorType r3 = r3.creatorType
            if (r3 == 0) goto L9c
            int r3 = r3.getValue()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L9d
        L9c:
            r3 = r2
        L9d:
            r1.setCreatorType(r3)
            seriessdk.com.dragon.read.saas.rpc.model.UserRelation r6 = r6.userRelation
            if (r6 == 0) goto Laa
            boolean r6 = r6.isTopConsume
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r6)
        Laa:
            r1.setTopConsume(r2)
            r0.setUserTag(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ps3.d.i(seriessdk.com.dragon.read.saas.rpc.model.UgcUserInfo):com.dragon.read.component.shortvideo.data.ugc.SaaSPostUserInfo");
    }

    private final SaasUserTitleInfo c(String str, List<SaasUserTitleInfo> list) {
        Object obj = null;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        Intrinsics.checkNotNull(list);
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (TextUtils.equals(str, ((SaasUserTitleInfo) next).getEnTitle())) {
                obj = next;
                break;
            }
        }
        return (SaasUserTitleInfo) obj;
    }

    public final SaaSSeriesUgcPostData e(SaaSSeriesUgcPostData data, SaasVideoDetailModel videoDetail) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(videoDetail, "videoDetail");
        f(data, videoDetail);
        SaasVideoDetailModel bindVideoDetail = videoDetail.getBindVideoDetail();
        if (bindVideoDetail != null) {
            bindVideoDetail.setSecondaryInfoList(videoDetail.getSecondaryInfoList());
            bindVideoDetail.setAbstractSecondaryInfoList(videoDetail.getAbstractSecondaryInfoList());
            bindVideoDetail.setRecTagList(videoDetail.getRecTagList());
            bindVideoDetail.setVideoTagInfo(videoDetail.getVideoTagInfo());
            bindVideoDetail.setVideoCategoryType(videoDetail.getVideoCategoryType());
            SaasVideoDetailModel bindVideoDetail2 = videoDetail.getBindVideoDetail();
            if (bindVideoDetail2 != null) {
                str = bindVideoDetail2.getPlayBtnSchema();
            } else {
                str = null;
            }
            bindVideoDetail.setPlayBtnSchema(str);
            bindVideoDetail.setRecommendInfo(videoDetail.getRecommendInfo());
            bindVideoDetail.setRecommendGroupId(videoDetail.getRecommendGroupId());
            bindVideoDetail.setUgcRelated(true);
            data.setSeriesId(bindVideoDetail.getEpisodesId());
            data.setEpisodesId(bindVideoDetail.getEpisodesId());
            data.setSecondaryInfoList(bindVideoDetail.getSecondaryInfoList());
            data.setAbstractSecondaryInfoList(bindVideoDetail.getAbstractSecondaryInfoList());
            data.setBindDetailModel(bindVideoDetail);
        }
        return data;
    }

    public final void f(SaaSUgcPostData data, SaasVideoDetailModel videoDetail) {
        SaasBookInfo saasBookInfo;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(videoDetail, "videoDetail");
        SaasVideoData saasVideoData = videoDetail.getEpisodesList().get(0);
        if (saasVideoData == null) {
            return;
        }
        data.setVid(saasVideoData.getVid());
        data.setVideoSeriesIdType(VideoSeriesIdType.SeriesId);
        data.setContentType(saasVideoData.getContentType());
        data.setTitle(saasVideoData.getVideoDesc());
        data.setSeriesName(saasVideoData.getTitle());
        data.setHasDigg(saasVideoData.isHasDigg());
        data.setVideoCategoryType(videoDetail.getVideoCategoryType());
        data.setDiggCount(saasVideoData.getDiggCount());
        data.setRecommendInfo(videoDetail.getRecommendInfo());
        data.setRecommendGroupId(videoDetail.getRecommendGroupId());
        data.setCover(saasVideoData.getCover());
        data.setVertical(saasVideoData.isVertical());
        data.setDuration(saasVideoData.getDuration());
        data.setPrivate(saasVideoData.isPrivate());
        data.setPlayCnt(videoDetail.getEpisodesPlayCount());
        data.setEnableVisionProduct(videoDetail.isEnableVisionProduct());
        data.setVideoRecordInfo(videoDetail.getVideoRecordInfo());
        data.setSupportListen(videoDetail.isSupportListen());
        data.setSecondaryInfoList(videoDetail.getSecondaryInfoList());
        data.setAbstractSecondaryInfoList(videoDetail.getAbstractSecondaryInfoList());
        data.setBgColorHex(saasVideoData.getBgColorHex());
        UgcUserInfo ugcUserInfo = videoDetail.getUgcUserInfo();
        if (ugcUserInfo != null) {
            data.setUserInfo(a.i(ugcUserInfo));
        }
        data.setAiUsageType(videoDetail.getAiUsageType());
        SaaSVideoBottomBar videoBottomBar = videoDetail.getVideoBottomBar();
        if (videoBottomBar != null) {
            data.setBottomBar(videoBottomBar);
        }
        data.setRelatedAlbumId(videoDetail.getRelatedAlbumId());
        VideoRecordInfo videoRecordInfo = videoDetail.getVideoRecordInfo();
        if (videoRecordInfo != null) {
            data.setVideoRecordInfo(videoRecordInfo);
        }
        data.setFollowedCount(videoDetail.getFollowedCnt());
        data.setSeriesPlayCnt(saasVideoData.getEpisodesCount());
        data.setRelatedAlbumId(videoDetail.getRelatedAlbumId());
        data.setVideoShareInfo(videoDetail.getVideoShareInfo());
        VideoRelateBook videoRelateBook = videoDetail.getVideoRelateBook();
        if (videoRelateBook != null) {
            saasBookInfo = videoRelateBook.bookInfo;
        } else {
            saasBookInfo = null;
        }
        data.setRecBookData(saasBookInfo);
        data.setCreateTime(Long.valueOf(videoDetail.getCreateTime()));
    }

    public final List<com.dragon.read.component.shortvideo.data.saas.video.d> d(AlbumDetailModel albumDetailModel, List<? extends SaaSUgcPostData> list, int i) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SaaSUgcPostData saaSUgcPostData : list) {
                if (saaSUgcPostData instanceof SaaSSeriesUgcPostData) {
                    arrayList.add(new SaaSSeriesUgcPostDataWrapper(albumDetailModel, (SaaSSeriesUgcPostData) saaSUgcPostData, i));
                } else {
                    arrayList.add(new SaaSUgcPostDataWrapper(albumDetailModel, saaSUgcPostData, i));
                }
            }
        }
        return arrayList;
    }

    public final void g(SaaSUgcPostData data, SaasVideoDetailModel videoDetail, Map<String, ? extends SaaSVideoDetailData> map) {
        Object firstOrNull;
        boolean z;
        Object firstOrNull2;
        String str;
        VideoDetailInfo videoDetailInfo;
        List list;
        Object firstOrNull3;
        Object firstOrNull4;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(videoDetail, "videoDetail");
        data.setVideoSeriesIdType(VideoSeriesIdType.SeriesId);
        data.setTitle(videoDetail.getEpisodesTitle());
        data.setContentType(videoDetail.getVideoContentType());
        data.setCover(videoDetail.getEpisodesCover());
        data.setEpisodesId(videoDetail.getEpisodesId());
        data.setVid(videoDetail.getEpisodesId());
        List<String> seriesSubTitleList = videoDetail.getSeriesSubTitleList();
        Intrinsics.checkNotNullExpressionValue(seriesSubTitleList, "getSeriesSubTitleList(...)");
        data.setSubTitleList(a(seriesSubTitleList));
        List<SaasVideoData> episodesList = videoDetail.getEpisodesList();
        Intrinsics.checkNotNullExpressionValue(episodesList, "getEpisodesList(...)");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) episodesList);
        SaasVideoData saasVideoData = (SaasVideoData) firstOrNull;
        if (saasVideoData != null) {
            z = saasVideoData.isVertical();
        } else {
            z = false;
        }
        data.setVertical(z);
        List<SaasVideoData> episodesList2 = videoDetail.getEpisodesList();
        Intrinsics.checkNotNullExpressionValue(episodesList2, "getEpisodesList(...)");
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) episodesList2);
        SaasVideoData saasVideoData2 = (SaasVideoData) firstOrNull2;
        if (saasVideoData2 == null || (str = saasVideoData2.getBgColorHex()) == null) {
            str = null;
            if (map != null) {
                if (!(!map.isEmpty())) {
                    map = null;
                }
                if (map != null) {
                    SaaSVideoDetailData saaSVideoDetailData = map.get(data.getVid());
                    if (saaSVideoDetailData == null) {
                        firstOrNull4 = CollectionsKt___CollectionsKt.firstOrNull(map.keySet());
                        String str2 = (String) firstOrNull4;
                        if (str2 == null) {
                            str2 = "";
                        }
                        saaSVideoDetailData = map.get(str2);
                    }
                    if (saaSVideoDetailData != null && (videoDetailInfo = saaSVideoDetailData.videoData) != null && (list = videoDetailInfo.videoList) != null) {
                        firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                        EpisodeInfo episodeInfo = (EpisodeInfo) firstOrNull3;
                        if (episodeInfo != null) {
                            str = episodeInfo.videoBgColorHex;
                        }
                    }
                }
            }
        }
        data.setBgColorHex(str);
        data.setSupportListen(videoDetail.isSupportListen());
        data.setRelatedAlbumId(videoDetail.getRelatedAlbumId());
        data.setEnableVisionProduct(videoDetail.isEnableVisionProduct());
        data.setVideoRecordInfo(videoDetail.getVideoRecordInfo());
    }
}
