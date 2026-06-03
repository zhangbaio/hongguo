package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIInsetStyle {
    ChinesePaintingWatercolorPainting(1),
    JapaneseAnimeRetroManga(2),
    JapaneseAnimeCelluloid(3),
    JapaneseAnimeSemiThickPainting(4),
    JapaneseAnimeAcrylicPainting(5),
    JapaneseAnimeWoodblockPrints(6),
    AnimeStudentSchool(7),
    AmericanComics2D(8),
    Pixar3D(9),
    CyberpunkStyle(10),
    Watercolor(11),
    BlindBoxToyStyle(12),
    ShojoManga(13),
    ChildrensIllustration(14),
    CityModern(15),
    GenrePainting(16),
    BestIllustrationAlbumCover1Girl(17),
    WastelandPunk(18),
    JapaneseAnimeChibi(19),
    AnimeFantasyRealistic(20),
    AmericanComicsAcrylicPainting(21),
    AmericanComicsRetroComics(22),
    ChineseAnimeAncientChinese(23),
    SpaceMachineArmour(24),
    FuturismArtMetropolitan(25),
    Steampunk(26),
    ChineseInkBrush(27),
    _3DCGAIInsetStyle(28);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612689);
    }

    public static AIInsetStyle findByValue(int i) {
        switch (i) {
            case 1:
                return ChinesePaintingWatercolorPainting;
            case 2:
                return JapaneseAnimeRetroManga;
            case 3:
                return JapaneseAnimeCelluloid;
            case 4:
                return JapaneseAnimeSemiThickPainting;
            case 5:
                return JapaneseAnimeAcrylicPainting;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return JapaneseAnimeWoodblockPrints;
            case 7:
                return AnimeStudentSchool;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return AmericanComics2D;
            case 9:
                return Pixar3D;
            case 10:
                return CyberpunkStyle;
            case 11:
                return Watercolor;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return BlindBoxToyStyle;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return ShojoManga;
            case 14:
                return ChildrensIllustration;
            case 15:
                return CityModern;
            case 16:
                return GenrePainting;
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return BestIllustrationAlbumCover1Girl;
            case 18:
                return WastelandPunk;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                return JapaneseAnimeChibi;
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                return AnimeFantasyRealistic;
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                return AmericanComicsAcrylicPainting;
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                return AmericanComicsRetroComics;
            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                return ChineseAnimeAncientChinese;
            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                return SpaceMachineArmour;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                return FuturismArtMetropolitan;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                return Steampunk;
            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                return ChineseInkBrush;
            case 28:
                return _3DCGAIInsetStyle;
            default:
                return null;
        }
    }

    AIInsetStyle(int i) {
        this.value = i;
    }
}
