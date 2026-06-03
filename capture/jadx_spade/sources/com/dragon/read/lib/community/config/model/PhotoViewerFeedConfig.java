package com.dragon.read.lib.community.config.model;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PhotoViewerFeedConfig {

    @SerializedName("enable_last_view_button")
    public final boolean enableLastViewButton;

    @SerializedName("enable_scroll")
    public final boolean enableScroll;

    @SerializedName("load_more_once_count")
    public final Integer loadMoreOnceCount;

    @SerializedName("new_photo_viewer_style")
    public final boolean newPhotoViewerStyle;

    static {
        Covode.recordClassIndex(611357);
    }

    public PhotoViewerFeedConfig() {
        this(false, false, null, false, 15, null);
    }

    public PhotoViewerFeedConfig(boolean z, boolean z2, Integer num, boolean z3) {
        this.newPhotoViewerStyle = z;
        this.enableScroll = z2;
        this.loadMoreOnceCount = num;
        this.enableLastViewButton = z3;
    }

    public /* synthetic */ PhotoViewerFeedConfig(boolean z, boolean z2, Integer num, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? false : z3);
    }
}
