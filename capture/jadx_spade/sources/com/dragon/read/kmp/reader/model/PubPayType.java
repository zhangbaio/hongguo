package com.dragon.read.kmp.reader.model;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PubPayType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PubPayType[] $VALUES;
    public static final PubPayType PayForFree;
    public static final PubPayType VipForFree;
    private final int value;

    private static final /* synthetic */ PubPayType[] $values() {
        return new PubPayType[]{VipForFree, PayForFree};
    }

    public static EnumEntries<PubPayType> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static PubPayType[] values() {
        return (PubPayType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608467);
        VipForFree = new PubPayType("VipForFree", 0, 0);
        PayForFree = new PubPayType("PayForFree", 1, 1);
        PubPayType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PubPayType valueOf(String str) {
        return (PubPayType) Enum.valueOf(PubPayType.class, str);
    }

    private PubPayType(String str, int i, int i2) {
        this.value = i2;
    }
}
