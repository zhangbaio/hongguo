package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcActionReasonType {
    Server(1),
    Client(2),
    User(3),
    Remark(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613489);
    }

    public static UgcActionReasonType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return Remark;
                }
                return User;
            }
            return Client;
        }
        return Server;
    }

    UgcActionReasonType(int i) {
        this.value = i;
    }
}
