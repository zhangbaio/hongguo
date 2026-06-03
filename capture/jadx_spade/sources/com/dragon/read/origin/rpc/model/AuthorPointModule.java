package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AuthorPointModule {
    TaskPoint(1),
    PublishPoint(2),
    OtherPoint(3),
    IncomePoint(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612755);
    }

    public static AuthorPointModule findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return IncomePoint;
                }
                return OtherPoint;
            }
            return PublishPoint;
        }
        return TaskPoint;
    }

    AuthorPointModule(int i) {
        this.value = i;
    }
}
