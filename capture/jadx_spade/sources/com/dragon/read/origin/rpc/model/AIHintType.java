package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIHintType {
    Category(1),
    Description(2),
    Hint(3),
    WorldSetting(4),
    PersonSetting(5),
    Outline(6),
    HintPre(7);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612686);
    }

    public static AIHintType findByValue(int i) {
        switch (i) {
            case 1:
                return Category;
            case 2:
                return Description;
            case 3:
                return Hint;
            case 4:
                return WorldSetting;
            case 5:
                return PersonSetting;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Outline;
            case 7:
                return HintPre;
            default:
                return null;
        }
    }

    AIHintType(int i) {
        this.value = i;
    }
}
