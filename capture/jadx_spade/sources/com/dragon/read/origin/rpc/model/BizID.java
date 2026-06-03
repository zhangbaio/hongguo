package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BizID {
    UNKNOWN(0),
    NOVEL(1),
    AUDIO(2),
    MUSIC(3),
    CP(4),
    DIY_DRAMA(5),
    PUGC(6),
    COPYRIGHT(7),
    SHORT_DRAMA(8),
    FEATURE(9),
    BERRYOSTORY(10);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612772);
    }

    public static BizID findByValue(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return NOVEL;
            case 2:
                return AUDIO;
            case 3:
                return MUSIC;
            case 4:
                return CP;
            case 5:
                return DIY_DRAMA;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return PUGC;
            case 7:
                return COPYRIGHT;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return SHORT_DRAMA;
            case 9:
                return FEATURE;
            case 10:
                return BERRYOSTORY;
            default:
                return null;
        }
    }

    BizID(int i) {
        this.value = i;
    }
}
