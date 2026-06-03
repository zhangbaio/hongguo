package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcCommentGroupType {
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
    DyVideo(1968),
    DonateReply(1969),
    AudioBook(3041),
    AudioBookFake(3042),
    AudioPost(3043),
    AudioKaraoke(3044),
    AudioItem(3045),
    AudioNovelParaBook(3046),
    AudioNovelAdditionalBook(3047),
    AudioMusicCommentServiceID(3048),
    LiteAudioBook(8662),
    LiteAudioKaraoke(8663),
    LiteAudioBookFake(8664),
    LiteAudioItem(8665),
    LiteAudioNovelParaBook(8666),
    LiteAudioNovelAdditionalBook(8667),
    LiteAudioMusicCommentServiceID(8668),
    MeloloVideoItem(138),
    FizzoTopic(106),
    FizzoToonItem(110),
    FizzoToonFakeBook(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE),
    FizzoToonBook(112),
    FizzoPost(113),
    FizzoBookCircle(114),
    FizzoVideoItem(139),
    MyTopiaItem(107),
    MyTopiaFakeBook(108),
    MyTopiaBook(109),
    MyTopiaPara(126),
    MyTopiaVideoItem(140),
    AuthorClass(116),
    AuthorForum(117),
    HongGuoItem(141),
    ChangDuItem(142),
    DanHuaItem(144),
    HuoYaItem(170),
    XianNingItem(173),
    HongGuoPost(156),
    AiSummary(166),
    HongguoBook(168),
    FakeHongguoBook(169),
    HongguoAdvertiseCreativeComment(172),
    HongguoDanmaku(178),
    NovelDanmaku(181);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613499);
    }

    public static UgcCommentGroupType findByValue(int i) {
        if (i != 116) {
            if (i != 117) {
                if (i != 126) {
                    if (i != 144) {
                        if (i != 156) {
                            if (i != 166) {
                                if (i != 178) {
                                    if (i != 181) {
                                        if (i != 172) {
                                            if (i != 173) {
                                                if (i != 1968) {
                                                    if (i != 1969) {
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
                                                            default:
                                                                switch (i) {
                                                                    case 106:
                                                                        return FizzoTopic;
                                                                    case 107:
                                                                        return MyTopiaItem;
                                                                    case 108:
                                                                        return MyTopiaFakeBook;
                                                                    case 109:
                                                                        return MyTopiaBook;
                                                                    case 110:
                                                                        return FizzoToonItem;
                                                                    case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                                                                        return FizzoToonFakeBook;
                                                                    case 112:
                                                                        return FizzoToonBook;
                                                                    case 113:
                                                                        return FizzoPost;
                                                                    case 114:
                                                                        return FizzoBookCircle;
                                                                    default:
                                                                        switch (i) {
                                                                            case 138:
                                                                                return MeloloVideoItem;
                                                                            case 139:
                                                                                return FizzoVideoItem;
                                                                            case 140:
                                                                                return MyTopiaVideoItem;
                                                                            case 141:
                                                                                return HongGuoItem;
                                                                            case 142:
                                                                                return ChangDuItem;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 168:
                                                                                        return HongguoBook;
                                                                                    case 169:
                                                                                        return FakeHongguoBook;
                                                                                    case 170:
                                                                                        return HuoYaItem;
                                                                                    default:
                                                                                        switch (i) {
                                                                                            case 3041:
                                                                                                return AudioBook;
                                                                                            case 3042:
                                                                                                return AudioBookFake;
                                                                                            case 3043:
                                                                                                return AudioPost;
                                                                                            case 3044:
                                                                                                return AudioKaraoke;
                                                                                            case 3045:
                                                                                                return AudioItem;
                                                                                            case 3046:
                                                                                                return AudioNovelParaBook;
                                                                                            case 3047:
                                                                                                return AudioNovelAdditionalBook;
                                                                                            case 3048:
                                                                                                return AudioMusicCommentServiceID;
                                                                                            default:
                                                                                                switch (i) {
                                                                                                    case 8662:
                                                                                                        return LiteAudioBook;
                                                                                                    case 8663:
                                                                                                        return LiteAudioKaraoke;
                                                                                                    case 8664:
                                                                                                        return LiteAudioBookFake;
                                                                                                    case 8665:
                                                                                                        return LiteAudioItem;
                                                                                                    case 8666:
                                                                                                        return LiteAudioNovelParaBook;
                                                                                                    case 8667:
                                                                                                        return LiteAudioNovelAdditionalBook;
                                                                                                    case 8668:
                                                                                                        return LiteAudioMusicCommentServiceID;
                                                                                                    default:
                                                                                                        return null;
                                                                                                }
                                                                                        }
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                    }
                                                    return DonateReply;
                                                }
                                                return DyVideo;
                                            }
                                            return XianNingItem;
                                        }
                                        return HongguoAdvertiseCreativeComment;
                                    }
                                    return NovelDanmaku;
                                }
                                return HongguoDanmaku;
                            }
                            return AiSummary;
                        }
                        return HongGuoPost;
                    }
                    return DanHuaItem;
                }
                return MyTopiaPara;
            }
            return AuthorForum;
        }
        return AuthorClass;
    }

    UgcCommentGroupType(int i) {
        this.value = i;
    }
}
