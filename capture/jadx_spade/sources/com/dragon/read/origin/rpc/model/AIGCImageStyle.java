package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIGCImageStyle {
    CityModern(1),
    ChineseAnimeAncientChinese(2),
    ChinesePaintingWatercolorPainting(3),
    AnimeFantasyRealistic(4),
    JapaneseAnimeSemiThickPainting(5),
    ShojoManga(6),
    AIMatching(100);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612679);
    }

    public static AIGCImageStyle findByValue(int i) {
        if (i != 100) {
            switch (i) {
                case 1:
                    return CityModern;
                case 2:
                    return ChineseAnimeAncientChinese;
                case 3:
                    return ChinesePaintingWatercolorPainting;
                case 4:
                    return AnimeFantasyRealistic;
                case 5:
                    return JapaneseAnimeSemiThickPainting;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    return ShojoManga;
                default:
                    return null;
            }
        }
        return AIMatching;
    }

    AIGCImageStyle(int i) {
        this.value = i;
    }
}
