package com.dragon.read.component.shortvideo.data.saas.video;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaasVideoDataWrapper implements d, Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private final Map<String, Object> extraDataMap = new HashMap();
    private SaasVideoDetailModel mDetailModel;
    private SaasVideoData mVideoData;
    private int mVideoScene;

    public static final class a {
        static {
            Covode.recordClassIndex(599121);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599120);
        Companion = new a(null);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.d
    public Map<String, Object> getExtraData() {
        return this.extraDataMap;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.d
    public SaasVideoDetailModel getFromDetailModel() {
        return this.mDetailModel;
    }

    public final SaasVideoDetailModel getMDetailModel() {
        return this.mDetailModel;
    }

    public final SaasVideoData getMVideoData() {
        return this.mVideoData;
    }

    public final int getMVideoScene() {
        return this.mVideoScene;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.d
    public SaasVideoData getVideoData() {
        return this.mVideoData;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.d
    public int getVideoScene() {
        return this.mVideoScene;
    }

    public final void setMDetailModel(SaasVideoDetailModel saasVideoDetailModel) {
        this.mDetailModel = saasVideoDetailModel;
    }

    public final void setMVideoData(SaasVideoData saasVideoData) {
        this.mVideoData = saasVideoData;
    }

    public final void setMVideoScene(int i) {
        this.mVideoScene = i;
    }

    public final void setVideoScene(int i) {
        this.mVideoScene = i;
    }

    public final void setVideoData(SaasVideoData videoData) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        this.mVideoData = videoData;
    }

    public SaasVideoDataWrapper(SaasVideoDetailModel saasVideoDetailModel, SaasVideoData saasVideoData, int i) {
        String str;
        List<SaasVideoData> episodesListWithTrail;
        this.mDetailModel = saasVideoDetailModel;
        this.mVideoData = saasVideoData;
        this.mVideoScene = i;
        SaasVideoData saasVideoData2 = this.mVideoData;
        SaasVideoData saasVideoData3 = null;
        if (saasVideoData2 != null) {
            str = saasVideoData2.getVid();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            SaasVideoDetailModel saasVideoDetailModel2 = this.mDetailModel;
            if (saasVideoDetailModel2 != null && (episodesListWithTrail = saasVideoDetailModel2.getEpisodesListWithTrail()) != null) {
                saasVideoData3 = (SaasVideoData) CollectionsKt___CollectionsKt.getOrNull(episodesListWithTrail, 0);
            }
            if (saasVideoData3 != null) {
                this.mVideoData = saasVideoData3;
            }
        }
    }
}
