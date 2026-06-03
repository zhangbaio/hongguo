package com.dragon.read.component.shortvideo.api.load;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortSeriesFailType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ShortSeriesFailType[] $VALUES;
    public static final ShortSeriesFailType NETWORK_ERROR;
    public static final ShortSeriesFailType SERIES_OFFLINE;

    private static final /* synthetic */ ShortSeriesFailType[] $values() {
        return new ShortSeriesFailType[]{NETWORK_ERROR, SERIES_OFFLINE};
    }

    public static EnumEntries<ShortSeriesFailType> getEntries() {
        return $ENTRIES;
    }

    public static ShortSeriesFailType[] values() {
        return (ShortSeriesFailType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598756);
        NETWORK_ERROR = new ShortSeriesFailType("NETWORK_ERROR", 0, 0);
        SERIES_OFFLINE = new ShortSeriesFailType("SERIES_OFFLINE", 1, 1);
        ShortSeriesFailType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ShortSeriesFailType valueOf(String str) {
        return (ShortSeriesFailType) Enum.valueOf(ShortSeriesFailType.class, str);
    }

    private ShortSeriesFailType(String str, int i, int i2) {
    }
}
