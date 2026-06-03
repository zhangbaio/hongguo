package com.dragon.read.component.shortvideo.api.docker.viewmamanager;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HandlerStyleType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HandlerStyleType[] $VALUES;
    public static final HandlerStyleType Inner;
    public static final HandlerStyleType Others;
    public static final HandlerStyleType Outer;
    public static final HandlerStyleType Special;

    private static final /* synthetic */ HandlerStyleType[] $values() {
        return new HandlerStyleType[]{Inner, Outer, Special, Others};
    }

    public static EnumEntries<HandlerStyleType> getEntries() {
        return $ENTRIES;
    }

    public static HandlerStyleType[] values() {
        return (HandlerStyleType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598698);
        Inner = new HandlerStyleType("Inner", 0);
        Outer = new HandlerStyleType("Outer", 1);
        Special = new HandlerStyleType("Special", 2);
        Others = new HandlerStyleType("Others", 3);
        HandlerStyleType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static HandlerStyleType valueOf(String str) {
        return (HandlerStyleType) Enum.valueOf(HandlerStyleType.class, str);
    }

    private HandlerStyleType(String str, int i) {
    }
}
