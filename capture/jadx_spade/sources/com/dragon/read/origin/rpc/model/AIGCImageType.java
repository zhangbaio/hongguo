package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIGCImageType {
    ManualInput(1),
    NovelParaContent(2),
    EditText(3),
    EditStyle(4),
    MultiEdit(5);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612680);
    }

    public static AIGCImageType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return MultiEdit;
                    }
                    return EditStyle;
                }
                return EditText;
            }
            return NovelParaContent;
        }
        return ManualInput;
    }

    AIGCImageType(int i) {
        this.value = i;
    }
}
