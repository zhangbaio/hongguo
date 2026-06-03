package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcHighlightTagType {
    General(1),
    NewTheme(2),
    Category(3),
    Personalise(4),
    NLPIntent(5),
    Search(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613510);
    }

    public static UgcHighlightTagType findByValue(int i) {
        switch (i) {
            case 1:
                return General;
            case 2:
                return NewTheme;
            case 3:
                return Category;
            case 4:
                return Personalise;
            case 5:
                return NLPIntent;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Search;
            default:
                return null;
        }
    }

    UgcHighlightTagType(int i) {
        this.value = i;
    }
}
