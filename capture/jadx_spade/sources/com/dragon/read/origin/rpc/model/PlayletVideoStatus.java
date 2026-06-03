package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletVideoStatus {
    Writing(1),
    Preparing(2),
    Making(3),
    Delivered(4),
    Released(5),
    Cancelled(6),
    Other(9);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613306);
    }

    public static PlayletVideoStatus findByValue(int i) {
        if (i != 9) {
            switch (i) {
                case 1:
                    return Writing;
                case 2:
                    return Preparing;
                case 3:
                    return Making;
                case 4:
                    return Delivered;
                case 5:
                    return Released;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    return Cancelled;
                default:
                    return null;
            }
        }
        return Other;
    }

    PlayletVideoStatus(int i) {
        this.value = i;
    }
}
