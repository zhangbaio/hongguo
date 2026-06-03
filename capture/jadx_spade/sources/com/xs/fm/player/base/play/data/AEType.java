package com.xs.fm.player.base.play.data;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum AEType {
    UNDEFINED(-1),
    BASS(0),
    VOICE_ENHANCE(1),
    CLEAR_VOICE(2),
    SURROUND(3),
    LOUDER_150(4),
    LOUDER_300(5),
    _3D_SURROUND(6),
    _360_SURROUND(7),
    SUPER_REVERBERATION(8),
    HIGH_RESOLUTION_VOCAL(9),
    TREBLE_ENHANCE(10),
    CONCERT(11),
    LIVE_HOUSE(12),
    CONCERT_HALL(13),
    SHOCKING_PANORAMIC_SOUND(14);

    private final int value;

    public final int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(655815);
    }

    AEType(int i) {
        this.value = i;
    }
}
