package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AgeClass {
    Unknown(0),
    Under18(1),
    Under24(2),
    Between25And30(3),
    Between31And40(4),
    Between41And50(5),
    Over50(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612727);
    }

    public static AgeClass findByValue(int i) {
        switch (i) {
            case 0:
                return Unknown;
            case 1:
                return Under18;
            case 2:
                return Under24;
            case 3:
                return Between25And30;
            case 4:
                return Between31And40;
            case 5:
                return Between41And50;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Over50;
            default:
                return null;
        }
    }

    AgeClass(int i) {
        this.value = i;
    }
}
