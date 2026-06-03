package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ProfileTab {
    MySeries(1),
    AuthorSpeak(2),
    Savior(3),
    Talk(4),
    Video(5),
    Story(6),
    Select(7),
    CelebrityWorks(8),
    Digg(9),
    Bookshelf(10),
    ProduceVideo(11),
    PugcVideo(12),
    Album(13),
    DirectorWorks(14),
    WriterWorks(15),
    CelebrityWorksMix(16),
    CreationV2(17),
    Comment(18),
    TalkV2(19),
    SubscribeWorks(20),
    All(100),
    AuthorSpeak2(101),
    AuthorSpeak_ChapterUpdate(102),
    Savior_Topic(110),
    Savior_Post(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE),
    Savior_Booklist(112),
    Savior_Playlist(113),
    Talk_ParaComment(120),
    Talk_BookComment(121),
    Talk_Post(122),
    Talk_Topic(123),
    Talk_ItemComment(124),
    Talk_ActivityTopic(125),
    Talk_VideoComment(126),
    Talk_Forward(127),
    Talk_PugcStory(128),
    Story_Post(130),
    Story_Question(131);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613330);
    }

    public static ProfileTab findByValue(int i) {
        if (i != 130) {
            if (i != 131) {
                switch (i) {
                    case 1:
                        return MySeries;
                    case 2:
                        return AuthorSpeak;
                    case 3:
                        return Savior;
                    case 4:
                        return Talk;
                    case 5:
                        return Video;
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        return Story;
                    case 7:
                        return Select;
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        return CelebrityWorks;
                    case 9:
                        return Digg;
                    case 10:
                        return Bookshelf;
                    case 11:
                        return ProduceVideo;
                    case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                        return PugcVideo;
                    case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                        return Album;
                    case 14:
                        return DirectorWorks;
                    case 15:
                        return WriterWorks;
                    case 16:
                        return CelebrityWorksMix;
                    case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                        return CreationV2;
                    case 18:
                        return Comment;
                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                        return TalkV2;
                    case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                        return SubscribeWorks;
                    default:
                        switch (i) {
                            case 100:
                                return All;
                            case 101:
                                return AuthorSpeak2;
                            case 102:
                                return AuthorSpeak_ChapterUpdate;
                            default:
                                switch (i) {
                                    case 110:
                                        return Savior_Topic;
                                    case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                                        return Savior_Post;
                                    case 112:
                                        return Savior_Booklist;
                                    case 113:
                                        return Savior_Playlist;
                                    default:
                                        switch (i) {
                                            case 120:
                                                return Talk_ParaComment;
                                            case 121:
                                                return Talk_BookComment;
                                            case 122:
                                                return Talk_Post;
                                            case 123:
                                                return Talk_Topic;
                                            case 124:
                                                return Talk_ItemComment;
                                            case 125:
                                                return Talk_ActivityTopic;
                                            case 126:
                                                return Talk_VideoComment;
                                            case 127:
                                                return Talk_Forward;
                                            case 128:
                                                return Talk_PugcStory;
                                            default:
                                                return null;
                                        }
                                }
                        }
                }
            }
            return Story_Question;
        }
        return Story_Post;
    }

    ProfileTab(int i) {
        this.value = i;
    }
}
