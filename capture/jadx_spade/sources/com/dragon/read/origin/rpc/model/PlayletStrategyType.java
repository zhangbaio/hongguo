package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletStrategyType {
    Assigning(1),
    Contractor(2),
    FlowTypeAssign(3),
    WriterPackage(4),
    IpPackage(5),
    IpVisibility(6),
    CQCGradeReview(7),
    PlatformSign(8);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613301);
    }

    public static PlayletStrategyType findByValue(int i) {
        switch (i) {
            case 1:
                return Assigning;
            case 2:
                return Contractor;
            case 3:
                return FlowTypeAssign;
            case 4:
                return WriterPackage;
            case 5:
                return IpPackage;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return IpVisibility;
            case 7:
                return CQCGradeReview;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return PlatformSign;
            default:
                return null;
        }
    }

    PlayletStrategyType(int i) {
        this.value = i;
    }
}
