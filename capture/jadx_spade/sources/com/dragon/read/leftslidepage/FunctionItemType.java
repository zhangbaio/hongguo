package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FunctionItemType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FunctionItemType[] $VALUES;
    public static final FunctionItemType FOLLOW_UPDATE;
    public static final FunctionItemType OFFLINE_CACHE;
    public static final FunctionItemType RESERVE;

    private static final /* synthetic */ FunctionItemType[] $values() {
        return new FunctionItemType[]{RESERVE, FOLLOW_UPDATE, OFFLINE_CACHE};
    }

    public static EnumEntries<FunctionItemType> getEntries() {
        return $ENTRIES;
    }

    public static FunctionItemType[] values() {
        return (FunctionItemType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(611241);
        RESERVE = new FunctionItemType("RESERVE", 0);
        FOLLOW_UPDATE = new FunctionItemType("FOLLOW_UPDATE", 1);
        OFFLINE_CACHE = new FunctionItemType("OFFLINE_CACHE", 2);
        FunctionItemType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static FunctionItemType valueOf(String str) {
        return (FunctionItemType) Enum.valueOf(FunctionItemType.class, str);
    }

    private FunctionItemType(String str, int i) {
    }
}
