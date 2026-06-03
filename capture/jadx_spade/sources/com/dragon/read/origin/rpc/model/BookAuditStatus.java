package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BookAuditStatus {
    WAIT_AUDIT(1),
    FIRST_AUDIT_FAIL(2),
    MODIFY_AUDIT_FAIL(3),
    AUDIT_PASS(4),
    MODIFY_WAIT_AUDIT(5),
    DELETE_AUDIT_FAIL(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612773);
    }

    public static BookAuditStatus findByValue(int i) {
        switch (i) {
            case 1:
                return WAIT_AUDIT;
            case 2:
                return FIRST_AUDIT_FAIL;
            case 3:
                return MODIFY_AUDIT_FAIL;
            case 4:
                return AUDIT_PASS;
            case 5:
                return MODIFY_WAIT_AUDIT;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return DELETE_AUDIT_FAIL;
            default:
                return null;
        }
    }

    BookAuditStatus(int i) {
        this.value = i;
    }
}
