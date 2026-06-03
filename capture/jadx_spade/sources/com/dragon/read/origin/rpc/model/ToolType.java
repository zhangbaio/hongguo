package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ToolType {
    BOOK_RECOMMEND(0),
    CHAPTER_READ(1),
    AUTHOR_SPEAK(2),
    COMMENT_MANAGE(3),
    EDIT_COVER(4),
    RECOMMEND_WORKS(5),
    MULTIPLE_EXPERIMENT(6),
    READER_OFFICE(7),
    FAN_NAME(8),
    AUTHOR_CLASS(9),
    RANKING_LIST(10),
    WORK_DRAINAGE(11),
    CREATE_BOOK(12),
    BOOK_PREHEAT(13);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613477);
    }

    public static ToolType findByValue(int i) {
        switch (i) {
            case 0:
                return BOOK_RECOMMEND;
            case 1:
                return CHAPTER_READ;
            case 2:
                return AUTHOR_SPEAK;
            case 3:
                return COMMENT_MANAGE;
            case 4:
                return EDIT_COVER;
            case 5:
                return RECOMMEND_WORKS;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return MULTIPLE_EXPERIMENT;
            case 7:
                return READER_OFFICE;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return FAN_NAME;
            case 9:
                return AUTHOR_CLASS;
            case 10:
                return RANKING_LIST;
            case 11:
                return WORK_DRAINAGE;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return CREATE_BOOK;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return BOOK_PREHEAT;
            default:
                return null;
        }
    }

    ToolType(int i) {
        this.value = i;
    }
}
