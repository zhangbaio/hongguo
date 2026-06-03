package com.dragon.read.component.shortvideo.data.ugc;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.model.videotag.SaasVideoTagInfo;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import seriessdk.com.dragon.read.saas.rpc.model.SaasBookInfo;
import seriessdk.com.dragon.read.saas.rpc.model.SecondaryInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoRecordInfo;
import seriessdk.com.dragon.read.saas.rpc.model.VideoShareInfo;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaaSUgcPostData extends SaasVideoData {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private long aiUsageType;
    private long createTime;
    private final Map<String, Object> extraDataMap = new HashMap();
    private long followedCount;
    private boolean needShowPauseBtn;
    private SaasBookInfo recBookData;
    private List<? extends SecondaryInfo> recTagList;
    private long relatedAlbumId;
    private long seriesPlayCnt;
    private SaaSPostUserInfo userInfo;
    private VideoRecordInfo videoRecordInfo;
    private VideoShareInfo videoShareInfo;
    private SaasVideoTagInfo videoTagInfo;

    public static final class a {
        static {
            Covode.recordClassIndex(599135);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599134);
        Companion = new a(null);
    }

    public final long getAiUsageType() {
        return this.aiUsageType;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData
    public Map<String, Object> getExtraData() {
        return this.extraDataMap;
    }

    public final Map<String, Object> getExtraDataMap() {
        return this.extraDataMap;
    }

    public final long getFollowedCount() {
        return this.followedCount;
    }

    public final boolean getNeedShowPauseBtn() {
        return this.needShowPauseBtn;
    }

    public final SaasBookInfo getRecBookData() {
        return this.recBookData;
    }

    public final List<SecondaryInfo> getRecTagList() {
        return this.recTagList;
    }

    public final long getRelatedAlbumId() {
        return this.relatedAlbumId;
    }

    public final long getSeriesPlayCnt() {
        return this.seriesPlayCnt;
    }

    public final SaaSPostUserInfo getUserInfo() {
        return this.userInfo;
    }

    public final VideoRecordInfo getVideoRecordInfo() {
        return this.videoRecordInfo;
    }

    public final VideoShareInfo getVideoShareInfo() {
        return this.videoShareInfo;
    }

    public final SaasVideoTagInfo getVideoTagInfo() {
        return this.videoTagInfo;
    }

    public final boolean isRecBookVideo() {
        if (this.recBookData != null) {
            return true;
        }
        return false;
    }

    public final void setAiUsageType(long j) {
        this.aiUsageType = j;
    }

    public final void setFollowedCount(long j) {
        this.followedCount = j;
    }

    public final void setNeedShowPauseBtn(boolean z) {
        this.needShowPauseBtn = z;
    }

    public final void setRecBookData(SaasBookInfo saasBookInfo) {
        this.recBookData = saasBookInfo;
    }

    public final void setRecTagList(List<? extends SecondaryInfo> list) {
        this.recTagList = list;
    }

    public final void setRelatedAlbumId(long j) {
        this.relatedAlbumId = j;
    }

    public final void setSeriesPlayCnt(long j) {
        this.seriesPlayCnt = j;
    }

    public final void setUserInfo(SaaSPostUserInfo saaSPostUserInfo) {
        this.userInfo = saaSPostUserInfo;
    }

    public final void setVideoRecordInfo(VideoRecordInfo videoRecordInfo) {
        this.videoRecordInfo = videoRecordInfo;
    }

    public final void setVideoShareInfo(VideoShareInfo videoShareInfo) {
        this.videoShareInfo = videoShareInfo;
    }

    public final void setVideoTagInfo(SaasVideoTagInfo saasVideoTagInfo) {
        this.videoTagInfo = saasVideoTagInfo;
    }

    public final void setCreateTime(Long l) {
        long j;
        if (l != null) {
            j = l.longValue();
        } else {
            j = 0;
        }
        this.createTime = j;
    }
}
