package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum InstitutionType {
    UNKNOWN(0),
    PRODUCER(1),
    CP(2),
    WRITER(3),
    ACTOR(4),
    INVESTOR(5),
    CP_INVESTOR(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613204);
    }

    public static InstitutionType findByValue(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return PRODUCER;
            case 2:
                return CP;
            case 3:
                return WRITER;
            case 4:
                return ACTOR;
            case 5:
                return INVESTOR;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return CP_INVESTOR;
            default:
                return null;
        }
    }

    InstitutionType(int i) {
        this.value = i;
    }
}
