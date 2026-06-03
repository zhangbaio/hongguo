package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class x {
    static {
        Covode.recordClassIndex(611273);
    }

    public static final String a(int i) {
        if (i == VideoContentType.MotionComic.getValue()) {
            return "motion_comic";
        }
        if (i == VideoContentType.ShortSeriesPlay.getValue()) {
            return "series";
        }
        if (i == VideoContentType.Album.getValue()) {
            return "album";
        }
        if (i == VideoContentType.PUGC.getValue()) {
            return "pugc_material";
        }
        return "";
    }
}
