package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum InviteStatus {
    INVITING(0),
    ACCEPTED(1),
    REJECTED(2),
    EXITED(3),
    AUDITING(4),
    AUDIT_UNPASS(5),
    NOT_EFFECTIVE(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613207);
    }

    public static InviteStatus findByValue(int i) {
        switch (i) {
            case 0:
                return INVITING;
            case 1:
                return ACCEPTED;
            case 2:
                return REJECTED;
            case 3:
                return EXITED;
            case 4:
                return AUDITING;
            case 5:
                return AUDIT_UNPASS;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return NOT_EFFECTIVE;
            default:
                return null;
        }
    }

    InviteStatus(int i) {
        this.value = i;
    }
}
