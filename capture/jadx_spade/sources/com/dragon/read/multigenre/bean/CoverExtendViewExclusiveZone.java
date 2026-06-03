package com.dragon.read.multigenre.bean;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CoverExtendViewExclusiveZone {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CoverExtendViewExclusiveZone[] $VALUES;
    public static final CoverExtendViewExclusiveZone BOTTOM;
    public static final CoverExtendViewExclusiveZone BOTTOM_LEFT;
    public static final CoverExtendViewExclusiveZone BOTTOM_RIGHT;
    public static final CoverExtendViewExclusiveZone NOT_SET;
    public static final CoverExtendViewExclusiveZone TOP;
    public static final CoverExtendViewExclusiveZone TOP_LEFT;
    public static final CoverExtendViewExclusiveZone TOP_RIGHT;

    private static final /* synthetic */ CoverExtendViewExclusiveZone[] $values() {
        return new CoverExtendViewExclusiveZone[]{TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, BOTTOM, TOP, TOP_LEFT, NOT_SET};
    }

    public static EnumEntries<CoverExtendViewExclusiveZone> getEntries() {
        return $ENTRIES;
    }

    public static CoverExtendViewExclusiveZone[] values() {
        return (CoverExtendViewExclusiveZone[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(612354);
        TOP_RIGHT = new CoverExtendViewExclusiveZone("TOP_RIGHT", 0);
        BOTTOM_LEFT = new CoverExtendViewExclusiveZone("BOTTOM_LEFT", 1);
        BOTTOM_RIGHT = new CoverExtendViewExclusiveZone("BOTTOM_RIGHT", 2);
        BOTTOM = new CoverExtendViewExclusiveZone("BOTTOM", 3);
        TOP = new CoverExtendViewExclusiveZone("TOP", 4);
        TOP_LEFT = new CoverExtendViewExclusiveZone("TOP_LEFT", 5);
        NOT_SET = new CoverExtendViewExclusiveZone("NOT_SET", 6);
        CoverExtendViewExclusiveZone[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static CoverExtendViewExclusiveZone valueOf(String str) {
        return (CoverExtendViewExclusiveZone) Enum.valueOf(CoverExtendViewExclusiveZone.class, str);
    }

    private CoverExtendViewExclusiveZone(String str, int i) {
    }
}
