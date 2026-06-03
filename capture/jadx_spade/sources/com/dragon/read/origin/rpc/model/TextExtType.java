package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum TextExtType {
    Txt(0),
    FowardedUser(1),
    MentionUser(2),
    Image(3),
    SearchLink(4),
    ActivityScore(5),
    HighLight(6),
    Book(7),
    Item(8),
    UgcTag(9),
    Hint(10),
    JumpLink(11),
    TagTopic(12),
    HotLineData(13),
    Comment(14),
    MentionRobot(15),
    RobotGreeting(16),
    Video(17),
    AIGCEditorOption(18),
    RankListTag(19),
    JumpSchema(20),
    Workplace(21),
    ProfessionalTitle(22);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613473);
    }

    public static TextExtType findByValue(int i) {
        switch (i) {
            case 0:
                return Txt;
            case 1:
                return FowardedUser;
            case 2:
                return MentionUser;
            case 3:
                return Image;
            case 4:
                return SearchLink;
            case 5:
                return ActivityScore;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return HighLight;
            case 7:
                return Book;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return Item;
            case 9:
                return UgcTag;
            case 10:
                return Hint;
            case 11:
                return JumpLink;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return TagTopic;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return HotLineData;
            case 14:
                return Comment;
            case 15:
                return MentionRobot;
            case 16:
                return RobotGreeting;
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return Video;
            case 18:
                return AIGCEditorOption;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                return RankListTag;
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                return JumpSchema;
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                return Workplace;
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                return ProfessionalTitle;
            default:
                return null;
        }
    }

    TextExtType(int i) {
        this.value = i;
    }
}
