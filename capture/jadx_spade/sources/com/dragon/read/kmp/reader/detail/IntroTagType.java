package com.dragon.read.kmp.reader.detail;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class IntroTagType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ IntroTagType[] $VALUES;
    public static final IntroTagType CATEGORY;
    public static final IntroTagType HIGHLIGHT;
    public static final IntroTagType PUBLISH_CARD;
    public static final IntroTagType RANK;

    private static final /* synthetic */ IntroTagType[] $values() {
        return new IntroTagType[]{HIGHLIGHT, PUBLISH_CARD, RANK, CATEGORY};
    }

    public static EnumEntries<IntroTagType> getEntries() {
        return $ENTRIES;
    }

    public static IntroTagType[] values() {
        return (IntroTagType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608370);
        HIGHLIGHT = new IntroTagType("HIGHLIGHT", 0);
        PUBLISH_CARD = new IntroTagType("PUBLISH_CARD", 1);
        RANK = new IntroTagType("RANK", 2);
        CATEGORY = new IntroTagType("CATEGORY", 3);
        IntroTagType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static IntroTagType valueOf(String str) {
        return (IntroTagType) Enum.valueOf(IntroTagType.class, str);
    }

    private IntroTagType(String str, int i) {
    }
}
