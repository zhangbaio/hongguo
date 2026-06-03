package com.dragon.read.component.shortvideo.api.docker;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FullScreenLockPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FullScreenLockPosition[] $VALUES;
    public static final FullScreenLockPosition LEFT;
    public static final FullScreenLockPosition RIGHT;

    private static final /* synthetic */ FullScreenLockPosition[] $values() {
        return new FullScreenLockPosition[]{LEFT, RIGHT};
    }

    public static EnumEntries<FullScreenLockPosition> getEntries() {
        return $ENTRIES;
    }

    public static FullScreenLockPosition[] values() {
        return (FullScreenLockPosition[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598625);
        LEFT = new FullScreenLockPosition("LEFT", 0);
        RIGHT = new FullScreenLockPosition("RIGHT", 1);
        FullScreenLockPosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static FullScreenLockPosition valueOf(String str) {
        return (FullScreenLockPosition) Enum.valueOf(FullScreenLockPosition.class, str);
    }

    private FullScreenLockPosition(String str, int i) {
    }
}
