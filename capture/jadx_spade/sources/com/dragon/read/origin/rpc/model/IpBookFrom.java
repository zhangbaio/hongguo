package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum IpBookFrom {
    InSite(1),
    OutSite(2),
    Origin(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613208);
    }

    public static IpBookFrom findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return Origin;
            }
            return OutSite;
        }
        return InSite;
    }

    IpBookFrom(int i) {
        this.value = i;
    }
}
