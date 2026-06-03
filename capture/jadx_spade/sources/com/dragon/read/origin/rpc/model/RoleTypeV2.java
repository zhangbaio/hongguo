package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum RoleTypeV2 {
    Unknown(0),
    Writer(1),
    Contractor(2),
    CP(3),
    Actor(4),
    Other(5),
    Investor(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613380);
    }

    public static RoleTypeV2 findByValue(int i) {
        switch (i) {
            case 0:
                return Unknown;
            case 1:
                return Writer;
            case 2:
                return Contractor;
            case 3:
                return CP;
            case 4:
                return Actor;
            case 5:
                return Other;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Investor;
            default:
                return null;
        }
    }

    RoleTypeV2(int i) {
        this.value = i;
    }
}
