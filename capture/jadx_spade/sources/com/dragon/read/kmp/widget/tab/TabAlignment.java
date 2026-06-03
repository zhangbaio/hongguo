package com.dragon.read.kmp.widget.tab;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class TabAlignment {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TabAlignment[] $VALUES;
    public static final TabAlignment Distributed;
    public static final TabAlignment Start;

    private static final /* synthetic */ TabAlignment[] $values() {
        return new TabAlignment[]{Start, Distributed};
    }

    public static EnumEntries<TabAlignment> getEntries() {
        return $ENTRIES;
    }

    public static TabAlignment[] values() {
        return (TabAlignment[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609695);
        Start = new TabAlignment("Start", 0);
        Distributed = new TabAlignment("Distributed", 1);
        TabAlignment[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static TabAlignment valueOf(String str) {
        return (TabAlignment) Enum.valueOf(TabAlignment.class, str);
    }

    private TabAlignment(String str, int i) {
    }
}
