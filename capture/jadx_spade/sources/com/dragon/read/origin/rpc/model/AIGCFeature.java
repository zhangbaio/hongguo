package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AIGCFeature {
    RandomImagePrompt(1),
    Text2Image(2),
    Image2Video(3),
    Text2ImageTopicCover(4),
    Text2ImageStory(5),
    Image2Image(6),
    Image2MultiImage(7),
    Text2ImagePostCover(8);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612673);
    }

    public static AIGCFeature findByValue(int i) {
        switch (i) {
            case 1:
                return RandomImagePrompt;
            case 2:
                return Text2Image;
            case 3:
                return Image2Video;
            case 4:
                return Text2ImageTopicCover;
            case 5:
                return Text2ImageStory;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Image2Image;
            case 7:
                return Image2MultiImage;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return Text2ImagePostCover;
            default:
                return null;
        }
    }

    AIGCFeature(int i) {
        this.value = i;
    }
}
