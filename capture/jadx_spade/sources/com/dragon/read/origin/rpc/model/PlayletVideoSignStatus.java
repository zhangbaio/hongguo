package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletVideoSignStatus {
    Unassigned(0),
    Assignable(5),
    Assigned(1),
    Accepted(2),
    Rejected(3),
    Timeout(4),
    Signed(7),
    Termination(8);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613305);
    }

    public static PlayletVideoSignStatus findByValue(int i) {
        switch (i) {
            case 0:
                return Unassigned;
            case 1:
                return Assigned;
            case 2:
                return Accepted;
            case 3:
                return Rejected;
            case 4:
                return Timeout;
            case 5:
                return Assignable;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
            default:
                return null;
            case 7:
                return Signed;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return Termination;
        }
    }

    PlayletVideoSignStatus(int i) {
        this.value = i;
    }
}
