package com.ttreader.tthtmlparser;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SelectionMoveResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SelectionMoveResult[] $VALUES;
    public static final SelectionMoveResult CONTINUE;
    public static final SelectionMoveResult INVALID;
    public static final SelectionMoveResult UPDATE;

    private static final /* synthetic */ SelectionMoveResult[] $values() {
        return new SelectionMoveResult[]{INVALID, UPDATE, CONTINUE};
    }

    public static EnumEntries<SelectionMoveResult> getEntries() {
        return $ENTRIES;
    }

    public static SelectionMoveResult[] values() {
        return (SelectionMoveResult[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(654725);
        INVALID = new SelectionMoveResult("INVALID", 0);
        UPDATE = new SelectionMoveResult("UPDATE", 1);
        CONTINUE = new SelectionMoveResult("CONTINUE", 2);
        SelectionMoveResult[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SelectionMoveResult valueOf(String str) {
        return (SelectionMoveResult) Enum.valueOf(SelectionMoveResult.class, str);
    }

    private SelectionMoveResult(String str, int i) {
    }
}
