package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum RankListType {
    RANK_LIST_AUTHORITY(1),
    RANK_LIST_READ(2),
    RANK_LIST_HIGH_SCORE(3),
    RANK_LIST_CHASE(4),
    RANK_LIST_HOT_COMMENT(5),
    RANK_LIST_INCR(6),
    RANK_LIST_HOT_SEARCH(7),
    RANK_LIST_NEW_BOOK(8),
    RANK_LIST_DIANFENG(9);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613353);
    }

    public static RankListType findByValue(int i) {
        switch (i) {
            case 1:
                return RANK_LIST_AUTHORITY;
            case 2:
                return RANK_LIST_READ;
            case 3:
                return RANK_LIST_HIGH_SCORE;
            case 4:
                return RANK_LIST_CHASE;
            case 5:
                return RANK_LIST_HOT_COMMENT;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return RANK_LIST_INCR;
            case 7:
                return RANK_LIST_HOT_SEARCH;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return RANK_LIST_NEW_BOOK;
            case 9:
                return RANK_LIST_DIANFENG;
            default:
                return null;
        }
    }

    RankListType(int i) {
        this.value = i;
    }
}
