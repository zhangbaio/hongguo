package com.dragon.read.kmp.reader.bookcover;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class InsertState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InsertState[] $VALUES;
    public static final InsertState INSERT;
    public static final InsertState LOADING;
    public static final InsertState NOT_INSERT;

    private static final /* synthetic */ InsertState[] $values() {
        return new InsertState[]{INSERT, LOADING, NOT_INSERT};
    }

    public static EnumEntries<InsertState> getEntries() {
        return $ENTRIES;
    }

    public static InsertState[] values() {
        return (InsertState[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608265);
        INSERT = new InsertState("INSERT", 0);
        LOADING = new InsertState("LOADING", 1);
        NOT_INSERT = new InsertState("NOT_INSERT", 2);
        InsertState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static InsertState valueOf(String str) {
        return (InsertState) Enum.valueOf(InsertState.class, str);
    }

    private InsertState(String str, int i) {
    }
}
