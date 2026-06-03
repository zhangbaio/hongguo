package com.dragon.read.component.shortvideo.data.consts;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HolderType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HolderType[] $VALUES;
    public static final HolderType COMMON_VIDEO;
    public static final HolderType PUGC_SERIES;
    public static final HolderType PUGC_VIDEO;
    public static final HolderType SIMPLE_VIDEO;

    private static final /* synthetic */ HolderType[] $values() {
        return new HolderType[]{COMMON_VIDEO, PUGC_SERIES, PUGC_VIDEO, SIMPLE_VIDEO};
    }

    public static EnumEntries<HolderType> getEntries() {
        return $ENTRIES;
    }

    public static HolderType[] values() {
        return (HolderType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(599035);
        COMMON_VIDEO = new HolderType("COMMON_VIDEO", 0);
        PUGC_SERIES = new HolderType("PUGC_SERIES", 1);
        PUGC_VIDEO = new HolderType("PUGC_VIDEO", 2);
        SIMPLE_VIDEO = new HolderType("SIMPLE_VIDEO", 3);
        HolderType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static HolderType valueOf(String str) {
        return (HolderType) Enum.valueOf(HolderType.class, str);
    }

    private HolderType(String str, int i) {
    }
}
