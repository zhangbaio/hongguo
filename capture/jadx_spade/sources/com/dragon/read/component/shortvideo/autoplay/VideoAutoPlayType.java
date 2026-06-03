package com.dragon.read.component.shortvideo.autoplay;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoAutoPlayType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoAutoPlayType[] $VALUES;
    public static final VideoAutoPlayType AUTO_PLAY;
    public static final VideoAutoPlayType LONG_PRESS_PLAY;
    private final String value;

    private static final /* synthetic */ VideoAutoPlayType[] $values() {
        return new VideoAutoPlayType[]{AUTO_PLAY, LONG_PRESS_PLAY};
    }

    public static EnumEntries<VideoAutoPlayType> getEntries() {
        return $ENTRIES;
    }

    public final String getValue() {
        return this.value;
    }

    public static VideoAutoPlayType[] values() {
        return (VideoAutoPlayType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598935);
        AUTO_PLAY = new VideoAutoPlayType("AUTO_PLAY", 0, "autoplay");
        LONG_PRESS_PLAY = new VideoAutoPlayType("LONG_PRESS_PLAY", 1, "long_press");
        VideoAutoPlayType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static VideoAutoPlayType valueOf(String str) {
        return (VideoAutoPlayType) Enum.valueOf(VideoAutoPlayType.class, str);
    }

    private VideoAutoPlayType(String str, int i, String str2) {
        this.value = str2;
    }
}
