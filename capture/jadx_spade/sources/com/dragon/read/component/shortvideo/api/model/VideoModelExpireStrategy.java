package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoModelExpireStrategy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoModelExpireStrategy[] $VALUES;
    public static final VideoModelExpireStrategy COLD_START;
    public static final VideoModelExpireStrategy NONE;
    private final String strategy;

    private static final /* synthetic */ VideoModelExpireStrategy[] $values() {
        return new VideoModelExpireStrategy[]{COLD_START, NONE};
    }

    public static EnumEntries<VideoModelExpireStrategy> getEntries() {
        return $ENTRIES;
    }

    public final String getStrategy() {
        return this.strategy;
    }

    public static VideoModelExpireStrategy[] values() {
        return (VideoModelExpireStrategy[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598815);
        COLD_START = new VideoModelExpireStrategy("COLD_START", 0, "cold_start");
        NONE = new VideoModelExpireStrategy("NONE", 1, "");
        VideoModelExpireStrategy[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static VideoModelExpireStrategy valueOf(String str) {
        return (VideoModelExpireStrategy) Enum.valueOf(VideoModelExpireStrategy.class, str);
    }

    private VideoModelExpireStrategy(String str, int i, String str2) {
        this.strategy = str2;
    }
}
