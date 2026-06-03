package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcCommentSourceEnum {
    None(0),
    NovelBookComment(1),
    NovelParaComment(2),
    NovelParaCommentExposed(3),
    NovelItemComment(4),
    NovelPostComment(5),
    NovelTopicComment(6),
    NovelBookReply(501),
    NovelParaReply(502),
    NovelBookLevel2Reply(503),
    NovelItemReply(504),
    NovelPostReply(505),
    NovelTopicCommentReply(506),
    NovelTopicCommentLevel2Reply(TTVideoEngineInterface.PLAYER_OPTION_ABR_4GMAX_RESOULUTION_MODE),
    NovelItemDanmaku(601),
    NovelBookCommentMessage(1001),
    NovelBookReplyMessage(1002),
    NovelParaCommentMessage(1003),
    NovelTopicMessage(1006),
    NovelTopicCommentMessage(1007),
    NovelPostMessage(1008),
    NovelPostCommentMessage(1009),
    NovelItemCommentMessage(1010),
    NovelItemReplyMessage(1011),
    NovelVideoSeriesPostMessage(1012),
    NovelVideoSeriesPostCommentMessage(1013),
    NovelUserReaderUgcConfig(1501),
    NovelUserIMConversation(1502),
    NovelItemSwitchConfig(1503),
    SeriesProfilePage(1504),
    OldNovelProfilePage(1505),
    VideoProfilePage(1506),
    FollowUserList(1507),
    FollowedUserList(1508),
    BlockUserList(1509),
    NovelItemDanmakuConf(1510),
    NovelAdvertiseCreativeItemComment(2000),
    NovelAdvertiseCreativeItemReply(2001);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613501);
    }

    public static UgcCommentSourceEnum findByValue(int i) {
        if (i != 601) {
            if (i != 2000) {
                if (i != 2001) {
                    switch (i) {
                        case 0:
                            return None;
                        case 1:
                            return NovelBookComment;
                        case 2:
                            return NovelParaComment;
                        case 3:
                            return NovelParaCommentExposed;
                        case 4:
                            return NovelItemComment;
                        case 5:
                            return NovelPostComment;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            return NovelTopicComment;
                        default:
                            switch (i) {
                                case 501:
                                    return NovelBookReply;
                                case 502:
                                    return NovelParaReply;
                                case 503:
                                    return NovelBookLevel2Reply;
                                case 504:
                                    return NovelItemReply;
                                case 505:
                                    return NovelPostReply;
                                case 506:
                                    return NovelTopicCommentReply;
                                case TTVideoEngineInterface.PLAYER_OPTION_ABR_4GMAX_RESOULUTION_MODE /* 507 */:
                                    return NovelTopicCommentLevel2Reply;
                                default:
                                    switch (i) {
                                        case 1001:
                                            return NovelBookCommentMessage;
                                        case 1002:
                                            return NovelBookReplyMessage;
                                        case 1003:
                                            return NovelParaCommentMessage;
                                        default:
                                            switch (i) {
                                                case 1006:
                                                    return NovelTopicMessage;
                                                case 1007:
                                                    return NovelTopicCommentMessage;
                                                case 1008:
                                                    return NovelPostMessage;
                                                case 1009:
                                                    return NovelPostCommentMessage;
                                                case 1010:
                                                    return NovelItemCommentMessage;
                                                case 1011:
                                                    return NovelItemReplyMessage;
                                                case 1012:
                                                    return NovelVideoSeriesPostMessage;
                                                case 1013:
                                                    return NovelVideoSeriesPostCommentMessage;
                                                default:
                                                    switch (i) {
                                                        case 1501:
                                                            return NovelUserReaderUgcConfig;
                                                        case 1502:
                                                            return NovelUserIMConversation;
                                                        case 1503:
                                                            return NovelItemSwitchConfig;
                                                        case 1504:
                                                            return SeriesProfilePage;
                                                        case 1505:
                                                            return OldNovelProfilePage;
                                                        case 1506:
                                                            return VideoProfilePage;
                                                        case 1507:
                                                            return FollowUserList;
                                                        case 1508:
                                                            return FollowedUserList;
                                                        case 1509:
                                                            return BlockUserList;
                                                        case 1510:
                                                            return NovelItemDanmakuConf;
                                                        default:
                                                            return null;
                                                    }
                                            }
                                    }
                            }
                    }
                }
                return NovelAdvertiseCreativeItemReply;
            }
            return NovelAdvertiseCreativeItemComment;
        }
        return NovelItemDanmaku;
    }

    UgcCommentSourceEnum(int i) {
        this.value = i;
    }
}
