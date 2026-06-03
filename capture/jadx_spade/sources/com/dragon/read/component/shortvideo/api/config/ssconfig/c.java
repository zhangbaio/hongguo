package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;

    static {
        Covode.recordClassIndex(598313);
        a = new c();
    }

    private c() {
    }

    public final boolean a() {
        if (!AlbumFinishPlayConfigV671.a.b() && !AlbumAutoShowNextEpisodeConfig.a.b()) {
            return false;
        }
        return true;
    }
}
