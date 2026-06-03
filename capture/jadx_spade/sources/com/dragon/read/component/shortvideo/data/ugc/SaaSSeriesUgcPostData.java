package com.dragon.read.component.shortvideo.data.ugc;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ps3.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaaSSeriesUgcPostData extends SaaSUgcPostData {
    public static final a Companion;
    private int insertFromScene;
    private boolean reportedShowOnce;
    private String trailerTitle = "";
    private SaasVideoDetailModel videoDetailModel;

    public static final class a {
        static {
            Covode.recordClassIndex(599131);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599130);
        Companion = new a(null);
    }

    public final SaasVideoDetailModel getBindDetailModel() {
        return this.videoDetailModel;
    }

    public final int getInsertFromScene() {
        return this.insertFromScene;
    }

    public final boolean getReportedShowOnce() {
        return this.reportedShowOnce;
    }

    public final String getTrailerTitle() {
        return this.trailerTitle;
    }

    public final boolean getMIsInsertedFromFeed() {
        if (this.insertFromScene > 0) {
            return true;
        }
        return false;
    }

    public final SaaSSeriesUgcPostData clone() {
        SaaSSeriesUgcPostData saaSSeriesUgcPostData = new SaaSSeriesUgcPostData();
        c.a.a(this, saaSSeriesUgcPostData);
        return saaSSeriesUgcPostData;
    }

    public final void setBindDetailModel(SaasVideoDetailModel saasVideoDetailModel) {
        this.videoDetailModel = saasVideoDetailModel;
    }

    public final void setInsertFromScene(int i) {
        this.insertFromScene = i;
    }

    public final void setReportedShowOnce(boolean z) {
        this.reportedShowOnce = z;
    }

    public final void setTrailerTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.trailerTitle = str;
    }
}
