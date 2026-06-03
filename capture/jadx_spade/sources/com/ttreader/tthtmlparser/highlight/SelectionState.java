package com.ttreader.tthtmlparser.highlight;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class SelectionState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SelectionState[] $VALUES;
    public static final SelectionState DRAGGING;
    public static final SelectionState ENTER_MARKING;
    public static final SelectionState NORMAL;
    public static final SelectionState SELECTING;

    private static final /* synthetic */ SelectionState[] $values() {
        return new SelectionState[]{NORMAL, ENTER_MARKING, DRAGGING, SELECTING};
    }

    public static EnumEntries<SelectionState> getEntries() {
        return $ENTRIES;
    }

    public static SelectionState[] values() {
        return (SelectionState[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(654774);
        NORMAL = new SelectionState("NORMAL", 0);
        ENTER_MARKING = new SelectionState("ENTER_MARKING", 1);
        DRAGGING = new SelectionState("DRAGGING", 2);
        SELECTING = new SelectionState("SELECTING", 3);
        SelectionState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SelectionState valueOf(String str) {
        return (SelectionState) Enum.valueOf(SelectionState.class, str);
    }

    private SelectionState(String str, int i) {
    }
}
