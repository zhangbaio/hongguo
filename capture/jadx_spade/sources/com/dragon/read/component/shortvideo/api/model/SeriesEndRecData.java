package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesEndRecData implements Serializable {
    private RecBookData bookData;
    private boolean isShown;
    private String tagText;
    private SaasVideoData videoData;

    static {
        Covode.recordClassIndex(598791);
    }

    public final RecBookData getBookData() {
        return this.bookData;
    }

    public final String getTagText() {
        return this.tagText;
    }

    public final SaasVideoData getVideoData() {
        return this.videoData;
    }

    public final boolean isShown() {
        return this.isShown;
    }

    public final void setBookData(RecBookData recBookData) {
        this.bookData = recBookData;
    }

    public final void setShown(boolean z) {
        this.isShown = z;
    }

    public final void setTagText(String str) {
        this.tagText = str;
    }

    public final void setVideoData(SaasVideoData saasVideoData) {
        this.videoData = saasVideoData;
    }
}
