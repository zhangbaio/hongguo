package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum StatsType4Chapter {
    ST_ReadCompletionRate(3),
    ST_FollowReadCount(4),
    ST_ReminderCount(5),
    ST_CommentParagraphCount(6),
    ST_CommentChapterCount(7);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613460);
    }

    public static StatsType4Chapter findByValue(int i) {
        if (i != 3) {
            if (i != 4) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 7) {
                            return null;
                        }
                        return ST_CommentChapterCount;
                    }
                    return ST_CommentParagraphCount;
                }
                return ST_ReminderCount;
            }
            return ST_FollowReadCount;
        }
        return ST_ReadCompletionRate;
    }

    StatsType4Chapter(int i) {
        this.value = i;
    }
}
