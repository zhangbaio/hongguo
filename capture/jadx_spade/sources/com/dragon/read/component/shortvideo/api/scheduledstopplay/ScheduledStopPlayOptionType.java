package com.dragon.read.component.shortvideo.api.scheduledstopplay;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ScheduledStopPlayOptionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScheduledStopPlayOptionType[] $VALUES;
    public static final ScheduledStopPlayOptionType CLOSED;
    public static final ScheduledStopPlayOptionType DIY_TIME;
    public static final ScheduledStopPlayOptionType FIXED_TIME;
    public static final ScheduledStopPlayOptionType PLAY_CURRENT_SERIES;
    public static final ScheduledStopPlayOptionType UNKNOW;
    private final int index;

    private static final /* synthetic */ ScheduledStopPlayOptionType[] $values() {
        return new ScheduledStopPlayOptionType[]{UNKNOW, CLOSED, PLAY_CURRENT_SERIES, FIXED_TIME, DIY_TIME};
    }

    public static EnumEntries<ScheduledStopPlayOptionType> getEntries() {
        return $ENTRIES;
    }

    public final int getIndex() {
        return this.index;
    }

    public static ScheduledStopPlayOptionType[] values() {
        return (ScheduledStopPlayOptionType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598853);
        UNKNOW = new ScheduledStopPlayOptionType("UNKNOW", 0, -1);
        CLOSED = new ScheduledStopPlayOptionType("CLOSED", 1, 0);
        PLAY_CURRENT_SERIES = new ScheduledStopPlayOptionType("PLAY_CURRENT_SERIES", 2, 1);
        FIXED_TIME = new ScheduledStopPlayOptionType("FIXED_TIME", 3, 2);
        DIY_TIME = new ScheduledStopPlayOptionType("DIY_TIME", 4, 3);
        ScheduledStopPlayOptionType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ScheduledStopPlayOptionType valueOf(String str) {
        return (ScheduledStopPlayOptionType) Enum.valueOf(ScheduledStopPlayOptionType.class, str);
    }

    private ScheduledStopPlayOptionType(String str, int i, int i2) {
        this.index = i2;
    }
}
