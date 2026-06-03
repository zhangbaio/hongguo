package com.dragon.read.kmp.shortvideo.distribution.model;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FilterType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FilterType[] $VALUES;
    public static final FilterType BACKGROUND;
    public static final FilterType DEFAULT;
    public static final FilterType PANEL;

    private static final /* synthetic */ FilterType[] $values() {
        return new FilterType[]{DEFAULT, PANEL, BACKGROUND};
    }

    public static EnumEntries<FilterType> getEntries() {
        return $ENTRIES;
    }

    public static FilterType[] values() {
        return (FilterType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609037);
        DEFAULT = new FilterType("DEFAULT", 0);
        PANEL = new FilterType("PANEL", 1);
        BACKGROUND = new FilterType("BACKGROUND", 2);
        FilterType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static FilterType valueOf(String str) {
        return (FilterType) Enum.valueOf(FilterType.class, str);
    }

    private FilterType(String str, int i) {
    }
}
