package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletChapterPublishStatus {
    Publishable(1),
    Published(2),
    PartiallyPublished(3),
    Unpublishable(-1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613289);
    }

    public static PlayletChapterPublishStatus findByValue(int i) {
        if (i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return PartiallyPublished;
                }
                return Published;
            }
            return Publishable;
        }
        return Unpublishable;
    }

    PlayletChapterPublishStatus(int i) {
        this.value = i;
    }
}
