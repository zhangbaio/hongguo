package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcCoverType {
    DefaultCover(0),
    AuthorUpload(1),
    ActUpload(2),
    ExternalPurchase(3),
    ServerGenerate(4),
    BookCoverCollection(5),
    HandWrittenBookTitles(6),
    MemoStytle(7),
    RealWorldScene(8),
    RealWorldSceneGrouping(9),
    MemoStytleWithBookname(10),
    AIGCCover(11),
    AIGCCoverWithTmpl(12),
    Carousel(13),
    StoryTopic(14),
    Grid(15),
    UnderlineRandomText(16),
    UnderlineTitle(17),
    TextGenImage(18),
    Dynamic(50);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613504);
    }

    public static UgcCoverType findByValue(int i) {
        if (i != 50) {
            switch (i) {
                case 0:
                    return DefaultCover;
                case 1:
                    return AuthorUpload;
                case 2:
                    return ActUpload;
                case 3:
                    return ExternalPurchase;
                case 4:
                    return ServerGenerate;
                case 5:
                    return BookCoverCollection;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    return HandWrittenBookTitles;
                case 7:
                    return MemoStytle;
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    return RealWorldScene;
                case 9:
                    return RealWorldSceneGrouping;
                case 10:
                    return MemoStytleWithBookname;
                case 11:
                    return AIGCCover;
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    return AIGCCoverWithTmpl;
                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                    return Carousel;
                case 14:
                    return StoryTopic;
                case 15:
                    return Grid;
                case 16:
                    return UnderlineRandomText;
                case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                    return UnderlineTitle;
                case 18:
                    return TextGenImage;
                default:
                    return null;
            }
        }
        return Dynamic;
    }

    UgcCoverType(int i) {
        this.value = i;
    }
}
