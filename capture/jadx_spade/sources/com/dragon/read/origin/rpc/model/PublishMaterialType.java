package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PublishMaterialType {
    ActorVoiceover(1),
    HighlightClips(2),
    PlayletBts(3);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613337);
    }

    public static PublishMaterialType findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return PlayletBts;
            }
            return HighlightClips;
        }
        return ActorVoiceover;
    }

    PublishMaterialType(int i) {
        this.value = i;
    }
}
