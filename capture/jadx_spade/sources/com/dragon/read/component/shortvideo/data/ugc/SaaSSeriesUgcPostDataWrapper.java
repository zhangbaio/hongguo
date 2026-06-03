package com.dragon.read.component.shortvideo.data.ugc;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.dragon.read.component.shortvideo.data.saas.video.c;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaaSSeriesUgcPostDataWrapper extends SaaSUgcPostDataWrapper {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private final SaaSSeriesUgcPostData postSeriesData;

    public static final class a {
        static {
            Covode.recordClassIndex(599133);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599132);
        Companion = new a(null);
    }

    @Override // com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostDataWrapper, com.dragon.read.component.shortvideo.data.saas.video.d
    public /* bridge */ /* synthetic */ Map getExtraData() {
        return c.a(this);
    }

    public final SaaSSeriesUgcPostData getPostSeriesData() {
        return this.postSeriesData;
    }

    @Override // com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostDataWrapper, com.dragon.read.component.shortvideo.data.saas.video.d
    public SaaSSeriesUgcPostData getVideoData() {
        return this.postSeriesData;
    }

    public final SaasVideoDetailModel getBindDetailModel() {
        return this.postSeriesData.getBindDetailModel();
    }

    @Override // com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostDataWrapper, com.dragon.read.component.shortvideo.data.saas.video.d
    public int getVideoScene() {
        return getMVideoScene();
    }

    @Override // com.dragon.read.component.shortvideo.data.ugc.SaaSUgcPostDataWrapper, com.dragon.read.component.shortvideo.data.saas.video.d
    public AlbumDetailModel getFromDetailModel() {
        return getMAlbumDetailModel();
    }

    public final void setBindDetailModel(SaasVideoDetailModel saasVideoDetailModel) {
        this.postSeriesData.setBindDetailModel(saasVideoDetailModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaaSSeriesUgcPostDataWrapper(AlbumDetailModel albumDetailModel, SaaSSeriesUgcPostData postSeriesData, int i) {
        super(albumDetailModel, postSeriesData, i);
        Intrinsics.checkNotNullParameter(postSeriesData, "postSeriesData");
        this.postSeriesData = postSeriesData;
    }
}
