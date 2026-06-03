package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum VerifyFeatureType {
    LeaveTicket(1),
    DeleteBookComment(2),
    ChapterImgInsert(3),
    ChapterAIImgInsert(4),
    ExtraChapter(5),
    AICharacter(6),
    AITools(7),
    AIAssistTools(8),
    AICover(9),
    AuthorSpeakVote(10),
    AIDiagnose(11);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613566);
    }

    public static VerifyFeatureType findByValue(int i) {
        switch (i) {
            case 1:
                return LeaveTicket;
            case 2:
                return DeleteBookComment;
            case 3:
                return ChapterImgInsert;
            case 4:
                return ChapterAIImgInsert;
            case 5:
                return ExtraChapter;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return AICharacter;
            case 7:
                return AITools;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return AIAssistTools;
            case 9:
                return AICover;
            case 10:
                return AuthorSpeakVote;
            case 11:
                return AIDiagnose;
            default:
                return null;
        }
    }

    VerifyFeatureType(int i) {
        this.value = i;
    }
}
