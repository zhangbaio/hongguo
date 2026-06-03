package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoInsertPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoInsertPosition[] $VALUES;
    public static final VideoInsertPosition AT_START;
    public static final VideoInsertPosition FRONT_OF_PROGRESS_CACHE;

    private static final /* synthetic */ VideoInsertPosition[] $values() {
        return new VideoInsertPosition[]{AT_START, FRONT_OF_PROGRESS_CACHE};
    }

    public static EnumEntries<VideoInsertPosition> getEntries() {
        return $ENTRIES;
    }

    public static VideoInsertPosition[] values() {
        return (VideoInsertPosition[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598812);
        AT_START = new VideoInsertPosition("AT_START", 0);
        FRONT_OF_PROGRESS_CACHE = new VideoInsertPosition("FRONT_OF_PROGRESS_CACHE", 1);
        VideoInsertPosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static VideoInsertPosition valueOf(String str) {
        return (VideoInsertPosition) Enum.valueOf(VideoInsertPosition.class, str);
    }

    private VideoInsertPosition(String str, int i) {
    }
}
