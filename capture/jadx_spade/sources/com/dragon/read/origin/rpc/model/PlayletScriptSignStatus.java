package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletScriptSignStatus {
    Unsigned(0),
    Signable(1),
    Auditing(2),
    Passed(3),
    Rejected(4),
    Returned(5),
    Waiting(6),
    Signed(7),
    Termination(8);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613297);
    }

    public static PlayletScriptSignStatus findByValue(int i) {
        switch (i) {
            case 0:
                return Unsigned;
            case 1:
                return Signable;
            case 2:
                return Auditing;
            case 3:
                return Passed;
            case 4:
                return Rejected;
            case 5:
                return Returned;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Waiting;
            case 7:
                return Signed;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return Termination;
            default:
                return null;
        }
    }

    PlayletScriptSignStatus(int i) {
        this.value = i;
    }
}
