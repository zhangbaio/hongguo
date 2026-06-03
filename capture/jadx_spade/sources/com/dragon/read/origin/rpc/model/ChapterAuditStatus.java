package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ChapterAuditStatus {
    All(0),
    CAN_PUBLISH(1),
    DELETED(2),
    NOT_EXIST(3),
    WAIT_PROCESS(4),
    CAN_NOT_PUBLISH(5),
    PASSED(6),
    NOT_PASS(7),
    DRAFT(8),
    DROP(9),
    TIMER_TIME(10),
    TIMER_FAILED(11),
    STOP_RECOMMEND(12);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612800);
    }

    public static ChapterAuditStatus findByValue(int i) {
        switch (i) {
            case 0:
                return All;
            case 1:
                return CAN_PUBLISH;
            case 2:
                return DELETED;
            case 3:
                return NOT_EXIST;
            case 4:
                return WAIT_PROCESS;
            case 5:
                return CAN_NOT_PUBLISH;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return PASSED;
            case 7:
                return NOT_PASS;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return DRAFT;
            case 9:
                return DROP;
            case 10:
                return TIMER_TIME;
            case 11:
                return TIMER_FAILED;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return STOP_RECOMMEND;
            default:
                return null;
        }
    }

    ChapterAuditStatus(int i) {
        this.value = i;
    }
}
