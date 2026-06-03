package com.dragon.read.component.shortvideo.data.ugc;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.c;
import com.dragon.read.component.shortvideo.data.saas.video.d;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaaSUgcPostDataWrapper implements d, Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private AlbumDetailModel mAlbumDetailModel;
    private int mVideoScene;
    private final SaaSUgcPostData postData;

    public static final class a {
        static {
            Covode.recordClassIndex(599137);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599136);
        Companion = new a(null);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.d
    public /* bridge */ /* synthetic */ Map getExtraData() {
        return c.a(this);
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.d
    public AlbumDetailModel getFromDetailModel() {
        return this.mAlbumDetailModel;
    }

    public final AlbumDetailModel getMAlbumDetailModel() {
        return this.mAlbumDetailModel;
    }

    public final int getMVideoScene() {
        return this.mVideoScene;
    }

    public final SaaSUgcPostData getPostData() {
        return this.postData;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.d
    public SaaSUgcPostData getVideoData() {
        return this.postData;
    }

    @Override // com.dragon.read.component.shortvideo.data.saas.video.d
    public int getVideoScene() {
        return this.mVideoScene;
    }

    public final void setAlbumDetailModel(AlbumDetailModel albumDetailModel) {
        this.mAlbumDetailModel = albumDetailModel;
    }

    public final void setMAlbumDetailModel(AlbumDetailModel albumDetailModel) {
        this.mAlbumDetailModel = albumDetailModel;
    }

    public final void setMVideoScene(int i) {
        this.mVideoScene = i;
    }

    public final void setVideoScene(int i) {
        this.mVideoScene = i;
    }

    public SaaSUgcPostDataWrapper(AlbumDetailModel albumDetailModel, SaaSUgcPostData postData, int i) {
        Intrinsics.checkNotNullParameter(postData, "postData");
        this.mAlbumDetailModel = albumDetailModel;
        this.postData = postData;
        this.mVideoScene = i;
    }
}
