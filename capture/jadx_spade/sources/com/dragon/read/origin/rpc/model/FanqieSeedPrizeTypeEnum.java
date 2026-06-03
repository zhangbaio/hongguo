package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum FanqieSeedPrizeTypeEnum {
    Medal(1),
    LuckyBag(2),
    WeekNovelVip(3),
    MonthNovelVip(4),
    AvatarWidget(5);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612926);
    }

    public static FanqieSeedPrizeTypeEnum findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return AvatarWidget;
                    }
                    return MonthNovelVip;
                }
                return WeekNovelVip;
            }
            return LuckyBag;
        }
        return Medal;
    }

    FanqieSeedPrizeTypeEnum(int i) {
        this.value = i;
    }
}
