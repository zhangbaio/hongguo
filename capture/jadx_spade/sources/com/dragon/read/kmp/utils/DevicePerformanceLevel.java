package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DevicePerformanceLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DevicePerformanceLevel[] $VALUES;
    public static final DevicePerformanceLevel HIGH_DEVICE;
    public static final DevicePerformanceLevel LOWER_DEVICE;
    public static final DevicePerformanceLevel MIDDLE_DEVICE;

    private static final /* synthetic */ DevicePerformanceLevel[] $values() {
        return new DevicePerformanceLevel[]{LOWER_DEVICE, MIDDLE_DEVICE, HIGH_DEVICE};
    }

    public static EnumEntries<DevicePerformanceLevel> getEntries() {
        return $ENTRIES;
    }

    public static DevicePerformanceLevel[] values() {
        return (DevicePerformanceLevel[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609536);
        LOWER_DEVICE = new DevicePerformanceLevel("LOWER_DEVICE", 0);
        MIDDLE_DEVICE = new DevicePerformanceLevel("MIDDLE_DEVICE", 1);
        HIGH_DEVICE = new DevicePerformanceLevel("HIGH_DEVICE", 2);
        DevicePerformanceLevel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DevicePerformanceLevel valueOf(String str) {
        return (DevicePerformanceLevel) Enum.valueOf(DevicePerformanceLevel.class, str);
    }

    private DevicePerformanceLevel(String str, int i) {
    }
}
