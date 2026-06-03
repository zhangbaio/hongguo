package com.dragon.read.kmp.performance;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PerformancePeriod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PerformancePeriod[] $VALUES;
    public static final PerformancePeriod FIRST_FRAME;
    public static final PerformancePeriod LAUNCH_PERIOD;
    public static final PerformancePeriod NET_PERIOD;
    public static final PerformancePeriod PREPARE_PERIOD;
    private final String period;

    private static final /* synthetic */ PerformancePeriod[] $values() {
        return new PerformancePeriod[]{FIRST_FRAME, NET_PERIOD, PREPARE_PERIOD, LAUNCH_PERIOD};
    }

    public static EnumEntries<PerformancePeriod> getEntries() {
        return $ENTRIES;
    }

    public final String getPeriod() {
        return this.period;
    }

    public static PerformancePeriod[] values() {
        return (PerformancePeriod[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(607917);
        FIRST_FRAME = new PerformancePeriod("FIRST_FRAME", 0, "first_frame_duration");
        NET_PERIOD = new PerformancePeriod("NET_PERIOD", 1, "net_duration");
        PREPARE_PERIOD = new PerformancePeriod("PREPARE_PERIOD", 2, "prepare_duration");
        LAUNCH_PERIOD = new PerformancePeriod("LAUNCH_PERIOD", 3, "total_duration");
        PerformancePeriod[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PerformancePeriod valueOf(String str) {
        return (PerformancePeriod) Enum.valueOf(PerformancePeriod.class, str);
    }

    private PerformancePeriod(String str, int i, String str2) {
        this.period = str2;
    }
}
