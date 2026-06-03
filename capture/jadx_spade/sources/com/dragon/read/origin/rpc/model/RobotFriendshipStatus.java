package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum RobotFriendshipStatus {
    Lock(1),
    Playing(2),
    UnLocked(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613376);
    }

    public static RobotFriendshipStatus findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return UnLocked;
            }
            return Playing;
        }
        return Lock;
    }

    RobotFriendshipStatus(int i) {
        this.value = i;
    }
}
