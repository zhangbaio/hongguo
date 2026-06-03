package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PostType {
    Talk(1),
    Creation(2),
    VideoRecommendBook(3),
    Forward(4),
    Story(5),
    Wiki(6),
    DouyinVideo(7),
    ChapterStory(8),
    UgcBooklist(9),
    FollowStory(10),
    AddBookshelfStory(11),
    DouyinLiveStory(12),
    MuyeShortStory(13),
    MuyeUgcContent(14),
    RecommendBookVideo(15),
    ForumVideo(16),
    StoryVideo(17),
    PictureVideo(18),
    XiguaVideo(20),
    DouyinSyncVideo(21),
    VideoSeries(22),
    AuthorSellProduct(23),
    TalkV2(24),
    TalkVideoV2(25),
    FmTopic(100),
    FizzoTopic(200),
    AuthorForum(201);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613311);
    }

    public static PostType findByValue(int i) {
        if (i != 100) {
            if (i != 200) {
                if (i != 201) {
                    switch (i) {
                        case 1:
                            return Talk;
                        case 2:
                            return Creation;
                        case 3:
                            return VideoRecommendBook;
                        case 4:
                            return Forward;
                        case 5:
                            return Story;
                        case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                            return Wiki;
                        case 7:
                            return DouyinVideo;
                        case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                            return ChapterStory;
                        case 9:
                            return UgcBooklist;
                        case 10:
                            return FollowStory;
                        case 11:
                            return AddBookshelfStory;
                        case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                            return DouyinLiveStory;
                        case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                            return MuyeShortStory;
                        case 14:
                            return MuyeUgcContent;
                        case 15:
                            return RecommendBookVideo;
                        case 16:
                            return ForumVideo;
                        case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                            return StoryVideo;
                        case 18:
                            return PictureVideo;
                        default:
                            switch (i) {
                                case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                                    return XiguaVideo;
                                case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                                    return DouyinSyncVideo;
                                case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                                    return VideoSeries;
                                case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                    return AuthorSellProduct;
                                case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                    return TalkV2;
                                case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                    return TalkVideoV2;
                                default:
                                    return null;
                            }
                    }
                }
                return AuthorForum;
            }
            return FizzoTopic;
        }
        return FmTopic;
    }

    PostType(int i) {
        this.value = i;
    }
}
