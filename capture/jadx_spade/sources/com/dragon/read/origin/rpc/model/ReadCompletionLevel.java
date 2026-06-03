package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ReadCompletionLevel {
    NO_VALUE(-1),
    READ_COMPLETION_LEVEL_10(1),
    READ_COMPLETION_LEVEL_30(2),
    READ_COMPLETION_LEVEL_50(3),
    READ_COMPLETION_LEVEL_80(4),
    READ_COMPLETION_LEVEL_100(5),
    READ_COMPLETION_LEVEL_20(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613355);
    }

    public static ReadCompletionLevel findByValue(int i) {
        switch (i) {
            case -1:
                return NO_VALUE;
            case 0:
            default:
                return null;
            case 1:
                return READ_COMPLETION_LEVEL_10;
            case 2:
                return READ_COMPLETION_LEVEL_30;
            case 3:
                return READ_COMPLETION_LEVEL_50;
            case 4:
                return READ_COMPLETION_LEVEL_80;
            case 5:
                return READ_COMPLETION_LEVEL_100;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return READ_COMPLETION_LEVEL_20;
        }
    }

    ReadCompletionLevel(int i) {
        this.value = i;
    }
}
