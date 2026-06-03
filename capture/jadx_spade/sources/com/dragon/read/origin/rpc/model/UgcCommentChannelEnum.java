package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcCommentChannelEnum {
    None(0),
    NovelBookInnerList(1),
    NovelBookListBookEnd(2),
    NovelBookListChapterEnd(3),
    NovelBookExposedBookCover(4),
    NovelBookListBookCover(5),
    NovelBookExposedBookDetail(6),
    NovelBookListBookDetail(7),
    NovelBookExposedBookEnd(8),
    NovelBookListDefault(9),
    NovelBookListSearchLink(11),
    NovelBookListShare(12),
    NovelAudioBookList(13),
    NovelBookExposedChapterEnd(14),
    NovelBookMallBookCommentList(15),
    NovelUserIMPrivateChat(16),
    NovelItemCount(17),
    NovelItemList(18),
    NovelBookExposedCatalog(19),
    NovelBookListBookCatalog(20),
    NovelAudioBookListBookDetail(21),
    NovelPostCount(22),
    NovelPostList(23),
    NovelItemListRecLink(24),
    NovelPostListRecLink(25),
    NovelPUGCVideoCount(26),
    NovelPUGCVideoList(27),
    NovelBookEndFeedBookCommentList(28),
    NovelReplyDialogueLine(29),
    NovelStoryPostCommentList(30),
    NovelVideoSeriesPostCount(31),
    NovelVideoSeriesPostList(32),
    NovelPlayletCommentOutterList(33),
    NovelPlayletCommentInnerList(34),
    NovelForumPostCommentList(35),
    NovelTopicCommentInnerList(36),
    NovelVideoFeedItemCount(37),
    NovelBookEndUnlimitedInnerList(38),
    NovelShortStoryParaList(39),
    NovelSeriesCommentEndList(40),
    NovelSeriesSingleFeedOutterList(41),
    NovelStorePostCommentList(42),
    NovelParaUserCommentList(43),
    NovelMsgCenterCommentList(44),
    NovelReaderDialogBookCommentList(45),
    NovelCommentBoardPlayletComment(46),
    NovelCommentBoardPlayletCommentCount(47),
    NovelVideoSeriesEposideEnd(48),
    NovelAuthorSpeak(49),
    NovelInteractiveGameCommentList(50),
    NovelStoryBookCommentList(51),
    NovelItemDanmakuList(1000),
    NovelAdvertiseCreativeItemCount(2000),
    NovelAdvertiseCreativeItemList(2001),
    OutShareBackflowPage(3000),
    MyCommentPage(3001),
    DynamicTabGenre(3002),
    PlayletCommentOutSharePage(3003),
    PlayletKepPage(3004),
    SeriesSingleColPugc(3005),
    SeriesCommonPugc(3006),
    SeriesUserPublish(3007),
    SeriesSubscribe(3008);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613497);
    }

    public static UgcCommentChannelEnum findByValue(int i) {
        if (i != 1000) {
            if (i != 2000) {
                if (i != 2001) {
                    switch (i) {
                        case 0:
                            return None;
                        case 1:
                            return NovelBookInnerList;
                        case 2:
                            return NovelBookListBookEnd;
                        case 3:
                            return NovelBookListChapterEnd;
                        case 4:
                            return NovelBookExposedBookCover;
                        case 5:
                            return NovelBookListBookCover;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            return NovelBookExposedBookDetail;
                        case 7:
                            return NovelBookListBookDetail;
                        case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                            return NovelBookExposedBookEnd;
                        case 9:
                            return NovelBookListDefault;
                        default:
                            switch (i) {
                                case 11:
                                    return NovelBookListSearchLink;
                                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                                    return NovelBookListShare;
                                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                                    return NovelAudioBookList;
                                case 14:
                                    return NovelBookExposedChapterEnd;
                                case 15:
                                    return NovelBookMallBookCommentList;
                                case 16:
                                    return NovelUserIMPrivateChat;
                                case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                    return NovelItemCount;
                                case 18:
                                    return NovelItemList;
                                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                                    return NovelBookExposedCatalog;
                                case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                    return NovelBookListBookCatalog;
                                case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                    return NovelAudioBookListBookDetail;
                                case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                    return NovelPostCount;
                                case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                    return NovelPostList;
                                case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                    return NovelItemListRecLink;
                                case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                    return NovelPostListRecLink;
                                case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                    return NovelPUGCVideoCount;
                                case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                    return NovelPUGCVideoList;
                                case 28:
                                    return NovelBookEndFeedBookCommentList;
                                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                    return NovelReplyDialogueLine;
                                case 30:
                                    return NovelStoryPostCommentList;
                                case 31:
                                    return NovelVideoSeriesPostCount;
                                case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                                    return NovelVideoSeriesPostList;
                                case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                                    return NovelPlayletCommentOutterList;
                                case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                                    return NovelPlayletCommentInnerList;
                                case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                                    return NovelForumPostCommentList;
                                case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                                    return NovelTopicCommentInnerList;
                                case ConstantsAPI.COMMAND_OPEN_CUSTOMER_SERVICE_CHAT /* 37 */:
                                    return NovelVideoFeedItemCount;
                                case ConstantsAPI.COMMAND_OPEN_QRCODE_PAY /* 38 */:
                                    return NovelBookEndUnlimitedInnerList;
                                case ConstantsAPI.COMMAND_FINDER_START_LIVE /* 39 */:
                                    return NovelShortStoryParaList;
                                case 40:
                                    return NovelSeriesCommentEndList;
                                case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                                    return NovelSeriesSingleFeedOutterList;
                                case 42:
                                    return NovelStorePostCommentList;
                                case 43:
                                    return NovelParaUserCommentList;
                                case 44:
                                    return NovelMsgCenterCommentList;
                                case 45:
                                    return NovelReaderDialogBookCommentList;
                                case 46:
                                    return NovelCommentBoardPlayletComment;
                                case 47:
                                    return NovelCommentBoardPlayletCommentCount;
                                case 48:
                                    return NovelVideoSeriesEposideEnd;
                                case 49:
                                    return NovelAuthorSpeak;
                                case 50:
                                    return NovelInteractiveGameCommentList;
                                case IVideoEventLogger.LOGGER_OPTION_ENABLE_PLAYER_DEGRADE /* 51 */:
                                    return NovelStoryBookCommentList;
                                default:
                                    switch (i) {
                                        case 3000:
                                            return OutShareBackflowPage;
                                        case 3001:
                                            return MyCommentPage;
                                        case 3002:
                                            return DynamicTabGenre;
                                        case 3003:
                                            return PlayletCommentOutSharePage;
                                        case 3004:
                                            return PlayletKepPage;
                                        case 3005:
                                            return SeriesSingleColPugc;
                                        case 3006:
                                            return SeriesCommonPugc;
                                        case 3007:
                                            return SeriesUserPublish;
                                        case 3008:
                                            return SeriesSubscribe;
                                        default:
                                            return null;
                                    }
                            }
                    }
                }
                return NovelAdvertiseCreativeItemList;
            }
            return NovelAdvertiseCreativeItemCount;
        }
        return NovelItemDanmakuList;
    }

    UgcCommentChannelEnum(int i) {
        this.value = i;
    }
}
