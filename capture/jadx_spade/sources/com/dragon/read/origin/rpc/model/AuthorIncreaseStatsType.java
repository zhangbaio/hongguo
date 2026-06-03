package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AuthorIncreaseStatsType {
    SHORT_ARTICLE_READ_COUNT(1),
    SHORT_ARTICLE_SHELF_COUNT(2),
    SHORT_ARTICLE_SHOW_COUNT(3),
    SHORT_ARTICLE_CLICK_RATE(4),
    SHORT_ARTICLE_COMMENT_COUNT(5),
    SHORT_ARTICLE_DIGG_COUNT(6),
    SHORT_ARTICLE_DOUYIN_PAY_RATE(7),
    SHORT_ARTICLE_DOUYIN_READ_POPULARITY_SCORE(8),
    SHORT_ARTICLE_SUM_READ_COUNT(9),
    SHORT_ARTICLE_SUM_SHELF_COUNT(10),
    SHORT_ARTICLE_SUM_SHOW_COUNT(11),
    SHORT_ARTICLE_SUM_CLICK_RATE(12),
    SHORT_ARTICLE_SUM_COMMENT_COUNT(13),
    SHORT_ARTICLE_SUM_DIGG_COUNT(14),
    SHORT_ARTICLE_SUM_DOUYIN_PAY_RATE(15),
    SHORT_ARTICLE_SUM_DOUYIN_READ_POPULARITY_SCORE(16);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612754);
    }

    public static AuthorIncreaseStatsType findByValue(int i) {
        switch (i) {
            case 1:
                return SHORT_ARTICLE_READ_COUNT;
            case 2:
                return SHORT_ARTICLE_SHELF_COUNT;
            case 3:
                return SHORT_ARTICLE_SHOW_COUNT;
            case 4:
                return SHORT_ARTICLE_CLICK_RATE;
            case 5:
                return SHORT_ARTICLE_COMMENT_COUNT;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return SHORT_ARTICLE_DIGG_COUNT;
            case 7:
                return SHORT_ARTICLE_DOUYIN_PAY_RATE;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return SHORT_ARTICLE_DOUYIN_READ_POPULARITY_SCORE;
            case 9:
                return SHORT_ARTICLE_SUM_READ_COUNT;
            case 10:
                return SHORT_ARTICLE_SUM_SHELF_COUNT;
            case 11:
                return SHORT_ARTICLE_SUM_SHOW_COUNT;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return SHORT_ARTICLE_SUM_CLICK_RATE;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return SHORT_ARTICLE_SUM_COMMENT_COUNT;
            case 14:
                return SHORT_ARTICLE_SUM_DIGG_COUNT;
            case 15:
                return SHORT_ARTICLE_SUM_DOUYIN_PAY_RATE;
            case 16:
                return SHORT_ARTICLE_SUM_DOUYIN_READ_POPULARITY_SCORE;
            default:
                return null;
        }
    }

    AuthorIncreaseStatsType(int i) {
        this.value = i;
    }
}
