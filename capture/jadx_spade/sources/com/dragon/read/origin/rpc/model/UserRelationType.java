package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UserRelationType {
    None(1),
    Follow(2),
    Followed(3),
    MutualFollow(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613559);
    }

    public static UserRelationType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return MutualFollow;
                }
                return Followed;
            }
            return Follow;
        }
        return None;
    }

    UserRelationType(int i) {
        this.value = i;
    }
}
