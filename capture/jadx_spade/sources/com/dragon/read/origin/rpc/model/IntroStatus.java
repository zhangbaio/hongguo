package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum IntroStatus {
    SIGN_FIRST(0),
    SIGN_SECOND(1),
    SIGN_THIRD(2),
    RECOMMEND_FIRST(3),
    RECOMMEND_SECOND(4),
    RECOMMEND_THIRD(5),
    RECOMMEND_FORTH(6),
    RECOMMEND_FIFTH(7),
    RECOMMEND_SIXTH(8),
    FINISH_FIRST(9);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613206);
    }

    public static IntroStatus findByValue(int i) {
        switch (i) {
            case 0:
                return SIGN_FIRST;
            case 1:
                return SIGN_SECOND;
            case 2:
                return SIGN_THIRD;
            case 3:
                return RECOMMEND_FIRST;
            case 4:
                return RECOMMEND_SECOND;
            case 5:
                return RECOMMEND_THIRD;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return RECOMMEND_FORTH;
            case 7:
                return RECOMMEND_FIFTH;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return RECOMMEND_SIXTH;
            case 9:
                return FINISH_FIRST;
            default:
                return null;
        }
    }

    IntroStatus(int i) {
        this.value = i;
    }
}
