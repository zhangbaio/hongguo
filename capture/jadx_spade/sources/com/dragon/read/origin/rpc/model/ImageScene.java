package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ImageScene {
    BookThumb(0),
    FeedbackImage(1),
    IdCard(2),
    StarPlanImage(3),
    GuaranteedPlanImage(4),
    PlagiarizeAppealImage(5);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613192);
    }

    public static ImageScene findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return PlagiarizeAppealImage;
                        }
                        return GuaranteedPlanImage;
                    }
                    return StarPlanImage;
                }
                return IdCard;
            }
            return FeedbackImage;
        }
        return BookThumb;
    }

    ImageScene(int i) {
        this.value = i;
    }
}
