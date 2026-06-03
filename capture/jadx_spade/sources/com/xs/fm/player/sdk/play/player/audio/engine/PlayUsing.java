package com.xs.fm.player.sdk.play.player.audio.engine;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum PlayUsing {
    VID("vid"),
    VIDEO_MODEL("video_model"),
    DIRECT_URL("direct_url"),
    DIRECT_URL_USE_DATA_LOADER("direct_url_use_data_loader");

    private final String use;

    public final String getUse() {
        return this.use;
    }

    static {
        Covode.recordClassIndex(655957);
    }

    PlayUsing(String str) {
        this.use = str;
    }
}
