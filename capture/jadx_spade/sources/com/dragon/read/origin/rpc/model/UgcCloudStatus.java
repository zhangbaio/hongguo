package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcCloudStatus {
    Reviewing(0),
    Pass(1),
    Reject(2),
    Deleted(3),
    Reported(4),
    HighReviewDel(5),
    Draft(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613496);
    }

    public static UgcCloudStatus findByValue(int i) {
        switch (i) {
            case 0:
                return Reviewing;
            case 1:
                return Pass;
            case 2:
                return Reject;
            case 3:
                return Deleted;
            case 4:
                return Reported;
            case 5:
                return HighReviewDel;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Draft;
            default:
                return null;
        }
    }

    UgcCloudStatus(int i) {
        this.value = i;
    }
}
