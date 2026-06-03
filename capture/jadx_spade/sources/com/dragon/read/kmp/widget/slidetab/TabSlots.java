package com.dragon.read.kmp.widget.slidetab;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class TabSlots {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TabSlots[] $VALUES;
    public static final TabSlots Divider;
    public static final TabSlots Indicator;
    public static final TabSlots Tabs;

    private static final /* synthetic */ TabSlots[] $values() {
        return new TabSlots[]{Tabs, Divider, Indicator};
    }

    public static EnumEntries<TabSlots> getEntries() {
        return $ENTRIES;
    }

    public static TabSlots[] values() {
        return (TabSlots[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609693);
        Tabs = new TabSlots("Tabs", 0);
        Divider = new TabSlots("Divider", 1);
        Indicator = new TabSlots("Indicator", 2);
        TabSlots[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static TabSlots valueOf(String str) {
        return (TabSlots) Enum.valueOf(TabSlots.class, str);
    }

    private TabSlots(String str, int i) {
    }
}
