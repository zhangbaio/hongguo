package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum TopicStatus {
    TopicStatusNotKnow(-1),
    TopicStatusReviewing(0),
    TopicStatusNotPass(1),
    TopicStatusPass(2),
    TopicStatusModifyNotPASS(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613483);
    }

    public static TopicStatus findByValue(int i) {
        if (i != -1) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return TopicStatusModifyNotPASS;
                    }
                    return TopicStatusPass;
                }
                return TopicStatusNotPass;
            }
            return TopicStatusReviewing;
        }
        return TopicStatusNotKnow;
    }

    TopicStatus(int i) {
        this.value = i;
    }
}
