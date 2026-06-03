package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum RightType {
    Unknown(0),
    RightIndividual(1),
    RightInstitutionRoot(2),
    RightInstitutionMember(3),
    RightAddition(4),
    RightInstitutionManager(5);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613375);
    }

    public static RightType findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return RightInstitutionManager;
                        }
                        return RightAddition;
                    }
                    return RightInstitutionMember;
                }
                return RightInstitutionRoot;
            }
            return RightIndividual;
        }
        return Unknown;
    }

    RightType(int i) {
        this.value = i;
    }
}
