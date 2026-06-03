package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcCommentGroupTypeOutter {
    Item(0),
    Paragraph(1),
    Book(2),
    FakeBook(3),
    NewItem(4),
    Topic(5),
    OpTopic(6),
    Moment(7),
    Message(8),
    Bullet(9),
    AuthorSpeak(10),
    Post(11),
    MuyeWeb(12),
    Additional(13),
    VideoPost(14),
    WikiSection(15),
    Forward(16),
    Story(17),
    AudioDanmaku(18),
    ChapterStory(19),
    Danmaku(20),
    AiSummary(166),
    AdvertiseCreativeItem(167);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613500);
    }

    public static UgcCommentGroupTypeOutter findByValue(int i) {
        if (i != 166) {
            if (i != 167) {
                switch (i) {
                    case 0:
                        return Item;
                    case 1:
                        return Paragraph;
                    case 2:
                        return Book;
                    case 3:
                        return FakeBook;
                    case 4:
                        return NewItem;
                    case 5:
                        return Topic;
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        return OpTopic;
                    case 7:
                        return Moment;
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        return Message;
                    case 9:
                        return Bullet;
                    case 10:
                        return AuthorSpeak;
                    case 11:
                        return Post;
                    case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                        return MuyeWeb;
                    case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                        return Additional;
                    case 14:
                        return VideoPost;
                    case 15:
                        return WikiSection;
                    case 16:
                        return Forward;
                    case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                        return Story;
                    case 18:
                        return AudioDanmaku;
                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                        return ChapterStory;
                    case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                        return Danmaku;
                    default:
                        return null;
                }
            }
            return AdvertiseCreativeItem;
        }
        return AiSummary;
    }

    UgcCommentGroupTypeOutter(int i) {
        this.value = i;
    }
}
