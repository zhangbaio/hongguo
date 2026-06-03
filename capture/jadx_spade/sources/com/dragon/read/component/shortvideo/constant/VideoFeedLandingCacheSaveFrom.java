package com.dragon.read.component.shortvideo.constant;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoFeedLandingCacheSaveFrom {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoFeedLandingCacheSaveFrom[] $VALUES;
    public static final VideoFeedLandingCacheSaveFrom CACHE_VIDEO_CONSUMED;
    public static final VideoFeedLandingCacheSaveFrom COLD_START_DELAY;
    public static final VideoFeedLandingCacheSaveFrom ENTER_BACKGROUND;
    public static final VideoFeedLandingCacheSaveFrom FRAGMENT_INVISIBLE;
    public static final VideoFeedLandingCacheSaveFrom ON_MORE_DATA_LOAD;
    public static final VideoFeedLandingCacheSaveFrom VIDEO_RENDER_START;

    private static final /* synthetic */ VideoFeedLandingCacheSaveFrom[] $values() {
        return new VideoFeedLandingCacheSaveFrom[]{FRAGMENT_INVISIBLE, VIDEO_RENDER_START, ON_MORE_DATA_LOAD, ENTER_BACKGROUND, COLD_START_DELAY, CACHE_VIDEO_CONSUMED};
    }

    public static EnumEntries<VideoFeedLandingCacheSaveFrom> getEntries() {
        return $ENTRIES;
    }

    public static VideoFeedLandingCacheSaveFrom[] values() {
        return (VideoFeedLandingCacheSaveFrom[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(599012);
        FRAGMENT_INVISIBLE = new VideoFeedLandingCacheSaveFrom("FRAGMENT_INVISIBLE", 0);
        VIDEO_RENDER_START = new VideoFeedLandingCacheSaveFrom("VIDEO_RENDER_START", 1);
        ON_MORE_DATA_LOAD = new VideoFeedLandingCacheSaveFrom("ON_MORE_DATA_LOAD", 2);
        ENTER_BACKGROUND = new VideoFeedLandingCacheSaveFrom("ENTER_BACKGROUND", 3);
        COLD_START_DELAY = new VideoFeedLandingCacheSaveFrom("COLD_START_DELAY", 4);
        CACHE_VIDEO_CONSUMED = new VideoFeedLandingCacheSaveFrom("CACHE_VIDEO_CONSUMED", 5);
        VideoFeedLandingCacheSaveFrom[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static VideoFeedLandingCacheSaveFrom valueOf(String str) {
        return (VideoFeedLandingCacheSaveFrom) Enum.valueOf(VideoFeedLandingCacheSaveFrom.class, str);
    }

    private VideoFeedLandingCacheSaveFrom(String str, int i) {
    }
}
