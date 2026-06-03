package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum InsetAgreementType {
    Inset(1),
    AI(2),
    AITool(3),
    AICover(4),
    AICharacter(5);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613196);
    }

    public static InsetAgreementType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return AICharacter;
                    }
                    return AICover;
                }
                return AITool;
            }
            return AI;
        }
        return Inset;
    }

    InsetAgreementType(int i) {
        this.value = i;
    }
}
