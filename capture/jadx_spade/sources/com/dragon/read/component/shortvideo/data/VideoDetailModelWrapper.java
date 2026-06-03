package com.dragon.read.component.shortvideo.data;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDataWrapper;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoDetailModelWrapper extends SaasVideoDataWrapper {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private boolean coldStartSeries;
    private boolean isSeriesPlayed;
    private boolean needUnlock;
    private int playEndCnt;

    public static final class a {
        static {
            Covode.recordClassIndex(599031);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599030);
        Companion = new a(null);
    }

    public final boolean getColdStartSeries() {
        return this.coldStartSeries;
    }

    public final boolean getNeedUnlock() {
        return this.needUnlock;
    }

    public final int getPlayEndCnt() {
        return this.playEndCnt;
    }

    public final boolean isSeriesPlayed() {
        return this.isSeriesPlayed;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDataWrapper, com.dragon.read.component.shortvideo.data.saas.video.d
    public SaasVideoDetailModel getFromDetailModel() {
        return getMDetailModel();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDataWrapper, com.dragon.read.component.shortvideo.data.saas.video.d
    public SaasVideoData getVideoData() {
        return getMVideoData();
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDataWrapper, com.dragon.read.component.shortvideo.data.saas.video.d
    public int getVideoScene() {
        return getMVideoScene();
    }

    public String toString() {
        return "VideoDetailModelWrapper(hash = " + hashCode() + ", videoDetailModel=" + getMDetailModel() + ')';
    }

    public final void setColdStartSeries(boolean z) {
        this.coldStartSeries = z;
    }

    public final void setNeedUnlock(boolean z) {
        this.needUnlock = z;
    }

    public final void setPlayEndCnt(int i) {
        this.playEndCnt = i;
    }

    public final void setSeriesPlayed(boolean z) {
        this.isSeriesPlayed = z;
    }

    public VideoDetailModelWrapper(SaasVideoDetailModel saasVideoDetailModel, SaasVideoData saasVideoData, int i) {
        super(saasVideoDetailModel, saasVideoData, i);
    }
}
