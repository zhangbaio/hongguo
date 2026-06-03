package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AuthType {
    UnknownType(0),
    PersonalTwoElement(1),
    PersonalThreeElement(2),
    EnterpriseAccount(3),
    EnterpriseFourElement(4),
    PersonalThreeElementMobile(5),
    PersonalThreeElementBankCheck(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612750);
    }

    public static AuthType findByValue(int i) {
        switch (i) {
            case 0:
                return UnknownType;
            case 1:
                return PersonalTwoElement;
            case 2:
                return PersonalThreeElement;
            case 3:
                return EnterpriseAccount;
            case 4:
                return EnterpriseFourElement;
            case 5:
                return PersonalThreeElementMobile;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return PersonalThreeElementBankCheck;
            default:
                return null;
        }
    }

    AuthType(int i) {
        this.value = i;
    }
}
