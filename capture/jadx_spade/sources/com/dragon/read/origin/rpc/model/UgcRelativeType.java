package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcRelativeType {
    Book(1),
    Category(2),
    Post(3),
    Comment(4),
    Forum(5),
    Topic(6),
    MixedForum(0),
    BookshelfBooklist(7),
    TtsNovel(8),
    Reply(9),
    VideoPost(10),
    BookstoreVideoPost(11),
    Forward(12),
    ReqBookTopic(13),
    Story(14),
    Item(15),
    Tag(16),
    AuthorSpeak(17),
    Bonus(18),
    MagicForum(19),
    OriginalClassroomNotice(20),
    Template(21),
    OriginalTopic(22),
    User(100),
    Author(101),
    Task(23),
    IMRobot(24),
    RobotScript(25),
    Vote(26),
    Report(27),
    UserRobotRelation(28),
    UserScriptRelation(29),
    SeriesVideo(30),
    AIGC(31),
    Rank(32),
    Message(33),
    UniversalCard(34),
    PUGC(35),
    AIGCImage(36),
    AIGCVideo(37),
    AdvertiseCreative(38),
    FamousScene(39),
    AIGCCharacter(40),
    AIGCImageV2(41),
    Series(42),
    UgcFeature(43),
    UserDislikeRule(44),
    TagAdmin(45);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613519);
    }

    public static UgcRelativeType findByValue(int i) {
        if (i != 100) {
            if (i != 101) {
                switch (i) {
                    case 0:
                        return MixedForum;
                    case 1:
                        return Book;
                    case 2:
                        return Category;
                    case 3:
                        return Post;
                    case 4:
                        return Comment;
                    case 5:
                        return Forum;
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        return Topic;
                    case 7:
                        return BookshelfBooklist;
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        return TtsNovel;
                    case 9:
                        return Reply;
                    case 10:
                        return VideoPost;
                    case 11:
                        return BookstoreVideoPost;
                    case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                        return Forward;
                    case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                        return ReqBookTopic;
                    case 14:
                        return Story;
                    case 15:
                        return Item;
                    case 16:
                        return Tag;
                    case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                        return AuthorSpeak;
                    case 18:
                        return Bonus;
                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                        return MagicForum;
                    case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                        return OriginalClassroomNotice;
                    case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                        return Template;
                    case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                        return OriginalTopic;
                    case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                        return Task;
                    case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                        return IMRobot;
                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                        return RobotScript;
                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                        return Vote;
                    case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                        return Report;
                    case 28:
                        return UserRobotRelation;
                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                        return UserScriptRelation;
                    case 30:
                        return SeriesVideo;
                    case 31:
                        return AIGC;
                    case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                        return Rank;
                    case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                        return Message;
                    case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                        return UniversalCard;
                    case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                        return PUGC;
                    case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                        return AIGCImage;
                    case ConstantsAPI.COMMAND_OPEN_CUSTOMER_SERVICE_CHAT /* 37 */:
                        return AIGCVideo;
                    case ConstantsAPI.COMMAND_OPEN_QRCODE_PAY /* 38 */:
                        return AdvertiseCreative;
                    case ConstantsAPI.COMMAND_FINDER_START_LIVE /* 39 */:
                        return FamousScene;
                    case 40:
                        return AIGCCharacter;
                    case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                        return AIGCImageV2;
                    case 42:
                        return Series;
                    case 43:
                        return UgcFeature;
                    case 44:
                        return UserDislikeRule;
                    case 45:
                        return TagAdmin;
                    default:
                        return null;
                }
            }
            return Author;
        }
        return User;
    }

    UgcRelativeType(int i) {
        this.value = i;
    }
}
