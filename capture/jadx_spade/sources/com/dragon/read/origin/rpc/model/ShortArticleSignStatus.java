package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ShortArticleSignStatus {
    NOT_SIGN(0),
    NEED_ASSESS(1),
    CAN_APPLY(2),
    SIGN_ASSESS(3),
    CAN_SIGN(4),
    SIGNED(5),
    ASSESS_REJECT(6),
    STOPPED(7);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613448);
    }

    public static ShortArticleSignStatus findByValue(int i) {
        switch (i) {
            case 0:
                return NOT_SIGN;
            case 1:
                return NEED_ASSESS;
            case 2:
                return CAN_APPLY;
            case 3:
                return SIGN_ASSESS;
            case 4:
                return CAN_SIGN;
            case 5:
                return SIGNED;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return ASSESS_REJECT;
            case 7:
                return STOPPED;
            default:
                return null;
        }
    }

    ShortArticleSignStatus(int i) {
        this.value = i;
    }
}
