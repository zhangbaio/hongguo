package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ColdStartShowStatus {
    INIT(0),
    AUDITING(1),
    UNPASSED(2),
    PASSED(3),
    WAIT_AUDIT(4),
    PAUSE_RECOMMEND(5),
    STOP_RECOMMEND(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612829);
    }

    public static ColdStartShowStatus findByValue(int i) {
        switch (i) {
            case 0:
                return INIT;
            case 1:
                return AUDITING;
            case 2:
                return UNPASSED;
            case 3:
                return PASSED;
            case 4:
                return WAIT_AUDIT;
            case 5:
                return PAUSE_RECOMMEND;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return STOP_RECOMMEND;
            default:
                return null;
        }
    }

    ColdStartShowStatus(int i) {
        this.value = i;
    }
}
