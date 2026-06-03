package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PraiseSupportStatus {
    Reviewing(0),
    Reject(1),
    NotStart(2),
    InProgress(3),
    Finish(4),
    RewardReviewing(5),
    RewardReject(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613313);
    }

    public static PraiseSupportStatus findByValue(int i) {
        switch (i) {
            case 0:
                return Reviewing;
            case 1:
                return Reject;
            case 2:
                return NotStart;
            case 3:
                return InProgress;
            case 4:
                return Finish;
            case 5:
                return RewardReviewing;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return RewardReject;
            default:
                return null;
        }
    }

    PraiseSupportStatus(int i) {
        this.value = i;
    }
}
