package com.dragon.read.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BannerTaskAction {
    watch_ad(1),
    ad_free(2),
    redirect(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612017);
    }

    public static BannerTaskAction findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return redirect;
            }
            return ad_free;
        }
        return watch_ad;
    }

    BannerTaskAction(int i) {
        this.value = i;
    }
}
