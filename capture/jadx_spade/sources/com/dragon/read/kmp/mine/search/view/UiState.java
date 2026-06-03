package com.dragon.read.kmp.mine.search.view;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class UiState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UiState[] $VALUES;
    public static final UiState Empty;
    public static final UiState Error;
    public static final UiState Init;
    public static final UiState Loading;
    public static final UiState Success;

    private static final /* synthetic */ UiState[] $values() {
        return new UiState[]{Init, Loading, Success, Error, Empty};
    }

    public static EnumEntries<UiState> getEntries() {
        return $ENTRIES;
    }

    public static UiState[] values() {
        return (UiState[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(607780);
        Init = new UiState("Init", 0);
        Loading = new UiState("Loading", 1);
        Success = new UiState("Success", 2);
        Error = new UiState("Error", 3);
        Empty = new UiState("Empty", 4);
        UiState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static UiState valueOf(String str) {
        return (UiState) Enum.valueOf(UiState.class, str);
    }

    private UiState(String str, int i) {
    }
}
