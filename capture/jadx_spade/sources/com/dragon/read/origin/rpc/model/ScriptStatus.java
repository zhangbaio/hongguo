package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ScriptStatus {
    Unsigned(0),
    Signable(1),
    IpPending(2),
    Passed(3),
    Waiting(4),
    Rejected(5),
    Returned(6),
    Completable(7),
    Completed(8);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613401);
    }

    public static ScriptStatus findByValue(int i) {
        switch (i) {
            case 0:
                return Unsigned;
            case 1:
                return Signable;
            case 2:
                return IpPending;
            case 3:
                return Passed;
            case 4:
                return Waiting;
            case 5:
                return Rejected;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Returned;
            case 7:
                return Completable;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return Completed;
            default:
                return null;
        }
    }

    ScriptStatus(int i) {
        this.value = i;
    }
}
