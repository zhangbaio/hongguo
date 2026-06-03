package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SourceType {
    ACTIVITY(0),
    INTERACTIVATION(1),
    SYSTEM(2),
    VIP(3),
    WELFARE(4),
    AUDIT(5),
    SIGN(6),
    OTHER(7),
    PRAISE_AUTO(8),
    PRAISE_REPLY(9),
    TOPIC_FORUM_DYNAMIC(10),
    TOPIC_FORUM_INVITE(11),
    UGC_NOTIFY(12),
    ORIGIN_INTERACT(13),
    PRAISE(14),
    UGC_QUESTION_INVITE(15),
    PUBLISH_VIP_ACTIVITY(16),
    SHELF(17),
    MUSIC_PRODUCT(18),
    CP_AUDIT_STATUS(20),
    CP_AUDIT_MODIFY(21),
    CP_UPDATE_NOTICE(22),
    CP_OTHER(23),
    CP_PROVIDER_DOWNLOAD(24),
    CP_PROVIDER_TASK(25),
    Attention(26),
    PROVIDER_AUDIO_QUALITY(28),
    NEWS_TTS_FAILED(29),
    CP_FLIGHT(30),
    CP_PROVIDER_ACTIVITY(31),
    IP_NOTICE(32),
    INSTITUTION(33),
    MATCH_TASK(35),
    CP_CLAIM_NOTICE(40),
    DIGG(100),
    COMMENT(101),
    ORIGIN_POST(110);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613455);
    }

    public static SourceType findByValue(int i) {
        if (i != 35) {
            if (i != 40) {
                if (i != 110) {
                    if (i != 100) {
                        if (i != 101) {
                            switch (i) {
                                case 0:
                                    return ACTIVITY;
                                case 1:
                                    return INTERACTIVATION;
                                case 2:
                                    return SYSTEM;
                                case 3:
                                    return VIP;
                                case 4:
                                    return WELFARE;
                                case 5:
                                    return AUDIT;
                                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                                    return SIGN;
                                case 7:
                                    return OTHER;
                                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                                    return PRAISE_AUTO;
                                case 9:
                                    return PRAISE_REPLY;
                                case 10:
                                    return TOPIC_FORUM_DYNAMIC;
                                case 11:
                                    return TOPIC_FORUM_INVITE;
                                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                                    return UGC_NOTIFY;
                                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                                    return ORIGIN_INTERACT;
                                case 14:
                                    return PRAISE;
                                case 15:
                                    return UGC_QUESTION_INVITE;
                                case 16:
                                    return PUBLISH_VIP_ACTIVITY;
                                case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                    return SHELF;
                                case 18:
                                    return MUSIC_PRODUCT;
                                default:
                                    switch (i) {
                                        case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                            return CP_AUDIT_STATUS;
                                        case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                            return CP_AUDIT_MODIFY;
                                        case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                            return CP_UPDATE_NOTICE;
                                        case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                            return CP_OTHER;
                                        case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                            return CP_PROVIDER_DOWNLOAD;
                                        case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                            return CP_PROVIDER_TASK;
                                        case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                            return Attention;
                                        default:
                                            switch (i) {
                                                case 28:
                                                    return PROVIDER_AUDIO_QUALITY;
                                                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                                    return NEWS_TTS_FAILED;
                                                case 30:
                                                    return CP_FLIGHT;
                                                case 31:
                                                    return CP_PROVIDER_ACTIVITY;
                                                case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                                                    return IP_NOTICE;
                                                case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                                                    return INSTITUTION;
                                                default:
                                                    return null;
                                            }
                                    }
                            }
                        }
                        return COMMENT;
                    }
                    return DIGG;
                }
                return ORIGIN_POST;
            }
            return CP_CLAIM_NOTICE;
        }
        return MATCH_TASK;
    }

    SourceType(int i) {
        this.value = i;
    }
}
