package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum CommentIndexType {
    SavoirComment(1),
    TalkComment(2),
    ItemComment(3),
    BookComment(4),
    AIParaComment(5),
    VideoComment(6);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612832);
    }

    public static CommentIndexType findByValue(int i) {
        switch (i) {
            case 1:
                return SavoirComment;
            case 2:
                return TalkComment;
            case 3:
                return ItemComment;
            case 4:
                return BookComment;
            case 5:
                return AIParaComment;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return VideoComment;
            default:
                return null;
        }
    }

    CommentIndexType(int i) {
        this.value = i;
    }
}
