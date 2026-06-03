package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum MessageType {
    OPERATION(0),
    RED_DOT(1),
    SNAPSHOT(2),
    TOAST_GOLD(3),
    TOAST_CASH(4),
    TOAST_OPERATION(5),
    BOOK_SNAPSHOT(6),
    AD_SNAPSHOT(7),
    YOUNG_TOAST(8),
    QUESTION_MSG(10),
    OUT_BOOK_TOPIC_EMPTY_REPLY(40),
    GET_MONEY_REWARD_NOTIFY(41),
    GET_MONEY_REWARD_IN_A_WEEK_NOTIFY(42),
    DIGG(100),
    COMMENT(101),
    COMMON_INFO(102),
    PRAISE_ACTIVITY(104),
    PRAISE_NOTIFY(105),
    PRAISE_USER_NOTIFY(106),
    OUT_BOOK_TOPIC(107),
    OUT_BOOK_TOPIC_COMMENT(108),
    OUT_BOOK_TOPIC_INVITE(109),
    OUT_BOOK_USER_TOPIC_INVITE(110),
    In_BOOK_USER_TOPIC_INVITE(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE),
    UGC_MENTION_USER(112),
    POST_DIGG(113),
    POST_COMMENT(114),
    UGC_USER_ATTENTION(115),
    UGC_COLLECT(116),
    UGC_BOOK_LIST(117),
    UGC_URGE(118),
    UGC_UPDATE(119),
    UGC_CREATION(120),
    INVITE_ENTER_CONVERSATION(121),
    UGC_INVITE_ANSWER(122),
    UGC_INVITE_BOOK_COMMENT(123),
    UGC_IMAGE_ACTIVITY(124),
    UGC_TOPIC_ACTIVITY(125),
    UGC_PRAISE_SHARE_THANK(126),
    UGC_AUTHOR_POST_INTERACTION(127),
    UGC_PRAISE_NOTIFY(128),
    GET_MONEY_REWARD_MSG_CENTER_NOTIFY(129),
    GET_MONEY_REWARD_IN_A_WEEK_MSG_CENTER_NOTIFY(130),
    UGC_QUESTION_INVITE_USER(131),
    UGC_QUESTION_INVITE_OFFICIAL(132),
    AUTHOR_UGC_URGE(133),
    DIGG_OR_COLLECT_ACHIEVEMENT(134),
    DIGG_OR_COLLECT_ACHIEVEMENT_IN_MSG_CENTER(135),
    INVITE_TOPIC_COMMENT(136),
    UGC_TOPIC_COMMENT(137),
    UGC_CREATOR_COMMENT(138),
    UGC_CREATOR_DIGG(139),
    UGC_CREATOR_SELECT(140),
    ACTOR_PICK_COMMENT(141),
    ACTOR_PICK_DIGG(142),
    ACTOR_PICK_COLLECT(143),
    LIVE_PUSH(200),
    NOVELFM_VIP(201),
    NOVELFM_WELFARE(202),
    NOVELFM_SYSTEM(203),
    NOVELFM_ACTIVITY(204),
    NOVELFM_SHOPPING(205),
    NOVELFM_FOLLOW_UP_PUSH(206),
    NOVELFM_COMMON(207),
    NOVELFM_SUBSCRIBE(208),
    BOOK_UPDATE(301),
    USER_PROFILE_REVIEW(302),
    SYS_TOS_UPDATE(303),
    SYS_PP_UPDATE(304),
    INACTIVE_USER(305),
    NOT_READ_PAY_WALL(306),
    NEVER_PAID(307),
    COMMENT_DIGG(308),
    COMMENT_REPLY(309),
    GOOD_BOOKS(310),
    CONTINUE_READ(TTVideoEngineInterface.PLAYER_OPTION_PREFER_NEARESTSAMPLE),
    CHECK_IN_TASK(312),
    HG_INNER_PUSH_LIVEROOM(401),
    HG_INNER_PUSH_SETTLE(402),
    HG_INNER_PUSH_SERIES_ADDED(403),
    HG_INNER_PUSH_SERIES_CAN_SUBSCRIBE(404),
    HG_INNER_PUSH_VIDEO_PUBLISHED(405),
    HG_INNER_PUSH_CACHE_MSG(406),
    HG_INNER_PUSH_AI_VIDEO_MSG(407),
    HG_INNER_PUSH_SUBSCRIBE(408);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613219);
    }

    public static MessageType findByValue(int i) {
        if (i != 10) {
            switch (i) {
                case 0:
                    return OPERATION;
                case 1:
                    return RED_DOT;
                case 2:
                    return SNAPSHOT;
                case 3:
                    return TOAST_GOLD;
                case 4:
                    return TOAST_CASH;
                case 5:
                    return TOAST_OPERATION;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    return BOOK_SNAPSHOT;
                case 7:
                    return AD_SNAPSHOT;
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    return YOUNG_TOAST;
                default:
                    switch (i) {
                        case 40:
                            return OUT_BOOK_TOPIC_EMPTY_REPLY;
                        case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                            return GET_MONEY_REWARD_NOTIFY;
                        case 42:
                            return GET_MONEY_REWARD_IN_A_WEEK_NOTIFY;
                        default:
                            switch (i) {
                                case 100:
                                    return DIGG;
                                case 101:
                                    return COMMENT;
                                case 102:
                                    return COMMON_INFO;
                                default:
                                    switch (i) {
                                        case 104:
                                            return PRAISE_ACTIVITY;
                                        case 105:
                                            return PRAISE_NOTIFY;
                                        case 106:
                                            return PRAISE_USER_NOTIFY;
                                        case 107:
                                            return OUT_BOOK_TOPIC;
                                        case 108:
                                            return OUT_BOOK_TOPIC_COMMENT;
                                        case 109:
                                            return OUT_BOOK_TOPIC_INVITE;
                                        case 110:
                                            return OUT_BOOK_USER_TOPIC_INVITE;
                                        case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                                            return In_BOOK_USER_TOPIC_INVITE;
                                        case 112:
                                            return UGC_MENTION_USER;
                                        case 113:
                                            return POST_DIGG;
                                        case 114:
                                            return POST_COMMENT;
                                        case 115:
                                            return UGC_USER_ATTENTION;
                                        case 116:
                                            return UGC_COLLECT;
                                        case 117:
                                            return UGC_BOOK_LIST;
                                        case 118:
                                            return UGC_URGE;
                                        case 119:
                                            return UGC_UPDATE;
                                        case 120:
                                            return UGC_CREATION;
                                        case 121:
                                            return INVITE_ENTER_CONVERSATION;
                                        case 122:
                                            return UGC_INVITE_ANSWER;
                                        case 123:
                                            return UGC_INVITE_BOOK_COMMENT;
                                        case 124:
                                            return UGC_IMAGE_ACTIVITY;
                                        case 125:
                                            return UGC_TOPIC_ACTIVITY;
                                        case 126:
                                            return UGC_PRAISE_SHARE_THANK;
                                        case 127:
                                            return UGC_AUTHOR_POST_INTERACTION;
                                        case 128:
                                            return UGC_PRAISE_NOTIFY;
                                        case 129:
                                            return GET_MONEY_REWARD_MSG_CENTER_NOTIFY;
                                        case 130:
                                            return GET_MONEY_REWARD_IN_A_WEEK_MSG_CENTER_NOTIFY;
                                        case 131:
                                            return UGC_QUESTION_INVITE_USER;
                                        case 132:
                                            return UGC_QUESTION_INVITE_OFFICIAL;
                                        case 133:
                                            return AUTHOR_UGC_URGE;
                                        case 134:
                                            return DIGG_OR_COLLECT_ACHIEVEMENT;
                                        case 135:
                                            return DIGG_OR_COLLECT_ACHIEVEMENT_IN_MSG_CENTER;
                                        case 136:
                                            return INVITE_TOPIC_COMMENT;
                                        case 137:
                                            return UGC_TOPIC_COMMENT;
                                        case 138:
                                            return UGC_CREATOR_COMMENT;
                                        case 139:
                                            return UGC_CREATOR_DIGG;
                                        case 140:
                                            return UGC_CREATOR_SELECT;
                                        case 141:
                                            return ACTOR_PICK_COMMENT;
                                        case 142:
                                            return ACTOR_PICK_DIGG;
                                        case 143:
                                            return ACTOR_PICK_COLLECT;
                                        default:
                                            switch (i) {
                                                case 200:
                                                    return LIVE_PUSH;
                                                case 201:
                                                    return NOVELFM_VIP;
                                                case 202:
                                                    return NOVELFM_WELFARE;
                                                case 203:
                                                    return NOVELFM_SYSTEM;
                                                case 204:
                                                    return NOVELFM_ACTIVITY;
                                                case 205:
                                                    return NOVELFM_SHOPPING;
                                                case 206:
                                                    return NOVELFM_FOLLOW_UP_PUSH;
                                                case 207:
                                                    return NOVELFM_COMMON;
                                                case 208:
                                                    return NOVELFM_SUBSCRIBE;
                                                default:
                                                    switch (i) {
                                                        case 301:
                                                            return BOOK_UPDATE;
                                                        case 302:
                                                            return USER_PROFILE_REVIEW;
                                                        case 303:
                                                            return SYS_TOS_UPDATE;
                                                        case 304:
                                                            return SYS_PP_UPDATE;
                                                        case 305:
                                                            return INACTIVE_USER;
                                                        case 306:
                                                            return NOT_READ_PAY_WALL;
                                                        case 307:
                                                            return NEVER_PAID;
                                                        case 308:
                                                            return COMMENT_DIGG;
                                                        case 309:
                                                            return COMMENT_REPLY;
                                                        case 310:
                                                            return GOOD_BOOKS;
                                                        case TTVideoEngineInterface.PLAYER_OPTION_PREFER_NEARESTSAMPLE /* 311 */:
                                                            return CONTINUE_READ;
                                                        case 312:
                                                            return CHECK_IN_TASK;
                                                        default:
                                                            switch (i) {
                                                                case 401:
                                                                    return HG_INNER_PUSH_LIVEROOM;
                                                                case 402:
                                                                    return HG_INNER_PUSH_SETTLE;
                                                                case 403:
                                                                    return HG_INNER_PUSH_SERIES_ADDED;
                                                                case 404:
                                                                    return HG_INNER_PUSH_SERIES_CAN_SUBSCRIBE;
                                                                case 405:
                                                                    return HG_INNER_PUSH_VIDEO_PUBLISHED;
                                                                case 406:
                                                                    return HG_INNER_PUSH_CACHE_MSG;
                                                                case 407:
                                                                    return HG_INNER_PUSH_AI_VIDEO_MSG;
                                                                case 408:
                                                                    return HG_INNER_PUSH_SUBSCRIBE;
                                                                default:
                                                                    return null;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return QUESTION_MSG;
    }

    MessageType(int i) {
        this.value = i;
    }
}
