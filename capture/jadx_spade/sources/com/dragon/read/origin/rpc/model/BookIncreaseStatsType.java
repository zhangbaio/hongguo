package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum BookIncreaseStatsType {
    READ_COUNT_NOVEL_APP(1),
    SHELF_COUNT_NOVEL_APP(2),
    READER_UV_DAY14_NOVEL_APP(3),
    MARK_SCORE_NOVEL_APP(4),
    READ_COMPLETION_RATE_10_NOVEL_APP(9),
    READ_COMPLETION_RATE_30_NOVEL_APP(10),
    READ_COMPLETION_RATE_50_NOVEL_APP(11),
    READ_COMPLETION_RATE_80_NOVEL_APP(12),
    READ_COMPLETION_RATE_100_NOVEL_APP(13),
    REMINDER_COUNT_NOVEL_APP(14),
    PURCHASE_READ_RATE_NOVEL_APP(15),
    PURSUE_READ_COUNT_NOVEL_APP(17),
    READ_COMPLETION_RATE_20_NOVEL_APP(18),
    COMMENT_COUNT_NOVEL_APP(19),
    SUM_READ_COUNT_NOVEL_APP(20),
    SUM_SHELF_COUNT_NOVEL_APP(21),
    SUM_COMMENT_COUNT_NOVEL_APP(22),
    SUM_REMINDER_COUNT_NOVEL_APP(23),
    READ_SOURCE_LIBRARY_NOVEL_APP(24),
    READ_SOURCE_RECENT_NOVEL_APP(25),
    READ_SOURCE_SHELF_NOVEL_APP(26),
    READ_SOURCE_CATEGORY_NOVEL_APP(27),
    READ_SOURCE_SEARCH_NOVEL_APP(28),
    READ_SOURCE_OTHER_NOVEL_APP(29),
    SHORT_ARTICLE_READ_COUNT(30),
    SHORT_ARTICLE_SHELF_COUNT(31),
    SHORT_ARTICLE_SHOW_COUNT(32),
    SHORT_ARTICLE_CLICK_RATE(33),
    SHORT_ARTICLE_COMMENT_COUNT(34),
    SHORT_ARTICLE_DIGG_COUNT(35),
    SHORT_ARTICLE_DOUYIN_PAY_RATE(36),
    SHORT_ARTICLE_DOUYIN_READ_POPULARITY_SCORE(37),
    SHORT_ARTICLE_SUM_READ_COUNT(38),
    SHORT_ARTICLE_SUM_SHELF_COUNT(39),
    SHORT_ARTICLE_SUM_SHOW_COUNT(40),
    SHORT_ARTICLE_SUM_CLICK_RATE(41),
    SHORT_ARTICLE_SUM_COMMENT_COUNT(42),
    SHORT_ARTICLE_SUM_DIGG_COUNT(43),
    SHORT_ARTICLE_SUM_DOUYIN_PAY_RATE(44),
    SHORT_ARTICLE_SUM_DOUYIN_READ_POPULARITY_SCORE(45);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612775);
    }

    public static BookIncreaseStatsType findByValue(int i) {
        switch (i) {
            case 1:
                return READ_COUNT_NOVEL_APP;
            case 2:
                return SHELF_COUNT_NOVEL_APP;
            case 3:
                return READER_UV_DAY14_NOVEL_APP;
            case 4:
                return MARK_SCORE_NOVEL_APP;
            case 5:
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
            case 7:
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
            case 16:
            default:
                return null;
            case 9:
                return READ_COMPLETION_RATE_10_NOVEL_APP;
            case 10:
                return READ_COMPLETION_RATE_30_NOVEL_APP;
            case 11:
                return READ_COMPLETION_RATE_50_NOVEL_APP;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return READ_COMPLETION_RATE_80_NOVEL_APP;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return READ_COMPLETION_RATE_100_NOVEL_APP;
            case 14:
                return REMINDER_COUNT_NOVEL_APP;
            case 15:
                return PURCHASE_READ_RATE_NOVEL_APP;
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return PURSUE_READ_COUNT_NOVEL_APP;
            case 18:
                return READ_COMPLETION_RATE_20_NOVEL_APP;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                return COMMENT_COUNT_NOVEL_APP;
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                return SUM_READ_COUNT_NOVEL_APP;
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                return SUM_SHELF_COUNT_NOVEL_APP;
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                return SUM_COMMENT_COUNT_NOVEL_APP;
            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                return SUM_REMINDER_COUNT_NOVEL_APP;
            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                return READ_SOURCE_LIBRARY_NOVEL_APP;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                return READ_SOURCE_RECENT_NOVEL_APP;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                return READ_SOURCE_SHELF_NOVEL_APP;
            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                return READ_SOURCE_CATEGORY_NOVEL_APP;
            case 28:
                return READ_SOURCE_SEARCH_NOVEL_APP;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                return READ_SOURCE_OTHER_NOVEL_APP;
            case 30:
                return SHORT_ARTICLE_READ_COUNT;
            case 31:
                return SHORT_ARTICLE_SHELF_COUNT;
            case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                return SHORT_ARTICLE_SHOW_COUNT;
            case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                return SHORT_ARTICLE_CLICK_RATE;
            case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                return SHORT_ARTICLE_COMMENT_COUNT;
            case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                return SHORT_ARTICLE_DIGG_COUNT;
            case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                return SHORT_ARTICLE_DOUYIN_PAY_RATE;
            case ConstantsAPI.COMMAND_OPEN_CUSTOMER_SERVICE_CHAT /* 37 */:
                return SHORT_ARTICLE_DOUYIN_READ_POPULARITY_SCORE;
            case ConstantsAPI.COMMAND_OPEN_QRCODE_PAY /* 38 */:
                return SHORT_ARTICLE_SUM_READ_COUNT;
            case ConstantsAPI.COMMAND_FINDER_START_LIVE /* 39 */:
                return SHORT_ARTICLE_SUM_SHELF_COUNT;
            case 40:
                return SHORT_ARTICLE_SUM_SHOW_COUNT;
            case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                return SHORT_ARTICLE_SUM_CLICK_RATE;
            case 42:
                return SHORT_ARTICLE_SUM_COMMENT_COUNT;
            case 43:
                return SHORT_ARTICLE_SUM_DIGG_COUNT;
            case 44:
                return SHORT_ARTICLE_SUM_DOUYIN_PAY_RATE;
            case 45:
                return SHORT_ARTICLE_SUM_DOUYIN_READ_POPULARITY_SCORE;
        }
    }

    BookIncreaseStatsType(int i) {
        this.value = i;
    }
}
