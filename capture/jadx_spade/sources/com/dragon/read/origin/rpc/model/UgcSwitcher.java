package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcSwitcher {
    Reader(1),
    IdeaComment(2),
    GodIdeaExposed(3),
    ChapterEndForum(4),
    BotTTSAutoPlay(5),
    PlotBGMAutoPlay(6),
    Item(7),
    ItemPresetText(8),
    StoryIdeaComment(9);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613527);
    }

    public static UgcSwitcher findByValue(int i) {
        switch (i) {
            case 1:
                return Reader;
            case 2:
                return IdeaComment;
            case 3:
                return GodIdeaExposed;
            case 4:
                return ChapterEndForum;
            case 5:
                return BotTTSAutoPlay;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return PlotBGMAutoPlay;
            case 7:
                return Item;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return ItemPresetText;
            case 9:
                return StoryIdeaComment;
            default:
                return null;
        }
    }

    UgcSwitcher(int i) {
        this.value = i;
    }
}
