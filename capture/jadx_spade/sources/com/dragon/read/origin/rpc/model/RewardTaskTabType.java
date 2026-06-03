package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum RewardTaskTabType {
    YesterdayTab(1),
    AllHistory(2),
    DouyinYesterdayTab(3),
    DouyinAllHistory(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613372);
    }

    public static RewardTaskTabType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return DouyinAllHistory;
                }
                return DouyinYesterdayTab;
            }
            return AllHistory;
        }
        return YesterdayTab;
    }

    RewardTaskTabType(int i) {
        this.value = i;
    }
}
