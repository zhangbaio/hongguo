package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum NovelTopicType {
    Top(1),
    Announcement(2),
    Activity(3),
    Recruit(4),
    Official(5),
    List(6),
    Interview(7),
    Topic(8),
    UgcTopic(9),
    InBookTopic(10),
    Celebrity(11),
    Author(12),
    AuthorReward(13),
    AuthorSpeak(14),
    AuthorReferralTraffic(15),
    TagTopic(16),
    AuthorNewBookPreheat(17),
    ImageActivityBanner(18),
    StoryQuestion(19),
    ForumDiscussion(20),
    Fm(100),
    FizzoAuthorSpeak(201);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613261);
    }

    public static NovelTopicType findByValue(int i) {
        if (i != 100) {
            if (i != 201) {
                switch (i) {
                    case 1:
                        return Top;
                    case 2:
                        return Announcement;
                    case 3:
                        return Activity;
                    case 4:
                        return Recruit;
                    case 5:
                        return Official;
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        return List;
                    case 7:
                        return Interview;
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        return Topic;
                    case 9:
                        return UgcTopic;
                    case 10:
                        return InBookTopic;
                    case 11:
                        return Celebrity;
                    case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                        return Author;
                    case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                        return AuthorReward;
                    case 14:
                        return AuthorSpeak;
                    case 15:
                        return AuthorReferralTraffic;
                    case 16:
                        return TagTopic;
                    case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                        return AuthorNewBookPreheat;
                    case 18:
                        return ImageActivityBanner;
                    case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                        return StoryQuestion;
                    case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                        return ForumDiscussion;
                    default:
                        return null;
                }
            }
            return FizzoAuthorSpeak;
        }
        return Fm;
    }

    NovelTopicType(int i) {
        this.value = i;
    }
}
