package com.dragon.read.component.shortvideo.api.feed;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FeedColumnType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FeedColumnType[] $VALUES;
    public static final FeedColumnType ONE;
    public static final FeedColumnType THREE;
    public static final FeedColumnType TWO;

    private static final /* synthetic */ FeedColumnType[] $values() {
        return new FeedColumnType[]{ONE, TWO, THREE};
    }

    public static EnumEntries<FeedColumnType> getEntries() {
        return $ENTRIES;
    }

    public static FeedColumnType[] values() {
        return (FeedColumnType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598731);
        ONE = new FeedColumnType("ONE", 0);
        TWO = new FeedColumnType("TWO", 1);
        THREE = new FeedColumnType("THREE", 2);
        FeedColumnType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static FeedColumnType valueOf(String str) {
        return (FeedColumnType) Enum.valueOf(FeedColumnType.class, str);
    }

    private FeedColumnType(String str, int i) {
    }
}
