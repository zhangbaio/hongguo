package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum TopicCanRelease {
    TopicCanReleaseNothing(0),
    TopicCanReleaseCanRelease(1),
    TopicCanReleaseCanOffline(2),
    TopicCanReleaseCanNotReleaseNUMLimit(3),
    TopicCanReleaseCanNotOfflineVoteExist(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613481);
    }

    public static TopicCanRelease findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return TopicCanReleaseCanNotOfflineVoteExist;
                    }
                    return TopicCanReleaseCanNotReleaseNUMLimit;
                }
                return TopicCanReleaseCanOffline;
            }
            return TopicCanReleaseCanRelease;
        }
        return TopicCanReleaseNothing;
    }

    TopicCanRelease(int i) {
        this.value = i;
    }
}
