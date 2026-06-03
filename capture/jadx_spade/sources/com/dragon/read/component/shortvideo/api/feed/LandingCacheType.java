package com.dragon.read.component.shortvideo.api.feed;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class LandingCacheType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LandingCacheType[] $VALUES;
    public static final LandingCacheType AD;
    public static final LandingCacheType BookStore;
    public static final LandingCacheType None;
    public static final LandingCacheType Video;

    private static final /* synthetic */ LandingCacheType[] $values() {
        return new LandingCacheType[]{None, AD, Video, BookStore};
    }

    public static EnumEntries<LandingCacheType> getEntries() {
        return $ENTRIES;
    }

    public static LandingCacheType[] values() {
        return (LandingCacheType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598738);
        None = new LandingCacheType("None", 0);
        AD = new LandingCacheType("AD", 1);
        Video = new LandingCacheType("Video", 2);
        BookStore = new LandingCacheType("BookStore", 3);
        LandingCacheType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static LandingCacheType valueOf(String str) {
        return (LandingCacheType) Enum.valueOf(LandingCacheType.class, str);
    }

    private LandingCacheType(String str, int i) {
    }
}
