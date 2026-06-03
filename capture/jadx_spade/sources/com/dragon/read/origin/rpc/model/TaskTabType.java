package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum TaskTabType {
    RecommendBook(1),
    Story(2),
    GameComic(3),
    Recommend(4),
    Forum(5),
    Romance(6),
    Imagination(7),
    SuspenseAndMysterious(8);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613472);
    }

    public static TaskTabType findByValue(int i) {
        switch (i) {
            case 1:
                return RecommendBook;
            case 2:
                return Story;
            case 3:
                return GameComic;
            case 4:
                return Recommend;
            case 5:
                return Forum;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Romance;
            case 7:
                return Imagination;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return SuspenseAndMysterious;
            default:
                return null;
        }
    }

    TaskTabType(int i) {
        this.value = i;
    }
}
