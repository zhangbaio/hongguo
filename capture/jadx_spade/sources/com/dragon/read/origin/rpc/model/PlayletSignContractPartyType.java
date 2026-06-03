package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PlayletSignContractPartyType {
    OtherPartyForCorporate(3),
    OtherPartyForPersonal(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613298);
    }

    public static PlayletSignContractPartyType findByValue(int i) {
        if (i != 3) {
            if (i != 4) {
                return null;
            }
            return OtherPartyForPersonal;
        }
        return OtherPartyForCorporate;
    }

    PlayletSignContractPartyType(int i) {
        this.value = i;
    }
}
