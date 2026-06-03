package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SyncPermDataType {
    UNKNOWN(0),
    PPE_TO_PROD_DRAFT(1),
    PPE_TO_PROD_CHECKPOINT(2),
    PROD_TO_PPE_DRAFT(3),
    PROD_TO_PPE_CHECKPOINT(4),
    PPE_TO_PPE_DRAFT(5),
    PROD_TO_PROD_DRAFT(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613467);
    }

    public static SyncPermDataType findByValue(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return PPE_TO_PROD_DRAFT;
            case 2:
                return PPE_TO_PROD_CHECKPOINT;
            case 3:
                return PROD_TO_PPE_DRAFT;
            case 4:
                return PROD_TO_PPE_CHECKPOINT;
            case 5:
                return PPE_TO_PPE_DRAFT;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return PROD_TO_PROD_DRAFT;
            default:
                return null;
        }
    }

    SyncPermDataType(int i) {
        this.value = i;
    }
}
