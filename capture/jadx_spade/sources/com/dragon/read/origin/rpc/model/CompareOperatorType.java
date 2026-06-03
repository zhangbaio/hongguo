package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum CompareOperatorType {
    Gt(1),
    Equal(2),
    Lt(3),
    Gte(4),
    Lte(5),
    NotEqual(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612834);
    }

    public static CompareOperatorType findByValue(int i) {
        switch (i) {
            case 1:
                return Gt;
            case 2:
                return Equal;
            case 3:
                return Lt;
            case 4:
                return Gte;
            case 5:
                return Lte;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return NotEqual;
            default:
                return null;
        }
    }

    CompareOperatorType(int i) {
        this.value = i;
    }
}
